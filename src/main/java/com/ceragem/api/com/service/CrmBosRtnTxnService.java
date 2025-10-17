package com.ceragem.api.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.com.dao.CrmBosRtnTxnDao;
import com.ceragem.api.crm.dao.CrmCustBosCntrtHstDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCustBosCntrtHstVo;

/**
 * 
 * @ClassName CrmBosRtnTxnService
 * @author 김성태
 * @date 2023. 6. 14.
 * @Version 1.0
 * @description CRMBOS반환내역 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmBosRtnTxnService extends AbstractCrmService {
	@Autowired
	CrmBosRtnTxnDao dao;

	@Autowired
	CrmCustBosCntrtHstDao contractDao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public int getContractListCount(Object so) {

		return contractDao.selectListCount(so);
	}

	public List<CrmCustBosCntrtHstVo> getContractList(Object so) {
		return contractDao.selectList(so);
	}


	public CrmCustBosCntrtHstVo getContractDetail(Object param) {
		return contractDao.select(param);
	}
}
