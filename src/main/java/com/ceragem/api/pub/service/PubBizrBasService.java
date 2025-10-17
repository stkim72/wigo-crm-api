package com.ceragem.api.pub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmFileVo;
import com.ceragem.api.crm.service.CrmFileService;
import com.ceragem.api.pub.dao.PubBizrBasDao;
import com.ceragem.api.pub.model.PubBizrBasSo2;
import com.ceragem.api.pub.model.PubBizrBasVo;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

/**
 * 
 * @ClassName PubBusinessBasService
 * @author user
 * @date 2023. 5. 5.
 * @Version 1.0
 * @description 공유사업자 기본정보 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class PubBizrBasService extends AbstractCrmService {
	@Autowired
	PubBizrBasDao dao;

	@Autowired
	CrmFileService fileService;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public List<CrmCustVo> getCustList(EzMap param) {
		return dao.getCustList(param);
	}

	public int insertPubMem(PubBizrBasSo2 insVo) {
		return dao.insertPubMem(insVo);
	}

	public PubBizrBasSo2 selectChkPub(EzMap param) {
		return dao.selectChkPub(param);
	}

	public int selectChkWlng(PubBizrBasVo vo) {
		return dao.selectChkWlng(vo);
	}

	public int getCustListCount(EzMap param) {
		return dao.getCustListCount(param);
	}

	public CrmFileVo uploadFile(MultipartFile uploadfile, EzMap param) throws Exception {
//		String pubBizrBasNo = param.getString("pubBizrBasNo");
		String type = param.getString("type");
		if (!"001".equals(type) && !"002".equals(type)) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "유형은 [001:사업자등록증, 002:통장사본]만 가능합니다.");
		}
		PubBizrBasVo vo = dao.select(param);
		if (vo == null) {
			throw new EzApiException(Constants._API_CODE_INVALID_PARAM, "존재하지 않는 공유사업자 번호입니다.");
		}
		CrmFileVo fileVo = new CrmFileVo();
		fileVo.setFileOdrg(1);
		boolean isNullFileCd = false;
		// bizrFileCd
		// bankFileCd
		if ("001".equals(type)) {
			fileVo.setFileCd(vo.getBizrFileCd());
		} else {
			fileVo.setFileCd(vo.getBankFileCd());
		}
		if (Utilities.isEmpty(fileVo.getFileCd())) {
			fileVo.setFileCd(Utilities.getAutoSeq("PUB"));
			isNullFileCd = true;
			if ("001".equals(type)) {
				vo.setBizrFileCd(fileVo.getFileCd());
			} else {
				vo.setBankFileCd(fileVo.getFileCd());
			}
		}
		CrmFileVo result = fileService.uploadFile(uploadfile, fileVo);
		if (isNullFileCd) {
			dao.updateFileCd(vo);
		}
		return result;
	}
}
