package com.ceragem.api.as.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.model.AsmCrmCustResultVo;
import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @ClassName AsmCrmService
 * @author 이윤성
 * @date 2022. 6. 7.
 * @Version 1.0
 * @description CRM고객정보 Service
 */
@Slf4j
@Service
public class AsmCrmService {

	// AS시스템 API URL
	@Value("${as.api.rest-url}")
	String restUrl;

	// AS시스템, 고객정보 저장 API URL
	String saveCustInfo = "/asReceipt/saveCustInfo";

	// (ASM 공통) Restful API Call Service
	@Autowired
	AsmRestApiCallService restApiCallService;

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;

	/**
	 * @author 이윤성
	 * @date 2022. 6. 7.
	 * @param 고객정보 수신 EzMap
	 * @return
	 * @throws Exception
	 * @description [CRM-ASM] 고객정보수신 API
	 *
	 */
	public AsmCrmCustResultVo getCustReceive(EzMap param) throws Exception {

		// 고객정보 저장결과 VO
		AsmCrmCustResultVo asmCrmCustResultVo = new AsmCrmCustResultVo();
		// 2022-09-14 (요청) 날짜를 현재 시간으로 변경
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String cnslgYmdhms = formatter.format(new Date());
		param.setString("cnslgYmdhms", cnslgYmdhms);
		EzMap header = new EzMap();
		// AS시스템 고객정보 저장요청
		String resJsonData = restApiCallService.httpCallApi(restUrl + saveCustInfo, param, "GET",
				null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);

		String resCd = (String) map.get("resCd"); // 성공:200, 실패:999
		String resMsg = (String) map.get("resMsg"); // 성공:success, 실패 : fail

		if ("200".equals(resCd)) {

			int asSubmitNo = (int) map.get("asSubmitNo"); // AS접수번호
			log.debug("asSubmitNo ======>" + asSubmitNo);

			if (asSubmitNo <= 0) {
				// 접수번호가 0으로 내려오는 경우, 에러처리
				throw new EzApiException(Constants._API_CODE_NO_DATA, "AS접수번호 생성 실패");
			}

			// AS접수 바로가기 링크
			String directUrl = restUrl + String.format("/asReceipt?asSubmitNo=%s&_mode=redi&lnk=",
					String.valueOf(asSubmitNo));
			log.debug("directUrl1 ======>" + directUrl);

			map.put("directUrl", directUrl);

			asmCrmCustResultVo = Utilities.beanToBean(map, AsmCrmCustResultVo.class);

		} else {
			// AS시스템 고객정보저장 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("[%s]%s", resCd, resMsg));
		}

		return asmCrmCustResultVo;
	}
}
