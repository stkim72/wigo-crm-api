package com.ceragem.api.as.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.as.model.AsmCrmCustReceiveVo;
import com.ceragem.api.as.model.AsmCrmCustResultVo;
import com.ceragem.api.as.service.AsmCrmService;
import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @ClassName AsmCrmController
 * @author 이윤성
 * @date 2022. 6. 7.
 * @Version 1.0
 * @description CRM고객정보조회 Controller
 */

@Tag(name = "CRM고객정보조회", description = "CRM고객정보조회 API")
@RestController
@RequestMapping("/as/v1.0/crm")
public class AsmCrmController extends BaseRestController {

	@Autowired
	AsmCrmService asmCrmService;

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 7.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description 고객정보수신 (API ID : INF_AS_A_001)
	 *
	 */
	@PostMapping("/cust/receive")
	@Operation(summary = "고객정보수신", description = "고객정보수신 API")
	public ResponseEntity<ApiResultVo<AsmCrmCustResultVo>> getCustReceive(
			@Parameter(description = "CRM고객정보 객체") @RequestBody @Valid AsmCrmCustReceiveVo paramVo) throws Exception {

		EzMap param = new EzMap(paramVo);
		param.put("regrId", "apiadmin");
		param.put("amdrId", "apiadmin");

		// CRM고객정보수신, AS시스템으로 전달
		AsmCrmCustResultVo asmCrmCustResultVo = asmCrmService.getCustReceive(param);

		if (Utilities.isEmpty(asmCrmCustResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmCrmCustResultVo);
	}

}
