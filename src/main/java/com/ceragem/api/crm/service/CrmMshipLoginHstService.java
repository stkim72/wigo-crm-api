package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmMshipLoginHstDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipLoginHstService
 * @author    김성태
 * @date    2023. 3. 31.
 * @Version    1.0
 * @description    CRM사용자로그인이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipLoginHstService extends AbstractCrmService {
   @Autowired
   CrmMshipLoginHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
