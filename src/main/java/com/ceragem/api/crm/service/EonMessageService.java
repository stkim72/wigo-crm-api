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
 * @author κΉμ±ν
 * @date 2022. 8. 9.
 * @Version 1.0
 * @description
 * @Company Copyright β wigo.ai. All Right Reserved
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
		msgMap.put("νμλͺ", cust.getCustNm());
		msgMap.put("κ³ κ°λͺ", cust.getCustNm());
		msgMap.put("μ λ¦½μΌμ", pointDay);

		msgMap.put("μ λ¦½μΌμ", pointDay);
		msgMap.put("μ¬μ©μΌμ", pointDay);
		msgMap.put("μ·¨μμΌμ", pointDay);
		msgMap.put("μ λ¦½ν¬μΈνΈ", strOPoint);
		msgMap.put("μ¬μ©ν¬μΈνΈ", strOPoint);
		msgMap.put("μ°¨κ°ν¬μΈνΈ", strOPoint);
		msgMap.put("μ·¨μν¬μΈνΈ", strOPoint);
		msgMap.put("μμ¬ν¬μΈνΈ", strTPoint);
		msgMap.put("storNm", storeNm);
		msgMap.put("μ¬μ©μ²", storeNm);

		MsgIfVo message = getMessage(code, itgCustNo, cust.getMphonNo(), msgMap);
		message.setCampaignId(null);
		return sendMessage(message);
	}
	

	
	// κ΅¬λ§€μΆμ² μΆκ°
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
		msgMap.put("μΆμ²μΈ", cust.getCustNm());
		msgMap.put("νΌμΆμ²μΈ", rcmdrCustNm);
		msgMap.put("λ³΄μν¬μΈνΈ", strOPoint );


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

		String statusNm = "Y".equals(cust.getMarketingAgreeYn()) ? "μμ λμ" : "μμ κ±°λΆ";
		// cust
		msgMap.put("custNm", cust.getCustNm());
		msgMap.put("νμλͺ", cust.getCustNm());
		msgMap.put("κ³ κ°λͺ", cust.getCustNm());
		msgMap.put("agreeDay", agreeDay);
		msgMap.put("λ³κ²½μΌ", agreeDay);
		msgMap.put("κ΄κ³ μ± μμ  μ λ³΄ λμμΌ", agreeDay);
		msgMap.put("κ΄κ³ μ± μ λ³΄ μμ  μ² νμΌ", agreeDay);

		msgMap.put("λ³κ²½μν", statusNm);
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
		msgMap.put("κ³ κ°λ", cust.getCustNm());
		msgMap.put("νμλͺ", cust.getCustNm());
		msgMap.put("κ³ κ°λͺ", cust.getCustNm());
		msgMap.put("νμλͺ", cust.getCustNm());
		
		msgMap.put("νΈλν°λ²νΈ", Utilities.getPhoneNumberFormat(cust.getMphonNo()));
		msgMap.put("ν΄λ©΄μ²λ¦¬μΌμ", procDt);
		msgMap.put("νν΄μ²λ¦¬μΌμ", procDt);
		msgMap.put("κ°μμΌμ", cust.getMshipSbscDt());
		msgMap.put("λΉνλκΈ°κ°", cust.getDormPerdCd());
		msgMap.put("λΉνλ κΈ°κ°", cust.getDormPerdCd());

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
