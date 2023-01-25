package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmAdvncmtHstVo;
import com.ceragem.api.crm.model.CrmPointHstVo;

@CrmMapper
public interface CrmAdvncmtHstDao extends ICrmDao {

	CrmAdvncmtHstVo selectAdvnCmtInfo(CrmAdvncmtHstVo hstVo);

	List<CrmAdvncmtHstVo> selectAdvnCmt(CrmPointHstVo vo);

}
