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
 * @ClassName CrmCoupnPblsHstSo
 * @author 김성태
 * @date 2022. 5. 11.
 * @Version 1.0
 * @description CRM멤버십쿠폰기본 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십쿠폰 사용자검색 객체")
public class CrmCouponCustNoSo extends ApiPagination {
	/**
	 * 쿠폰발행기본번호
	 */
	@Parameter(description = "쿠폰번호", example = "", hidden = false, required = false)
	private String coupnPblsBasNo;
	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = false, required = false)
	private String itgCustNo;
	/**
	 * 멤버십쿠폰기본번호
	 */
	@Parameter(description = "멤버십쿠폰기본번호", example = "", hidden = false, required = false)
	private String mshipCoupnBasNo;
	/**
	 * 쿠폰종류코드 공통코드 : MB080 [001 : 음료할인쿠폰 , 002 : 무료체험서비스쿠폰 , 003 : 회원가입쿠폰 , 004 :
	 * 마케팅정보동의쿠폰 , 005 : 앱다운로드쿠폰 , 006 : 추가정보입력쿠폰 , 007 : 첫구매쿠폰 , 008 : 교차구매유도쿠폰 ,
	 * 009 : 생일축하쿠폰 , 010 : 등급상승쿠폰 , 011 : 휴면방지쿠폰 , 012 : 포인트쿠폰 , 013 : 서비스쿠폰]
	 */

	@CodeValue(codeId = "MB080", codes = { "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011",
			"012", "013", "014", "015",
			"016" }, message = "[001 : 음료할인쿠폰 , 002 : 무료체험서비스쿠폰 , 003 : 회원가입쿠폰 , 004 : 마케팅정보동의쿠폰 , 005 : 앱다운로드쿠폰 , 006 : 추가정보입력쿠폰 , 007 : 첫구매쿠폰 , 008 : 교차구매유도쿠폰 , 009 : 생일축하쿠폰 , 010 : 등급상승쿠폰 , 011 : 휴면방지쿠폰 , 012 : 포인트쿠폰 , 013 : 서비스쿠폰, 014 : 서베이, 015 : 세라체크, 016 : IOT] 등록된 코드가 아닙니다. ")
	@Parameter(description = "쿠폰종류코드  [001 : 음료할인쿠폰 , 002 : 무료체험서비스쿠폰 , 003 : 회원가입쿠폰 , 004 : 마케팅정보동의쿠폰 , 005 : 앱다운로드쿠폰 , 006 : 추가정보입력쿠폰 , 007 : 첫구매쿠폰 , 008 : 교차구매유도쿠폰 , 009 : 생일축하쿠폰 , 010 : 등급상승쿠폰 , 011 : 휴면방지쿠폰 , 012 : 포인트쿠폰 , 013 : 서비스쿠폰, 014 : 서베이, 015 : 세라체크, 016 : IOT]", example = "", hidden = true, required = false)
	private String coupnKndCd;

	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;

	/**
	 * 사용가능여부
	 */
	@Parameter(description = "사용가능여부[Y : 사용가능, N : 사용불가 유효기간 지남]", example = "", hidden = false, required = false)
	@YnValue
	private String availableYn;

	@Parameter(description = "만료여부[Y : 기간이내 ,N : 기간외 ]", example = "", hidden = false, required = false)
	@YnValue
	private String expiredYn;

}
