package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmMshipPromBasDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipPromBasService
 * @author    김성태
 * @date    2022. 6. 20.
 * @Version    1.0
 * @description    CRM멤버십프로모션기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipPromBasService extends AbstractCrmService {
   @Autowired
   CrmMshipPromBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
