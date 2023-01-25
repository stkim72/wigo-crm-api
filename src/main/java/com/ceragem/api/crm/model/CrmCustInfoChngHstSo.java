package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustInfoChngHstSo
 * @author    김성태
 * @date    2022. 4. 21.
 * @Version    1.0
 * @description    CRM고객정보변경이력 So
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객정보변경이력 검색 객체")
public class CrmCustInfoChngHstSo extends ApiPagination {
    /**
    * 고객정보변경이력일련번호 
    */
    @Parameter(description = "고객정보변경이력일련번호", example = "", hidden = true, required = false)
    private String custInfoChngHstSeq;
    /**
    * 통합고객번호 
    */
    @Parameter(description = "통합고객번호", example = "", hidden = true, required = false)
    private String itgCustNo;
    /**
    * 변경항목내용 
    */
    @Parameter(description = "변경항목내용", example = "", hidden = true, required = false)
    private String chngClusCtnts;
    /**
    * 변경사유내용 
    */
    @Parameter(description = "변경사유내용", example = "", hidden = true, required = false)
    private String chngWhyCtnts;
    /**
    * 보존기간 
    */
    @Parameter(description = "보존기간", example = "", hidden = true, required = false)
    private String keepPerd;
    /**
    * 변경전내용 
    */
    @Parameter(description = "변경전내용", example = "", hidden = true, required = false)
    private String chngPreCtnts;
    /**
    * 변경내용 
    */
    @Parameter(description = "변경내용", example = "", hidden = true, required = false)
    private String chngCtnts;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
    */
    @Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
    @CodeValue(codeId = "S000", codes = {"CRM","CTC","AS","SAP"}, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
    private String regChlCd;
}
