package com.ceragem.api.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmSnstvInfoInqryHstDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCustCntplcBasVo;
import com.ceragem.api.crm.model.CrmCustHshldBasVo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmSnstvInfoInqryHstVo;

/**
 * 
 * @ClassName CrmSnstvInfoInqryHstService
 * @author 김성태
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM민감정보조회이력 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmSnstvInfoInqryHstService extends AbstractCrmService {
	@Autowired
	CrmSnstvInfoInqryHstDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public CrmSnstvInfoInqryHstVo getHistVo(Object param) {
		CrmSnstvInfoInqryHstVo vo = Utilities.beanToBean(param, CrmSnstvInfoInqryHstVo.class);
		vo.setRegChlCd(Utilities.getSystemCd());
		return vo;
	}

	private boolean canDecrypt(CrmSnstvInfoInqryHstVo vo) {
		if (vo == null)
			return false;
		if (vo.isForceDecrypt())
			return true;
		return Utilities.isNotEmpty(vo.getIndiInfoHandlPrsnNo()) && Utilities.isNotEmpty(vo.getConnPrsnIpAddr());
	}

//	private boolean needDecrypt(CrmCustCntplcBasVo vo) {
//		if (vo == null)
//			return false;
//		return true;
//	}

//	private boolean needDecrypt(CrmCustHshldBasVo vo) {
//		if (vo == null)
//			return false;
//		return Utilities.isNotEmpty(vo.getMphonNoEncVal());
//	}
//
//	private boolean needDecrypt(CrmCustVo vo) {
//		if (vo == null)
//			return false;
//		return true;
//	}

	public List<? extends CrmCustVo> decryptCust(Object param, List<? extends CrmCustVo> list) {
		if (Utilities.isEmpty(list))
			return list;
		try {
			CrmSnstvInfoInqryHstVo logVo = getHistVo(param);
			logVo.setListMode(true);
			if (Utilities.isEmpty(logVo.getDnldTxn()))
				logVo.setPfmWorkCd("002");
			else
				logVo.setPfmWorkCd("003");
			if (!canDecrypt(logVo))
				return list;
			StringBuffer bf = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				CrmCustVo vo = list.get(i);
				if (i > 0)
					bf.append(",");
				else
					logVo.setItgCustNo(vo.getItgCustNo());
				bf.append(vo.getItgCustNo());
				decrypt(logVo, vo);
			}
			if (Utilities.isNotEmpty(logVo)) {
				logVo.setInqryCnt(list.size());
				if (logVo.getInqryCnt() > 1) {
					logVo.setInqryTxn(bf.toString());
				}
				addLog(logVo);
			}

			return list;
		} catch (Exception ex) {
			return list;
		}

	}

	public List<CrmCustHshldBasVo> decryptHshld(Object param, List<CrmCustHshldBasVo> list) {
		if (Utilities.isEmpty(list))
			return list;
		try {
			CrmSnstvInfoInqryHstVo logVo = getHistVo(param);
			if (!canDecrypt(logVo))
				return list;
			logVo.setListMode(true);
			logVo.setPfmWorkCd("002");
			StringBuffer bf = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				CrmCustHshldBasVo vo = list.get(i);
				if (i > 0)
					bf.append(",");
				bf.append(vo.getItgCustNo());
				decrypt(logVo, vo);
			}
			if (Utilities.isNotEmpty(logVo)) {
				logVo.setInqryCnt(list.size());
				if (logVo.getInqryCnt() > 1) {
					logVo.setInqryTxn(bf.toString());
				}
				addLog(logVo);
			}

			return list;
		} catch (Exception ex) {
			return list;
		}

	}

	public List<CrmCustCntplcBasVo> decryptCntplc(Object param, List<CrmCustCntplcBasVo> list) {
		if (Utilities.isEmpty(list))
			return list;
		try {
			CrmSnstvInfoInqryHstVo logVo = getHistVo(param);
			if (!canDecrypt(logVo))
				return list;
			logVo.setListMode(true);
			logVo.setPfmWorkCd("002");
			StringBuffer bf = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				CrmCustCntplcBasVo vo = list.get(i);
				if (i > 0)
					bf.append(",");
				bf.append(vo.getItgCustNo());
				decrypt(logVo, vo);
			}
			if (Utilities.isNotEmpty(logVo)) {
				logVo.setInqryCnt(list.size());
				if (logVo.getInqryCnt() > 1) {
					logVo.setInqryTxn(bf.toString());
				}
				addLog(logVo);
			}

			return list;
		} catch (Exception ex) {
			return list;
		}

	}

	public CrmCustVo decryptCust(Object param, CrmCustVo vo) {
		CrmSnstvInfoInqryHstVo so = getHistVo(param);
		return decrypt(so, vo);
	}

	public boolean canDecrypt(Object vo) {
		if (vo == null)
			return false;
		CrmSnstvInfoInqryHstVo so = getHistVo(vo);
		return canDecrypt(so);
	}

	public int addLog(CrmSnstvInfoInqryHstVo vo) {
		try {
			if (vo != null)
				vo.setRegChlCdNm(Utilities.getSystemCd());
			if (!vo.isForceDecrypt())
				return insert(vo);
			else
				return 0;
		} catch (Exception e) {
			return 0;
		}

	}

	public CrmCustVo decrypt(CrmSnstvInfoInqryHstVo so, CrmCustVo vo) {
		try {
//			if (!canDecrypt(so))
//				return vo;
//			if (!needDecrypt(vo))
//				return vo;
//			decrypt(vo);
//			so.setItgCustNo(vo.getItgCustNo());
//			so.setRegChlCd(vo.getRegChlCd());
//			if (!so.isListMode()) {
//				so.setPfmWorkCd("001");
//				addLog(so);
//			}
			return vo;
		} catch (Exception ex) {
			return vo;
		}
	}

	public CrmCustHshldBasVo decrypt(CrmSnstvInfoInqryHstVo so, CrmCustHshldBasVo vo) {
		try {
//			if (!canDecrypt(so))
//				return vo;
//			if (!needDecrypt(vo))
//				return vo;
//
//			decrypt(vo);
//			so.setItgCustNo(vo.getItgCustNo());
//			so.setRegChlCd(vo.getRegChlCd());
//			if (!so.isListMode()) {
//				so.setPfmWorkCd("001");
//				addLog(so);
//			}
			return vo;
		} catch (Exception ex) {
			return vo;
		}
	}

	public CrmCustCntplcBasVo decrypt(CrmSnstvInfoInqryHstVo so, CrmCustCntplcBasVo vo) {
		try {
//			if (!canDecrypt(so))
//				return vo;
//			if (!needDecrypt(vo))
//				return vo;
//			decrypt(vo);
//			so.setItgCustNo(vo.getItgCustNo());
//			so.setRegChlCd(vo.getRegChlCd());
//			if (!so.isListMode()) {
//				so.setPfmWorkCd("001");
//				addLog(so);
//			}
			return vo;
		} catch (Exception ex) {
			return vo;
		}
	}

	public CrmCustHshldBasVo decrypt(CrmCustHshldBasVo vo) {
//		try {
//			if (Utilities.isNotEmpty(vo.getMphonNoEncVal())) {
//				vo.setMphonNo(Utilities.decrypt(vo.getMphonNoEncVal()));
//			}
//			return vo;
//		} catch (Exception e) {
//			return vo;
//		}
		return vo;
	}

	public CrmCustVo decrypt(CrmCustVo vo) {
//		try {
//			if (Utilities.isNotEmpty(vo.getMphonNoEncVal())) {
//				vo.setMphonNo(Utilities.decrypt(vo.getMphonNoEncVal()));
//			}
//			if (Utilities.isNotEmpty(vo.getAddr2Ctnts())) {
//				vo.setAddr2Ctnts(Utilities.decrypt(vo.getAddr2Ctnts()));
//			}
//
//			if (Utilities.isNotEmpty(vo.getInstTelNoEncVal())) {
//				vo.setInstTelNo(Utilities.decrypt(vo.getInstTelNoEncVal()));
//			}
//
//			if (Utilities.isNotEmpty(vo.getInstAddr2())) {
//				vo.setInstAddr2(Utilities.decrypt(vo.getInstAddr2()));
//			}
//
//			if (Utilities.isNotEmpty(vo.getJobTelNoEncVal())) {
//				vo.setJobTelNo(Utilities.decrypt(vo.getJobTelNoEncVal()));
//			}
//
//			if (Utilities.isNotEmpty(vo.getJobAddr2())) {
//				vo.setJobAddr2(Utilities.decrypt(vo.getJobAddr2()));
//			}
//
//			if (Utilities.isNotEmpty(vo.getHomeTelNoEncVal())) {
//				vo.setHomeTelNo(Utilities.decrypt(vo.getHomeTelNoEncVal()));
//			}
//			if (Utilities.isNotEmpty(vo.getHomeAddr2())) {
//				vo.setHomeAddr2(Utilities.decrypt(vo.getHomeAddr2()));
//			}
//
//			if (Utilities.isNotEmpty(vo.getCorpTelNo())) {
//				vo.setCorpTelNo(Utilities.decrypt(vo.getCorpTelNo()));
//			}
//			if (Utilities.isNotEmpty(vo.getEmailAddr())) {
//				vo.setEmailAddr(Utilities.decrypt(vo.getEmailAddr()));
//			}
//			if (Utilities.isNotEmpty(vo.getPicMphonNo())) {
//				vo.setPicMphonNo(Utilities.decrypt(vo.getPicMphonNo()));
//			}
//			if (Utilities.isNotEmpty(vo.getPicEmailAddr())) {
//				vo.setPicEmailAddr(Utilities.decrypt(vo.getPicEmailAddr()));
//			}
//
//			List<CrmCustCntplcBasVo> cntplcList = vo.getCntplcList();
//			for (int i = 0; cntplcList != null && i < cntplcList.size(); i++) {
//				CrmCustCntplcBasVo cnt = cntplcList.get(i);
//				decrypt(cnt);
//			}
//			return vo;
//		} catch (Exception ex) {
//			return vo;
//		}
		return vo;
	}

	public CrmCustCntplcBasVo decrypt(CrmCustCntplcBasVo vo) {
		try {
			if (Utilities.isNotEmpty(vo.getTelNo())) {
				vo.setTelNo(Utilities.decrypt(vo.getTelNo()));
			}
			if (Utilities.isNotEmpty(vo.getAddr2Ctnts())) {
				vo.setAddr2Ctnts(Utilities.decrypt(vo.getAddr2Ctnts()));
			}
			if (Utilities.isNotEmpty(vo.getEmailAddr())) {
				vo.setEmailAddr(Utilities.decrypt(vo.getEmailAddr()));
			}

			return vo;
		} catch (Exception ex) {
			return vo;
		}
	}

	public List<CrmCustVo> encryptCust(List<CrmCustVo> list) {
		for (int i = 0; i < list.size(); i++) {
			encrypt(list.get(i));
		}
		return list;

	}

	public CrmCustVo encrypt(CrmCustVo vo) {
//		try {
//			if (Utilities.isNotEmpty(vo.getMphonNo())) {
//				String m = vo.getMphonNo();
//				vo.setMphonNoEncVal(Utilities.encrypt(m));
//				vo.setMphonNo(null);
//				String b = m.length() >= 4 ? m.substring(m.length() - 4) : m;
//				vo.setMphonBkDgtNo(b);
//
//			} else {
//				vo.setMphonBkDgtNo(null);
//			}
//			String pwd = vo.getMshipLoginPwd();
//			if (Utilities.isNotEmpty(pwd)) {
//				vo.setMshipLoginPwd(Utilities.passwordEncode(pwd));
//			}
//		} catch (Exception ex) {
//			return vo;
//		}

		return vo;

	}

	public CrmCustCntplcBasVo encrypt(CrmCustCntplcBasVo vo) {
//		try {
//			if (Utilities.isNotEmpty(vo.getTelNo())) {
//				String m = vo.getTelNo();
//				vo.setTelNo(Utilities.encrypt(m));
//				String b = m.length() >= 4 ? m.substring(m.length() - 4) : m;
//				vo.setTelBkDgtNo(b);
//			} else {
//				vo.setTelBkDgtNo(null);
//			}
//		} catch (Exception ex) {
//			return vo;
//		}
//
		return vo;

	}

	public Object encrypt(Object param) {
//		if (param instanceof CrmCustCntplcBasVo)
//			return encrypt((CrmCustCntplcBasVo) param);
//		else if (param instanceof CrmCustVo)
//			return encrypt((CrmCustVo) param);
		return param;

	}

}
