package com.ceragem.api.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmPointGodsHstDao;
import com.ceragem.api.crm.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmPointGodsHstService
 * @author    user
 * @date    2022. 5. 23.
 * @Version    1.0
 * @description    구매상품별포인트히스토리 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmPointGodsHstService extends AbstractCrmService {
   @Autowired
   CrmPointGodsHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
