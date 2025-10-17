package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipPlcyGodsRelVo
 * @author 김성태
 * @date 2023. 4. 19.
 * @Version 1.0
 * @description 멤버십정책제품관계 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "멤버십정책제품관계 객체")
@Hidden
public class CrmPointExceptVo extends ApiBaseVo {
	/**
	 * 정책제품관계ID
	 */
	@Schema(description = "정책제품관계ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String plcyGodsRelId;
	/**
	 * 멤버십정책기본번호
	 */
	@Schema(description = "멤버십정책기본번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String mshipPlcyBasNo;
	/**
	 * 제품유형코드
	 */
	@Schema(description = "제품유형코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	@MaxByte(max = 10)
	private String godsTypeCd;
	/**
	 * 제품분류코드
	 */
	@Schema(description = "제품분류코드", example = "", hidden = false, required = false, nullable = true, maxLength = 14)
	@MaxByte(max = 14)
	private String godsClassCd;
	/**
	 * 제품번호
	 */
	@Schema(description = "제품번호", example = "", hidden = false, required = false, nullable = true, maxLength = 14)
	@MaxByte(max = 14)
	private String godsNo;
	/**
	 * 구매적립유형코드
	 */
	@Schema(description = "구매적립유형코드", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	@MaxByte(max = 3)
	private String buyAccumTypeCd;
	/**
	 * 구매적립포인트율
	 */
	@Schema(description = "구매적립포인트율", example = "", hidden = false, required = false, nullable = true)
	private Double buyAccumPointRate;
	/**
	 * 구매적립포인트점수
	 */
	@Schema(description = "구매적립포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer buyAccumPointScore;
	/**
	 * 채널코드
	 */
	@Schema(description = "채널코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String chlCd;

	/**
	 * 멤버십구분 임직원/제휴/회원
	 */
	@Schema(description = "회원구분(임직원/제휴/회원)", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String mshipGradeCd;
	/**
	 * 멤버십등급 화이트/골드
	 */
	@Schema(description = "멤버십등급", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String mshpGradeCd;
	/**
	 * 멤버십정책명
	 */
	@Schema(description = "멤버십정책명", example = "", hidden = false, required = false, nullable = true)
	private String mshipPlcyNm;
	/**
	 * 제품명
	 */
	@Schema(description = "제품명", example = "", hidden = false, required = false, nullable = true)
	private String godsNm;
}
