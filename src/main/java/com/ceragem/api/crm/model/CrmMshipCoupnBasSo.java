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
 * @ClassName CrmMshipCoupnBasSo
 * @author 김성태
 * @date 2022. 5. 20.
 * @Version 1.0
 * @description CRM멤버십쿠폰기본 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십쿠폰기본 검색 객체")
public class CrmMshipCoupnBasSo extends ApiPagination {
	/**
	 * 멤버십쿠폰기본번호
	 */
	@Parameter(description = "멤버십쿠폰기본번호", example = "", hidden = true, required = false)
	private String mshipCoupnBasNo;
	/**
	 * 쿠폰종류코드
	 */
	@Parameter(description = "쿠폰종류코드", example = "", hidden = true, required = false)
	private String coupnKndCd;
	/**
	 * 쿠폰대상코드
	 */
	@Parameter(description = "쿠폰대상코드", example = "", hidden = true, required = false)
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
	@Parameter(description = "쿠폰마스터명", example = "", hidden = true, required = false)
	private String coupnBasNm;
	/**
	 * 쿠폰기본명
	 */
	@Parameter(description = "쿠폰마스터명 Like 검색", example = "", hidden = false, required = false)
	private String coupnBasNmLike;
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

	@Parameter(description = "쿠폰유형 MB080  [001 :	음료 쿠폰,002 :	체험 쿠폰,012 :	앰버서더,017 :	상품 쿠폰,003 :	회원가입,004 :	마케팅정보수신동의,005 :	홈쇼핑 채널 쿠폰,006 :	쿠폰재발행,007 :	생일,008 :	슬기로운마스터,009 :	휴면해제,010 :	출석체크,011 :	후기작성,015 :	세라체크,014 :	서베이,016 :	IoT,013 :	서비스 쿠폰,018 :	임직원 쿠폰,019 :	HC전용 쿠폰,020 :	장바구니 쿠폰, 021 : 직영몰 상품 쿠폰 , 022 : TM상담쿠폰]", example = "001", hidden = false, required = false)
	@CodeValue(codeId = "MB080", codes = { "001", "002", "012", "017", "003", "004", "005", "006", "007", "008", "009",
			"010", "011", "015", "014", "016", "013", "018", "019", "020", "021",
			"022" }, message = "[001 :	음료 쿠폰,002 :	체험 쿠폰,012 :	앰버서더,017 :	상품 쿠폰,003 :	회원가입,004 :	마케팅정보수신동의,005 :	홈쇼핑 채널 쿠폰,006 :	쿠폰재발행,007 :	생일,008 :	슬기로운마스터,009 :	휴면해제,010 :	출석체크,011 :	후기작성,015 :	세라체크,014 :	서베이,016 :	IoT,013 :	서비스 쿠폰,018 :	임직원 쿠폰,019 :	HC전용 쿠폰,020 :	장바구니 쿠폰 , 021 : 직영몰 상품 쿠폰 , 022 : TM상담쿠폰 ] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)

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
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
//	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
//			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
//	private String regChlCd;
	/**
	 * 멤버십코드
	 */
	@Parameter(description = "멤버십코드", example = "", hidden = true, required = false)
	private String mshipGradeCd;
	/**
	 * 제휴사코드번호
	 */
	@Parameter(description = "제휴사코드번호", example = "", hidden = true, required = false)
	private String cprtCmpNo;
	/**
	 * 사용가능여부
	 */
	@Parameter(description = "사용가능여부[Y : 사용가능, N : 사용불가 유효기간 지남]", example = "", hidden = false, required = false)
	@YnValue
	private String availableYn;
	/**
	 * 등록채널코드 공통코드 : CH100 [COM : MAL , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [MEM : 멤버십 , COM : 직영몰 , POS : POS]", example = "", hidden = false, required = false)
	@CodeValue(codeId = "CH100", codes = { "MEM", "COM",
			"POS" }, message = "[MEM : MEM , COM : 직영몰 , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;
}
