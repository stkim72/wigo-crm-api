package com.ceragem.api.as.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.as.model.AsmMoReceiveVo;
import com.ceragem.api.as.model.AsmMoResultVo;
import com.ceragem.api.as.service.AsmMoService;
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
 * @ClassName AsmMoController
 * @author 이윤성
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description MO서비스 정보 수신 Controller
 */
@Tag(name = "MO서비스 정보 수신", description = "MO서비스 정보 수신 API")
@RestController
@RequestMapping("/as/v1.0/mo")
public class AsmMoController extends BaseRestController {

	@Autowired
	AsmMoService asmMoService;

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 14.
	 * @param 송신  전화번호 : 고객전화번호
	 * @param 수신  번호 : Mo 수신 번호(서비스번호)
	 * @param 수신  시각
	 * @param 이미지 개수
	 * @param 이미지 경로 (3개) Path1, Path2, Path3
	 * @param 문자  내용 : 수신 문자 text (Base64인코딩)
	 * @return
	 * @throws Exception
	 * @description MO서비스 정보 수신 API
	 *
	 */
	@PostMapping("/info-receive")
	@Operation(summary = "MO서비스 정보 수신", description = "MO서비스 정보 수신 API")
	public ResponseEntity<ApiResultVo<AsmMoResultVo>> getInfoReceive(
			@Parameter(description = "MO서비스 정보객체") @RequestBody @Valid AsmMoReceiveVo mo) throws Exception {

		// MO정보수신
		AsmMoResultVo asmMoResultVo = asmMoService.getInfoReceive(mo);

		if (Utilities.isEmpty(asmMoResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmMoResultVo);
	}
}
