package com.ceragem.api.crm.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmCustBasDao;
import com.ceragem.api.crm.dao.CrmCustPatronStorBasDao;
import com.ceragem.api.crm.dao.CrmStorBasDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCustPatronStorBasVo;
import com.ceragem.crm.common.model.EzApiException;

/**
 * 
 * @ClassName CrmCustPatronStorBasService
 * @author 김성태
 * @date 2022. 5. 16.
 * @Version 1.0
 * @description CRM고객단골매장기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustPatronStorBasService extends AbstractCrmService {

	@Autowired
	CrmCustPatronStorBasDao dao;

	@Autowired
	CrmCustBasDao custDao;

	@Autowired
	CrmStorBasDao storeDao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public int deleteStore(CrmCustPatronStorBasVo vo) throws Exception {
		return dao.deleteStore(vo);
	}

	@Override
	public int insert(Object param) throws Exception {
		Map<String, Object> so = Utilities.beanToMap(param);
		if (custDao.select(so) == null)
			throw new EzApiException(Constants._API_CODE_NO_USER, Constants._API_CODE_NO_USER_MSG);

		if (storeDao.select(so) == null)
			throw new EzApiException(Constants._API_CODE_NO_STORE, Constants._API_CODE_NO_STORE_MSG);

		if (dao.selectStore(so) != null)
			throw new EzApiException(Constants._API_CODE_DUPLICATED_PARAM, Constants._API_CODE_DUPLICATED_PARAM_MSG);

		return super.insert(param);
	}
}
