package com.ceragem.api.crm.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmPointGodsHstVo
 * @author    user
 * @date    2022. 5. 23.
 * @Version    1.0
 * @description    구매상품별포인트히스토리 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmPointGodsHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 구매일련번호 
    */
    private String buySeq;
    /**
    * 전표번호 
    */
    private String chitNo;
    /**
    * 통합회원번호 
    */
    private String itgCustNo;
    /**
    * 구매제품번호 
    */
    private String buyGodsNo;
    /**
    * 구매포인트점수 
    */
    private Integer buyAccumPointScore;
    /**
    * 구매추천포인트승급점수 
    */
    private Integer buyRcmdPointScore;
    /**
    * 구매보상승급점수 
    */
    private Integer buyRewardAdvncmtScore;
    /**
    * 구매추천보상승급점수 
    */
    private Integer buyRcmdRewardAdvncmtScore;
}
