package com.ceragem.api.crm.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DateValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmPointHstVo
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM포인트이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM포인트이력 객체")
public class CrmPointHstVo extends ApiBaseVo {

	/**
	 * 검색시작일
	 */
	@Schema(description = "검색시작일", example = "", hidden = true, required = false, nullable = true)
	@DateValue
	private String startDt;
	/**
	 * 검색종료일
	 */
	@Schema(description = "검색종료일", example = "", hidden = true, required = false, nullable = true)
	@DateValue
	private String endDt;
	/**
	 * 포인트이력일련번호
	 */
	@Schema(description = "포인트이력일련번호[자동생성]", example = "", hidden = false, required = false, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String pointHstSeq;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	@NotEmpty
	private String itgCustNo;

	/**
	 * 추천인통합번호
	 */
	@Schema(description = "추천인통합고객번호", example = "", hidden = false, required = false, nullable = true)
	private String rcmdrCustNo;

	/**
	 * 멤버십등급코드 공통코드 : MB020 [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드
	 * , 006 : VIP]
	 */
	@Schema(description = "멤버십등급코드  [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "MB020", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String mshipGradeCd;
	@Schema(description = "멤버십등급코드명", example = "", hidden = false, required = false, nullable = true)
	private String mshipGradeCdNm;
	/**
	 * 매장번호
	 */
	@Schema(description = "매장번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String storNo;
	/**
	 * 매장명
	 */
	@Schema(description = "매장명", example = "", hidden = false, required = false, nullable = true)
	private String storNoNm;
	/**
	 * 전표번호
	 */
	@Schema(description = "전표번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String chitNo;
	/**
	 * 구매제품번호
	 */
	@Schema(description = "구매제품번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String buyGodsNo;
	/**
	 * 구매제품명
	 */
	@Schema(description = "구매제품명", example = "", hidden = false, required = false, nullable = true)
	private String buyGodsNoNm;
	/**
	 * 주문금액
	 */
	@Schema(description = "주문금액", example = "", hidden = false, required = false, nullable = true)
	private Integer ordrAmt;
	/**
	 * 적용금액
	 */
	@Schema(description = "적용금액", example = "", hidden = false, required = false, nullable = true)
	private Integer applyAmt;
	/**
	 * 결제금액
	 */
	@Schema(description = "결제금액", example = "", hidden = false, required = false, nullable = true)
	private Integer payAmt;
	/**
	 * 발행구분코드 공통코드 : EV100 [010 : 웰카페 체험추천 , 020 : 홈체험 추천 , 030 : 멤버십 가입 추천 , 040 :
	 * 웰카페 체험 , 050 : 홈체험 , 060 : 멤버십회원 가입 , 070 : 마케팅정보 수신동의 , 080 : 앱 다운로드 , 090 :
	 * 추가 정보 입력 , 100 : 생일 , 110 : 휴면방지 , 120 : 휴면해제 , 130 : 출석체크 , 140 : 텍스트 후기 작성
	 * , 150 : 이미지 후기 작성 , 160 : 동영상 후기 작성 , 170 : 세라체크 , 180 : 서베이 , 190 : IoT]
	 */
	@Schema(description = "발행구분코드  [010 : 웰카페 체험추천 , 020 : 홈체험 추천 , 030 : 멤버십 가입 추천 , 040 : 웰카페 체험 , 050 : 홈체험 , 060 : 멤버십회원 가입 , 070 : 마케팅정보 수신동의 , 080 : 앱 다운로드 , 090 : 추가 정보 입력 , 100 : 생일 , 110 : 휴면방지 , 120 : 휴면해제 , 130 : 출석체크 , 140 : 텍스트 후기 작성 , 150 : 이미지 후기 작성 , 160 : 동영상 후기 작성 , 170 : 세라체크 , 180 : 서베이 , 190 : IoT , 901 : 구매, 902 : 구매추천, 903 : 스탬프, 904 : 쿠폰, 905 : 프로모션, 940 : 수기차감, 950 : 수기지급, 960 : 캠페인지급, 970 : 승급, 999 :기타]", example = "001", hidden = false, required = true, nullable = true, maxLength = 3)
	@CodeValue(codeId = "EV100", codes = { "010", "020", "030", "040", "050", "060", "070", "080", "090", "100", "110",
			"120", "130", "140", "150", "160", "170", "180", "190", "200", "210", "901", "902", "903", "904", "905",
			"940", "950", "960", "970",
			"999" }, message = "[010 : 웰카페 체험추천 , 020 : 홈체험 추천 , 030 : 멤버십 가입 추천 , 040 : 웰카페 체험 , 050 : 홈체험 , 060 : 멤버십회원 가입 , 070 : 마케팅정보 수신동의 , 080 : 앱 다운로드 , 090 : 추가 정보 입력 , 100 : 생일 , 110 : 휴면방지 , 120 : 휴면해제 , 130 : 출석체크 , 140 : 텍스트 후기 작성 , 150 : 이미지 후기 작성 , 160 : 동영상 후기 작성 , 170 : 세라체크 , 180 : 서베이 , 190 : IoT , 901 : 구매, 902 : 구매추천, 903 : 스탬프, 904 : 쿠폰, 905 : 프로모션, 940 : 수기차감, 950 : 수기지급, 960 : 캠페인지급, 970 : 승급, 999 :기타] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	@NotEmpty(message = "[발행/사용]구분코드를 입력해야 합니다.")
	private String pblsDivCd;

	@Schema(description = "발행구분코드명", example = "구매포인트", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String pblsDivNm;

	/**
	 * 발생포인트점수
	 */
//	@Min(value = 1)
//	@NotNull
	@Schema(description = "발생포인트점수", example = "100", hidden = false, required = false, nullable = true)
	private Integer occurPointScore;

	/**
	 * 잔여포인트점수
	 */
	@Schema(description = "잔여포인트점수", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private Integer remainPointScore;
	/**
	 * 실제포인트점수
	 */
	@Schema(description = "실제포인트점수", example = "", hidden = true, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private int pointScore;
	/**
	 * 실제포인트점수
	 */
	@Schema(description = "실제만료포인트점수", example = "", hidden = true, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private int expireScore;

	/**
	 * 유효기간시작년월일
	 */
	@Schema(description = "유효기간시작년월일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	@DateValue
	private String validPerdStaYmd;
	/**
	 * 유효기간종료년월일
	 */
	@Schema(description = "유효기간종료년월일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	@DateValue
	private String validPerdEndYmd;

	@Schema(description = "원 유효기간종료년월일", example = "", hidden = true, required = false, nullable = true, maxLength = 8)
	private String orgValidPerdEndYmd;
	/**
	 * 발행일시
	 */
	@Schema(description = "발행일시 (YYYYMMDDHH24MISS)", example = "20220421161132", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String pblsDt;
	/**
	 * 소멸일시
	 */
	@Schema(description = "소멸일시 (YYYYMMDDHH24MISS)", example = "20220421161132", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String extncDt;
	/**
	 * 내역
	 */
	@Schema(description = "내역", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String txn;
	/**
	 * 발행채널코드 공통코드 : S000 [CTC : 상담 , AS : AS , SAP : SAP , test : test]
	 */
	@Schema(description = "발행채널코드  [CTC : 상담 , AS : AS , SAP : SAP , test : test]", example = "CTC", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CTC", "AS", "SAP",
			"test" }, message = "[CTC : 상담 , AS : AS , SAP : SAP , test : test] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String pblsChlCd;

	@Schema(description = "발행채널코드명", example = "", hidden = true, required = false, nullable = true)
	private String pblsChlCdNm;
	/**
	 * 카드발행이력일련번호
	 */
	@Schema(description = "카드발행이력일련번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String cardPblsHstSeq;
	/**
	 * 사용유형코드 공통코드 : PO010 [001 : 사용 , 002 : 적립 , 003 : 취소]
	 */
	@Schema(description = "사용유형코드  [001 : 사용 , 002 : 적립 , 003 : 취소, 004 : 소멸]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "PO010", codes = { "001", "002",
			"003" }, message = "[001 : 사용 , 002 : 적립 , 003 : 취소 , 004 : 소멸] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String useTypeCd;

	@Schema(description = "사용유형코드명", example = "사용", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String useTypeNm;
	/**
	 * 거래번호
	 */
	@Schema(description = "거래번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String dealNo;
	/**
	 * 프로모션번호
	 */
	@Schema(description = "프로모션번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String promNo;
	/**
	 * 캠페인번호
	 */
	@Schema(description = "캠페인번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String campNo;
	/**
	 * 쿠폰번호
	 */
	@Schema(description = "쿠폰번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String coupnNo;
	/**
	 * 사용일시
	 */
	@Schema(description = "사용일시 (YYYYMMDDHH24MISS)", example = "20220421161132", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String useDt;
	/**
	 * 등록채널코드 공통코드 : S000 [CTC : 상담 , AS : AS , SAP : SAP , test : test]
	 */
	@Schema(description = "등록채널코드  [CTC : 상담 , AS : AS , SAP : SAP , test : test]", example = "CTC", hidden = false, required = true, nullable = false, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CTC", "AS", "SAP",
			"test" }, message = "[CTC : 상담 , AS : AS , SAP : SAP , test : test] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;

	@Schema(description = "사용포인트점수", example = "100", hidden = true, required = false, nullable = true)
	private int usePointScore = 0;

	/**
	 * 구매보상승급율
	 */
	@Schema(description = "구매보상승급점수", example = "", hidden = true, required = false, nullable = true)
	private int buyRewardAdvncmtScore;

	/**
	 * 구매추천보상승급율
	 */
	@Schema(description = "구매추천보상승급점수", example = "", hidden = true, required = false, nullable = true)
	private int buyRcmdRewardAdvncmtScore;

	/**
	 * 구매적립포인트율
	 */
	@Schema(description = "구매적립포인트점수", example = "", hidden = true, required = false, nullable = true)
	private int buyAccumPointScore;

	/**
	 * 구매추천포인트율
	 */
	@Schema(description = "구매추천포인트점수", example = "", hidden = true, required = false, nullable = true)
	private int buyRcmdPointScore;

	/**
	 * 구매추천포인트율
	 */
	@Schema(description = "포인트지급리스트", example = "", hidden = true, required = false, nullable = true)
	private List<CrmPointItemVo> crmPointHsList;

	/**
	 * 구매추천포인트율
	 */
	@Schema(description = "승급지급리스트", example = "", hidden = true, required = false, nullable = true)
	private List<CrmPointItemVo> crmAdvncmtHsList;

	/**
	 * 구매추천포인트율
	 */
	@Schema(description = "구매아이템리스트", example = "", hidden = true, required = false, nullable = true)
	private List<CrmPointItemVo> crmPointHsItemList;

	/**
	 * 승급이력일련번호
	 */
	@Schema(description = "승급이력일련번호", example = "", hidden = true, required = false, nullable = true)
	private String advncmtHstSeq;

	/**
	 * 발생등급점수
	 */
	@Schema(description = "발생등급점수", example = "", hidden = true, required = false, nullable = true)
	private Integer occurAdvncmtScore;

	/**
	 * 잔여등급점수
	 */
	@Schema(description = "잔여등급점수", example = "", hidden = true, required = false, nullable = true)
	private Integer remainAdvncmtScore;

	@Schema(description = "포인트적립여부", example = "", hidden = true, required = false, nullable = true)
	private String accumYn;

	@Schema(description = "추천인회원등급", example = "", hidden = true, required = false, nullable = true)
	private String rcmdrMshipGradeCd; // 추천인회원등급

	@Schema(description = "1일적립포인트", example = "", hidden = true, required = false, nullable = true)
	private Integer todayPblsPnt;

	@Schema(description = "1일적립가능포인트", example = "", hidden = true, required = false, nullable = true)
	private Integer accumLmtPointScore;

	@Schema(description = "포인트정책체크값", example = "", hidden = true, required = false, nullable = true)
	private String plcyChkSatus;

	@Schema(description = "추천지급여부", example = "", hidden = true, required = false, nullable = true)
	private String rcmdYn;

	@Schema(description = "알림톡전송여부", example = "", hidden = true, required = false, nullable = true)
	private String messageYn = "Y";

	/**
	 * 추천인통합번호
	 */
	@Schema(description = "추천인통합고객번호", example = "", hidden = true, required = false, nullable = true)
	private String rcmdrCustNo2;

	@Schema(description = "취소전표번호", example = "", hidden = true, required = false, nullable = true)
	private String orgChitNo;

	@Schema(description = "비고", example = "", hidden = true, required = false, nullable = true)
	private String rmark;
	/**
	 * 사용포인트점수
	 */
	@Schema(description = "사용포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer usePoint;

	@Schema(description = "가용포인트점수", example = "100", hidden = true, required = false, nullable = true)
	public int getAvailableScore() {
		if (occurPointScore == null)
			occurPointScore = 0;
//		if (usePointScore != 0)
		return occurPointScore - usePointScore;
//		return remainPointScore;
	}

	/**
	 * 임시유효기간 [이벤트 중 유효기간 동적처리]
	 */
	@Schema(description = "임시유효기간", example = "", hidden = true, required = false, nullable = true)
	@MaxByte(max = 8)
	@DateValue
	private String temValidPerdYmd;

	/**
	 * 취소유효기간순번
	 */
	@Schema(description = "취소유효기간순번", example = "", hidden = true, required = false, nullable = true)
	private String pointPerdHstSeq;

	/**
	 * 사용참조순번
	 */
	@Schema(description = "사용참조순번", example = "", hidden = true, required = false, nullable = true)
	private String pointSeq;

	@Schema(description = "카드번호", example = "", hidden = false, required = false, nullable = true)
	public String getCardNo() {
		return cardPblsHstSeq;
	}

	public void setCardNo(String cardNo) {
		this.cardPblsHstSeq = cardNo;
	}

}
