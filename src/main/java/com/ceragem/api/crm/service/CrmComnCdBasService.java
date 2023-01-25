package com.ceragem.api.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmComnCdBasDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCommonCodeVo;

/**
 * 
 * @ClassName CrmComnCdBasService
 * @author 김성태
 * @date 2022. 4. 8.
 * @Version 1.0
 * @description 공통코드 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmComnCdBasService extends AbstractCrmService {
	@Autowired
	CrmComnCdBasDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public List<CrmCommonCodeVo> getLargeList(Object param) throws Exception {
		return dao.selectLargeList(param);
	}
}
