package com.ceragem.api.sap.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.sap.model.SapPntPreserveResultVo;
import com.ceragem.api.sap.model.SapPntProcessResultVo;
import com.ceragem.api.sap.model.SapPntUserSetItemResultVo;
import com.ceragem.crm.common.model.EzMap;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @ClassName SapPntService
 * @author 이승빈
 * @date 2022. 6. 22.
 * @Version 1.0
 * @description SAP PNT Service
 */

@Service
public class SapPntService {

	// SAP시스템 API URL
	@Value("${sap.api.rest-url}")
	String restUrl;

	// PNT 포인트적립/소멸 완료 수신 처리
	private final static String PNT_PROCESS_RES = "/ZCRM_PNT_001_SRV/SADESet";

	// PNT 포인트 사용 완료 수신 처리
	private final static String PNT_USER_SET_RES = "/ZCRM_PNT_001_SRV/USESet";

	// SAP PNT 가맹점 포인트 보전 완료 수신 처리
	private final static String PNT_PRESERVE_SET_RES = "/ZCRM_PNT_001_SRV/PRSet";

	// (SAP 공통) Restful API Call Service
	@Autowired
	SapRestApiCallService restApiCallService;

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;

	/**
	 * @author 이승빈
	 * @date 2022. 6. 22.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP PNT 포인트 적립/소멸 완료 처리
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPntProcessResultVo sapPntProcess(EzMap param) throws Exception {

		// SAP PNT 포인트 VO
		SapPntProcessResultVo sapPntProcessResultVo = new SapPntProcessResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 포인트 적립/소멸 완료 처리 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + PNT_PROCESS_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPntProcessResultVo.setMsgty("E");
			sapPntProcessResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPntProcessResultVo.setMsgid(code);
				sapPntProcessResultVo.setMsgtx(value);
			}

		} else {
			sapPntProcessResultVo = Utilities.beanToBean(d, SapPntProcessResultVo.class);

			sapPntProcessResultVo.setMsgty("S");
			sapPntProcessResultVo.setMsgno("200");
		}

		return sapPntProcessResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 6. 23.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP PNT 포인트 사용 완료 처리
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPntUserSetItemResultVo sapPntUserSet(EzMap param) throws Exception {

		// SAP PNT 포인트 사용완료 처리 결과 VO
		SapPntUserSetItemResultVo sapPntUserSetItemResultVo = new SapPntUserSetItemResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 포인트 사용 완료처리 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + PNT_USER_SET_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPntUserSetItemResultVo.setMsgty("E");
			sapPntUserSetItemResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPntUserSetItemResultVo.setMsgid(code);
				sapPntUserSetItemResultVo.setMsgtx(value);
			}

		} else {
			sapPntUserSetItemResultVo = Utilities.beanToBean(d, SapPntUserSetItemResultVo.class);

			sapPntUserSetItemResultVo.setMsgty("S");
			sapPntUserSetItemResultVo.setMsgno("200");
		}

		return sapPntUserSetItemResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 6. 23.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP PNT 가맹점 포인트 보전 완료 처리
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPntPreserveResultVo sapPntPreserveSet(EzMap param) throws Exception {

		// SAP PNT 가맹점 포인트 보전 처리 결과 VO
		SapPntPreserveResultVo sapPntPreserveResultVo = new SapPntPreserveResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 가맹점 포인트 보전 완료 처리 내역 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + PNT_PRESERVE_SET_RES, param, "POST", null,
				header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPntPreserveResultVo.setMsgty("E");
			sapPntPreserveResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPntPreserveResultVo.setMsgid(code);
				sapPntPreserveResultVo.setMsgtx(value);
			}

		} else {
			sapPntPreserveResultVo = Utilities.beanToBean(d, SapPntPreserveResultVo.class);

			sapPntPreserveResultVo.setMsgty("S");
			sapPntPreserveResultVo.setMsgno("200");
		}

		return sapPntPreserveResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 6. 22.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 헤더세팅
	 *
	 */
	public static EzMap reqHeaderParam(String method) throws Exception {
		EzMap header = new EzMap();

		header.put("Content-Type", "application/json");
		header.put("Accept", "application/json");

		if (!method.equals("GET")) {
			header.put("X-Requested-With", "X");
		}

		header.put("SYSID", "002");
		header.put("AUTHID", "crmAPI@2022");

		return header;
	}

}