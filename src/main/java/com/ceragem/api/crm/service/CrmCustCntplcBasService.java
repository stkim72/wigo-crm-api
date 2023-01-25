package com.ceragem.api.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmCustCntplcBasDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCustCntplcBasSo;
import com.ceragem.api.crm.model.CrmCustCntplcBasVo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.crm.common.model.EzApiException;

/**
 * 
 * @ClassName CrmCustCntplcBasService
 * @author 김성태
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM고객연락처기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustCntplcBasService extends AbstractCrmService {

	public final static String PHONE_TYPE_MOBILE = "004";
	public final static String API_CODE_CANNOT_DELETE = "IAR0501";
	public final static String API_CODE_CANNOT_DELETE_MSG = "대표 연락처는 삭제 할 수 없습니다.";
	public final static String API_CODE_CANNOT_UPDATE = "IAR0502";
	public final static String API_CODE_CANNOT_UPDATE_MSG = "대표 연락처는 일반 연락처로 변경 할 수 없습니다.";
	@Autowired
	CrmSnstvInfoInqryHstService inqHstService;

	@Autowired
	CrmCustService custService;

	@Autowired
	CrmCustCntplcBasDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCustCntplcBasVo> getList(Object param) throws Exception {

		List<CrmCustCntplcBasVo> list = super.getList(param);
		inqHstService.decryptCntplc(param, list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCustCntplcBasVo get(Object param) throws Exception {
		CrmCustCntplcBasVo vo = super.get(param);
		if (vo == null)
			return vo;
		return inqHstService.decrypt(inqHstService.getHistVo(param), vo);
	}

	@Override
	public int insert(Object param) throws Exception {

		inqHstService.encrypt(param);
		int ret = super.insert(param);

		if (param instanceof CrmCustCntplcBasVo) {
			CrmCustCntplcBasVo vo = (CrmCustCntplcBasVo) param;
			if ("Y".equals(vo.getRepCntplcYn())) {
				dao.updateRepCntplc(param);
//				if (PHONE_TYPE_MOBILE.equals(vo.getCntplcTypeCd()))
//					custService.updateRepCntplcPhone(vo);
//				else
				custService.updateRepCntplc(vo);

			}
		}
		return ret;

	}

	@Override
	public int update(Object param) throws Exception {
		CrmCustCntplcBasVo vo = null;
		inqHstService.encrypt(param);
		CrmCustCntplcBasVo old = get(param);
		if (param instanceof CrmCustCntplcBasVo)
			vo = (CrmCustCntplcBasVo) param;
		if (old == null)
			return 0;
//			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		if (vo != null && "Y".equals(old.getRepCntplcYn()) && "N".equals(vo.getRepCntplcYn()))
			return 0;
//			throw new EzApiException(API_CODE_CANNOT_UPDATE, API_CODE_CANNOT_UPDATE_MSG);
		int ret = super.update(param);
		if (vo != null && "Y".equals(vo.getRepCntplcYn())) {

			dao.updateRepCntplc(param);
			if (PHONE_TYPE_MOBILE.equals(vo.getCntplcTypeCd()))
//				custService.updateRepCntplcPhone(vo);
//			else
				custService.updateRepCntplc(vo);

		}
		return ret;
	}

	public int updateRepCntplc(CrmCustCntplcBasVo rVo) throws Exception {
		return dao.updateRepCntplc(rVo);

	}

	public CrmCustCntplcBasVo updateLastInfo(CrmCustVo vo) throws Exception {
		if (vo == null || Utilities.isEmpty(vo.getMphonNo()))
			return null;
		CrmCustCntplcBasSo so = new CrmCustCntplcBasSo();
		so.setItgCustNo(vo.getItgCustNo());
//		so.setTelNoEncVal(vo.getMphonNoEncVal());
		so.setDelYn("N");
		List<CrmCustCntplcBasVo> list = getList(so);
		CrmCustCntplcBasVo rVo = null;
		CrmCustCntplcBasVo aVo = null;
		if (Utilities.isNotEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				CrmCustCntplcBasVo cVo = list.get(i);
				if ("Y".equals(cVo.getRepCntplcYn())) {
					aVo = cVo;
				}
				if (vo.getMphonNo().equals(cVo.getTelNo())) {
					rVo = cVo;
				}
			}
			if (rVo == null) {
				if (aVo == null) {
					aVo = list.get(0);
				}
				rVo = aVo;
				rVo.setTelNo(vo.getMphonNo());
				rVo.setTelBkDgtNo(vo.getMphonBkDgtNo());
				rVo.setEmailAddr(vo.getEmailAddr());
				rVo.setDistrctCd(vo.getDistrctCd());
				rVo.setZipCd(vo.getZipCd());
				rVo.setAddr1Ctnts(vo.getAddr1Ctnts());
				rVo.setAddr2Ctnts(vo.getAddr2Ctnts());
				dao.update(rVo);
			}
			dao.updateRepCntplc(rVo);
		} else {
			rVo = new CrmCustCntplcBasVo();
			rVo.setItgCustNo(vo.getItgCustNo());
			rVo.setRepCntplcYn("Y");
			rVo.setTelNo(vo.getMphonNo());
			rVo.setTelBkDgtNo(vo.getMphonBkDgtNo());
			rVo.setCntplcTypeCd("004");
			rVo.setEmailAddr(vo.getEmailAddr());
			rVo.setRegChlCd(vo.getRegChlCd());
			rVo.setDistrctCd(vo.getDistrctCd());
			rVo.setZipCd(vo.getZipCd());
			rVo.setAddr1Ctnts(vo.getAddr1Ctnts());
			rVo.setAddr2Ctnts(vo.getAddr2Ctnts());
			dao.insert(rVo);
			dao.updateRepCntplc(rVo);
		}
		updateLastContacts(vo);
		return rVo;

	}

	private void updateLastContacts(CrmCustVo vo) throws Exception {

		CrmCustCntplcBasSo so = new CrmCustCntplcBasSo();
		so.setItgCustNo(vo.getItgCustNo());
		so.setLastYn("Y");
		List<CrmCustCntplcBasVo> lastList = dao.selectLastList(so);

		CrmCustCntplcBasVo instOld = null;
		CrmCustCntplcBasVo jobOld = null;
		CrmCustCntplcBasVo homeOld = null;

		for (int i = 0; i < lastList.size(); i++) {
			if (instOld == null && lastList.get(i).getCntplcTypeCd().equals("001"))
				instOld = lastList.get(i);
			else if (jobOld == null && lastList.get(i).getCntplcTypeCd().equals("002"))
				jobOld = lastList.get(i);
			else if (homeOld == null && lastList.get(i).getCntplcTypeCd().equals("003"))
				homeOld = lastList.get(i);
		}
		// 설치처
		// 직장
		// 자택
		/*
		 * 001 설치장소 002 직장 003 자택
		 */
		CrmCustCntplcBasVo inst = new CrmCustCntplcBasVo();
		inst.setItgCustNo(vo.getItgCustNo());
		inst.setCntplcTypeCd("001");
		inst.setTelNo(vo.getInstTelNo());
