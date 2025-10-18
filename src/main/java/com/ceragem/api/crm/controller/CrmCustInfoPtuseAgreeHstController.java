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
import com.ceragem.api.crm.model.CrmCustInfoPtuseAgreeHstSo;
import com.ceragem.api.crm.model.CrmCustInfoPtuseAgreeHstVo;
import com.ceragem.api.crm.service.CrmCustInfoPtuseAgreeHstService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * 
 * @ClassName CrmCustInfoPtuseAgreeHstController
 * @author 김성태
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM고객정보활용동의 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

//@Tag(name = "CRM고객정보활용동의", description = "CRM고객정보활용동의 API")
//@RestController
//@RequestMapping("/crm/v1.0/agree")

public class CrmCustInfoPtuseAgreeHstController extends BaseRestController {

	@Autowired
	CrmCustInfoPtuseAgreeHstService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 5. 17.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM고객정보활용동의 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM고객정보활용동의 검색", description = "CRM고객정보활용동의 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustInfoPtuseAgreeHstVo>>> getCrmCustBasList(
			@Parameter(description = "CRM고객정보활용동의 검색객체") @ParameterObject @Valid CrmCustInfoPtuseAgreeHstSo so) throws Exception {
		EzMap param = new EzMap(so);
		List<CrmCustInfoPtuseAgreeHstVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 5. 17.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM고객정보활용동의단건 검색
	 *
	 */
	@GetMapping("/{infoPtuseAgreeHstSeq}")
	@Operation(summary = "CRM고객정보활용동의 단건", description = "CRM고객정보활용동의 단건 검색")
	public ResponseEntity<ApiResultVo<CrmCustInfoPtuseAgreeHstVo>> getCrmCustInfoPtuseAgreeHst(
			@Parameter(description = "정보활용동의일련번호") @PathVariable String infoPtuseAgreeHstSeq)
			throws Exception {
		CrmCustInfoPtuseAgreeHstSo so = new CrmCustInfoPtuseAgreeHstSo();
		so.setInfoPtuseAgreeHstSeq(infoPtuseAgreeHstSeq);
		CrmCustInfoPtuseAgreeHstVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 5. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객정보활용동의 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM고객정보활용동의 입력", description = "CRM고객정보활용동의 입력")
	public ResponseEntity<ApiResultVo<CrmCustInfoPtuseAgreeHstVo>> registerCrmCustInfoPtuseAgreeHst(
			@Parameter(description = "CRM고객정보활용동의 객체") @RequestBody @Valid CrmCustInfoPtuseAgreeHstVo vo)
			throws Exception {
		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 5. 17.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM고객정보활용동의 수정
	 *
	 */
	@PutMapping("")
	@Operation(summary = "CRM고객정보활용동의 수정", description = "CRM고객정보활용동의 수정")
	public ResponseEntity<ApiResultVo<CrmCustInfoPtuseAgreeHstVo>> modifyCrmCustInfoPtuseAgreeHst(
			@Parameter(description = "CRM고객정보활용동의 객체") @RequestBody @Valid CrmCustInfoPtuseAgreeHstVo vo)
			throws Exception {
		int ret = service.update(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 5. 17.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM고객정보활용동의 삭제
	 *
	 */
	@DeleteMapping("/{infoPtuseAgreeHstSeq}")
	@Operation(summary = "CRM고객정보활용동의 삭제", description = "CRM고객정보활용동의 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmCustInfoPtuseAgreeHst(
			@Parameter(description = "정보활용동의일련번호") @PathVariable String infoPtuseAgreeHstSeq)
			throws Exception {
		CrmCustInfoPtuseAgreeHstVo vo = new CrmCustInfoPtuseAgreeHstVo();
		vo.setInfoPtuseAgreeHstSeq(infoPtuseAgreeHstSeq);
		int ret = service.delete(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

}
