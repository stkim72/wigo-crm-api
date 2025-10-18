package com.ceragem.api.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.model.ApiVoidResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmBllkCustHstSo;
import com.ceragem.api.crm.model.CrmBllkCustHstVo;
import com.ceragem.api.crm.model.CrmBllkCustVo;
import com.ceragem.api.crm.service.CrmBllkCustHstService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmBllkCustHstController
 * @author 김성태
 * @date 2022. 4. 15.
 * @Version 1.0
 * @description CRM주의고객이력 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM주의고객이력", description = "CRM주의고객이력 API")
@RestController
@RequestMapping("/crm/v1.0/customer-black")
public class CrmBllkCustHstController extends BaseRestController {

	@Autowired
	CrmBllkCustHstService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 15.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM주의고객이력 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM주의고객이력 검색", description = "CRM주의고객이력 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmBllkCustHstVo>>> getCrmCustBasList(
			@Parameter(description = "CRM주의고객이력 검색객체") @ParameterObject @Valid CrmBllkCustHstSo so) throws Exception {
		EzMap param = new EzMap(so);
		List<CrmBllkCustHstVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 15.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM주의고객이력단건 검색
	 *
	 */
	@GetMapping("/{bllkCustHstSeq}")
	@Operation(summary = "CRM주의고객 단건", description = "CRM주의고객이력 단건 검색")
	public ResponseEntity<ApiResultVo<CrmBllkCustHstVo>> getCrmBllkCustHst(
			@Parameter(description = "주의고객이력일련번호") @PathVariable String bllkCustHstSeq)
			throws Exception {
		CrmBllkCustHstSo so = new CrmBllkCustHstSo();
		so.setBllkCustHstSeq(bllkCustHstSeq);
		CrmBllkCustHstVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 15.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM주의고객이력 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM주의고객 등록", description = "CRM주의고객 등록")
	public ResponseEntity<ApiResultVo<CrmBllkCustHstVo>> registerCrmBllkCustHst(
			@Parameter(description = "CRM주의고객이력 객체") @RequestBody @Valid CrmBllkCustVo vo) throws Exception {
		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 15.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM주의고객이력 수정
	 *
	 */
	@PutMapping("")
	@Operation(summary = "CRM주의고객 수정", description = "CRM주의고객이력 수정", hidden = true)
	public ResponseEntity<ApiResultVo<CrmBllkCustHstVo>> modifyCrmBllkCustHst(
			@Parameter(description = "CRM주의고객이력 객체") @RequestBody @Valid CrmBllkCustVo vo) throws Exception {
		int ret = service.update(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 15.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM주의고객이력 삭제
	 *
	 */
	@DeleteMapping("/{bllkCustHstSeq}")
	@Operation(summary = "CRM주의고객 해제", description = "CRM주의고객 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmBllkCustHst(
			@Parameter(description = "주의고객이력일련번호") @PathVariable String bllkCustHstSeq)
			throws Exception {
		CrmBllkCustHstVo vo = new CrmBllkCustHstVo();
		vo.setBllkCustHstSeq(bllkCustHstSeq);
		int ret = service.delete(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 15.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM주의고객이력 삭제
	 *
	 */
	@DeleteMapping("/{regChlCd}/{itgCustNo}")
	@Operation(summary = "CRM 채널별 주의고객 해제", description = "CRM 채널별 주의고객 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmBllkCustHst3(
			@Parameter(description = "채널코드") @PathVariable String regChlCd,
			@Parameter(description = "통합고객번호") @PathVariable String itgCustNo) throws Exception {
		CrmBllkCustHstVo vo = new CrmBllkCustHstVo();
		vo.setRegChlCd(regChlCd);
		vo.setItgCustNo(itgCustNo);
		int ret = service.deleteChennel(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 15.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM주의고객이력 삭제
	 *
	 */
	@DeleteMapping("/{regChlCd}/{storeNo}/{itgCustNo}")
	@Operation(summary = "CRM 매장별 주의고객 해제", description = "CRM 매장별 주의고객 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmBllkCustHst2(
			@Parameter(description = "채널코드") @PathVariable String regChlCd,
			@Parameter(description = "매장번호") @PathVariable String storeNo,
			@Parameter(description = "통합고객번호") @PathVariable String itgCustNo) throws Exception {
		CrmBllkCustHstVo vo = new CrmBllkCustHstVo();
		vo.setRegChlCd(regChlCd);
		vo.setStorNo(storeNo);
		vo.setItgCustNo(itgCustNo);
		int ret = service.deleteStore(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

}
