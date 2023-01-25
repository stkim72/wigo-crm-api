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

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.model.ApiVoidResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmCardPblsHstSo;
import com.ceragem.api.crm.model.CrmCardPblsHstVo;
import com.ceragem.api.crm.service.CrmCardPblsHstService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * 
 * @ClassName CrmCardPblsHstController
 * @author 김성태
 * @date 2022. 4. 26.
 * @Version 1.0
 * @description CRM카드발행이력 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

public class CrmCardPblsHstController extends BaseRestController {

	@Autowired
	CrmCardPblsHstService service;

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
	@Operation(summary = "CRM카드발행이력 검색", description = "CRM카드발행이력 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCardPblsHstVo>>> getCrmCustBasList(
			@Parameter(description = "CRM카드발행이력 검색객체") @ParameterObject @Valid CrmCardPblsHstSo so) throws Exception {
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
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM카드발행이력단건 검색
	 *
	 */
	@GetMapping("/{cardPblsHstSeq}")
	@Operation(summary = "CRM카드발행이력 단건", description = "CRM카드발행이력 단건 검색")
	public ResponseEntity<ApiResultVo<CrmCardPblsHstVo>> getCrmCardPblsHst(
			@Parameter(description = "카드발행이력일련번호") @PathVariable("cardPblsHstSeq") String cardPblsHstSeq)
			throws Exception {
		CrmCardPblsHstSo so = new CrmCardPblsHstSo();
		so.setCardPblsHstSeq(cardPblsHstSeq);
		CrmCardPblsHstVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 26.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM카드발행이력 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM카드발행이력 입력", description = "CRM카드발행이력 입력")
	public ResponseEntity<ApiResultVo<CrmCardPblsHstVo>> registerCrmCardPblsHst(
			@Parameter(description = "CRM카드발행이력 객체") @RequestBody @Valid CrmCardPblsHstVo vo) throws Exception {
		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 26.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM카드발행이력 수정
	 *
	 */
	@PutMapping("")
	@Operation(summary = "CRM카드발행이력 수정", description = "CRM카드발행이력 수정")
	public ResponseEntity<ApiResultVo<CrmCardPblsHstVo>> modifyCrmCardPblsHst(
			@Parameter(description = "CRM카드발행이력 객체") @RequestBody @Valid CrmCardPblsHstVo vo) throws Exception {
		int ret = service.update(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 26.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM카드발행이력 삭제
	 *
	 */
	@DeleteMapping("/{cardPblsHstSeq}")
	@Operation(summary = "CRM카드발행이력 삭제", description = "CRM카드발행이력 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmCardPblsHst(
			@Parameter(description = "카드발행이력일련번호") @PathVariable("cardPblsHstSeq") String cardPblsHstSeq)
			throws Exception {
		CrmCardPblsHstVo vo = new CrmCardPblsHstVo();
		vo.setCardPblsHstSeq(cardPblsHstSeq);
		int ret = service.delete(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

}
