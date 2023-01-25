package com.ceragem.api.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiDateRangePagination;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmCardPblsHstSo;
import com.ceragem.api.crm.model.CrmCardPblsHstVo;
import com.ceragem.api.crm.model.CrmPointHstSo;
import com.ceragem.api.crm.model.CrmPointHstVo;
import com.ceragem.api.crm.service.CrmCardPblsHstService;
import com.ceragem.api.crm.service.CrmPointHstService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmMshipCardBasController
 * @author 김성태
 * @date 2022. 4. 26.
 * @Version 1.0
 * @description CRM멤버십카드기본 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM멤버십카드", description = "CRM멤버십카드 API")
@RestController
@RequestMapping("/crm/v1.0/membership-card")
public class CrmMshipCardBasController extends BaseRestController {

	@Autowired
	CrmCardPblsHstService service;

	@Autowired
	CrmPointHstService pointService;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 26.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM카드발행이력 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM 보유카드 목록 검색", description = "CRM 보유카드 목록")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCardPblsHstVo>>> getCrmCustBasList(
			@Parameter(description = "통합고객번호") @RequestParam("itgCustNo") String itgCustNo,
			@Parameter(description = "CRM카드발행이력 검색객체", hidden = true) @ParameterObject @Valid CrmCardPblsHstSo so) throws Exception {
		EzMap param = new EzMap(so);
		List<CrmCardPblsHstVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 26.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM카드발행이력 검색
	 *
	 */
	@GetMapping("point/{itgCustNo}")
	@Operation(summary = "CRM 고객별 카드 사용내역", description = "CRM 고객별 카드 사용내역")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmPointHstVo>>> getPointList(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "카드번호", required = false) @RequestParam(required = false, value = "cardNo") String cardNo,
			@Parameter(description = "검색시작일", required = false) @RequestParam(required = false, value = "startDt") String startDt,
			@Parameter(description = "검색종료일", required = false) @RequestParam(required = false, value = "endDt") String endDt,
			@Parameter(description = "페이지번호", required = false) @RequestParam(required = false, value = "currentPageNo") String currentPageNo,
			@Parameter(description = "페이지당row", required = false) @RequestParam(required = false, value = "recordCountPerPage") String recordCountPerPage,
			@Parameter(hidden = true) @ParameterObject @ModelAttribute @Valid CrmPointHstSo so) throws Exception {
		so.setUseCard("Y");
		EzMap param = new EzMap(so);

		List<CrmPointHstVo> list = pointService.getList(param);
		int cnt = pointService.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 26.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM카드발행이력 검색
	 *
	 */
	@GetMapping("card/{cardNo}")
	@Operation(summary = "CRM 카드별 사용내역", description = "CRM 카드 사용내역")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmPointHstVo>>> getCardPointList(
			@Parameter(description = "카드번호", required = false) @RequestParam(required = false, value = "cardNo") String cardNo,
			@Parameter(description = "검색시작일", required = false) @RequestParam(required = false, value = "startDt") String strtDt,
			@Parameter(description = "검색종료일", required = false) @RequestParam(required = false, value = "endDt") String endDt,
			@Parameter(description = "페이지번호", required = false) @RequestParam(required = false, value = "currentPageNo") String currentPageNo,
			@Parameter(description = "페이지당row", required = false) @RequestParam(required = false, value = "recordCountPerPage") String recordCountPerPage,
			@Parameter(hidden = true) @ModelAttribute @Valid ApiDateRangePagination p,
			@Parameter(hidden = true) @ModelAttribute CrmPointHstSo so) throws Exception {
		so.setUseCard("Y");
		EzMap param = new EzMap(so);
		List<CrmPointHstVo> list = pointService.getList(param);
		int cnt = pointService.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}
}
