package com.ceragem.api.as.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.dao.AsmAsHstDao;
import com.ceragem.api.as.dao.IAsmDao;
import com.ceragem.api.as.model.AsmAsSubmitBasHstCountVo;
import com.ceragem.api.base.service.AbstractAsmService;

/**
 *
 * @ClassName AsmAsHstService
 * @author 이윤성
 * @date 2022. 5. 20.
 * @Version 1.0
 * @description AS이력 Service
 */
@Service
public class AsmAsHstService extends AbstractAsmService {
	@Autowired
	AsmAsHstDao dao;

	@Override
	public IAsmDao getDao() {
		return dao;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 15.
	 * @param (필수) 통합고객번호
	 * @return
	 * @throws Exception
	 * @description AS이력 건수(총건수, 취소건수) API
	 *
	 */
	public AsmAsSubmitBasHstCountVo selectAsHistoryCount(Object param) throws Exception {
		return dao.selectAsHistoryCount(param);
	}
}
