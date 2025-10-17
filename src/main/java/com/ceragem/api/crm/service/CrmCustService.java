package com.ceragem.api.crm.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.config.jwt.EzJwtService;
import com.ceragem.api.crm.dao.CrmAcqieHstDao;
import com.ceragem.api.crm.dao.CrmBllkCustHstDao;
import com.ceragem.api.crm.dao.CrmCustBasDao;
import com.ceragem.api.crm.dao.CrmCustBosCntrtHstDao;
import com.ceragem.api.crm.dao.CrmCustHshldBasDao;
import com.ceragem.api.crm.dao.CrmCustPatronStorBasDao;
import com.ceragem.api.crm.dao.CrmDormCustBasDao;
import com.ceragem.api.crm.dao.CrmMshipAppToknBasDao;
import com.ceragem.api.crm.dao.CrmMshipCoupnBasDao;
import com.ceragem.api.crm.dao.CrmMshipLoginHstDao;
import com.ceragem.api.crm.dao.CrmMshipPlcyBasDao;
import com.ceragem.api.crm.dao.CrmMshipStmpBasDao;
import com.ceragem.api.crm.dao.CrmPointHstDao;
import com.ceragem.api.crm.dao.CrmRcmdHstDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.dao.MsgIfDao;
import com.ceragem.api.crm.model.CrmAdvncmtHstVo;
import com.ceragem.api.crm.model.CrmAgreementVo;
import com.ceragem.api.crm.model.CrmAppPushTrmHstVo;
import com.ceragem.api.crm.model.CrmBllkCustHstSo;
import com.ceragem.api.crm.model.CrmBllkCustHstVo;
import com.ceragem.api.crm.model.CrmCouponVo;
import com.ceragem.api.crm.model.CrmCustBosCntrtHstVo;
import com.ceragem.api.crm.model.CrmCustCntplcBasSo;
import com.ceragem.api.crm.model.CrmCustCntplcBasVo;
import com.ceragem.api.crm.model.CrmCustInfoChngHstVo;
import com.ceragem.api.crm.model.CrmCustInstallLocVo;
import com.ceragem.api.crm.model.CrmCustPatronStorBasVo;
import com.ceragem.api.crm.model.CrmCustSo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmDormCustBasVo;
import com.ceragem.api.crm.model.CrmMshipAppToknBasVo;
import com.ceragem.api.crm.model.CrmMshipApplyAdvncmtRelVo;
import com.ceragem.api.crm.model.CrmMshipApplyCoupnEventRelVo;
import com.ceragem.api.crm.model.CrmMshipApplyPointRelVo;
import com.ceragem.api.crm.model.CrmMshipLoginHstVo;
import com.ceragem.api.crm.model.CrmMshipPlcyBasVo;
import com.ceragem.api.crm.model.CrmMshipStmpEventVo;
import com.ceragem.api.crm.model.CrmMshipStmpIssueVo;
import com.ceragem.api.crm.model.CrmPointHstVo;
import com.ceragem.api.crm.model.CrmPointInfoVo;
import com.ceragem.api.crm.model.CrmRcmdHstVo;
import com.ceragem.api.crm.model.CrmSnstvInfoInqryHstVo;
import com.ceragem.api.crm.model.CrmSnstvInfoInqrySo;
import com.ceragem.api.crm.model.MsgCodeVo;
import com.ceragem.api.crm.model.MsgIfVo;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName CrmCustBasService
 * @author user
 * @date 2022. 4. 5.
 * @Version 1.0
 * @description CRM고객기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Service
public class CrmCustService extends AbstractCrmService {

	private final static String API_CODE_EVENT_CODE = "IAR0501";
	private final static String API_CODE_EVENT_CODE_MSG = "이벤트 코드가 없습니다.";

//	private final SimpleDateFormat DATETIME_FORMAT_ORG = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREAN);
//	private final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREAN);
	@Value("${spring.profiles.active}")
	String activeProfile;

	@Value("${spring.eon.sms-sender-no}")
	String smsSenderNo;

	@Value("${spring.eon.sms-sender-name}")
	String smsSenderName;

	@Value("${spring.eon.talk-sender-key}")
	String talkSenderKey;

	@Value("${spring.eon.user}")
	String eonUser;

	@Value("${bos.use-event}")
	boolean useEvent = false;

	@Value("${crm.event.lab-url}")
	String labEventUrl;

	@Value("${crm.event.com-url}")
	String comEventUrl;

	@Value("${crm.event.chk-url}")
	String chkEventUrl;

	@Value("${crm.event.mem-url}")
	String memEventUrl;

	@Value("${mindfit.access_key}")
	String mindfitAccessKey; // Ybrain Mindfit AccessKey
	@Value("${mindfit.secret_key}")
	String mindfitSecretKey; // Ybrain Mindfit SecretKey
	@Value("${mindfit.api.base-url}")
	String mindfitBaseUrl; // Ybrain Mindfit Api Base Url
	@Value("${mindfit.api.path}")
	String mindfitPath; // Ybrain Mindfit Path

	boolean useDorm = false;

	private final static String API_EVENT_EXIST = "NOT_EXIST";
	private final static String API_EVENT_EXIST_MSG = "해당하는 이벤트 정책이 없습니다.";

	private final static String API_CODE_CALL_DOUBLE = "DOUBLE";
	private final static String API_CODE_CALL_DOUBLE_MSG = "이미 호출된(더블클릭) 내역입니다.";

	private final static String API_CODE_PAY_OVER_01 = "TOTAL";
	private final static String API_CODE_PAY_OVER_01_MSG = "총지급 횟수를 초과했습니다.";

	private final static String API_CODE_PAY_OVER_02 = "MONTH";
	private final static String API_CODE_PAY_OVER_02_MSG = "1개월 지급 횟수를 초과했습니다.";

	private final static String API_CODE_PAY_OVER_03 = "TODAY";
	private final static String API_CODE_PAY_OVER_03_MSG = "1일 지급 횟수를 초과했습니다.";

	private final static String API_CODE_PNT_OVER = "PNT_OVER";
	private final static String API_CODE_PNT_OVER_MSG = "1일 적립한도를 초과했습니다.";

	@Autowired
	CrmCustBasDao dao;

	@Autowired
	CrmSnstvInfoInqryHstService inqHstService;

	@Autowired
	CrmCustCntplcBasService contactService;

	@Autowired
	CrmCustHshldBasDao hshldDao;

	@Autowired
	CrmDormCustBasDao dormDao;

	@Autowired
	CrmBllkCustHstDao blackDao;

	@Autowired
	CrmCustInfoChngHstService infoChangeService;

	@Autowired
	CrmCustInfoPtuseAgreeHstService agreeService;

	@Autowired
	CrmCouponService couponService;

	@Autowired
	CrmMshipCoupnBasDao couponDao;

	@Autowired
	CrmPointHstService pointHstService;

	@Autowired
	CrmPointHstDao pointHstDao;

	@Autowired
	CrmMshipPlcyBasDao plcyDao;

	@Autowired
	CrmAcqieHstDao acqDao;

	@Autowired
	CrmAdvncmtHstService advnCmtHstService;

	@Autowired
	CrmAsyncService asyncService;

	@Autowired
	MsgIfDao msgIfDao;

	@Autowired
	EonMessageService messageService;

	@Autowired
	CrmRcmdHstDao rcmdHstDao;

	@Autowired
	BosApiService bosApiService;

	@Autowired
	CrmCustPatronStorBasDao patronDao;

	@Autowired
	CrmCustBosCntrtHstDao contractDao;

	@Autowired
	CrmMshipLoginHstDao loginHstDao;

	@Autowired
	CrmMshipAppToknBasDao tokenDao;

	@Autowired
	CrmMshipStmpBasService stmpService;

