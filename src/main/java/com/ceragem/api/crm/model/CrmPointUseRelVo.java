package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import javax.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmPointUseRelVo
 * @author    김성태
 * @date    2022. 4. 22.
 * @Version    1.0
 * @description    CRM포인트사용관계 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM포인트사용관계 객체")
public class CrmPointUseRelVo extends ApiBaseVo {
    /**
    * 발생포인트이력일련번호 
    */
    @Schema(description = "발생포인트이력일련번호", example = "", hidden = false, required = true, nullable = false , maxLength=30)
    @NotEmpty
    @MaxByte(max=30)
    private String occurPointHstSeq;
    /**
    * 사용포인트이력일련번호 
    */
    @Schema(description = "사용포인트이력일련번호", example = "", hidden = false, required = true, nullable = false , maxLength=30)
    @NotEmpty
    @MaxByte(max=30)
    private String usePointHstSeq;
    /**
    * 사용금액 
    */
    @Schema(description = "사용금액", example = "", hidden = false, required = false, nullable = true)
    private Integer useAmt;
    /**
    * 사용포인트점수 
    */
    @Schema(description = "사용포인트점수", example = "", hidden = false, required = false, nullable = true)
    private Integer usePointScore;
    /**
    * 사용일시 
    */
    @Schema(description = "사용일시 (YYYYMMDDHH24MISS)", example = "20220422105714", hidden = false, required = false, nullable = true)
    @DatetimeValue
    private String useDt;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]
    */
    @Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]", example = "CRM", hidden = false, required = false, nullable = true , maxLength=3)
    @CodeValue(codeId = "S000", codes = {"CRM","CTC","AS","SAP","test"}, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test] 등록된 코드가 아닙니다. ")
    @MaxByte(max=3)
    private String regChlCd;
}
