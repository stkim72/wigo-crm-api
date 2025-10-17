package com.ceragem.api.crm.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzAjaxException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BosApiService {
	
	static public boolean useRental = true;
	
	@Value("${bos.api.rest-url}/crm/CRM_API_0001Ctl/getRandomKey.do")
	String randomKeyUrl;
	@Value("${bos.api.rest-url}/crm/CRM_API_0056Ctl/saveCrmCustInfo.do")
	String bosEventUrl;
	String enc = "UTF-8";

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;
	@Autowired
	RentalApiService retalApiService;
	static final String[] LARGE_CD_AREA = { "AM", "CM", "CR", "FI", "OG", "SD", "SV", "WM" };

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 24.
	 * @param uri
	 * @param param
	 * @return
	 * @throws Exception
	 * @description api text 가져오기
	 *
	 */
	private String getStr(String uri, BosApiParamVo param) throws Exception {
//		serverUrl.append( uri );
		String method = "POST";
		String enc = "UTF-8";
		BufferedReader br = null;
		OutputStreamWriter osw = null;
		String body = Utilities.getJsonString(param);
		BosCmCondVo cmCond = param.getCmCond();
		try {

			URL url = new URL(uri);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn == null)
				return null;
			conn.setDoOutput(true);
			conn.setConnectTimeout(2000);
			conn.setReadTimeout(60000);
			conn.setUseCaches(false);
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type", "application/json;charset=" + enc);
			if (Utilities.isNotEmpty(cmCond.getRandomKey()))
				conn.setRequestProperty("randomKey", cmCond.getRandomKey());
			conn.setRequestProperty("crmUsrId", cmCond.getCrmUsrId());
			conn.setRequestProperty("crmYn", cmCond.getCrmYn());
			conn.setRequestProperty("crmJobSe", cmCond.getCrmJobSe());
			conn.setRequestProperty("usrLocale", cmCond.getUsrLocale());

			if (Utilities.isNotEmpty(body)) {
				osw = new OutputStreamWriter(conn.getOutputStream(), enc);
				osw.write(body);
				osw.flush();
			}

			int responseCode = conn.getResponseCode();
			if (responseCode != HttpURLConnection.HTTP_OK)
				return null;

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), enc));

			char[] buffer = new char[1024];
			StringBuffer sb = new StringBuffer();
			do {
				int nRead = br.read(buffer);
				if (nRead <= 0)
					break;

				sb.append(buffer, 0, nRead);
			} while (true);
			return sb.toString();
		} catch (Exception ex) {

			return null;
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception ex) {
				log.debug(ex.getMessage());
			}
			try {
				if (osw != null)
					osw.close();
			} catch (Exception ex) {
				log.debug(ex.getMessage());
			}

		}
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 24.
	 * @param uri
	 * @param param
	 * @return bos api map으로 가져오기
	 * @throws Exception
	 * @description
	 *
	 */
	public Map<String, Object> getResultMap(String uri, BosApiParamVo param) throws Exception {
		String result = getStr(uri, param);
		if (Utilities.isEmpty(result))
			return null;
		return Utilities.getJson(result);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 24.
	 * @param <T>
	 * @param uri
	 * @param param
	 * @param clz   클래스유형
	 * @return 결과 객체
	 * @throws Exception
	 * @description api결과 vo로 가져오기
	 *
	 */
	public <T> T getResultVo(String uri, BosApiParamVo param, Class<T> clz) throws Exception {
		Map<String, Object> result = getResultMap(uri, param);
		if (Utilities.isEmpty(result))
			return null;
		return objectMapper.convertValue(result.get("dtlCond"), clz);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 24.
	 * @param uri
	 * @param param
	 * @return
	 * @throws Exception
	 * @description list<Map> 결과 가져오기
	 *
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getResultList(String uri, BosApiParamVo param) throws Exception {
		return getResultList(uri, param, Map.class);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 24.
	 * @param <T>
	 * @param uri
	 * @param param
	 * @param clz
	 * @return
	 * @throws Exception
	 * @description 결과 가져오기
	 *
	 */
	public <T> List<T> getResultList(String uri, BosApiParamVo param, Class<T> clz) throws Exception {
		Map<String, Object> result = getResultMap(uri, param);
		if (Utilities.isEmpty(result))
			return null;

		return objectMapper.convertValue(result.get("list"),
				TypeFactory.defaultInstance().constructCollectionType(List.class, clz));
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 24.
	 * @return
	 * @throws Exception
	 * @description 암호화키 가져오기
	 *
	 */
	public String getRandomKey() throws Exception {

		Map<String, Object> result = getResultMap(randomKeyUrl, new BosApiParamVo(null));
		if (result == null)
			throw new EzAjaxException("랜덤키를 획득하지 못했습니다.");
		return (String) result.get("randomKey");

	}

	public boolean sendCustEvent(String itgCustNo) throws Exception {
		if(useRental)
			return retalApiService.sendCustEvent(itgCustNo);
		BosApiParamVo param = new BosApiParamVo(getRandomKey());
		param.setParam("crmCustNo", itgCustNo);
		Map<String, Object> result = getResultMap(bosEventUrl, param);
		if (Utilities.isEmpty(result))
			return false;
		return true;
//		BosEmpVo vo = getResultVo(empDtlUrl, param, BosEmpVo.class);
//		return vo;
	}
}
