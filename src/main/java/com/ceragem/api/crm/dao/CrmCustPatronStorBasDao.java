package com.ceragem.api.crm.dao;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmCustPatronStorBasVo;

@CrmMapper
public interface CrmCustPatronStorBasDao extends ICrmDao {

	int deleteStore(Object param) throws Exception;

	CrmCustPatronStorBasVo selectStore(Object param) throws Exception;

}
