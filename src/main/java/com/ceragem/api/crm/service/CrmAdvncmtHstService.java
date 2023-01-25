package com.ceragem.api.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.crm.dao.CrmAdvncmtHstDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmAdvncmtHstVo;
import com.ceragem.api.crm.model.CrmPointHstVo;

/**
 * 
 * @ClassName    CrmAdvncmtHstService
 * @author    user
 * @date    2022. 5. 23.
 * @Version    1.0
 * @description    CRM승급이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmAdvncmtHstService extends AbstractCrmService {
	
//	private final static String ADVNCMT_001 = "001"; /* 구매점수 */
//	private final static String ADVNCMT_002 = "002"; /* 구매추천점수 */
//	private final static String ADVNCMT_003 = "003"; /* 웰카페체험점수 */
//	private final static String ADVNCMT_004 = "004"; /* 홈체험추천점수 */
//	private final static String ADVNCMT_005 = "005"; /* 웰카페체험추천점수 */
//	private final static String ADVNCMT_010 = "010"; /* 가입추천점수 */
//	private final static String ADVNCMT_016 = "016"; /* IOT 점수 */
	
	
	
   @Autowired
   CrmAdvncmtHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }

    // 등급점수 등록
	public int insertAdVnCmt(CrmPointHstVo vo) {
		
		CrmAdvncmtHstVo hstVo = new CrmAdvncmtHstVo();
		hstVo.setItgCustNo( vo.getItgCustNo()  );		
		CrmAdvncmtHstVo pInfo = dao.selectAdvnCmtInfo(hstVo);	
		
		vo.setRemainAdvncmtScore( vo.getOccurAdvncmtScore() + pInfo.getTotalAdvnCmt() );		
		return dao.insert(vo);
		
	}
	

    // 등급점수 등록
	public int insertAdVnCmt(CrmAdvncmtHstVo hstVo) {
			
//		CrmAdvncmtHstVo pInfo = dao.selectAdvnCmtInfo(hstVo);		
		return dao.insert(hstVo);
		
	}

	public List<CrmAdvncmtHstVo> selectAdvnCmt(CrmPointHstVo vo) {
		return dao.selectAdvnCmt(vo);
	}
	   

}
