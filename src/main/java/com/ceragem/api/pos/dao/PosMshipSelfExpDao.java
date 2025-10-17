package com.ceragem.api.pos.dao;

import java.util.List;

import com.ceragem.api.config.annotation.PosMapper;
import com.ceragem.api.pos.model.PosExpCustListVo;
import com.ceragem.api.pos.model.PosExpListVo;
import com.ceragem.api.pos.model.PosExpResultVo;
import com.ceragem.api.pos.model.PosExpVo;

@PosMapper
public interface PosMshipSelfExpDao extends IPosDao {

	List<PosExpResultVo> getMshipSelfExpList(PosExpVo vo) throws Exception;

	List<PosExpCustListVo> getCustExpList(PosExpListVo vo) throws Exception;

	void insertExpWaitList(PosExpVo vo);

	List<PosExpResultVo> selectExpWaitHour(PosExpVo vo);

	int saveExpWaitHourS(PosExpVo vo);

	int selectExpWaitHourNullYn(PosExpVo vo);

	int updateExpHourNull(PosExpVo vo);

	int selectStorcdNullchk(PosExpVo vo);
}
