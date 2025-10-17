package com.ceragem.api.crm.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.ceragem.api.base.model.ApiBasePagination;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.model.ApiVoidResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmAcqieHstSo;
import com.ceragem.api.crm.model.CrmAcqieHstVo;
import com.ceragem.api.crm.model.CrmAgreementVo;
import com.ceragem.api.crm.model.CrmAppPushTrmHstVo;
import com.ceragem.api.crm.model.CrmCustInfoPtuseAgreeHstSo;
import com.ceragem.api.crm.model.CrmCustInfoPtuseAgreeHstVo;
import com.ceragem.api.crm.model.CrmCustSo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmMshipAppToknBasVo;
import com.ceragem.api.crm.model.CrmSnstvInfoInqrySo;
import com.ceragem.api.crm.service.CrmAcqieHstService;
import com.ceragem.api.crm.service.CrmCustInfoPtuseAgreeHstService;
import com.ceragem.api.crm.service.CrmCustService;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.YnValue;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmCustBasController
 * @author 김성태
 * @date 2022. 4. 8.
 * @Version 1.0
 * @description CRM멤버십 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM멤버십", description = "CRM멤버십 API")
@RestController
@Validated
@RequestMapping("/crm/v1.0/membership")
public class CrmMembershipController extends BaseRestController {

	@Autowired
	CrmCustService service;

	@Autowired
	CrmCustInfoPtuseAgreeHstService agreeService;

