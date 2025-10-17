package com.ceragem.api.as.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.as.model.AsmSapPrecChitTrmVo;
import com.ceragem.api.as.model.AsmSapProdReqTrmVo;
import com.ceragem.api.as.model.AsmSapResultVo;
import com.ceragem.api.as.model.AsmSapRfndTrtTrmVo;
import com.ceragem.api.as.service.AsmSapService;
import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzApiException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @ClassName AsmSapController
 * @author 이윤성
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP CRM Controller
 */
@Tag(name = "SAP AS", description = "SAP AS표준 API")
@RestController
@RequestMapping("/as/v1.0/sap")
public class AsmSapController extends BaseRestController {

	@Autowired
	AsmSapService asmSapService;

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 24.
	 * @param
	 * @return
	 * @throws Exception
	 * @description [AS_103] 수금반제-입금정보/선수금전표 수신 API (SAP에서, 1시간 단위로 배치 전송)
	 *
	 */
	@PostMapping("/prec-chit-trm")
	@Operation(summary = "입금정보/선수금전표 수신", description = "SAP에서 생성된 선수금전표 번호 수신 배치")
	public ResponseEntity<ApiResultVo<AsmSapResultVo>> precChitRrm(
			@Parameter(description = "입금정보/선수금전표수신 객체") @RequestBody @Valid AsmSapPrecChitTrmVo param)
			throws Exception {

		// 입금정보/선수금전표 수신
		AsmSapResultVo amSapResultVo = asmSapService.precChitRrm(param);

		if (Utilities.isEmpty(amSapResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(amSapResultVo);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description [AS_112] 수금반제-유상매출 반제처리 결과 수신 API (SAP매출반제 처리프로그램에서 반제처리시
	 *              AS시스템으로 처리결과전송)
	 *
	 */
	@PostMapping("/rfnd-trt-trm")
	@Operation(summary = "유상매출 반제처리 결과 수신", description = "수금반제-유상매출 반제처리 결과 수신 배치")
	public ResponseEntity<ApiResultVo<AsmSapResultVo>> rfndTrtTrm(
			@Parameter(description = "유상매출 반제처리 결과 수신 객체") @RequestBody @Valid AsmSapRfndTrtTrmVo param)
			throws Exception {

		// 유상매출 반제처리 결과 수신
		AsmSapResultVo amSapResultVo = asmSapService.rfndTrtTrm(param);

		if (Utilities.isEmpty(amSapResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(amSapResultVo);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description [AS_108] 자재요청-구매입고 결과 수신 API (SAP에서, 1시간 단위로 배치 전송), 매시간 SAP에서
	 *              자동 PO입고 후 처리결과를 AS시스템으로 전송, 또는 본사 SO가 출고처리될때 PO자동입고 후 전송
	 *
	 */
	@PostMapping("/prod-req-trm")
	@Operation(summary = "자재요청-구매입고 결과 수신", description = "자재요청건의 구매입고시 처리 결과 수신 배치")
	public ResponseEntity<ApiResultVo<AsmSapResultVo>> prodReqTrm(
			@Parameter(description = "자재요청-구매입고 결과 수신 객체") @RequestBody @Valid AsmSapProdReqTrmVo param)
			throws Exception {

		// 자재요청-구매입고 결과 수신
		AsmSapResultVo amSapResultVo = asmSapService.prodReqTrm(param);

		if (Utilities.isEmpty(amSapResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(amSapResultVo);
	}
}
