package com.ceragem.api.ctc.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.ctc.dao.CtcInquiryDao;
import com.ceragem.api.ctc.model.CtcInquiryVo;


@Service("CtcInquiryService")
public class CtcInquiryServiceimpl implements CtcInquiryService
{

    @Autowired
    CtcInquiryDao dao;


    @Override
    public List<CtcInquiryVo> selectList(Map<String, Object> param) throws Exception
    {
        return dao.selectList(param);
    }



}
