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
import com.ceragem.api.crm.model.CrmDormCustBasSo;
import com.ceragem.api.crm.model.CrmDormCustBasVo;
import com.ceragem.api.crm.service.CrmDormCustBasService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * 
 * @ClassName    CrmDormCustBasController
 * @author    김성태
 * @date    2022. 4. 18.
 * @Version    1.0
 * @description    CRM휴면고객기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

//@Tag(name = "CRM휴면고객기본", description = "CRM휴면고객기본 API")
//@RestController
//@RequestMapping("/crm/v1.0/crm-dorm-cust-bas")
public class CrmDormCustBasController extends BaseRestController {

@Autowired
CrmDormCustBasService service;

	 /**
	*
	* @author 김성태
	* @date 2022. 4. 18.
	* @param so
	* @param param
	* @return
	* @throws Exception
	* @description CRM휴면고객기본 검색
	*
	*/
	@GetMapping("list")
	@Operation(summary = "CRM휴면고객기본 검색", description = "CRM휴면고객기본 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmDormCustBasVo>>> getCrmCustBasList(
			@Parameter(description = "CRM휴면고객기본 검색객체") @ParameterObject @Valid CrmDormCustBasSo so)
			throws Exception {
		EzMap param = new EzMap(so);
		List<CrmDormCustBasVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if(Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list,so);
}

	/**
	*
	* @author 김성태
	* @date 2022. 4. 18.
	* @param id
	* @return
	* @throws Exception
	* @description CRM휴면고객기본단건 검색
	*
	*/
	@GetMapping("/{itgCustNo}")
	@Operation(summary = "CRM휴면고객기본 단건", description = "CRM휴면고객기본 단건 검색")
	public ResponseEntity<ApiResultVo<CrmDormCustBasVo>> getCrmDormCustBas(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo)
			throws Exception {
		CrmDormCustBasSo so  = new CrmDormCustBasSo();
		so.setItgCustNo(itgCustNo);
		CrmDormCustBasVo vo = service.get(so);
		if(vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
}

	/**
	*
	* @author 김성태
	* @date 2022. 4. 18.
	* @param vo
	* @return
	* @throws Exception
	* @description CRM휴면고객기본 입력
	*
	*/
	@PostMapping("")
	@Operation(summary = "CRM휴면고객기본 입력", description = "CRM휴면고객기본 입력")
	public ResponseEntity<ApiResultVo<CrmDormCustBasVo>> registerCrmDormCustBas(
			@Parameter(description = "CRM휴면고객기본 객체") @RequestBody @Valid CrmDormCustBasVo vo)
			throws Exception {
		int ret = service.insert(vo);
		if(ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
}

	/**
	*
	* @author 김성태
	* @date 2022. 4. 18.
	* @param vo
	* @param param
	* @return
	* @throws Exception
	* @description CRM휴면고객기본 수정
	*
	*/
	@PutMapping("")
	@Operation(summary = "CRM휴면고객기본 수정", description = "CRM휴면고객기본 수정")
	public ResponseEntity<ApiResultVo<CrmDormCustBasVo>> modifyCrmDormCustBas(
			@Parameter(description = "CRM휴면고객기본 객체") @RequestBody @Valid CrmDormCustBasVo vo)
			throws Exception {
		int ret = service.update(vo);
		if(ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
}

	/**
	*
	* @author 김성태
	* @date 2022. 4. 18.
	* @param id
	* @return
	* @throws Exception
	* @description CRM휴면고객기본 삭제
	*
	*/
	@DeleteMapping("/{itgCustNo}")
	@Operation(summary = "CRM휴면고객기본 삭제", description = "CRM휴면고객기본 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmDormCustBas(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo)
			throws Exception {
		CrmDormCustBasVo vo = new CrmDormCustBasVo();
		vo.setItgCustNo(itgCustNo);
		int ret = service.delete(vo);
		if(ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
}

}
