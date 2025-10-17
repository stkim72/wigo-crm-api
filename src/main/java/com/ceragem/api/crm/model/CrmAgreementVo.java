package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmAgreementVo
 * @author 김성태
 * @date 2022. 6. 13.
 * @Version 1.0
 * @description
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객정보활용동의이력 객체")
public class CrmAgreementVo extends ApiBaseVo {
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	@NotEmpty
	private String itgCustNo;

	/**
	 * 약관동의여부
	 */
	@Schema(description = "약관동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String termYn;

	/**
	 * 개인정보수집 동의여부
	 */
	@Schema(description = "개인정보수집 동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String collectYn;

	/**
	 * 제3자제공 동의여부
	 */
	@Schema(description = "마켓팅정보수집 동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String marketingYn;

	/**
	 * 마켓팅정보수집 동의여부
	 */
	@Schema(description = "제3자제공 동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String thirdYn;

	/**
	 * SMS수신동의여부
	 */
	@Schema(description = "SMS수신동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String smsRcvAgreeYn;

	/**
	 * 이메일수신동의여부
	 */
	@Schema(description = "이메일수신동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String emailRcvAgreeYn;

	/**
	 * 알람톡수신동의여부
	 */
	@Schema(description = "알람톡수신동의여부 [Y/N]", example = "N", hidden = true, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String alrmTkRcvAgreeYn;

	/**
	 * PUSH수신동의여부
	 */
	@Schema(description = "PUSH수신동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String pushRcvAgreeYn;

	@Schema(description = "PUSH Token 정보", example = "", hidden = false, required = false, nullable = true, maxLength = 1)
	@MaxByte(max = 1000)
	private String appPushTokn;

	@Schema(description = "앱OS정보 [안드로이드:1, iOs:2, Web: 3]", example = "1", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "MB220", codes = { "1", "2", "3" }, message = "[안드로이드:1, iOs:2, Web: 3] 등록된 코드가 아닙니다.")
	@MaxByte(max = 3)
	private String appPushOsCd;

	@Schema(description = "민감정보 동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String infoAgreeYn;

	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;


	@Schema(description = "체험 정보 동의 여부[Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String exprnInfoAgreeYn;


}
