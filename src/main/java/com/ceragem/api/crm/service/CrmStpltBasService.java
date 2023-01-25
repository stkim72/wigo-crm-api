package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmStpltBasDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmStpltBasService
 * @author    김성태
 * @date    2022. 5. 23.
 * @Version    1.0
 * @description    CRM약관기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmStpltBasService extends AbstractCrmService {
   @Autowired
   CrmStpltBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
