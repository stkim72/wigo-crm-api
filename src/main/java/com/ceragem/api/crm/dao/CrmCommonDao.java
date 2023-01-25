package com.ceragem.api.crm.dao;

import com.ceragem.api.config.annotation.CrmMapper;

@CrmMapper
public interface CrmCommonDao extends ICrmDao {

	String getAutoSeq(Object param);

	String endcryptText(String param);

	String decryptText(String param);
}
