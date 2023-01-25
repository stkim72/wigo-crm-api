package com.ceragem.api.crm.dao;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmPointHstVo;

@CrmMapper
public interface CrmPointUseRelDao extends ICrmDao {

	int deletePoint(CrmPointHstVo pt) throws Exception;

}
