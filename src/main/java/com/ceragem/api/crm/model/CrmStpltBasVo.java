package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import javax.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

import com.ceragem.api.crm.validate.YnValue;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmStpltBasVo
 * @author 김성태
 * @date 2022. 5. 23.
 * @Version 1.0
 * @description CRM약관기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM약관기본 객체")
public class CrmStpltBasVo extends ApiBaseVo {
	/**
	 * 약관번호
	 */
	@Schema(description = "약관번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String stpltNo;
	/**
	 * 약관명
	 */
	@Schema(description = "약관명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String stpltNm;
	/**
	 * 약관유형코드 공통코드 : CU310 [001 : 개인정보 수집 및 이용 동의 , 002 : 개인정보 제3자 제공 동의 , 003 :
	 * 마케팅을 위한 개인정보 수집 및 이용 동의 , 004 : 광고성 정보 수신 동의(이메일, SMS, PUSH)]
	 */
	@Schema(description = "약관유형코드  [001 : 개인정보 수집 및 이용 동의 , 002 : 개인정보 제3자 제공 동의 , 003 : 마케팅을 위한 개인정보 수집 및 이용 동의 , 004 : 광고성 정보 수신 동의(이메일, SMS, PUSH)]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "CU310", codes = { "001", "002", "003",
			"004" }, message = "[001 : 개인정보 수집 및 이용 동의 , 002 : 개인정보 제3자 제공 동의 , 003 : 마케팅을 위한 개인정보 수집 및 이용 동의 , 004 : 광고성 정보 수신 동의(이메일, SMS, PUSH)] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String stpltTypeCd;

	/*
	 * 약관유형명
	 */
	@Schema(description = "약관명", example = "", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String stpltTypeCdNm;
	/**
	 * 약관내용
	 */
	@Schema(description = "약관내용", example = "", hidden = false, required = false, nullable = true)
	private String stpltCtnts;
	/**
	 * 약관시작년월일
	 */
	@Schema(description = "약관시작년월일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String stpltStaYmd;
	/**
	 * 약관종료년월일
	 */
	@Schema(description = "약관종료년월일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String stpltEndYmd;
	/**
	 * 사용여부
	 */
	@Schema(description = "사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String useYn;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;
}
