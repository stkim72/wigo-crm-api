package com.ceragem.api.crm.dao;

import com.ceragem.api.config.annotation.CrmMapper;

@CrmMapper
public interface CrmAcqieHstDao extends ICrmDao {
	int deleteCust(Object param) throws Exception;
}
