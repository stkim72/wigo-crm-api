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
import com.ceragem.api.sap.model.SapPntPreserveResultVo;
import com.ceragem.api.sap.model.SapPntPreserveVo;
import com.ceragem.api.sap.model.SapPntProcessResultVo;
import com.ceragem.api.sap.model.SapPntProcessVo;
import com.ceragem.api.sap.model.SapPntUseSetVo;
import com.ceragem.api.sap.model.SapPntUserSetItemResultVo;
import com.ceragem.api.sap.service.SapPntService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "SAP PNT", description = "SAP PNT API")
@RestController
@RequestMapping("/sap/v1.0/pnt")
public class SapPntController extends BaseRestController {

	@Autowired
	SapPntService service;

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 22.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP PNT 포인트적립/소멸 완료 처리
	 *
	 */
	@PostMapping("/sade")
	@Operation(summary = "SAP PNT 포인트적립/소멸 완료 처리", description = "SAP PNT 포인트적립/소멸 완료 처리 API")
	public ResponseEntity<ApiResultVo<SapPntProcessResultVo>> sapPntProcess(
			@Parameter(description = "SAP PNT 포인트적립/소멸 완료 처리 객체") @RequestBody @Valid SapPntProcessVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP PNT 포인트적립/소멸 완료 처리 수신, SAP시스템으로 전달
		SapPntProcessResultVo sapPntProcessResultVo = service.sapPntProcess(param);

		if (Utilities.isEmpty(sapPntProcessResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPntProcessResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 23.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP PNT 포인트 사용 완료 처리
	 *
	 */
	@PostMapping("/use")
	@Operation(summary = "SAP PNT 포인트 사용 완료 처리", description = "SAP PNT 포인트 사용 완료 처리 API")
	public ResponseEntity<ApiResultVo<SapPntUserSetItemResultVo>> sapPntUse(
			@Parameter(description = "SAP PNT 포인트 사용 완료 처리 객체") @RequestBody @Valid SapPntUseSetVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		SapPntUserSetItemResultVo sapPntUserSetItemResultVo = service.sapPntUserSet(param);

		if (Utilities.isEmpty(sapPntUserSetItemResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPntUserSetItemResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 23.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP PNT 가맹점 포인트 보전 완료 처리 수신
	 *
	 */
	@PostMapping("/pr")
	@Operation(summary = "SAP PNT 가맹점 포인트 보전 완료 처리 수신", description = "SAP PNT 가맹점 포인트 보전 완료 처리 수신 API")
	public ResponseEntity<ApiResultVo<SapPntPreserveResultVo>> sapPntPreserveSet(
			@Parameter(description = "SAP PNT 가맹점 포인트 보전 객체") @RequestBody @Valid SapPntPreserveVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		SapPntPreserveResultVo sapPntPreserveResultVo = service.sapPntPreserveSet(param);

		if (Utilities.isEmpty(sapPntPreserveResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPntPreserveResultVo);
	}

}