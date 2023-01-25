package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmChlBasVo;
import com.ceragem.api.crm.model.CrmCouponCustNoSo;
import com.ceragem.api.crm.model.CrmCouponVo;
import com.ceragem.api.crm.model.CrmGodsBasVo;
import com.ceragem.api.crm.model.CrmMshipCoupnBasVo;
import com.ceragem.crm.common.model.EzMap;

@CrmMapper
public interface CrmCoupnPblsHstDao extends ICrmDao {
	int deleteBook(Object param) throws Exception;

	int updateApprove(Object param) throws Exception;

	int updateCancel(Object param) throws Exception;

	int insertIssueTem(CrmCouponVo cpVo);

	CrmCouponVo getMaxCoupnHstSeq(CrmCouponVo cpVo);

	int getMaxIssuDay(String mshipCoupnBasNo);

	List<CrmGodsBasVo> getGodsList(String mshipCoupnBasNo);

	List<CrmChlBasVo> getChlList(String mshipCoupnBasNo);

	List<CrmCouponVo> getCouponMasterList(CrmCouponCustNoSo so);

	int updateGiftCoupn(CrmCouponVo vo);

	CrmCouponVo selectJoinStore(CrmCouponVo vo);

	int getDayCoupnCnt(CrmMshipCoupnBasVo voTem);

	CrmCouponVo selectMaster(CrmCouponVo cpVo);

	EzMap selectStorCnt(CrmCouponVo vo);
}
