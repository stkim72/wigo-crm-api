package com.ceragem.api.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.model.ApiVoidResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmAcqieHstSo;
import com.ceragem.api.crm.model.CrmAcqieHstVo;
import com.ceragem.api.crm.model.CrmAgreementVo;
import com.ceragem.api.crm.model.CrmCustBosCntrtHstSo;
import com.ceragem.api.crm.model.CrmCustBosCntrtHstVo;
import com.ceragem.api.crm.model.CrmCustInfoChngHstSo;
import com.ceragem.api.crm.model.CrmCustInfoChngHstVo;
import com.ceragem.api.crm.model.CrmCustInfoPtuseAgreeHstSo;
import com.ceragem.api.crm.model.CrmCustInfoPtuseAgreeHstVo;
import com.ceragem.api.crm.model.CrmCustInstallLocVo;
import com.ceragem.api.crm.model.CrmCustSo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmDenyVo;
import com.ceragem.api.crm.model.CrmSnstvInfoInqrySo;
import com.ceragem.api.crm.service.CrmAcqieHstService;
import com.ceragem.api.crm.service.CrmCustInfoChngHstService;
import com.ceragem.api.crm.service.CrmCustInfoPtuseAgreeHstService;
import com.ceragem.api.crm.service.CrmCustService;
import com.ceragem.api.crm.service.EonMessageService;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @ClassName CrmCustBasController
 * @author 김성태
 * @date 2022. 4. 8.
 * @Version 1.0
 * @description CRM고객 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Validated
@Tag(name = "CRM고객", description = "CRM고객 API")
@RestController
@RequestMapping("/crm/v1.0/customer")
public class CrmCustController extends BaseRestController {

	@Autowired
	CrmCustService service;

	@Autowired
	CrmCustInfoPtuseAgreeHstService agreeService;

	@Autowired
	CrmAcqieHstService acqService;
	@Autowired
	CrmCustInfoChngHstService infoChangeService;

