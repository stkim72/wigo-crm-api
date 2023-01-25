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
import com.ceragem.api.crm.model.CrmMshipPromBasSo;
import com.ceragem.api.crm.model.CrmMshipPromBasVo;
import com.ceragem.api.crm.service.CrmMshipPromBasService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmMshipPromBasController
 * @author 김성태
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description CRM멤버십프로모션기본 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM멤버십프로모션", description = "CRM멤버십프로모션 API")
@RestController
@RequestMapping("/crm/v1.0/promotion")
public class CrmMshipPromBasController extends BaseRestController {

	@Autowired
	CrmMshipPromBasService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 6. 20.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십프로모션기본 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM멤버십프로모션 목록", description = "프로모션목록")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmMshipPromBasVo>>> getCrmCustBasList(
			@Parameter(description = "CRM멤버십프로모션기본 검색객체") @ParameterObject @Valid CrmMshipPromBasSo so)
			throws Exception {
		if (Utilities.isEmpty(so.getStdDt()))
			so.setStdDt(Utilities.getDateString());
		so.setStatusCd("002");
		EzMap param = new EzMap(so);
		List<CrmMshipPromBasVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 6. 20.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM멤버십프로모션기본단건 검색
	 *
	 */
	@GetMapping("/{mshipPromBasNo}")
	@Operation(summary = "CRM멤버십프로모션 단건", description = "CRM멤버십프로모션 단건 검색")
	public ResponseEntity<ApiResultVo<CrmMshipPromBasVo>> getCrmMshipPromBas(
			@Parameter(description = "멤버십프로모션기본번호") @PathVariable("mshipPromBasNo") String mshipPromBasNo)
			throws Exception {
		CrmMshipPromBasSo so = new CrmMshipPromBasSo();
		so.setMshipPromBasNo(mshipPromBasNo);
		CrmMshipPromBasVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

}
