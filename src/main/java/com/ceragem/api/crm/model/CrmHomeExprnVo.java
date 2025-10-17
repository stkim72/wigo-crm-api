package com.ceragem.api.crm.model;

import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Schema(description = "CRM홈체험이력 객체")
public class CrmHomeExprnVo {

    @Schema(description = "순번", example = "", hidden = true, required = true, nullable = false, maxLength = 30)
    @MaxByte(max = 30)
    private String exprnNo;

    @Schema(description = "신청자명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
    @MaxByte(max = 100)
    @NotEmpty
    private String custNm;

    @Schema(description = "연락처", example = "", hidden = false, required = true, nullable = false, maxLength = 88)
    @MaxByte(max = 88)
    @NotEmpty
    @Pattern(regexp = "^[0-9]*$", message = "전화번호는 숫자만 가능합니다")
    private String mphonNo;

    @Schema(description = "지역 (서울, 경기, 인천)", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
    @MaxByte(max = 1000)
    @NotEmpty
    private String addr1Ctnts;

    @Schema(description = "구/시/군", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
    @MaxByte(max = 1000)
    @NotEmpty
    private String addr2Ctnts;

    @Schema(description = "내용", example = "", hidden = false, required = false, nullable = true, maxLength = 4000)
    @MaxByte(max = 4000)
    private String rmark;

    @Schema(description = "마케팅 수신동의 [Y/N]", example = "Y", hidden = false, required = true, nullable = false, maxLength = 1)
    @MaxByte(max = 1)
    @NotEmpty
    private String agreeYn;

    @Schema(description = "서비스타입 (HOMESERVICE 고정)", example = "HOMESERVICE", hidden = true, required = true, nullable = false, maxLength = 100)
    @MaxByte(max = 100)
    private String itemNm;

    @Schema(description = "신청상태 (상담대기 고정)", example = "상담대기", hidden = true, required = true, nullable = false, maxLength = 100)
    @MaxByte(max = 100)
    private String statusCdNm;

    @Schema(description = "Pc, Mobile 구분", example = "Pc", hidden = false, required = true, nullable = false, maxLength = 20)
    @MaxByte(max = 20)
    @NotEmpty
    private String tgtAppId;

    @Schema(description = "접속 IP", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
    @MaxByte(max = 100)
    private String ipAddr;

    @Schema(description = "reCaptcha 점수", example = "", hidden = false, required = true, nullable = true, maxLength = 30)
    @MaxByte(max = 30)
    private String pointScore;

    @Schema(description = "신청일", example = "", hidden = true, required = true, nullable = false)
    private String regDt;

}
