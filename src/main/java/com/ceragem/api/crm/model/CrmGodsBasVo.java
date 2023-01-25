package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmGodsBasVo
 * @author 김성태
 * @date 2022. 6. 13.
 * @Version 1.0
 * @description CRM제품기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM제품기본 객체")
public class CrmGodsBasVo extends ApiBaseVo {
	/**
	 * 제품번호
	 */
	@Schema(description = "제품번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String godsNo;
	/**
	 * 제품명
	 */
	@Schema(description = "제품명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String godsNm;
	/**
	 * 제품분류코드
	 */
	@Schema(description = "제품분류코드", example = "", hidden = false, required = false, nullable = true, maxLength = 14)
	@MaxByte(max = 14)
	private String godsClassCd;
	/**
	 * 소비자금액
	 */
	@Schema(description = "소비자금액", example = "", hidden = true, required = false, nullable = true)
	private Integer cnsrAmt;
	/**
	 * 사용여부
	 */
	@Schema(description = "사용여부 [Y/N]", example = "N", hidden = true, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String useYn;
	/**
	 * 상품그룹코드
	 */
	@Schema(description = "상품그룹코드", example = "", hidden = true, required = false, nullable = true, maxLength = 5)
	@MaxByte(max = 5)
	private String godsGrpCd;

	@Schema(hidden = true)
	@Override
	public String getRegChlCd() {
		return super.getRegChlCd();
	}
}
