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
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmMshipLoginHstSo;
import com.ceragem.api.crm.model.CrmMshipLoginHstVo;
import com.ceragem.api.crm.service.CrmMshipLoginHstService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmMshipLoginHstController
 * @author 김성태
 * @date 2023. 3. 31.
 * @Version 1.0
 * @description CRM사용자로그인이력 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Hidden
@Tag(name = "CRM사용자로그인이력", description = "CRM사용자로그인이력 API")
@RestController
@RequestMapping("/crm/v1.0/crm-mship-login-hst")
public class CrmMshipLoginHstController extends BaseRestController {

	@Autowired
	CrmMshipLoginHstService service;

	/**
	 *
	 * @author 김성태
	 * @date 2023. 3. 31.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM사용자로그인이력 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM사용자로그인이력 검색", description = "CRM사용자로그인이력 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmMshipLoginHstVo>>> getCrmCustBasList(
			@Parameter(description = "CRM사용자로그인이력 검색객체") @ParameterObject @Valid CrmMshipLoginHstSo so)
			throws Exception {
		EzMap param = new EzMap(so);
		List<CrmMshipLoginHstVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2023. 3. 31.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM사용자로그인이력단건 검색
	 *
	 */
	@GetMapping("/{loginHstId}")
	@Operation(summary = "CRM사용자로그인이력 단건", description = "CRM사용자로그인이력 단건 검색")
	public ResponseEntity<ApiResultVo<CrmMshipLoginHstVo>> getCrmMshipLoginHst(
			@Parameter(description = "로그인이력ID") @PathVariable String loginHstId) throws Exception {
		CrmMshipLoginHstSo so = new CrmMshipLoginHstSo();
		so.setLoginHstId(loginHstId);
		CrmMshipLoginHstVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2023. 3. 31.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM사용자로그인이력 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM사용자로그인이력 입력", description = "CRM사용자로그인이력 입력")
	public ResponseEntity<ApiResultVo<CrmMshipLoginHstVo>> registerCrmMshipLoginHst(
			@Parameter(description = "CRM사용자로그인이력 객체") @RequestBody @Valid CrmMshipLoginHstVo vo) throws Exception {
		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2023. 3. 31.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM사용자로그인이력 수정
	 *
	 */
	@PutMapping("")
	@Operation(summary = "CRM사용자로그인이력 수정", description = "CRM사용자로그인이력 수정")
	public ResponseEntity<ApiResultVo<CrmMshipLoginHstVo>> modifyCrmMshipLoginHst(
			@Parameter(description = "CRM사용자로그인이력 객체") @RequestBody @Valid CrmMshipLoginHstVo vo) throws Exception {
		int ret = service.update(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2023. 3. 31.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM사용자로그인이력 삭제
	 *
	 */
	@DeleteMapping("/{loginHstId}")
	@Operation(summary = "CRM사용자로그인이력 삭제", description = "CRM사용자로그인이력 삭제")
	public ResponseEntity<ApiResultVo<Object>> removeCrmMshipLoginHst(
			@Parameter(description = "로그인이력ID") @PathVariable String loginHstId) throws Exception {
		CrmMshipLoginHstVo vo = new CrmMshipLoginHstVo();
		vo.setLoginHstId(loginHstId);
		int ret = service.delete(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(null);
	}

}
