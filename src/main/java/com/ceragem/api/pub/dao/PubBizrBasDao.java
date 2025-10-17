package com.ceragem.api.pub.dao;

import java.util.List;

import com.ceragem.api.config.annotation.PubMapper;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.pub.model.PubBizrBasSo2;
import com.ceragem.api.pub.model.PubBizrBasVo;
import com.ceragem.crm.common.model.EzMap;

@PubMapper
public interface PubBizrBasDao extends ICrmDao {

	List<CrmCustVo> getCustList(EzMap param);

	int insertPubMem(PubBizrBasSo2 insVo);

	PubBizrBasSo2 selectChkPub(EzMap param);

	int selectChkWlng(PubBizrBasVo vo);

	int getCustListCount(EzMap param);

	int updateFileCd(PubBizrBasVo param);

}
