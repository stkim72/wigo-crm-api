package com.ceragem.api.crm.dao;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmMshipApplyAdvncmtRelVo;
import com.ceragem.api.crm.model.CrmMshipApplyPointRelVo;
import com.ceragem.api.crm.model.CrmMshipPlcyBasVo;

@CrmMapper
public interface CrmMshipPlcyBasDao extends ICrmDao {

	CrmMshipPlcyBasVo selectPlcyInfo(CrmMshipPlcyBasVo plcyVo);

	CrmMshipPlcyBasVo selectCoupnPlcyInfo(CrmMshipPlcyBasVo vo);

	CrmMshipApplyPointRelVo selectEventPointInfo(CrmMshipPlcyBasVo plcyInfo);

	CrmMshipApplyAdvncmtRelVo selectEventAdvnInfo(CrmMshipPlcyBasVo custVo);

	CrmMshipApplyPointRelVo selectEventPointCnt(CrmMshipPlcyBasVo plcyInfo);

}
