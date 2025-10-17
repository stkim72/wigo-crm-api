package com.ceragem.api.ctc.service;

import java.util.List;
import java.util.Map;

import com.ceragem.api.ctc.model.CtcInquiryVo;

public interface CtcInquiryService {

	List<CtcInquiryVo> selectList(Map<String, Object> param) throws Exception;


}
