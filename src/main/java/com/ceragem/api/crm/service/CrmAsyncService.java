package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ceragem.api.crm.controller.CrmMembershipController;
import com.ceragem.api.crm.model.CrmCustVo;

//@Slf4j
@Service
public class CrmAsyncService {
	private final int delay = 500;

	@Autowired
	CrmCustService custService;

	@Autowired
	EonMessageService eonService;

	@Autowired
	CrmMembershipController mCon;

	@Async
	public void getEventChk(CrmCustVo custVo) throws Exception {
		if ("Y".equals(custVo.getMshipSbscYn())) {
			Thread.sleep(delay);
			mCon.event(custVo.getItgCustNo(), custVo.getEventCd(), custVo.getRegChlCd(), custVo.getRcmdrCustNo());
//			custService.getEventChk(custVo);
		}
	}

//	@Async
//	public void saveRcmdHst(CrmCustVo custVo) throws Exception {
//		if ("Y".equals(custVo.getMshipSbscYn())) {
//			custService.saveRcmdHst(custVo);
//		}
//	}

	@Async
	public void sendPointMessage(String itgCustNo, int pt, String codeCd, String storNo, boolean reserve)
			throws Exception {
		Thread.sleep(delay);
		eonService.sendPointMessage(itgCustNo, pt, codeCd, storNo, reserve);
	}

	@Async
	public void sendAgreeMessage(String itgCustNo, String codeCd) throws Exception {
		Thread.sleep(delay);
		eonService.sendAgreeMessage(itgCustNo, codeCd);
	}

	@Async
	public void sendCustStatusMessage(String itgCustNo, String codeCd) throws Exception {
		Thread.sleep(delay);
		eonService.sendCustStatusMessage(itgCustNo, codeCd);

	}

	@Async
	public void sendCustmerApiEvent(String itgCustNo, String code, String exceptCh) throws Exception {
		Thread.sleep(delay);
		custService.sendCustmerApiEvent(itgCustNo, code, exceptCh);
	}
}
