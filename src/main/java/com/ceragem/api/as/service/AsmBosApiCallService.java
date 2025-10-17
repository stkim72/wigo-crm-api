package com.ceragem.api.as.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.dao.AsmBosHstDao;
import com.ceragem.api.as.dao.IAsmDao;
import com.ceragem.api.as.model.AsmBosContractListVo;
import com.ceragem.api.as.model.AsmBosContractVo;
import com.ceragem.api.as.model.AsmBosExchngCmptHstListVo;
import com.ceragem.api.as.model.AsmBosExchngCmptHstVo;
import com.ceragem.api.as.model.AsmBosInstallHst01ListVo;
import com.ceragem.api.as.model.AsmBosInstallHst02ListVo;
import com.ceragem.api.as.model.AsmBosInstallHst03ListVo;
import com.ceragem.api.as.model.AsmBosInstallHstListVo;
import com.ceragem.api.as.model.AsmBosInstallHstVo;
import com.ceragem.api.as.model.AsmCustVo;
import com.ceragem.api.as.model.AsmMngAddrChngHstListVo;
import com.ceragem.api.as.model.AsmMngAddrChngHstVo;
import com.ceragem.api.as.model.AsmRgitvInspHstListVo;
import com.ceragem.api.as.model.AsmRgitvInspHstVo;
import com.ceragem.api.as.model.AsmRgitvInspRsltListVo;
import com.ceragem.api.as.model.AsmRgitvInspRsltVo;
import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractAsmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @ClassName AsmBosApiCallService
 * @author 이윤성
 * @date 2022. 5. 31.
 * @Version 1.0
 * @description BOS Restful API Call Service
 */
@Slf4j
@Service
public class AsmBosApiCallService extends AbstractAsmService {

	// BOS API URL
	@Value("${bos.api.rest-url}")
	String restUrl;
	@Value("${bos.api.rental-url}")
	String newUrl;
	@Value("${bos.api.rental-id}")
	String rentalId;
	@Value("${bos.api.rental_pwd}")
	String rentalPwd;

	// (임시 - YML 에 셋팅 예정) BOS API URL
	// String restUrl = "https://ceragem-dmapi.wjcloud.co.kr"; (개발 접근안됨)
	// String restUrl = "https://mapone.ceragem.com"; // 우선 검증계로 연결

	// (IF-BOS-001) 랜덤키 생성 API URL
	String randomKeyUrl = "/crm/CRM_API_0001Ctl/getRandomKey.do";
	// (IF-BOS-010) 고객 상세 조회 API URL
	String selectCustDtlUrl = "/crm/CRM_API_0004Ctl/selectCustDtl.do";
	String selectCustDtlIFID = "IF-1-001";
	// (IF-BOS-013) 계약내역 목록 조회 API URL
	String selectCntrList = "/crm/CRM_API_0005Ctl/selectCntrList.do";
	String selectCntrListIFID = "IF-3-001";
	// (IF-BOS-014) 계약상세 조회 API URL
	String selectCntrDtl = "/crm/CRM_API_0006Ctl/selectCntrDtl.do";
	String selectCntrDtlIFID = "IF-3-002";
	// (IF-BOS-030) 교환 완료 이력 조회
	String selectAsExchEndHst = "/crm/CRM_API_0043Ctl/selectAsExchEndHst.do";
	String selectAsExchEndHstIFID = "IF-6-014";
	// (IF-BOS-026) 정기점검 처리 결과 정보조회
	String selectServiceProcList = "/crm/CRM_API_0035Ctl/selectServiceProcList.do";
	String selectServiceProcListIFID = "IF-6-113";
	// (IF-BOS-027) 정기점검 방문 이력 조회
	String selectServiceVisitHstList = "/crm/CRM_API_0036Ctl/selectServiceVisitHstList.do";
	String selectServiceVisitHstListIFID = "IF-6-114";
	// (IF-BOS-054) A/S 처리결과 리스트(상담)
	String selectAsProcRsltList = "/crm/CRM_API_0016Ctl/selectAsProcRsltList.do";
	String selectAsProcRsltListIFID = "IF-6-003";
	// (IF-BOS-055) 설치결과등록 리스트(상담)
	String selectIstRsltRegList = "/crm/CRM_API_0017Ctl/selectIstRsltRegList.do";
	String selectIstRsltRegListIFID = "IF-6-004";
	// (IF-BOS-056) 반환결과등록 리스트(상담)
	String selectRtnRsltRegList = "/crm/CRM_API_0018Ctl/selectRtnRsltRegList.do";
	String selectRtnRsltRegListIFID = "IF-6-005";

