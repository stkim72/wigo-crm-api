package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DateValue;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipPromBasSo
 * @author 김성태
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description CRM멤버십프로모션기본 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십프로모션기본 검색 객체")
public class CrmMshipPromBasSo extends ApiPagination {
	/**
	 * 멤버십프로모션기본번호
	 */
	@Parameter(description = "멤버십프로모션기본번호", example = "", hidden = true, required = false)
	@Schema(description = "멤버십프로모션기본번호", example = "", hidden = true, required = false, nullable = true)
	private String mshipPromBasNo;
	/**
	 * 프로모션시작년월일
	 */
	@Parameter(description = "프로모션시작년월일", example = "", hidden = true, required = false)
	@Schema(description = "프로모션시작년월일", example = "", hidden = true, required = false, nullable = true)
	private String promStaYmd;
	/**
	 * 프로모션유형코드 공통코드 : PM100 [001 : 정기 , 002 : 이벤트 , 003 : 할인행사 , 004 : 체험단모집 , 005
	 * : 한정제품판매]
	 */
	@Parameter(description = "프로모션유형코드  [001 : 정기 , 002 : 이벤트 , 003 : 할인행사 , 004 : 체험단모집 , 005 : 한정제품판매]", example = "", hidden = true, required = false)
	@Schema(description = "프로모션유형코드  [001 : 정기 , 002 : 이벤트 , 003 : 할인행사 , 004 : 체험단모집 , 005 : 한정제품판매]", example = "", hidden = true, required = false, nullable = true)
	@CodeValue(codeId = "PM100", codes = { "001", "002", "003", "004",
			"005" }, message = "[001 : 정기 , 002 : 이벤트 , 003 : 할인행사 , 004 : 체험단모집 , 005 : 한정제품판매] 등록된 코드가 아닙니다. ")
	private String promTypeCd;
	/**
	 * 프로모션종료년월일
	 */
	@Parameter(description = "프로모션종료년월일", example = "", hidden = true, required = false)
	@Schema(description = "프로모션종료년월일", example = "", hidden = true, required = false, nullable = true)
	private String promEndYmd;
	/**
	 * 프로모션기본내용
	 */
	@Parameter(description = "프로모션기본내용", example = "", hidden = true, required = false)
	@Schema(description = "프로모션기본내용", example = "", hidden = true, required = false, nullable = true)
	private String promBasCtnts;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS ,
	 * BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]", example = "", hidden = true, required = false)
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]", example = "", hidden = true, required = false, nullable = true)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP", "POS", "BOS", "MEM", "CERA", "DNA",
			"IoT" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT] 등록된 코드가 아닙니다. ")
	private String regChlCd;
	/**
	 * 광고노출여부
	 */
	@Parameter(description = "광고노출여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "광고노출여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String advmShowYn;
	/**
	 * 사용채널정책코드
	 */
	@Parameter(description = "사용채널정책코드", example = "", hidden = true, required = false)
	@Schema(description = "사용채널정책코드", example = "", hidden = true, required = false, nullable = true)
	private String useChlPlcyCd;
	/**
	 * FROM적용매출금액
	 */
	@Parameter(description = "FROM적용매출금액", example = "", hidden = true, required = false)
	@Schema(description = "FROM적용매출금액", example = "", hidden = true, required = false, nullable = true)
	private Integer fromApplySaleAmt;
	/**
	 * TO적용매출금액
	 */
	@Parameter(description = "TO적용매출금액", example = "", hidden = true, required = false)
	@Schema(description = "TO적용매출금액", example = "", hidden = true, required = false, nullable = true)
	private Integer toApplySaleAmt;
	/**
	 * FROM적용매출조건코드 공통코드 : MB050 [01 : 이상 , 02 : 초과]
	 */
	@Parameter(description = "FROM적용매출조건코드  [01 : 이상 , 02 : 초과]", example = "", hidden = true, required = false)
	@Schema(description = "FROM적용매출조건코드  [01 : 이상 , 02 : 초과]", example = "", hidden = true, required = false, nullable = true)
	@CodeValue(codeId = "MB050", codes = { "01", "02" }, message = "[01 : 이상 , 02 : 초과] 등록된 코드가 아닙니다. ")
	private String fromApplySaleCondCd;
	/**
	 * TO적용매출조건코드 공통코드 : MB060 [01 : 이하 , 02 : 미만]
	 */
	@Parameter(description = "TO적용매출조건코드  [01 : 이하 , 02 : 미만]", example = "", hidden = true, required = false)
	@Schema(description = "TO적용매출조건코드  [01 : 이하 , 02 : 미만]", example = "", hidden = true, required = false, nullable = true)
	@CodeValue(codeId = "MB060", codes = { "01", "02" }, message = "[01 : 이하 , 02 : 미만] 등록된 코드가 아닙니다. ")
	private String toApplySaleCondCd;
	/**
	 * FROM적용결제금액
	 */
	@Parameter(description = "FROM적용결제금액", example = "", hidden = true, required = false)
	@Schema(description = "FROM적용결제금액", example = "", hidden = true, required = false, nullable = true)
	private Integer fromApplyPayAmt;
	/**
	 * TO적용결제금액
	 */
	@Parameter(description = "TO적용결제금액", example = "", hidden = true, required = false)
	@Schema(description = "TO적용결제금액", example = "", hidden = true, required = false, nullable = true)
	private Integer toApplyPayAmt;
	/**
	 * FROM적용결제조건코드 공통코드 : MB050 [01 : 이상 , 02 : 초과]
	 */
	@Parameter(description = "FROM적용결제조건코드  [01 : 이상 , 02 : 초과]", example = "", hidden = true, required = false)
	@Schema(description = "FROM적용결제조건코드  [01 : 이상 , 02 : 초과]", example = "", hidden = true, required = false, nullable = true)
	@CodeValue(codeId = "MB050", codes = { "01", "02" }, message = "[01 : 이상 , 02 : 초과] 등록된 코드가 아닙니다. ")
	private String fromApplyPayCondCd;
	/**
	 * TO적용결제조건코드 공통코드 : MB060 [01 : 이하 , 02 : 미만]
	 */
	@Parameter(description = "TO적용결제조건코드  [01 : 이하 , 02 : 미만]", example = "", hidden = true, required = false)
	@Schema(description = "TO적용결제조건코드  [01 : 이하 , 02 : 미만]", example = "", hidden = true, required = false, nullable = true)
	@CodeValue(codeId = "MB060", codes = { "01", "02" }, message = "[01 : 이하 , 02 : 미만] 등록된 코드가 아닙니다. ")
	private String toApplyPayCondCd;
	/**
	 * 적용멤버십등급코드
	 */
	@Parameter(description = "적용멤버십등급코드", example = "", hidden = true, required = false)
	@Schema(description = "적용멤버십등급코드", example = "", hidden = true, required = false, nullable = true)
	private String applyMshipGradeCd;
	/**
	 * 중복사용여부
	 */
	@Parameter(description = "중복사용여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "중복사용여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String dupUseYn;
	/**
	 * 적용혜택코드 공통코드 : PM120 [001 : 포인트 , 002 : 쿠폰]
	 */
	@Parameter(description = "적용혜택코드  [001 : 포인트 , 002 : 쿠폰]", example = "", hidden = true, required = false)
	@Schema(description = "적용혜택코드  [001 : 포인트 , 002 : 쿠폰]", example = "", hidden = true, required = false, nullable = true)
	@CodeValue(codeId = "PM120", codes = { "001", "002" }, message = "[001 : 포인트 , 002 : 쿠폰] 등록된 코드가 아닙니다. ")
	private String applyBnfitCd;
	/**
	 * 쿠폰적용구분코드1
	 */
	@Parameter(description = "쿠폰적용구분코드1", example = "", hidden = true, required = false)
	@Schema(description = "쿠폰적용구분코드1", example = "", hidden = true, required = false, nullable = true)
	private String coupnApplyDivCd1;
	/**
	 * 쿠폰적용구분코드2
	 */
	@Parameter(description = "쿠폰적용구분코드2", example = "", hidden = true, required = false)
	@Schema(description = "쿠폰적용구분코드2", example = "", hidden = true, required = false, nullable = true)
	private String coupnApplyDivCd2;
	/**
	 * 적용할인율
	 */
	@Parameter(description = "적용할인율", example = "", hidden = true, required = false)
	@Schema(description = "적용할인율", example = "", hidden = true, required = false, nullable = true)
	private Integer applyDcRate;
	/**
	 * 적용할인금액
	 */
	@Parameter(description = "적용할인금액", example = "", hidden = true, required = false)
	@Schema(description = "적용할인금액", example = "", hidden = true, required = false, nullable = true)
	private Integer applyDcAmt;
	/**
	 * 포인트적립율
	 */
	@Parameter(description = "포인트적립율", example = "", hidden = true, required = false)
	@Schema(description = "포인트적립율", example = "", hidden = true, required = false, nullable = true)
	private Integer pointAccumRate;
	/**
	 * 스탬프제공수
	 */
	@Parameter(description = "스탬프제공수", example = "", hidden = true, required = false)
	@Schema(description = "스탬프제공수", example = "", hidden = true, required = false, nullable = true)
	private Integer stmpPrvCnt;
	/**
	 * 제공쿠폰기본번호
	 */
	@Parameter(description = "제공쿠폰기본번호", example = "", hidden = true, required = false)
	@Schema(description = "제공쿠폰기본번호", example = "", hidden = true, required = false, nullable = true)
	private String prvCoupnBasNo;
	/**
	 * 상태코드 공통코드 : PM110 [001 : 대기중 , 002 : 진행중 , 003 : 승인대기중 , 004 : 기타]
	 */
	@Parameter(description = "상태코드  [001 : 대기중 , 002 : 진행중 , 003 : 승인대기중 , 004 : 기타]", example = "", hidden = true, required = false)
	@Schema(description = "상태코드  [001 : 대기중 , 002 : 진행중 , 003 : 승인대기중 , 004 : 기타]", example = "", hidden = true, required = false, nullable = true)
	@CodeValue(codeId = "PM110", codes = { "001", "002", "003",
			"004" }, message = "[001 : 대기중 , 002 : 진행중 , 003 : 승인대기중 , 004 : 기타] 등록된 코드가 아닙니다. ")
	private String statusCd;
	/**
	 * 프로모션기본명
	 */
	@Parameter(description = "프로모션기본명", example = "", hidden = true, required = false)
	@Schema(description = "프로모션기본명", example = "", hidden = true, required = false, nullable = true)
	private String promBasNm;
	/**
	 * 적용회원등급내용 공통코드 : MB020 [002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 :
	 * VIP , 001 : 일반]
	 */
	@Parameter(description = "적용회원등급내용 ,구분 [002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP , 001 : 일반]", example = "", hidden = true, required = false)
	@Schema(description = "적용회원등급내용  [002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP , 001 : 일반]", example = "", hidden = true, required = false, nullable = true)
	private String applyMshpGradeCtnts;
	/**
	 * 적용멤버십등급코드1
	 */
	@Parameter(description = "적용멤버십등급코드1", example = "", hidden = true, required = false)
	@Schema(description = "적용멤버십등급코드1", example = "", hidden = true, required = false, nullable = true)
	private String applyMshipGradeCd1;
	/**
	 * 제휴회사번호
	 */
	@Parameter(description = "제휴회사번호", example = "", hidden = true, required = false)
	@Schema(description = "제휴회사번호", example = "", hidden = true, required = false, nullable = true)
	private String cprtCmpNo;
	/**
	 * 적용포인트점수
	 */
	@Parameter(description = "적용포인트점수", example = "", hidden = true, required = false)
	@Schema(description = "적용포인트점수", example = "", hidden = true, required = false, nullable = true)
	private Integer applyPointScore;

	/**
	 * 기준일
	 */
	@Parameter(description = "기준일 [빈값일시 현재일]", example = "", hidden = false, required = false)
	@Schema(description = "기준일", example = "", hidden = false, required = false, nullable = true)
	@DateValue
	private String stdDt;

	/**
	 * 매장코드
	 */
	@Parameter(description = "적용매장", example = "", hidden = false, required = false)
	@Schema(description = "적용매장", example = "", hidden = false)
	private String storNo;

	/**
	 * 상품코드
	 */
	@Parameter(description = "적용상품", example = "", hidden = false, required = false)
	@Schema(description = "적용상품", example = "", hidden = false)
	private String godsNo;

	/**
	 * 매출금액
	 */
	@Parameter(description = "매출금액", example = "", hidden = false, required = false)
	@Schema(description = "매출금액", example = "", hidden = false)
	private Integer saleAmt;

	/**
	 * 결제금액
	 */
	@Parameter(description = "결제금액", example = "", hidden = false, required = false)
	@Schema(description = "결제금액", example = "", hidden = false)
	private Integer payAmt;
}
