package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmMshipAppToknBasDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipAppToknBasService
 * @author    김성태
 * @date    2023. 5. 26.
 * @Version    1.0
 * @description    멤버십앱토큰기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipAppToknBasService extends AbstractCrmService {
   @Autowired
   CrmMshipAppToknBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
