package com.ceragem.api.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmCustBasDao;
import com.ceragem.api.crm.dao.CrmCustHshldBasDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCustHshldBasSo;
import com.ceragem.api.crm.model.CrmCustHshldBasVo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.crm.common.model.EzApiException;

/**
 * 
 * @ClassName CrmCustHshldBasService
 * @author 김성태
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM고객가구기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustHshldBasService extends AbstractCrmService {

	public final static String API_CODE_CANNOT_INSERT_001 = "IAR0501";
	public final static String API_CODE_CANNOT_INSERT_001_MSG = "본인을 가족으로 추가할 수 없습니다.";

	public final static String API_CODE_CANNOT_INSERT_002 = "IAR0502";
	public final static String API_CODE_CANNOT_INSERT_002_MSG = "등록되지 않은 대표 사용자 입니다.";

	public final static String API_CODE_CANNOT_INSERT_003 = "IAR0503";
	public final static String API_CODE_CANNOT_INSERT_003_MSG = "등록되지 않은 사용자 입니다.";

	public final static String API_CODE_CANNOT_INSERT_004 = "IAR0504";
	public final static String API_CODE_CANNOT_INSERT_004_MSG = "이미 등록된 가족 회원 입니다.";

	public final static String API_CODE_CANNOT_INSERT_005 = "IAR0505";
	public final static String API_CODE_CANNOT_INSERT_005_MSG = "다른 가족에 소속된 회원입니다.";

	public final static String API_CODE_CANNOT_INSERT_006 = "IAR0506";
	public final static String API_CODE_CANNOT_INSERT_006_MSG = "다른 가족 구성원을 대표사용자로 지정 할 수 없습니다.";

	@Autowired
	CrmCustHshldBasDao dao;

	@Autowired
	CrmCustBasDao custDao;

	@Autowired
	CrmSnstvInfoInqryHstService inqHstService;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	@Override
	public int insert(Object param) throws Exception {

		CrmCustHshldBasVo vo = null;
		vo = (CrmCustHshldBasVo) param;
		if (vo.getItgCustNo().equals(vo.getRepHshldNo())) {
			throw new EzApiException(API_CODE_CANNOT_INSERT_001, API_CODE_CANNOT_INSERT_001_MSG);
		}

		CrmCustHshldBasSo so = new CrmCustHshldBasSo();
		so.setItgCustNo(vo.getItgCustNo());
		List<CrmCustHshldBasVo> list = dao.selectList(so);
		if (Utilities.isNotEmpty(list)) {
			CrmCustHshldBasVo v = list.get(0);
			if (v.getRepHshldNo().equals(vo.getRepHshldNo()))
				throw new EzApiException(API_CODE_CANNOT_INSERT_004, API_CODE_CANNOT_INSERT_004_MSG);
			else {
				throw new EzApiException(API_CODE_CANNOT_INSERT_005, API_CODE_CANNOT_INSERT_005_MSG);
			}
		}

		so.setItgCustNo(vo.getRepHshldNo());
		CrmCustHshldBasVo rvo = dao.selectNoDel(so);
		if (rvo != null && !rvo.getItgCustNo().equals(rvo.getRepHshldNo())) {
			throw new EzApiException(API_CODE_CANNOT_INSERT_006, API_CODE_CANNOT_INSERT_006_MSG);
		}

		CrmCustVo custVo = custDao.select(so);
		if (custVo == null) {
			throw new EzApiException(API_CODE_CANNOT_INSERT_002, API_CODE_CANNOT_INSERT_002_MSG);
		}

		so.setItgCustNo(vo.getItgCustNo());
		custVo = custDao.select(so);
		if (custVo == null) {
			throw new EzApiException(API_CODE_CANNOT_INSERT_003, API_CODE_CANNOT_INSERT_003_MSG);
		}

		so.setItgCustNo(vo.getRepHshldNo());
		so.setRepHshldNo(vo.getRepHshldNo());
		CrmCustHshldBasVo rVo = dao.select(so);
		if (rVo == null) {
			CrmCustHshldBasVo v = new CrmCustHshldBasVo();
			v.setItgCustNo(vo.getRepHshldNo());
			v.setRepHshldNo(vo.getRepHshldNo());
			v.setFamlyRelCd("000");
			v.setUseTypeCd(vo.getUseTypeCd());
			dao.insert(v);

			CrmCustVo cust = new CrmCustVo();
			cust.setItgCustNo(vo.getRepHshldNo());
			cust.setRepHshldNo(vo.getRepHshldNo());
			custDao.updateRepHshld(cust);
		}

		int ret = super.insert(param);

		CrmCustVo cust = new CrmCustVo();
		cust.setItgCustNo(vo.getItgCustNo());
		cust.setRepHshldNo(vo.getRepHshldNo());
		custDao.updateRepHshld(cust);

		return ret;
	}

//	@Override
//	public int update(Object param) throws Exception {
//		return super.update(param);
//	}

	@Override
	public int delete(Object param) throws Exception {
		CrmCustHshldBasVo vo = null;
		vo = (CrmCustHshldBasVo) param;
		CrmCustVo cust = new CrmCustVo();
		cust.setItgCustNo(vo.getItgCustNo());
		cust.setRepHshldNo(vo.getItgCustNo());
		custDao.updateRepHshld(cust);
		return dao.delete(param);
	}

	public int deleteCust(Object param) throws Exception {
		return dao.deleteCust(param);

	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCustHshldBasVo get(Object param) throws Exception {
		CrmCustHshldBasVo vo = super.get(param);
		return inqHstService.decrypt(inqHstService.getHistVo(param), vo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmCustHshldBasVo> getList(Object param) throws Exception {
		List<CrmCustHshldBasVo> list = super.getList(param);
		inqHstService.decryptHshld(param, list);
		return list;
	}
}
