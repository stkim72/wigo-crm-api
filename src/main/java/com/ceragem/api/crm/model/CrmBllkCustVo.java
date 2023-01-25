package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmBllkCustHstVo
 * @author 김성태
 * @date 2022. 4. 15.
 * @Version 1.0
 * @description CRM주의고객이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM주의고객이력 객체")
public class CrmBllkCustVo extends ApiBaseVo {
	/**
	 * 주의고객이력일련번호
	 */
	@Schema(description = "주의고객이력일련번호 [자동생성]", example = "CBL202201011212121234", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String bllkCustHstSeq;

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "CST22041210355401087", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;

	/**
	 * 주의고객등록사유코드 공통코드 : CU320 [001 : 구매취소 2회 이상 , 002 : 상습컴플레인 3회 이상 , 003 : 폭언 및 욕설
	 * 2회 이상 , 999 : 기타]
	 */
	@Schema(description = "주의고객등록사유코드  [001 : 구매취소 2회 이상 , 002 : 상습컴플레인 3회 이상 , 003 : 폭언 및 욕설 2회 이상 , 999 : 기타]", example = "001", hidden = false, required = true, nullable = false, maxLength = 3)
	@CodeValue(codeId = "CU320", codes = { "001", "002", "003",
			"999" }, message = "[001 : 구매취소 2회 이상 , 002 : 상습컴플레인 3회 이상 , 003 : 폭언 및 욕설 2회 이상 , 999 : 기타] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	@NotEmpty
	private String bllkRegWhyCd;

	@Schema(description = "주의고객등록사유코드명",accessMode = AccessMode.READ_ONLY)
	private String bllkRegWhyCdNm;
	/**
	 * 주의고객등록사유내용
	 */
	@Schema(description = "주의고객등록사유내용", example = "등록할 사유를 여기 적습니다.", hidden = false, required = true, nullable = false, maxLength = 4000)
	@MaxByte(max = 4000)
	@NotEmpty
	private String bllkRegWhyCtnts;
	/**
	 * 매장번호
	 */
	@Schema(description = "매장번호", example = "A100000001", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String storNo;

	@Schema(description = "매장명", example = "", hidden = false, required = false, nullable = true,accessMode = AccessMode.READ_ONLY)
	private String storNoNm;

	/**
	 * 삭제여부
	 */
	@Schema(description = "삭제여부 [Y/N]", example = "N", hidden = true, required = true, nullable = false, maxLength = 1, accessMode = AccessMode.READ_ONLY)
	@YnValue
	@MaxByte(max = 1)
	private String delYn;
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
}
