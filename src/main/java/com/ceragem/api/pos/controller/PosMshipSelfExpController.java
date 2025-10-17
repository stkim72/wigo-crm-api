package com.ceragem.api.pos.controller;

import java.net.InetAddress;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.pos.model.PosExpCustListVo;
import com.ceragem.api.pos.model.PosExpListResultVo;
import com.ceragem.api.pos.model.PosExpListVo;
import com.ceragem.api.pos.model.PosExpResultVo;
import com.ceragem.api.pos.model.PosExpVo;
import com.ceragem.api.pos.service.PosMshipSelfExpService;
import com.ceragem.crm.common.model.EzApiException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @ClassName PosMshipSelfExpController
 * @author 최희원
 * @date 2023. 10. 10.
 * @Version 1.0
 * @description POS 체험대기등록 Controller
 */

@Tag(name = "POS 체험", description = "POS 체험대기등록 API")
@RestController
@RequestMapping("/pos/v1.0")
public class PosMshipSelfExpController extends BaseRestController {

	@Autowired
	PosMshipSelfExpService service;

	/**
	 *
	 * @author 최희원
	 * @date 2023. 10. 10.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description POS 체험대기등록 신청
	 *
	 */
	@PostMapping("/exp/wait-register")
	@Operation(summary = "POS 체험대기등록", description = "POS 체험대기등록")
	public ResponseEntity<ApiResultVo<PosExpResultVo>> getMshipSelfExpList(
			@Parameter(description = "POS 체험대기등록") @RequestBody @Valid PosExpVo vo) throws Exception {

		PosExpResultVo posExpResultVo = new PosExpResultVo();

		String langSetting = "ko-KR";
		String salesOrgCd = "9620";
		String cmpcd = "1000";

		vo.setLangSetting(langSetting);
		vo.setSalesOrgCd(salesOrgCd);
		vo.setCmpCd(cmpcd);
		vo.setRequestHostname(InetAddress.getLocalHost().getHostAddress());

		// vo.setTransactionId("posTransactionManager");

		posExpResultVo = service.selectExpWaitHour(vo);

		if (posExpResultVo == null) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		return successResponse(posExpResultVo);
	}

	/**
	 *
	 * @author 최희원
	 * @date 2023. 10. 10.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description POS 체험대기등록 조회
	 *
	 */
	@PostMapping("/exp/wait-list")
	@Operation(summary = "POS 체험대기고객 조회", description = "POS 체험대기고객 조회")
	public ResponseEntity<ApiResultVo<PosExpListResultVo>> getExpWaitList(
			@Parameter(description = "POS 체험대기고객 조회") @RequestBody @Valid PosExpListVo vo) throws Exception {

		PosExpListResultVo posExpListResultVo = new PosExpListResultVo();

		String langSetting = "ko-KR";
		String salesOrgCd = "9620";
		String cmpcd = "1000";

		vo.setLangSetting(langSetting);
		vo.setSalesOrgCd(salesOrgCd);
		vo.setCmpCd(cmpcd);
		vo.setRequestHostname(InetAddress.getLocalHost().getHostAddress());

		List<PosExpCustListVo> contList = service.getCustExpWaitList(vo);
		posExpListResultVo.setContList(contList);

		posExpListResultVo.setInterfaceId("INF_POS_002");
		posExpListResultVo.setResponseSystem("POS");
		posExpListResultVo.setResponseHostname(InetAddress.getLocalHost().getHostAddress());
		posExpListResultVo.setTransactionId("posTransactionManager");
		// 요청서버의 IP주소를 가져와서 응답서버에서 내려준다.
		Object ob = vo.getRequestHostname();
		posExpListResultVo.setRequestHostname(ob.toString());

		if (posExpListResultVo.getContList().isEmpty()) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		return successResponse(posExpListResultVo);
	}

}