	@Autowired
	CrmMshipStmpBasDao stmpDao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCustVo> getList(Object param) throws Exception {
		CrmCustSo so = Utilities.beanToBean(param, CrmCustSo.class);
		List<CrmCustVo> list = super.getList(so);
		if ("Y".equals(so.getIncludeContactYn())) {
			patchContact(list, so);
		}
		inqHstService.decryptCust(param, list);
		return list;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 6.
	 * @param list
	 * @throws Exception
	 * @description 연락처 리스트 추가
	 *
	 */
	private void patchContact(List<CrmCustVo> list, CrmSnstvInfoInqrySo iso) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			patchContact(list.get(i), iso);
		}

	}

	private void patchContact(CrmCustVo vo, CrmSnstvInfoInqrySo iso) throws Exception {
		CrmCustCntplcBasSo so = new CrmCustCntplcBasSo();
		so.setItgCustNo(vo.getItgCustNo());
		so.setRecordCountPerPage(1000);
		so.setSo(iso);
		List<CrmCustCntplcBasVo> cntplcList = contactService.getList(so);
		vo.setCntplcList(cntplcList);

	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCustVo get(Object param) throws Exception {

		CrmCustVo vo = super.get(param);
		if (vo == null)
			return vo;
		if (Constants._USER_STATUS_DELETE.equals(vo.getCustStatusCd()))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		CrmCustSo so = Utilities.beanToBean(param, CrmCustSo.class);
		if ("Y".equals(so.getIncludeContactYn())) {
			patchContact(vo, so);
		}
		// CrmCustCntplcBasSo so = new CrmCustCntplcBasSo();
		// so.setItgCustNo(vo.getItgCustNo());
		// so.setRecordCountPerPage(1000);
		// Map<String, Object> map = Utilities.beanToMap(so);
		// List<CrmCustCntplcBasVo> cntplcList = cntplcService.getList(map);
		// vo.setCntplcList(cntplcList);
		//
		// List<CrmCustHshldBasVo> hshldList = hshldDao.selectList(map);
		// vo.setHshldList(hshldList);

		return inqHstService.decryptCust(so, vo);
	}

	public CrmCustVo getMembership(CrmCustSo param) throws Exception {

		CrmCustVo vo = get(param);
		if (Utilities.isEmpty(vo.getMshipLoginId()))
			return null;

		return vo;
	}

	@Override
	public int insert(Object param) throws Exception {
		CrmCustVo vo = (CrmCustVo) param;

		inqHstService.encrypt(vo);
		vo.setItgCustNo(null);
		vo.setRegrId(vo.getIndiInfoHandlPrsnNo());
		vo.setAmdrId(vo.getIndiInfoHandlPrsnNo());
		checkDuplication(vo);

		if (Utilities.isNotEmpty(vo.getCustNm()))
			vo.setCustNm(vo.getCustNm().trim());
		int ret = super.insert(vo);

		if (ret > 0) {
			String reason = "신규통합고객등록";
			List<CrmCustInfoChngHstVo> infoList = null;
			infoList = infoChangeService.getChangeInfoList(vo.getItgCustNo(), reason, null,
					vo.getIndiInfoHandlPrsnNo());
			if (Utilities.isNotEmpty(infoList))
				infoChangeService.insertList(infoList);
			CrmAgreementVo agreement = vo.getAgreement();
			if (agreement != null) {
				agreement.setItgCustNo(vo.getItgCustNo());
				agreement.setRegrId(vo.getRegrId());
				agreement.setAmdrId(vo.getAmdrId());
				agreeService.updateAgreement(agreement);
			}
			contactService.updateLastInfo(vo);

			CrmSnstvInfoInqryHstVo hst = Utilities.beanToBean(vo, CrmSnstvInfoInqryHstVo.class);
			hst.setInqryCnt(1);
			hst.setPfmWorkCd("005");
			hst.setRegChlCd(EzJwtService.getSystemCd());
			inqHstService.addLog(hst);

			dao.insertCard(vo);
		}
		asyncService.sendCustmerApiEvent(vo.getItgCustNo(), Constants._CUST_EVENT_REGISTER, getCallChannel());
		return ret;
	}

	public CrmCustVo getNamePhone(Object param) throws Exception {
		return dao.selectNamePhone(param);
	}

	public int getAge(String birthday) {
		if (Utilities.isEmpty(birthday))
			return 0;
		String day = Utilities.getDateString();
		int year = Utilities.parseInt(birthday.substring(0, 4));
		int cYear = Utilities.parseInt(day.substring(0, 4));
		int off = Utilities.parseInt(birthday.substring(4, 8));
		int coff = Utilities.parseInt(day.substring(4, 8));
		int age = cYear - year;
		int offset = off - coff > 0 ? -1 : 0;
		return age + offset;

	}

	public int insertMembership(CrmCustVo vo) throws Exception {
		String reason = "신규멤버십";
		int ret = 0;

		if (Utilities.isEmpty(vo.getBirthday())) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "멤버십 회원은 생년월일이 필수 입니다.");
		}
		int age = getAge(vo.getBirthday());
		if (age < 14) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "멤버십 회원은 만14세 이상만 가입 가능합니다.");
		}

		if (Utilities.isNotEmpty(vo.getCustNm()))
			vo.setCustNm(vo.getCustNm().trim());

		CrmCustVo dorm = dao.selectExitUser(vo);
		if (dorm != null) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM,
					"[탈회일시 : " + dorm.getMshipLeaveDt() + "]탈회후 한달이 경과하지 않은 회원입니다.");
		}
		if (Utilities.isEmpty(vo.getItgCustNo())) {
			CrmCustVo old = dao.selectNamePhone(vo);
			if (old != null) {
				if ("Y".equals(old.getMshipSbscYn())) {
					throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "이미 등록된 멤버십 회원입니다.");
				}
				vo.setItgCustNo(old.getItgCustNo());
			}
		}
		vo.setAmdrId(vo.getIndiInfoHandlPrsnNo());
		List<CrmCustInfoChngHstVo> infoList = null;
		inqHstService.encrypt(vo);
		checkDuplication(vo);
		if (Utilities.isEmpty(vo.getItgCustNo())) {
			ret = dao.insertMembership(vo);
			infoList = infoChangeService.getChangeInfoList(vo.getItgCustNo(), reason, null,
					vo.getIndiInfoHandlPrsnNo());
			dao.insertCard(vo);

		} else {
			infoList = infoChangeService.getChangeInfoList(vo.getItgCustNo(), reason, vo, vo.getIndiInfoHandlPrsnNo());
			dao.insertCard(vo);
			ret = dao.updateMembership(vo);
		}

		if (ret > 0 && vo != null) {
			CrmAgreementVo agreement = vo.getAgreement();
			if (agreement != null) {
				agreement.setAmdrId(vo.getIndiInfoHandlPrsnNo());
				agreement.setRegrId(vo.getIndiInfoHandlPrsnNo());
				agreement.setItgCustNo(vo.getItgCustNo());
				agreeService.updateAgreement(agreement);
			}
			contactService.updateLastInfo(vo);

			if (Utilities.isNotEmpty(infoList))
				infoChangeService.insertList(infoList);
		}

		CrmCustVo custVo = new CrmCustVo();
		custVo.setItgCustNo(vo.getItgCustNo());
		custVo.setEventCd("060");
		custVo.setPblsChlCd(vo.getRegChlCd());
		custVo.setRegChlCd(vo.getRegChlCd());
		custVo.setMshipSbscYn("Y");

		if (Utilities.isNotEmpty(vo.getRcmdStorNo())) {
			CrmCustPatronStorBasVo p = new CrmCustPatronStorBasVo();
			p.setItgCustNo(vo.getItgCustNo());
			p.setStorNo(vo.getRcmdStorNo());
			p.setRegChlCd(vo.getRegChlCd());
			p.setRegrId(vo.getRegrId());
			p.setAmdrId(vo.getAmdrId());

			CrmCustPatronStorBasVo patron = patronDao.selectStore(custVo);
			if (patron == null) {
				patronDao.insert(p);
			}
		}
		if (Utilities.isNotEmpty(vo.getRcmdrCustNo())) {
			CrmCustVo rcSo = new CrmCustVo();
			rcSo.setItgCustNo(vo.getRcmdrCustNo());
			CrmCustVo rc = dao.selectBasic(rcSo);
			if (rc != null && !"003".equals(rc.getCustStatusCd())) {
				CrmCustVo c = new CrmCustVo();
				c.setItgCustNo(custVo.getItgCustNo());
				c.setRcmdrCustNo(vo.getRcmdrCustNo());
//				c.setItgCustNo(vo.getRcmdrCustNo());
				c.setEventCd("030");
				c.setPblsChlCd(vo.getRegChlCd());
				c.setRegChlCd(vo.getRegChlCd());
				c.setMshipSbscYn("Y");
				getAsyncEventChk(c);
			}

		}
		getAsyncEventChk(custVo);
		asyncService.sendCustStatusMessage(vo.getItgCustNo(), "410");
		asyncService.sendCustmerApiEvent(vo.getItgCustNo(), Constants._CUST_EVENT_MEMBERSHIP, getCallChannel());
		return ret;
	}

	@Override
	public int update(Object param) throws Exception {
		return updateCustInfo(param, "API 변경");
	}

	public int updateCustInfo(Object param, String reason) throws Exception {

		CrmCustVo vo = null;
		List<CrmCustInfoChngHstVo> infoList = null;

		if (param instanceof CrmCustVo) {
			vo = (CrmCustVo) param;

			if ("Y".equals(vo.getMshipSbscYn())) {
				if (Utilities.isEmpty(vo.getBirthday())) {
					throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "멤버십 회원은 생년월일이 필수 입니다.");
				}
				int age = getAge(vo.getBirthday());
				if (age < 14) {
					throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "멤버십 회원은 만14세 이상만 가입 가능합니다.");
				}
			}
			if (Utilities.isNotEmpty(vo.getIndiInfoAmdTxn()))
				reason = vo.getIndiInfoAmdTxn();
			vo.setAmdrId(vo.getIndiInfoHandlPrsnNo());
			vo.setRegrId(vo.getIndiInfoHandlPrsnNo());
			inqHstService.encrypt(vo);
			checkDuplication(vo);
			infoList = infoChangeService.getChangeInfoList(vo.getItgCustNo(), reason, param,
					vo.getIndiInfoHandlPrsnNo());
		}

		int ret = super.update(param);

		if (ret > 0 && vo != null) {
			CrmAgreementVo agreement = vo.getAgreement();
			if (agreement != null) {
				agreement.setItgCustNo(vo.getItgCustNo());
				agreement.setRegrId(vo.getIndiInfoHandlPrsnNo());
				agreement.setAmdrId(vo.getIndiInfoHandlPrsnNo());
				agreeService.updateAgreement(agreement);
			}
			contactService.updateLastInfo(vo);
			if (Utilities.isNotEmpty(infoList))
				infoChangeService.insertList(infoList);
			CrmSnstvInfoInqryHstVo hst = Utilities.beanToBean(vo, CrmSnstvInfoInqryHstVo.class);
			hst.setInqryCnt(1);
			hst.setPfmWorkCd("004");
			hst.setRegChlCd(EzJwtService.getSystemCd());

			inqHstService.addLog(hst);
		}
		asyncService.sendCustmerApiEvent(vo.getItgCustNo(), Constants._CUST_EVENT_MODIFY, getCallChannel());
		return ret;
	}

	public int updateNormal(CrmCustVo param) throws Exception {
		if (!useDorm)
			throw new EzApiException(Constants._API_CODE_DEPRECATED, Constants._API_CODE_DEPRECATED_MSG);
		CrmCustVo vo = dao.select(param);
		if (vo == null) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "등록되지 않은 회원입니다.");
		}
		String status = vo.getCustStatusCd();
		if (Constants._USER_STATUS_NORMAL.equals(status)) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "이미 정상 회원 상태입니다.");
		}
		CrmDormCustBasVo sel = dormDao.select(vo);
		if (sel == null) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "등독되지 않은 회원이거나 탈회 완료되어 복구할 수 없습니다.");
		}

		sel.setCustStatusCd(Constants._USER_STATUS_NORMAL);
		dormDao.delete(sel);
		int ret = dao.updateDormant(sel);

		CrmCustInfoChngHstVo info = new CrmCustInfoChngHstVo();
		info.setItgCustNo(vo.getItgCustNo());
		info.setChngClusCtnts("회원상태");
		info.setChngCtnts("정상");
		info.setChngPreCtnts(vo.getCustStatusCdNm());
		info.setChngWhyCtnts(getCallChannel() + " 변경");
		info.setRegrId(vo.getIndiInfoHandlPrsnNo());
		info.setAmdrId(vo.getIndiInfoHandlPrsnNo());
		infoChangeService.insert(info);

		CrmCustVo custVo = new CrmCustVo();
		custVo.setItgCustNo(param.getItgCustNo());
		custVo.setEventCd("120");
		custVo.setPblsChlCd(getCallChannel());
		custVo.setRegChlCd(getCallChannel());
		String codeCd = param.getCodeCd();
		if (Utilities.isEmpty(codeCd)) {
			getAsyncEventChk(custVo);
		}
		CrmCustVo cust = new CrmCustVo();
		cust.setItgCustNo(param.getItgCustNo());
		cust.setMshipLastLoginIpAddr(param.getConnPrsnIpAddr());
		if (Utilities.isEmpty(cust.getMshipLastLoginIpAddr()))
			cust.setMshipLastLoginIpAddr(Utilities.getPeerIp());
		updateLastLogin(cust);
		/*
		 * 
		 * 
		 * int ret = service.updateLastLogin(vo);
		 */
		asyncService.sendCustmerApiEvent(vo.getItgCustNo(), Constants._CUST_EVENT_DORM_CANCEL, getCallChannel());
		return ret;
	}

	public int updateDormant(CrmCustVo param) throws Exception {
		if (!useDorm)
			throw new EzApiException(Constants._API_CODE_DEPRECATED, Constants._API_CODE_DEPRECATED_MSG);
		CrmCustVo vo = dao.select(param);
		if (vo == null) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "등록되지 않은 회원입니다.");
		}
		String status = vo.getCustStatusCd();
		if (Constants._USER_STATUS_DORMANT.equals(status)) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "이미 휴면 회원 상태입니다.");
		}
		if (Constants._USER_STATUS_DELETE.equals(status)) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "탈회 회원입니다.");
		}
		if (!"Y".equals(vo.getMshipSbscYn())) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "멤버십 회원이 아닙니다.");
		}

		String codeCd = param.getCodeCd();
		if (Utilities.isEmpty(codeCd)) {
			asyncService.sendCustStatusMessage(vo.getItgCustNo(), "030");
		}
		CrmCustInfoChngHstVo info = new CrmCustInfoChngHstVo();
		info.setItgCustNo(vo.getItgCustNo());
		info.setChngClusCtnts("회원상태");
		info.setChngCtnts("휴면");
		info.setChngPreCtnts(vo.getCustStatusCdNm());
		info.setChngWhyCtnts(getCallChannel() + " 변경");
		infoChangeService.insert(info);

		// 23.2.7 멤버십 예정 등급코드 삭제 요청
		vo.setMshipExptGradeCd(null);

		dao.insertDormant(vo);
		vo.setCustStatusCd(Constants._USER_STATUS_DORMANT);
		asyncService.sendCustmerApiEvent(vo.getItgCustNo(), Constants._CUST_EVENT_DORM, getCallChannel());
		return dao.updateDelete(vo);
	}

	public int updateWithdrawal(CrmCustVo param) throws Exception {
		CrmCustVo vo = dao.select(param);
		if (vo == null) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "등록되지 않은 회원입니다.");
		}
		String status = vo.getCustStatusCd();

		if (Constants._USER_STATUS_DELETE.equals(status)) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "이미 탈퇴 회원 상태입니다.");
		}
		String codeCd = param.getCodeCd();
		System.out.println("check : " + codeCd);
		if (Utilities.isEmpty(codeCd)) {
			asyncService.sendCustStatusMessage(vo.getItgCustNo(), "130");
		}
		CrmCustInfoChngHstVo info = new CrmCustInfoChngHstVo();
		info.setItgCustNo(vo.getItgCustNo());
		info.setChngClusCtnts("회원상태");
		info.setChngCtnts("탈회");
		info.setChngPreCtnts(vo.getCustStatusCdNm());
		info.setChngWhyCtnts(getCallChannel() + " 변경");
		infoChangeService.insert(info);

		vo.setCustStatusCd(Constants._USER_STATUS_DELETE);
		dao.updateRepHshldDelete(vo);
		if ("Y".equals(vo.getMshipSbscYn()))
			asyncService.sendCustmerApiEvent(vo.getItgCustNo(), Constants._CUST_EVENT_WITHDRAWAL, getCallChannel());
		// CRM_ACQIE_HST
		return updateDelete(vo);

	}

	public int updateDelete(Object param) throws Exception {
		contactService.deleteCust(param);
		hshldDao.deleteCust(param);
		acqDao.deleteCust(param);
		dao.insertDormant(param);
		dao.updateDormantStatus(param);

		// dao.deleteDormant(param);
		return dao.updateDelete(param);
	}

	@Override
	public int delete(Object param) throws Exception {
		contactService.deleteCust(param);
		hshldDao.deleteCust(param);
		dao.deleteDormant(param);
		return super.delete(param);
	}

	private void checkDuplication(CrmCustVo vo) {

		CrmCustSo so = new CrmCustSo();
		so.setExceptItgCustNo(vo.getItgCustNo());
		// if (Utilities.isNotEmpty(vo.getCi())) {
		// so.setCi(vo.getCi());
		// int ret = dao.selectListCount(so);
		// if (ret > 0)
		// throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM,
		// Constants._API_CODE_DUPLICATED_PARAM_USER_CI_MSG);
		// so.setCi(null);
		// }

		if (Utilities.isNotEmpty(vo.getMshipLoginId())) {
			so.setMshipLoginId(vo.getMshipLoginId());
			int ret = dao.selectListCount(so);
			if (ret > 0)
				throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM,
						Constants._API_CODE_DUPLICATED_PARAM_LOGIN_ID_MSG);
			so.setMshipLoginId(null);
		}
		// so.setCustStatusCdNot(Constants._USER_STATUS_DELETE);

		so.setMphonNo(vo.getMphonNo());
		so.setCustNm(vo.getCustNm());
		int ret = dao.selectListCount(so);
		if (ret > 0)
			throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM,
					Constants._API_CODE_DUPLICATED_PARAM_USER_NM_PHONE_MSG);
		// so.setMphonNo(null);
		// so.setCustNm(null);
		int ret1 = dormDao.selectListCount(so);
		if (ret1 > 0)
			throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM,
					Constants._API_CODE_DUPLICATED_PARAM_USER_NM_PHONE_MSG);
	}

	public int updateRepCntplc(CrmCustCntplcBasVo vo) throws Exception {
		CrmCustVo custVo = dao.select(vo);
		if (custVo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, "존재하지 않는 통합회원입니다.");

		CrmCustSo so = new CrmCustSo();
		so.setExceptItgCustNo(vo.getItgCustNo());
		so.setCustStatusCdNot(Constants._USER_STATUS_DELETE);
		so.setMphonNo(vo.getTelNo());
		int cnt = dao.selectListCount(so);
		if (cnt > 0)
			return 0;
		// custVo.setMphonNo(null);
		custVo.setMphonNo(vo.getTelNo());
		custVo.setMphonBkDgtNo(vo.getTelBkDgtNo());
		custVo.setDistrctCd(vo.getDistrctCd());
		custVo.setZipCd(vo.getZipCd());
		custVo.setAddr1Ctnts(vo.getAddr1Ctnts());
		custVo.setAddr2Ctnts(vo.getAddr2Ctnts());
		return dao.updateRepCntplc(custVo);

	}

	public int updateRepCntplcPhone(CrmCustCntplcBasVo vo) throws Exception {
		CrmCustVo custVo = dao.select(vo);
		if (custVo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, "존재하지 않는 통합회원입니다.");

		CrmCustSo so = new CrmCustSo();
		so.setExceptItgCustNo(vo.getItgCustNo());
		so.setCustStatusCdNot(Constants._USER_STATUS_DELETE);
		so.setMphonNo(vo.getTelNo());
		int cnt = dao.selectListCount(so);
		if (cnt > 0)
			return 0;

		custVo.setMphonNo(vo.getTelNo());
		custVo.setMphonBkDgtNo(vo.getTelBkDgtNo());

		return dao.updateRepCntplc(custVo);

	}

	public CrmCustVo getLoginUser(CrmCustVo vo) throws Exception {
		CrmCustVo user = dao.selectLoginId(vo);
		if (user == null)
			return null;
		if (Constants._USER_STATUS_DORMANT.equals(user.getCustStatusCd())) {
			user = dormDao.select(user);
			user.setCustStatusCd(Constants._USER_STATUS_DORMANT);
		}
		inqHstService.decrypt(user);
		return user;
	}

	public CrmCustVo getLoginUserPwd(CrmCustVo vo) throws Exception {
		CrmCustVo user = dao.selectLoginId(vo);
		if (user == null)
			throw new EzApiException(Constants._API_CODE_LOGIN_FAIL, Constants._API_CODE_LOGIN_FAIL_MSG);
		if (Constants._USER_STATUS_DORMANT.equals(user.getCustStatusCd())) {
			user = dormDao.select(user);
			user.setCustStatusCd(Constants._USER_STATUS_DORMANT);
		}
		if (!Utilities.passwordMatch(vo.getMshipLoginPwd(), user.getMshipLoginPwd())) {
			throw new EzApiException(Constants._API_CODE_LOGIN_FAIL, Constants._API_CODE_LOGIN_FAIL_MSG);
		}
		inqHstService.decrypt(user);
		return user;
	}

	public CrmCustVo login(CrmCustVo vo) throws Exception {
		// vo.setMshipLoginPwd(Utilities.passwordEncode(vo.getMshipLoginPwd()));

		CrmCustVo user = dao.selectLoginId(vo);
		if (user == null) {
			throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM, Constants._API_CODE_LOGIN_FAIL_MSG);
		}
		// String pwd = Utilities.passwordEncode(vo.getMshipLoginPwd());
		// if (Utilities.passwordMatch(pwd, user.getMshipLoginPwd())) {
		// updateFailLogin(user);
		// throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM,
		// Constants._API_CODE_LOGIN_FAIL_MSG);
		// }
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(vo.getMshipLoginPwd(), user.getMshipLoginPwd())) {
			// updateFailLogin(user);
			throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM, Constants._API_CODE_LOGIN_FAIL_MSG);
		}
		// checkLoginUser(user);

		if (Constants._USER_STATUS_DORMANT.equals(user.getCustStatusCd())) {
			user = dormDao.select(user);
			user.setCustStatusCd(Constants._USER_STATUS_DORMANT);
		}

		updateSuccessLogin(user);
		CrmSnstvInfoInqrySo iso = new CrmSnstvInfoInqrySo();
		iso.setForceDecrypt(true);
		patchContact(user, iso);
		inqHstService.decrypt(user);
		return user;
	}

	public CrmCustVo getCustVo(String itgCustNo) throws Exception {
		CrmCustSo so = new CrmCustSo();
		so.setItgCustNo(itgCustNo);
		CrmCustVo custVo = dao.select(so);
		if (custVo == null || Constants._USER_STATUS_DELETE.equals(custVo.getCustStatusCd()))
			throw new EzApiException(Constants._API_CODE_NO_USER,
					"[" + itgCustNo + "] " + Constants._API_CODE_NO_USER_MSG);
		if (Constants._USER_STATUS_DELETE.equals(custVo.getCustStatusCd()))
			throw new EzApiException(Constants._API_CODE_NO_USER, Constants._API_CODE_NO_USER_MSG);
		return custVo;
	}

	public int updateBlack(String itgCustNo) throws Exception {
		CrmBllkCustHstSo so = new CrmBllkCustHstSo();
		so.setItgCustNo(itgCustNo);
		List<CrmBllkCustHstVo> list = blackDao.selectCustList(so);

		CrmCustVo custVo = new CrmCustVo();
		custVo.setItgCustNo(itgCustNo);
		if (Utilities.isEmpty(list)) {
			custVo.setBllkmshpYn("N");
			custVo.setBllkRegStorNo(null);
			custVo.setBllkRegChlCd(null);
			custVo.setBllkRegDt(null);
		} else {
			CrmBllkCustHstVo vo = null;
			vo = list.get(0);
			custVo.setBllkmshpYn("Y");
			custVo.setBllkRegStorNo(vo.getStorNo());
			custVo.setBllkRegChlCd(vo.getRegChlCd());
			custVo.setBllkRegWhyCtnts(vo.getBllkRegWhyCtnts());
			custVo.setBllkRegDt(vo.getRegDt());

		}

		return dao.updateBlack(custVo);
	}

	private int updateSuccessLogin(CrmCustVo user) throws Exception {
		return dao.updateSuccessLogin(user);

	}

	// private int updateFailLogin(CrmCustVo user) throws Exception {
	// return 0;
	//
	// }
	//
	// private void checkLoginUser(CrmCustVo user) throws Exception {
	//
	// }

	public CrmCustVo updateAgreement(CrmAgreementVo vo) throws Exception {
		return agreeService.updateAgreement(vo);
	}

	// 회원에 맞는 정책 쿠폰이 있는 지 검색
	public CrmMshipApplyCoupnEventRelVo selectCoupnInfo(CrmCustVo custVo) {
		return dao.selectCoupnInfo(custVo);
	}

	// 이벤트가 들어올 경우 처리
	// 이벤트 쿠폰, 이벤트 포인트, 이벤트 승급을 처리한다.
	// 이벤트코드 [EV100] [010 : 웰카페 체험추천 , 020 : 홈체험 추천 , 030 : 멤버십 가입 추천 , 040 : 웰카페 체험
	// , 050 : 홈체험 , 060 : 멤버십회원 가입 ,
	// 070 : 마케팅정보 수신동의 , 080 : 앱 다운로드 , 090 : 추가 정보 입력 , 100 : 생일 , 110 : 휴면방지 ,
	// 120 : 휴면해제 , 130 : 출석체크 , 140 : 텍스트 후기 작성 ,
	// 150 : 이미지 후기 작성 , 160 : 동영상 후기 작성 , 170 : 세라체크 , 180 : 서베이 , 190 : IoT]"
	@SuppressWarnings("unused")
	public Map<String, Object> getEventChk(CrmCustVo custVo) throws Exception {

		log.debug("getEventChk == " + custVo.toString());

		Map<String, Object> rtnMap = new LinkedHashMap<String, Object>();

		// 회원정보를 가져옴
		CrmCustVo vo = null;

		String orgCustNm = "";
		String orgRcmdCustNm = "";

		// 이벤트 코드가 추천인 기준이라면
		String[] rcmdEventCd = { "010", "020", "030" };
		if (Arrays.asList(rcmdEventCd).contains(custVo.getEventCd())) {

			orgCustNm = custVo.getCustNm();
			orgRcmdCustNm = custVo.getCustNm();

			// 혜택 제한 조건의 회원 통합번호
			custVo.setRcmdrCustNo2(custVo.getItgCustNo());

			// 이벤트 대상고객번호를 추천인 코드로 변경
			custVo.setOrgItgCustNo(custVo.getItgCustNo());
			custVo.setOrgMshipGradeCd(custVo.getOrgMshipGradeCd());
			custVo.setItgCustNo(custVo.getRcmdrCustNo());

			vo = dao.select(custVo);

			if (vo == null) {

				// 추천인이 정보가 없더라도 프로세스 처리 되게 함
				throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "등록되지 않은 추천 회원입니다.");

			}

		} else {

			vo = dao.select(custVo);

			if (vo == null) {
				throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "등록되지 않은 회원입니다.");
			}

			orgCustNm = custVo.getCustNm();
			orgRcmdCustNm = vo.getRcmdrCustNm();

			custVo.setOrgItgCustNo(custVo.getItgCustNo());
			custVo.setRcmdrCustNo2(custVo.getItgCustNo()); // 혜택 제한 조건의 회원 통합번호

		}

		// custVo.setMshipGradeCd(vo.getMshipGradeCd());
		// vo.setCoupnTypeCd(custVo.getEventCd());
		// vo.setEventCd(custVo.getEventCd());

		if (custVo.getEventCd() == null || "".equals(custVo.getEventCd())) {
			throw new EzApiException(API_CODE_EVENT_CODE, API_CODE_EVENT_CODE_MSG);
		}

		custVo.setCoupnTypeCd(custVo.getEventCd());
		custVo.setEventCd(custVo.getEventCd());
		custVo.setOrgMshipPlcyBasNo(custVo.getOrgMshipPlcyBasNo());

		// Utilities.beanToBean(custVo, vo);

		log.debug("custVo = " + custVo.toString());

		Map<String, Object> cpnInfo = null;
		Map<String, Object> potInfo = null;
		Map<String, Object> advnInfo = null;
		Map<String, Object> temPotInfo = null;

		CrmMshipPlcyBasVo plcyVo = new CrmMshipPlcyBasVo();
		plcyVo.setItgCustNo(custVo.getItgCustNo()); // 통합고객번호
		plcyVo.setPblsDivCd(custVo.getEventCd()); // 쿠폰종류코드
		plcyVo.setStatusCd("Y"); // 사용유무

		plcyVo.setOrgItgCustNo(custVo.getOrgItgCustNo());
		plcyVo.setOrgMshipPlcyBasNo(custVo.getOrgMshipPlcyBasNo());
		plcyVo.setRcmdrCustNo(custVo.getRcmdrCustNo());

		plcyVo.setRcmdrCustNo2(custVo.getRcmdrCustNo2());

		// String div = Utilities.nullCheck(custVo.getEventCd());

		// 이벤트 쿠폰을 지급한다.
		cpnInfo = chkEvtCoupon(custVo);
		if (cpnInfo != null) {
			rtnMap.putAll(cpnInfo);
			log.debug("### cpnInfo = " + cpnInfo.toString());
		}

		// 멤버십회원 가입일 경우 쿠폰만 1번 더 지급하므로
		// Y 가 아닐경우만 포인트, 승급점수 처리
		if (!"Y".equals(custVo.getCpnPblsAddYn())) {

			// 이벤트 포인트를 지급한다.
			potInfo = chkEvtPoint(custVo);
			if (potInfo != null) {
				rtnMap.putAll(potInfo);
				log.debug("### potInfo = " + potInfo.toString());
			}

			// 이벤트 승급점수를 지급한다.
			advnInfo = chkAdvnScore(custVo);
			if (advnInfo != null) {
				rtnMap.putAll(advnInfo);
				log.debug("### advnInfo = " + advnInfo.toString());
			}

			if ("060".equals(custVo.getEventCd())) {
				// 이벤트성 포인트 지급 끝나면 삭제.
				// 2023.02.01 ~ 2023.02.28 멤버십 회원가입 > 5000 포인트 지급 > 유효기간 3개월
				temPotInfo = chkTemEvtPoint(custVo);
				if (temPotInfo != null) {
					rtnMap.putAll(temPotInfo);
					log.debug("### temPotInfo = " + temPotInfo.toString());
				}
			}

		}

		// 체험스탬프
		if ("040".equals(custVo.getEventCd())) {
			CrmMshipStmpEventVo stmpVo = stmpDao.selectExpStampEvent(custVo);
			if (stmpVo != null) {
				List<CrmMshipStmpIssueVo> stmps = stmpService.eventStmp(stmpVo);
			}
		}

		// 이벤트 알림톡 체크
		String[] aTalkEventCd = { "010", "020", "030", "040", "050", "070", "090", "100", "120", "170", "180", "902" };

		if (Arrays.asList(aTalkEventCd).contains(custVo.getEventCd())) {

			EzMap param = new EzMap();
			param.setString("codeCd", custVo.getEventCd());

			MsgCodeVo code = null;
			MsgCodeVo pntCode = null;
			MsgCodeVo cpnCode = null;

			String itgCustNo = custVo.getItgCustNo();

			param.setString("itgCustNo", custVo.getItgCustNo());
			CrmCustVo cust = dao.selectMphone(param);
			Map<String, Object> msgMap = Utilities.beanToMap(cust);

			String rcmdrCustNm = "";

			// 추천인 이름 검색
			CrmCustVo rcmdCust = dao.selectRcmdCustInfo(custVo);
			if (rcmdCust != null) {
				rcmdrCustNm = rcmdCust.getCustNm();
			}

			// 추가정보입력, 생일일 경우 문자 템플릿 가져오기
			if ("090".equals(custVo.getEventCd()) || "100".equals(custVo.getEventCd())) {

				if ("090".equals(custVo.getEventCd())) {

					// 포인트 템플릿
					param.put("templateType", "A.RFRN_1_COMN_CD");
					param.put("sendYnCols", "A.RFRN_7_COMN_CD");
					pntCode = msgIfDao.selectEvtSmsCode(param);
					if (pntCode != null && !"".equals(pntCode.getTemplateCode())) {
						msgMap.put("pntTemplateCode", pntCode.getTemplateCode());
					}

					// 쿠폰 템플릿
					param.put("templateType", "A.RFRN_3_COMN_CD");
					param.put("sendYnCols", "A.RFRN_8_COMN_CD");
					cpnCode = msgIfDao.selectEvtSmsCode(param);
					if (cpnCode != null && !"".equals(cpnCode.getTemplateCode())) {
						msgMap.put("cpnTemplateCode", cpnCode.getTemplateCode());
					}

				}

				if ("100".equals(custVo.getEventCd())) {

					// 포인트 템플릿
					param.put("templateType", "A.RFRN_1_COMN_CD");
					param.put("sendYnCols", "A.RFRN_7_COMN_CD");
					pntCode = msgIfDao.selectEvtSmsCode(param);
					if (pntCode != null && !"".equals(pntCode.getTemplateCode())) {
						msgMap.put("pntTemplateCode", pntCode.getTemplateCode());
					}

					// 쿠폰 템플릿
					param.put("templateType", "A.RFRN_3_COMN_CD");
					param.put("sendYnCols", "A.RFRN_8_COMN_CD");
					cpnCode = msgIfDao.selectEvtSmsCode(param);
					if (cpnCode != null && !"".equals(cpnCode.getTemplateCode())) {
						msgMap.put("cpnTemplateCode", cpnCode.getTemplateCode());
					}
				}

			} else {

				// 포인트 템플릿
				param.put("templateType", "A.RFRN_1_COMN_CD");
				param.put("sendYnCols", "A.RFRN_7_COMN_CD");
				pntCode = msgIfDao.selectEvtCode(param);

				if (pntCode != null && !"".equals(pntCode.getTemplateCode())) {
					msgMap.put("pntTemplateCode", pntCode.getTemplateCode());
				}

				// 쿠폰 템플릿
				param.put("templateType", "A.RFRN_3_COMN_CD");
				param.put("sendYnCols", "A.RFRN_8_COMN_CD");
				cpnCode = msgIfDao.selectEvtCode(param);
				if (cpnCode != null && !"".equals(cpnCode.getTemplateCode())) {
					msgMap.put("cpnTemplateCode", cpnCode.getTemplateCode());
				}

			}

			msgMap.put("eventCd", custVo.getEventCd());
			msgMap.put("barcodeValue", null);
			msgMap.put("barcodeType", null);

			// 이벤트 쿠폰이 지급되었다면 알림톡

			if (cpnInfo != null && "SUCCESS".equalsIgnoreCase((String) cpnInfo.get("coupnErr")) && cpnCode != null
					&& !"".equals(cpnCode.getTemplateCode())) {

				if (Arrays.asList(rcmdEventCd).contains(custVo.getEventCd())) {
					orgCustNm = orgRcmdCustNm;
				} else {
					rcmdrCustNm = custVo.getCustNm();
				}

				// cust
				msgMap.put("고객님", rcmdrCustNm);
				msgMap.put("고객명", rcmdrCustNm);
				msgMap.put("회원명", rcmdrCustNm);
				msgMap.put("회원님", rcmdrCustNm);
				msgMap.put("피추천인", rcmdrCustNm);
				msgMap.put("추천인", orgCustNm);
				msgMap.put("쿠폰명", cpnInfo.get("coupnNm"));
				msgMap.put("쿠폰번호", cpnInfo.get("coupnPblsBasNo"));
				msgMap.put("입력날짜", Utilities.getDateString("."));
				msgMap.put("마케팅정보 수신동의 일자", Utilities.getDateString("."));
				msgMap.put("유효기간", Utilities.getDateFormat(cpnInfo.get("coupnDay").toString(), "."));
				msgMap.put("쿠폰 유효기간", Utilities.getDateFormat(cpnInfo.get("coupnDay").toString(), "."));
				msgMap.put("수신동의 일자", Utilities.getDateString("."));

				if (cpnCode.getBarcodeType() != null) {

					// String barcodeBackImgDir = "/weom/app/mmsimg/";
					String barcodeBackImgDir = "/app/eon/webmgr/app/mmsimg/";

					msgMap.put("barcodeType", cpnCode.getBarcodeType());
					msgMap.put("barcodeWidth", cpnCode.getBarcodeWidth());
					msgMap.put("barcodeHeight", cpnCode.getBarcodeHeight());
					msgMap.put("barcodePosX", cpnCode.getBarcodePosX());
					msgMap.put("barcodePosY", cpnCode.getBarcodePosY());
					msgMap.put("barcodeOrgImg", barcodeBackImgDir + cpnCode.getBarcodeOrgImg());
					msgMap.put("barcodeImg", barcodeBackImgDir + cpnCode.getBarcodeImg());

				}

				msgMap.put("barcodeValue", cpnInfo.get("coupnPblsBasNo"));

				msgMap.put("txt_1", orgCustNm);
				msgMap.put("txt_2", cpnInfo.get("coupnNm"));
				msgMap.put("txt_3", Utilities.getDateFormat(cpnInfo.get("coupnDay").toString(), "."));
				msgMap.put("txt_4", "");

				msgMap.put("templateCode", cpnCode.getTemplateCode());

				MsgIfVo message = getMessage(cpnCode, itgCustNo, cust.getMphonNo(), msgMap);
				sendMessage(message);

			}

			// 이벤트 포인트가 지급되었다면 알림톡

			if (potInfo != null && "SUCCESS".equalsIgnoreCase((String) potInfo.get("pntErr")) && pntCode != null
					&& !"".equals(pntCode.getTemplateCode())) {

				if (Arrays.asList(rcmdEventCd).contains(custVo.getEventCd())) {
					orgCustNm = custVo.getCustNm();
				}

				String pntPoint = Utilities.getMoneyString(Long.parseLong(potInfo.get("pntPoint").toString()));

				// cust
				msgMap.put("고객님", orgCustNm);
				msgMap.put("고객명", orgCustNm);
				msgMap.put("회원명", orgCustNm);
				msgMap.put("회원님", orgCustNm);
				msgMap.put("보상보인트", pntPoint);
				msgMap.put("보상포인트", pntPoint);
				msgMap.put("지급포인트", pntPoint);
				msgMap.put("회원님", orgCustNm);
				msgMap.put("피추천인", orgCustNm);
				msgMap.put("추천인", rcmdrCustNm);
				msgMap.put("마케팅정보 수신동의 일자", Utilities.getDateString("."));

				if (pntCode.getBarcodeType() == null) {

					msgMap.put("fileCnt", 0);
					msgMap.put("fileType1", null);
					msgMap.put("filePath1", null);
					msgMap.put("barcodeType", null);
					msgMap.put("barcodeWidth", null);
					msgMap.put("barcodeHeight", null);
					msgMap.put("barcodePosX", null);
					msgMap.put("barcodePosY", null);
					msgMap.put("barcodeOrgImg", null);
					msgMap.put("barcodeImg", null);

				}

				msgMap.put("templateCode", pntCode.getTemplateCode());

				MsgIfVo message = getMessage(pntCode, itgCustNo, cust.getMphonNo(), msgMap);
				sendMessage(message);

			}
		}

		return rtnMap;

	}

	// 추천 히스토리 작성
	public int saveRcmdHst(CrmCustVo custVo) {

		CrmRcmdHstVo crmRcmdHstVo = new CrmRcmdHstVo();

		crmRcmdHstVo.setItgCustNo(custVo.getItgCustNo());
		crmRcmdHstVo.setRcmdrCustNo(custVo.getRcmdrCustNo());

//		No.	이벤트명코드(EV100)	추천종류코드(CU340)
//		코드	코드명				코드	코드명
//		1	030	멤버십 가입 추천	003		가입추천
//		2	902	구매추천			001		구매추천
//		3	020	홈체험 추천			002		홈체험추천
//		4	040	웰카페 체험			004		웰카페체험추천

		String rcmdTypeCd = custVo.getEventCd();
		if ("030".equals(custVo.getEventCd())) {
			rcmdTypeCd = "003";
		} else if ("902".equals(custVo.getEventCd())) {
			rcmdTypeCd = "001";
		} else if ("020".equals(custVo.getEventCd())) {
			rcmdTypeCd = "002";
		} else if ("010".equals(custVo.getEventCd())) {
			rcmdTypeCd = "004";
		}

		crmRcmdHstVo.setRcmdTypeCd(rcmdTypeCd);
		crmRcmdHstVo.setRegChlCd(custVo.getRegChlCd());
		crmRcmdHstVo.setRcmdStorNo(custVo.getRcmdStorNo());

		if (crmRcmdHstVo.getRcmdrCustNo() != null && !"".equals(crmRcmdHstVo.getRcmdrCustNo())) {

			CrmCustVo vo1 = new CrmCustVo();
			vo1.setItgCustNo(crmRcmdHstVo.getRcmdrCustNo());

			CrmCustVo custVo2 = dao.select(vo1);
			if (custVo2 != null) {
				return rcmdHstDao.insert(crmRcmdHstVo);
			}
		}

		return 1;
	}

	public int sendMessage(MsgIfVo message) throws Exception {
		message.setSrctel(smsSenderNo);
		if (Utilities.isEmpty(message.getSenderKey()))
			message.setSenderKey(talkSenderKey);
		// 배치저장
		if ("MSG_IF".equals(message.getDummy7())) {
			message.setDummy7(null);
			return msgIfDao.insertEvtMsg(message);
		} else { // 실시간 저장
			message.setDummy7(null);
			return msgIfDao.insertEvtMsgR(message);
		}
	}

	public String getTalkTemplateText(String template, Map<String, Object> map) {

		if (Utilities.isEmpty(template) || Utilities.isEmpty(map))
			return template;
		Map<String, Object> variant = getVariant(template, map);
		String ret = template;
		for (Map.Entry<String, Object> entry : variant.entrySet()) {
			String strKey = entry.getKey();
			String strValue = Utilities.nullCheck(entry.getValue());

			ret = ret.replace("#{" + strKey + "}", strValue + ""); // 카카오
			ret = ret.replace("${" + strKey + "}", strValue + ""); // SMS
		}
		ret = ret.replace("#{}", "");
		ret = ret.replace("${}", "");
		return ret;
	}

	public Map<String, Object> getVariant(String template, Map<String, Object> map) {
		Map<String, Object> variant = new LinkedHashMap<>();
		int index = -1;
		if (Utilities.isEmpty(template))
			return variant;
		while (true) {

			int idx = template.indexOf("#{", index);
			if (idx == -1)
				idx = template.indexOf("${", index);

			if (idx < 0)
				break;
			int end = template.indexOf("}", idx);
			if (end < 0)
				break;
			if (end > idx + 2) {
				String key = template.substring(idx + 2, end).trim();
				if (!variant.containsKey(key)) {
					variant.put(key, map.get(key));
				}
			}
			index = end;
		}
		return variant;
	}

	public String getTimeString(String time) throws Exception {
		Calendar cal = Calendar.getInstance();
		if (Utilities.parseLong(Utilities.getTimeString()) >= Utilities.parseLong(time)) {
			cal.add(Calendar.DATE, 1);
		}
		String dateString = Utilities.getDateString(cal.getTime());
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREAN);
		Date dt = sf.parse(dateString + time);
		return sf.format(dt);
	}

	public MsgIfVo getMessage(MsgCodeVo code, String itgCustNo, String mphoneNo, Map<String, Object> msgMap)
			throws Exception {

		// 문자의경우 txt_ 로 시작함 카멜표기로 _ 없어져야 함
		String msg = getTalkTemplateText(code.getTalkTemplate().replace("txt_", "txt"), msgMap);
		String subject = getTalkTemplateText(code.getSubject().replace("txt_", "txt"), msgMap);
		MsgIfVo message = new MsgIfVo();
		String timTalk = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREAN);
		if (Utilities.isNotEmpty(code.getTalkSendTime())) {
			// 다음날 예약시간
			timTalk = getTimeString(code.getTalkSendTime());
		} else {
			// 실시간
			timTalk = sf.format(new Date());
		}

		// 이벤트가 마케팅정보 수신동의, 추가정보 입력일 경우 실시간이되,
		// 현재 시간이 9~18 시 가 아니라면 익일 10시 처리

		message.setDummy7("MSG_IF");
		int nowTime = 0;
		if ("010".equals(msgMap.get("eventCd")) || "030".equals(msgMap.get("eventCd"))
				|| "040".equals(msgMap.get("eventCd")) || "070".equals(msgMap.get("eventCd"))
				|| "090".equals(msgMap.get("eventCd")) || "170".equals(msgMap.get("eventCd"))) {

			LocalTime now = LocalTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
			nowTime = Integer.valueOf(now.format(formatter));
			// nowTime = 1801;

			if (nowTime < 90000 || nowTime > 180000) {
				timTalk = getTimeString(code.getTalkSendTime());
			} else {
				timTalk = sf.format(new Date());
				message.setDummy7("MSGR_IF");
			}

		}

		String codeCd = (String) msgMap.get("eventCd"); // getComnCd();
		// DATETIME_FORMAT.format(dt)
		message.setSenderKey(code.getSendProfileKey());

		message.setRevId(itgCustNo);
		message.setDestel(mphoneNo);
		message.setReservetime(timTalk);
		message.setClient("CRM");
		message.setDummy10(itgCustNo);
		message.setDummy9(codeCd);
		message.setCampaignId(null);
