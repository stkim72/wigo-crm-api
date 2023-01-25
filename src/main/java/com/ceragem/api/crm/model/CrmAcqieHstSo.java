package com.ceragem.api.crm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmAcqieHstSo
 * @author 김성태
 * @date 2022. 8. 17.
 * @Version 1.0
 * @description CRM지인이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
//@Schema(description = "CRM지인이력 검색 객체")
public class CrmAcqieHstSo extends ApiPagination {
	/**
	 * 지인이력일련번호
	 */
	@Parameter(description = "지인이력일련번호", example = "", hidden = true, required = false)
	@Schema(description = "지인이력일련번호", example = "", hidden = true, required = false, nullable = true)
	private String acqieHstSeq;
	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = true, required = false)
	@Schema(description = "통합고객번호", example = "", hidden = true, required = false, nullable = true)
	private String itgCustNo;
	/**
	 * 지인통합고객번호
	 */
	@Parameter(description = "지인통합고객번호", example = "", hidden = true, required = false)
	@Schema(description = "지인통합고객번호", example = "", hidden = true, required = false, nullable = true)
	private String acqieItgCustNo;
	/**
	 * 계약번호
	 */
//	@Parameter(description = "계약번호", example = "", hidden = true, required = false)
//	@Schema(description = "계약번호", example = "", hidden = true, required = false, nullable = true)
//	private String cntrtNo;
	/**
	 * 사용유형코드
	 */
//	@Parameter(description = "사용유형코드", example = "", hidden = true, required = false)
//	@Schema(description = "사용유형코드", example = "", hidden = true, required = false, nullable = true)
//	private String useTypeCd;
	/**
	 * 지인관계코드 공통코드 : CU330 [001 : 지인]
	 */
//	@Parameter(description = "지인관계코드  [001 : 지인]", example = "", hidden = true, required = false)
//	@Schema(description = "지인관계코드  [001 : 지인]", example = "", hidden = true, required = false, nullable = true)
//	@CodeValue(codeId = "CU330", codes = { "001" }, message = "[001 : 지인] 등록된 코드가 아닙니다. ")
//	private String acqieRelCd;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS ,
	 * BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]", example = "", hidden = true, required = false)
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]", example = "", hidden = true, required = false, nullable = true)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP", "POS", "BOS", "MEM", "CERA", "DNA",
			"IoT" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT] 등록된 코드가 아닙니다. ")
	private String regChlCd;
}
