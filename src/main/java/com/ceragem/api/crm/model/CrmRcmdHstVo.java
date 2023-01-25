package com.ceragem.api.crm.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmRcmdHstVo
 * @author    user
 * @date    2022. 8. 18.
 * @Version    1.0
 * @description    CRM추천인 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmRcmdHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 추천인이력일련번호 
    */
    private String rcmdrHstSeq;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 추천인고객번호 
    */
    private String rcmdrCustNo;
    /**
    * 추천임직원번호 
    */
    private String rcmdExecvdempNo;
    /**
    * 추천매장번호 
    */
    private String rcmdStorNo;
    /**
    * 추천유형코드 
    */
    private String rcmdTypeCd;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]
    */
    private String regChlCd;
}
