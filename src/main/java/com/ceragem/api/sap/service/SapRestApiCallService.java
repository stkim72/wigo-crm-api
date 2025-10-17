package com.ceragem.api.sap.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @ClassName SapRestApiCallService
 * @author 김연지
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description (SAP 공통) Restful API Call Service
 */
@Slf4j
@Service
public class SapRestApiCallService {

	/**
	 * @author 김연지
	 * @date 2022. 6. 14.
	 * @param strUri   : (필수) API 호출 URL
	 * @param postData : (선택) Request Body 요청값
	 * @param method   : (필수) POST or GET
	 * @param token    : (선택) Authorization bearer 발급 토큰 (null 가능)
	 * @param header   : (선택) Request Header 요청값
	 * @return 요청응답 String
	 * @throws Exception
	 * @description HttpURLConnection - Restful API
	 *
	 */
	public String httpCallApi(String strUri, Map<String, Object> postData, String method, String token, EzMap header)
			throws Exception {

		BufferedReader in = null;
		String json = null;

		URL obj = new URL(strUri);

		try {
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			con.setRequestMethod(method);

			// Request Header 요청값
			if (Utilities.isNotEmpty(header)) {
				for (String key : header.keySet()) {
					con.setRequestProperty(key, header.getString(key));
				}
			}

			// Request 토큰값
			if (Utilities.isNotEmpty(token)) {
				con.setRequestProperty("Authorization", "bearer " + token);
			}

			// Request Body 요청값
			if (Utilities.isNotEmpty(postData)) {
				String jsonBody = Utilities.getJsonString(postData); // postData.toString();

				byte[] postDataBytes = jsonBody.getBytes("UTF-8");
				con.getOutputStream().write(postDataBytes);
			}

			String resCd = String.valueOf(con.getResponseCode());
			resCd = resCd.substring(0, 1);

			if ("2".equals(resCd)) {
				in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			} else {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
			}

			StringBuffer response = new StringBuffer();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// 요청응답데이터
			json = response.toString();

			return json;
		} catch (Exception e) {
			// TODO: handle exception
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception ex) {
				log.debug(ex.getMessage());
			}
		}
	}
}
