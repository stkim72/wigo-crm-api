package com.ceragem.api.as.dao;

import com.ceragem.api.config.annotation.AsMapper;

@AsMapper
public interface AsmMoDao extends IAsmDao {

	int moFileInsert(Object param) throws Exception;

	int moFileUpdate(Object param) throws Exception;

}
