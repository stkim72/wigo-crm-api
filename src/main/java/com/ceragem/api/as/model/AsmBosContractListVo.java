package com.ceragem.api.as.model;

import java.math.BigDecimal;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmBosContractListVo
 * @author 이윤성
 * @date 2022. 5. 30.
 * @Version 1.0
 * @description BOS계약내역 목록 Vo
 */
@Getter
@Setter
@Schema(description = "BOS계약내역 목록 객체")
public class AsmBosContractListVo extends ApiBaseVo {

	/**
	 * (PK)고유번호 (hidden)
	 */
	@Schema(description = "(PK)고유번호", example = "", hidden = true, required = true, nullable = false)
	private int seq;
	/**
	 * 통합고객번호 (hidden)
	 */
	@Schema(description = "통합고객번호", example = "", hidden = true, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 조회건수(임시) (hidden)
	 */
	@Schema(description = "조회건수(임시)", example = "", hidden = true, required = true, nullable = false)
	private int rtnCnt;

	/**
	 * 주문 일자
	 */
	@Schema(description = "주문 일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String ordDe;

	/**
	 * 판매 구분 코드
	 */
	@Schema(description = "판매 구분 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String saleSeCd;

	/**
	 * 판매 구분 명
	 */
	@Schema(description = "판매 구분 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String saleSeNm;

	/**
	 * 판매 유형 코드
	 */
	@Schema(description = "판매 유형 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String saleTyCd;

	/**
	 * 판매 유형 명
	 */
	@Schema(description = "판매 유형 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String saleTyNm;

	/**
	 * 판매 그룹 코드
	 */
	@Schema(description = "판매 그룹 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String saleGrpCd;

	/**
	 * 판매 그룹 명
	 */
	@Schema(description = "판매 그룹 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String saleGrpNm;

	/**
	 * 주문 구분 코드
	 */
	@Schema(description = "주문 구분 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String ordSeCd;

	/**
	 * 주문 구분 명
	 */
	@Schema(description = "주문 구분 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String ordSeNm;

	/**
	 * 주문 채널 코드
	 */
	@Schema(description = "주문 채널 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String ordChnCd;

	/**
	 * 주문 채널 명
	 */
	@Schema(description = "주문 채널 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String ordChnNm;

	/**
	 * 주문 번호
	 */
	@Schema(description = "주문 번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String ordNo;

	/**
	 * 주문 번호 순번
	 */
	@Schema(description = "주문 번호 순번", example = "", hidden = false, required = true, nullable = false)
	private int ordNoSn;

	/**
	 * 계약번호
	 */
	@Schema(description = "계약번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String cntrNo;

	/**
	 * 고객번호
	 */
	@Schema(description = "고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String custNo;

	/**
	 * 고객 명
	 */
	@Schema(description = "고객 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;

	/**
	 * 품목유형코드(카테고리2)
	 */
	@Schema(description = "품목유형코드(카테고리2)", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String itemTyCd;

	/**
	 * 품목유형명(카테고리2)
	 */
	@Schema(description = "품목유형명(카테고리2)", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String itemTyNm;

	/**
	 * 품목코드(제품코드)
	 */
	@Schema(description = "품목코드(제품코드)", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String itemCd;

	/**
	 * SAP품목코드
	 */
	@Schema(description = "SAP품목코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String baseItemCd;

	/**
	 * 품목명(제품명)
	 */
	@Schema(description = "품목명(제품명)", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String itemNm;

	/**
	 * 계약 수량
	 */
	@Schema(description = "계약 수량", example = "", hidden = false, required = true, nullable = false)
	private int cntrQy;

	/**
	 * 할인율 (%가 포함되서, String으로 변경함)
	 */
	@Schema(description = "할인율", example = "", hidden = false, required = true, nullable = false)
	private String dcrt;

	/**
	 * 할인금액
	 */
	@Schema(description = "할인금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal dcAmt;

	/**
	 * 가격 정책 번호
	 */
	@Schema(description = "가격 정책 번호", example = "", hidden = false, required = true, nullable = false, maxLength = 15)
	@MaxByte(max = 15)
	private String prcPlcNo;

	/**
	 * 가격 정책 명
	 */
	@Schema(description = "가격 정책 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String prcPlcNm;

	/**
	 * 사은품 내역
	 */
	@Schema(description = "사은품 내역", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
	@MaxByte(max = 1000)
	private String prsntDtls;

	/**
	 * 계약상태코드
	 */
	@Schema(description = "계약상태코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String cntrStsCd;

	/**
	 * 계약상태
	 */
	@Schema(description = "계약상태", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String cntrStsNm;

	/**
	 * 계약상태상세코드
	 */
	@Schema(description = "계약상태상세코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String cntrStsDtlCd;

	/**
	 * 계약상태상세
	 */
	@Schema(description = "계약상태상세", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String cntrStsDtlNm;

	/**
	 * 계약상태상세사유
	 */
	@Schema(description = "계약상태상세사유", example = "", hidden = false, required = true, nullable = false, maxLength = 300)
	@MaxByte(max = 300)
	private String cntrStsDtlRsn;

	/**
	 * 결제상태코드
	 */
	@Schema(description = "결제상태코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String setlStsCd;

	/**
	 * 결제상태명
	 */
	@Schema(description = "결제상태명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String setlStsNm;

	/**
	 * 설치상태코드
	 */
	@Schema(description = "설치상태코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String istStsCd;

	/**
	 * 설치상태명
	 */
	@Schema(description = "설치상태명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String istStsNm;

	/**
	 * 출고상태
	 */
	@Schema(description = "출고상태", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String otbnStsCd;

	/**
	 * 출고상태명
	 */
	@Schema(description = "출고상태명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String otbnStsNm;

	/**
	 * 판매 본부 코드
	 */
	@Schema(description = "판매 본부 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String hqSeCd;

	/**
	 * 판매 본부 명
	 */
	@Schema(description = "판매 본부 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String hqSeNm;

	/**
	 * 상위 조직 코드
	 */
	@Schema(description = "상위 조직 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String upperOrgzCd;

	/**
	 * 상위 조직 명
	 */
	@Schema(description = "상위 조직 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String upperOrgzNm;

	/**
	 * 판매조직코드
	 */
	@Schema(description = "판매조직코드", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String saleOrgz;

	/**
	 * 판매조직명
	 */
	@Schema(description = "판매조직명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String saleOrgzNm;

	/**
	 * 판매조직고객코드(SAP)
	 */
	@Schema(description = "판매조직고객코드(SAP)", example = "", hidden = false, required = true, nullable = false, maxLength = 64)
	@MaxByte(max = 64)
	private String saleOrgzCustCd;

	/**
	 * 판매인코드
	 */
	@Schema(description = "판매인코드", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String seller;

	/**
	 * 판매인명
	 */
	@Schema(description = "판매인명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String sellerNm;

	/**
	 * 스폰서 ID
	 */
	@Schema(description = "스폰서 ID", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String sponsorId;

	/**
	 * 스폰서 명
	 */
	@Schema(description = "스폰서 명 ", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String sponsorNm;

	/**
	 * 추천인 코드
	 */
	@Schema(description = "추천인 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String rcmdr;

	/**
	 * 추천인 명
	 */
	@Schema(description = "추천인 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String rcmdrNm;

	/**
	 * 추천고객 ID
	 */
	@Schema(description = "추천고객 ID", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String rcmdrMbrshId;

	/**
	 * 추천고객 명
	 */
	@Schema(description = "추천고객 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String rcmdrMbrshNm;

	/**
	 * 계약 취소 여부
	 */
	@Schema(description = "계약 취소 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String cntrCnclYn;

	/**
	 * 계약 취소 일자
	 */
	@Schema(description = "계약 취소 일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String cntrCnclDe;

	/**
	 * 계약 취소 사유
	 */
	@Schema(description = "계약 취소 사유", example = "", hidden = false, required = true, nullable = false, maxLength = 300)
	@MaxByte(max = 300)
	private String cntrCnclRsn;

	/**
	 * 약정 기간 코드
	 */
	@Schema(description = "약정 기간 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String agrPdCd;

	/**
	 * 약정 기간 명
	 */
	@Schema(description = "약정 기간 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String agrPdNm;

	/**
	 * 계약 기간 값
	 */
	@Schema(description = "계약 기간 값", example = "", hidden = false, required = true, nullable = false)
	private int cntrPdVal;

	/**
	 * 기간 구분 (M:월, D:일)
	 */
	@Schema(description = "기간 구분 (M:월, D:일)", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String cntrPdSeCd;

	/**
	 * 홈체험 청구할인 개월
	 */
	@Schema(description = "홈체험 청구할인 개월", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String exprnDmdDcPdCd;

	/**
	 * 선납 여부
	 */
	@Schema(description = "선납 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String prepayYn;

	/**
	 * 선납 금액
	 */
	@Schema(description = "선납 금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal prepayAmt;

	/**
	 * 선납 주기
	 */
	@Schema(description = "선납 주기", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String prepayCycle;

	/**
	 * 등록비
	 */
	@Schema(description = "등록비", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal regfee;

	/**
	 * 기본 렌탈 금액
	 */
	@Schema(description = "기본 렌탈 금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal bassRentAmt;

	/**
	 * 렌탈 금액
	 */
	@Schema(description = "렌탈 금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal rentAmt;

	/**
	 * 기본 판매 금액
	 */
	@Schema(description = "기본 판매 금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal bassSaleAmt;

	/**
	 * 판매 금액
	 */
	@Schema(description = "판매 금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal saleAmt;

	/**
	 * 결제 금액
	 */
	@Schema(description = "결제 금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal setlAmt;

	/**
	 * 기본 멤버십 금액
	 */
	@Schema(description = "기본 멤버십 금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal bassMbrshAmt;

	/**
	 * 멤버십 금액
	 */
	@Schema(description = "멤버십 금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal mbrshAmt;

	/**
	 * 컨택 일자
	 */
	@Schema(description = "컨택 일자", example = "", hidden = false, required = true, nullable = false)
	private String cntcDe;

	/**
	 * 설치예정일시
	 */
	@Schema(description = "설치예정일시", example = "", hidden = false, required = true, nullable = false)
	private String istDueDe;

	/**
	 * 출고일
	 */
	@Schema(description = "출고일", example = "", hidden = false, required = true, nullable = false)
	private String otbnDe;

	/**
	 * 설치처 고객 명
	 */
	@Schema(description = "설치처 고객 명", example = "", hidden = false, required = true, nullable = false)
	private String istCustNm;

	/**
	 * 설치처 우편번호
	 */
	@Schema(description = "설치처 우편번호", example = "", hidden = false, required = true, nullable = false)
	private String zip;

	/**
	 * 설치처 기본주소
	 */
	@Schema(description = "설치처 기본주소", example = "", hidden = false, required = true, nullable = false)
	private String bassAddr;

	/**
	 * 설치처 상세주소
	 */
	@Schema(description = "설치처 상세주소", example = "", hidden = false, required = true, nullable = false)
	private String dtlAddr;

	/**
	 * 창고 코드
	 */
	@Schema(description = "창고 코드", example = "", hidden = false, required = true, nullable = false)
	private String wrhCd;

	/**
	 * 창고 명
	 */
	@Schema(description = "창고 명", example = "", hidden = false, required = true, nullable = false)
	private String wrhNm;

	/**
	 * 출고처
	 */
	@Schema(description = "출고처", example = "", hidden = false, required = true, nullable = false)
	private String otbnCustNo;

	/**
	 * 설치 예정 조직 코드
	 */
	@Schema(description = "설치 예정 조직 코드", example = "", hidden = false, required = true, nullable = false)
	private String istDueOrgz;

	/**
	 * 설치 예정 조직 명
	 */
	@Schema(description = "설치 예정 조직 명", example = "", hidden = false, required = true, nullable = false)
	private String istDueOrgzNm;

	/**
	 * 설치 예정 기사 코드
	 */
	@Schema(description = "설치 예정 기사 코드", example = "", hidden = false, required = true, nullable = false)
	private String istDueEngr;

	/**
	 * 설치 예정 기사 명
	 */
	@Schema(description = "설치 예정 기사 명", example = "", hidden = false, required = true, nullable = false)
	private String istDueEngrNm;

	/**
	 * 설치 확정 일자
	 */
	@Schema(description = "설치 확정 일자", example = "", hidden = false, required = true, nullable = false)
	private String istDcsDe;

	/**
	 * 매출 확정 일자
	 */
	@Schema(description = "매출 확정 일자", example = "", hidden = false, required = true, nullable = false)
	private String selngDcsDe;

	/**
	 * 맞교환 설치 일자
	 */
	@Schema(description = "맞교환 설치 일자", example = "", hidden = false, required = true, nullable = false)
	private String procDe;

	/**
	 * 설치취소사유코드
	 */
	@Schema(description = "설치취소사유코드", example = "", hidden = false, required = true, nullable = false)
	private String nprocRsnCd;

	/**
	 * 이관사유 코드
	 */
	@Schema(description = "이관사유 코드", example = "", hidden = false, required = true, nullable = false)
	private String trfRsnCd;

	/**
	 * 이관사유 명
	 */
	@Schema(description = "이관사유 명", example = "", hidden = false, required = true, nullable = false)
	private String trfRsnNm;

	/**
	 * 반환 유형 코드
	 */
	@Schema(description = "반환 유형 코드", example = "", hidden = false, required = true, nullable = false)
	private String rtgdTyCd;

	/**
	 * 반환 유형 명
	 */
	@Schema(description = "반환 유형 명", example = "", hidden = false, required = true, nullable = false)
	private String rtgdTyNm;

	/**
	 * 반환 요청 일자
	 */
	@Schema(description = "반환 요청 일자", example = "", hidden = false, required = true, nullable = false)
	private String rtgdReqDe;

	/**
	 * 반환 확정 여부
	 */
	@Schema(description = "반환 확정 여부", example = "", hidden = false, required = true, nullable = false)
	private String rtgdDcsYn;

	/**
	 * 반환 종료 일자
	 */
	@Schema(description = "반환 종료 일자", example = "", hidden = false, required = true, nullable = false)
	private String rtgdEndDe;

	/**
	 * 패키지여부
	 */
	@Schema(description = "패키지여부", example = "", hidden = false, required = true, nullable = false)
	private String pkgYn;

	/**
	 * 패키지 정책 번호
	 */
	@Schema(description = "패키지 정책 번호", example = "", hidden = false, required = true, nullable = false)
	private String pkgPlcNo;

	/**
	 * 패키지 번호
	 */
	@Schema(description = "패키지 번호", example = "", hidden = false, required = true, nullable = false)
	private String pkgNo;

	/**
	 * 그룹 여부
	 */
	@Schema(description = "그룹 여부", example = "", hidden = false, required = true, nullable = false)
	private String grpYn;

	/**
	 * 그룹 번호
	 */
	@Schema(description = "그룹 번호", example = "", hidden = false, required = true, nullable = false)
	private String grpNo;

	/**
	 * 홈체험 계약 번호
	 */
	@Schema(description = "홈체험 계약 번호", example = "", hidden = false, required = true, nullable = false)
	private String exprnCntrNo;

	/**
	 * 배송유형코드
	 */
	@Schema(description = "배송유형코드", example = "", hidden = false, required = true, nullable = false)
	private String dlvTyCd;

	/**
	 * 배송유형명
	 */
	@Schema(description = "배송유형명", example = "", hidden = false, required = true, nullable = false)
	private String dlvTyNm;

	/**
	 * 배송 유형 상세 코드
	 */
	@Schema(description = "배송 유형 상세 코드", example = "", hidden = false, required = true, nullable = false)
	private String dlvTyDtlCd;

	/**
	 * 배송유형상세명
	 */
	@Schema(description = "배송유형상세명", example = "", hidden = false, required = true, nullable = false)
	private String dlvTyDtlNm;

	/**
	 * 청구스케줄 생성 여부
	 */
	@Schema(description = "청구스케줄 생성 여부", example = "", hidden = false, required = true, nullable = false)
	private String shdeCreYn;

	/**
	 * 계약 종료 이후 처리 방법 코드
	 */
	@Schema(description = "계약 종료 이후 처리 방법 코드", example = "", hidden = false, required = true, nullable = false)
	private String cntrEndAfterProcMthCd;

	/**
	 * 계약 종료 이후 처리 방법 명
	 */
	@Schema(description = "계약 종료 이후 처리 방법 명", example = "", hidden = false, required = true, nullable = false)
	private String cntrEndAfterProcMthNm;

	/**
	 * 정기결제 방법 코드
	 */
	@Schema(description = "정기결제 방법 코드", example = "", hidden = false, required = true, nullable = false)
	private String fsetlMthCd;

	/**
	 * 정기결제 방법 명
	 */
	@Schema(description = "정기결제 방법 명", example = "", hidden = false, required = true, nullable = false)
	private String fsetlMthNm;

	/**
	 * 정기결제 일자
	 */
	@Schema(description = "정기결제 일자", example = "", hidden = false, required = true, nullable = false)
	private String fsetlDeCd;

	/**
	 * SIGN 파일 여부
	 */
	@Schema(description = "SIGN 파일 여부", example = "", hidden = false, required = true, nullable = false)
	private String signFileYn;

	/**
	 * 계약서 파일 여부
	 */
	@Schema(description = "계약서 파일 여부", example = "", hidden = false, required = true, nullable = false)
	private String ctrtcFileYn;

	/**
	 * 등록자 ID
	 */
	@Schema(description = "등록자 ID", example = "", hidden = false, required = true, nullable = false)
	private String regUsrId;

	/**
	 * 등록일시
	 */
	@Schema(description = "등록일시", example = "", hidden = false, required = true, nullable = false)
	private String regDt;

	/**
	 * 수정자 ID
	 */
	@Schema(description = "수정자 ID", example = "", hidden = false, required = true, nullable = false)
	private String updUsrId;

	/**
	 * 수정일시
	 */
	@Schema(description = "수정일시", example = "", hidden = false, required = true, nullable = false)
	private String updDt;

	/**
	 * 계약 시작 일자
	 */
	@Schema(description = "계약 시작 일자", example = "", hidden = false, required = true, nullable = false)
	private String cntrStartDe;

	/**
	 * 계약 종료 예정 일자
	 */
	@Schema(description = "계약 종료 예정 일자", example = "", hidden = false, required = true, nullable = false)
	private String cntrEndDueDe;

	/**
	 * 계약 종료 여부
	 */
	@Schema(description = "계약 종료 여부", example = "", hidden = false, required = true, nullable = false)
	private String cntrEndYn;

	/**
	 * 계약 종료 일자
	 */
	@Schema(description = "계약 종료 일자", example = "", hidden = false, required = true, nullable = false)
	private String cntrEndDe;

	/**
	 * 설치완료일시
	 */
	@Schema(description = "설치완료일시", example = "", hidden = false, required = true, nullable = false)
	private String istDe;

	/**
	 * 설치기사코드
	 */
	@Schema(description = "설치기사코드", example = "", hidden = false, required = true, nullable = false)
	private String istEngr;

	/**
	 * 설치기사명
	 */
	@Schema(description = "설치기사명", example = "", hidden = false, required = true, nullable = false)
	private String istEngrNm;

	/**
	 * 시리얼번호
	 */
	@Schema(description = "시리얼번호", example = "", hidden = false, required = true, nullable = false)
	private String serialNo;

	/**
	 * 품목그룹코드(카테고리1)
	 */
	@Schema(description = "품목그룹코드(카테고리1)", example = "", hidden = false, required = true, nullable = false)
	private String itemGrpCd;

	/**
	 * 품목그룹명(카테고리1)
	 */
	@Schema(description = "품목그룹명(카테고리1)", example = "", hidden = false, required = true, nullable = false)
	private String itemGrpNm;

	/**
	 * 품목유형상세코드(카테고리3)
	 */
	@Schema(description = "품목유형상세코드(카테고리3)", example = "", hidden = false, required = true, nullable = false)
	private String itemTyDtlCd;

	/**
	 * 품목유형상세명(카테고리3)
	 */
	@Schema(description = "품목유형상세명(카테고리3)", example = "", hidden = false, required = true, nullable = false)
	private String itemTyDtlNm;
}
