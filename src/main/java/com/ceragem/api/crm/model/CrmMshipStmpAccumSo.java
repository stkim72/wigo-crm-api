package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipStmpBasVo
 * @author user
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM멤버십스탬프기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십스탬프적립 객체")
public class CrmMshipStmpAccumSo {
	/**
	 * 매장번호
	 */
	@Parameter(description = "매장번호", example = "", hidden = false, required = true)
	@MaxByte(max = 30)
	private String storNo;
	/**
	 * 채널코드
	 */
	@Parameter(description = "채널코드", example = "", hidden = true, required = true)
	@MaxByte(max = 3)
	@CodeValue(codeId = "ST040", codes = { "9620", "9100", "9200", "9630", "9631", "9560",
			"9561" }, message = "[9620 : 웰카페 , 9100 : CB5 , 9200 : 나비엘 , 9630 : 유통점 , 9631 : 온라인 , 9560 : HC지원팀 , 9561 : HP지원팀] 등록된 매장채널이 아닙니다. ")
	private String chlCd;
	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = false, required = true)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 구매제품번호
	 */
	@Parameter(description = "구매제품번호", example = "", hidden = false, required = true)
	@MaxByte(max = 30)
	private String buyGodsNo;
	/**
	 * 스탬프발행기본번호
	 */
	@Parameter(description = "스탬프발행기본번호", example = "", hidden = false, required = true)
	@NotEmpty
	@MaxByte(max = 30)
	private String mshipStmpBasNo;
	/**
	 * 스탬프기본명
	 */
	@Parameter(description = "스탬프기본명", example = "", hidden = false, required = false)
	@MaxByte(max = 100)
	private String stmpBasNm;
	/**
	 * 스탬프기본명
	 */
	@Parameter(description = "상태명", example = "", hidden = false, required = false)
	@MaxByte(max = 100)
	private String statusNm;
}
