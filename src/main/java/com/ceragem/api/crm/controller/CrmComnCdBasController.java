package com.ceragem.api.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmCommonCodeVo;
import com.ceragem.api.crm.service.CrmComnCdBasService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmComnCdBasController
 * @author 김성태
 * @date 2022. 4. 28.
 * @Version 1.0
 * @description 공통코드 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM 공통코드", description = "공통코드 API")
@RestController
@RequestMapping("/crm/v1.0/common-code")
public class CrmComnCdBasController extends BaseRestController {

	@Autowired
	CrmComnCdBasService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 공통코드 검색
	 *
	 */
	@GetMapping("large-cd")
	@Operation(summary = "공통코드 대분류 검색", description = "공통코드 대분류 검색")
	public ResponseEntity<ApiResultVo<List<CrmCommonCodeVo>>> getCrmCustBasList(
			@Parameter(description = "대분류명", required = false) @RequestParam(required = false, value = "keyword") String keyword)
			throws Exception {
		EzMap param = new EzMap();
		if (Utilities.isNotEmpty(keyword))
			param.setString("comnCdNmLike", keyword);
		List<CrmCommonCodeVo> list = service.getLargeList(param);

		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list);
	}

	@GetMapping("{largDiv}")
	@Operation(summary = "공통코드 소분류 검색", description = "공통코드 소분류 검색")
	public ResponseEntity<ApiResultVo<List<CrmCommonCodeVo>>> getCodeList(
			@Parameter(description = "대분류코드", required = false) @PathVariable("largDiv") String topComnCd)
			throws Exception {
		EzMap param = new EzMap();
		param.setString("topComnCd", topComnCd);
		List<CrmCommonCodeVo> list = service.getList(param);

		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list);
	}

	@GetMapping("all")
	@Operation(summary = "공통코드 전체 목록", description = "공통코드 전체 목록")
	public ResponseEntity<ApiResultVo<List<CrmCommonCodeVo>>> getAll() throws Exception {
		EzMap param = new EzMap();
		List<CrmCommonCodeVo> list = service.getList(param);

		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list);
	}
}
