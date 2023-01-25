package com.ceragem.api.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmMshipStmpAccumVo;
import com.ceragem.api.crm.model.CrmMshipStmpCancelVo;
import com.ceragem.api.crm.model.CrmMshipStmpEventVo;
import com.ceragem.api.crm.model.CrmMshipStmpIssueSo;
import com.ceragem.api.crm.model.CrmMshipStmpIssueVo;
import com.ceragem.api.crm.service.CrmMshipStmpBasService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmMshipStmpBasController
 * @author user
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM멤버십스탬프기본 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM멤버십스탬프기본", description = "CRM멤버십스탬프기본 API")
@RestController
@RequestMapping("/crm/v1.0/crm-mship-stmp-bas")
public class CrmMshipStmpBasController extends BaseRestController {

	@Autowired
	CrmMshipStmpBasService service;

	/**
	 *
	 * @author user
	 * @date 2022. 5. 17.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십스탬프기본 검색
	 *
	 */
//	@GetMapping("list")
//	@Operation(summary = "CRM멤버십스탬프기본 검색", description = "CRM멤버십스탬프기본 검색")
//	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmMshipStmpBasVo>>> getCrmCustBasList(
//			@Parameter(description = "CRM멤버십스탬프기본 검색객체") @ParameterObject @Valid CrmMshipStmpBasSo so)
//			throws Exception {
//		EzMap param = new EzMap(so);
//		List<CrmMshipStmpBasVo> list = service.getList(param);
//		int cnt = service.getListCount(param);
//		so.setTotalRecordCount(cnt);
//		if (Utilities.isEmpty(list))
//			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
//		return successResponse(list, so);
//	}

	/**
	 *
	 * @author user
	 * @date 2022. 5. 17.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM멤버십스탬프기본단건 검색
	 *
	 */
//	@GetMapping("/{mshipStmpBasNo}")
//	@Operation(summary = "CRM멤버십스탬프기본 단건", description = "CRM멤버십스탬프기본 단건 검색")
//	public ResponseEntity<ApiResultVo<CrmMshipStmpBasVo>> getCrmMshipStmpBas(
//			@Parameter(description = "스탬프발행기본번호") @PathVariable("mshipStmpBasNo") String mshipStmpBasNo)
//			throws Exception {
//		CrmMshipStmpBasSo so = new CrmMshipStmpBasSo();
//		so.setMshipStmpBasNo(mshipStmpBasNo);
//		CrmMshipStmpBasVo vo = service.get(so);
//		if (vo == null)
//			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
//		return successResponse(vo);
//	}

	/**
	 *
	 * @author user
	 * @date 2022. 5. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM멤버십스탬프기본 입력
	 *
	 */
//	@PostMapping("")
//	@Operation(summary = "CRM멤버십스탬프기본 입력", description = "CRM멤버십스탬프기본 입력")
//	public ResponseEntity<ApiResultVo<CrmMshipStmpBasVo>> registerCrmMshipStmpBas(
//			@Parameter(description = "CRM멤버십스탬프기본 객체") @RequestBody @Valid CrmMshipStmpBasVo vo) throws Exception {
//		int ret = service.insert(vo);
//		if (ret == 0)
//			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
//		return successResponse(service.get(vo));
//	}

	/**
	 *
	 * @author user
	 * @date 2022. 5. 17.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십스탬프기본 수정
	 *
	 */
//	@PutMapping("")
//	@Operation(summary = "CRM멤버십스탬프기본 수정", description = "CRM멤버십스탬프기본 수정")
//	public ResponseEntity<ApiResultVo<CrmMshipStmpBasVo>> modifyCrmMshipStmpBas(
//			@Parameter(description = "CRM멤버십스탬프기본 객체") @RequestBody @Valid CrmMshipStmpBasVo vo) throws Exception {
//		int ret = service.update(vo);
//		if (ret == 0)
//			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
//		return successResponse(service.get(vo));
//	}

