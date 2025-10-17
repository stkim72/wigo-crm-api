package com.ceragem.api.crm.service;

import com.ceragem.api.crm.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.api.base.service.AbstractCrmService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CrmHomeExprnService extends AbstractCrmService {

    @Autowired
    CrmHomeExprnDao dao;

    @Override
    public ICrmDao getDao() {
        return dao;
    }

}
