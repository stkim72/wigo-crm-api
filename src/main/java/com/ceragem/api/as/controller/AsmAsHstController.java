package com.ceragem.api.as.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.as.model.AsmAsHstSo;
import com.ceragem.api.as.model.AsmAsHstVo;
import com.ceragem.api.as.model.AsmAsSubmitBasHstCountVo;
import com.ceragem.api.as.model.AsmAsSubmitBasHstSo;
import com.ceragem.api.as.model.AsmAsSubmitBasHstVo;
import com.ceragem.api.as.service.AsmAsHstService;
import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @ClassName AsmAsHstController
 * @author 이윤성
 * @date 2022. 5. 20.
 * @Version 1.0
 * @description AS이력 Controller
 */

@Tag(name = "AS이력", description = "AS이력 API")
@RestController
@RequestMapping("/as/v1.0/history")
public class AsmAsHstController extends BaseRestController {

	@Autowired
	AsmAsHstService service;

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 5. 20.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description AS이력 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "AS이력 검색", description = "AS이력 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<AsmAsHstVo>>> getAsmHistoryList(
			@Parameter(description = "AS이력 검색객체") @Valid AsmAsHstSo so) throws Exception {

		EzMap param = new EzMap(so);

		// AS이력목록 조회
		List<AsmAsHstVo> list = service.getList(param);

		// AS이력목록 TotalCount
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);

		if (Utilities.isEmpty(list)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 5. 20.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description AS이력단건 검색
	 *
	 */
	@GetMapping("/{itgCustNo}/{asSubmitNo}")
	@Operation(summary = "AS이력 단건", description = "AS이력 단건 검색 예시 : 통합고객번호(857545), AS접수번호(334455)")
	public ResponseEntity<ApiResultVo<AsmAsSubmitBasHstVo>> getAsmHistoryDetail(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "AS접수번호") @PathVariable("asSubmitNo") String asSubmitNo) throws Exception {

		AsmAsSubmitBasHstSo so = new AsmAsSubmitBasHstSo();
		so.setItgCustNo(itgCustNo);
		so.setAsSubmitNo(asSubmitNo);

		// AS이력상세 조회
		AsmAsSubmitBasHstVo vo = service.get(so);

		if (vo == null) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		return successResponse(vo);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 15.
	 * @param (필수) 통합고객번호
	 * @return
	 * @throws Exception
	 * @description AS이력 건수(총건수, 취소건수) API
	 *
	 */
	@GetMapping("/count/{itgCustNo}")
	@Operation(summary = "AS이력 건수 API (총건수, 취소건수)", description = "AS이력 건수(총건수, 취소건수) API")
	public ResponseEntity<ApiResultVo<AsmAsSubmitBasHstCountVo>> selectAsHistoryCount(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo) throws Exception {

		// 검색객체
		AsmAsSubmitBasHstSo so = new AsmAsSubmitBasHstSo();
		so.setItgCustNo(itgCustNo);

		// AS이력상세 조회
		AsmAsSubmitBasHstCountVo vo = service.selectAsHistoryCount(so);

		if (vo == null) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		return successResponse(vo);
	}

}