	// (IF-BOS-057) 관리주소 변경이력 조회
	String selectEqpChgMngHstList = "/crm/CRM_API_0055Ctl/selectEqpChgMngHstList.do";
	String selectEqpChgMngHstListIFID = "IF-1-004";

	// CRM사용자 ID
	static String crmUsrId = "ASM";
	// Locale 구분
	static String usrLocale = "ko";
	// CRM 구분
	static String crmYn = "Y";

	static String username = "CRMAPI";

	// (ASM 공통) Restful API Call Service
	@Autowired
	AsmRestApiCallService restApiCallService;

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;

	@Autowired
	AsmBosHstDao dao;

	@Override
	public IAsmDao getDao() {
		return dao;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 5. 31.
	 * @param
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] API 랜덤키 생성
	 *
	 */
	public String getRandomKey() throws Exception {

		String randomKey = "";

		// Request Header 요청값 (헤더에 crmUsrId 추가해야 된다고함)
		EzMap header = reqHeaderParam(null);

		// Request Body 요청값 (랜덤키 요청시 param 없음)
		EzMap postData = reqParamData(null, null);

		// BOS Api 랜덤키 요청
		String resJsonData = restApiCallService.httpCallApi(restUrl + randomKeyUrl, postData,
				"POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		String rtnMsg = (String) map.get("rtnMsg");
		String rtnCode = (String) map.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류

		if ("0".equals(rtnCode)) {
			randomKey = (String) map.get("randomKey"); // (랜덤키) 사전약속된 암호화 값
		} else {
			// 랜덤키 생성 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("[%s]%s", rtnCode, rtnMsg));
		}
		return randomKey;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 5. 31.
	 * @param randomKey : (필수 랜덤키) 사전약속된 암호화 값
	 * @param crmCustNo : (필수) 통합고객번호
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] 고객 상세조회 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<AsmCustVo> getCustDtl(String crmCustNo) throws Exception {

		// 고객정보 VO
		ArrayList<AsmCustVo> asmCustListVo = new ArrayList<AsmCustVo>();

		// header에 ifid set
		EzMap header = setHeader(selectCustDtlIFID);

		// Bos Request Param
		EzMap cond = new EzMap();
		cond.put("crmCustNo", crmCustNo);

		// Request Body 요청값
		EzMap postData = setCond(cond);

		// BOS Api 고객상세정보 조회
		String resJsonData = restApiCallService.httpCallApi(newUrl, postData, "POST", header,
				getAuthInfo());

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		String rtnMsg = (String) map.get("rtnMsg");
		String rtnCode = (String) map.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류

		if ("0".equals(rtnCode)) {
			asmCustListVo = (ArrayList<AsmCustVo>) map.get("list");
		} else {
			// 고객상세조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("[%s]%s", rtnCode, rtnMsg));
		}

		return asmCustListVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 5. 31.
	 * @param randomKey : (필수 랜덤키) 사전약속된 암호화 값
	 * @param EzMap     : param
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] 계약내역 목록 조회 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public AsmBosContractVo selectCntrList(EzMap param) throws Exception {

		// 고객정보 VO
		AsmBosContractVo asmBosContractVo = new AsmBosContractVo();

		// Request Header 요청값 (헤더에 crmUsrId 추가해야 된다고함)
		EzMap header = setHeader(selectCntrListIFID);

		// (필수) CRM통합고객번호
		String itgCustNo = (String) param.get("crmCustNo");

		// Bos Request Param
		EzMap cond = new EzMap();
		cond.put("crmCustNo", itgCustNo); // (필수) CRM통합고객번호
		cond.put("ordNo", (String) param.get("ordNo")); // (선택) 주문번호
		cond.put("cntrNo", (String) param.get("cntrNo")); // (선택) 계약번호
		cond.put("saleTyCd", (String) param.get("saleTyCd")); // (선택) 판매유형

		// Request Body 요청값
		EzMap postData = setCond(cond);

		// BOS Api 계약내역 목록 조회
		String resJsonData = restApiCallService.httpCallApi(newUrl, postData, "POST", header,
				getAuthInfo());

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		String rtnMsg = (String) map.get("rtnMsg");
		String rtnCode = (String) map.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류

		if ("0".equals(rtnCode)) {

			// 조회 건수
			int rtnCnt = (int) map.get("rtnCnt");
			log.debug("rtnCnt ======>" + rtnCnt);

			// 계약내역 목록
			List<AsmBosContractListVo> asmBosContractListVo = null;

			if (rtnCnt > 0) {
				asmBosContractListVo = (ArrayList<AsmBosContractListVo>) map.get("list");
				// log.debug("asmBosContractListVo1 ======>" + asmBosContractListVo.size());
				// log.debug("asmBosContractListVo2 ======>" + asmBosContractListVo);

				// 계약내역 DB 저장 (임시 - 대표님시연)
				for (int i = 0; i < asmBosContractListVo.size(); i++) {
					log.debug("insertContractIfHist =====>" + asmBosContractListVo.get(i));

					AsmBosContractListVo vo = objectMapper.convertValue(asmBosContractListVo.get(i),
							AsmBosContractListVo.class);
					vo.setItgCustNo(itgCustNo);
					vo.setRtnCnt(rtnCnt);

					// 계약내역 저장
					// dao.insertContractIfHist(vo);
				}
			}

			asmBosContractVo.setRtnCnt(rtnCnt);
			asmBosContractVo.setList(asmBosContractListVo);

			log.debug("vo1 ======>" + asmBosContractVo);
			// log.debug("vo2 ======>" + asmBosContractVo.getList().size());

		} else {
			// 계약내역 목록 조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("[%s]%s", rtnCode, rtnMsg));
		}

		return asmBosContractVo;
	}

	/**
	 * @author 조기현
	 * @date 2023. 9. 27.
	 * @param randomKey : (필수 랜덤키) 사전약속된 암호화 값
	 * @param cntrNo    : (필수) 계약번호
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] 계약 상세조회 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public AsmBosContractVo selectCntrDtl(EzMap param) throws Exception {

		// 고객정보 VO
		AsmBosContractVo asmBosContractVo = new AsmBosContractVo();

		// Request Header 요청값 (헤더에 crmUsrId 추가해야 된다고함)
		EzMap header = setHeader(selectCntrDtlIFID);

		// Bos Request Param
		EzMap cond = new EzMap();
		cond.put("cntrNo", param.get("cntrNo"));

		// Request Body 요청값
		EzMap postData = setCond(cond);

		// BOS Api 고객상세정보 조회
		String resJsonData = restApiCallService.httpCallApi(newUrl, postData, "POST", header,
				getAuthInfo());

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		String rtnMsg = (String) map.get("rtnMsg");
		String rtnCode = (String) map.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류
		;
		log.debug("RtnCode=====>" + rtnCode);
		if ("0".equals(rtnCode)) {
			ArrayList<AsmBosContractListVo> asmBosContractListVo = new ArrayList<AsmBosContractListVo>();
			// 계약상세
			String dtlCond = null;
			int rtnCnt = (int) map.get("rtnCnt");
			if (rtnCnt == 1) {
				dtlCond = Utilities.getJsonString((Map<String, Object>) map.get("dtlCond"));
				log.debug("dtlCond ======>" + dtlCond);
			}
			if (!Utilities.isEmpty(dtlCond)) {
				asmBosContractListVo
						.add(objectMapper.readValue(dtlCond, AsmBosContractListVo.class));
				log.debug("asmBosContractListVo ======>" + asmBosContractListVo);
			}

			asmBosContractVo.setList(asmBosContractListVo);
		} else {
			// 고객상세조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("[%s]%s", rtnCode, rtnMsg));
		}

		return asmBosContractVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 9.
	 * @param (필수) 사전암호화값
	 * @param (필수) 계약번호
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] 교환 완료 이력 조회 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public AsmBosExchngCmptHstVo selectAsExchEndHst(String cntrNo, String crmCustNo)
			throws Exception {

		// 교환완료 이력조회 Vo
		AsmBosExchngCmptHstVo asmBosExchngCmptHstVo = new AsmBosExchngCmptHstVo();

		// Request Header 요청값
		EzMap header = setHeader(selectAsExchEndHstIFID);

		// Bos Request Param
		EzMap cond = new EzMap();
		cond.put("cntrNo", cntrNo); // (필수) 계약번호
		cond.put("crmCustNo", crmCustNo); // 고객번호

		// Request Body 요청값
		EzMap postData = setCond(cond);

		// BOS Api 교환완료 이력 조회
		String resJsonData = restApiCallService.httpCallApi(newUrl, postData, "POST", header,
				getAuthInfo());

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		String rtnMsg = (String) map.get("rtnMsg");
		String rtnCode = (String) map.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류

		if ("0".equals(rtnCode)) {

			// 조회 건수
			int rtnCnt = (int) map.get("rtnCnt");
			log.debug("rtnCnt ======>" + rtnCnt);

			// 교환완료 이력 조회 목록
			List<AsmBosExchngCmptHstListVo> asmBosExchngCmptHstListVo = null;

			if (rtnCnt > 0) {
				asmBosExchngCmptHstListVo = (ArrayList<AsmBosExchngCmptHstListVo>) map.get("list");
			}

			asmBosExchngCmptHstVo.setRtnCnt(rtnCnt);
			asmBosExchngCmptHstVo.setList(asmBosExchngCmptHstListVo);

		} else {
			// 교환완료 이력 조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("[%s]%s", rtnCode, rtnMsg));
		}

		return asmBosExchngCmptHstVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 14.
	 * @param EzMap
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] 정기점검 처리 결과 정보조회 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public AsmRgitvInspRsltVo selectServiceProcList(EzMap param) throws Exception {

		// 정기점검 처리 결과 정보조회 Vo
		AsmRgitvInspRsltVo asmRgitvInspRsltVo = new AsmRgitvInspRsltVo();

		// Request Header 요청값 (헤더에 crmUsrId 추가해야 된다고함)
		EzMap header = setHeader(selectServiceProcListIFID);

		// Bos Request Param
//		EzMap cond = new EzMap();
//		cond.put("crmCustNo", (String) param.get("crmCustNo")); // (필수) CRM고객번호
//		cond.put("procBhf", (String) param.get("procBhf")); // (선택) 처리지점
//		cond.put("dueFrDe", (String) param.get("dueFrDe")); // (선택) 처리일자(시작일)
//		cond.put("dueToDe", (String) param.get("dueToDe")); // (선택) 처리일자(종료일)
//		cond.put("procEngr", (String) param.get("procEngr")); // (선택) 처리기사
//		cond.put("cntrNo", (String) param.get("cntrNo")); // (선택) 계약번호

		// Request Body 요청값
		EzMap postData = setCond(param);

		// BOS Api 정기점검 처리 결과 정보조회
		String resJsonData = restApiCallService.httpCallApi(newUrl, postData, "POST", header,
				getAuthInfo());

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		String rtnMsg = (String) map.get("rtnMsg");
		String rtnCode = (String) map.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류
		log.debug("rtnCode ======>" + rtnCode);
		if ("0".equals(rtnCode)) {

			// 조회 건수
			int rtnCnt = (int) map.get("rtnCnt");
			log.debug("rtnCnt ======>" + rtnCnt);

			// 정기점검 처리 결과 정보조회 목록
			List<AsmRgitvInspRsltListVo> asmRgitvInspRsltListVo = null;

			if (rtnCnt > 0) {
				asmRgitvInspRsltListVo = (ArrayList<AsmRgitvInspRsltListVo>) map.get("list");
			}

			asmRgitvInspRsltVo.setRtnCnt(rtnCnt);
			asmRgitvInspRsltVo.setList(asmRgitvInspRsltListVo);

		} else {
			// 정기점검 처리 결과 정보조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("[%s]%s", rtnCode, rtnMsg));
		}

		return asmRgitvInspRsltVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 17.
	 * @param randomKey : 암호화키값
	 * @param cntrNo    : (필수) 계약번호
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] 정기점검 방문 이력 조회 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public AsmRgitvInspHstVo selectServiceVisitHstList(String cntrNo, String crmCustNo)
			throws Exception {
		// 정기점검 방문 이력 조회 Vo
		AsmRgitvInspHstVo asmRgitvInspHstVo = new AsmRgitvInspHstVo();

		// Request Header 요청값 (헤더에 crmUsrId 추가해야 된다고함)
		EzMap header = setHeader(selectServiceVisitHstListIFID);

		// Bos Request Param
		EzMap cond = new EzMap();
		if (StringUtils.isNotBlank(cntrNo)) {
			cond.put("cntrNo", cntrNo); // 계약번호
		}
		if (StringUtils.isNotBlank(crmCustNo)) {
			cond.put("crmCustNo", crmCustNo); // 고객번호
		}

		// Request Body 요청값
		EzMap postData = setCond(cond);

		// BOS Api 정기점검 방문 이력 조회
		String resJsonData = restApiCallService.httpCallApi(newUrl, postData, "POST", header,
				getAuthInfo());

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		String rtnMsg = (String) map.get("rtnMsg");
		String rtnCode = (String) map.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류

		if ("0".equals(rtnCode)) {

			// 조회 건수
			int rtnCnt = (int) map.get("rtnCnt");
			log.debug("rtnCnt ======>" + rtnCnt);

			// 정기점검 방문 이력 조회 목록
			List<AsmRgitvInspHstListVo> asmRgitvInspHstListVo = null;

			if (rtnCnt > 0) {
				asmRgitvInspHstListVo = (ArrayList<AsmRgitvInspHstListVo>) map.get("list");
			}

			asmRgitvInspHstVo.setRtnCnt(rtnCnt);
			asmRgitvInspHstVo.setList(asmRgitvInspHstListVo);

		} else {
			// 정기점검 방문 이력 조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("[%s]%s", rtnCode, rtnMsg));
		}

		return asmRgitvInspHstVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 21.
	 * @param randomKey : 암호화키값
	 * @param crmCustNo : 통합고객번호
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] 설치이력(신규설치) API + 설치이력(제품교환) API + 설치이력(반환) API = Merge
	 *
	 */
	@SuppressWarnings("unchecked")
	public AsmBosInstallHstVo selectInstallHst(String crmCustNo, String cntrNo) throws Exception {

		// String apiUrl = restUrl;

		// 설치이력(신규설치) API
		// apiUrl += selectIstRsltRegList;

		// 설치이력(제품교환) API
		// apiUrl += selectAsProcRsltList;

		// 설치이력(반환) API
		// apiUrl += selectRtnRsltRegList;

		// 설치이력 Vo
		AsmBosInstallHstVo asmBosInstallHstVo = new AsmBosInstallHstVo();

		// Request Header 요청값 (헤더에 crmUsrId 추가해야 된다고함)
		EzMap header01 = setHeader(selectIstRsltRegListIFID);
		EzMap header02 = setHeader(selectAsProcRsltListIFID);
		EzMap header03 = setHeader(selectRtnRsltRegListIFID);
		// Bos Request Param
		EzMap cond = new EzMap();
		cond.put("crmCustNo", crmCustNo); // (필수) 통합고객번호
		cond.put("cntrNo", cntrNo);

		// Request Body 요청값
		EzMap postData = setCond(cond);

		// 설치이력(설치) Api
		String resJsonData01 = restApiCallService.httpCallApi(newUrl, postData, "POST", header01,
				getAuthInfo());

		// 설치이력(교환) Api
		String resJsonData02 = restApiCallService.httpCallApi(newUrl, postData, "POST", header02,
				getAuthInfo());

		// 설치이력(반환) Api
		String resJsonData03 = restApiCallService.httpCallApi(newUrl, postData, "POST", header03,
				getAuthInfo());

		// Response Data
		Map<String, Object> map01 = Utilities.getJson(resJsonData01);
		Map<String, Object> map02 = Utilities.getJson(resJsonData02);
		Map<String, Object> map03 = Utilities.getJson(resJsonData03);

		String rtnMsg01 = (String) map01.get("rtnMsg");
		String rtnCode01 = (String) map01.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류

		String rtnMsg02 = (String) map02.get("rtnMsg");
		String rtnCode02 = (String) map02.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류

		String rtnMsg03 = (String) map03.get("rtnMsg");
		String rtnCode03 = (String) map03.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류

		if (!"0".equals(rtnCode01)) {
			// 설치이력(설치) Api 조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("16[%s]%s", rtnCode01, rtnMsg01));
		}

		if (!"0".equals(rtnCode02)) {
			// 설치이력(교환) Api 조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("17[%s]%s", rtnCode02, rtnMsg02));
		}

		if (!"0".equals(rtnCode03)) {
			// 설치이력(반환) Api 조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("18[%s]%s", rtnCode03, rtnMsg03));
		}

		// 건수
		int rtnCnt01 = (int) map01.get("rtnCnt");
		log.debug("설치 건수 ======>" + rtnCnt01);

		int rtnCnt02 = (int) map02.get("rtnCnt");
		log.debug("교환 건수 ======>" + rtnCnt02);

		int rtnCnt03 = (int) map03.get("rtnCnt");
		log.debug("반환 건수 ======>" + rtnCnt03);

		List<AsmBosInstallHstListVo> mergeVo = new ArrayList<AsmBosInstallHstListVo>(); // 설치이력
																						// Merge VO
		AsmBosInstallHstListVo asmBosInstallHstListVo = new AsmBosInstallHstListVo();

		List<EzMap> resultList01 = (ArrayList<EzMap>) map01.get("list"); // 설치
		List<EzMap> resultList02 = (ArrayList<EzMap>) map02.get("list"); // 교환
		List<EzMap> resultList03 = (ArrayList<EzMap>) map03.get("list"); // 반환

		if (rtnCnt01 > 0) {
			for (int i = 0; i < resultList01.size(); i++) {
				AsmBosInstallHst01ListVo vo = objectMapper.convertValue(resultList01.get(i),
						AsmBosInstallHst01ListVo.class);

				asmBosInstallHstListVo.setInstallHstDiv("신규설치"); // 구분
				asmBosInstallHstListVo.setStrRegDt(vo.getDueDe()); // 접수일자

				asmBosInstallHstListVo.setProcDe(vo.getIstDe()); // 설치일자 (Merge명칭 : 처리일자)
				asmBosInstallHstListVo.setProcTime(vo.getIstTime()); // 설치시간 (Merge명칭 : 처리시간)

				asmBosInstallHstListVo.setProcBhfNm(vo.getIstBhfNm()); // 설치지점명 (Merge명칭 : 처리팀)
				asmBosInstallHstListVo.setProcEngrNm(vo.getIstEngrNm()); // 설치기사명 (Merge명칭 : 처리자)
				asmBosInstallHstListVo.setIstEngrMobNo(vo.getIstEngrMobNo()); // 설치기사연락처 (Merge명칭 :
																				// 처리자연락처)

				asmBosInstallHstListVo.setCntrNo(vo.getCntrNo()); // (Merge명칭 : 계약번호)
				asmBosInstallHstListVo.setSaleSeNm(vo.getSaleSeNm()); // (Merge명칭 : 판매구분)
				asmBosInstallHstListVo.setPrcPlcNm(vo.getPrcPlcNm()); // 가격정책명 (Merge명칭 : 요금제명) -
																		// 신규설치 API에만 있음

				asmBosInstallHstListVo.setPrBrcd(vo.getPrBrcd()); // 상품바코드(Merge명칭 : 설치 S/N)
				asmBosInstallHstListVo.setCnfirmBrcd(vo.getConfirmBrcd()); // 확인바코드 (Merge명칭 : 회수
																			// S/N)

				mergeVo.add(asmBosInstallHstListVo);
				asmBosInstallHstListVo = new AsmBosInstallHstListVo();
			}
		}

		if (rtnCnt02 > 0) {
			for (int i = 0; i < resultList02.size(); i++) {
				AsmBosInstallHst02ListVo vo = objectMapper.convertValue(resultList02.get(i),
						AsmBosInstallHst02ListVo.class);

				asmBosInstallHstListVo.setInstallHstDiv("제품교환");
				asmBosInstallHstListVo.setStrRegDt(vo.getStrRegDt());

				asmBosInstallHstListVo.setProcDe(vo.getProcDe()); // 처리일자 (Merge명칭 : 처리일자)
				asmBosInstallHstListVo.setProcTime(vo.getProcTime()); // 처리시간 (Merge명칭 : 처리시간)

				asmBosInstallHstListVo.setProcBhfNm(vo.getProcBhfNm()); // 처리지점명 (Merge명칭 : 처리팀)
				asmBosInstallHstListVo.setProcEngrNm(vo.getProcEngrNm()); // 처리기사명 (Merge명칭 : 처리자)
				asmBosInstallHstListVo.setIstEngrMobNo(vo.getProcEngrMobNo()); // 처리기사연락처 (Merge명칭 :
																				// 처리자연락처)

				asmBosInstallHstListVo.setCntrNo(vo.getCntrNo()); // (Merge명칭 : 계약번호)
				asmBosInstallHstListVo.setSaleSeNm(vo.getSaleSeCdNm()); // (Merge명칭 : 판매구분)

				asmBosInstallHstListVo.setPrBrcd(vo.getIstPrBrcd()); // 설치제품 바코드(Merge명칭 : 설치 S/N)
				asmBosInstallHstListVo.setCnfirmBrcd(vo.getRtnPrBrcd()); // 반환제품 바코드 (Merge명칭 : 회수
																			// S/N)

				asmBosInstallHstListVo.setAcptTyDtlNm(vo.getAcptTyDtlNm()); // 접수유형상세명 (Merge명칭 :
																			// 접수유형) - 제품교환 API에만 있음
				asmBosInstallHstListVo.setProcTyDtlNm(vo.getProcTyDtlNm()); // 처리유형상세명 (Merge명칭 :
																			// 처리유형) - 제품교환 API에만 있음

				mergeVo.add(asmBosInstallHstListVo);
				asmBosInstallHstListVo = new AsmBosInstallHstListVo();
			}
		}

		asmBosInstallHstListVo = new AsmBosInstallHstListVo();
		if (rtnCnt03 > 0) {
			for (int i = 0; i < resultList03.size(); i++) {
				AsmBosInstallHst03ListVo vo = objectMapper.convertValue(resultList03.get(i),
						AsmBosInstallHst03ListVo.class);

				asmBosInstallHstListVo.setInstallHstDiv("반환");
				asmBosInstallHstListVo.setStrRegDt(vo.getRtnAcptDe());

				asmBosInstallHstListVo.setProcDe(vo.getRtnDe()); // 반환일자 (Merge명칭 : 처리일자)
				asmBosInstallHstListVo.setProcTime(vo.getRtnTime()); // 반환시간 (Merge명칭 : 처리시간)

				asmBosInstallHstListVo.setProcBhfNm(vo.getRtnBhfNm()); // 반환지점명 (Merge명칭 : 처리팀)
				asmBosInstallHstListVo.setProcEngrNm(vo.getRtnEngrNm()); // 반환기사명 (Merge명칭 : 처리자)
				asmBosInstallHstListVo.setIstEngrMobNo(vo.getRtnEngrMobNo()); // 반환기사연락처 (Merge명칭 :
																				// 처리자연락처)

				asmBosInstallHstListVo.setCntrNo(vo.getCntrNo()); // (Merge명칭 : 계약번호)
				asmBosInstallHstListVo.setSaleSeNm(vo.getSaleSeNm()); // (Merge명칭 : 판매구분)

				asmBosInstallHstListVo.setPrBrcd(vo.getPrBrcd()); // 제품 바코드(Merge명칭 : 설치 S/N)
				asmBosInstallHstListVo.setCnfirmBrcd(vo.getCnfirmBrcd()); // 확인 바코드 (Merge명칭 : 회수
																			// S/N)

				asmBosInstallHstListVo.setRtnStsCdNm(vo.getRtnStsCdNm()); // 반환상태명 (Merge명칭 : 반환상태)
																			// - 반환 API에만 있음
				asmBosInstallHstListVo.setRm(vo.getRm()); // 고객요청사항 (Merge명칭 : 고객요청사항) - 반환 API에만 있음

				mergeVo.add(asmBosInstallHstListVo);
				asmBosInstallHstListVo = new AsmBosInstallHstListVo();
			}
		}

		asmBosInstallHstVo.setRtnCnt(rtnCnt01 + rtnCnt02 + rtnCnt03); // 설치이력 건수 Merge
		asmBosInstallHstVo.setList(mergeVo); // 설치이력 Merge

		log.debug("mergeVo 건수======>" + mergeVo.size());
		log.debug("mergeVo======>" + mergeVo);

		return asmBosInstallHstVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 23.
	 * @param randomKey : 암호화키값
	 * @param (필수)      crmCustNo : CRM고객번호
	 * @param (필수)      cntrNo : 계약번호
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] 관리주소변경이력 조회 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public AsmMngAddrChngHstVo selectEqpChgMngHstList(String crmCustNo, String cntrNo)
			throws Exception {
		// 관리주소변경이력 조회 Vo
		AsmMngAddrChngHstVo asmMngAddrChngHstVo = new AsmMngAddrChngHstVo();

		// Header에 ifid
		EzMap header = setHeader(selectEqpChgMngHstListIFID);
		// Bos Request Param
		EzMap cond = new EzMap();
		cond.put("crmCustNo", crmCustNo); // (필수) CRM고객번호
		cond.put("cntrNo", cntrNo); // (필수) 계약번호
		EzMap body = setCond(cond);

		// BOS Api 관리주소변경이력 조회
		String resJsonData = restApiCallService.httpCallApi(newUrl, body, "POST", header,
				getAuthInfo());

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		String rtnMsg = (String) map.get("rtnMsg");
		String rtnCode = (String) map.get("rtnCode"); // 0:성공, -1:오류, -999 : SYSTEM 오류

		if ("0".equals(rtnCode)) {

			// 조회 건수
			int rtnCnt = (int) map.get("rtnCnt");
			// (int) map.get("rtnCnt");
			log.debug("rtnCnt ======>" + rtnCnt);

			// 관리주소변경이력 목록
			List<AsmMngAddrChngHstListVo> asmMngAddrChngHstListVo = null;

			if (rtnCnt > 0) {
				asmMngAddrChngHstListVo = (ArrayList<AsmMngAddrChngHstListVo>) map.get("list");
			}

			asmMngAddrChngHstVo.setRtnCnt(rtnCnt);
			asmMngAddrChngHstVo.setList(asmMngAddrChngHstListVo);

		} else {
			// 관리주소변경이력 조회 실패
			throw new EzApiException(Constants._API_CODE_NO_DATA,
					String.format("[%s]%s", rtnCode, rtnMsg));
		}

		return asmMngAddrChngHstVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 5. 31.
	 * @param
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] API Call Request Body 요청값 (Parameter)
	 *
	 */
	public static EzMap reqParamData(String randomKey, EzMap cond) throws Exception {

		EzMap bodyMap = new EzMap();

		if (Utilities.isNotEmpty(randomKey)) {
			bodyMap.put("randomKey", randomKey); // (랜덤키)사전약속된 암호화 값
		}
		bodyMap.put("crmUsrId", crmUsrId);
		bodyMap.put("usrLocale", usrLocale);
		bodyMap.put("crmYn", crmYn);

		EzMap reqParamData = new EzMap();
		reqParamData.put("cmCond", bodyMap);

		if (Utilities.isNotEmpty(cond)) {
			reqParamData.put("cond", cond);
		}

		return reqParamData;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 5. 31.
	 * @param
	 * @return
	 * @throws Exception
	 * @description [CRM-BOS] API Call Request Header 요청값
	 *
	 */
	public static EzMap reqHeaderParam(String randomKey) throws Exception {

		// Request Header 요청값 (헤더에 crmUsrId 추가해야 된다고함)
		EzMap header = new EzMap();

		if (Utilities.isNotEmpty(randomKey)) {
			header.put("randomKey", randomKey);
		}
		header.put("crmUsrId", crmUsrId);
		header.put("crmYn", crmYn);

		return header;
	}

	private EzMap setCond(EzMap ezMap) throws Exception {
		EzMap body = new EzMap();
		body.put("cond", ezMap);
		return body;
	}

	private EzMap setHeader(String ifid) {
		EzMap header = new EzMap();
		header.put("ifid", ifid);
		return header;
	}

	private String getAuthInfo() throws Exception {
		return "BASIC " + Utilities.encodeBase64(rentalId + ":" + rentalPwd);
	}
}
