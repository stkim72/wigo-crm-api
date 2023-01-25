package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmCustCntplcBasVo;

@CrmMapper
public interface CrmCustCntplcBasDao extends ICrmDao {

	int updateRepCntplc(Object param) throws Exception;

	int deleteCust(Object param) throws Exception;

	int deleteUpdate(Object param)throws Exception;

	List<CrmCustCntplcBasVo> selectLastList(Object param) throws Exception;

}
