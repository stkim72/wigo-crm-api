package com.ceragem.api.crm.dao;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmCustInfoPtuseAgreeHstVo;

@CrmMapper
public interface CrmCustInfoPtuseAgreeHstDao extends ICrmDao {

	void updateCustAgreement(Object param) throws Exception;

	CrmCustInfoPtuseAgreeHstVo selectChangeInfo(Object param)throws Exception;

}
