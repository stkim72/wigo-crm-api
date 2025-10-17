package com.ceragem.api.crm.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.util.Utilities;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName RentalApiService
 * @author 강구진
 * @date 2024. 10. 11.
 * @Version 1.0
 * @description 신규 Bos 연계 API
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Service
public class RentalApiService {

	@Value("${bos.api.rental-url}")
	String rentalUrl;

	@Value("${bos.api.rental-id}")
	String rentalId;

	@Value("${bos.api.rental-pwd}")
	String rentalPwd;

	String enc = "UTF-8";

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;

	static final String[] LARGE_CD_AREA = { "AM", "CM", "CR", "FI", "OG", "SD", "SV", "WM" };

	@Getter
	@Setter
	public class RentalApiParamVo {
		private Map<String, Object> cond = new HashMap<String, Object>();

		public void setParam(String name, Object value) {
			cond.put(name, value);
		}

	}

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
	private String getStr(String ifid, RentalApiParamVo param) throws Exception {
		String method = "POST";
		String enc = "UTF-8";
		BufferedReader br = null;
		OutputStreamWriter osw = null;
		String body = Utilities.getJsonString(param);
		String baseAuth = Utilities.encodeBase64(rentalId + ":" + rentalPwd);
		try {

			URL url = new URL(rentalUrl);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn == null)
				return null;
			conn.setDoOutput(true);
			conn.setConnectTimeout(2000);
			conn.setReadTimeout(60000);
			conn.setUseCaches(false);
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type", "application/json;charset=" + enc);
			conn.setRequestProperty("ifid", ifid);
			conn.setRequestProperty("Authorization", "Basic " + baseAuth);

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
	public Map<String, Object> getResultMap(String ifid, RentalApiParamVo param) throws Exception {
		String result = getStr(ifid, param);
		if (Utilities.isEmpty(result))
			return null;
		return Utilities.getJson(result);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 10. 5.
	 * @param itgCustNo
	 * @return CSS 고객 이벤트 전송
	 * @throws Exception
	 * @description
	 *
	 */
	public boolean sendCustEvent(String itgCustNo) throws Exception {
		final String ifid = "IF-1-005";
		RentalApiParamVo param = new RentalApiParamVo();
		param.setParam("crmCustNo", itgCustNo);
		Map<String, Object> result = getResultMap(ifid, param);
		if (Utilities.isEmpty(result))
			return false;
		return true;
	}
}
