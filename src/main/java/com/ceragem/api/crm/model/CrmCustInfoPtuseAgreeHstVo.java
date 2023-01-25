package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import javax.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.ceragem.api.crm.validate.YnValue;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCustInfoPtuseAgreeHstVo
 * @author 김성태
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM고객정보활용동의이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객정보활용동의이력 객체")
public class CrmCustInfoPtuseAgreeHstVo extends ApiBaseVo {
	/**
	 * 정보활용동의이력일련번호
	 */
	@Schema(description = "정보활용동의이력일련번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)

	@MaxByte(max = 30)
	private String infoPtuseAgreeHstSeq;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	@NotEmpty
	private String itgCustNo;
	/**
	 * 동의유형코드 공통코드 : CU080 [001 : 약관 , 002 : 개인정보수집 , 003 : 마켓팅정보수집 , 004 : 제3자제공]
	 */
	@Schema(description = "동의유형코드  [001 : 약관 , 002 : 개인정보수집 , 003 : 마켓팅정보수집 , 004 : 제3자제공]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "CU080", codes = { "001", "002", "003",
			"004" }, message = "[001 : 약관 , 002 : 개인정보수집 , 003 : 마켓팅정보수집 , 004 : 제3자제공] 등록된 코드가 아닙니다. ")
	@NotEmpty
	@MaxByte(max = 3)
	private String agreeTypeCd;

	
	/**
	 * 동의유형코드명
	 */
	@Schema(description = "동의유형코드명")
	private String agreeTypeCdNm;
	
	
	/**
	 * 동의여부
	 */
	@Schema(description = "동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@NotEmpty
	@YnValue
	@MaxByte(max = 1)
	private String agreeYn;

	/**
	 * 약관번호
	 */
	@Schema(description = "약관번호", example = "", hidden = true, required = false, nullable = true)
	private String stpltNo;

	/**
	 * 수신거부유형코드
	 */
	@Schema(description = "수신거부유형코드", example = "", hidden = true, required = false, nullable = true)
	private String rcvRfslTypeCd;
	/**
	 * 수신거부여부
	 */
	@Schema(description = "수신거부여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String rcvRfslYn;

	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;
}
