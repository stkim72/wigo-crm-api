package com.ceragem.api.ctc.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.ctc.model.ConsultHstInqryDetailSendVo;
import com.ceragem.api.ctc.model.ConsultHstInqrySendSo;
import com.ceragem.api.ctc.model.ConsultHstInqrySendVo;
import com.ceragem.api.ctc.service.ConsultHstInqrySendService;
import com.ceragem.crm.common.model.EzApiException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName
 * @author 임형진
 * @date 2022. 5. 10.
 * @Version 1.0
 * @description CRM고객 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CTC고객", description = "CTC API")
@RestController
@RequestMapping("/ctc/v1.0/history")
public class ConsultHstInqrySendController extends BaseRestController {

	@Autowired
	ConsultHstInqrySendService service;

	/**
	 *
	 * @author 임형진
	 * @date 2022. 5. 11
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 상담이력조회
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "상담이력조회", description = "상담이력조회")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<ConsultHstInqrySendVo>>> selectHst(
			@Valid ConsultHstInqrySendSo so, @RequestParam Map<String, Object> param) throws Exception {

		List<ConsultHstInqrySendVo> list = service.selectList(param);

		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}
	

	
	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 15.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM주의고객이력단건 검색
	 *
	 */
	@GetMapping("/{cnslHistNo}")
	@Operation(summary = "상담이력상세", description = "상담이력상세")
	public ResponseEntity<ApiResultVo<ConsultHstInqryDetailSendVo>> selectHstDetail(
			@Parameter(description = "상담이력상세") @PathVariable("cnslHistNo") String cnslHistNo)
			throws Exception {
		ConsultHstInqrySendSo so = new ConsultHstInqrySendSo();
		so.setCnslHistNo(cnslHistNo);
		ConsultHstInqryDetailSendVo vo = service.selectListDetail(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}
	
	
	
}
