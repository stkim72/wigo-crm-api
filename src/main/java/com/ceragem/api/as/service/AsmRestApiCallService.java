package com.ceragem.api.as.service;

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
 * @ClassName AsmRestApiCallService
 * @author 이윤성
 * @date 2022. 6. 03.
 * @Version 1.0
 * @description (ASM 공통) Restful API Call Service - BOS, SAP, AS관리시스템 연계등
 */
@Slf4j
@Service
public class AsmRestApiCallService {

	/**
	 * @author 이윤성
	 * @date 2022. 5. 31.
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
	public String httpCallApi(String strUri, Map<String, Object> postData, String method,
			String token, EzMap header) throws Exception {

		BufferedReader in = null;
		URL obj = new URL(strUri);

		try {

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestMethod(method);

			// Request Header 요청값
			if (Utilities.isNotEmpty(header)) {
				for (String key : header.keySet()) {
					con.setRequestProperty(key, header.getString(key));
					log.debug(
							"header ======>" + String.format("%s:%s", key, header.getString(key)));
				}
			}

			// Request 토큰값
			if (Utilities.isNotEmpty(token)) {
				con.setRequestProperty("Authorization", "bearer " + token);
				log.debug("token ======>" + token);
			}

			// Request Body 요청값
			if (Utilities.isNotEmpty(postData)) {
				String jsonBody = Utilities.getJsonString(postData); // postData.toString();
				log.debug("jsonBody ======>" + jsonBody);

				byte[] postDataBytes = jsonBody.getBytes("UTF-8");
				con.getOutputStream().write(postDataBytes);
			}

			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			StringBuffer response = new StringBuffer();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// 요청응답데이터
			String json = response.toString();

			log.debug("요청응답데이터 ======>" + json);

			return json;

		} catch (Exception e) {
			// TODO: handle exception
			log.debug("Exception ======>" + e.toString());
			throw new EzApiException(Constants._API_CODE_NOT_FOUND, e.getMessage());
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

	public String httpCallApi(String strUri, EzMap postData, String method, EzMap header,
			String basicAuthStr) throws Exception {
		log.debug("AuthTest");
		BufferedReader in = null;
		URL obj = new URL(strUri);

		try {

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestMethod(method);

			// Request Header 요청값
			if (Utilities.isNotEmpty(header)) {
				for (String key : header.keySet()) {
					con.setRequestProperty(key, header.getString(key));
					log.debug(
							"header ======>" + String.format("%s:%s", key, header.getString(key)));
				}
			}

			if (Utilities.isNotEmpty(basicAuthStr)) {
				con.addRequestProperty("Authorization", basicAuthStr);
				log.debug("token ======>" + basicAuthStr);
			}

			// Request Body 요청값
			if (Utilities.isNotEmpty(postData)) {
				String jsonBody = Utilities.getJsonString(postData); // postData.toString();
				log.debug("jsonBody ======>" + jsonBody);

				byte[] postDataBytes = jsonBody.getBytes("UTF-8");
				con.getOutputStream().write(postDataBytes);
			}

			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			StringBuffer response = new StringBuffer();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// 요청응답데이터
			String json = response.toString();

			log.debug("요청응답데이터 ======>" + json);

			return json;

		} catch (Exception e) {
			// TODO: handle exception
			log.debug("Exception ======>" + e.toString());
			throw new EzApiException(Constants._API_CODE_NOT_FOUND, e.getMessage());
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
