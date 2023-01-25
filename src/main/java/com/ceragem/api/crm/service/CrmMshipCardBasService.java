package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmCardPblsHstDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipCardBasService
 * @author    김성태
 * @date    2022. 4. 26.
 * @Version    1.0
 * @description    CRM멤버십카드기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipCardBasService extends AbstractCrmService {
   @Autowired
   CrmCardPblsHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
