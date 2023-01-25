package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmStorBasDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmStorBasService
 * @author    김성태
 * @date    2022. 5. 16.
 * @Version    1.0
 * @description    CRM매장기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmStorBasService extends AbstractCrmService {
   @Autowired
   CrmStorBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