//		message.setCampaignId(codeCd + Utilities.getDateTimeString() + Utilities.getUniqNumberID(3));
		message.setMemberSeq("1");
		message.setSubject(subject);
		message.setKTitle(subject);
		message.setMsg(msg);
		message.setEtc3(eonUser);
		message.setTemplateCode(code.getTalkTemplateId());
		message.setKMsg(msg);
		message.setKReservetime(timTalk);
		message.setKErrIssend("Y");
		message.setTemplateCode("" + msgMap.get("templateCode"));

		message.setFileType1(null);
		message.setFilePath1(null);
		message.setBarcodeType(null);
		message.setBarcodeWidth(null);
		message.setBarcodeHeight(null);
		message.setBarcodePosX(null);
		message.setBarcodePosY(null);
		message.setBarcodeValue(null);
		message.setBarcodeOrgImg(null);
		message.setBarcodeImg(null);

		if (msgMap.get("barcodeValue") != null && msgMap.get("barcodeType") != null) {

			message.setFileCnt(1);
			message.setFileType1("I");
			message.setFilePath1("" + msgMap.get("barcodeOrgImg"));

			message.setBarcodeType("" + msgMap.get("barcodeType"));
			message.setBarcodeWidth(Integer.valueOf("" + msgMap.get("barcodeWidth")));
			message.setBarcodeHeight(Integer.valueOf("" + msgMap.get("barcodeHeight")));
			message.setBarcodePosX(Integer.valueOf("" + msgMap.get("barcodePosX")));
			message.setBarcodePosY(Integer.valueOf("" + msgMap.get("barcodePosY")));
			message.setBarcodeValue("" + msgMap.get("barcodeValue"));
			message.setBarcodeOrgImg("" + msgMap.get("barcodeOrgImg"));
			message.setBarcodeImg("" + msgMap.get("barcodeImg"));

		}

		// 생일이거나 추가 정보 입력의 경우 문자 발송
		if ("090".equals(codeCd) || "100".equals(codeCd)) {
			message.setSendresult("00000");
			message.setMsgType("0000");
		} else {
			message.setSendresult("K");
			message.setMsgType("AT");
		}

		message.setSendType("2");
		message.setKkoBtnInfo(code.getBtnInfo());
		message.setKkoBtnType("2");
		return message;
	}

	public void getAsyncEventChk(CrmCustVo custVo) throws Exception {
		if ("Y".equals(custVo.getMshipSbscYn())) {
//			asyncService.saveRcmdHst(custVo);
			asyncService.getEventChk(custVo);
		}
	}

	// 이벤트 쿠폰을 검색후 지급한다.
	private Map<String, Object> chkEvtCoupon(CrmCustVo custVo) throws Exception {

		Map<String, Object> result = new LinkedHashMap<String, Object>();

		// 이벤트 쿠폰을 검색한다.
		// 05.25 김은성 쿠폰 정책 추가
		// 쿠폰 정책 번호 없이 넘어올때
		// 해당 회원등급,쿠폰유형에 맞는 정책을 찾아서 처리한다

		// 해당 회원에 맞는 정책이 있는 지 찾는다.
		// 필수 파라미터 itgCustNo, COUPN_TYPE_CD = '007' AND A.MSHIP_GRADE_CD = '003' AND
		// A.MSHP_GRADE_CD = '005'

		CrmMshipPlcyBasVo plcyVo = new CrmMshipPlcyBasVo();
		plcyVo.setItgCustNo(custVo.getItgCustNo()); // 통합고객번호
		plcyVo.setPblsDivCd(custVo.getEventCd()); // 쿠폰종류코드
		plcyVo.setStatusCd("Y"); // 사용유무

		plcyVo.setOrgItgCustNo(custVo.getOrgItgCustNo());
		plcyVo.setOrgMshipPlcyBasNo(custVo.getOrgMshipPlcyBasNo());
		plcyVo.setRcmdrCustNo(custVo.getRcmdrCustNo());

		plcyVo.setRcmdrCustNo2(custVo.getRcmdrCustNo2());

		// String div = Utilities.nullCheck(custVo.getEventCd());

		// 정책을 불러온다.
		CrmMshipPlcyBasVo plcyInfo = plcyDao.selectPlcyInfo(plcyVo);
		String orgMBas = null;
		CrmCouponVo coupon = new CrmCouponVo();
		coupon.setItgCustNo(custVo.getItgCustNo());
		coupon.setPblsDivCd(custVo.getEventCd());
		coupon.setRcmdrCustNo2(custVo.getRcmdrCustNo2());
		coupon.setMshpGradeCd(custVo.getOrgMshipGradeCd());
		orgMBas = custVo.getOrgMshipPlcyBasNo();
		if (plcyInfo != null) {
			custVo.setOrgMshipPlcyBasNo(plcyInfo.getMshipPlcyBasNo());
		}

		CrmMshipApplyCoupnEventRelVo coupnInfo = couponDao.selectCoupnInfo(custVo);
		if (plcyInfo != null && coupnInfo == null && !"003".equals(custVo.getMshipTypeCd())) {
			custVo.setOrgMshipPlcyBasNo(null);
			coupnInfo = couponDao.selectCoupnInfo(custVo);
		}

		custVo.setOrgMshipPlcyBasNo(orgMBas);

		Utilities.beanToBean(coupon, coupnInfo);
		coupon.setRegChlCd(null);
		coupon.setRegrId(null);
		coupon.setRegDt(null);
		coupon.setAmdrId(null);
		coupon.setAmdDt(null);

		String cpnErr = "SUCCESS";
		String cpnErrMsg = "";

		if (coupnInfo == null) {
			// throw new EzApiException(API_CODE_COUPON_EXIST, API_CODE_COUPON_EXIST_MSG);
			cpnErr = "NULL";

			result.put("coupnErr", API_EVENT_EXIST);
			result.put("coupnErrMsg", API_EVENT_EXIST_MSG);

			return result;

		} else {

			result.put("coupnErr", null);
			result.put("coupnCode", null);

			coupon.setUseYn("N");
			coupnInfo.setUseYn("N");

			// 멤버십정책 - 이벤트 쿠폰 지급 횟수 정책

			// 떠블클릭 체크
			if (coupnInfo.getDoubleClickChk() > 0) {
				// throw new EzApiException(API_CODE_PAY_OVER_01, API_CODE_PAY_OVER_01_MSG);
				// cpnErr = "DOUBLE";
				cpnErr = API_CODE_CALL_DOUBLE;
				cpnErrMsg = API_CODE_CALL_DOUBLE_MSG;

				// 총지급횟수 초과
			} else if (coupnInfo.getTotAppntCnt() <= coupnInfo.getAllCpnPlbsCnt()) {
				// throw new EzApiException(API_CODE_PAY_OVER_01, API_CODE_PAY_OVER_01_MSG);
				// cpnErr = "TOTAL";
				cpnErr = API_CODE_PAY_OVER_01;
				cpnErrMsg = API_CODE_PAY_OVER_01_MSG + "TotAppntCnt[" + coupnInfo.getTotAppntCnt()
						+ "] , AllCpnPlbsCnt[" + coupnInfo.getAllCpnPlbsCnt() + "]";

				// 1개월 지급횟수 초과
			} else if (coupnInfo.getMonthAppntCnt() <= coupnInfo.getMonthCpnPlbsCnt()) {
				// throw new EzApiException(API_CODE_PAY_OVER_02, API_CODE_PAY_OVER_02_MSG);
				// cpnErr = "MONTH";
				cpnErr = API_CODE_PAY_OVER_02;
				cpnErrMsg = API_CODE_PAY_OVER_02_MSG + "MonthAppntCnt[" + coupnInfo.getMonthAppntCnt()
						+ "] , MonthCpnPlbsCnt[" + coupnInfo.getMonthCpnPlbsCnt() + "]";

				// 1일 지급횟수 초과
			} else if (coupnInfo.getDayAppntCnt() <= coupnInfo.getTodayCpnPlbsCnt()) {
				// throw new EzApiException(API_CODE_PAY_OVER_03, API_CODE_PAY_OVER_03_MSG);
				cpnErr = API_CODE_PAY_OVER_03;
				cpnErrMsg = API_CODE_PAY_OVER_03_MSG + "DayAppntCnt[" + coupnInfo.getDayAppntCnt()
						+ "] , TodayCpnPlbsCnt[" + coupnInfo.getTodayCpnPlbsCnt() + "]";
			}

			// 사용기한일 구하기
			// Y 발급후 즉시 else 날짜 지정 fromUseStdDay ~ toUseStdDay
			if ("Y".equals(coupnInfo.getUseStdDayCondCd()) && "SUCCESS".equals(cpnErr)) {

				coupon.setFromUseStdDay(getToday());
				if (coupnInfo.getCoupnUsePossDay() != null) {
					// if (!"".equals(coupnInfo.getCoupnUsePossDay())) {
					coupon.setToUseStdDay(getHowDay(Integer.valueOf(coupnInfo.getCoupnUsePossDay().toString())));
				} else {
					// getCoupnUsePossDay 값이 없다면 기본 2년으로 처리
					coupon.setToUseStdDay(getHowDay(730));
				}

			}

			int coupnCode = 0;
			if ("SUCCESS".equals(cpnErr)) {
				coupnCode = couponService.insert(coupon);
			}

			result.put("coupnErr", cpnErr);
			result.put("coupnErrMsg", cpnErrMsg);
			result.put("coupnCode", coupnCode);
			result.put("coupnNm", coupon.getCoupnBasNm());
			result.put("coupnDay", coupon.getToUseStdDay());
			result.put("coupnHstSeq", coupon.getCoupnPblsHstSeq()); // 쿠폰 발행 고유 번호
			result.put("coupnPblsBasNo", coupon.getCoupnPblsBasNo()); // 쿠폰 발행 고유 번호

		}

		return result;

	}

	// 이벤트 포인트를 검색후 지급한다.
	private Map<String, Object> chkEvtPoint(CrmCustVo custVo) throws Exception {

		Map<String, Object> result = new LinkedHashMap<String, Object>();

		// 이벤트 포인트를 검색한다.
		CrmPointHstVo crmPointHstVo = new CrmPointHstVo();
		crmPointHstVo.setPblsDivCd(custVo.getEventCd());
		crmPointHstVo.setItgCustNo(custVo.getItgCustNo());

		crmPointHstVo.setRcmdrCustNo2(custVo.getRcmdrCustNo2());

		CrmPointInfoVo info = pointHstDao.selectPointInfo(custVo);

		// 05.20 김은성 멤버십 정책 추가
		CrmMshipPlcyBasVo plcyVo = new CrmMshipPlcyBasVo();
		plcyVo.setItgCustNo(custVo.getItgCustNo()); // 통합고객번호
		plcyVo.setPblsDivCd(custVo.getEventCd()); // 쿠폰종류코드
		plcyVo.setStatusCd("Y"); // 사용유무

		plcyVo.setOrgItgCustNo(custVo.getOrgItgCustNo());
		plcyVo.setOrgMshipPlcyBasNo(custVo.getOrgMshipPlcyBasNo());
		plcyVo.setRcmdrCustNo(custVo.getRcmdrCustNo());

		plcyVo.setRcmdrCustNo2(custVo.getRcmdrCustNo2());

		// String div = Utilities.nullCheck(custVo.getEventCd());

		// 정책을 불러온다.
		CrmMshipPlcyBasVo plcyInfo = plcyDao.selectPlcyInfo(plcyVo);

		log.debug("### plcyInfo = " + custVo.getEventCd() + "//" + plcyVo.getPblsDivCd());

		// 해당 정책이 없다면
		String pntErr = "";
		String pntErrMsg = "";

		if (plcyInfo == null) {
			pntErr = "NULL";

			result.put("pntErr", API_EVENT_EXIST);
			result.put("pntErrMsg", API_EVENT_EXIST_MSG);

			return result;

		} else {

			result.put("pntErr", null);
			result.put("pntCode", null);

			log.debug("### plcyInfo = " + plcyInfo.toString());
			crmPointHstVo.setOccurPointScore(0);
			crmPointHstVo.setUseTypeCd(CrmPointHstService.USE_TYPE_DEPOSIT); // 적립코드
			crmPointHstVo.setPblsDivCd(plcyVo.getPblsDivCd());

			plcyInfo.setPblsDivCd(plcyVo.getPblsDivCd());
			plcyInfo.setOrgItgCustNo(plcyVo.getOrgItgCustNo());
			plcyInfo.setOrgMshipPlcyBasNo(plcyVo.getOrgMshipPlcyBasNo());
			plcyInfo.setRcmdrCustNo2(plcyVo.getRcmdrCustNo2());

			// 이벤트 포인트 정책을 가져온다.
			CrmMshipApplyPointRelVo pntInfo = plcyDao.selectEventPointInfo(plcyInfo);

			if ((pntInfo == null || pntInfo.getAccumPointScore() == 0) && !"003".equals(custVo.getMshipTypeCd())) {
				plcyVo.setUseGradeYn("Y");
				plcyInfo = plcyDao.selectPlcyInfo(plcyVo);
				if (plcyInfo != null) {
					plcyInfo.setPblsDivCd(plcyVo.getPblsDivCd());
					plcyInfo.setOrgItgCustNo(plcyVo.getOrgItgCustNo());
					plcyInfo.setOrgMshipPlcyBasNo(plcyVo.getOrgMshipPlcyBasNo());
					plcyInfo.setRcmdrCustNo2(plcyVo.getRcmdrCustNo2());
					plcyVo.setUseGradeYn(null);
					pntInfo = plcyDao.selectEventPointInfo(plcyInfo);
				}

			}
			// log.debug("pntInfo == " + pntInfo.toString());

			if (pntInfo == null || pntInfo.getAccumPointScore() == 0) {
				pntErr = "NULL";

				result.put("pntErr", API_EVENT_EXIST);
				result.put("pntErrMsg", API_EVENT_EXIST_MSG);

				return result;
			}

			pntErr = "SUCCESS";
			pntErrMsg = "";

			// 떠블클릭 체크
			if (pntInfo.getDoubleClickChk() > 0) {
				// throw new EzApiException(API_CODE_PAY_OVER_01, API_CODE_PAY_OVER_01_MSG);
				pntErr = API_CODE_CALL_DOUBLE;
				pntErrMsg = API_CODE_CALL_DOUBLE_MSG;
				pntInfo.setAccumPointScore(0);

				// 총지급횟수 체크
			} else if (pntInfo.getTotAppntCnt() > 0 && pntInfo.getTotAppntCnt() <= pntInfo.getAllPntPlbsCnt()) {
				// pntErr = "TOTAL";

				pntErr = API_CODE_PAY_OVER_01;
				pntErrMsg = API_CODE_PAY_OVER_01_MSG;
				pntInfo.setAccumPointScore(0);

				// 월지급 체크
			} else if (pntInfo.getMonthAppntCnt() > 0 && pntInfo.getMonthAppntCnt() <= pntInfo.getMonthPntPlbsCnt()) {
				// pntErr = "MONTH";

				pntErr = API_CODE_PAY_OVER_02;
				pntErrMsg = API_CODE_PAY_OVER_02_MSG;

				pntInfo.setAccumPointScore(0);

				// 일지급 체크
			} else if (pntInfo.getDayAppntCnt() > 0 && pntInfo.getDayAppntCnt() <= pntInfo.getTodayPntPlbsCnt()) {
				// pntErr = "TODAY";

				pntErr = API_CODE_PAY_OVER_03;
				pntErrMsg = API_CODE_PAY_OVER_03_MSG;
				pntInfo.setAccumPointScore(0);
			}

			// 포인트 1일 적립한도 체크
			if (pntInfo.getAccumLmtPointScore() > 0 && pntInfo.getAccumLmtPointScore() <= pntInfo.getTodayPblsPnt()) {
				// pntErr = "TODAY";

				pntErr = API_CODE_PNT_OVER;
				pntErrMsg = API_CODE_PNT_OVER_MSG;
				pntInfo.setAccumPointScore(0);
			}

			int pntCode = 0;
			int score = 0;

			if ("SUCCESS".equals(pntErr)) {

				// int score = Math.abs(pntInfo.getAccumPointScore());
				score = pntInfo.getAccumPointScore();
				crmPointHstVo.setOccurPointScore(score);
				crmPointHstVo.setMshipGradeCd(custVo.getMshipGradeCd());
				crmPointHstVo.setAccumYn("Y");

				info.setOccurPointScore(pntInfo.getAccumPointScore());

				info.setTotalPoint(info.getTotalPoint() + score);
				info.setAvailablePoint(info.getAvailablePoint() + score);
				info.setItgCustNo(info.getItgCustNo());

				crmPointHstVo.setRemainPointScore(info.getAvailablePoint());

				// 2022-09-23 포인트 적립은 포인트 API /point/deposit/ 처리 하기로 함

//				pntCode = pointHstService.insert(crmPointHstVo);
//				pointHstService.insertDepositHst(crmPointHstVo);
//				info = pointHstDao.selectPointInfo(crmPointHstVo);
//				info.setOccurPointScore(crmPointHstVo.getOccurPointScore());
//				pointHstService.updateRemainPoint(info);

				crmPointHstVo.setMessageYn("N");
				crmPointHstVo.setChitNo(Utilities.getAutoSeq("CHT"));

				CrmPointInfoVo crmPointInfoVo = pointHstService.saveDeposit(crmPointHstVo);
				pntCode = crmPointInfoVo.getOccurPointScore();

			}

			result.put("pntErr", pntErr);
			result.put("pntErrMsg", pntErrMsg);
			result.put("pntCode", pntCode);
			result.put("pntPoint", score);

		}

		return result;
	}

	// 이벤트 승급점수를 검색후 지급한다.
	private Map<String, Object> chkAdvnScore(CrmCustVo custVo) throws Exception {

		Map<String, Object> result = new LinkedHashMap<String, Object>();

		// 05.20 김은성 멤버십 정책 추가
		CrmMshipPlcyBasVo plcyVo = new CrmMshipPlcyBasVo();
		plcyVo.setItgCustNo(custVo.getItgCustNo()); // 통합고객번호
		plcyVo.setPblsDivCd(custVo.getEventCd()); // 쿠폰종류코드
		plcyVo.setStatusCd("Y"); // 사용유무
		plcyVo.setOrgItgCustNo(custVo.getItgCustNo());
		plcyVo.setRcmdrCustNo2(custVo.getRcmdrCustNo2());

		plcyVo.setOrgMshipPlcyBasNo(custVo.getOrgMshipPlcyBasNo());

		CrmMshipPlcyBasVo plcyInfo = plcyDao.selectPlcyInfo(plcyVo);

		log.debug("### plcyInfo = " + custVo.getEventCd() + "//" + plcyVo.getPblsDivCd());

		// 해당 정책이 없다면
		String advnErr = "";
		String advnErrMsg = "";

		if (plcyInfo == null) {
			// advnErr = "NULL";

			result.put("advnErr", API_EVENT_EXIST);
			result.put("advnErrMsg", API_EVENT_EXIST_MSG);

			return result;

		} else {

			result.put("advnErr", null);
			result.put("advnCode", null);

			log.debug("### plcyInfo = " + plcyInfo.toString());
			plcyInfo.setPblsDivCd(plcyVo.getPblsDivCd());
			plcyInfo.setOrgItgCustNo(plcyVo.getOrgItgCustNo());
			plcyInfo.setRcmdrCustNo2(plcyVo.getRcmdrCustNo2());

			plcyInfo.setOrgMshipPlcyBasNo(plcyVo.getOrgMshipPlcyBasNo());

			// 이벤트 승급 정책을 가져온다.
			CrmMshipApplyAdvncmtRelVo advnInfo = plcyDao.selectEventAdvnInfo(plcyInfo);

			if (advnInfo == null) {
				advnErr = "NULL";
				// advnInfo.setAdvncmtPointScore(0);

				result.put("advnErr", API_EVENT_EXIST);
				result.put("advnErrMsg", API_EVENT_EXIST_MSG);

				return result;
			}

			advnErr = "SUCCESS";

			// 떠블클릭 체크
			if (advnInfo.getDoubleClickChk() > 0) {
				// throw new EzApiException(API_CODE_PAY_OVER_01, API_CODE_PAY_OVER_01_MSG);
				// advnErr = "DOUBLE";

				advnErr = API_CODE_CALL_DOUBLE;
				advnErrMsg = API_CODE_CALL_DOUBLE_MSG;

				advnInfo.setAdvncmtPointScore(0);

				// 총지급횟수 체크
			} else if (advnInfo.getTotAppntCnt() <= advnInfo.getAllAppntPlbsCnt()) {
				// advnErr = "ALL";

				advnErr = API_CODE_PAY_OVER_01;
				advnErrMsg = API_CODE_PAY_OVER_01_MSG;

				advnInfo.setAdvncmtPointScore(0);

				// 월지급 체크
			} else if (advnInfo.getMonthAppntCnt() <= advnInfo.getMonthAppntPlbsCnt()) {
				// advnErr = "MONTH";

				advnErr = API_CODE_PAY_OVER_02;
				advnErrMsg = API_CODE_PAY_OVER_02_MSG;

				advnInfo.setAdvncmtPointScore(0);

				// 일지급 체크
			} else if (advnInfo.getDayAppntCnt() <= advnInfo.getTodayAppntPlbsCnt()) {
				// advnErr = "TODAY";

				advnErr = API_CODE_PAY_OVER_03;
				advnErrMsg = API_CODE_PAY_OVER_03_MSG;

				advnInfo.setAdvncmtPointScore(0);
			}

			int advnCode = 0;
			// 구매보상 승금점수 등록
			if (advnInfo.getAdvncmtPointScore() > 0) {

				CrmAdvncmtHstVo advncmtHstVo = new CrmAdvncmtHstVo();
				advncmtHstVo.setMshipGradeCd(custVo.getMshipGradeCd());

				advncmtHstVo.setPblsDivCd(advnInfo.getAdvncmtComnCd());
				advncmtHstVo.setItgCustNo(custVo.getItgCustNo());
				advncmtHstVo.setAccumYn("Y");
				advncmtHstVo.setOccurAdvncmtScore(advnInfo.getAdvncmtPointScore());
				advncmtHstVo.setRemainAdvncmtScore(advnInfo.getAdvncmtPointScore() + advnInfo.getAllAdvnCmtScore());

				advncmtHstVo.setChitNo(
						plcyVo.getPblsDivCd() + Utilities.getDateTimeString() + Utilities.getUniqNumberID(3));

				advncmtHstVo.setRcmdrCustNo2(plcyInfo.getRcmdrCustNo2());

				advnCode = advnCmtHstService.insertAdVnCmt(advncmtHstVo);

			}

			result.put("advnErr", advnErr);
			result.put("advnErrMsg", advnErrMsg);
			result.put("advnCode", advnCode);
			result.put("advnPoint", advnInfo.getAdvncmtPointScore());

		}

		return result;
	}

	private Map<String, Object> chkTemEvtPoint(CrmCustVo custVo) throws Exception {

		Map<String, Object> result = new LinkedHashMap<String, Object>();

		// 멤버십 앱만 | 채널코드[MEM] and 가입ID가 존재하는 고객만

		if ((!custVo.getRegChlCd().equals("MEM"))
				|| (custVo.getRegChlCd().equals("MEM") && Utilities.isEmpty(custVo.getMshipLoginId())))
			return result;

		CrmPointHstVo crmPointHstVo = new CrmPointHstVo();
		crmPointHstVo.setPblsDivCd(custVo.getEventCd());
		crmPointHstVo.setItgCustNo(custVo.getItgCustNo());

		crmPointHstVo.setRcmdrCustNo2(custVo.getRcmdrCustNo2());

		CrmPointInfoVo info = pointHstDao.selectPointInfo(custVo);

		String pntErr = "";
		String pntErrMsg = "";

		// 1. 날짜체크 2023.02.01 ~ 2023.02.28
		// 2. 5000 포인트 지급
		// 3. 유효기간 3개월 설정 > 공통 insert 시 nvl(이벤트날짜,기존)

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		Date currentTime = new Date();

		String today = sdf.format(currentTime);
		String start_dt = "20230501000000"; // 20230501000000
		String end_dt = "20230531235959"; // 20230531235959

//		String start_dt = "130000";
//		String end_dt = "155959";

		Date startDt = sdf.parse(start_dt);
		Date endDt = sdf.parse(end_dt);
		Date toDt = sdf.parse(today);

		int compare1 = toDt.compareTo(startDt);
		int compare2 = endDt.compareTo(toDt);

		int pntCode = 0;
		int score = 0;

		// ==============================================
		// 회수제한
		CrmMshipPlcyBasVo plcyVo = new CrmMshipPlcyBasVo();
		plcyVo.setItgCustNo(custVo.getItgCustNo()); // 통합고객번호
		plcyVo.setPblsDivCd(custVo.getEventCd()); // 쿠폰종류코드
		plcyVo.setStatusCd("Y"); // 사용유무

		plcyVo.setOrgItgCustNo(custVo.getOrgItgCustNo());
		plcyVo.setOrgMshipPlcyBasNo(custVo.getOrgMshipPlcyBasNo());
		plcyVo.setRcmdrCustNo(custVo.getRcmdrCustNo());

		plcyVo.setRcmdrCustNo2(custVo.getRcmdrCustNo2());

		// 정책을 불러온다.
		CrmMshipPlcyBasVo plcyInfo = plcyDao.selectPlcyInfo(plcyVo);

		// ==============================================
		if (plcyInfo == null) {
			pntErr = "NULL";

			result.put("pntErr", API_EVENT_EXIST);
			result.put("pntErrMsg", API_EVENT_EXIST_MSG);

			return result;

		} else {

			result.put("pntErr", null);
			result.put("pntCode", null);

			crmPointHstVo.setOccurPointScore(0);
			crmPointHstVo.setUseTypeCd(CrmPointHstService.USE_TYPE_DEPOSIT); // 적립코드
			crmPointHstVo.setPblsDivCd(plcyVo.getPblsDivCd());

			plcyInfo.setPblsDivCd(plcyVo.getPblsDivCd());
			plcyInfo.setOrgItgCustNo(plcyVo.getOrgItgCustNo());
			plcyInfo.setOrgMshipPlcyBasNo(plcyVo.getOrgMshipPlcyBasNo());
			plcyInfo.setRcmdrCustNo2(plcyVo.getRcmdrCustNo2());

			// 이벤트 포인트 정책을 가져온다.
			// 이미 정책에서 이벤트 포인트 설정해도 한번만 지급
			CrmMshipApplyPointRelVo pntInfo = plcyDao.selectEventPointCnt(plcyInfo);

			pntErr = "SUCCESS";
			pntErrMsg = "";

			// 총 1 회
			if (pntInfo != null && pntInfo.getAllPntPlbsCnt() >= 1) {
				pntErr = API_CODE_PAY_OVER_03;
				pntErrMsg = API_CODE_PAY_OVER_03_MSG;
			}

			// 이벤트 기간이내
			if ("SUCCESS".equals(pntErr) && compare1 >= 0 && compare2 >= 0) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				DateFormat df = new SimpleDateFormat("yyyyMMdd");
				cal.add(Calendar.MONTH, 3);
				log.debug("after: " + df.format(cal.getTime()));

				score = 5000;
				crmPointHstVo.setOccurPointScore(score);
				crmPointHstVo.setMshipGradeCd(custVo.getMshipGradeCd());
				crmPointHstVo.setAccumYn("Y");
				crmPointHstVo.setTemValidPerdYmd(df.format(cal.getTime()));

				info.setOccurPointScore(score);
				info.setTotalPoint(info.getTotalPoint() + score);
				info.setAvailablePoint(info.getAvailablePoint() + score);
				info.setItgCustNo(info.getItgCustNo());

				crmPointHstVo.setRemainPointScore(info.getAvailablePoint());

				crmPointHstVo.setMessageYn("N");
				crmPointHstVo.setChitNo(Utilities.getAutoSeq("CHT"));

				CrmPointInfoVo crmPointInfoVo = pointHstService.saveDeposit(crmPointHstVo);
				pntCode = crmPointInfoVo.getOccurPointScore();
				pntErr = "SUCCESS";
			} else {
				pntErr = "EVENTPNT";
			}

			result.put("pntErr", pntErr);
			result.put("pntErrMsg", pntErrMsg);
			result.put("pntCode", pntCode);
			result.put("pntPoint", score);
		}

		return result;
	}

	public int updateLastLogin(CrmCustVo vo) throws Exception {
		CrmCustVo member = get(vo);
		if (member == null)
			return 0;
		if (Constants._USER_STATUS_DORMANT.equals(member.getCustStatusCd())) {
			try {
				updateNormal(member);
			} catch (Exception ex) {
				log.debug(ex.getMessage());
			}

		}
		insertLoginHist(vo);
		int ret = dao.updateLastLogin(vo);
		try {
			String regChlCd = Utilities.getSystemCd();
			// 추후에 멤버십 제거
			if ("MEM".equals(regChlCd) && Utilities.isNotEmpty(vo.getAppPushTokn())
					&& Utilities.isNotEmpty(vo.getAppPushOsCd())) {
				String agreeYn = vo.getPushRcvAgreeYn();
				if (!"Y".equals(agreeYn) && !"N".equals(agreeYn)) {
					member.setAppPushTokn(vo.getAppPushTokn());
					member.setAppPushOsCd(vo.getAppPushOsCd());
					member.setRegrId(regChlCd);
					member.setAmdrId(regChlCd);
					member.setRegChlCd(regChlCd);
					updateAppToken(member);
					return ret;
				}

				CrmAgreementVo agreement = new CrmAgreementVo();
				agreement.setPushRcvAgreeYn(agreeYn);
				agreement.setItgCustNo(vo.getItgCustNo());
				agreement.setRegrId(regChlCd);
				agreement.setAmdrId(regChlCd);
				agreement.setAppPushOsCd(vo.getAppPushOsCd());
				agreement.setAppPushTokn(vo.getAppPushTokn());
				agreement.setRegChlCd(regChlCd);
				agreeService.updateAgreement(agreement);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

		return ret;
	}

	public int insertLoginHist(CrmCustVo vo) {
		try {
			CrmMshipLoginHstVo hst = new CrmMshipLoginHstVo();
			hst.setItgCustNo(vo.getItgCustNo());
			hst.setLoginIpAddr(vo.getMshipLastLoginIpAddr());
			hst.setLoginDt(vo.getMshipLastLoginDt());
			hst.setChlCd(Utilities.getSystemCd());
			return loginHstDao.insert(hst);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return 0;

	}

	public int updateLastVisitStore(CrmCustVo vo) throws Exception {
		// vo.getMshipLastVisitStorNo();
		dao.updateLastPatronStore(vo);
		return dao.updateLastVisitStore(vo);
	}

	public CrmCustVo updateSwichMember(String itgCustNo, String dupItgCustNo) {
		return null;
	}

	public int updateLoginPassword(CrmCustVo vo) throws Exception {
		CrmCustVo cust = dao.select(vo);
		if (cust == null)
			return 0;
		CrmCustInfoChngHstVo info = new CrmCustInfoChngHstVo();
		info.setItgCustNo(vo.getItgCustNo());
		info.setChngClusCtnts("로그인암호변경");
		info.setChngCtnts(vo.getMshipLoginPwd());
		info.setChngPreCtnts(cust.getMshipLoginPwd());
		info.setChngWhyCtnts(getCallChannel() + " 변경");
		int ret = dao.updateLoginPassword(vo);
		infoChangeService.insert(info);
		asyncService.sendCustmerApiEvent(vo.getItgCustNo(), Constants._CUST_EVENT_MODIFY_PWD, getCallChannel());
		return ret;
	}

	public int updateLoginIdPassword(CrmCustVo vo) throws Exception {
		if (Utilities.isEmpty(vo.getMshipLoginId()))
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "ID는 빈값일 수 없습니다.");

		CrmCustVo cust = dao.select(vo);
		if (cust == null)
			return 0;
		CrmCustSo so = new CrmCustSo();

		so.setExceptItgCustNo(vo.getItgCustNo());
		so.setMshipLoginId(vo.getMshipLoginId());

		int cnt = dao.selectListCount(so);
		if (cnt > 0)
			throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM,
					Constants._API_CODE_DUPLICATED_PARAM_LOGIN_ID_MSG);

		int ret = dao.updateLoginIdPassword(vo);
		CrmCustInfoChngHstVo info = new CrmCustInfoChngHstVo();
		info.setItgCustNo(vo.getItgCustNo());
		info.setChngClusCtnts("로그인아이디변경");
		info.setChngCtnts(vo.getMshipLoginId());
		info.setChngPreCtnts(cust.getMshipLoginId());
		info.setChngWhyCtnts(getCallChannel() + " 변경");
		infoChangeService.insert(info);

		info = new CrmCustInfoChngHstVo();
		info.setItgCustNo(vo.getItgCustNo());
		info.setChngClusCtnts("로그인암호변경");
		info.setChngCtnts(vo.getMshipLoginPwd());
		info.setChngPreCtnts(cust.getMshipLoginPwd());
		info.setChngWhyCtnts(getCallChannel() + " 변경");
		infoChangeService.insert(info);
		asyncService.sendCustmerApiEvent(vo.getItgCustNo(), Constants._CUST_EVENT_MODIFY_IDPWD, getCallChannel());
		return ret;
	}

	public CrmCustVo saveInstaller(CrmCustInstallLocVo installer) throws Exception {
		String mnum = installer.getMphonNo();
		String backNum = null;
		if (Utilities.isEmpty(mnum) || mnum.length() < 4)
			backNum = mnum;
		else
			backNum = mnum.substring(mnum.length() - 4);

		CrmCustVo vo = Utilities.beanToBean(installer, CrmCustVo.class);
		vo.setRegrId(vo.getIndiInfoHandlPrsnNo());
		vo.setCustTypeCd("004");

		CrmCustSo so = new CrmCustSo();
		so.setCustNm(installer.getCustNm());
		so.setMphonNo(installer.getMphonNo());
		so.setForceDecrypt(true);

		CrmCustVo cust = getNamePhone(so);

		if (cust == null) {
			insert(vo);
			so.setItgCustNo(vo.getItgCustNo());
			cust = get(so);
		} else {
			cust.setCustTypeCd("004");

			CrmCustCntplcBasSo cSo = new CrmCustCntplcBasSo();
			cSo.setCntplcTypeCd("001");
			cSo.setItgCustNo(cust.getItgCustNo());
			cSo.setForceDecrypt(true);
			cSo.setTelNo(installer.getMphonNo());
			List<CrmCustCntplcBasVo> conList = contactService.getList(cSo);
			CrmCustCntplcBasVo contact = null;
			boolean find = false;
			for (int i = 0; i < conList.size(); i++) {
				if (mnum.equals(conList.get(i).getTelNo())) {
					contact = conList.get(i);
					find = true;
					break;
				}
			}
			if (!find) {
				contact = new CrmCustCntplcBasVo();
				contact.setTelNo(installer.getMphonNo());
				contact.setItgCustNo(cust.getItgCustNo());
				contact.setCntplcTypeCd("001");
				contact.setTelBkDgtNo(backNum);
			}
			if (Utilities.isNotEmpty(installer.getEmailAddr()))
				contact.setEmailAddr(installer.getEmailAddr());
			if (Utilities.isNotEmpty(installer.getDistrctCd())) {
				contact.setDistrctCd(installer.getDistrctCd());
				contact.setZipCd(installer.getZipCd());
				contact.setAddr1Ctnts(installer.getAddr1Ctnts());
				contact.setAddr2Ctnts(installer.getAddr2Ctnts());
			}

			dao.updateCustType(cust);
			if (find)
				contactService.update(contact);
			else
				contactService.insert(contact);
			cust.setDecryptYn("Y");
			cust = get(cust);

		}

		return cust;

	}

	public void checkCustSo(CrmCustSo param) throws Exception {
		if (Utilities.isEmpty(param))
			return;
		// Map<String, Object> checkParam = param;
		Map<String, Object> inMap = Utilities.beanToMap(new CrmSnstvInfoInqrySo());
		// for( String strKey : inMap.keySet() ){
		// checkParam.remove(strKey);
		// }
		// checkParam.remove("indiInfoHandlPrsnNo");
		// checkParam.remove("connPrsnIpAddr");
		// checkParam.remove("dnldTxn");
		// checkParam.remove("pfmWorkCd");
		// checkParam.remove("currentPageNo");
		// checkParam.remove("recordCountPerPage");

		// CrmCustSo obj = Utilities.mapToBean(checkParam, CrmCustSo.class) ;
		Map<String, Object> filter = Utilities.beanToMap(param);
		for (String strKey : inMap.keySet()) {
			filter.remove(strKey);
		}
		List<String> arr = new ArrayList<String>();
		for (String strKey : filter.keySet()) {
			if (Utilities.isEmpty(filter.get(strKey)))
				arr.add(strKey);
		}
		for (int i = 0; i < arr.size(); i++) {
			filter.remove(arr.get(i));
		}
		filter.remove("custDivCd");
		filter.remove("includeContactYn");

		if (Utilities.isEmpty(filter)) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "검색조건이 설정되지 않았습니다.");
		}
	}

	public CrmCustVo getModifiedCust(Map<String, Object> param) throws Exception {
		if (param == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		param.put("decryptYn", "Y");
		CrmCustVo old = dao.select(param);
		param.remove("decryptYn");
		if (old == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		Map<String, Object> oldMap = Utilities.beanToMap(old);

		for (String strKey : param.keySet()) {
			oldMap.put(strKey, param.get(strKey));
		}
		CrmCustVo vo = Utilities.mapToBean(oldMap, CrmCustVo.class);
		Utilities.validate(vo);
		return vo;

	}

	public int saveAlliance(Object param) throws Exception {
		Map<String, Object> map = Utilities.beanToMap(param);
		String itgCustNo = (String) map.get("itgCustNo");
		String mphonNo = (String) map.get("mphonNo");
		/* String cprtCmpNo = (String)map.get("cprtCmpNo"); */
//		String custNm = (String) map.get("custNm");
//		String empNo = (String) map.get("empNo");
		if (Utilities.isEmpty(itgCustNo) && Utilities.isEmpty(mphonNo)) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "통합고객 번호 또는 이동전화번호 중 한가지 값은 입력해야 합니다.");
		}
		if (Utilities.isEmpty(itgCustNo)) {
			CrmCustVo cust = dao.selectNamePhone(param);
			if (cust == null)
				throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "존재하지 않는 회원입니다.");
			if (!"Y".equals(cust.getMshipSbscYn())) {
				throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "멤버십회원이 아닙니다.");
			}
			itgCustNo = cust.getItgCustNo();
			map.put("itgCustNo", itgCustNo);
		}
		dao.updateAllianceRefNull(map);
		int ret = dao.updateAlliance(map);
		if (ret > 0)
			dao.updateAllianceRef(map);
		return ret;
	}

	public int updateAppToken(CrmCustVo vo) throws Exception {
//		CrmCustVo membership = dao.selectBasic(vo);
//		if (!"Y".equals(membership.getMshipSbscYn()))
//			return 0;
//		String pYn = membership.getPushRcvAgreeYn();
//		String aYn = vo.getPushRcvAgreeYn();
//		String pTk = membership.getAppPushTokn();
//		String tk = vo.getAppPushTokn();
//		
//		

		int ret = dao.updateToken(vo);
		if (ret > 0 && Utilities.isNotEmpty(vo.getAppPushTokn())) {
			CrmMshipAppToknBasVo s = new CrmMshipAppToknBasVo();
			s.setAppPushTokn(vo.getAppPushTokn());
			CrmMshipAppToknBasVo t = tokenDao.select(vo);
			s.setAppPushOsCd(vo.getAppPushOsCd());
			s.setItgCustNo(vo.getItgCustNo());
			s.setAgreeYn(vo.getPushRcvAgreeYn());
			if ("Y".equals(s.getAgreeYn()))
				s.setAgreeDt(Utilities.getDateTimeString());
			if ("N".equals(s.getAgreeYn()))
				s.setRfslDt(Utilities.getDateTimeString());
			tokenDao.updateTokenUseYn(s);
			s.setUseYn("Y");
			if (t == null)
				tokenDao.insert(s);
			else
				tokenDao.update(s);

		}
		return ret;
	}

	public int updateAppToken(CrmMshipAppToknBasVo vo) throws Exception {
		String chlCd = vo.getRegChlCd();
		if (Utilities.isEmpty(chlCd))
			chlCd = Utilities.getSystemCd();

		int ret = 0;

		if ("MEM".equalsIgnoreCase(chlCd)) {
			CrmCustVo cust = new CrmCustVo();
			cust.setItgCustNo(vo.getItgCustNo());
			cust.setAppPushTokn(vo.getAppPushTokn());
			cust.setAppPushOsCd(vo.getAppPushOsCd());
			cust.setPushRcvAgreeYn(vo.getAgreeYn());
			CrmAgreementVo agreement = new CrmAgreementVo();
			if (Utilities.isNotEmpty(vo.getAgreeYn())) {
				agreement.setPushRcvAgreeYn(vo.getAgreeYn());
				agreement.setItgCustNo(vo.getItgCustNo());
				agreement.setRegrId(vo.getRegChlCd());
				agreement.setAmdrId(vo.getRegChlCd());
				agreement.setAppPushOsCd(vo.getAppPushOsCd());
				agreement.setAppPushTokn(vo.getAppPushTokn());
				agreement.setRegChlCd(vo.getRegChlCd());
				agreeService.updateAgreement(agreement);
				ret = 1;
			} else {
				ret = dao.updateToken(cust);
			}
		} else {
			CrmMshipAppToknBasVo t = tokenDao.select(vo);
			if ("Y".equals(vo.getAgreeYn()) && Utilities.isEmpty(vo.getAgreeDt()))
				vo.setAgreeDt(Utilities.getDateTimeString());
			if ("N".equals(vo.getAgreeYn()) && Utilities.isEmpty(vo.getRfslDt()))
				vo.setRfslDt(Utilities.getDateTimeString());
			tokenDao.updateTokenUseYn(vo);
			if (t == null) {
//				ret = tokenDao.deleteAppId(vo);
				ret = tokenDao.insert(vo);
			} else
				ret = tokenDao.update(vo);

		}

		return ret;
	}

	public int updateAppPushRead(EzMap so) {
		List<EzMap> list = tokenDao.selectDispatch(so);
		if (Utilities.isEmpty(list)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			EzMap vo = list.get(i);
			if (!"001".equals(vo.getString("pushStatusCd")))
				cnt++;

		}
		if (cnt == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, "이미 처리된 데이터 입니다.");
		return tokenDao.updatePushRead(so);
	}

	public int updateAppPushReadAll(EzMap so) {
		so.setString("chlCd", Utilities.getSystemCd());
		return tokenDao.updatePushReadAll(so);
	}

	public CrmAppPushTrmHstVo selectPushTrm(EzMap so) {
		return tokenDao.selectPushTrm(so);
	}

	public List<CrmAppPushTrmHstVo> selectPushTrmList(EzMap so) {
		so.setString("chlCd", Utilities.getSystemCd());
		return tokenDao.selectPushTrmList(so);
	}

	public int selectPushTrmListCount(EzMap so) {
		return tokenDao.selectPushTrmListCount(so);
	}

	public String getToday() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formatedNow = now.format(formatter);
		return formatedNow;
	}

	public String getHowDay(int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		cal.add(Calendar.DATE, day);
		return df.format(cal.getTime());
	}

	public int updateAgreementDeny(String rNumber, String uNumber) throws Exception {
		if (Utilities.isEmpty(rNumber))
			return 0;
		CrmCustSo so = new CrmCustSo();
		so.setMphonNo(rNumber);
		List<CrmCustVo> list = getList(so);
		int ret = 0;
		for (int i = 0; i < list.size(); i++) {
			CrmCustVo cust = list.get(i);
			if (Constants._USER_STATUS_DELETE.equals(cust.getCustStatusCd()))
				continue;
			CrmAgreementVo agree = new CrmAgreementVo();
			agree.setRegChlCd("EON");
			boolean update = false;
			agree.setItgCustNo(cust.getItgCustNo());
			if (!"N".equals(cust.getMarketingAgreeYn())) {
				agree.setMarketingYn("N");
				update = true;
			}
			if (!"N".equals(cust.getSmsRcvAgreeYn())) {
				agree.setSmsRcvAgreeYn("N");
				update = true;
			}
			if (update) {
				updateAgreement(agree);
				ret++;
			}

		}
		return ret;
	}

	public void sendCustmerApiEvent(String itgCustNo, String code, String exceptCh) throws Exception {
		if (!useEvent)
			return;
		try {
			if (!"BOS".equals(exceptCh) || !"CSS".equals(exceptCh) || !"CRS".equals(exceptCh))
				bosApiService.sendCustEvent(itgCustNo);
		} catch (Exception ex) {
			log.debug(ex.getMessage());
		}
//		try {
//			String url = String.format(labEventUrl, itgCustNo, code);
//			log.debug(url);
//			if (!"PRC".equals(exceptCh))
//				Utilities.wget(url, null, null, false, "POST");
//
//		} catch (Exception ex) {
//			log.debug(ex.getMessage());
//		}
		try {

			if ("prod".equals(activeProfile)) {
				if (Constants._CUST_EVENT_MODIFY.equals(code) || Constants._CUST_EVENT_WITHDRAWAL.equals(code)) {

//					try {
//						if (!"COM".equals(exceptCh)) {
//							String url2 = String.format(
//									"http://kaimen.shop/ceragem/api/crm/membership_re.php?itgCustNo=%s&eventNo=%s",
//									itgCustNo, code);
//							String tok = "Bearer QUtpTndnS2RpRVp3SC9TQ1hGa0hCUT09";
//							Map<String, String> header = new HashMap<String, String>();
//							header.put("Authorization", tok);
//							Utilities.wget(url2, null, null, false, "GET", header, 60000);
//						}
//					} catch (Exception e) {
//
//					}
					String url = String.format(comEventUrl, itgCustNo, code);
					if (!"COM".equals(exceptCh))
						Utilities.wget(url, null, null, false, "GET", null, 60000);
				}

			}

		} catch (Exception ex) {
			log.debug(ex.getMessage());
		}

		try {
			if (Constants._CUST_EVENT_MODIFY.equals(code) || Constants._CUST_EVENT_WITHDRAWAL.equals(code)) {
				String url = String.format(chkEventUrl, itgCustNo, code);
				if (!"CRA".equals(exceptCh))
					Utilities.wget(url, null, null, false, "GET", null, 60000);
			}
		} catch (Exception ex) {
			log.debug(ex.getMessage());
		}
		try {
			if (Constants._CUST_EVENT_MODIFY.equals(code) || Constants._CUST_EVENT_WITHDRAWAL.equals(code)) {
				String url = String.format(memEventUrl, itgCustNo, code);
				if (!"MEM".equals(exceptCh))
					Utilities.wget(url, null, null, false, "GET", null, 60000);
			}
		} catch (Exception ex) {
			log.debug(ex.getMessage());
		}
	}

	public String getCallChannel() {
		return Utilities.getSystemCd();
	}

	public List<CrmCustBosCntrtHstVo> getCustContractList(Object param) {
		return contractDao.selectCustContractList(param);
	}

	public int getCustContractListCount(Object param) {
		return contractDao.selectCustContractListCount(param);
	}

	public String getMindfitUseList(Map<String, Object> params) {

		DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(mindfitBaseUrl);
		factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

		ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
				.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)) // to unlimited memory size
				.build();

		WebClient webClient = WebClient.builder().uriBuilderFactory(factory).baseUrl(mindfitBaseUrl)
				.exchangeStrategies(exchangeStrategies).build();

		// api 요청
		String resJsonData = webClient.get()
				.uri(uriBuilder -> uriBuilder.path(mindfitPath).queryParam("access_key", mindfitAccessKey)
						.queryParam("secret_key", mindfitSecretKey).queryParam("from", params.get("from").toString())
						.queryParam("to", params.get("to").toString()).build())
				.retrieve().bodyToMono(String.class).block();

		return resJsonData;
	}

	public Map<String, Object> issueEvent(Map<String, Object> param) throws Exception {
		Map<String, Object> ret = new HashMap<>();
		try {
			List<CrmCouponVo> res = couponService.insertEventCoupon(param);

			if (Utilities.isNotEmpty(res)) {
				ret.put("eventCoupnErr", "OK");
				ret.put("eventCoupnCode", null);
				ret.put("eventCoupnMsg", "");
				ret.put("eventCoupnList", res);
				ret.put("eventCoupnCount", res.size());
			} else {
				ret.put("eventCoupnErr", "NOT_EXIST");
				ret.put("eventCoupnCode", null);
				ret.put("eventCoupnMsg", "진행중인 쿠폰 이벤트가 없습니다.");
			}
		} catch (Exception ex) {
			ret.put("eventCoupnErr", "SYSTEM_ERR");
			ret.put("eventCoupnCode", null);
			ret.put("eventCoupnMsg", ex.getClass().getName());
		}
		return ret;
	}

}
