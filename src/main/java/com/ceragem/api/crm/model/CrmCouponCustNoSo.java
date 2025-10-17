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

	@CodeValue(codeId = "MB080", codes = { "001", "002", "012", "017", "003", "004", "005", "006", "007", "008", "009",
			"010", "011", "015", "014", "016", "013", "018", "019",
			"020" }, message = "[001 :	음료 쿠폰,002 :	체험 쿠폰,012 :	앰버서더,017 :	상품 쿠폰,003 :	회원가입,004 :	마케팅정보수신동의,005 :	홈쇼핑 채널 쿠폰,006 :	쿠폰재발행,007 :	생일,008 :	슬기로운마스터,009 :	휴면해제,010 :	출석체크,011 :	후기작성,015 :	세라체크,014 :	서베이,016 :	IoT,013 :	서비스 쿠폰,018 :	임직원 쿠폰,019 :	HC전용 쿠폰,020 :	장바구니 쿠폰] 등록된 코드가 아닙니다. ")
	@Parameter(description = "쿠폰종류코드  [001 :	음료 쿠폰,002 :	체험 쿠폰,012 :	앰버서더,017 :	상품 쿠폰,003 :	회원가입,004 :	마케팅정보수신동의,005 :	홈쇼핑 채널 쿠폰,006 :	쿠폰재발행,007 :	생일,008 :	슬기로운마스터,009 :	휴면해제,010 :	출석체크,011 :	후기작성,015 :	세라체크,014 :	서베이,016 :	IoT,013 :	서비스 쿠폰,018 :	임직원 쿠폰,019 :	HC전용 쿠폰,020 :	장바구니 쿠폰]", example = "", hidden = true, required = false)
	private String coupnKndCd;

	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
//	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
//			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
//	private String regChlCd;

	/**
	 * 사용가능여부
	 */
	@Parameter(description = "사용가능여부[Y : 사용가능, N : 사용불가 유효기간 지남]", example = "", hidden = false, required = false)
	@YnValue
	private String availableYn;

	@Parameter(description = "만료여부[Y : 기간이내 ,N : 기간외 ]", example = "", hidden = false, required = false)
	@YnValue
	private String expiredYn;

	/**
	 * 등록채널코드 공통코드 : CH100 [MAL : COM , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [MEM : 멤버십 , COM : 직영몰 , POS : POS]", example = "", hidden = false, required = false)
	@CodeValue(codeId = "CH100", codes = { "MEM", "MAL",
			"POS" }, message = "[MEM : MEM , COM : MAL , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;

	@Parameter(description = "직영몰쿠폰여부", example = "", hidden = false, required = false)
	@YnValue
	private String chlComYn;

	@Parameter(description = "웰니스인식쿠폰여부")
	@YnValue
	private String wellnessIdYn;

	@Parameter(description = "웰니스쿠폰여부")
	@YnValue
	private String wellnessYn;
}
