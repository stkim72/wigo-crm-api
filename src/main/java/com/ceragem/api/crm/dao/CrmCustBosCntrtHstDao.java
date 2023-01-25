package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmCustBosCntrtHstVo;

@CrmMapper
public interface CrmCustBosCntrtHstDao extends ICrmDao {
	List<CrmCustBosCntrtHstVo> selectCustContractList(Object param);

	int selectCustContractListCount(Object param);
}
