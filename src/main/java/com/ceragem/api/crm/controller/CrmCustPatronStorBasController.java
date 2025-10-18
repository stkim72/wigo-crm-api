package com.ceragem.api.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.model.ApiVoidResultVo;
import com.ceragem.api.crm.model.CrmCustPatronStorBasVo;
import com.ceragem.api.crm.service.CrmCustPatronStorBasService;
import com.ceragem.crm.common.model.EzApiException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmCustPatronStorBasController
 * @author 김성태
 * @date 2022. 5. 16.
 * @Version 1.0
 * @description CRM고객단골매장 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM고객단골매장", description = "CRM고객단골매장 API")
@RestController
@RequestMapping("/crm/v1.0/customer-store")
public class CrmCustPatronStorBasController extends BaseRestController {

	@Autowired
	CrmCustPatronStorBasService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 5. 16.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객단골매장 입력
	 *
	 */
	@PostMapping("/{storNo}/{itgCustNo}")
	@Operation(summary = "CRM고객단골매장등록", description = "CRM고객단골매장등록")
	public ResponseEntity<ApiResultVo<CrmCustPatronStorBasVo>> registerCrmCustPatronStorBas(
			@Parameter(description = "매장번호") @PathVariable String storNo,
			@Parameter(description = "통합고객번호") @PathVariable String itgCustNo,
			@Parameter(description = "CRM고객단골매장 객체", hidden = true) @ModelAttribute CrmCustPatronStorBasVo vo)
			throws Exception {
		vo.setItgCustNo(itgCustNo);
		vo.setStorNo(storNo);
		int ret = service.insert(vo);
		if (ret == 0)
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
	 * @description CRM고객단골매장 삭제
	 *
	 */
	@DeleteMapping("/{storNo}/{itgCustNo}")
	@Operation(summary = "CRM고객단골매장삭제", description = "CRM고객단골매장삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmCustPatronStorBas(
			@Parameter(description = "매장번호") @PathVariable String storNo,
			@Parameter(description = "통합고객번호") @PathVariable String itgCustNo,
			@Parameter(description = "CRM고객단골매장 객체", hidden = true) @ModelAttribute CrmCustPatronStorBasVo vo)
			throws Exception {
		vo.setItgCustNo(itgCustNo);
		vo.setStorNo(storNo);
		int ret = service.deleteStore(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

}
