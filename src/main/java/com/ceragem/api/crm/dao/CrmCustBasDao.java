package com.ceragem.api.crm.dao;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmMshipApplyCoupnEventRelVo;

@CrmMapper
public interface CrmCustBasDao extends ICrmDao {

	int updateRepCntplc(Object param) throws Exception;

	int updateDelete(Object param) throws Exception;

	int deleteDormant(Object param) throws Exception;

	int insertDormant(Object param) throws Exception;

	int updateDormant(Object param) throws Exception;

	int insertCard(Object param) throws Exception;

	CrmCustVo selectLoginId(Object param) throws Exception;

	CrmCustVo selectBasic(Object param) throws Exception;

	int updateSuccessLogin(Object param) throws Exception;

	int updateFailLogin(Object param) throws Exception;

	int updateRepHshld(Object param) throws Exception;

	int updateRepHshldDelete(Object param) throws Exception;

	int updateLastVisitStore(Object param) throws Exception;

	int updateLastPatronStore(Object param) throws Exception;

	int updateRemainPoint(Object param) throws Exception;

	int updateBlack(Object param) throws Exception;

	int insertMembership(Object vo) throws Exception;

	int updateMembership(Object vo) throws Exception;

	int selectCoupnCount(Object so) throws Exception;

//	int selectCoupnCount(Object custVo) throws Exception;

	CrmMshipApplyCoupnEventRelVo selectCoupnInfo(Object custVo);

	CrmCustVo selectNamePhone(Object vo) throws Exception;

//	int updateAgreement(Object vo) throws Exception;

	int updateDuplication(Object vo) throws Exception;

	int updateLastLogin(Object vo) throws Exception;

	int updateLoginPassword(Object vo) throws Exception;

	int updateLoginIdPassword(Object vo) throws Exception;

	int updateCustType(Object vo) throws Exception;

	int updateAlliance(Object vo) throws Exception;

	int updateAllianceRef(Object vo) throws Exception;

	int updateAllianceRefNull(Object vo) throws Exception;

	int updateToken(Object param) throws Exception;

	CrmCustVo selectMphone(Object vo) throws Exception;

	void updateDormantStatus(Object param) throws Exception;

	CrmCustVo selectExitUser(Object vo) throws Exception;

	CrmCustVo selectRcmdCustInfo(CrmCustVo custVo);

}
