package com.ceragem.api.ctc.controller;

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
import com.ceragem.api.ctc.model.QustnAsRegVo;
import com.ceragem.api.ctc.service.AsRegService;
import com.ceragem.api.sap.model.SapAsCmptTrtResultVo;
import com.ceragem.api.sap.model.SapAsCmptTrtVo;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName
 * @author 임형진
 * @date 2022. 5. 10.
 * @Version 1.0
 * @description 1대1문의_AS등록 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "1대1문의_AS등록_homeage", description = "1대1문의_AS등록_homeage")
@RestController
@RequestMapping("/ctc/v1.0/regist")
public class AsRegController extends BaseRestController {

	@Autowired
	AsRegService service;

	/**
	 *
	 * @author 임형진
	 * @date 2022. 5. 11
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 1대1문의_AS등록_homeage
	 *
	 */
	@PostMapping("/homepage")
	@Operation(summary = "1대1문의_AS등록_homeage", description = "1대1문의_AS등록_homeage")
	public ResponseEntity<ApiResultVo<QustnAsRegVo>> homepageAsReg( 
			@Parameter(description = "1대1문의_AS등록_homeage") @Valid QustnAsRegVo vo) throws Exception {

		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, Constants._API_CODE_INVALID_PARAM_MSG);
		return successResponse(vo);
	}



	
	/**
	 *
	 * @author 임형진
	 * @date 2022. 5. 11
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 1대1문의_AS등록_mall
	 *
	 */
	@PostMapping("/iot")
	@Operation(summary = "1대1문의_AS등록_iot", description = "1대1문의_AS등록_iot")
	public ResponseEntity<ApiResultVo<QustnAsRegVo>> iotAsReg(
			@Parameter(description = "1대1문의_AS등록_iot") @RequestBody  @Valid QustnAsRegVo vo) throws Exception {
		EzMap param = new EzMap(vo);
		
		int ret = service.insert(param);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, Constants._API_CODE_INVALID_PARAM_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author 임형진
	 * @date 2022. 5. 11
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 1대1문의_AS등록_mall
	 *
	 */
	@PostMapping("/mall")
	@Operation(summary = "1대1문의_AS등록_mall", description = "1대1문의_AS등록_mall")
	public ResponseEntity<ApiResultVo<QustnAsRegVo>> mallAsReg(
			@Parameter(description = "1대1문의_AS등록_iot") @RequestBody @Valid QustnAsRegVo vo) throws Exception {
		
		EzMap param = new EzMap(vo);
		int ret = service.insert(param);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, Constants._API_CODE_INVALID_PARAM_MSG);
		return successResponse(vo);
	}

}