	@Autowired
	CrmAcqieHstService acqService;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 8.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM멤버십 검색", description = "CRM멤버십 검색 [개인정보취급자번호-indiInfoHandlPrsnNo,접속자IP주소-connPrsnIpAddr,수행업무코드-pfmWorkCd 모두 제공시 암호화 해제 후 전송]")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustVo>>> getCrmCustBasList(
			@Parameter(description = "CRM멤버십 검색객체") @ParameterObject @Valid CrmCustSo so) throws Exception {
		service.checkCustSo(so);
//		so.setForceDecrypt(true);
		so.setMembershipOnly("Y");
		EzMap param = new EzMap(so);
		List<CrmCustVo> list = service.getList(param);
		int cnt = service.getListCount(param);
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
	 * @description CRM멤버십단건 검색
	 *
	 */
	@GetMapping("/{itgCustNo}")
	@Operation(summary = "CRM멤버십 단건", description = "CRM멤버십 단건 검색 [개인정보취급자번호-indiInfoHandlPrsnNo,접속자IP주소-connPrsnIpAddr 모두 제공시 암호화 해제 후 전송]")
	public ResponseEntity<ApiResultVo<CrmCustVo>> getCrmCustBas(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
//			@Parameter(description = "연락처포함여부") @RequestParam(value = "includeContactYn", required = false, defaultValue = "N") String includeContactYn,
			@Parameter(description = "개인정보 취급자 정보") @RequestParam(name = "indiInfoHandlPrsnNo", required = false) String indiInfoHandlPrsnNo,
			@Parameter(description = "접속아이피") @RequestParam(name = "connPrsnIpAddr", required = false) String connPrsnIpAddr,
			@Parameter(description = "개인정보 취급자 정보", required = false, hidden = true) @ModelAttribute CrmSnstvInfoInqrySo info)
			throws Exception {
//		String contactYn = includeContactYn;
		CrmCustSo so = new CrmCustSo();
		so.setSo(info);
//		so.setForceDecrypt(true);

//		if (Utilities.isEmpty(contactYn))
//			contactYn = "N";
//		so.setIncludeContactYn(contactYn);
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
	@Operation(summary = "CRM멤버십 휴면등록", description = "CRM멤버십 휴면등록")
	public ResponseEntity<ApiVoidResultVo> dormancy(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "메시지코드") @RequestBody(required = false) String codeCd) throws Exception {

		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(itgCustNo);
		vo.setCodeCd(codeCd);
		vo.setCustStatusCd(Constants._USER_STATUS_DORMANT);
		service.updateDormant(vo);

		return successResponse();
	}

	@Deprecated
	@PostMapping("/dormancy-cancel/{itgCustNo}")
	@Operation(summary = "CRM멤버십 휴면취소", description = "CRM멤버십 휴면취소")
	public ResponseEntity<ApiVoidResultVo> cancelDormancy(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "메시지코드") @RequestBody(required = false) String codeCd) throws Exception {

		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(itgCustNo);
		vo.setCodeCd(codeCd);
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
	 * @description CRM멤버십 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM멤버십 입력", description = "CRM멤버십 입력")
	public ResponseEntity<ApiResultVo<CrmCustVo>> registerCrmCustBas(
			@Parameter(description = "CRM멤버십 객체") @RequestBody @Valid CrmCustVo vo) throws Exception {
		int ret = service.insertMembership(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		vo.setDecryptYn("Y");
		return successResponse(service.get(vo));
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
	@PutMapping("")
	@Operation(summary = "CRM멤버십 수정", description = "CRM멤버십 수정")
	public ResponseEntity<ApiResultVo<CrmCustVo>> modifyCrmCustBas(
			@Parameter(description = "CRM고객 객체", hidden = true) @RequestBody Map<String, Object> param,
			@Parameter(description = "CRM고객 객체") CrmCustVo v) throws Exception {

		CrmCustVo vo = service.getModifiedCust(param);
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
	 * @description CRM멤버십 삭제
	 *
	 */
	@DeleteMapping("/{itgCustNo}")
	@Operation(summary = "CRM멤버십 탈회", description = "CRM멤버십 탈회")
	public ResponseEntity<ApiVoidResultVo> removeCrmCustBas(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "메시지코드") @RequestBody(required = false) String codeCd) throws Exception {
		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(itgCustNo);
		vo.setCodeCd(codeCd);
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
	@Operation(summary = "CRM멤버십 정보 by 로그인아이디", description = "CRM멤버십 정보 by 로그인아이디")
	public ResponseEntity<ApiResultVo<CrmCustVo>> loginMember(
			@Parameter(description = "로그인 아이디") @RequestParam("mshipLoginId") String mshipLoginId
//			@Parameter(description = "로그인 암호") @RequestParam("loginPwd") String loginPwd
//			@Parameter(description = "접속 아이피") @RequestParam("ipAddr") String ipAddr
	) throws Exception {
		CrmCustVo vo = new CrmCustVo();
		vo.setDecryptYn("Y");
		vo.setMshipLoginId(mshipLoginId);
//		vo.setMshipLoginPwd(loginPwd);
		CrmCustVo user = service.getLoginUser(vo);
//		CrmCustVo user = service.login(vo);
		if (user == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(user);
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
	@GetMapping("/login-pwd")
	@Hidden
	@Operation(summary = "CRM멤버십 정보 by 로그인아이디/pwd", description = "CRM멤버십 정보 by 로그인아이디/Pwd")
	public ResponseEntity<ApiResultVo<CrmCustVo>> loginMemberPwd(
			@Parameter(description = "로그인 아이디") @RequestParam("mshipLoginId") String mshipLoginId,
			@Parameter(description = "로그인 암호") @RequestParam("loginPwd") String loginPwd
//			@Parameter(description = "접속 아이피") @RequestParam("ipAddr") String ipAddr
	) throws Exception {
		CrmCustVo vo = new CrmCustVo();
		vo.setDecryptYn("Y");
		vo.setMshipLoginId(mshipLoginId);
		vo.setMshipLoginPwd(loginPwd);
		CrmCustVo user = service.getLoginUserPwd(vo);
		if (user == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(user);

	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 19.
	 * @param loginId
	 * @return
	 * @throws Exception
	 * @description
	 *
	 */
	@GetMapping("/login-id/duplicate")
	@Operation(summary = "로그인아이디 중복체크", description = "로그인아이디 중복체크 [hasId : Y/N]")
	public ResponseEntity<ApiResultVo<Object>> duplicate(
			@Parameter(description = "로그인 아이디") @RequestParam("mshipLoginId") String mshipLoginId) throws Exception {
		CrmCustVo vo = new CrmCustVo();
//		vo.setDecryptYn("Y");
		vo.setMshipLoginId(mshipLoginId);
		CrmCustVo user = service.getLoginUser(vo);
		EzMap map = new EzMap();
		map.setString("hasId", user == null ? "N" : "Y");
		return successResponse(map);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 18.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 고객정보활용동의
	 *
	 */
	@PostMapping("/agree")
	@Operation(summary = "고객정보활용동의", description = "고객정보활용동의")
	public ResponseEntity<ApiResultVo<CrmCustVo>> agree(
			@Parameter(description = "CRM고객 객체") @RequestBody @Valid CrmAgreementVo vo) throws Exception {

		return successResponse(service.updateAgreement(vo));
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

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 19.
	 * @param agree
	 * @return
	 * @throws Exception
	 * @description 이벤트처리 * 매장번호 공통코드 : EV100 [010 : 웰카페 체험추천 , 020 : 홈체험 추천 , 030 :
	 *              멤버십 가입 추천 , 040 : 웰카페 체험 , 050 : 홈체험 , 060 : 멤버십회원 가입 , 070 :
	 *              마케팅정보 수신동의 , 080 : 앱 다운로드 , 090 : 추가 정보 입력 , 100 : 생일 , 110 :
	 *              휴면방지 , 120 : 휴면해제 , 130 : 출석체크 , 140 : 텍스트 후기 작성 , 150 : 이미지 후기
	 *              작성 , 160 : 동영상 후기 작성 , 170 : 세라체크 , 180 : 서베이 , 190 : IoT , 901
	 *              : 구매 , 902 : 구매추천]
	 *
	 */
	@GetMapping("/event/{itgCustNo}/{eventCd}/{regChlCd}")
	@Operation(summary = "멤버십이벤트처리", description = "멤버십이벤트")
	public ResponseEntity<ApiResultVo<Object>> event(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "이벤트코드 [EV100] [010 : 웰카페 체험추천 , 020 : 홈체험 추천 , 030 : 멤버십 가입 추천 , 040 : 웰카페 체험 , 050 : 홈체험 , 060 : 멤버십회원 가입 , 070 : 마케팅정보 수신동의 , 080 : 앱 다운로드 , 090 : 추가 정보 입력 , 100 : 생일 , 110 : 휴면방지 , 120 : 휴면해제 , 130 : 출석체크 , 140 : 텍스트 후기 작성 , 150 : 이미지 후기 작성 , 160 : 동영상 후기 작성 , 170 : 세라체크 , 180 : 서베이 , 190 : IoT , 903 : 스탬프, 904 : 쿠폰, 905 : 프로모션, 940 : 수기차감, 950 : 수기지급, 960 : 캠페인지급, 970 : 승급]") @PathVariable("eventCd") String eventCd,
			@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]") @PathVariable("regChlCd") String regChlCd,
			@Parameter(description = "추천인통합고객번호") @RequestParam(name = "rcmdrCustNo", required = false) String rcmdrCustNo)
			throws Exception {

		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(itgCustNo);

		CrmCustVo custVo = service.get(vo);
		custVo.setItgCustNo(itgCustNo);
		custVo.setEventCd(eventCd);
		custVo.setPblsChlCd(regChlCd);
		custVo.setRegChlCd(regChlCd);
		custVo.setRcmdrCustNo(rcmdrCustNo);
		custVo.setOrgItgCustNo(itgCustNo);
		custVo.setOrgMshipGradeCd(custVo.getMshipGradeCd());
		custVo.setOrgMshipPlcyBasNo(custVo.getOrgMshipPlcyBasNo());
		custVo.setCpnPblsAddYn("N");

		if (itgCustNo.equals(rcmdrCustNo)) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "통합고객과 추천인이 같을 수 없습니다.");
		}

		// 010, 020, 030 일 경우 무조건 추천 히스토리 작성
		String[] rcmdEventCd = { "010", "020", "030" };

		if (Arrays.asList(rcmdEventCd).contains(custVo.getEventCd()) && !"".equals(rcmdrCustNo)) {

			CrmCustVo vo1 = new CrmCustVo();
			vo1.setItgCustNo(rcmdrCustNo);

			CrmCustVo custVo2 = service.get(vo1);
			if (custVo2 != null) {
				custVo.setMshipGradeCd(custVo2.getMshipGradeCd());
				service.saveRcmdHst(custVo);
			}
		}

		Map<String, Object> evtInfo = service.getEventChk(custVo);

		// 2022-09-29 추가호출
		// 멤버십회원 가입일 경우 쿠폰만 1번 더 지급한다.
		if ("060".equals(custVo.getEventCd())) {
			custVo.setCpnPblsAddYn("Y");
			evtInfo = service.getEventChk(custVo);
		}

		Map<String, Object> evParam = new HashMap<>();
		evParam.put("eventCd", eventCd);
		evParam.put("itgCustNo", itgCustNo);
		evParam.put("regChlCd", regChlCd);
		// 특별쿠폰발급
		Map<String, Object> ec = service.issueEvent(evParam);
		if (Utilities.isNotEmpty(ec))
			evtInfo.putAll(ec);
		return successResponse(evtInfo);
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
			@Parameter(description = "방문일시", required = false) @RequestParam(name = "visitDt", required = false) String visitDt,
			@Parameter(description = "통합고객객체", required = false, hidden = true) @ModelAttribute CrmCustVo vo)
			throws Exception {
		vo.setMshipLastVisitStorNo(storNo);
		vo.setItgCustNo(itgCustNo);
		int ret = service.updateLastVisitStore(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 8.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 최종로그인성공
	 *
	 */
	@PostMapping("login-success")
	@Operation(summary = "최종로그인성공", description = "최종로그인성공")
	public ResponseEntity<ApiVoidResultVo> loginSuccess(
			@Parameter(description = "통합회원코드") @RequestParam("itgCustNo") String itgCustNo,
			@Parameter(description = "최종로그인 IP", required = false) @RequestParam("mshipLastLoginIpAddr") String mshipLastLoginIpAddr,
			@Parameter(description = "최종로그인일시(YYYYMMDDHH24MISS) 미제공 => 현재시간") @RequestParam(name = "mshipLastLoginDt", required = false) String mshipLastLoginDt,
			@Parameter(description = "푸시토큰") @RequestParam(name = "appPushTokn", required = false) String appPushTokn,
			@Parameter(description = "푸시앱OS코드 [1: 안드로이드,2: iOs]") @RequestParam(name = "appPushOsCd", required = false) String appPushOsCd,
			@Parameter(description = "푸시동의여부") @RequestParam(name = "pushRcvAgreeYn", required = false) String pushRcvAgreeYn,
			@Parameter(description = "통합고객객체", required = false, hidden = true) @ModelAttribute CrmCustVo vo)
			throws Exception {

		vo.setItgCustNo(itgCustNo);
		vo.setMshipLastLoginDt(mshipLastLoginDt);
		vo.setMshipLastLoginIpAddr(mshipLastLoginIpAddr);
		vo.setAppPushTokn(appPushTokn);
		vo.setAppPushOsCd(appPushOsCd);
		vo.setPushRcvAgreeYn(pushRcvAgreeYn);
		int ret = service.updateLastLogin(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
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
	 * @description 로그인암호변경
	 *
	 */
	@PostMapping("change-password")
	@Operation(summary = "로그인암호변경", description = "로그인암호변경")
	public ResponseEntity<ApiVoidResultVo> savePassword(
			@Parameter(description = "통합회원코드") @RequestParam("itgCustNo") String itgCustNo,
			@Parameter(description = "로그인암호", required = false) @RequestParam("mshipLoginPwd") String mshipLoginPwd,
			@Parameter(description = "통합고객객체", required = false, hidden = true) @ModelAttribute CrmCustVo vo)
			throws Exception {
		vo.setMshipLoginPwd(mshipLoginPwd);
		vo.setItgCustNo(itgCustNo);
		int ret = service.updateLoginPassword(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
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
	 * @description 아이디-암호변경
	 *
	 */
	@PostMapping("change-id-password")
	@Operation(summary = "로그인아이디-암호변경", description = "로그인아이디-암호변경")
	public ResponseEntity<ApiVoidResultVo> savePassword(
			@Parameter(description = "통합회원코드") @RequestParam("itgCustNo") String itgCustNo,
			@Parameter(description = "로그인아이디", required = false) @RequestParam("mshipLoginId") String mshipLoginId,
			@Parameter(description = "로그인암호", required = false) @RequestParam("mshipLoginPwd") String mshipLoginPwd,
			@Parameter(description = "통합고객객체", required = false, hidden = true) @ModelAttribute CrmCustVo vo)
			throws Exception {
		vo.setMshipLoginId(mshipLoginId);
		vo.setMshipLoginPwd(mshipLoginPwd);
		vo.setItgCustNo(itgCustNo);
		int ret = service.updateLoginIdPassword(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
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
	 * @description 아이디-암호변경
	 *
	 */
	@PostMapping("register-alliance")
	@Operation(summary = "제휴회원등록", description = "제휴회원등록")
	public ResponseEntity<ApiVoidResultVo> saveAlliance(
			@Parameter(description = "통합회원코드") @RequestParam(name = "itgCustNo", required = false) String itgCustNo,
			@Parameter(description = "휴대전화번호") @RequestParam(name = "mphonNo", required = false) String mphonNo,
			@Parameter(description = "사용자명") @RequestParam("custNm") String custNm,
			@Parameter(description = "사번") @RequestParam("empNo") String empNo,
			@Parameter(description = "제휴사코드") @RequestParam(name = "cprtCmpNo", required = false) String cprtCmpNo)
			throws Exception {
		EzMap vo = new EzMap();
		vo.put("itgCustNo", itgCustNo);
		vo.put("mphonNo", mphonNo);
		vo.put("custNm", custNm);
		vo.put("empNo", empNo);
		vo.put("cprtCmpNo", cprtCmpNo);
		int ret = service.saveAlliance(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, "등록된 제휴회원이 아닙니다.");
		return successResponse();
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 18.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 고객정보활용동의
	 *
	 */
	@PostMapping("/app-token/{itgCustNo}")
	@Deprecated
	@Operation(summary = "멤버십앱토큰정보저장", description = "토큰정보저장")
	public ResponseEntity<ApiVoidResultVo> appToken(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "토큰") @RequestParam("token") String token,
			@Parameter(description = "OS정보( 1:안드로이드, 2:iOs , 3 Web )") @RequestParam("osCd") String appPushOsCd,
			@Parameter(description = "푸시수신동의여부") @RequestParam(value = "agreeYn", required = false) String pushRcvAgreeYn)
			throws Exception {
		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(itgCustNo);
		vo.setAppPushTokn(token);
		vo.setAppPushOsCd(appPushOsCd);
		vo.setPushRcvAgreeYn(pushRcvAgreeYn);
		int ret = service.updateAppToken(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, "회원이 아닙니다.");
		return successResponse();
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 18.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 고객정보활용동의
	 *
	 */
	@PostMapping("/push-token")
	@Operation(summary = "토큰정보저장", description = "토큰정보저장")
	public ResponseEntity<ApiVoidResultVo> pushToken(
			@Parameter(description = "CRM앱푸시토큰 객체") @RequestBody @Valid CrmMshipAppToknBasVo vo) throws Exception {
		int ret = service.updateAppToken(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, "해당채널에 등록된 앱이 존재하지 않습니다.");
		return successResponse();
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 18.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 푸시읽음상태저장
	 *
	 */
	@GetMapping("/push-read")
	@Operation(summary = "푸시열람상태저장", description = "푸시열람상태저장")
	public ResponseEntity<ApiVoidResultVo> pushRead(
			@Parameter(description = "푸시전송ID") @RequestParam("dspHstId") String dspHstId,
			@Parameter(description = "앱푸시토큰") @RequestParam("appPushTokn") String appPushTokn,
			@Parameter(description = "통합고객번호", hidden = true) @RequestParam(required = false, value = "itgCustNo") String itgCustNo)
			throws Exception {
		EzMap so = new EzMap();
		so.setString("dspHstId", dspHstId);
		so.setString("appPushTokn", appPushTokn);
		so.setString("itgCustNo", itgCustNo);
		int ret = service.updateAppPushRead(so);
		if (ret == 0) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		return successResponse();
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 18.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 푸시읽음상태저장
	 *
	 */
	@GetMapping("/push-read-all/{itgCustNo}")
	@Operation(summary = "푸시전체열람처리", description = "푸시전체열람처리")
	public ResponseEntity<ApiVoidResultVo> pushAllRead(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo) throws Exception {
		EzMap so = new EzMap();
		so.setString("itgCustNo", itgCustNo);
		int ret = service.updateAppPushReadAll(so);
		if (ret == 0) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		return successResponse();
	}

	@GetMapping("/push-info")
	@Operation(summary = "푸시정보조회", description = "푸시정보조회")
	public ResponseEntity<ApiResultVo<CrmAppPushTrmHstVo>> pushInfo(
			@Parameter(description = "푸시전송ID") @RequestParam("dspHstId") String dspHstId,
			@Parameter(description = "앱푸시토큰") @RequestParam("appPushTokn") String appPushTokn,
			@Parameter(description = "통합고객번호", hidden = true) @RequestParam(required = false, value = "itgCustNo") String itgCustNo)
			throws Exception {
		EzMap so = new EzMap();
		so.setString("dspHstId", dspHstId);
		so.setString("appPushTokn", appPushTokn);
		so.setString("itgCustNo", itgCustNo);
		CrmAppPushTrmHstVo ret = service.selectPushTrm(so);
		if (ret == null) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		return successResponse(ret);
	}

	@GetMapping("/push-list/{itgCustNo}")
	@Operation(summary = "푸시발송내역", description = "푸시발송내역")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmAppPushTrmHstVo>>> pushList(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
//			@Parameter(description = "전송성공여부") @RequestParam(value = "successYn", required = false) @YnValue String successYn,
			@Parameter(description = "푸시열람상태") @RequestParam(value = "pushStatusCd", required = false) @CodeValue(codeId = "PS070") String pushStatusCd,

			@Parameter(description = "푸시열람여부") @RequestParam(value = "readYn", required = false) @YnValue String readYn,
			@Parameter(description = "CRM멤버십 검색객체") @ParameterObject @Valid ApiBasePagination pagination)
			throws Exception {
		EzMap so = new EzMap(pagination);
		so.setString("itgCustNo", itgCustNo);
		so.setString("pushStatusCd", pushStatusCd);
//		so.setString("successYn", successYn);
		so.setString("readYn", readYn);
		List<CrmAppPushTrmHstVo> list = service.selectPushTrmList(so);
		if (list == null) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		pagination.setTotalRecordCount(service.selectPushTrmListCount(so));
		return successResponse(list, pagination);
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
}
