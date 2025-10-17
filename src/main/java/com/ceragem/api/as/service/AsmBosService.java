package com.ceragem.api.as.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.dao.AsmAsHstDao;
import com.ceragem.api.as.dao.IAsmDao;
import com.ceragem.api.as.model.AsmBosContractVo;
import com.ceragem.api.as.model.AsmBosExchngCmptHstVo;
import com.ceragem.api.as.model.AsmBosInstallHstVo;
import com.ceragem.api.as.model.AsmCustVo;
import com.ceragem.api.as.model.AsmMngAddrChngHstVo;
import com.ceragem.api.as.model.AsmRgitvInspHstVo;
import com.ceragem.api.as.model.AsmRgitvInspRsltVo;
import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractAsmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @ClassName AsmBosService
 * @author 이윤성
 * @date 2022. 5. 30.
 * @Version 1.0
 * @description CRM-BOS인터페이스 Service
 */
@Slf4j
@Service
public class AsmBosService extends AbstractAsmService {

	@Autowired
	AsmBosApiCallService asmBosApiCallService;

	@Autowired
	AsmAsHstDao dao;

	@Override
	public IAsmDao getDao() {
		return dao;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 5. 30.
	 * @param EzMap
	 * @return
	 * @throws Exception
	 * @description BOS계약내역 목록 조회
	 *
	 */
	public AsmBosContractVo selectCntrList(EzMap param) throws Exception {

		AsmBosContractVo asmBosContractVo = null;
		// 계약내역 목록 조회
		asmBosContractVo = asmBosApiCallService.selectCntrList(param);
		log.debug("asmBosContractVo ======>" + asmBosContractVo);

		return asmBosContractVo;
	}

	/**
	 * @author 조기현
	 * @date 2023. 9. 27.
	 * @param EzMap
	 * @return
	 * @throws Exception
	 * @description BOS계약 상세조회
	 *
	 */
	public AsmBosContractVo selectCntrDtl(EzMap param) throws Exception {

		AsmBosContractVo asmBosContractVo = null;

		// 계약내역 목록 조회
		asmBosContractVo = asmBosApiCallService.selectCntrDtl(param);
		log.debug("asmBosContractVo ======>" + asmBosContractVo);

		return asmBosContractVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 5. 30.
	 * @param 고객번호
	 * @return
	 * @throws Exception
	 * @description BOS고객상세조회
	 *
	 */
	public List<AsmCustVo> getCustDetail(String crmCustNo) throws Exception {

		// 통합고객번호 필수
		if (Utilities.isEmpty(crmCustNo)) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM,
					Constants._API_CODE_INVALID_PARAM_MSG);
		}

		List<AsmCustVo> asmCustVo = null;
		asmCustVo = asmBosApiCallService.getCustDtl(crmCustNo);

		return asmCustVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 9.
	 * @param 계약번호
	 * @return
	 * @throws Exception
	 * @description 교환 완료 이력 조회
	 *
	 */
	public AsmBosExchngCmptHstVo selectAsExchEndHst(String cntrNo, String crmCustNo)
			throws Exception {

		AsmBosExchngCmptHstVo asmBosExchngCmptHstVo = null;
		// 교환 완료 이력 조회
		asmBosExchngCmptHstVo = asmBosApiCallService.selectAsExchEndHst(cntrNo, crmCustNo);
		log.debug("asmBosExchngCmptHstVo ======>" + asmBosExchngCmptHstVo);

		return asmBosExchngCmptHstVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 14.
	 * @param EzMap
	 * @return
	 * @throws Exception
	 * @description 정기점검 처리 결과 정보조회
	 *
	 */
	public AsmRgitvInspRsltVo selectServiceProcList(EzMap param) throws Exception {

		AsmRgitvInspRsltVo asmRgitvInspRsltVo = null;

		asmRgitvInspRsltVo = asmBosApiCallService.selectServiceProcList(param);
		log.debug("asmRgitvInspRsltVo ======>" + asmRgitvInspRsltVo);

		return asmRgitvInspRsltVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 17.
	 * @param EzMap
	 * @return
	 * @throws Exception
	 * @description 정기점검 방문 이력 조회
	 *
	 */
	public AsmRgitvInspHstVo selectServiceVisitHstList(String cntrNo, String crmCustNo)
			throws Exception {

		AsmRgitvInspHstVo asmRgitvInspHstVo = null;
		// 이력 조회
		asmRgitvInspHstVo = asmBosApiCallService.selectServiceVisitHstList(cntrNo, crmCustNo);

		return asmRgitvInspHstVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 21.
	 * @param EzMap
	 * @return
	 * @throws Exception
	 * @description 설치이력 - 신규설치API(IF-BOS-054), 제품교환API(IF-BOS-055),
	 *              반환API(IF-BOS-056)
	 *
	 */
	public AsmBosInstallHstVo selectInstallHst(String crmCustNo, String cntrNo) throws Exception {

		AsmBosInstallHstVo asmBosInstallHstVo = null;
		// 설치이력(설치, 교환, 반환) 조회
		asmBosInstallHstVo = asmBosApiCallService.selectInstallHst(crmCustNo, cntrNo);

		return asmBosInstallHstVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 23.
	 * @param (필수) crmCustNo : CRM고객번호
	 * @param (필수) cntrNo : 계약번호
	 * @return
	 * @throws Exception
	 * @description 관리주소변경이력
	 *
	 */
	public AsmMngAddrChngHstVo selectEqpChgMngHstList(String crmCustNo, String cntrNo)
			throws Exception {

		AsmMngAddrChngHstVo asmMngAddrChngHstVo = null;
		// 이력 조회
		asmMngAddrChngHstVo = asmBosApiCallService.selectEqpChgMngHstList(crmCustNo, cntrNo);
		log.debug("asmMngAddrChngHstVo ======>" + asmMngAddrChngHstVo);

		return asmMngAddrChngHstVo;
	}
}
