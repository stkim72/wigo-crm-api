package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmAcqieHstDao;
import com.ceragem.api.crm.dao.CrmCustBasDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmAcqieHstVo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

/**
 * 
 * @ClassName CrmAcqieHstService
 * @author 김성태
 * @date 2022. 8. 17.
 * @Version 1.0
 * @description CRM지인이력 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmAcqieHstService extends AbstractCrmService {

	public final static String ERROR_CODE_NO_USER = "IAR0501";
	public final static String ERROR_CODE_NO_USER_MSG = "등록된 사용자가 아닙니다.";

	public final static String ERROR_CODE_NO_MEMBERSHIP = "IAR0502";
	public final static String ERROR_CODE_NO_MEMBERSHIP_MSG = "멤버십 회원이 아닙니다.";

	@Autowired
	CrmAcqieHstDao dao;

	@Autowired
	CrmCustBasDao custDao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	@Override
	public int insert(Object param) throws Exception {
		CrmAcqieHstVo vo = Utilities.beanToBean(param, CrmAcqieHstVo.class);
		EzMap so = new EzMap();
		so.setString("itgCustNo", vo.getItgCustNo());
		CrmCustVo cust = custDao.selectBasic(so);
		if (cust == null || "003".equals(cust.getCustStatusCd())) {
			throw new EzApiException(ERROR_CODE_NO_USER, "[" + vo.getItgCustNo() + "]" + ERROR_CODE_NO_USER_MSG);
		}
		if (!"Y".equals(cust.getMshipSbscYn())) {
			throw new EzApiException(ERROR_CODE_NO_MEMBERSHIP,
					"[" + vo.getItgCustNo() + "][" + cust.getCustNm() + "]" + ERROR_CODE_NO_MEMBERSHIP_MSG);
		}

		so.setString("itgCustNo", vo.getAcqieItgCustNo());
		cust = custDao.selectBasic(so);
		if (cust == null || "003".equals(cust.getCustStatusCd())) {
			throw new EzApiException(ERROR_CODE_NO_USER, "[" + vo.getAcqieItgCustNo() + "]" + ERROR_CODE_NO_USER_MSG);
		}
		if (!"Y".equals(cust.getMshipSbscYn())) {
			throw new EzApiException(ERROR_CODE_NO_MEMBERSHIP,
					"[" + vo.getAcqieItgCustNo() + "][" + cust.getCustNm() + "]" + ERROR_CODE_NO_MEMBERSHIP_MSG);
		}
		return super.insert(param);
	}
}
