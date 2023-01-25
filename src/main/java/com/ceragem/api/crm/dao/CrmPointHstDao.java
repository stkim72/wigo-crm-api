package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmPointHstVo;
import com.ceragem.api.crm.model.CrmPointInfoVo;
import com.ceragem.api.crm.model.CrmPointVo;

@CrmMapper
public interface CrmPointHstDao extends ICrmDao {
	int updateExtncDt(Object param) throws Exception;

	CrmPointInfoVo selectPointInfo(Object param) throws Exception;

	List<CrmPointHstVo> selectAvailableList(Object param) throws Exception;

	List<CrmPointHstVo> selectDebtList(Object param) throws Exception;

	CrmPointHstVo selectChitNoChk(CrmPointVo vo);

}
