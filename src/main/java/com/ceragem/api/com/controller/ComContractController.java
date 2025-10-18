package com.ceragem.api.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.com.model.CrmBosRtnTxnCountSo;
import com.ceragem.api.com.model.CrmBosRtnTxnSo;
import com.ceragem.api.com.model.CrmBosRtnTxnVo;
import com.ceragem.api.com.model.CrmCustBosCancelCountSo;
import com.ceragem.api.com.model.CrmCustBosCancelSo;
import com.ceragem.api.com.model.CrmCustBosInstallCountSo;
import com.ceragem.api.com.model.CrmCustBosInstallSo;
import com.ceragem.api.com.service.CrmBosRtnTxnService;
import com.ceragem.api.crm.model.CrmCustBosCntrtHstVo;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName ComBosContractController
 * @author stkim
 * @date 2023. 6. 14.
 * @Version 1.0
 * @description 직영몰계약정보
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "직영몰계약정보", description = "직영몰계약정보 API")
@RestController
@RequestMapping("/com/v1.0/contract")
public class ComContractController extends BaseRestController {
	@Autowired
	CrmBosRtnTxnService service;

	@GetMapping("return-count")
	@Operation(summary = "CSS 반환내역 수량", description = "CSS 반환내역 수량 검색")
	public ResponseEntity<ApiResultVo<Integer>> getReturnCount(
			@Parameter(description = "반환내역검색객체") @ParameterObject @Valid CrmBosRtnTxnCountSo so) throws Exception {
		EzMap param = new EzMap(so);
		param.setString("saleOrgzCustCd", Constants._COM_SALE_ORG_CD);
		int cnt = service.getListCount(param);
		return successResponse(cnt);
	}

	@GetMapping("return-list")
	@Operation(summary = "CSS 반환내역 검색", description = "CSS 반환내역 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmBosRtnTxnVo>>> getReturnList(
			@Parameter(description = "반환내역검색객체") @ParameterObject @Valid CrmBosRtnTxnSo so) throws Exception {
		EzMap param = new EzMap(so);
		param.setString("saleOrgzCustCd", Constants._COM_SALE_ORG_CD);
		List<CrmBosRtnTxnVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	@GetMapping("cancel-count")
	@Operation(summary = "CSS 계약취소 수량", description = "CSS 계약취소 수량 검색")
	public ResponseEntity<ApiResultVo<Integer>> getCancelCount(
			@Parameter(description = "계약취소검색객체") @ParameterObject @Valid CrmCustBosCancelCountSo so) throws Exception {

		EzMap param = new EzMap(so);
		param.setString("saleOrgzCustCd", Constants._COM_SALE_ORG_CD);
		param.setString("cntrCnclYn", "Y");
		int cnt = service.getContractListCount(param);
		return successResponse(cnt);
	}

	@GetMapping("cancel-list")
	@Operation(summary = "CSS 계약취소 검색", description = "CSS 계약취소 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustBosCntrtHstVo>>> getcancelList(
			@Parameter(description = "계약취소검색객체") @ParameterObject @Valid CrmCustBosCancelSo so) throws Exception {

		EzMap param = new EzMap(so);
		param.setString("saleOrgzCustCd", Constants._COM_SALE_ORG_CD);
		param.setString("cntrCnclYn", "Y");

		List<CrmCustBosCntrtHstVo> list = service.getContractList(param);
		int cnt = service.getContractListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	@GetMapping("install-count")
	@Operation(summary = "CSS 설치완료 수량", description = "CSS 설치완료 수량 검색")
	public ResponseEntity<ApiResultVo<Integer>> getInstallCount(
			@Parameter(description = "설치완료검색객체") @ParameterObject @Valid CrmCustBosInstallCountSo so) throws Exception {

		EzMap param = new EzMap(so);
		param.setString("saleOrgzCustCd", Constants._COM_SALE_ORG_CD);
		int cnt = service.getContractListCount(param);
		return successResponse(cnt);
	}

	@GetMapping("install-list")
	@Operation(summary = "CSS 설치완료 검색", description = "CSS 설치완료 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustBosCntrtHstVo>>> getInstallList(
			@Parameter(description = "설치완료검색객체") @ParameterObject @Valid CrmCustBosInstallSo so) throws Exception {

		EzMap param = new EzMap(so);
		param.setString("saleOrgzCustCd", Constants._COM_SALE_ORG_CD);

		List<CrmCustBosCntrtHstVo> list = service.getContractList(param);
		int cnt = service.getContractListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	@GetMapping("return-detail")
	@Operation(summary = "CSS 반환내역 상세", description = "CSS 반환내역 상세")
	public ResponseEntity<ApiResultVo<CrmBosRtnTxnVo>> getReturnDetail(
			@Parameter(description = "계약번호") @RequestParam String cntrno,
			@Parameter(description = "반환순번") @RequestParam String rtnsn,
			@Parameter(description = "고객번호") @RequestParam String custno,
			@Parameter(description = "주문번호") @RequestParam String ordno) throws Exception {
		EzMap param = new EzMap();
		param.put("cntrno", cntrno);
		param.put("rtnsn", rtnsn);
		param.put("custno", custno);
		param.put("ordno", ordno);

		CrmBosRtnTxnVo vo = service.get(param);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		if (!Constants._COM_SALE_ORG_CD.equals(vo.getSaleOrgzCustCd()))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	@GetMapping("contract-detail")
	@Operation(summary = "CSS 계약 상세", description = "CSS 계약 상세")
	public ResponseEntity<ApiResultVo<CrmCustBosCntrtHstVo>> getContractDetail(
			@Parameter(description = "계약번호") @RequestParam("cntrNo") String cntrno) throws Exception {
		EzMap param = new EzMap();
		param.put("cntrNo", cntrno);
		CrmCustBosCntrtHstVo vo = service.getContractDetail(param);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		if (!Constants._COM_SALE_ORG_CD.equals(vo.getSaleOrgzCustCd()))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}
}
