package com.ceragem.api.crm.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCoupnPblsHstVo
 * @author 김성태
 * @date 2022. 5. 11.
 * @Version 1.0
 * @description CRM멤버십쿠폰기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십쿠폰기본 객체")
public class CrmCouponVo extends CrmMshipCoupnBasVo {
	/**
	 * 쿠폰발행이력일련번호
	 */
	@Schema(description = "쿠폰발행이력일련번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String coupnPblsHstSeq;
	/**
	 * 쿠폰발행기본번호
	 */
	@Schema(description = "쿠폰발행기본번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String coupnPblsBasNo;
	/**
	 * 매장번호
	 */
	@Schema(description = "매장번호", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String storNo;
	/**
	 * 매장명
	 */
	@Schema(description = "매장명", example = "", hidden = false, required = false, nullable = true)
	private String storNoNm;
	/**
	 * 캠페인번호
	 */
	@Schema(description = "캠페인번호", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String campNo;
	/**
	 * 프로모션번호
	 */
	@Schema(description = "프로모션번호", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String promNo;
	/**
	 * 서비스권번호
	 */
	@Schema(description = "서비스권번호", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String coupnBookHstSeq;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = false, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 멤버십쿠폰기본번호
	 */
	@Schema(description = "멤버십쿠폰기본번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String mshipCoupnBasNo;

	/**
	 * 쿠폰종류코드 공통코드 : MB130 [001 : 정액할인 , 002 : 정률할인 , 003 : 제품증정 , 004 : 서비스 , 005 :
	 * 포인트]
	 */
	@Schema(description = "쿠폰종류코드  [001 : 정액할인 , 002 : 정률할인 , 003 : 제품증정 , 004 : 서비스 , 005 : 포인트]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "MB130", codes = { "001", "002", "003", "004",
			"005" }, message = "[001 : 정액할인 , 002 : 정률할인 , 003 : 제품증정 , 004 : 서비스 , 005 : 포인트] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String coupnKndCd;
	/**
	 * 쿠폰대상코드
	 */
	@Schema(description = "쿠폰대상코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnTgtCd;
	/**
	 * 쿠폰적용구분코드1
	 */
	@Schema(description = "쿠폰적용구분코드1", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnApplyDivCd1;
	/**
	 * 쿠폰적용구분코드2
	 */
	@Schema(description = "쿠폰적용구분코드2", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnApplyDivCd2;
	/**
	 * FROM발행기준일
	 */
	@Schema(description = "FROM발행기준일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String fromPblsStdDay;
	/**
	 * TO발행기준일
	 */
	@Schema(description = "TO발행기준일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String toPblsStdDay;
	/**
	 * 사용기준일조건코드
	 */
	@Schema(description = "사용기준일조건코드", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String useStdDayCondCd;
	/**
	 * FROM사용기준일
	 */
	@Schema(description = "FROM사용기준일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String fromUseStdDay;
	/**
	 * TO사용기준일
	 */
	@Schema(description = "TO사용기준일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String toUseStdDay;
	/**
	 * 선물가능여부
	 */
	@Schema(description = "선물가능여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String giftPossYn;
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
	@Schema(description = "일요일7사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dow7UseYn;
	/**
	 * 쿠폰발급방법코드
	 */
	@Schema(description = "쿠폰발급방법코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String coupnIssueMethCd;
	/**
	 * 발급제한수
	 */
	@Schema(description = "발급제한수", example = "", hidden = false, required = false, nullable = true)
	private Integer issueRstrtnCnt;
	/**
	 * 최대발급수
	 */
	@Schema(description = "최대발급수", example = "", hidden = false, required = false, nullable = true)
	private Integer maxIssueCnt;
	/**
	 * 최대사용수
	 */
	@Schema(description = "최대사용수", example = "", hidden = false, required = false, nullable = true)
	private Integer maxUseCnt;
	/**
	 * 적용금액
	 */
	@Schema(description = "적용금액", example = "", hidden = false, required = false, nullable = true)
	private Integer applyAmt;
	/**
	 * 적용율
	 */
	@Schema(description = "적용율", example = "", hidden = false, required = false, nullable = true)
	private Integer applyRate;
	/**
	 * 적용포인트
	 */
	@Schema(description = "적용포인트", example = "", hidden = false, required = false, nullable = true)
	private Integer applyPoint;
	/**
	 * 최소구매금액
	 */
	@Schema(description = "최소구매금액", example = "", hidden = false, required = false, nullable = true)
	private Integer minBuyAmt;
	/**
	 * 최대할인금액
	 */
	@Schema(description = "최대할인금액", example = "", hidden = false, required = false, nullable = true)
	private Integer maxDcAmt;
	/**
	 * 적용수
	 */
	@Schema(description = "적용수", example = "", hidden = false, required = false, nullable = true)
	private Integer applyCnt;
	/**
	 * 증정제품코드
	 */
	@Schema(description = "증정제품코드", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String prsnttnGodsCd;
	/**
	 * 사용요일
	 */
	@Schema(description = "사용요일", example = "", hidden = false, required = false, nullable = true, maxLength = 1)
	@MaxByte(max = 1)
	private String useDow;
	/**
	 * FROM사용시간
	 */
	@Schema(description = "FROM사용시간", example = "", hidden = false, required = false, nullable = true, maxLength = 4)
	@MaxByte(max = 4)
	private String fromUseHour;
	/**
	 * TO사용시간
	 */
	@Schema(description = "TO사용시간", example = "", hidden = false, required = false, nullable = true, maxLength = 4)
	@MaxByte(max = 4)
	private String toUseHour;
	/**
	 * 사용채널코드
	 */
	@Schema(description = "사용채널코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String useChlCd;
	/**
	 * 중복사용여부
	 */
	@Schema(description = "중복사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dupUseYn;
	/**
	 * 전표번호
	 */
	@Schema(description = "전표번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String chitNo;
	/**
	 * 사용일시
	 */
	@Schema(description = "사용일시 (YYYYMMDDHH24MISS)", example = "20220520162635", hidden = false, required = false, nullable = true, maxLength = 30)
	@DatetimeValue
	@MaxByte(max = 30)
	private String useDt;

	@Schema(description = "쿠폰등급", example = "", hidden = true)
	private String couponGradeCd;

	@Schema(description = "상품목록", hidden = true)
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private List<CrmGodsBasVo> goods = null;

	@Getter(AccessLevel.NONE)
	@Schema(description = "상품목록", hidden = false)
	private String godsNo;

	@Schema(description = "상품목록", hidden = false)
	private List<CrmGodsBasVo> godsList;

	@Schema(description = "채널목록", hidden = false)
	private List<CrmChlBasVo> chlList;

	/**
	 * 사용여부
	 */
	@Schema(description = "사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String issueUseYn;

	/**
	 * 제품번호
	 */
	@Schema(description = "제품번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String buyGodsCd;
	/**
	 * 주문금액
	 */
	@Schema(description = "주문금액", example = "", hidden = true, required = false, nullable = true)
	private Integer ordrAmt;
	/**
	 * 결제금액
	 */
	@Schema(description = "결제금액", example = "", hidden = true, required = false, nullable = true)
	private Integer payAmt;
	/**
	 * 할인금액
	 */
	@Schema(description = "할인금액", example = "", hidden = true, required = false, nullable = true)
	private Integer saleAmt;
	/**
	 * 프로모션
	 */
	@Schema(description = "프로모션", example = "", hidden = false, required = false, nullable = true)
	private String mshipPromBasNos;
	/**
	 * 캠페인
	 */
	@Schema(description = "캠페인", example = "", hidden = false, required = false, nullable = true)
	private String campBasNos;
	/**
	 * 사용매장
	 */
	@Schema(description = "사용매장", example = "", hidden = false, required = false, nullable = true)
	private String useStorNo;
	/**
	 * 양도자
	 */
	@Schema(description = "양도자", example = "", hidden = false, required = false, nullable = true)
	private String trns;

	/**
	 * 발급구분코드
	 */
	@Schema(description = "발급구분코드", example = "", hidden = false, required = false, nullable = true)
	private String pblsDivCd;
	/**
	 * 매장체크
	 */
	@Schema(description = "매장체크", example = "", hidden = false, required = false, nullable = true)
	private String chkStor;
	/**
	 * 무기명여부
	 */
	@Schema(description = "무기명여부", example = "", hidden = false, required = false, nullable = true)
	@YnValue
	private String sgntYn;
	/**
	 * 사용구분코드
	 */
	@Schema(description = "사용구분", example = "", hidden = false, required = false, nullable = true)
	private String useDivCd;
	/**
	 * 채널코드
	 */
	@Schema(description = "채널코드", example = "", hidden = false, required = false, nullable = true)
	private String chlCd;
	/**
	 * 추천인고객번호
	 */
	@Schema(description = "추천인고객번호", example = "CST20220411121212001", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String rcmdrCustNo2;

	private String orgMshipPlcyBasNo;

	@Schema(description = "웰니스인식쿠폰여부", example = "", hidden = false, required = false, nullable = true)
	private String wellnessIdYn;

	@Schema(description = "웰니스쿠폰여부", example = "", hidden = false, required = false, nullable = true)
	private String wellnessYn;

//	@Schema(description = "상품목록", accessMode = AccessMode.READ_ONLY)
//	public List<CrmGodsBasVo> getGodsList() {
//		if (goods != null)
//			return goods;
//		goods = new ArrayList<CrmGodsBasVo>();
//
//		if (Utilities.isEmpty(godsNo))
//			return goods;
//
//		String[] arr = godsNo.split(",");
//		if (arr == null || arr.length == 0)
//			return goods;
//
//		for (int i = 0; i < arr.length; i++) {
//			String[] vals = arr[i].toString().split("\\|");
//			CrmGodsBasVo vo = new CrmGodsBasVo();
//			vo.setGodsNo(vals[0]);
//			vo.setGodsNm(vals[1]);
//			goods.add(vo);
//		}
//
//		return goods;
//	}
	@Schema(description = "직영몰쿠폰여부", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)

	public String getChlComYn() {
		return "COM".equals(getRegChlCd()) ? "Y" : "N";
	}

	@Schema(description = "쿠폰사용가능시작일", example = "20220101", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	public String getUseStartYmd() {
		String regDt = getRegDt();
		if (Utilities.isEmpty(regDt))
			regDt = Utilities.getDateString();
		else
			regDt = regDt.substring(0, 8);

		String stdDt = getFromUseStdDay();
		if (Utilities.isEmpty(stdDt))
			return regDt;
		return stdDt.compareTo(regDt) > 0 ? stdDt : regDt;
	}

	@Schema(description = "쿠폰사용가능종료일", example = "20221231", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	public String getUseEndYmd() {

		if ("Y".equals(getUseStdDayCondCd())) {
			String regDt = getRegDt();
			if (Utilities.isEmpty(regDt))
				regDt = Utilities.getDateString();
			else
				regDt = regDt.substring(0, 8);

			int days = Utilities.parseInt(getCoupnUsePossDay());
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd", Locale.KOREAN);

			Calendar cal = Calendar.getInstance();
			Date dt = null;
			try {
				dt = df.parse(regDt);
			} catch (ParseException e) {
				dt = new Date();
			}
			cal.setTime(dt);
			cal.add(Calendar.DATE, days);

			String stdDt = df.format(cal.getTime());
			if (Utilities.isEmpty(getToUseStdDay()))
				return stdDt;
			return stdDt.compareTo(getToUseStdDay()) < 0 ? stdDt : getToUseStdDay();

		} else {
			return getToUseStdDay();
		}
	}

}
