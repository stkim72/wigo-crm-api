package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmRcmdHstDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmRcmdHstService
 * @author    user
 * @date    2022. 8. 18.
 * @Version    1.0
 * @description    CRM추천인 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmRcmdHstService extends AbstractCrmService {
   @Autowired
   CrmRcmdHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
