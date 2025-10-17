package com.ceragem.api.ctc.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.ctc.model.CtcInquirySo;
import com.ceragem.api.ctc.model.CtcInquiryVo;
import com.ceragem.api.ctc.service.CtcInquiryService;
import com.ceragem.crm.common.model.EzApiException;

import io.swagger.v3.oas.annotations.Operation;
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

@Tag(name = "문의접수", description = "문의접수")
@RestController
@RequestMapping("/ctc/v1.0/inquiry")
public class CtcInquiryController extends BaseRestController{


	@Autowired
	CtcInquiryService service;

	/**
	 *
	 * @author 임형진
	 * @date 2022. 7. 06
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 문의접수 조회
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "문의접수 조회", description = "문의접수 조회")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CtcInquiryVo>>> selectInquiry(
			@Valid CtcInquirySo so, @RequestParam Map<String, Object> param) throws Exception {

		List<CtcInquiryVo> list = service.selectList(param);

		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}
	

	
}
