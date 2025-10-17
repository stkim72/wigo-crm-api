package com.ceragem.api.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.as.model.AsmWebAppApiVo;
import com.ceragem.api.as.service.AsmWebAppApiService;
import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @ClassName AsmWebAppApiController
 * @author 이윤성
 * @date 2022. 6. 15.
 * @Version 1.0
 * @description AS네이티브앱 WebApp API Controller
 */

@Tag(name = "AS네이티브앱 WebApp", description = "AS네이티브앱 WebApp API")
@RestController
@RequestMapping("/as/v1.0/app")
public class AsmWebAppApiController extends BaseRestController {

	@Autowired
	AsmWebAppApiService service;

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 15.
	 * @param divCD : (필수) 구분코드
	 * @return
	 * @throws Exception
	 * @description App 버전정보 API
	 *
	 */
	@GetMapping("/ver/{divCd}")
	@Operation(summary = "네이티브App 버전정보", description = "네이티브App 버전정보 API")
	public ResponseEntity<ApiResultVo<AsmWebAppApiVo>> selectAppVer(
			@Parameter(description = "APP구분코드") @PathVariable("divCd") String divCd) throws Exception {

		EzMap param = new EzMap();
		param.put("grpCd", "CM119"); // App버전 공통코드
		param.put("divCd", divCd); // App구분코드(APP1:직영앱, APP2:위탁앱)

		// 네이티브App 버전정보 조회
		AsmWebAppApiVo vo = service.selectAppVer(param);

		if (vo == null) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		return successResponse(vo);
	}

}
