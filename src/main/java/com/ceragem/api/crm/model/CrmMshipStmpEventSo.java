package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

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
@Schema(description = "CRM멤버십스탬프이벤트 객체")
public class CrmMshipStmpEventSo extends ApiBaseVo {
	/**
	 * 스탬프발행기본번호
	 */
	@Parameter(description = "스탬프발행기본번호", example = "", hidden = true, required = false)
	private String mshipStmpBasNo;
	/**
	 * 스탬프기본명
	 */
	@Parameter(description = "스탬프기본명", example = "", hidden = true, required = false)
	private String stmpBasNm;
	/**
	 * 스탬프유형코드
	 */
	@Parameter(description = "스탬프유형코드", example = "", hidden = true, required = false)
	private String stmpTypeCd;
	/**
	 * 스탬프이벤트코드
	 */
	@Parameter(description = "스탬프이벤트코드", example = "", hidden = true, required = false)
	private String stmpEventCd;
	/**
	 * FROM사용가능일시
	 */
	@Parameter(description = "FROM사용가능일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String fromUsePossDt;
	/**
	 * TO사용가능일시
	 */
	@Parameter(description = "TO사용가능일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String toUsePossDt;
	/**
	 * 스탬프최대여부
	 */
	@Parameter(description = "스탬프최대여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String stmpMaxYn;
	/**
	 * 스탬프최대수
	 */
	@Parameter(description = "스탬프최대수", example = "", hidden = true, required = false)
	private Integer stmpMaxCnt;
	/**
	 * 스탬프수량
	 */
	@Parameter(description = "스탬프수량", example = "", hidden = true, required = false)
	private Integer stmpQnty;
	/**
	 * 매장번호
	 */
	@Parameter(description = "매장번호", example = "", hidden = false, required = true)
	@MaxByte(max = 30)
	private String storNo;
	/**
	 * 채널코드
	 */
	@Parameter(description = "채널코드", example = "", hidden = false, required = true)
	@MaxByte(max = 4)
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
	 * 적립수
	 */
//	@Parameter(description = "적립수", example = "", hidden = true, required = false)
//	private Integer accumCnt;

}
