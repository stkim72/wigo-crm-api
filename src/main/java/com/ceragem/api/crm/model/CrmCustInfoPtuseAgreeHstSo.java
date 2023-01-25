package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCustInfoPtuseAgreeHstSo
 * @author 김성태
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM고객정보활용동의이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객정보활용동의이력 검색 객체")
public class CrmCustInfoPtuseAgreeHstSo extends ApiPagination {
	/**
	 * 정보활용동의이력일련번호
	 */
	@Parameter(description = "정보활용동의이력일련번호", example = "", hidden = true, required = false)
	private String infoPtuseAgreeHstSeq;
	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = true, required = false)
	private String itgCustNo;
	/**
	 * 동의유형코드 공통코드 : CU080 [001 : 약관 , 002 : 개인정보수집 , 003 : 마켓팅정보수집 , 004 : 제3자제공]
	 */
	@Parameter(description = "동의유형코드  [001 : 약관 , 002 : 개인정보수집 , 003 : 마켓팅정보수집 , 004 : 제3자제공]", example = "001", hidden = true, required = false)
	@CodeValue(codeId = "CU080", codes = { "001", "002", "003",
			"004" }, message = "[001 : 약관 , 002 : 개인정보수집 , 003 : 마켓팅정보수집 , 004 : 제3자제공] 등록된 코드가 아닙니다. ")
	private String agreeTypeCd;
	/**
	 * 약관번호
	 */
	@Parameter(description = "약관번호", example = "", hidden = true, required = false)
	private String stpltNo;
	/**
	 * 동의여부
	 */
	@Parameter(description = "동의여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String agreeYn;

	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;
}
