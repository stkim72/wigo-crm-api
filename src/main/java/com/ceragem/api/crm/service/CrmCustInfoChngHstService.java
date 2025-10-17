package com.ceragem.api.crm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmCustBasDao;
import com.ceragem.api.crm.dao.CrmCustInfoChngHstDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCustInfoChngHstVo;
import com.ceragem.api.crm.model.CrmCustSo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.crm.common.model.EzApiException;

/**
 * 
 * @ClassName CrmCustInfoChngHstService
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM고객정보변경이력 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustInfoChngHstService extends AbstractCrmService {
	private static final Map<String, String> FIELD_MAP = new HashMap<>();

	static {
		FIELD_MAP.put("custNm", "고객명");
		FIELD_MAP.put("gndrCd", "성별");
		FIELD_MAP.put("birthday", "생년월일");
		FIELD_MAP.put("fornYn", "외국인여부");
		FIELD_MAP.put("mphonNo", "이동전화번호");
		FIELD_MAP.put("emailAddr", "이메일");
//		FIELD_MAP.put("custStatusCd", "회원상태");
//		FIELD_MAP.put("custTypeCd", "회원유형");
		FIELD_MAP.put("zipCd", "우편번호");
		FIELD_MAP.put("addr1Ctnts", "회원주소1");
		FIELD_MAP.put("addr2Ctnts", "회원주소2");
		FIELD_MAP.put("rcmdStorNo", "추천매장");
		FIELD_MAP.put("rcmdrCustNo", "추천인");
		FIELD_MAP.put("marryYn", "결혼여부");
		FIELD_MAP.put("homeTelNo", "재택전화번호");
		FIELD_MAP.put("jobTelNo", "직장전화번호");
		FIELD_MAP.put("instZipCd", "설치지 우편번호");
		FIELD_MAP.put("instAddr1", "설치지 주소1");
		FIELD_MAP.put("instAddr2", "설치지 주소2");
//		FIELD_MAP.put("repHshldNo", "대표가족");
//		FIELD_MAP.put("smsRcvAgreeYn", "sms동의여부");
//		FIELD_MAP.put("smsRcvAgreeChlCd", "sms동의채널");
//		FIELD_MAP.put("emailRcvAgreeYn", "이메일동의여부");
//		FIELD_MAP.put("emailRcvAgreeChlCd", "이메일동의채널");
//		FIELD_MAP.put("alrmTkRcvAgreeChlCd", "알림수신동의채널");
//		FIELD_MAP.put("pushRcvAgreeYn", "푸시동의여부");
//		FIELD_MAP.put("pushRcvAgreeChlCd", "푸시동의채널");
		FIELD_MAP.put("ci", "ci");
		FIELD_MAP.put("mshipLoginPwd", "로그인암호");
//		FIELD_MAP.put("mshipTypeCd", "멤버십유형");
//		FIELD_MAP.put("mshipGradeCd", "멤버십등급");
//		FIELD_MAP.put("mshipInfoConfrExecvdempNo", "멤버십확인자");
//		FIELD_MAP.put("cprtExecvdempNo", "제휴임직원");
//		FIELD_MAP.put("mshipChlCd", "멤버십채널");
//		FIELD_MAP.put("regChlCd", "등록채널");

	}
	@Autowired
	CrmCustInfoChngHstDao dao;

	@Autowired
	CrmCustBasDao custDao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public List<CrmCustInfoChngHstVo> getChangeInfoList(String itgCustNo, String chngWhyCtnts, Object param,
			String indiInfoHandlPrsnNo) throws Exception {
		CrmCustVo custVo = null;
		Object srcVo = null;
		Object destVo = null;
		if (param == null) {
			// 입력
			CrmCustSo so = new CrmCustSo();
			so.setForceDecrypt(true);
			so.setItgCustNo(itgCustNo);
			custVo = custDao.select(so);
			srcVo = null;
			destVo = custVo;
		} else {
			// 수정
			CrmCustVo so = Utilities.beanToBean(param, CrmCustVo.class);
			so.setDecryptYn("Y");
			custVo = custDao.select(so);
			if (custVo == null)
				return null;
			if (Constants._USER_STATUS_DORMANT.equals(custVo.getCustStatusCd()))
				throw new EzApiException(Constants._API_CODE_NO_DORMANT, Constants._API_CODE_NO_DORMANT_MSG);
			srcVo = custVo;
			destVo = param;
		}
		if (custVo == null)
			return null;
		Map<String, Object> src = srcVo == null ? new HashMap<String, Object>() : Utilities.beanToMap(srcVo);
		Map<String, Object> dest = Utilities.beanToMap(destVo);
		List<CrmCustInfoChngHstVo> list = new ArrayList<>();
		for (Map.Entry<String, String> entry : FIELD_MAP.entrySet()) {
			String field = entry.getKey();
			String fieldName = entry.getValue();
			Object srcVal = src.get(field);
			Object destVal = dest.get(field);
			CrmCustInfoChngHstVo vo = getHistVo(itgCustNo, chngWhyCtnts, field, fieldName, srcVal, destVal,
					indiInfoHandlPrsnNo);
			if (vo != null)
				list.add(vo);

		}
		return list;
	}

	public CrmCustInfoChngHstVo getHistVo(String itgCustNo, String chngWhyCtnts, String field, String fieldName,
			Object srcVal, Object destVal, String indiInfoHandlPrsnNo) {
		CrmCustInfoChngHstVo vo = null;
		String fName = fieldName;

		if (Utilities.isEmpty(field))
			return null;
		if (Utilities.isEmpty(fieldName))
			fName = FIELD_MAP.get(field);
		if (Utilities.isEmpty(fName))
			return null;
		if ("ci".equals(field) && (Utilities.isNotEmpty(srcVal) || Utilities.isEmpty(destVal)))
			return null;

		if ("gndrCd".equals(field) && (Utilities.isEmpty(destVal)))
			return null;

		if ("birthday".equals(field) && (Utilities.isEmpty(destVal)))
			return null;

		if (Utilities.isEmpty(srcVal) && Utilities.isEmpty(destVal))
			return null;
		vo = new CrmCustInfoChngHstVo();
		vo.setItgCustNo(itgCustNo);
		vo.setChngClusCtnts(fName);
		vo.setChngWhyCtnts(chngWhyCtnts);
		vo.setRegrId(indiInfoHandlPrsnNo);
		vo.setAmdrId(indiInfoHandlPrsnNo);

		if (Utilities.isEmpty(srcVal))
			vo.setChngPreCtnts("");
		else
			vo.setChngPreCtnts(srcVal + "");
		if (Utilities.isEmpty(destVal))
			vo.setChngCtnts("");
		else
			vo.setChngCtnts(destVal + "");

		if (!vo.getChngCtnts().equals(vo.getChngPreCtnts()))
			return vo;
		return null;
	}
}
