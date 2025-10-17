package com.ceragem.api.as.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.as.model.AsmBosContractVo;
import com.ceragem.api.as.model.AsmBosExchngCmptHstVo;
import com.ceragem.api.as.model.AsmBosInstallHstVo;
import com.ceragem.api.as.model.AsmCustVo;
import com.ceragem.api.as.model.AsmMngAddrChngHstVo;
import com.ceragem.api.as.model.AsmRgitvInspHstVo;
import com.ceragem.api.as.model.AsmRgitvInspRsltVo;
import com.ceragem.api.as.service.AsmBosService;
import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @ClassName AsmBosController
 * @author 이윤성
 * @date 2022. 5. 30.
 * @Version 1.0
 * @description CRM-BOS인터페이스 Controller
 */
@Slf4j
@Tag(name = "CRM-BOS인터페이스", description = "CRM-BOS인터페이스 API")
@RestController
@RequestMapping("/as/v1.0/bos")
public class AsmBosController extends BaseRestController {

	@Autowired
	AsmBosService asmBosService;

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 8.
	 * @param (필수) CRM고객번호
	 * @param (선택) 주문번호
	 * @param (선택) 계약번호
	 * @param (선택) 판매유형
	 * @return
	 * @throws Exception
	 * @description BOS계약내역 목록 조회 (API ID : IF-BOS-013)
	 *
	 */
	@GetMapping("/contract-list/{crmCustNo}")
	// @GetMapping("/contract-list")
	@Operation(summary = "BOS계약내역 목록 조회", description = "BOS계약내역 목록 조회 API", hidden = true)
	public ResponseEntity<ApiResultVo<AsmBosContractVo>> selectCntrList(
			@Parameter(description = "CRM고객번호") @PathVariable("crmCustNo") String crmCustNo,
			// @Parameter(description = "CRM고객번호") @RequestParam(name =
			// "crmCustNo", required = true) String crmCustNo,
			@Parameter(description = "주문번호") @RequestParam(name = "ordNo", required = false) String ordNo,
			@Parameter(description = "계약번호") @RequestParam(name = "cntrNo", required = false) String cntrNo,
			@Parameter(description = "판매유형") @RequestParam(name = "saleTyCd", required = false) String saleTyCd)
			throws Exception {

		EzMap param = new EzMap();

		log.debug("crmCustNo: " + crmCustNo);
		log.debug("cntrNo: " + cntrNo);

		param.put("crmCustNo", crmCustNo);
		param.put("ordNo", ordNo);
		param.put("cntrNo", cntrNo);
		param.put("saleTyCd", saleTyCd);

		// 판매유형
		/*
		 * 1202:홈체험,1401:렌탈,1402:유상체험 후 렌탈, 1403:렌탈(보상판매),1404:유상체험 후 렌탈(보상판매),
		 * 2101:일시불판매,2102:유상체험 후 일시불, 2103:일시불(보상판매),2104:유상체험 후 일시불(보상판매), 2401:선수납판매
		 */

		// BOS계약내역 목록 조회
		AsmBosContractVo asmBosContractVo = asmBosService.selectCntrList(param);

		if (Utilities.isEmpty(asmBosContractVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmBosContractVo);
	}

	/**
	 *
	 * @author 조기현
	 * @date 2023. 9. 27.
	 * @param (필수) 계약번호
	 * @return
	 * @throws Exception
	 * @description BOS계약 상세조회 (API ID : IF-BOS-014)
	 *
	 */
	@GetMapping("/contract-detail/{cntrNo}")
	@Operation(summary = "BOS계약 상세조회", description = "BOS계약 상세조회 API", hidden = true)
	public ResponseEntity<ApiResultVo<AsmBosContractVo>> selectCntrDtl(
			@Parameter(description = "계약번호") @PathVariable(name = "cntrNo") String cntrNo)
			throws Exception {

		EzMap param = new EzMap();
		log.debug("cntrNo: " + cntrNo);
		param.put("cntrNo", cntrNo);

		// BOS계약내역 상세조회
		AsmBosContractVo asmBosContractVo = asmBosService.selectCntrDtl(param);

		if (Utilities.isEmpty(asmBosContractVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmBosContractVo);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 5. 30.
	 * @param CRM고객번호
	 * @return
	 * @throws Exception
	 * @description BOS고객상세조회 (API ID : IF-BOS-010)
	 *
	 */
	@GetMapping("/cust/{crmCustNo}")
	@Operation(summary = "BOS	상세조회", description = "BOS고객상세조회", hidden = true)
	public ResponseEntity<ApiResultVo<List<AsmCustVo>>> getBosApi010(
			@Parameter(description = "CRM고객번호") @PathVariable("crmCustNo") String crmCustNo)
			throws Exception {
		log.debug("crmCustNo : " + crmCustNo);
		// BOS고객상세조회
		List<AsmCustVo> asmCustVo = asmBosService.getCustDetail(crmCustNo);

		if (Utilities.isEmpty(asmCustVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmCustVo);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 9.
	 * @param 계약번호
	 * @return
	 * @throws Exception
	 * @description 교환 완료 이력 조회 (API ID : IF-BOS-030)
	 *
	 */
	@GetMapping("/exchng-cmpt-hst")
	@Operation(summary = "교환 완료 이력 조회", description = "교환 완료 이력 조회 API", hidden = true)
	public ResponseEntity<ApiResultVo<AsmBosExchngCmptHstVo>> selectAsExchEndHst(
			@Parameter(description = "계약번호") @RequestParam(name = "cntrNo", required = false) String cntrNo,
			@Parameter(description = "CRM고객번호") @RequestParam(name = "crmCustNo", required = false) String crmCustNo)
			throws Exception {

		// BOS계약내역 목록 조회
		AsmBosExchngCmptHstVo asmBosExchngCmptHstVo = asmBosService.selectAsExchEndHst(cntrNo,
				crmCustNo);

		if (Utilities.isEmpty(asmBosExchngCmptHstVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmBosExchngCmptHstVo);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 14.
	 * @param (필수) crmCustNo : CRM고객번호
	 * @param (선택) procBhf : 처리지점
	 * @param (선택) dueFrDe : 처리일자(시작일)
	 * @param (선택) dueToDe : 처리일자(종료일)
	 * @param (선택) procEngr : 처리기사
	 * @param (선택) cntrNo : 계약번호
	 * @return
	 * @throws Exception
	 * @description 정기점검 처리 결과 정보조회 (API ID : IF-BOS-026)
	 *
	 */
	@GetMapping("/rgitv-insp-rslt")
	@Operation(summary = "정기점검 처리 결과 정보조회", description = "정기점검 처리 결과 정보조회 API", hidden = true)
	public ResponseEntity<ApiResultVo<AsmRgitvInspRsltVo>> selectServiceProcList(
			@Parameter(description = "CRM고객번호") @RequestParam(name = "crmCustNo", required = false) String crmCustNo,
			@Parameter(description = "처리지점") @RequestParam(name = "procBhf", required = false) String procBhf,
			@Parameter(description = "처리일자(시작일)") @RequestParam(name = "dueFrDe", required = false) String dueFrDe,
			@Parameter(description = "처리일자(종료일)") @RequestParam(name = "dueToDe", required = false) String dueToDe,
			@Parameter(description = "처리기사") @RequestParam(name = "procEngr", required = false) String procEngr,
			@Parameter(description = "계약번호") @RequestParam(name = "cntrNo", required = false) String cntrNo)
			throws Exception {

		EzMap param = new EzMap();
		param.put("crmCustNo", crmCustNo); // (필수) CRM고객번호
		param.put("procBhf", procBhf); // (선택) 처리지점
		param.put("dueFrDe", dueFrDe); // (선택) 처리일자(시작일)
		param.put("dueToDe", dueToDe); // (선택) 처리일자(종료일)
		param.put("procEngr", procEngr); // (선택) 처리기사
		param.put("cntrNo", cntrNo); // (선택) 계약번호

		// 정기점검 처리 결과 조회
		AsmRgitvInspRsltVo asmRgitvInspRsltVo = asmBosService.selectServiceProcList(param);

		if (Utilities.isEmpty(asmRgitvInspRsltVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmRgitvInspRsltVo);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 17.
	 * @param (필수) cntrNo : 계약번호
	 * @return
	 * @throws Exception
	 * @description 정기점검 방문 이력 조회 (API ID : IF-BOS-027)
	 *
	 */
	@GetMapping("/rgitv-insp-hst")
	@Operation(summary = "정기점검 방문 이력 조회", description = "정기점검 방문 이력 조회 API", hidden = true)
	public ResponseEntity<ApiResultVo<AsmRgitvInspHstVo>> selectServiceVisitHstList(
			@Parameter(description = "계약번호") @RequestParam(name = "cntrNo", required = false) String cntrNo,
			@Parameter(description = "CRM고객번호") @RequestParam(name = "crmCustNo", required = false) String crmCustNo)
			throws Exception {

		// 정기점검 방문 이력 조회
		AsmRgitvInspHstVo asmRgitvInspHstVo = asmBosService.selectServiceVisitHstList(cntrNo,
				crmCustNo);
		if (Utilities.isEmpty(asmRgitvInspHstVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmRgitvInspHstVo);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 21.
	 * @param (필수) crmCustNo : 통합고객번호
	 * @return
	 * @throws Exception
	 * @description 설치이력 - 신규설치API(IF-BOS-054), 제품교환API(IF-BOS-055),
	 *              반환API(IF-BOS-056)
	 *
	 */
	@GetMapping("/install-hst")
	@Operation(summary = "설치이력 조회", description = "설치이력 조회 API", hidden = true)
	public ResponseEntity<ApiResultVo<AsmBosInstallHstVo>> selectInstallHst(
			@Parameter(description = "계약번호") @RequestParam(name = "cntrNo", required = false) String cntrNo,
			@Parameter(description = "CRM고객번호") @RequestParam(name = "crmCustNo", required = false) String crmCustNo)
			throws Exception {

		// 설치이력 조회
		AsmBosInstallHstVo asmBosInstallHstVo = asmBosService.selectInstallHst(crmCustNo, cntrNo);

		if (Utilities.isEmpty(asmBosInstallHstVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmBosInstallHstVo);
	}

	/**
	 *
	 * @author 이윤성
	 * @date 2022. 6. 23.
	 * @param (필수) crmCustNo : CRM고객번호
	 * @param (필수) cntrNo : 계약번호
	 * @return
	 * @throws Exception
	 * @description 관리주소변경이력 (API ID : IF-BOS-057)
	 *
	 */
	@GetMapping("/mng-addr/chnghst")
	@Operation(summary = "관리주소변경이력", description = "관리주소변경이력 API", hidden = true)
	public ResponseEntity<ApiResultVo<AsmMngAddrChngHstVo>> selectEqpChgMngHstList(
			@Parameter(description = "계약번호") @RequestParam(name = "cntrNo", required = false) String cntrNo,
			@Parameter(description = "CRM고객번호") @RequestParam(name = "crmCustNo", required = false) String crmCustNo)
			throws Exception {

		// 관리주소변경이력 조회
		AsmMngAddrChngHstVo asmMngAddrChngHstVo = asmBosService.selectEqpChgMngHstList(crmCustNo,
				cntrNo);

		if (Utilities.isEmpty(asmMngAddrChngHstVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(asmMngAddrChngHstVo);
	}
}
