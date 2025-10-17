package com.ceragem.api.as.dao;

import com.ceragem.api.as.model.AsmAsSubmitBasHstCountVo;
import com.ceragem.api.config.annotation.AsMapper;

@AsMapper
public interface AsmAsHstDao extends IAsmDao {

	AsmAsSubmitBasHstCountVo selectAsHistoryCount(Object param) throws Exception;

}
