package com.ceragem.api.crm.dao;

import com.ceragem.api.config.annotation.CrmMapper;

@CrmMapper
public interface CrmCustHshldBasDao extends ICrmDao {
	int deleteCust(Object param) throws Exception;

	int updateDelete(Object param) throws Exception;
}
