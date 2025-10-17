package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.CrmAppPushTrmHstVo;
import com.ceragem.crm.common.model.EzMap;

@CrmMapper
public interface CrmMshipAppToknBasDao extends ICrmDao {

	int deleteAppId(Object param);

	int updatePushRead(Object param);

	int updatePushReadAll(Object param);

	List<EzMap> selectDispatch(Object param);

	int updateTokenUseYn(Object param);

	CrmAppPushTrmHstVo selectPushTrm(Object param);

	List<CrmAppPushTrmHstVo> selectPushTrmList(Object param);

	int selectPushTrmListCount(Object so);

}
