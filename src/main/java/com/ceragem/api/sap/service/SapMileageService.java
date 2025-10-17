package com.ceragem.api.sap.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.sap.model.SapMaProcessResultVo;
import com.ceragem.crm.common.model.EzMap;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SapMileageService {

	// SAP시스템 API URL
	@Value("${sap.api.rest-url}")
	String restUrl;

	// 마일리지 통합 완료 처리 내역 수신
	private final static String MA_ALL_PROCESS = "/ZCRM_MA_001_SRV/ALLSet";

	// (SAP 공통) Restful API Call Service
	@Autowired
	SapRestApiCallService restApiCallService;

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;

	/**
	 * @author 이승빈
	 * @date 2022. 7. 12.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP 마일리지 통합 완료 처리 내역 수신
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapMaProcessResultVo sapMaProcess(EzMap param) throws Exception {

		// SAP PNT 포인트 VO
		SapMaProcessResultVo sapMaProcessResultVo = new SapMaProcessResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 포인트 적립/소멸 완료 처리 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + MA_ALL_PROCESS, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapMaProcessResultVo.setMsgty("E");
			sapMaProcessResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapMaProcessResultVo.setMsgid(code);
				sapMaProcessResultVo.setMsgtx(value);
			}

		} else {
			sapMaProcessResultVo = Utilities.beanToBean(d, SapMaProcessResultVo.class);

			sapMaProcessResultVo.setMsgty("S");
			sapMaProcessResultVo.setMsgno("200");
		}

		return sapMaProcessResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 12.
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
