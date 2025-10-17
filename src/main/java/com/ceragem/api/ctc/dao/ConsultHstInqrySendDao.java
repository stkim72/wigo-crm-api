package com.ceragem.api.ctc.dao;


import com.ceragem.api.base.dao.IBaseDao;
import com.ceragem.api.config.annotation.CtcMapper;
import com.ceragem.api.ctc.model.ConsultHstInqryDetailSendVo;
import com.ceragem.api.ctc.model.ConsultHstInqrySendSo;


@CtcMapper
public interface ConsultHstInqrySendDao extends IBaseDao
{

    ConsultHstInqryDetailSendVo selectListDetail(ConsultHstInqrySendSo so);

}