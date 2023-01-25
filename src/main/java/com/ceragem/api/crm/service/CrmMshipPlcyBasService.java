package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmMshipPlcyBasDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmMshipPlcyBasVo;

/**
 * 
 * @ClassName    CrmMshipPlcyBasService
 * @author    user
 * @date    2022. 5. 20.
 * @Version    1.0
 * @description    맴버십기본정책 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipPlcyBasService extends AbstractCrmService {
   @Autowired
   CrmMshipPlcyBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   
   
   public CrmMshipPlcyBasVo selectPlcyInfo(CrmMshipPlcyBasVo plcyVo) {
		return dao.selectPlcyInfo(plcyVo);
	}
}
