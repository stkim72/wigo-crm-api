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
	@Parameter(description = "쿠폰유형 EV100  [010 : 웰카페 체험추천, 020 : 홈체험 추천, 030 : 멤버십 가입 추천, 040 : 웰카페 체험, 050 : 홈체험, 060 : 멤버십회원 가입, 902 : 구매추천, 901 : 구매, 070 : 마케팅정보 수신동의, 080 : 앱 다운로드, 090 : 추가 정보 입력, 100 : 생일, 110 : 휴면방지, 120 : 휴면해제, 130 : 출석체크, 140 : 텍스트 후기 작성, 150 : 이미지 후기 작성, 160 : 동영상 후기 작성, 170 : 세라체크, 180 : 서베이, 190 : IoT]", example = "010", hidden = true, required = true)
	@CodeValue(codeId = "EV100", codes = { "010", "020", "030", "040", "050", "060", "902", "901", "070", "080", "090",
			"100", "110", "120", "130", "140", "150", "160", "170", "180",
			"190" }, message = "[010 : 웰카페 체험추천, 020 : 홈체험 추천, 030 : 멤버십 가입 추천, 040 : 웰카페 체험, 050 : 홈체험, 060 : 멤버십회원 가입, 902 : 구매추천, 901 : 구매, 070 : 마케팅정보 수신동의, 080 : 앱 다운로드, 090 : 추가 정보 입력, 100 : 생일, 110 : 휴면방지, 120 : 휴면해제, 130 : 출석체크, 140 : 텍스트 후기 작성, 150 : 이미지 후기 작성, 160 : 동영상 후기 작성, 170 : 세라체크, 180 : 서베이, 190 : IoT] 등록된 코드가 아닙니다. ")
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
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;
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
}
