package com.ceragem.api.as.dao;

import com.ceragem.api.config.annotation.AsMapper;

@AsMapper
public interface AsmCommonDao extends IAsmDao {

	String getAutoSeq(Object param);
}
