package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmPointUseRelDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmPointUseRelService
 * @author    김성태
 * @date    2022. 4. 22.
 * @Version    1.0
 * @description    CRM포인트사용관계 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmPointUseRelService extends AbstractCrmService {
   @Autowired
   CrmPointUseRelDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
