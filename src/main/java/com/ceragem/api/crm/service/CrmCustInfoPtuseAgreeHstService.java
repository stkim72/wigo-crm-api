package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmCustBasDao;
import com.ceragem.api.crm.dao.CrmCustInfoPtuseAgreeHstDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmAgreementVo;
import com.ceragem.api.crm.model.CrmCustInfoChngHstVo;
import com.ceragem.api.crm.model.CrmCustInfoPtuseAgreeHstVo;
import com.ceragem.api.crm.model.CrmCustSo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.crm.common.model.EzApiException;

/**
 * 
 * @ClassName CrmCustInfoPtuseAgreeHstService
 * @author 김성태
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM고객정보활용동의이력 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustInfoPtuseAgreeHstService extends AbstractCrmService {
	@Autowired
	CrmCustInfoPtuseAgreeHstDao dao;

	@Autowired
	CrmCustBasDao custDao;

	@Autowired
	CrmCustService custService;

	@Autowired
	EonMessageService messageService;

	@Autowired
	CrmCustInfoChngHstService infoService;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public CrmCustVo updateAgreement(CrmAgreementVo vo) throws Exception {
		if (vo == null)
			return null;
		int updated = 0;
		CrmCustSo so = new CrmCustSo();
		so.setItgCustNo(vo.getItgCustNo());
		CrmCustVo cust = custDao.select(so);
		if (cust == null || Constants._USER_STATUS_DELETE.equals(cust.getCustStatusCd()))
			throw new EzApiException(Constants._API_CODE_NO_USER, Constants._API_CODE_NO_USER_MSG);
		if (Utilities.isNotEmpty(vo.getTermYn())) {
			CrmCustInfoPtuseAgreeHstVo agree = new CrmCustInfoPtuseAgreeHstVo();
			agree.setItgCustNo(vo.getItgCustNo());
			agree.setAgreeYn(vo.getTermYn());
			agree.setAgreeTypeCd("001");
			agree.setRegChlCd(vo.getRegChlCd());
			agree.setRegrId(vo.getRegrId());
			agree.setAmdrId(vo.getAmdrId());
			updated += insert(agree);
		}
		if (Utilities.isNotEmpty(vo.getCollectYn())) {
			CrmCustInfoPtuseAgreeHstVo agree = new CrmCustInfoPtuseAgreeHstVo();
			agree.setItgCustNo(vo.getItgCustNo());
			agree.setAgreeYn(vo.getCollectYn());
			agree.setAgreeTypeCd("002");
			agree.setRegChlCd(vo.getRegChlCd());
			agree.setRegrId(vo.getRegrId());
			agree.setAmdrId(vo.getAmdrId());
			updated += insert(agree);
		}
		if (Utilities.isNotEmpty(vo.getMarketingYn())) {
			CrmCustInfoPtuseAgreeHstVo agree = new CrmCustInfoPtuseAgreeHstVo();

			String yn = cust.getMarketingAgreeYn();
			String ch = vo.getRegChlCd();
			if (Utilities.isEmpty(ch))
				ch = Utilities.getSystemCd();

			agree.setItgCustNo(vo.getItgCustNo());
			agree.setAgreeYn(vo.getMarketingYn());
			agree.setAgreeTypeCd("003");
			agree.setRegChlCd(vo.getRegChlCd());
			agree.setRegrId(vo.getRegrId());
			agree.setAmdrId(vo.getAmdrId());
			updated += insert(agree);
			boolean sendTalk = false;
			if ("N".equals(vo.getMarketingYn())) {
				sendTalk = "Y".equals(yn);
			} else {
				String dt = cust.getMarketingAgreeDt();
				sendTalk = !("Y".equals(yn) && ch.equals(cust.getMarketingAgreeChlCd()) && Utilities.isNotEmpty(dt)
						&& Utilities.getDateString().equals(dt.substring(0, 8)));

			}
			String codeCd = "Y".equals(vo.getMarketingYn()) ? "320" : "310";
			if (sendTalk)
				messageService.sendAsyncAgreeMessage(vo.getItgCustNo(), codeCd);

		}
		if (Utilities.isNotEmpty(vo.getThirdYn())) {
			CrmCustInfoPtuseAgreeHstVo agree = new CrmCustInfoPtuseAgreeHstVo();
			agree.setItgCustNo(vo.getItgCustNo());
			agree.setAgreeYn(vo.getThirdYn());
			agree.setAgreeTypeCd("004");
			agree.setRegChlCd(vo.getRegChlCd());
			agree.setRegrId(vo.getRegrId());
			agree.setAmdrId(vo.getAmdrId());
			updated += insert(agree);
		}
		if (Utilities.isNotEmpty(vo.getInfoAgreeYn())) {
			CrmCustInfoPtuseAgreeHstVo agree = new CrmCustInfoPtuseAgreeHstVo();
			agree.setItgCustNo(vo.getItgCustNo());
			agree.setAgreeYn(vo.getInfoAgreeYn());
			agree.setAgreeTypeCd("005");
			agree.setRegChlCd(vo.getRegChlCd());
			agree.setRegrId(vo.getRegrId());
			agree.setAmdrId(vo.getAmdrId());
			updated += insert(agree);
		}

		if (Utilities.isNotEmpty(vo.getSmsRcvAgreeYn())) {
			CrmCustInfoPtuseAgreeHstVo agree = new CrmCustInfoPtuseAgreeHstVo();
			agree.setItgCustNo(vo.getItgCustNo());
			agree.setAgreeYn(vo.getSmsRcvAgreeYn());
			agree.setAgreeTypeCd("006");
			agree.setRegChlCd(vo.getRegChlCd());
			agree.setRegrId(vo.getRegrId());
			agree.setAmdrId(vo.getAmdrId());
			addChangeLog(agree);
			updated += insert(agree);

		}
		if (Utilities.isNotEmpty(vo.getEmailRcvAgreeYn())) {
			CrmCustInfoPtuseAgreeHstVo agree = new CrmCustInfoPtuseAgreeHstVo();
			agree.setItgCustNo(vo.getItgCustNo());
			agree.setAgreeYn(vo.getEmailRcvAgreeYn());
			agree.setAgreeTypeCd("007");
			agree.setRegChlCd(vo.getRegChlCd());
			agree.setRegrId(vo.getRegrId());
			agree.setAmdrId(vo.getAmdrId());
			addChangeLog(agree);
			updated += insert(agree);
		}

		if (Utilities.isNotEmpty(vo.getPushRcvAgreeYn())) {
			CrmCustInfoPtuseAgreeHstVo agree = new CrmCustInfoPtuseAgreeHstVo();
			agree.setItgCustNo(vo.getItgCustNo());
			agree.setAgreeYn(vo.getPushRcvAgreeYn());
			agree.setAgreeTypeCd("008");
			agree.setRegChlCd(vo.getRegChlCd());
			agree.setRegrId(vo.getRegrId());
			agree.setAmdrId(vo.getAmdrId());
			addChangeLog(agree);
			updated += insert(agree);
		}
		if(updated>0)
			dao.updateCustAgreement(vo);
		return custDao.select(so);
	}

	public int addChangeLog(CrmCustInfoPtuseAgreeHstVo vo) throws Exception {
		CrmCustInfoPtuseAgreeHstVo old = dao.selectChangeInfo(vo);
		if (old != null) {
			CrmCustInfoChngHstVo hist = new CrmCustInfoChngHstVo();
			hist.setItgCustNo(vo.getItgCustNo());
			hist.setChngWhyCtnts("동의내역변경");
			hist.setChngClusCtnts(old.getAgreeTypeCdNm());
			hist.setChngPreCtnts(old.getAgreeYn());
			hist.setChngCtnts(vo.getAgreeYn());
			hist.setRegChlCd(vo.getRegChlCd());
			hist.setRegrId(vo.getRegrId());
			hist.setAmdrId(vo.getAmdrId());
			return infoService.insert(hist);
		}
		return 0;

	}

}
