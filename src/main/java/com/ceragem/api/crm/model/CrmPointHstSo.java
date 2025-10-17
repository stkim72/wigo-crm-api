package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DateValue;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmPointHstSo
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM포인트이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM포인트이력 검색 객체")
public class CrmPointHstSo extends ApiPagination {

	/**
	 * 포인트이력일련번호
	 */
	@Parameter(description = "포인트이력일련번호", example = "", hidden = true, required = false)
	private String pointHstSeq;
	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = false, required = false)
	@NotEmpty
	private String itgCustNo;
	/**
	 * 멤버십등급코드 공통코드 : MB020 [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드
	 * , 006 : VIP]
	 */
	@Parameter(description = "멤버십등급코드  [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "MB020", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP] 등록된 코드가 아닙니다. ")
	private String mshipGradeCd;
	/**
	 * 매장번호
	 */
	@Parameter(description = "매장번호", example = "", hidden = true, required = false)
	private String storNo;
	/**
	 * 전표번호
	 */
	@Parameter(description = "전표번호", example = "", hidden = true, required = false)
	private String chitNo;
	/**
	 * 구매제품번호
	 */
	@Parameter(description = "구매제품번호", example = "", hidden = true, required = false)
	private String buyGodsNo;
	/**
	 * 주문금액
	 */
	@Parameter(description = "주문금액", example = "", hidden = true, required = false)
	private Integer ordrAmt;
	/**
	 * 적용금액
	 */
	@Parameter(description = "적용금액", example = "", hidden = true, required = false)
	private Integer applyAmt;
	/**
	 * 결제금액
	 */
	@Parameter(description = "결제금액", example = "", hidden = true, required = false)
	private Integer payAmt;

	/**
	 * 발행구분코드 공통코드 : EV100 [010 : 웰카페 체험추천 , 020 : 홈체험 추천 , 030 : 멤버십 가입 추천 , 040 :
	 * 웰카페 체험 , 050 : 홈체험 , 060 : 멤버십회원 가입 , 070 : 마케팅정보 수신동의 , 080 : 앱 다운로드 , 090 :
	 * 추가 정보 입력 , 100 : 생일 , 110 : 휴면방지 , 120 : 휴면해제 , 130 : 출석체크 , 140 : 텍스트 후기 작성
	 * , 150 : 이미지 후기 작성 , 160 : 동영상 후기 작성 , 170 : 세라체크 , 180 : 서베이 , 190 : IoT]
	 */
	@Parameter(description = "발행구분코드  [010 : 웰카페 체험추천 , 020 : 홈체험 추천 , 030 : 멤버십 가입 추천 , 040 : 웰카페 체험 , 050 : 홈체험 , 060 : 멤버십회원 가입 , 070 : 마케팅정보 수신동의 , 080 : 앱 다운로드 , 090 : 추가 정보 입력 , 100 : 생일 , 110 : 휴면방지 , 120 : 휴면해제 , 130 : 출석체크 , 140 : 텍스트 후기 작성 , 150 : 이미지 후기 작성 , 160 : 동영상 후기 작성 , 170 : 세라체크 , 180 : 서베이 , 190 : IoT , 901 : 구매, 902 : 구매추천, 903 : 스탬프, 904 : 쿠폰, 905 : 프로모션, 940 : 수기차감, 950 : 수기지급, 960 : 캠페인지급, 970 : 승급]", example = "001", hidden = false, required = false)
	@CodeValue(codeId = "EV100", codes = { "010", "020", "030", "040", "050", "060", "070", "080", "090", "100", "110",
			"120", "130", "140", "150", "160", "170", "180", "190", "901", "902", "903", "904", "905", "940", "950",
			"960",
			"970" }, message = "[010 : 웰카페 체험추천 , 020 : 홈체험 추천 , 030 : 멤버십 가입 추천 , 040 : 웰카페 체험 , 050 : 홈체험 , 060 : 멤버십회원 가입 , 070 : 마케팅정보 수신동의 , 080 : 앱 다운로드 , 090 : 추가 정보 입력 , 100 : 생일 , 110 : 휴면방지 , 120 : 휴면해제 , 130 : 출석체크 , 140 : 텍스트 후기 작성 , 150 : 이미지 후기 작성 , 160 : 동영상 후기 작성 , 170 : 세라체크 , 180 : 서베이 , 190 : IoT , 901 : 구매, 902 : 구매추천, 903 : 스탬프, 904 : 쿠폰, 905 : 프로모션, 940 : 수기차감, 950 : 수기지급, 960 : 캠페인지급, 970 : 승급] 등록된 코드가 아닙니다. 11 ")
	@MaxByte(max = 3)
	private String pblsDivCd;

	/**
	 * 검색시작일
	 */
	@Parameter(description = "검색시작일", example = "20220101", hidden = false, required = false)
	@DateValue
	private String startDt;
	/**
	 * 검색종료일
	 */
	@Parameter(description = "검색종료일", example = "20221230", hidden = false, required = false)
	@DateValue
	private String endDt;

	@Parameter(description = "발행구분코드명", example = "구매포인트", hidden = false)
	private String pblsDivNm;

	/**
	 * 발생포인트점수
	 */
	@Parameter(description = "발생포인트점수", example = "", hidden = true, required = false)
	private Integer occurPointScore;

	/**
	 * 잔여포인트점수
	 */
	@Parameter(description = "잔여포인트점수", example = "", hidden = true, required = false)
	private Integer remainPointScore;

	/**
	 * 유효기간시작년월일
	 */
	@Parameter(description = "유효기간시작년월일", example = "", hidden = true, required = false)
	@MaxByte(max = 8)
	@DateValue
	private String validPerdStaYmd;
	/**
	 * 유효기간종료년월일
	 */
	@Parameter(description = "유효기간종료년월일", example = "", hidden = true, required = false)
	@MaxByte(max = 8)
	@DateValue
	private String validPerdEndYmd;
	/**
	 * 발행일시
	 */
	@Parameter(description = "발행일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String pblsDt;
	/**
	 * 소멸일시
	 */
	@Parameter(description = "소멸일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String extncDt;
	/**
	 * 내역
	 */
	@Parameter(description = "내역", example = "", hidden = true, required = false)
	private String txn;
	/**
	 * 발행채널코드 공통코드 : S000 [CTC : 상담 , AS : AS , SAP : SAP , test : test]
	 */
	@Parameter(description = "발행채널코드  [CTC : 상담 , AS : AS , SAP : SAP , test : test]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CTC", "AS", "SAP",
			"test" }, message = "[CTC : 상담 , AS : AS , SAP : SAP , test : test] 등록된 코드가 아닙니다. ")
	private String pblsChlCd;
	/**
	 * 카드발행이력일련번호
	 */
	@Parameter(description = "카드발행이력일련번호", example = "", hidden = true, required = false)
	private String cardPblsHstSeq;
	/**
	 * 사용유형코드 공통코드 : PO010 [001 : 사용 , 002 : 적립 , 003 : 취소]
	 */
	@Parameter(description = "사용유형코드  [001 : 사용 , 002 : 적립 , 003 : 취소]", example = "001", hidden = false, required = false)
	@CodeValue(codeId = "PO010", codes = { "001", "002",
			"003" }, message = "[001 : 사용 , 002 : 적립 , 003 : 취소] 등록된 코드가 아닙니다. ")
	private String useTypeCd;
	/**
	 * 거래번호
	 */
	@Parameter(description = "거래번호", example = "", hidden = true, required = false)
	private String dealNo;
	/**
	 * 프로모션번호
	 */
	@Parameter(description = "프로모션번호", example = "", hidden = true, required = false)
	private String promNo;
	/**
	 * 캠페인번호
	 */
	@Parameter(description = "캠페인번호", example = "", hidden = true, required = false)
	private String campNo;
	/**
	 * 쿠폰번호
	 */
	@Parameter(description = "쿠폰번호", example = "", hidden = true, required = false)
	private String coupnNo;
	/**
	 * 사용일시
	 */
	@Parameter(description = "사용일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String useDt;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"test" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test] 등록된 코드가 아닙니다. ")
	private String regChlCd;

	@Parameter(description = "카드사용분", example = "", hidden = true, required = false)
	private String useCard;

	@Parameter(description = "카드번호", example = "", hidden = false, required = false)
	public String getCardNo() {
		return cardPblsHstSeq;
	}

	public void setCardNo(String cardNo) {
		this.cardPblsHstSeq = cardNo;
	}
}
