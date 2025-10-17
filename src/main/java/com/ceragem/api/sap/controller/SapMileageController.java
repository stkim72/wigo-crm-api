package com.ceragem.api.sap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.sap.model.SapMaProcessResultVo;
import com.ceragem.api.sap.model.SapMaProcessVo;
import com.ceragem.api.sap.service.SapMileageService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "SAP MA", description = "SAP MA API")
@RestController
@RequestMapping("/sap/v1.0/ma")
public class SapMileageController extends BaseRestController {

	@Autowired
	SapMileageService service;

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 12.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP 마일리지 통합 완료 처리 내역 수신
	 *
	 */
	@PostMapping("/all")
	@Operation(summary = "SAP 마일리지 통합 완료 처리 내역 수신", description = "SAP 마일리지 통합 완료 처리 내역 수신 API")
	public ResponseEntity<ApiResultVo<SapMaProcessResultVo>> sapPntProcess(
			@Parameter(description = "SAP 마일리지 통합 완료 처리 내역 수신 처리 객체") @RequestBody @Valid SapMaProcessVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP 마일리지 통합 완료 처리 내역 수신, SAP시스템으로 전달
		SapMaProcessResultVo sapMaProcessResultVo = service.sapMaProcess(param);

		if (Utilities.isEmpty(sapMaProcessResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapMaProcessResultVo);
	}

}
