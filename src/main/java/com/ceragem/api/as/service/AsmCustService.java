package com.ceragem.api.as.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.dao.AsmAsHstDao;
import com.ceragem.api.as.dao.IAsmDao;
import com.ceragem.api.base.service.AbstractAsmService;

/**
 *
 * @ClassName AsmCustService
 * @author 이윤성
 * @date 2022. 5. 30.
 * @Version 1.0
 * @description BOS고객상세조회 Service ==> AsmCustService 사용안함, 삭제예정
 */
@Service
public class AsmCustService extends AbstractAsmService {

	@Autowired
	AsmBosApiCallService asmBosApiCallService;

	@Autowired
	AsmAsHstDao dao;

	@Override
	public IAsmDao getDao() {
		return dao;
	}
}
