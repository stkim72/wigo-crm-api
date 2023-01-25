package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmMshipCoupnBasDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipCoupnBasService
 * @author    김성태
 * @date    2022. 4. 28.
 * @Version    1.0
 * @description    CRM멤버십쿠폰기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipCoupnBasService extends AbstractCrmService {
   @Autowired
   CrmMshipCoupnBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
