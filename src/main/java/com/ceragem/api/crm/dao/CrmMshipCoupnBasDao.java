package com.ceragem.api.crm.dao;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmMshipApplyCoupnEventRelVo;
import com.ceragem.api.crm.model.CrmMshipCoupnBasVo;

@CrmMapper
public interface CrmMshipCoupnBasDao extends ICrmDao {

	CrmMshipCoupnBasVo selectMasterCoupon(Object param);

	CrmMshipApplyCoupnEventRelVo selectCoupnInfo(CrmCustVo vo);

}
