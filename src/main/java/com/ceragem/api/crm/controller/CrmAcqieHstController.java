package com.ceragem.api.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.model.ApiVoidResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmAcqieHstSo;
import com.ceragem.api.crm.model.CrmAcqieHstVo;
import com.ceragem.api.crm.service.CrmAcqieHstService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmAcqieHstController
 * @author 김성태
 * @date 2022. 8. 17.
 * @Version 1.0
 * @description CRM지인이력 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM 지인", description = "CRM 지인 API")
@RestController
@RequestMapping("/crm/v1.0/crm-acqie")
public class CrmAcqieHstController extends BaseRestController {

	@Autowired
	CrmAcqieHstService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 8. 17.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM지인이력 검색
	 *
	 */
	@GetMapping("/{itgCustNo}")
	@Operation(summary = "CRM지인 검색", description = "CRM지인 검색")
	public ResponseEntity<ApiResultVo<List<CrmAcqieHstVo>>> getCrmCustBasList(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo) throws Exception {
		CrmAcqieHstSo so = new CrmAcqieHstSo();
		so.setItgCustNo(itgCustNo);
		EzMap param = new EzMap(so);
		List<CrmAcqieHstVo> list = service.getList(param);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 8. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM지인이력 입력
	 *
	 */
	@PostMapping("/{itgCustNo}/{acqieItgCustNo}")
	@Operation(summary = "CRM지인 입력", description = "CRM지인 입력")
	public ResponseEntity<ApiVoidResultVo> registerCrmAcqieHst(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "지인통합고객번호") @PathVariable("acqieItgCustNo") String acqieItgCustNo)
			throws Exception {
		if(itgCustNo.equals(acqieItgCustNo))
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "자기 자신을 지인으로 등록할 수 없습니다.");
		CrmAcqieHstVo vo = new CrmAcqieHstVo();
		vo.setItgCustNo(itgCustNo);
		vo.setAcqieItgCustNo(acqieItgCustNo);
		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 8. 17.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM지인이력 삭제
	 *
	 */
	@DeleteMapping("/{acqieHstSeq}")
	@Operation(summary = "CRM지인 삭제", description = "CRM지인 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmAcqieHst(
			@Parameter(description = "지인이력일련번호") @PathVariable("acqieHstSeq") String acqieHstSeq) throws Exception {
		CrmAcqieHstVo vo = new CrmAcqieHstVo();
		vo.setAcqieHstSeq(acqieHstSeq);
		int ret = service.delete(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

}
