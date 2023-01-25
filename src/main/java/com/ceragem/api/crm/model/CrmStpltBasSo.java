package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DateValue;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmStpltBasSo
 * @author 김성태
 * @date 2022. 5. 23.
 * @Version 1.0
 * @description CRM약관기본 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM약관기본 검색 객체")
public class CrmStpltBasSo extends ApiPagination {
	/**
	 * 약관번호
	 */
	@Parameter(description = "약관번호", example = "", hidden = false, required = false)
	private String stpltNo;
	/**
	 * 약관명
	 */
	@Parameter(description = "약관명", example = "", hidden = true, required = false)
	private String stpltNm;
	/**
	 * 약관유형코드 공통코드 : CU310 [001 : 개인정보 수집 및 이용 동의 , 002 : 개인정보 제3자 제공 동의 , 003 :
	 * 마케팅을 위한 개인정보 수집 및 이용 동의 , 004 : 광고성 정보 수신 동의(이메일, SMS, PUSH)]
	 */
	@Parameter(description = "약관유형코드  [001 : 개인정보 수집 및 이용 동의 , 002 : 개인정보 제3자 제공 동의 , 003 : 마케팅을 위한 개인정보 수집 및 이용 동의 , 004 : 광고성 정보 수신 동의(이메일, SMS, PUSH)]", example = "", hidden = false, required = false)
	@CodeValue(codeId = "CU310", codes = { "001", "002", "003",
			"004" }, message = "[001 : 개인정보 수집 및 이용 동의 , 002 : 개인정보 제3자 제공 동의 , 003 : 마케팅을 위한 개인정보 수집 및 이용 동의 , 004 : 광고성 정보 수신 동의(이메일, SMS, PUSH)] 등록된 코드가 아닙니다. ")
	private String stpltTypeCd;
	/**
	 * 약관내용
	 */
	@Parameter(description = "약관내용", example = "", hidden = true, required = false)
	private String stpltCtnts;
	/**
	 * 약관시작년월일
	 */
	@Parameter(description = "약관시작년월일", example = "", hidden = true, required = false)
	private String stpltStaYmd;
	/**
	 * 약관종료년월일
	 */
	@Parameter(description = "약관종료년월일", example = "", hidden = true, required = false)
	private String stpltEndYmd;
	/**
	 * 사용여부
	 */
	@Parameter(description = "사용여부 [Y/N]", example = "", hidden = false, required = false)
	@YnValue
	private String useYn = "Y";
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;
	
	@Parameter(description = "검색기준일", hidden = false)
	@DateValue
	private String stdYmd;
}
