package com.ceragem.api.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.dao.AsmCommonDao;

@Service("asmCommonService")
public class AsmCommonService {
	@Autowired
	AsmCommonDao commonDao;

	/**
	 * <pre>
	 * 자동채번
	 * </pre>
	 */
	public String getAutoSeq(Object param) {
		return commonDao.getAutoSeq(param);
	}

}
