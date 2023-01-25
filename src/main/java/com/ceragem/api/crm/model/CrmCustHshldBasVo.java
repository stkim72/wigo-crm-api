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
 * @ClassName CrmCustHshldBasVo
 * @author 김성태
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM고객가구기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객가구기본 객체")
public class CrmCustHshldBasVo extends ApiBaseVo {
	/**
	 * 대표가구번호
	 */
	@Schema(description = "대표가구번호", example = "CST22041315400401558", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	@NotEmpty
	private String repHshldNo;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "CST22041315400401558", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 사용유형코드 공통코드 : CU070 [001 : 주계약자 , 002 : AS신청자 , 003 : 설치자 , 004 : 지불고객]
	 */
	@Schema(description = "사용유형코드  [001 : 주계약자 , 002 : AS신청자 , 003 : 설치자 , 004 : 지불고객]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "CU070", codes = { "001", "002", "003",
			"004" }, message = "[001 : 주계약자 , 002 : AS신청자 , 003 : 설치자 , 004 : 지불고객] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String useTypeCd;
	@Schema(description = "사용유형코드명",accessMode = AccessMode.READ_ONLY)
	private String useTypeCdNm;
	/**
	 * 가족관계코드 공통코드 : CU040 [001 : 부모 , 002 : 배우자 , 003 : 자녀]
	 */
	@Schema(description = "가족관계코드  [000 : 본인 ,001 : 부모 , 002 : 배우자 , 003 : 자녀]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "CU040", codes = { "000", "001", "002",
			"003" }, message = "[000 : 본인 ,001 : 부모 , 002 : 배우자 , 003 : 자녀] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String famlyRelCd;
	@Schema(description = "가족관계코드명",accessMode = AccessMode.READ_ONLY)
	private String famlyRelCdNm;
	/**
	 * 삭제여부
	 */
	@Schema(description = "삭제여부 [Y/N]", example = "N", hidden = true, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String delYn = "N";
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;

	@Schema(description = "등록채널코드명",accessMode = AccessMode.READ_ONLY)
	private String regChlCdNm;

	@Schema(description = "고객명", accessMode = AccessMode.READ_ONLY)
	private String custNm;

	@Schema(description = "전화번호", accessMode = AccessMode.READ_ONLY)
	private String mphonNo;

	@Schema(description = "암호화 전화번호", accessMode = AccessMode.READ_ONLY)
	private String mphonNoEncVal;

}
