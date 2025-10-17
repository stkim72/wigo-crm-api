package com.ceragem.api.crm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.YnValue;
import com.ceragem.api.crm.validate.CodeValue;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmMshipAppToknBasSo
 * @author    김성태
 * @date    2023. 5. 26.
 * @Version    1.0
 * @description    멤버십앱토큰기본 So
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "멤버십앱토큰기본 검색 객체")
public class CrmMshipAppToknBasSo extends ApiPagination {
    /**
    * 앱PUSH토큰 
    */
    @Parameter(description = "앱PUSH토큰", example = "", hidden = true, required = false)
    @Schema(description = "앱PUSH토큰", example = "", hidden = true, required = false, nullable = true)
    private String appPushTokn;
    /**
    * 앱PUSHOS코드 
    */
    @Parameter(description = "앱PUSHOS코드", example = "", hidden = true, required = false)
    @Schema(description = "앱PUSHOS코드", example = "", hidden = true, required = false, nullable = true)
    private String appPushOsCd;
    /**
    * 통합고객번호 
    */
    @Parameter(description = "통합고객번호", example = "", hidden = true, required = false)
    @Schema(description = "통합고객번호", example = "", hidden = true, required = false, nullable = true)
    private String itgCustNo;
    /**
    * 동의여부 
    */
    @Parameter(description = "동의여부 [Y/N]", example = "", hidden = true, required = false)
    @Schema(description = "동의여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
    @YnValue
    private String agreeYn;
    /**
    * 동의일시 
    */
    @Parameter(description = "동의일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
    @Schema(description = "동의일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false, nullable = true)
    private String agreeDt;
    /**
    * 거부일시 
    */
    @Parameter(description = "거부일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
    @Schema(description = "거부일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false, nullable = true)
    private String rfslDt;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT , PRC : 부모님연구소 , EON : 발송 , COM : 직영몰 , PUB : 공유사업자]
    */
    @Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT , PRC : 부모님연구소 , EON : 발송 , COM : 직영몰 , PUB : 공유사업자]", example = "", hidden = true, required = false)
    @Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT , PRC : 부모님연구소 , EON : 발송 , COM : 직영몰 , PUB : 공유사업자]", example = "", hidden = true, required = false, nullable = true)
    @CodeValue(codeId = "S000", codes = {"CRM","CTC","AS","SAP","POS","BOS","MEM","CRA","DNA","IoT","PRC","EON","COM","PUB"}, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT , PRC : 부모님연구소 , EON : 발송 , COM : 직영몰 , PUB : 공유사업자] 등록된 코드가 아닙니다. ")
    private String regChlCd;
}
