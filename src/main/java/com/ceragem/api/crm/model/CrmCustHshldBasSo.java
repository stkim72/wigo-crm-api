package com.ceragem.api.crm.model;

import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCustHshldBasSo
 * @author 김성태
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM고객가구기본 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객가구기본 검색 객체")
public class CrmCustHshldBasSo extends CrmSnstvInfoInqrySo {
	/**
	 * 대표가구번호
	 */
	@Parameter(description = "대표가구번호", example = "CST22041315400401558", hidden = false, required = false)
	private String repHshldNo;
	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "CST22041315400401558", hidden = false, required = false)
	private String itgCustNo;
	/**
	 * 사용유형코드 공통코드 : CU070 [001 : 주계약자 , 002 : AS신청자 , 003 : 설치자 , 004 : 지불고객]
	 */
	@Parameter(description = "사용유형코드  [001 : 주계약자 , 002 : AS신청자 , 003 : 설치자 , 004 : 지불고객]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "CU070", codes = { "001", "002", "003",
			"004" }, message = "[001 : 주계약자 , 002 : AS신청자 , 003 : 설치자 , 004 : 지불고객] 등록된 코드가 아닙니다. ")
	private String useTypeCd;
	/**
	 * 가족관계코드 공통코드 : CU040 [000 : 본인 ,001 : 부모 , 002 : 배우자 , 003 : 자녀]
	 */
	@Parameter(description = "가족관계코드  [000: 본인, 001 : 부모 , 002 : 배우자 , 003 : 자녀]", example = "000", hidden = false, required = false)
	@CodeValue(codeId = "CU040", codes = { "000", "001", "002",
			"003" }, message = "[000 : 본인 ,001 : 부모 , 002 : 배우자 , 003 : 자녀] 등록된 코드가 아닙니다. ")
	private String famlyRelCd;
	/**
	 * 삭제여부
	 */
	@Parameter(description = "삭제여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String delYn = "N";
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	private String regChlCd;
}
