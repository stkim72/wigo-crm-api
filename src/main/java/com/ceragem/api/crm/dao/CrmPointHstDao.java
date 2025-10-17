package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmPointExceptVo;
import com.ceragem.api.crm.model.CrmPointExpireVo;
import com.ceragem.api.crm.model.CrmPointHstVo;
import com.ceragem.api.crm.model.CrmPointInfoVo;
import com.ceragem.crm.common.model.EzMap;

@CrmMapper
public interface CrmPointHstDao extends ICrmDao {
	int updateExtncDt(Object param) throws Exception;

	CrmPointInfoVo selectPointInfo(Object param) throws Exception;

	List<CrmPointHstVo> selectAvailableList(Object param) throws Exception;

	List<CrmPointHstVo> selectDebtList(Object param) throws Exception;

	List<CrmPointHstVo> selectUseRelList(Object param) throws Exception;

	EzMap selectChitNoChk(Object vo) throws Exception;

	int updatePerdExtncDt(Object pt) throws Exception;

	int selectPerdPointRemain(Object pt) throws Exception;

	int insertPerdHst(Object p) throws Exception;

	int updatePerdDt(Object point) throws Exception;

	CrmPointHstVo selectValidPerd(Object vo) throws Exception;

	List<CrmPointHstVo> selectExpireList(Object param) throws Exception;

	CrmPointHstVo selectLastPoint(Object param) throws Exception;

	int insertUseRel(Object param) throws Exception;

	int updateExpire(Object param) throws Exception;

	int updateExpirePerd(Object param) throws Exception;

	List<CrmPointExceptVo> selectPointExceptList(Object param) throws Exception;

	int insertRestoreHst(Object param) throws Exception;

	List<CrmPointExpireVo> selectPointExpireList(Object param) throws Exception;

}
