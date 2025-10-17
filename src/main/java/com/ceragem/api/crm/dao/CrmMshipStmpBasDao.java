package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmMshipStmpEventVo;
import com.ceragem.api.crm.model.CrmMshipStmpIssueVo;
import com.ceragem.crm.common.model.EzMap;

@CrmMapper
public interface CrmMshipStmpBasDao extends ICrmDao {

	List<String> getStmpMarstList(EzMap parm);

	List<EzMap> getStmpInfoList(EzMap infoPrm);

	int getStmpTotalHist(EzMap hisPrm);

	List<EzMap> getStmpGodsList(EzMap godsPrm);

	int insertStmpHis(EzMap inHisPrm);

	EzMap getStmpMaxSeq(String hstSeq);

	int updateStmpHis(EzMap upHisPrm);

	String getStmpHisSeq(EzMap inHisPrm);

	List<String> getStmpMarstListForChitNo(EzMap parm);

	List<EzMap> getStmpMarstInfoList(EzMap parm);

	EzMap getStmpMarstInfo(EzMap parm);

	int deleteStmpHis(EzMap parm);

	List<EzMap> getStmpMarstListForEvent(EzMap parm);

	int checkStoreCnt(String storNo);

	int checkChlCnt(String chlCd);

	int checkMemberCnt(String itgCustNo);

	List<CrmMshipStmpIssueVo> getStmpIssueList(EzMap param);

	List<EzMap> getStmpMarstList2(EzMap checkParm);

	List<EzMap> getStmpHistoryList(EzMap hisParm);

	int checkChitNoCheck(String chitNo);

	List<EzMap> getStmpCancelData(EzMap parm);

	int getStmpDayHist(EzMap hisPrm);

	List<EzMap> getMasterStmpByGodsList(Object parm);

	int deleteStmpCancel(Object param);

	List<CrmMshipStmpIssueVo> selectStmpCancelList(Object param);

	CrmMshipStmpEventVo selectExpStampEvent(Object param);
}
