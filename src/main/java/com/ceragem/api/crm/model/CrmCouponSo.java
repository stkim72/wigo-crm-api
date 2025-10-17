package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
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
@Schema(description = "CRM멤버십쿠폰기본 검색 객체")
public class CrmCouponSo extends ApiPagination {
	/**
	 * 쿠폰발행이력일련번호
	 */
	@Parameter(description = "쿠폰발행이력일련번호", example = "", hidden = true, required = false)
	private String coupnPblsHstSeq;
	/**
	 * 쿠폰발행기본번호
	 */
	@Parameter(description = "쿠폰번호", example = "", hidden = false, required = false)
	private String coupnPblsBasNo;
	/**
	 * 매장번호
	 */
	@Parameter(description = "발행매장번호", example = "", hidden = false, required = false)
	private String storNo;
	/**
	 * 캠페인번호
	 */
	@Parameter(description = "캠페인번호", example = "", hidden = true, required = false)
	private String campNo;
	/**
	 * 프로모션번호
	 */
	@Parameter(description = "프로모션번호", example = "", hidden = true, required = false)
	private String promNo;
	/**
	 * 쿠폰북이력일련번호
	 */
	@Parameter(description = "서비스권번호", example = "", hidden = true, required = false)
	@MaxByte(max = 20)
	private String coupnBookHstSeq;

	/**
	 * 서비스권검색(Y : 서비스권만 검색 , N 서비스권 : 제외 , NULL 전제검색)
	 * 
	 */
	@Parameter(description = "서비스권검색여부  [Y : 서비스권만 검색 , N 서비스권 : 제외 , NULL 전제검색]", example = "", hidden = true, required = false)
	@YnValue
	private String bookYn;

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

