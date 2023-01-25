package com.ceragem.api.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmStpltBasSo;
import com.ceragem.api.crm.model.CrmStpltBasVo;
import com.ceragem.api.crm.service.CrmStpltBasService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmStpltBasController
 * @author 김성태
 * @date 2022. 5. 23.
 * @Version 1.0
 * @description CRM약관 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM약관", description = "CRM약관")
@RestController
@RequestMapping("/crm/v1.0/terms")
public class CrmStpltBasController extends BaseRestController {

	@Autowired
	CrmStpltBasService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 5. 23.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM약관 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM약관 검색", description = "CRM약관 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmStpltBasVo>>> getCrmCustBasList(
			@Parameter(description = "CRM약관 검색객체")@ParameterObject  @Valid CrmStpltBasSo so) throws Exception {
		EzMap param = new EzMap(so);
		List<CrmStpltBasVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 5. 23.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM약관단건 검색
	 *
	 */
	@GetMapping("/{stpltNo}")
	@Operation(summary = "CRM약관 조회", description = "CRM약관 조회")
	public ResponseEntity<ApiResultVo<CrmStpltBasVo>> getCrmStpltBas(
			@Parameter(description = "약관번호") @PathVariable("stpltNo") String stpltNo) throws Exception {
		CrmStpltBasSo so = new CrmStpltBasSo();
		so.setStpltNo(stpltNo);
		CrmStpltBasVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

}
