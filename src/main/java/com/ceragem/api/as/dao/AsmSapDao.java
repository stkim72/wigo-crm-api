package com.ceragem.api.as.dao;

import com.ceragem.api.config.annotation.AsMapper;

@AsMapper
public interface AsmSapDao extends IAsmDao {

	int insertPrecChitRrm(Object param) throws Exception;

	int insertAsRmnyBatchTmp(Object param) throws Exception;

	int updateAsRmnyBatchTmp(Object param) throws Exception;

	int deleteAsRmnyBatchTmp(Object param) throws Exception;

	int insertRfndTrtTrm(Object param) throws Exception;

	int updateRfndTrtTrm(Object param) throws Exception;

	int updateProdReqTrm(Object param) throws Exception;

	int updateRfndTrtTrm2(Object param) throws Exception;

}