//		inst.setTelNo(vo.getInstTelNoEncVal());
		inst.setDistrctCd(vo.getInstDistrctCd());
		inst.setZipCd(vo.getInstZipCd());
		inst.setAddr1Ctnts(vo.getInstAddr1());
		inst.setAddr2Ctnts(vo.getInstAddr2());

		CrmCustCntplcBasVo job = new CrmCustCntplcBasVo();
		job.setItgCustNo(vo.getItgCustNo());
		job.setCntplcTypeCd("002");
		job.setTelNo(vo.getJobTelNo());
//		job.setTelNo(vo.getJobTelNoEncVal());
		job.setDistrctCd(vo.getJobDistrctCd());
		job.setZipCd(vo.getJobZipCd());
		job.setAddr1Ctnts(vo.getJobAddr1());
		job.setAddr2Ctnts(vo.getJobAddr2());

		CrmCustCntplcBasVo home = new CrmCustCntplcBasVo();
		home.setItgCustNo(vo.getItgCustNo());
		home.setCntplcTypeCd("003");
		home.setTelNo(vo.getHomeTelNo());
//		home.setTelNo(vo.getHomeTelNoEncVal());
		home.setZipCd(vo.getHomeZipCd());
		home.setDistrctCd(vo.getHomeDistrctCd());
		home.setAddr1Ctnts(vo.getHomeAddr1());
		home.setAddr2Ctnts(vo.getHomeAddr2());
		updateLastContact(instOld, inst);
		updateLastContact(jobOld, job);
		updateLastContact(homeOld, home);
	}

	private int updateLastContact(CrmCustCntplcBasVo contactOld, CrmCustCntplcBasVo contact) throws Exception {
		if (contactOld == null && contact == null)
			return 0;
		if (contact == null)
			return 0;//super.delete(contactOld);

		String distrctCd = Utilities.nullCheck(contact.getDistrctCd());
		String ziopCd = Utilities.nullCheck(contact.getZipCd());
		String addr1 = Utilities.nullCheck(contact.getAddr1Ctnts());
		String addr2 = Utilities.nullCheck(contact.getAddr2Ctnts());
		String telNo = Utilities.nullCheck(contact.getTelNo());
		if (Utilities.isNotEmpty(telNo)) {
			telNo = Utilities.encrypt(telNo);
			contact.setTelNo(telNo);
		}
		if (Utilities.isNotEmpty(addr2)) {
			addr2 = Utilities.encrypt(addr2);
			contact.setAddr2Ctnts(addr2);
		}
		if (Utilities.isEmpty(telNo) && Utilities.isEmpty(ziopCd) && Utilities.isEmpty(addr1)
				&& Utilities.isEmpty(addr2) && Utilities.isEmpty(distrctCd) &&contactOld == null) {
//			if (contactOld == null)
				return 0;
//			else
//				super.delete(contactOld);
		}

		if (contactOld == null)
			return insert(contact);

		String telNoOld = Utilities.nullCheck(contactOld.getTelNo());
		String distrctCdOld = Utilities.nullCheck(contactOld.getDistrctCd());
		String ziopCdOld = Utilities.nullCheck(contactOld.getZipCd());
		String addr1Old = Utilities.nullCheck(contactOld.getAddr1Ctnts());
		String addr2Old = Utilities.nullCheck(contactOld.getAddr2Ctnts());
		if (telNoOld.equals(telNo) && ziopCdOld.equals(ziopCd) && addr1Old.equals(addr1) && addr2Old.equals(addr2)
				&& distrctCdOld.equals(distrctCd))
			return 0;

		contact.setCntplcSeq(contactOld.getCntplcSeq());
		if (Utilities.isNotEmpty(contact.getEmailAddr()))
			contact.setEmailAddr(contactOld.getEmailAddr());

		return update(contact);

	}

	@Override
	public int delete(Object param) throws Exception {
		CrmCustCntplcBasVo vo = get(param);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		if ("Y".equals(vo.getRepCntplcYn()))
			throw new EzApiException(API_CODE_CANNOT_DELETE, API_CODE_CANNOT_DELETE_MSG);

		return super.delete(param);
	}

	public int deleteCust(Object param) throws Exception {
		return dao.deleteCust(param);
	}

	public List<CrmCustCntplcBasVo> insertCntplcList(List<CrmCustCntplcBasVo> list) throws Exception {
		List<CrmCustCntplcBasVo> ret = new ArrayList<CrmCustCntplcBasVo>();
		for (int i = 0; i < list.size(); i++) {
			CrmCustCntplcBasVo vo = list.get(i);
			Utilities.validate(vo);
			insert(vo);
			CrmCustCntplcBasSo so = new CrmCustCntplcBasSo();
			so.setForceDecrypt(true);
			so.setCntplcSeq(vo.getCntplcSeq());
			ret.add(get(so));
		}
		return ret;
	}
}
