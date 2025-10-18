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
import com.ceragem.api.crm.model.CrmCustCntplcBasSo;
import com.ceragem.api.crm.model.CrmCustCntplcBasVo;
import com.ceragem.api.crm.model.CrmSnstvInfoInqrySo;
import com.ceragem.api.crm.service.CrmCustCntplcBasService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmCustCntplcBasController
 * @author 김성태
 * @date 2022. 4. 12.
 * @Version 1.0
 * @description CRM고객연락처 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM고객연락처", description = "CRM고객연락처 API")
@RestController
@RequestMapping("/crm/v1.0/customer-contact")
public class CrmCustCntplcBasController extends BaseRestController {
/*
 * 
 * public final static String API_CODE_CANNOT_DELETE = "IAR0501";
	public final static String API_CODE_CANNOT_DELETE_MSG = "대표 연락처는 삭제 할 수 없습니다.";
	public final static String API_CODE_CANNOT_UPDATE = "IAR0502";
	public final static String API_CODE_CANNOT_UPDATE_MSG = "대표 연락처는 일반 연락처로 변경 할 수 없습니다.";
 * 
 * */
	@Autowired
	CrmCustCntplcBasService service;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 12.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM고객연락처 검색", description = "CRM고객연락처 검색[개인정보취급자번호-indiInfoHandlPrsnNo,접속자IP주소-connPrsnIpAddr,수행업무코드-pfmWorkCd 모두 제공시 암호화 해제 후 전송]")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustCntplcBasVo>>> getCrmCustCntplcBasList(
			@Parameter(description = "CRM고객연락처 검색객체") @ParameterObject @Valid CrmCustCntplcBasSo so) throws Exception {

//		if (Utilities.isNotEmpty(so.getTelNo())) {
//			so.setTelNoEncVal(Utilities.encrypt(so.getTelNo()));
//			so.setTelNo(null);
//		}
		EzMap param = new EzMap(so);
		List<CrmCustCntplcBasVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 12.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처단건 검색
	 *
	 */
	@GetMapping("/{cntplcSeq}")
	@Operation(summary = "CRM고객연락처 단건", description = "CRM고객연락처 단건 검색[개인정보취급자번호-indiInfoHandlPrsnNo,접속자IP주소-connPrsnIpAddr,수행업무코드-pfmWorkCd 모두 제공시 암호화 해제 후 전송]")
	public ResponseEntity<ApiResultVo<CrmCustCntplcBasVo>> getCrmCustCntplcBas(
			@Parameter(description = "연락처일련번호") @PathVariable String cntplcSeq,
			@Parameter(description = "개인정보 취급자 정보") @ParameterObject CrmSnstvInfoInqrySo info) throws Exception {
		CrmCustCntplcBasSo so = new CrmCustCntplcBasSo();
		so.setSo(info);
		so.setCntplcSeq(cntplcSeq);
		CrmCustCntplcBasVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 12.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM고객연락처 입력", description = "CRM고객연락처 입력")
	public ResponseEntity<ApiResultVo<CrmCustCntplcBasVo>> registerCrmCustCntplcBas(
			@Parameter(description = "CRM고객연락처 객체") @RequestBody @Valid CrmCustCntplcBasVo vo) throws Exception {
		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		CrmCustCntplcBasSo so = new CrmCustCntplcBasSo();
		so.setForceDecrypt(true);
		so.setCntplcSeq(vo.getCntplcSeq());
		return successResponse(service.get(so));
	}
	
	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 12.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처 입력
	 *
	 */
	@PostMapping("list")
	@Operation(summary = "CRM고객연락처 일괄입력", description = "CRM고객연락처 입력")
	public ResponseEntity<ApiResultVo<List<CrmCustCntplcBasVo>>> registerCrmCustCntplcBasList(
			@Parameter(description = "CRM고객연락처 객체") @RequestBody @Valid List<CrmCustCntplcBasVo> list) throws Exception {
		List<CrmCustCntplcBasVo> ret = service.insertCntplcList(list);
		if (Utilities.isEmpty(ret))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 12.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처 수정
	 *
	 */
	@PutMapping("")
	@Operation(summary = "CRM고객연락처 수정", description = "CRM고객연락처 수정")
	public ResponseEntity<ApiResultVo<CrmCustCntplcBasVo>> modifyCrmCustCntplcBas(
			@Parameter(description = "CRM고객연락처 객체") @RequestBody @Valid CrmCustCntplcBasVo vo) throws Exception {
		int ret = service.update(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 12.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처 삭제
	 *
	 */
	@DeleteMapping("/{cntplcSeq}")
	@Operation(summary = "CRM고객연락처 삭제", description = "CRM고객연락처 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmCustCntplcBas(
			@Parameter(description = "연락처일련번호") @PathVariable String cntplcSeq) throws Exception {
		CrmCustCntplcBasVo vo = new CrmCustCntplcBasVo();
		vo.setCntplcSeq(cntplcSeq);
		int ret = service.delete(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

}
