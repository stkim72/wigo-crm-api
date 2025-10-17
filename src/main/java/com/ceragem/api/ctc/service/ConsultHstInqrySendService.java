package com.ceragem.api.ctc.service;

import java.util.List;
import java.util.Map;

import com.ceragem.api.ctc.model.ConsultHstInqryDetailSendVo;
import com.ceragem.api.ctc.model.ConsultHstInqrySendSo;
import com.ceragem.api.ctc.model.ConsultHstInqrySendVo;

public interface ConsultHstInqrySendService {

	List<ConsultHstInqrySendVo> selectList(Map<String, Object> param) throws Exception;

	ConsultHstInqryDetailSendVo selectListDetail(ConsultHstInqrySendSo so)  throws Exception;

}
