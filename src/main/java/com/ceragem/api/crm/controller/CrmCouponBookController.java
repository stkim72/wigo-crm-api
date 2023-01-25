package com.ceragem.api.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.model.ApiVoidResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmCouponBookSo;
import com.ceragem.api.crm.model.CrmCouponBookVo;
import com.ceragem.api.crm.service.CrmCouponBookService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmCoupnBookPblsHstController
 * @author 김성태
 * @date 2022. 5. 11.
 * @Version 1.0
 * @description CRM쿠폰북발행이력 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM서비스권", description = "CRM서비스권 API")
@RestController
@RequestMapping("/crm/v1.0/coupon-book")
public class CrmCouponBookController extends BaseRestController {

	@Autowired
	CrmCouponBookService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM서비스권 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM서비스권 검색", description = "CRM서비스권 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCouponBookVo>>> getBookList(
			@Parameter(description = "CRM서비스권 검색객체") @ParameterObject @Valid CrmCouponBookSo so) throws Exception {
		EzMap param = new EzMap(so);
		List<CrmCouponBookVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰발행이력 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM 서비스권 발행", description = "CRM 서비스권 발행")
	public ResponseEntity<ApiResultVo<CrmCouponBookVo>> registerCrmCoupnBook(
			@Parameter(description = "CRM 서비스권 객체") @RequestBody @Valid CrmCouponBookVo vo) throws Exception {
		CrmCouponBookVo ret = service.insertServiceIssue(vo);
		if (ret == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);

		return successResponse(ret);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰발행이력 입력
	 *
	 */
	@DeleteMapping("")
	@Operation(summary = "CRM 서비스권 발행 취소", description = "CRM 서비스권 취소")
	public ResponseEntity<ApiVoidResultVo> removeCrmCoupnBook(
			@Parameter(description = "CRM 서비스권 객체") @RequestBody CrmCouponBookVo vo) throws Exception {
		int ret = service.delete(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰단건 검색
	 *
	 */
	@GetMapping("/{coupnBookHstSeq}")
	@Operation(summary = "CRM 서비스권 상세", description = "CRM 서비스권 상세")
	public ResponseEntity<ApiResultVo<CrmCouponBookVo>> getCrmCoupnPblsHst(
			@Parameter(description = "서비스권번호") @PathVariable("coupnBookHstSeq") String coupnBookHstSeq)
			throws Exception {
		CrmCouponBookSo so = new CrmCouponBookSo();
		so.setCoupnBookHstSeq(coupnBookHstSeq);
		CrmCouponBookVo vo = service.getBookInfo(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	@GetMapping("validate/{coupnBookHstSeq}")
	@Operation(summary = "CRM 서비스권번호 유효성", description = "CRM 서비스권번호 유효성")
	public ResponseEntity<ApiResultVo<CrmCouponBookVo>> validCoupon(
			@Parameter(description = "CRM 서비스권번호") @PathVariable("coupnBookHstSeq") String coupnBookHstSeq,
			@Parameter(description = "사용횟수") @RequestParam("applyCnt") int applyCnt,
			@Parameter(description = "매장번호", required = false) @RequestParam("storeNo") String storeNo,
			@Parameter(description = "CRM 서비스권객체", hidden = true) @ModelAttribute CrmCouponBookVo param)
			throws Exception {
		param.setCoupnBookHstSeq(coupnBookHstSeq);
		param.setApplyCnt(applyCnt);
		param.setStorNo(storeNo);
		service.updateValidate(param);
		return successResponse(service.getBookInfo(param));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM서비스권 사용
	 *
	 */
	@PostMapping("approve/{coupnBookHstSeq}")
	@Operation(summary = "CRM 서비스권 사용", description = "CRM 서비스권 사용")
	public ResponseEntity<ApiResultVo<CrmCouponBookVo>> approveCrmCoupnBook(
			@Parameter(description = "CRM 서비스권번호") @PathVariable("coupnBookHstSeq") String coupnBookHstSeq,
			@Parameter(description = "사용횟수") @RequestParam("applyCnt") int applyCnt,
			@Parameter(description = "매장번호", required = false) @RequestParam("storeNo") String storeNo,
			@Parameter(description = "CRM 서비스권객체", hidden = true) @ModelAttribute CrmCouponBookVo param)
			throws Exception {
		param.setCoupnBookHstSeq(coupnBookHstSeq);
		param.setApplyCnt(applyCnt);
		param.setStorNo(storeNo);
		int ret = service.updateApprove(param);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.getBookInfo(param));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM 서비스권 사용취소
	 *
	 */
	@PostMapping("cancel/{coupnBookHstSeq}")
	@Operation(summary = "CRM 서비스권 사용취소", description = "CRM 서비스권 사용취소")
	public ResponseEntity<ApiResultVo<CrmCouponBookVo>> cancelCrmCoupnPblsHsts(
			@Parameter(description = "CRM 서비스권번호") @PathVariable("coupnBookHstSeq") String coupnBookHstSeq,
			@Parameter(description = "적용횟수") @RequestParam("applyCnt") int applyCnt,
			@Parameter(description = "CRM 서비스권객체", hidden = true) @ModelAttribute CrmCouponBookVo param)
			throws Exception {
		param.setCoupnBookHstSeq(coupnBookHstSeq);
		param.setApplyCnt(applyCnt);
		int ret = service.updateCancel(param);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.getBookInfo(param));
	}

}
