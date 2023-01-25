package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipCoupnBasVo
 * @author 김성태
 * @date 2022. 5. 20.
 * @Version 1.0
 * @description CRM멤버십쿠폰기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십쿠폰기본 객체")
public class CrmMshipCoupnBasVo extends ApiBaseVo {
	/**
	 * 멤버십쿠폰기본번호
	 */
	@Schema(description = "멤버십쿠폰기본번호", example = "", hidden = true, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String mshipCoupnBasNo;
	/**
	 * 쿠폰종류코드
	 */
	@Schema(description = "쿠폰종류코드", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnKndCd;

	/**
	 * 쿠폰종류코드명
	 */
	@Schema(description = "쿠폰종류코드명", example = "", hidden = true, required = false, nullable = true)
	private String coupnKndCdNm;

	/**
	 * 쿠폰대상코드
	 */
	@Schema(description = "쿠폰대상코드", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnTgtCd;
	/**
	 * 쿠폰대상코드명
	 */
	@Schema(description = "쿠폰대상코드명", example = "", hidden = true, required = false, nullable = true)
	private String coupnTgtCdNm;

	/**
	 * 쿠폰적용구분코드1
	 */
	@Schema(description = "쿠폰적용구분코드1", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnApplyDivCd1;
	/**
	 * 쿠폰적용구분코드1명
	 */
	@Schema(description = "쿠폰적용구분코드1명", example = "", hidden = true, required = false, nullable = true)
	private String coupnApplyDivCd1Nm;

	/**
	 * 쿠폰적용구분코드2
	 */
	@Schema(description = "쿠폰적용구분코드2", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnApplyDivCd2;
	/**
	 * 쿠폰적용구분코드2명
	 */
	@Schema(description = "쿠폰적용구분코드2명", example = "", hidden = true, required = false, nullable = true)
	private String coupnApplyDivCd2Nm;

	/**
	 * FROM발행기준일
	 */
	@Schema(description = "FROM발행기준일", example = "", hidden = true, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String fromPblsStdDay;
	/**
	 * TO발행기준일
	 */
	@Schema(description = "TO발행기준일", example = "", hidden = true, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String toPblsStdDay;
	/**
	 * 사용기준일조건코드
	 */
	@Schema(description = "사용기준일조건코드", example = "", hidden = true, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String useStdDayCondCd;
	/**
	 * FROM사용기준일
	 */
	@Schema(description = "FROM사용기준일", example = "", hidden = true, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String fromUseStdDay;
	/**
	 * TO사용기준일
	 */
	@Schema(description = "TO사용기준일", example = "", hidden = true, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String toUseStdDay;
	/**
	 * 선물가능여부
	 */
	@Schema(description = "선물가능여부 [Y/N]", example = "N", hidden = true, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String giftPossYn;
	/**
	 * 쿠폰발급방법코드
	 */
	@Schema(description = "쿠폰발급방법코드", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnIssueMethCd;
	/**
	 * 쿠폰발급방법코드
	 */
	@Schema(description = "쿠폰발급방법코드명", example = "", hidden = true, required = false, nullable = true)
	private String coupnIssueMethCdNm;
	/**
	 * 발급제한수
	 */
	@Schema(description = "발급제한수", example = "", hidden = true, required = false, nullable = true)
	private Integer issueRstrtnCnt;
	/**
	 * 최대발급수
	 */
	@Schema(description = "최대발급수", example = "", hidden = true, required = false, nullable = true)
	private Integer maxIssueCnt;
	/**
	 * 최대사용수
	 */
	@Schema(description = "최대사용수", example = "", hidden = true, required = false, nullable = true)
	private Integer maxUseCnt;
	/**
	 * 적용금액
	 */
	@Schema(description = "적용금액", example = "", hidden = true, required = false, nullable = true)
	private Integer applyAmt;
	/**
	 * 적용율
	 */
	@Schema(description = "적용율", example = "", hidden = true, required = false, nullable = true)
	private Integer applyRate;
	/**
	 * 적용포인트
	 */
	@Schema(description = "적용포인트", example = "", hidden = true, required = false, nullable = true)
	private Integer applyPoint;
	/**
	 * 최소구매금액
	 */
	@Schema(description = "최소구매금액", example = "", hidden = true, required = false, nullable = true)
	private Integer minBuyAmt;
	/**
	 * 최대할인금액
	 */
	@Schema(description = "최대할인금액", example = "", hidden = true, required = false, nullable = true)
	private Integer maxDcAmt;
	/**
	 * 적용수
	 */
	@Schema(description = "적용수", example = "", hidden = true, required = false, nullable = true)
	private Integer applyCnt;
	/**
	 * 증정제품코드
	 */
	@Schema(description = "증정제품코드", example = "", hidden = true, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String prsnttnGodsCd;
	/**
	 * 증정제품코드명
	 */
	@Schema(description = "증정제품코드명", example = "", hidden = true, required = false, nullable = true)
	private String prsnttnGodsCdNm;
	/**
	 * 사용요일
	 */
	@Schema(description = "사용요일", example = "", hidden = true, required = false, nullable = true, maxLength = 1)
	@MaxByte(max = 1)
	private String useDow;
	/**
	 * FROM사용시간
	 */
	@Schema(description = "FROM사용시간", example = "", hidden = true, required = false, nullable = true, maxLength = 4)
	@MaxByte(max = 4)
	private String fromUseHour;
	/**
	 * TO사용시간
	 */
	@Schema(description = "TO사용시간", example = "", hidden = true, required = false, nullable = true, maxLength = 4)
	@MaxByte(max = 4)
	private String toUseHour;
	/**
	 * 사용채널코드
	 */
	@Schema(description = "사용채널코드", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String useChlCd;
	/**
	 * 사용채널코드명
	 */
	@Schema(description = "사용채널코드명", example = "", hidden = true, required = false, nullable = true)
	private String useChlCdNm;
	/**
	 * 중복사용여부
	 */
	@Schema(description = "중복사용여부 [Y/N]", example = "N", hidden = true, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dupUseYn;
	/**
	 * 사용구분코드
	 */
	@Schema(description = "사용구분코드", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String useDivCd;
	/**
	 * 사용구분코드명
	 */
	@Schema(description = "사용구분코드명", example = "", hidden = true, required = false, nullable = true)
	private String useDivCdNm;
	/**
	 * 사용여부
	 */
	@Schema(description = "사용여부 [Y/N]", example = "N", hidden = true, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String useYn;
	/**
	 * 쿠폰기본명
	 */
	@Schema(description = "쿠폰마스트명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String coupnBasNm;
	/**
	 * 쿠폰기본내용
	 */
	@Schema(description = "쿠폰기본내용", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String coupnBasCtnts;
	/**
	 * 정산방법코드
	 */
	@Schema(description = "정산방법코드", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String admtMethCd;
	/**
	 * 정산방법코드명
	 */
	@Schema(description = "정산방법코드명", example = "", hidden = true, required = false, nullable = true)
	private String admtMethCdNm;
	/**
	 * 정산금액
	 */
	@Schema(description = "정산금액", example = "", hidden = true, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String admtAmt;
	/**
	 * 쿠폰유형
	 */
	@Schema(description = "쿠폰유형 EV100  [010 : 웰카페 체험추천, 020 : 홈체험 추천, 030 : 멤버십 가입 추천, 040 : 웰카페 체험, 050 : 홈체험, 060 : 멤버십회원 가입, 902 : 구매추천, 901 : 구매, 070 : 마케팅정보 수신동의, 080 : 앱 다운로드, 090 : 추가 정보 입력, 100 : 생일, 110 : 휴면방지, 120 : 휴면해제, 130 : 출석체크, 140 : 텍스트 후기 작성, 150 : 이미지 후기 작성, 160 : 동영상 후기 작성, 170 : 세라체크, 180 : 서베이, 190 : IoT]", example = "010", hidden = false, required = true, nullable = false, maxLength = 3)
	@CodeValue(codeId = "EV100", codes = { "010", "020", "030", "040", "050", "060", "902", "901", "070", "080", "090",
			"100", "110", "120", "130", "140", "150", "160", "170", "180",
			"190" }, message = "[010 : 웰카페 체험추천, 020 : 홈체험 추천, 030 : 멤버십 가입 추천, 040 : 웰카페 체험, 050 : 홈체험, 060 : 멤버십회원 가입, 902 : 구매추천, 901 : 구매, 070 : 마케팅정보 수신동의, 080 : 앱 다운로드, 090 : 추가 정보 입력, 100 : 생일, 110 : 휴면방지, 120 : 휴면해제, 130 : 출석체크, 140 : 텍스트 후기 작성, 150 : 이미지 후기 작성, 160 : 동영상 후기 작성, 170 : 세라체크, 180 : 서베이, 190 : IoT] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String coupnTypeCd;
	/**
	 * 쿠폰유형명
	 */
	@Schema(description = "쿠폰유형명", example = "", hidden = true, required = false, nullable = true)
	private String coupnTypeCdNm;

	/**
	 * 쿠폰사용가능일
	 */
	@Schema(description = "쿠폰사용가능일", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnUsePossDay;
	/**
	 * 쿠폰사용가능여부
	 */
	@Schema(description = "쿠폰사용가능여부 [Y/N]", example = "N", hidden = true, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String coupnUsePossYn;
	/**
	 * 쿠폰사용가능일수
	 */
	@Schema(description = "쿠폰사용가능일수", example = "", hidden = true, required = false, nullable = true)
	private Integer coupnUsePossDayCnt;
	/**
	 * 쿠폰분류코드
	 */
	@Schema(description = "쿠폰분류코드", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnClassCd;
	/**
	 * 쿠폰분류코드명
	 */
	@Schema(description = "쿠폰분류코드명", example = "", hidden = true, required = false, nullable = true)
	private String coupnClassCdNm;
	
	/**
	 * 요일1사용여부
	 */
	@Schema(description = "월요일사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dow1UseYn;
	/**
	 * 요일2사용여부
	 */
	@Schema(description = "화요일사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dow2UseYn;
	/**
	 * 요일3사용여부
	 */
	@Schema(description = "수요일사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dow3UseYn;
	/**
	 * 요일4사용여부
	 */
	@Schema(description = "목요일사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dow4UseYn;
	/**
	 * 요일5사용여부
	 */
	@Schema(description = "금요일사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dow5UseYn;
	/**
	 * 요일6사용여부
	 */
	@Schema(description = "토요일사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dow6UseYn;
	/**
	 * 요일7사용여부
	 */
	@Schema(description = "일요일사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dow7UseYn;
	/**
	 * 회원등급코드
	 */
	@Schema(description = "회원등급코드", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String mshpGradeCd;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "CRM", hidden = true, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;
	/**
	 * 멤버십코드
	 */
	@Schema(description = "등록채널코드명", example = "", hidden = true, required = false, nullable = true)
	private String regChlCdNm;
	
	/**
	 * 적용등급
	 */
	@Schema(description = "적용등급", example = "", hidden = true, required = false, nullable = true)
	private String applyMshpGradeCtnts;
	
	/**
	 * 적용등급
	 */
	@Schema(description = "회원타입", example = "", hidden = true, required = false, nullable = true)
	private String mshipTypeCds;
	
	/**
	 * 적용등급
	 */
	@Schema(description = "제휴사", example = "", hidden = true, required = false, nullable = true)
	private String cprtCmpNo;

}
