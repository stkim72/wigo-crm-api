package com.ceragem.api.as.dao;

import com.ceragem.api.as.model.AsmWebAppApiVo;
import com.ceragem.api.config.annotation.AsMapper;

@AsMapper
public interface AsmWebAppApiDao extends IAsmDao {

	AsmWebAppApiVo selectAppVer(Object param) throws Exception;

}