	/**
	 *
	 * @author user
	 * @date 2022. 5. 17.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM멤버십스탬프기본 삭제
	 *
	 */
//	@DeleteMapping("/{mshipStmpBasNo}")
//	@Operation(summary = "CRM멤버십스탬프기본 삭제", description = "CRM멤버십스탬프기본 삭제")
//	public ResponseEntity<ApiVoidResultVo> removeCrmMshipStmpBas(
//			@Parameter(description = "스탬프발행기본번호") @PathVariable("mshipStmpBasNo") String mshipStmpBasNo)
//			throws Exception {
//		CrmMshipStmpBasVo vo = new CrmMshipStmpBasVo();
//		vo.setMshipStmpBasNo(mshipStmpBasNo);
//		int ret = service.delete(vo);
//		if (ret == 0)
//			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
//		return successResponse();
//	}

	/**
	 *
	 * @author user
	 * @date 2022. 5. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM멤버십스탬프 이벤트
	 */
	@PostMapping("event")
	@Operation(summary = "CRM멤버십스탬프 이벤트", description = "CRM멤버십스탬프 이벤트")
	public ResponseEntity<ApiResultVo<List<CrmMshipStmpIssueVo>>> eventCrmMshipStmpBas(
			@Parameter(description = "CRM멤버십스탬프적립 객체") @RequestBody @Valid CrmMshipStmpEventVo vo) throws Exception {
		List<CrmMshipStmpIssueVo> list = service.eventStmp(vo);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list);
	}

	/**
	 *
	 * @author user
	 * @date 2022. 5. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM멤버십스탬프 적립 EzMap param = new EzMap(so);
	 */
	@PostMapping("accuml")
	@Operation(summary = "CRM멤버십스탬프 적립", description = "CRM멤버십스탬프 적립")
	public ResponseEntity<ApiResultVo<List<CrmMshipStmpIssueVo>>> accumlCrmMshipStmpBas(
			@Parameter(description = "CRM멤버십스탬프적립 객체") @RequestBody @Valid CrmMshipStmpAccumVo vo) throws Exception {

		List<CrmMshipStmpIssueVo> list = service.accumlStmp(vo);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list);
	}

	/**
	 *
	 * @author user
	 * @date 2022. 5. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰 사용
	 *
	 */
	@PostMapping("cancel")
	@Operation(summary = "CRM멤버십스탬프 취소", description = "CRM멤버십스탬프 취소")
	public ResponseEntity<ApiResultVo<CrmMshipStmpIssueVo>> cancelCrmMshipStmpBas(
			@Parameter(description = "CRM멤버십스탬프적립 객체") @RequestBody @Valid CrmMshipStmpCancelVo cVo) throws Exception {

		CrmMshipStmpAccumVo vo = new CrmMshipStmpAccumVo();
		vo.setStorNo(cVo.getStorNo());
		vo.setChlCd(cVo.getChlCd());
		vo.setItgCustNo(cVo.getItgCustNo());
		vo.setItemList(cVo.getItemList());
		vo.setMshipGradeCd(cVo.getMshipGradeCd());
		vo.setMshipTypeCd(cVo.getMshipTypeCd());
		vo.setCprtCmpNo(cVo.getCprtCmpNo());
		vo.setMshpGradeCd(cVo.getMshpGradeCd());
		service.cancelStmp(vo);

		return successResponse(null);
	}

	/**
	 *
	 * @author user
	 * @date 2022. 5. 17.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십스탬프 이력 검색
	 *
	 */
	@GetMapping("issue/list")
	@Operation(summary = "CRM멤버십스탬프 이력 검색", description = "CRM멤버십스탬프 이력 검색")
	public ResponseEntity<ApiResultVo<List<CrmMshipStmpIssueVo>>> getStmpIssueList(
			@Parameter(description = "CRM멤버십스탬프 이력 검색객체") @ParameterObject @Valid CrmMshipStmpIssueSo so)
			throws Exception {
		EzMap param = new EzMap(so);
		List<CrmMshipStmpIssueVo> list = service.getStmpIssueList(param);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list);
	}
}
