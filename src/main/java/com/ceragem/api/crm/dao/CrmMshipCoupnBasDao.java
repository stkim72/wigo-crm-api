package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmChlBasVo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmGodsBasVo;
import com.ceragem.api.crm.model.CrmMshipApplyCoupnEventRelVo;
import com.ceragem.api.crm.model.CrmMshipCoupnBasSo;
import com.ceragem.api.crm.model.CrmMshipCoupnBasVo;
import com.ceragem.api.crm.model.CrmStorBasVo;
import com.ceragem.crm.common.model.EzMap;

@CrmMapper
public interface CrmMshipCoupnBasDao extends ICrmDao {

	CrmMshipCoupnBasVo selectMasterCoupon(Object param);

	CrmMshipApplyCoupnEventRelVo selectCoupnInfo(CrmCustVo vo);

	List<CrmChlBasVo> getChlList(CrmMshipCoupnBasSo so);

	List<CrmGodsBasVo> getGodsList(CrmMshipCoupnBasSo so);

	List<CrmStorBasVo> getStorList(CrmMshipCoupnBasSo so);

	List<EzMap> selectEventCoupon(Object param);

}