	/**
	 * 쿠폰종류코드 공통코드 : MB130 [001 : 정액할인 , 002 : 정률할인 , 003 : 제품증정 , 004 : 서비스 , 005 :
	 * 포인트]
	 */
	@Parameter(description = "쿠폰종류코드  [001 : 정액할인 , 002 : 정률할인 , 003 : 제품증정 , 004 : 서비스 , 005 : 포인트]", example = "001", hidden = false, required = false)
	@CodeValue(codeId = "MB130", codes = { "001", "002", "003", "004",
			"005" }, message = "[001 : 정액할인 , 002 : 정률할인 , 003 : 제품증정 , 004 : 서비스 , 005 : 포인트] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String coupnKndCd;
	/**
	 * 쿠폰대상코드 공통코드 : MB100 [001 : 회원 , 002 : 전체]
	 */
	@Parameter(description = "쿠폰대상코드  [001 : 회원 , 002 : 전체]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "MB100", codes = { "001", "002" }, message = "[001 : 회원 , 002 : 전체] 등록된 코드가 아닙니다. ")
	private String coupnTgtCd;
	/**
	 * 쿠폰적용구분코드1
	 */
	@Parameter(description = "쿠폰적용구분코드1", example = "", hidden = true, required = false)
	private String coupnApplyDivCd1;
	/**
	 * 쿠폰적용구분코드2
	 */
	@Parameter(description = "쿠폰적용구분코드2", example = "", hidden = true, required = false)
	private String coupnApplyDivCd2;
	/**
	 * FROM발행기준일
	 */
	@Parameter(description = "FROM발행기준일", example = "", hidden = true, required = false)
	private String fromPblsStdDay;
	/**
	 * TO발행기준일
	 */
	@Parameter(description = "TO발행기준일", example = "", hidden = true, required = false)
	private String toPblsStdDay;
	/**
	 * 사용기준일조건코드
	 */
	@Parameter(description = "사용기준일조건코드", example = "", hidden = true, required = false)
	private String useStdDayCondCd;
	/**
	 * FROM사용기준일
	 */
	@Parameter(description = "FROM사용기준일", example = "", hidden = true, required = false)
	private String fromUseStdDay;
	/**
	 * TO사용기준일
	 */
	@Parameter(description = "TO사용기준일", example = "", hidden = true, required = false)
	private String toUseStdDay;
	/**
	 * 선물가능여부
	 */
	@Parameter(description = "선물가능여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String giftPossYn;
	/**
	 * 쿠폰발급방법코드
	 */
	@Parameter(description = "쿠폰발급방법코드", example = "", hidden = true, required = false)
	private String coupnIssueMethCd;
	/**
	 * 발급제한수
	 */
	@Parameter(description = "발급제한수", example = "", hidden = true, required = false)
	private Integer issueRstrtnCnt;
	/**
	 * 최대발급수
	 */
	@Parameter(description = "최대발급수", example = "", hidden = true, required = false)
	private Integer maxIssueCnt;
	/**
	 * 최대사용수
	 */
	@Parameter(description = "최대사용수", example = "", hidden = true, required = false)
	private Integer maxUseCnt;
	/**
	 * 적용금액
	 */
	@Parameter(description = "적용금액", example = "", hidden = true, required = false)
	private Integer applyAmt;
	/**
	 * 적용율
	 */
	@Parameter(description = "적용율", example = "", hidden = true, required = false)
	private Integer applyRate;
	/**
	 * 적용포인트
	 */
	@Parameter(description = "적용포인트", example = "", hidden = true, required = false)
	private Integer applyPoint;
	/**
	 * 최소구매금액
	 */
	@Parameter(description = "최소구매금액", example = "", hidden = true, required = false)
	private Integer minBuyAmt;
	/**
	 * 최대할인금액
	 */
	@Parameter(description = "최대할인금액", example = "", hidden = true, required = false)
	private Integer maxDcAmt;
	/**
	 * 적용수
	 */
	@Parameter(description = "적용수", example = "", hidden = true, required = false)
	private Integer applyCnt;
	/**
	 * 증정제품코드
	 */
	@Parameter(description = "증정제품코드", example = "", hidden = true, required = false)
	private String prsnttnGodsCd;
	/**
	 * 사용요일
	 */
	@Parameter(description = "사용요일", example = "", hidden = true, required = false)
	private String useDow;
	/**
	 * FROM사용시간
	 */
	@Parameter(description = "FROM사용시간", example = "", hidden = true, required = false)
	private String fromUseHour;
	/**
	 * TO사용시간
	 */
	@Parameter(description = "TO사용시간", example = "", hidden = true, required = false)
	private String toUseHour;
	/**
	 * 사용채널코드
	 */
	@Parameter(description = "사용채널코드", example = "", hidden = true, required = false)
	private String useChlCd;
	/**
	 * 중복사용여부
	 */
	@Parameter(description = "중복사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String dupUseYn;
	/**
	 * 전표번호
	 */
	@Parameter(description = "전표번호", example = "", hidden = true, required = false)
	private String chitNo;
	/**
	 * 사용일시
	 */
	@Parameter(description = "사용일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String useDt;
	/**
	 * 사용구분코드
	 */
	@Parameter(description = "사용구분코드", example = "", hidden = true, required = false)
	private String useDivCd;
	/**
	 * 사용여부
	 */
	@Parameter(description = "사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String useYn;
	/**
	 * 쿠폰기본명
	 */
	@Parameter(description = "쿠폰기본명", example = "", hidden = true, required = false)
	private String coupnBasNm;
	/**
	 * 쿠폰기본내용
	 */
	@Parameter(description = "쿠폰기본내용", example = "", hidden = true, required = false)
	private String coupnBasCtnts;
	/**
	 * 정산방법코드
	 */
	@Parameter(description = "정산방법코드", example = "", hidden = true, required = false)
	private String admtMethCd;
	/**
	 * 정산금액
	 */
	@Parameter(description = "정산금액", example = "", hidden = true, required = false)
	private String admtAmt;
	/**
	 * 쿠폰유형
	 */
	@Parameter(description = "쿠폰유형", example = "", hidden = true, required = false)
	private String coupnTypeCd;
	/**
	 * 쿠폰사용가능일
	 */
	@Parameter(description = "쿠폰사용가능일", example = "", hidden = true, required = false)
	private String coupnUsePossDay;
	/**
	 * 쿠폰사용가능여부
	 */
	@Parameter(description = "쿠폰사용가능여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String coupnUsePossYn;
	/**
	 * 쿠폰사용가능일수
	 */
	@Parameter(description = "쿠폰사용가능일수", example = "", hidden = true, required = false)
	private Integer coupnUsePossDayCnt;
	/**
	 * 쿠폰분류코드
	 */
	@Parameter(description = "쿠폰분류코드", example = "", hidden = true, required = false)
	private String coupnClassCd;

	/**
	 * 요일1사용여부
	 */
	@Parameter(description = "요일1사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String dow1UseYn;
	/**
	 * 요일2사용여부
	 */
	@Parameter(description = "요일2사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String dow2UseYn;
	/**
	 * 요일3사용여부
	 */
	@Parameter(description = "요일3사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String dow3UseYn;
	/**
	 * 요일4사용여부
	 */
	@Parameter(description = "요일4사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String dow4UseYn;
	/**
	 * 요일5사용여부
	 */
	@Parameter(description = "요일5사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String dow5UseYn;
	/**
	 * 요일6사용여부
	 */
	@Parameter(description = "요일6사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String dow6UseYn;
	/**
	 * 요일7사용여부
	 */
	@Parameter(description = "요일7사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String dow7UseYn;
	/**
	 * 회원등급코드
	 */
	@Parameter(description = "회원등급코드", example = "", hidden = true, required = false)
	private String mshpGradeCd;

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
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;

	@Parameter(description = "사용시간", example = "", hidden = true, required = false)
	private String useHour;

	/**
	 * 등록채널코드 공통코드 : CH100 [COM : MAL , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [MEM : 멤버십 , COM : 직영몰 , POS : POS]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "CH100", codes = { "MEM", "COM",
			"POS" }, message = "[MEM : MEM , COM : 직영몰 , POS : POS] 등록된 코드가 아닙니다. ")
	private String chlCd;

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
