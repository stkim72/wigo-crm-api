package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import javax.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmAcqieHstVo
 * @author 김성태
 * @date 2022. 8. 17.
 * @Version 1.0
 * @description CRM지인이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM지인이력 객체")
public class CrmAcqieHstVo extends ApiBaseVo {
	/**
	 * 지인이력일련번호
	 */
	@Schema(description = "지인이력일련번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String acqieHstSeq;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	@NotEmpty
	private String itgCustNo;
	/**
	 * 지인통합고객번호
	 */
	@Schema(description = "지인통합고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	@NotEmpty
	private String acqieItgCustNo;
	/**
	 * 계약번호
	 */
//	@Schema(description = "계약번호", example = "", hidden = true, required = false, nullable = true, maxLength = 30)
//	@MaxByte(max = 30)
//	private String cntrtNo;
	/**
	 * 사용유형코드
	 */
//	@Schema(description = "사용유형코드", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
//	@MaxByte(max = 3)
//	private String useTypeCd;
	/**
	 * 지인관계코드 공통코드 : CU330 [001 : 지인]
	 */
//	@Schema(description = "지인관계코드  [001 : 지인]", example = "001", hidden = true, required = false, nullable = true, maxLength = 3)
//	@CodeValue(codeId = "CU330", codes = { "001" }, message = "[001 : 지인] 등록된 코드가 아닙니다. ")
//	@MaxByte(max = 3)
//	private String acqieRelCd;
	
	/**
	 * 지인관계코드 공통코드 : CU330 [001 : 지인]
	 */
//	@Schema(description = "지인관계코드명", hidden = true, required = false, nullable = true, maxLength = 3)
//	private String acqieRelCdNm;
	
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS ,
	 * BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP", "POS", "BOS", "MEM", "CERA", "DNA",
			"IoT" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;
	
	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;
	
	/**
	 * 이동전화번호
	 */
	@Schema(description = "이동전화번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String mphonNo;
	
	/**
	 * 지인명
	 */
//	@Schema(description = "지인명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
//	@MaxByte(max = 100)
//	private String acqieCustNm;
	
	/**
	 * 지인이동전화번호
	 */
//	@Schema(description = "지인이동전화번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
//	@NotEmpty
//	@MaxByte(max = 20)
//	private String acqieMphonNo;
//	
}
