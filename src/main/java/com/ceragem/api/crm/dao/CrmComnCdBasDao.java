package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmCommonCodeVo;

@CrmMapper
public interface CrmComnCdBasDao extends ICrmDao {

	List<CrmCommonCodeVo> selectLargeList(Object param) throws Exception;

}