	@Autowired
	EonMessageService eonMessageService;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 8.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM고객 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM고객 검색", description = "CRM고객 검색 [개인정보취급자번호-indiInfoHandlPrsnNo,접속자IP주소-connPrsnIpAddr 모두 제공시 암호화 해제 후 전송]")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustVo>>> getCrmCustBasList(
			@Parameter(description = "개인정보 취급자 정보") @RequestParam(name = "indiInfoHandlPrsnNo", required = false) String indiInfoHandlPrsnNo,
			@Parameter(description = "접속아이피") @RequestParam(name = "connPrsnIpAddr", required = false) String connPrsnIpAddr,
			@Parameter(description = "다운로드 사유") @RequestParam(name = "dnldTxn", required = false) String dnldTxn,
			@Parameter(description = "CRM고객 검색객체") @ParameterObject @Valid @ModelAttribute CrmCustSo so)
			throws Exception {

		service.checkCustSo(so);

		EzMap param = new EzMap(so);
		int cnt = service.getListCount(param);
		List<CrmCustVo> list = service.getList(param);

		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 8.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM고객단건 검색
	 *
	 */
	@GetMapping("/{itgCustNo}")
	@Operation(summary = "CRM고객 단건", description = "CRM고객 단건 검색 [개인정보취급자번호-indiInfoHandlPrsnNo,접속자IP주소-connPrsnIpAddr 모두 제공시 암호화 해제 후 전송]")
	public ResponseEntity<ApiResultVo<CrmCustVo>> getCrmCustBas(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "연락처포함여부") @RequestParam(value = "includeContactYn", required = false, defaultValue = "N") String includeContactYn,
			@Parameter(description = "개인정보 취급자 정보") @RequestParam(name = "indiInfoHandlPrsnNo", required = false) String indiInfoHandlPrsnNo,
			@Parameter(description = "접속아이피") @RequestParam(name = "connPrsnIpAddr", required = false) String connPrsnIpAddr,
			@Parameter(description = "개인정보 취급자 정보", required = false, hidden = true) @ModelAttribute CrmSnstvInfoInqrySo info)
			throws Exception {
		String contactYn = includeContactYn;
		CrmCustSo so = new CrmCustSo();
		so.setSo(info);
		if (Utilities.isEmpty(contactYn))
			contactYn = "N";
		so.setIncludeContactYn(contactYn);
		so.setItgCustNo(itgCustNo);

		CrmCustVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);

		return successResponse(vo);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 18.
	 * @param itgCustNo
	 * @return
	 * @throws Exception
	 * @description 휴면등록
	 *
	 */
	@Deprecated
	@PostMapping("/dormancy/{itgCustNo}")
	@Operation(summary = "CRM고객 휴면등록", description = "CRM고객 휴면등록", hidden = true)
	public ResponseEntity<ApiVoidResultVo> dormancy(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo) throws Exception {

		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(itgCustNo);
		vo.setCustStatusCd(Constants._USER_STATUS_DORMANT);
		service.updateDormant(vo);

		return successResponse();
	}

	@Deprecated
	@PutMapping("/dormancy-cancel/{itgCustNo}")
	@Operation(summary = "CRM고객 휴면취소", description = "CRM고객 휴면취소", hidden = true)
	public ResponseEntity<ApiVoidResultVo> cancelDormancy(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo) throws Exception {

		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(itgCustNo);
		vo.setCustStatusCd(Constants._USER_STATUS_NORMAL);
		service.updateNormal(vo);

		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 8.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM고객 등록", description = "CRM고객 등록  indiInfoHandlPrsnNo, connPrsnIpAddr 필수로 제공")
	public ResponseEntity<ApiResultVo<CrmCustVo>> registerCrmCustBas(
			@Parameter(description = "CRM고객 객체") @RequestBody @Valid CrmCustVo vo) throws Exception {

		if (Utilities.isEmpty(vo.getIndiInfoHandlPrsnNo()))
			throw new EzApiException(Constants._API_CODE_NO_INFO_ID,
					"[ indiInfoHandlPrsnNo is null ]개인정보취급자 정보[사번]가 존재하지 않습니다.");
		if (Utilities.isEmpty(vo.getConnPrsnIpAddr()))
			throw new EzApiException(Constants._API_CODE_NO_INFO_ID, "[ connPrsnIpAddr is null ]접속자IP주소가 존재하지 않습니다.");

		vo.setRegrId(vo.getIndiInfoHandlPrsnNo());
		vo.setAmdrId(vo.getIndiInfoHandlPrsnNo());
		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		CrmCustSo so = new CrmCustSo();
		so.setItgCustNo(vo.getItgCustNo());
		so.setForceDecrypt(true);
		return successResponse(service.get(so));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 8.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객 입력
	 *
	 */
	@PostMapping("/installer")
	@Operation(summary = "CRM고객설치처 등록", description = "CRM고객설치처 등록  indiInfoHandlPrsnNo, connPrsnIpAddr 필수로 제공")
	public ResponseEntity<ApiResultVo<CrmCustVo>> registerCrmInstall(
			@Parameter(description = "CRM고객 객체") @RequestBody @Valid CrmCustInstallLocVo installer) throws Exception {

//		CrmCustVo vo = Utilities.beanToBean(installer, CrmCustVo.class);
		if (Utilities.isEmpty(installer.getIndiInfoHandlPrsnNo()))
			throw new EzApiException(Constants._API_CODE_NO_INFO_ID,
					"[ indiInfoHandlPrsnNo is null ]개인정보취급자 정보[사번]가 존재하지 않습니다.");
		if (Utilities.isEmpty(installer.getConnPrsnIpAddr()))
			throw new EzApiException(Constants._API_CODE_NO_INFO_ID, "[ connPrsnIpAddr is null ]접속자IP주소가 존재하지 않습니다.");

		CrmCustVo cust = service.saveInstaller(installer);

		return successResponse(cust);

	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 8.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM고객 수정
	 *
	 */
	@PutMapping("")
	@Operation(summary = "CRM고객 수정", description = "CRM고객 수정 indiInfoHandlPrsnNo, connPrsnIpAddr 필수로 제공")
	public ResponseEntity<ApiResultVo<CrmCustVo>> modifyCrmCustBas(
			@Parameter(description = "CRM고객 객체", hidden = true) @RequestBody Map<String, Object> param,
			@Parameter(description = "CRM고객 객체") CrmCustVo v) throws Exception {

		CrmCustVo vo = service.getModifiedCust(param);
		if (Utilities.isEmpty(vo.getIndiInfoHandlPrsnNo()))
			throw new EzApiException(Constants._API_CODE_NO_INFO_ID,
					"[ indiInfoHandlPrsnNo is null ]개인정보취급자 정보[사번]가 존재하지 않습니다.");
		if (Utilities.isEmpty(vo.getConnPrsnIpAddr()))
			throw new EzApiException(Constants._API_CODE_NO_INFO_ID, "[ connPrsnIpAddr is null ]접속자IP주소가 존재하지 않습니다.");
		vo.setAmdrId(vo.getIndiInfoHandlPrsnNo());
		int ret = service.update(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		CrmCustSo so = new CrmCustSo();
		so.setItgCustNo(vo.getItgCustNo());
		so.setForceDecrypt(true);
		return successResponse(service.get(so));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 8.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM고객 삭제
	 *
	 */
	@DeleteMapping("/{itgCustNo}")
	@Operation(summary = "CRM고객 탈회", description = "CRM고객 탈회")
	public ResponseEntity<ApiVoidResultVo> removeCrmCustBas(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo) throws Exception {
		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(itgCustNo);
		int ret = service.updateWithdrawal(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 19.
	 * @param loginId
	 * @param loginPwd
	 * @return
	 * @throws Exception
	 * @description
	 *
	 */
	@GetMapping("/login")
	@Operation(summary = "CRM고객 정보 by 로그인아이디", description = "CRM고객 정보 by 로그인아이디", hidden = true)
	public ResponseEntity<ApiResultVo<CrmCustVo>> loginMember(
			@Parameter(description = "로그인 아이디") @RequestParam("loginId") String loginId,
			@Parameter(description = "로그인 암호") @RequestParam("loginPwd") String loginPwd
//			@Parameter(description = "접속 아이피") @RequestParam("ipAddr") String ipAddr
	) throws Exception {
		CrmCustVo vo = new CrmCustVo();
		vo.setMshipLoginId(loginId);
		vo.setMshipLoginPwd(loginPwd);
//		CrmCustVo user = service.getLoginUser(vo);
		CrmCustVo user = service.login(vo);
		if (user == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(user);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 19.
	 * @param agree
	 * @return
	 * @throws Exception
	 * @description 고객정보활용동의
	 *
	 */
	@GetMapping("/agree/{itgCustNo}")
	@Operation(summary = "고객정보활용동의내역", description = "고객정보활용동의내역")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustInfoPtuseAgreeHstVo>>> agreeList(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "CRM고객 검색객체", hidden = true) CrmCustInfoPtuseAgreeHstSo so) throws Exception {
		so.setItgCustNo(itgCustNo);

		EzMap param = new EzMap(so);
		List<CrmCustInfoPtuseAgreeHstVo> list = agreeService.getList(param);
		int cnt = agreeService.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	@GetMapping("/contract")
	@Operation(summary = "CSS 계약내역", description = "CSS 계약내역")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustBosCntrtHstVo>>> contractList(
			@Parameter(description = "통합고객번호") @RequestParam("itgCustNo") String itgCustNo,
			@Parameter(description = "CSS 계약내역 검색객체") @ParameterObject @Valid CrmCustBosCntrtHstSo so)
			throws Exception {
		so.setItgCustNo(itgCustNo);
		EzMap param = new EzMap(so);
		List<CrmCustBosCntrtHstVo> list = service.getCustContractList(param);
		int cnt = service.getCustContractListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 19.
	 * @param agree
	 * @return
	 * @throws Exception
	 * @description 고객정보활용동의
	 *
	 */
	@PostMapping("/agree")
	@Operation(summary = "고객정보활용동의", description = "고객정보활용동의")
	public ResponseEntity<ApiResultVo<CrmCustVo>> agree(
			@Parameter(description = "CRM고객 객체") @RequestBody @Valid CrmAgreementVo vo) throws Exception {
//		return null;
		return successResponse(service.updateAgreement(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 19.
	 * @param agree
	 * @return
	 * @throws Exception
	 * @description 수신거부
	 *
	 */
	@GetMapping("/agreement/deny")
	@Operation(summary = "수신거부", description = "수신거부")
	public ResponseEntity<ApiVoidResultVo> deny(
			@Parameter(description = "수신거부 번호") @RequestParam(name = "uNumber", required = false) String uNumber,
			@Parameter(description = "수신거부 요청번호") @RequestParam("rNumber") String rNumber) throws Exception {
		service.updateAgreementDeny(rNumber, uNumber);
		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 19.
	 * @param agree
	 * @return
	 * @throws Exception
	 * @description 수신거부
	 *
	 */
	@PostMapping("/agreement/deny")
	@Operation(summary = "수신거부", description = "수신거부")
	public ResponseEntity<ApiVoidResultVo> deny(@RequestBody @Valid CrmDenyVo param

	) throws Exception {
		service.updateAgreementDeny(param.getRNumber(), param.getUNumber());
		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 8.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십 수정
	 *
	 */

	@PostMapping("visit-store")
	@Operation(summary = "최종방문매장등록", description = "최종방문매장등록")
	public ResponseEntity<ApiResultVo<CrmCustVo>> visitStore(
			@Parameter(description = "통합회원코드") @RequestParam("itgCustNo") String itgCustNo,
			@Parameter(description = "최종방문매장") @RequestParam("storeNo") String storNo,
			@Parameter(description = "방문일시", required = false) @RequestParam(name = "visitDt", required = false) @DatetimeValue String visitDt,
			@Parameter(description = "통합고객객체", required = false, hidden = true) @ModelAttribute CrmCustVo vo)
			throws Exception {
		vo.setMshipLastVisitStorNo(storNo);
		vo.setItgCustNo(itgCustNo);
		vo.setMshipLastStorVisitDt(visitDt);
//		try {
//			if (visitDt != null && visitDt.length() == 14) {
//				Date dt = Constants._DATETIME_FORMAT.parse(visitDt);
//				String str = Constants._DATETIME_FORMAT.format(dt);
//				if (str.equals(visitDt)) {
//					vo.setMshipLastStorVisitDt(visitDt);
//				}
//
//			}
//		} catch (Exception e) {
//			log.debug(e.getMessage());
//		}

		int ret = service.updateLastVisitStore(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

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
	@GetMapping("/acqie/{itgCustNo}")
	@Operation(summary = "CRM지인 검색", description = "CRM지인 검색")
	public ResponseEntity<ApiResultVo<List<CrmAcqieHstVo>>> getCrmCustBasList(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo) throws Exception {
		CrmAcqieHstSo so = new CrmAcqieHstSo();
		so.setItgCustNo(itgCustNo);
		EzMap param = new EzMap(so);
		List<CrmAcqieHstVo> list = acqService.getList(param);
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
	@PostMapping("/acqie/{itgCustNo}/{acqieItgCustNo}")
	@Operation(summary = "CRM지인 입력", description = "CRM지인 입력")
	public ResponseEntity<ApiVoidResultVo> registerCrmAcqieHst(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "지인통합고객번호") @PathVariable("acqieItgCustNo") String acqieItgCustNo)
			throws Exception {
		if (itgCustNo.equals(acqieItgCustNo))
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "자기 자신을 지인으로 등록할 수 없습니다.");
		CrmAcqieHstVo vo = new CrmAcqieHstVo();
		vo.setItgCustNo(itgCustNo);
		vo.setAcqieItgCustNo(acqieItgCustNo);
		int ret = acqService.insert(vo);
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
	@DeleteMapping("/acqie/{acqieHstSeq}")
	@Operation(summary = "CRM지인 삭제", description = "CRM지인 삭제")
	public ResponseEntity<ApiVoidResultVo> removeCrmAcqieHst(
			@Parameter(description = "지인이력일련번호") @PathVariable("acqieHstSeq") String acqieHstSeq) throws Exception {
		CrmAcqieHstVo vo = new CrmAcqieHstVo();
		vo.setAcqieHstSeq(acqieHstSeq);
		int ret = acqService.delete(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 9. 29.
	 * @param itgCustNo
	 * @param so
	 * @return 고객정보 변경이력 조회
	 * @throws Exception
	 * @description
	 *
	 */
	@GetMapping("/change-info/{itgCustNo}")
	@Operation(summary = "고객정보 변경이력 조회", description = "고객정보 변경이력 조회")
	public ResponseEntity<ApiResultVo<List<CrmCustInfoChngHstVo>>> getCrmhngHsList(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "변경이력 검색객체") @ParameterObject @Valid @ModelAttribute CrmCustInfoChngHstSo so)
			throws Exception {
		so.setItgCustNo(itgCustNo);
		EzMap param = new EzMap(so);

		int cnt = infoChangeService.getListCount(param);
		List<CrmCustInfoChngHstVo> list = infoChangeService.getList(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);

//		return successResponse(list, so);
		return successResponse(list);
	}

	/**
	 *
	 * @author 김정
	 * @date 2023. 3. 9.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 통합고객 바코드 알림톡 발송
	 *
	 */
	@PostMapping("/barcode/send")
	@Operation(summary = "통합고객 바코드 알림톡 발송", description = "통합고객 체크후, 부재시 통합고객 등록 후 바코드 알림톡 발송")
	public ResponseEntity<ApiVoidResultVo> sendBarcodeNumber(
			@Parameter(description = "고객명") @RequestParam("custNm") String custNm,
			@Parameter(description = "고객전화번호") @RequestParam("mphonNo") String mphonNo,
			@Parameter(description = "생년월일") @RequestParam("birthday") String birthday,
			@Parameter(description = "성별") @RequestParam("gndrCd") String gndrCd,
			@Parameter(description = "개인정보수집 동의여부") @RequestParam("collectYn") String collectYn,
			@Parameter(description = "마켓팅정보수집 동의여부") @RequestParam("marketingYn") String marketingYn,
			@Parameter(description = "웰카폐매장ID") @RequestParam("storeId") String storeId,
			@Parameter(description = "유입경로") @RequestParam("ingrsPathCd") String ingrsPathCd) throws Exception {
		// 1. 입력받은 전화번호, 고객명으로 통합고객 여부 체크
		CrmCustSo param = new CrmCustSo();
		param.setIndiInfoHandlPrsnNo("10022077");
		param.setCustNm(custNm);
		param.setMphonNo(mphonNo);
		int cnt = service.getListCount(param);

		// 없을경우 고객 생성
		if (cnt == 0) {
			CrmCustVo cust = new CrmCustVo();
			cust.setCustNm(custNm);
			cust.setMphonNo(mphonNo);
			cust.setBirthday(birthday);
			cust.setGndrCd(gndrCd);
			cust.setRcmdStorNo(storeId);
			cust.setIngrsPathCd(ingrsPathCd);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
			Date now = new Date();
			String procDt = sdf2.format(now);

			System.out.println("입력시간 > " + procDt);

			cust.setMarketingAgreeYn(marketingYn);
			cust.setMarketingAgreeDt(procDt);
			cust.setMarketingAgreeChlCd("EXP");

			cust.setInfoAgreeYn(collectYn);
			cust.setInfoAgreeDt(procDt);
			cust.setInfoAgreeChlCd("EXP");

			CrmAgreementVo agreement = new CrmAgreementVo();
			agreement.setCollectYn(collectYn);
			agreement.setMarketingYn(marketingYn);
			agreement.setRegChlCd("EXP");
			cust.setAgreement(agreement);

			service.insert(cust);
		}

		// 고객정보 조회
		List<CrmCustVo> list = service.getList(param);
		if (list.size() != 0) {
			CrmCustVo cust = list.get(0);
			// 카카오톡 알림톡 발송
			// 4. 알림톡 발송 처리
			Map<String, Object> params = new HashMap<>();
			params.put("codeCd", "414");
			params.put("itgCustNo", cust.getItgCustNo());
			params.put("custNm", custNm);
			params.put("mphonNo", mphonNo);
			params.put("cardNo", cust.getCardNo());
			eonMessageService.sendCustBarcodeMessage(params);
		}

		return successResponse();
	}

	/**
	 *
	 * @author 김정
	 * @date 2023. 3. 21.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 통합고객 인증번호 SMS 발송
	 *
	 */
	@PostMapping("/authno/send")
	@Operation(summary = "인증번호 알림톡 발송", description = "인증번호 알림톡 발송")
	public ResponseEntity<ApiVoidResultVo> sendSMSAuthNumber(
			@Parameter(description = "고객전화번호") @RequestParam("mphonNo") String mphonNo,
			@Parameter(description = "문자인증번호") @RequestParam("smsKey") String smsKey) throws Exception {
		// SMS 발송
		Map<String, Object> params = new HashMap<>();
		params.put("codeCd", "413");
		params.put("mphonNo", mphonNo);
		params.put("smskey", smsKey);
		eonMessageService.sendAuthMessage(params);

		return successResponse();
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2023. 9. 1.
	 * @param mphonNo
	 * @param smsKey
	 * @return
	 * @throws Exception
	 * @description
	 *
	 */
	@GetMapping("/event/send")
	@Operation(summary = "채널별 이벤트 알림", description = "채널별 이벤트 알림")
	public ResponseEntity<ApiVoidResultVo> sendCustmerApiEvent(
			@Parameter(description = "통합고객번호") @NotEmpty @RequestParam("itgCustNo") String itgCustNo,
			@Parameter(description = "이벤트코드") @CodeValue(codeId = "CU360") @RequestParam("eventCd") String eventCd,
			@Parameter(description = "제외채널") @CodeValue(codeId = "S000") @RequestParam(value = "exChlCd", required = false) String exChlCd)
			throws Exception {
		String ch = exChlCd;
		if (Utilities.isEmpty(ch))
			ch = Utilities.getSystemCd();
		service.sendCustmerApiEvent(itgCustNo, eventCd, ch);
		return successResponse();
	}

	/**
	 * @param vo
	 * @return
	 * @throws Exception
	 * @author 김정
	 * @date 2023. 9. 4.
	 * @description 통합고객 바코드 알림톡 발송(요건변경건에 대한 변경분 추가 )
	 */
	@PostMapping("/barcode/send/new")
	@Operation(summary = "통합고객 바코드 알림톡 발송", description = "통합고객 체크후, 부재시 통합고객 등록 후 바코드 알림톡 발송")
	public ResponseEntity<ApiVoidResultVo> sendBarcodeNumberNew(
			@Parameter(description = "고객명") @RequestParam("custNm") String custNm,
			@Parameter(description = "고객전화번호") @RequestParam("mphonNo") String mphonNo,
			@Parameter(description = "생년월일") @RequestParam("birthday") String birthday,
			@Parameter(description = "성별") @RequestParam("gndrCd") String gndrCd,
			@Parameter(description = "개인정보수집 동의여부") @RequestParam("collectYn") String collectYn,
			@Parameter(description = "마켓팅정보수집 동의여부") @RequestParam("marketingYn") String marketingYn,
			@Parameter(description = "웰카폐매장ID") @RequestParam("storeId") String storeId,
			@Parameter(description = "SMS 광고성 정보 수집 동의 여부") @RequestParam("smsYn") String smsYn,
			@Parameter(description = "EMAIL 광고성 정보 수집 동의 여부") @RequestParam("emailYn") String emailYn,
			@Parameter(description = "관심분야 코드") @RequestParam("interestsCode") String interestsCode,
			@Parameter(description = "관심분야 코드명") @RequestParam("interestsVal") String interestsVal,
			@Parameter(description = "체험 정보 동의 여부") @RequestParam("experienceYn") String experienceYn)
			throws Exception {

		// 1. 입력받은 전화번호, 고객명으로 통합고객 여부 체크
		CrmCustSo param = new CrmCustSo();
		param.setIndiInfoHandlPrsnNo("10022077");
		param.setCustNm(custNm);
		param.setMphonNo(mphonNo);
		int cnt = service.getListCount(param);

		// 없을경우 고객 생성
		if (cnt == 0) {
			CrmCustVo cust = new CrmCustVo();
			cust.setCustNm(custNm);
			cust.setMphonNo(mphonNo);
			cust.setBirthday(birthday);
			cust.setGndrCd(gndrCd);
			cust.setRcmdStorNo(storeId);
			cust.setHlthIntrstFildCd(interestsCode);
			cust.setHlthIntrstFildCdNm(interestsVal);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
			Date now = new Date();
			String procDt = sdf2.format(now);

			cust.setMarketingAgreeYn(marketingYn);
			cust.setMarketingAgreeDt(procDt);
			cust.setMarketingAgreeChlCd("EXP");

			cust.setInfoAgreeYn(collectYn);
			cust.setInfoAgreeDt(procDt);
			cust.setInfoAgreeChlCd("EXP");

			cust.setSmsRcvAgreeYn(smsYn);
			cust.setSmsRcvAgreeDt(procDt);
			cust.setSmsRcvAgreeChlCd("EXP");

			cust.setEmailRcvAgreeYn(emailYn);
			cust.setEmailRcvAgreeDt(procDt);
			cust.setEmailRcvAgreeChlCd("EXP");

			cust.setExprnInfoAgreeYn(experienceYn);
			cust.setExprnInfoAgreeDt(procDt);
			cust.setExprnInfoAgreeChlCd("EXP");

			CrmAgreementVo agreement = new CrmAgreementVo();
			agreement.setCollectYn(collectYn);
			agreement.setMarketingYn(marketingYn);
			agreement.setSmsRcvAgreeYn(smsYn);
			agreement.setEmailRcvAgreeYn(emailYn);
			agreement.setExprnInfoAgreeYn(experienceYn);
			agreement.setRegChlCd("EXP");
			cust.setAgreement(agreement);

			service.insert(cust);
		} else {
//			CrmCustVo custVo = service.getNamePhone(param);
//			CrmCustVo cust = new CrmCustVo();
//			cust.setItgCustNo(custVo.getItgCustNo());
//			cust.setCustNm(custNm);
//			cust.setMphonNo(mphonNo);
//			cust.setBirthday(birthday);
//			cust.setGndrCd(gndrCd);
//			cust.setHlthIntrstFildCd(interestsCode);
//			cust.setHlthIntrstFildCdNm(interestsVal);
//
//			CrmAgreementVo agreement = new CrmAgreementVo();
//			agreement.setCollectYn(collectYn);
//			agreement.setMarketingYn(marketingYn);
//			agreement.setSmsRcvAgreeYn(smsYn);
//			agreement.setEmailRcvAgreeYn(emailYn);
//			agreement.setExprnInfoAgreeYn(experienceYn);
//			agreement.setRegChlCd("EXP");
//			cust.setAgreement(agreement);
//			service.update(cust);
		}

		// 고객정보 조회
		List<CrmCustVo> list = service.getList(param);
		if (list.size() != 0) {
			CrmCustVo cust = list.get(0);
			// 카카오톡 알림톡 발송
			// 4. 알림톡 발송 처리
			Map<String, Object> params = new HashMap<>();
			params.put("codeCd", "415");
			params.put("itgCustNo", cust.getItgCustNo());
			params.put("custNm", custNm);
			params.put("mphonNo", mphonNo);
			params.put("cardNo", cust.getCardNo());
			eonMessageService.sendCustBarcodeMessage2(params);
		}

		return successResponse();
	}

	/**
	 *
	 * @author 김정
	 * @date 2024. 01. 08.
	 * @param String, String *
	 * @return
	 * @throws Exception
	 * @description MINDFIT 사용이력 조회 API
	 *
	 */
	@GetMapping("mindfit/list")
	@Operation(summary = "Mindfit 고객사용이력 gethering", description = "Mindfit 고객사용이력을 가져오는 API, CRM BATCH에서 사용")
	public ResponseEntity<ApiResultVo<String>> getMindfitUseList(
			@Parameter(description = "Mindfit 사용이력 조회시작일자") @RequestParam(name = "fromDt", required = true) String fromDt,
			@Parameter(description = "Mindfit 사용이력 조회종료일자") @RequestParam(name = "toDt", required = true) String toDt)
			throws Exception {

		// YYYY-MM-DD 날짜 패턴
		String datePattern = "^[\\d]{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
		if (!fromDt.matches(datePattern) || !toDt.matches(datePattern))
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "yyyy-mm-dd 형식의 날짜 데이터만 입력해주세요.");

		Map<String, Object> params = new HashMap<>();
		params.put("from", fromDt);
		params.put("to", toDt);

		String result = service.getMindfitUseList(params);

		if (result.equals("[]"))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);

		return successResponse(result);
	}

}
