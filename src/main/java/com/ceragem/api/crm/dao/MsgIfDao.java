package com.ceragem.api.crm.dao;

import java.util.List;

import com.ceragem.api.config.annotation.CrmMapper;
import com.ceragem.api.crm.model.MsgCodeVo;
import com.ceragem.api.crm.model.MsgIfVo;
import com.ceragem.crm.common.model.EzMap;

@CrmMapper
public interface MsgIfDao extends ICrmDao {
	List<MsgCodeVo> selectCodeList();

	MsgCodeVo selectCode(Object param);
	
	MsgCodeVo selectEvtCode(Object param);

	int insertEvtMsg(MsgIfVo param);
	
	int insertEvtMsgR(MsgIfVo param);

	MsgCodeVo selectEvtSmsCode(EzMap param);
	
}
