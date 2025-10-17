package com.ceragem.api.as.dao;

import com.ceragem.api.config.annotation.AsMapper;

@AsMapper
public interface AsmBosHstDao extends IAsmDao {

	int insertContractIfHist(Object param) throws Exception;

}
