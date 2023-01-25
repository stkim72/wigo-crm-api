package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmBllkCustHstVo;

@CrmMapper
public interface CrmBllkCustHstDao extends ICrmDao {

	int updateDelete(Object param) throws Exception;

	int deleteCust(Object param) throws Exception;

	List<CrmBllkCustHstVo> selectCustList(Object param) throws Exception;

	int updateDeleteStore(Object param) throws Exception;

	int updateDeleteChennel(Object param) throws Exception;
}
