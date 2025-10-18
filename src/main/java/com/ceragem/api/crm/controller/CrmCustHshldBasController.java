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
import com.ceragem.api.crm.model.CrmCustHshldBasSo;
import com.ceragem.api.crm.model.CrmCustHshldBasVo;
import com.ceragem.api.crm.model.CrmSnstvInfoInqrySo;
import com.ceragem.api.crm.service.CrmCustHshldBasService;
import com.ceragem.crm.common.model.EzApiException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmCustHshldBasController
 * @author 김성태
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM가족결합 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM고객가족결합", description = "CRM가족결합 API")
@RestController
@RequestMapping("/crm/v1.0/customer-bond")
public class CrmCustHshldBasController extends BaseRestController {

	@Autowired
	CrmCustHshldBasService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 11.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM가족결합 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM가족결합 검색", description = "CRM가족결합 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustHshldBasVo>>> getCrmCustHshldBasList(
			@Parameter(description = "CRM가족결합 검색객체") @ParameterObject @Valid CrmCustHshldBasSo so) throws Exception {
		List<CrmCustHshldBasVo> list = service.getList(so);
		int cnt = service.getListCount(so);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 11.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM가족결합단건 검색
	 *
	 */
	@GetMapping("/{itgCustNo}")
	@Operation(summary = "CRM가족결합 단건", description = "CRM가족결합 단건 검색")
	public ResponseEntity<ApiResultVo<CrmCustHshldBasVo>> getCrmCustHshldBas(
			@Parameter(description = "통합고객번호") @PathVariable String itgCustNo,
			@Parameter(description = "개인정보 취급자 정보") @ParameterObject CrmSnstvInfoInqrySo info) throws Exception {
		CrmCustHshldBasSo so = new CrmCustHshldBasSo();
		so.setSo(info);
		so.setItgCustNo(itgCustNo);
		CrmCustHshldBasVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 11.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM가족결합 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM가족결합 입력", description = "CRM가족결합 입력")
	public ResponseEntity<ApiResultVo<CrmCustHshldBasVo>> registerCrmCustHshldBas(
			@Parameter(description = "CRM가족결합 객체") @RequestBody @Valid CrmCustHshldBasVo vo) throws Exception {
		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 11.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM가족결합 수정
	 *
	 */
	@PutMapping("")
	@Operation(summary = "CRM가족결합 수정", description = "CRM가족결합 수정")
	public ResponseEntity<ApiResultVo<CrmCustHshldBasVo>> modifyCrmCustHshldBas(
			@Parameter(description = "CRM가족결합 객체") @RequestBody @Valid CrmCustHshldBasVo vo) throws Exception {
		int ret = service.update(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 11.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM가족결합 삭제
	 *
	 */
	@DeleteMapping("/{itgCustNo}")
	@Operation(summary = "CRM가족결합 탈퇴", description = "CRM가족결합 탈퇴")
	public ResponseEntity<ApiVoidResultVo> removeCrmCustHshldBas(
			@Parameter(description = "통합고객번호") @PathVariable String itgCustNo) throws Exception {
		CrmCustHshldBasVo vo = new CrmCustHshldBasVo();
		vo.setItgCustNo(itgCustNo);
		int ret = service.delete(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

}
