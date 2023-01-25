package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustPatronStorBasSo
 * @author    김성태
 * @date    2022. 5. 16.
 * @Version    1.0
 * @description    CRM고객단골매장기본 So
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객단골매장기본 검색 객체")
public class CrmCustPatronStorBasSo extends ApiPagination {
    /**
    * 단골매장일련번호 
    */
    @Parameter(description = "단골매장일련번호", example = "", hidden = true, required = false)
    private String patronStorSeq;
    /**
    * 통합고객번호 
    */
    @Parameter(description = "통합고객번호", example = "", hidden = true, required = false)
    private String itgCustNo;
    /**
    * 매장번호 
    */
    @Parameter(description = "매장번호", example = "", hidden = true, required = false)
    private String storNo;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    @Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
    @CodeValue(codeId = "S000", codes = {"CRM","CTC","AS","SAP","POS"}, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
    private String regChlCd;
}
