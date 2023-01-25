package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import javax.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmStorBasVo
 * @author    김성태
 * @date    2022. 5. 24.
 * @Version    1.0
 * @description    CRM매장기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM매장기본 객체")
public class CrmStorBasVo extends ApiBaseVo {
    /**
    * 매장번호 
    */
    @Schema(description = "매장번호", example = "", hidden = false, required = true, nullable = false , maxLength=30)
    @NotEmpty
    @MaxByte(max=30)
    private String storNo;
    /**
    * 매장명 
    */
    @Schema(description = "매장명", example = "", hidden = false, required = false, nullable = true , maxLength=100)
    @MaxByte(max=100)
    private String storNm;
    /**
    * 전화번호 
    */
    @Schema(description = "전화번호", example = "", hidden = false, required = false, nullable = true , maxLength=20)
    @MaxByte(max=20)
    private String telNo;
    /**
    * 우편번호 
    */
    @Schema(description = "우편번호", example = "", hidden = false, required = false, nullable = true , maxLength=5)
    @MaxByte(max=5)
    private String zipCd;
    /**
    * 주소1내용 
    */
    @Schema(description = "주소1내용", example = "", hidden = false, required = false, nullable = true , maxLength=1000)
    @MaxByte(max=1000)
    private String addr1Ctnts;
    /**
    * 주소2내용 
    */
    @Schema(description = "주소2내용", example = "", hidden = false, required = false, nullable = true , maxLength=1000)
    @MaxByte(max=1000)
    private String addr2Ctnts;
    /**
    * 위도 
    */
    @Schema(description = "위도", example = "", hidden = false, required = false, nullable = true , maxLength=30)
    @MaxByte(max=30)
    private String lati;
    /**
    * 경도 
    */
    @Schema(description = "경도", example = "", hidden = false, required = false, nullable = true , maxLength=30)
    @MaxByte(max=30)
    private String longi;
    /**
    * 지역코드 
    */
    @Schema(description = "지역코드", example = "", hidden = false, required = false, nullable = true , maxLength=3)
    @MaxByte(max=3)
    private String distrctCd;
    /**
    * 시작시간 
    */
    @Schema(description = "시작시간", example = "", hidden = false, required = false, nullable = true , maxLength=4)
    @MaxByte(max=4)
    private String staHour;
    /**
    * 종료시간 
    */
    @Schema(description = "종료시간", example = "", hidden = false, required = false, nullable = true , maxLength=4)
    @MaxByte(max=4)
    private String endHour;
    /**
    * 사업자등록번호 
    */
    @Schema(description = "사업자등록번호", example = "", hidden = false, required = false, nullable = true , maxLength=10)
    @MaxByte(max=10)
    private String bizNo;
    /**
    * 오픈일자 
    */
    @Schema(description = "오픈일자", example = "", hidden = false, required = false, nullable = true , maxLength=8)
    @MaxByte(max=8)
    private String openDate;
    /**
    * POS매장번호 
    */
    @Schema(description = "POS매장번호", example = "", hidden = false, required = false, nullable = true , maxLength=30)
    @MaxByte(max=30)
    private String posStorNo;
    /**
    * 매장채널코드 
    */
    @Schema(description = "매장채널코드", example = "", hidden = false, required = false, nullable = true , maxLength=10)
    @MaxByte(max=10)
    private String storChlCd;
    /**
    * 매장구분코드 
    */
    @Schema(description = "매장구분코드", example = "", hidden = false, required = false, nullable = true , maxLength=3)
    @MaxByte(max=3)
    private String storDivCd;
    /**
    * 매장유형코드 
    */
    @Schema(description = "매장유형코드", example = "", hidden = false, required = false, nullable = true , maxLength=3)
    @MaxByte(max=3)
    private String storTypeCd;
    /**
    * 매장상태코드 
    */
    @Schema(description = "매장상태코드", example = "", hidden = false, required = false, nullable = true , maxLength=3)
    @MaxByte(max=3)
    private String storStatusCd;
    /**
    * 메모내용 
    */
    @Schema(description = "메모내용", example = "", hidden = false, required = false, nullable = true , maxLength=4000)
    @MaxByte(max=4000)
    private String memoCtnts;
    /**
    * 상태코드 
    */
    @Schema(description = "상태코드", example = "", hidden = false, required = false, nullable = true , maxLength=3)
    @MaxByte(max=3)
    private String statusCd;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    @Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "CRM", hidden = false, required = false, nullable = true , maxLength=3)
    @CodeValue(codeId = "S000", codes = {"CRM","CTC","AS","SAP","POS"}, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
    @MaxByte(max=3)
    private String regChlCd;
}
