package com.ceragem.api.crm.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;

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
public class CrmMshipStmpAccumVo extends ApiBaseVo {
	/**
	 * 매장번호
	 */
	@Schema(description = "매장번호", example = "", hidden = false, required = true, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String storNo;
	/**
	 * 채널코드
	 */
	@Schema(description = "채널코드", example = "", hidden = false, required = true, nullable = true, maxLength = 4)
	@MaxByte(max = 4)
	@CodeValue(codeId = "ST040", codes = { "9620", "9100", "9200", "9630", "9631", "9560",
			"9561" }, message = "[9620 : 웰카페 , 9100 : CB5 , 9200 : 나비엘 , 9630 : 유통점 , 9631 : 온라인 , 9560 : HC지원팀 , 9561 : HP지원팀] 등록된 매장채널이 아닙니다. ")
	private String chlCd;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = true, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 회원등급코드
	 */
	@Schema(description = "회원코드 [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP]", example = "", hidden = false, required = true, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	@CodeValue(codeId = "MB020", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP ] 등록된 회원등급이 아닙니다. ")
	private String mshpGradeCd;
	/**
	 * 멤버십등급코드
	 */
	@Schema(description = "멤버십등급코드 [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP]", example = "", hidden = true, required = true, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	@CodeValue(codeId = "MB020", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP ] 등록된 회원등급이 아닙니다. ")
	private String mshipGradeCd;
	/**
	 * 
	 */
	@Schema(description = "회원구분 [001 : 임직원 , 002 : 제휴 , 003 : 회원]", example = "", hidden = false, required = true, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	@CodeValue(codeId = "MB010", codes = { "001", "002", "003" }, message = "[001 : 임직원 , 002 : 제휴 , 003 : 회원 ] 등록된 회원구분이 아닙니다. ")
	private String mshipTypeCd;
	/**
	 * 임직원번호
	 */
	@Schema(description = "임직원번호", example = "", hidden = true, required = false, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String execvdempNo;
	
	/**
	 * 임직원번호
	 */
	@Schema(description = "제휴코드", example = "", hidden = false, required = false, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String cprtCmpNo;
	/**
	 * 사용일시
	 */
	@Schema(description = "사용일시", example = "", hidden = true, required = false, nullable = true)
	@DatetimeValue
	private String useDt;
	/**
	 * 총금액
	 */
	@Schema(description = "총금액", example = "", hidden = false, required = true, nullable = true)
	private Integer totAmt;
	/**
	 * 전표번호
	 */
	@Schema(description = "전표번호", example = "", hidden = false, required = true, nullable = true)
	private String chitNo;

	@Schema(description = "구매제품번호리스트", example = "", hidden = false, required = true, nullable = true)
	@NotEmpty
	private List<CrmMshipStmpAccumGodsVo> itemList;

	/**
	 * 구매제품번호
	 */
//	@Schema(description = "구매제품번호", example = "", hidden = false, required = true, nullable = true, maxLength = 30)
//	@MaxByte(max = 30)
//	private String buyGodsNo;

//	@Schema(description = "FROM사용가능일시 (YYYYMMDDHH24MISS)", example = "20220517135655", hidden = false, required = false, nullable = true)
//	@DatetimeValue
//	private String fromUsePossDt;
//	/**
//	 * TO사용가능일시
//	 */
//	@Schema(description = "TO사용가능일시 (YYYYMMDDHH24MISS)", example = "20220517135655", hidden = false, required = false, nullable = true)
//	@DatetimeValue
//	private String toUsePossDt;
//	/**
//	 * 유효여부
//	 */
//	@Schema(description = "유효여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
//	@YnValue
//	@MaxByte(max = 1)
//	private String validYn;

}
