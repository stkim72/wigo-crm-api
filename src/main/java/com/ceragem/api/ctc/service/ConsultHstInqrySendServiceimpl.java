package com.ceragem.api.ctc.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.ctc.dao.ConsultHstInqrySendDao;
import com.ceragem.api.ctc.model.ConsultHstInqryDetailSendVo;
import com.ceragem.api.ctc.model.ConsultHstInqrySendSo;
import com.ceragem.api.ctc.model.ConsultHstInqrySendVo;


@Service("consultHstInqrySendService")
public class ConsultHstInqrySendServiceimpl implements ConsultHstInqrySendService
{

    @Autowired
    ConsultHstInqrySendDao dao;


    @Override
    public List<ConsultHstInqrySendVo> selectList(Map<String, Object> param) throws Exception
    {
        return dao.selectList(param);
    }


    @Override
    public ConsultHstInqryDetailSendVo selectListDetail(ConsultHstInqrySendSo so) throws Exception
    {
        return dao.selectListDetail(so);
    }

}
