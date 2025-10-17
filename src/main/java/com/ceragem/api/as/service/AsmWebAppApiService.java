package com.ceragem.api.as.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.dao.AsmWebAppApiDao;
import com.ceragem.api.as.dao.IAsmDao;
import com.ceragem.api.as.model.AsmWebAppApiVo;
import com.ceragem.api.base.service.AbstractAsmService;

/**
 *
 * @ClassName AsmWebAppApiService
 * @author 이윤성
 * @date 2022. 6. 15.
 * @Version 1.0
 * @description AS네이티브앱 WebApp API Service
 */
@Service
public class AsmWebAppApiService extends AbstractAsmService {

	@Autowired
	AsmWebAppApiDao dao;

	@Override
	public IAsmDao getDao() {
		return dao;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 15.
	 * @param (필수) 공통코드 (CM119)
	 * @return
	 * @throws Exception
	 * @description 네이티브App 버전정보 조회
	 *
	 */
	public AsmWebAppApiVo selectAppVer(Object param) throws Exception {
		return dao.selectAppVer(param);
	}
}
