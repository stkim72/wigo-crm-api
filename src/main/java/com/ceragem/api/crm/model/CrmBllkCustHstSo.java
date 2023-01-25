package com.ceragem.api.crm.model;

import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmBllkCustHstSo
 * @author 김성태
 * @date 2022. 4. 15.
 * @Version 1.0
 * @description CRM주의고객이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM주의고객이력 검색 객체")
public class CrmBllkCustHstSo extends CrmSnstvInfoInqrySo {
	/**
	 * 주의고객이력일련번호
	 */
	@Parameter(description = "주의고객이력일련번호", example = "CBL202201011212121234", hidden = false, required = false)
	private String bllkCustHstSeq;
	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "CST22041410024201688", hidden = false, required = false)
	private String itgCustNo;
	/**
	 * 주의고객등록사유코드 공통코드 : CU320 [001 : 구매취소 2회 이상 , 002 : 상습컴플레인 3회 이상 , 003 : 폭언 및 욕설
	 * 2회 이상 , 999 : 기타]
	 */
	@Parameter(description = "주의고객등록사유코드  [001 : 구매취소 2회 이상 , 002 : 상습컴플레인 3회 이상 , 003 : 폭언 및 욕설 2회 이상 , 999 : 기타]", example = "", hidden = false, required = false)
	@CodeValue(codeId = "CU320", codes = { "001", "002", "003",
			"999" }, message = "[001 : 구매취소 2회 이상 , 002 : 상습컴플레인 3회 이상 , 003 : 폭언 및 욕설 2회 이상 , 999 : 기타] 등록된 코드가 아닙니다. ")
	private String bllkRegWhyCd;
	/**
	 * 주의고객등록사유내용
	 */
	@Parameter(description = "주의고객등록사유내용", example = "", hidden = true, required = false)
	private String bllkRegWhyCtnts;
	/**
	 * 매장번호
	 */
	@Parameter(description = "매장번호", example = "A10000001", hidden = true, required = false)
	private String storNo;
	/**
	 * 삭제여부
	 */
	@Parameter(description = "삭제여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String delYn="N";
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	private String regChlCd;
}
