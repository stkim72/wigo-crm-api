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
import com.ceragem.api.crm.model.CrmStorBasSo;
import com.ceragem.api.crm.model.CrmStorBasVo;
import com.ceragem.api.crm.service.CrmStorBasService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * 
 * @ClassName    CrmStorBasController
 * @author    김성태
 * @date    2022. 5. 16.
 * @Version    1.0
 * @description    CRM매장기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

//@Tag(name = "CRM매장기본", description = "CRM매장기본 API")
//@RestController
//@RequestMapping("/crm/v1.0/store")
public class CrmStorBasController extends BaseRestController {

@Autowired
CrmStorBasService service;

	 /**
	*
	* @author 김성태
	* @date 2022. 5. 16.
	* @param so
	* @param param
	* @return
	* @throws Exception
	* @description CRM매장기본 검색
	*
	*/
	@GetMapping("list")
	@Operation(summary = "CRM매장기본 검색", description = "CRM매장기본 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmStorBasVo>>> getCrmCustBasList(
			@Parameter(description = "CRM매장기본 검색객체") @ParameterObject @Valid CrmStorBasSo so)
			throws Exception {
		EzMap param = new EzMap(so);
		List<CrmStorBasVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if(Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list,so);
}

	/**
	*
	* @author 김성태
	* @date 2022. 5. 16.
	* @param id
	* @return
	* @throws Exception
	* @description CRM매장기본단건 검색
	*
	*/
	@GetMapping("/{storNo}")
	@Operation(summary = "CRM매장기본 단건", description = "CRM매장기본 단건 검색")
	public ResponseEntity<ApiResultVo<CrmStorBasVo>> getCrmStorBas(
			@Parameter(description = "매장번호") @PathVariable("storNo") String storNo)
			throws Exception {
		CrmStorBasSo so  = new CrmStorBasSo();
		so.setStorNo(storNo);
		CrmStorBasVo vo = service.get(so);
		if(vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
}

	/**
	*
	* @author 김성태
	* @date 2022. 5. 16.
	* @param vo
	* @return
	* @throws Exception
	* @description CRM매장기본 입력
	*
	*/
	@PostMapping("")
	@Operation(summary = "CRM매장기본 입력", description = "CRM매장기본 입력")
	public ResponseEntity<ApiResultVo<CrmStorBasVo>> registerCrmStorBas(
			@Parameter(description = "CRM매장기본 객체") @RequestBody @Valid CrmStorBasVo vo)
			throws Exception {
		int ret = service.insert(vo);
		if(ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
}

	/**
	*
	* @author 김성태
	* @date 2022. 5. 16.
	* @param vo
	* @param param
	* @return
	* @throws Exception
	* @description CRM매장기본 수정
	*
	*/
	@PutMapping("")
	@Operation(summary = "CRM매장기본 수정", description = "CRM매장기본 수정")
	public ResponseEntity<ApiResultVo<CrmStorBasVo>> modifyCrmStorBas(
			@Parameter(description = "CRM매장기본 객체") @RequestBody @Valid CrmStorBasVo vo)
			throws Exception {
		int ret = service.update(vo);
		if(ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
}

	/**
	*
	* @author 김성태
	* @date 2022. 5. 16.
	* @param id
	* @return
	* @throws Exception
	* @description CRM매장기본 삭제
	*
	*/
	@DeleteMapping("/{storNo}")
	@Operation(summary = "CRM매장기본 삭제", description = "CRM매장기본 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmStorBas(
			@Parameter(description = "매장번호") @PathVariable("storNo") String storNo)
			throws Exception {
		CrmStorBasVo vo = new CrmStorBasVo();
		vo.setStorNo(storNo);
		int ret = service.delete(vo);
		if(ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
}

}
