package com.ceragem.api.crm.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmCustBasDao;
import com.ceragem.api.crm.dao.CrmPointHstDao;
import com.ceragem.api.crm.dao.CrmStorBasDao;
import com.ceragem.api.crm.dao.MsgIfDao;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmPointInfoVo;
import com.ceragem.api.crm.model.CrmStorBasVo;
import com.ceragem.api.crm.model.MsgCodeVo;
import com.ceragem.api.crm.model.MsgIfVo;
import com.ceragem.crm.common.model.EzMap;

/**
 * 
 * @ClassName EonMessageService
 * @author 김성태
 * @date 2022. 8. 9.
 * @Version 1.0
 * @description
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class EonMessageService {
	private final SimpleDateFormat DATETIME_FORMAT_ORG = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREAN);
	private final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREAN);

//	private static final String CLIENT = "crm_1";

//	private static final int DORM_BEFOR_CNT = 1;

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

	@Value("${spring.eon.mail-addr}")
	String mailAddr;

	@Value("${spring.eon.mail-name}")
	String mailName;

	@Autowired
	CrmCustBasDao custDao;

	@Autowired
	CrmStorBasDao storeDao;

	@Autowired
	MsgIfDao msgIfDao;

	@Autowired
	CrmPointHstDao pointDao;

	@Autowired
	CrmAsyncService asyncService;

//	Map<String, MsgIfVo> messageCodeMap = null;
//
//	Map<String, Integer> eventCntMap = new HashMap<String, Integer>();
//
//	String currentTime = Utilities.getDateTimeString();

	public String getTalkTemplateText(String template, Map<String, Object> map) {
		if (Utilities.isEmpty(template) || Utilities.isEmpty(map))
			return template;
		Map<String, Object> variant = getVariant(template, map);
		String ret = template;
		for (Map.Entry<String, Object> entry : variant.entrySet()) {
			String strKey = entry.getKey();
			String strValue = Utilities.nullCheck(entry.getValue());
			ret = ret.replace("#{" + strKey + "}", strValue + "");
		}
		ret = ret.replace("#{}", "");
		return ret;
	}

	public Map<String, Object> getVariant(String template, Map<String, Object> map) {
		Map<String, Object> variant = new LinkedHashMap<>();
		int index = -1;
		if (Utilities.isEmpty(template))
			return variant;
		while (true) {
			int idx = template.indexOf("#{", index);
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

	public String getTimeString(String tmStr) throws Exception {
		String tm = tmStr;
		Calendar cal = Calendar.getInstance();
		String timeString = Utilities.getTimeString().substring(0, 4);
		if (Utilities.isEmpty(tm) || tm.length() < 4) {
			int time = Utilities.parseInt(timeString.substring(0, 4));
			if (time < 900)
				tm = "1000";
			else if (time > 1800)
				tm = "1000";
			else
				tm = timeString;
		}
		String time = tm.substring(0, 4);
		if (Utilities.parseLong(timeString) > Utilities.parseLong("1800")) {
			cal.add(Calendar.DATE, 1);
		}
		String dateString = Utilities.getDateString(cal.getTime());
		Date dt = DATETIME_FORMAT_ORG.parse(dateString + time + "00");
		return DATETIME_FORMAT.format(dt);
	}

	public int sendMessage(MsgIfVo message) throws Exception {
		message.setSrctel(smsSenderNo);
		if (Utilities.isEmpty(message.getSenderKey()))
			message.setSenderKey(talkSenderKey);
		return msgIfDao.insert(message);
	}

	public int sendMessage(List<? extends MsgIfVo> msgList) throws Exception {
		int ret = 0;
		for (int i = 0; i < msgList.size(); i++) {
			MsgIfVo message = msgList.get(i);
			message.setMemberSeq((i + 1) + "");
			ret += sendMessage(message);
		}
		return ret;
	}

	public void sendAsyncPointMessage(String itgCustNo, int pt, String codeCd, String storNo,boolean reserve) throws Exception {
		asyncService.sendPointMessage(itgCustNo, pt, codeCd, storNo,reserve);
	}

	public int sendPointMessage(String itgCustNo, int pt, String codeCd, String storNo,boolean reserve) throws Exception {

		if (pt == 0)
			return 0;
		EzMap param = new EzMap();
		param.setString("codeCd", codeCd);
		MsgCodeVo code = msgIfDao.selectCode(param);
		if (code == null || !"Y".equals(code.getUseYn())) {
			return 0;
		}
		if(reserve && Utilities.isEmpty(code.getTalkSendTime()))
			code.setRfrn2ComnCd("1000");
			
		param.setString("itgCustNo", itgCustNo);
		CrmCustVo cust = custDao.selectMphone(param);
		if (cust == null)
			return 0;
		CrmPointInfoVo info = pointDao.selectPointInfo(param);

		param.setString("storNo", storNo);
		CrmStorBasVo store = storeDao.select(param);
		int point = Math.abs(pt);
		info.setOccurPointScore(point);
		Map<String, Object> msgMap = Utilities.beanToMap(info);
		String pointDay = Utilities.getDateString("-");

		msgMap.put("storNo", storNo);
		String storeNm = null;
		if (store != null) {
			storeNm = store.getStorNm();

		}
		String strOPoint = Utilities.getNumberString(info.getOccurPointScore());
		String strTPoint = Utilities.getNumberString(info.getTotalPoint());
		// cust
		msgMap.put("custNm", cust.getCustNm());
		msgMap.put("회원명", cust.getCustNm());
		msgMap.put("고객명", cust.getCustNm());
		msgMap.put("적립일자", pointDay);

		msgMap.put("적립일자", pointDay);
		msgMap.put("사용일자", pointDay);
		msgMap.put("취소일자", pointDay);
		msgMap.put("적립포인트", strOPoint);
		msgMap.put("사용포인트", strOPoint);
		msgMap.put("차감포인트", strOPoint);
		msgMap.put("취소포인트", strOPoint);
		msgMap.put("잔여포인트", strTPoint);
		msgMap.put("storNm", storeNm);
		msgMap.put("사용처", storeNm);

		MsgIfVo message = getMessage(code, itgCustNo, cust.getMphonNo(), msgMap);
		message.setCampaignId(null);
		return sendMessage(message);
	}
	

	
	// 구매추천 추가
	public int sendPointRcmdrMessage(String itgCustNo, int pt, String codeCd, String storNo,boolean reserve, String rcmdrCustNm) throws Exception {

		if (pt == 0)
			return 0;
		EzMap param = new EzMap();
		param.setString("codeCd", codeCd);		
		MsgCodeVo code = msgIfDao.selectCode(param);
		if (code == null || !"Y".equals(code.getUseYn())) {
			return 0;
		}
		if(reserve && Utilities.isEmpty(code.getTalkSendTime()))
			code.setRfrn2ComnCd("1000");
			
		param.setString("itgCustNo", itgCustNo);
		CrmCustVo cust = custDao.selectMphone(param);
		if (cust == null)
			return 0;
		CrmPointInfoVo info = pointDao.selectPointInfo(param);

		int point = Math.abs(pt);
		info.setOccurPointScore(point);
		Map<String, Object> msgMap = Utilities.beanToMap(info);
		
		String strOPoint = Utilities.getNumberString(info.getOccurPointScore());
		
		// cust
		msgMap.put("추천인", cust.getCustNm());
		msgMap.put("피추천인", rcmdrCustNm);
		msgMap.put("보상포인트", strOPoint );


		MsgIfVo message = getMessage(code, itgCustNo, cust.getMphonNo(), msgMap);
		message.setCampaignId(null);
		return sendMessage(message);
	}
	
	

	public void sendAsyncAgreeMessage(String itgCustNo, String codeCd) throws Exception {
		asyncService.sendAgreeMessage(itgCustNo, codeCd);
	}

	public int sendAgreeMessage(String itgCustNo, String codeCd) throws Exception {
		EzMap param = new EzMap();
		param.setString("codeCd", codeCd);
		MsgCodeVo code = msgIfDao.selectCode(param);
		if (code == null|| !"Y".equals(code.getUseYn())) {
			return 0;
		}

		param.setString("itgCustNo", itgCustNo);
		CrmCustVo cust = custDao.selectMphone(param);
		if (cust == null)
			return 0;

		Map<String, Object> msgMap = Utilities.beanToMap(cust);
		String agreeDay = Utilities.getDateString("-");

		String statusNm = "Y".equals(cust.getMarketingAgreeYn()) ? "수신동의" : "수신거부";
		// cust
		msgMap.put("custNm", cust.getCustNm());
		msgMap.put("회원명", cust.getCustNm());
		msgMap.put("고객명", cust.getCustNm());
		msgMap.put("agreeDay", agreeDay);
		msgMap.put("변경일", agreeDay);
		msgMap.put("광고성 수신 정보 동의일", agreeDay);
		msgMap.put("광고성 정보 수신 철회일", agreeDay);

		msgMap.put("변경상태", statusNm);
		MsgIfVo message = getMessage(code, itgCustNo, cust.getMphonNo(), msgMap);
		message.setCampaignId(null);
		return sendMessage(message);
	}

	
	public int sendCustStatusMessage(String itgCustNo, String codeCd) throws Exception {
		EzMap param = new EzMap();
		param.setString("codeCd", codeCd);
		MsgCodeVo code = msgIfDao.selectCode(param);
		if (code == null) {
			return 0;
		}

		param.setString("itgCustNo", itgCustNo);
		CrmCustVo cust = custDao.selectMphone(param);
		if (cust == null|| !"Y".equals(code.getUseYn()))
			return 0;

		Map<String, Object> msgMap = Utilities.beanToMap(cust);
		String procDt = Utilities.getDateString("-");
		msgMap.put("고객님", cust.getCustNm());
		msgMap.put("회원명", cust.getCustNm());
		msgMap.put("고객명", cust.getCustNm());
		msgMap.put("회원명", cust.getCustNm());
		
		msgMap.put("핸드폰번호", Utilities.getPhoneNumberFormat(cust.getMphonNo()));
		msgMap.put("휴면처리일자", procDt);
		msgMap.put("탈퇴처리일자", procDt);
		msgMap.put("가입일자", cust.getMshipSbscDt());
		msgMap.put("비활동기간", cust.getDormPerdCd());
		msgMap.put("비활동 기간", cust.getDormPerdCd());

		MsgIfVo message = getMessage(code, itgCustNo, cust.getMphonNo(), msgMap);
		message.setCampaignId(null);
		return sendMessage(message);

	}

	public MsgIfVo getMessage(MsgCodeVo code, String itgCustNo, String mphoneNo, Map<String, Object> msgMap)
			throws Exception {
		String msg = getTalkTemplateText(code.getTalkTemplate(), msgMap);
		String subject = getTalkTemplateText(code.getSubject(), msgMap);
		MsgIfVo message = new MsgIfVo();
		String timTalk = null;
		timTalk = getTimeString(code.getTalkSendTime());
		String codeCd = code.getComnCd();
		// DATETIME_FORMAT.format(dt)
		message.setSenderKey(code.getSendProfileKey());
		message.setSendresult("K");
		message.setRevId(itgCustNo);
		message.setDestel(mphoneNo);
		message.setClient("CRM");
		message.setDummy10(itgCustNo);
		message.setDummy9(codeCd);
		message.setCampaignId(Utilities.getDateTimeString() + Utilities.getUniqNumberID(6));
		message.setMemberSeq("1");
		message.setSubject(subject);
		message.setKTitle(subject);
		message.setMsg(msg);
		message.setEtc3(eonUser);
		message.setTemplateCode(code.getTalkTemplateId());
		message.setKMsg(msg);
		message.setKReservetime(timTalk);
		message.setKErrIssend("Y");
		message.setMsgType("AT");
		message.setSendType("2");
		message.setKkoBtnInfo(code.getBtnTemplate());
		message.setKkoBtnType("2");
		return message;
	}

}
