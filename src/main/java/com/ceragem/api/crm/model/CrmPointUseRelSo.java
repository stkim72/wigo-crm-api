package com.ceragem.api.crm.model;

import java.util.List;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmPointUseRelSo
 * @author    김성태
 * @date    2022. 4. 22.
 * @Version    1.0
 * @description    CRM포인트사용관계 So
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM포인트사용관계 검색 객체")
public class CrmPointUseRelSo extends ApiPagination {
    /**
    * 발생포인트이력일련번호 
    */
    @Parameter(description = "발생포인트이력일련번호", example = "", hidden = true, required = false)
    private String occurPointHstSeq;
    
    private List<CrmPointHstVo> ocurPointHstList;
    /**
    * 사용포인트이력일련번호 
    */
    @Parameter(description = "사용포인트이력일련번호", example = "", hidden = true, required = false)
    private String usePointHstSeq;
    /**
    * 사용금액 
    */
    @Parameter(description = "사용금액", example = "", hidden = true, required = false)
    private Integer useAmt;
    /**
    * 사용포인트점수 
    */
    @Parameter(description = "사용포인트점수", example = "", hidden = true, required = false)
    private Integer usePointScore;
    /**
    * 사용일시 
    */
    @Parameter(description = "사용일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
    private String useDt;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]
    */
    @Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]", example = "", hidden = true, required = false)
    @CodeValue(codeId = "S000", codes = {"CRM","CTC","AS","SAP","test"}, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test] 등록된 코드가 아닙니다. ")
    private String regChlCd;
}
