package com.ceragem.api.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmBllkCustHstDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmBllkCustHstSo;
import com.ceragem.api.crm.model.CrmBllkCustHstVo;
import com.ceragem.api.crm.model.CrmBllkCustVo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

/**
 * 
 * @ClassName CrmBllkCustHstService
 * @author 김성태
 * @date 2022. 4. 15.
 * @Version 1.0
 * @description CRM주의고객이력 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmBllkCustHstService extends AbstractCrmService {

	public final static String API_CODE_CANNOT_INSERT_001 = "IAR0501";
	public final static String API_CODE_CANNOT_INSERT_001_MSG = "등록되지 않은 사용자 입니다.";

	@Autowired
	CrmBllkCustHstDao dao;
//	@Autowired
//	CrmCustBasDao custDao;
	@Autowired
	CrmCustService custService;
	@Autowired
	CrmSnstvInfoInqryHstService inqHstService;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	@Override
	public int insert(Object param) throws Exception {
		CrmBllkCustVo vo = null;
		if (param instanceof CrmBllkCustVo)
			vo = (CrmBllkCustVo) param;
		else
			vo = Utilities.beanToBean(param, CrmBllkCustHstVo.class);
		EzMap custSo = new EzMap(vo);
		CrmCustVo custVo = custService.get(custSo);
		if (custVo == null) {
			throw new EzApiException(API_CODE_CANNOT_INSERT_001, API_CODE_CANNOT_INSERT_001_MSG);
		}

		CrmBllkCustHstSo so = new CrmBllkCustHstSo();
//		so.setDelYn("N");
		so.setItgCustNo(vo.getItgCustNo());
		so.setStorNo(vo.getStorNo());
		so.setBllkRegWhyCd(vo.getBllkRegWhyCd());
		so.setRegChlCd(vo.getRegChlCd());

		List<CrmBllkCustHstVo> list = dao.selectList(so);
		int ret = 0;
		if (list.size() > 0 && "N".equals(list.get(0).getDelYn())) {
			throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM, "이미 등록된 사용자 입니다.");

//			vo.setBllkCustHstSeq(list.get(0).getBllkCustHstSeq());
//			vo.setDelYn("N");
//			ret = super.update(vo);

		}
//		else
		ret = super.insert(vo);
		custService.updateBlack(vo.getItgCustNo());
		return ret;
	}

	@Override
	public int delete(Object param) throws Exception {
		CrmBllkCustHstVo vo = dao.select(param);
		if (vo == null || "Y".equals(vo.getDelYn())) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		int ret = dao.updateDelete(param);
		custService.updateBlack(vo.getItgCustNo());

		return ret;
	}

	@Override
	public int update(Object param) throws Exception {
		CrmBllkCustHstVo vo = Utilities.beanToBean(param, CrmBllkCustHstVo.class);
		CrmBllkCustHstVo blk = dao.select(param);
		if (blk == null || "Y".equals(blk.getDelYn())) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}
		vo.setItgCustNo(blk.getItgCustNo());
		vo.setDelYn("N");
		return super.update(vo);
	}

	public int deleteStore(CrmBllkCustHstVo vo) throws Exception {

		int ret = dao.updateDeleteStore(vo);
		custService.updateBlack(vo.getItgCustNo());

		return ret;
	}

	public int deleteChennel(CrmBllkCustHstVo vo) throws Exception {
		int ret = dao.updateDeleteChennel(vo);
		custService.updateBlack(vo.getItgCustNo());

		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmBllkCustHstVo> getList(Object param) throws Exception {
		List<CrmBllkCustHstVo> list = super.getList(param);
		inqHstService.decryptCust(param, list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmBllkCustHstVo get(Object param) throws Exception {
		CrmBllkCustHstVo vo = super.get(param);
		inqHstService.decryptCust(param, vo);
		return vo;
	}
}
