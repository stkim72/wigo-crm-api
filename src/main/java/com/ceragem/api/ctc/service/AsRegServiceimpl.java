package com.ceragem.api.ctc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.ctc.dao.AsRegDao;


@Service("homepageQustnAsRegService")
public class AsRegServiceimpl implements AsRegService
{

    @Autowired
    AsRegDao dao;


    @Override
    public int insert(Object param) throws Exception
    {
        return dao.insert(param);
    }
}
