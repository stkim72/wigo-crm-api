package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCustBosCntrtHstSo
 * @author 김성태
 * @date 2022. 10. 26.
 * @Version 1.0
 * @description CRMBOS계약이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "BOS계약 검색 객체")
public class CrmCustBosCntrtHstSo extends ApiPagination {
	/**
	 * 계약번호
	 */
	@Parameter(description = "계약번호", example = "", hidden = true, required = false)
	@Schema(description = "계약번호", example = "", hidden = true, required = false, nullable = true)
	private String cntrNo;
	/**
	 * 고객번호
	 */
	@Parameter(description = "고객번호", example = "", hidden = true, required = false)
	@Schema(description = "고객번호", example = "", hidden = true, required = false, nullable = true)
	private String custNo;
	/**
	 * 고객명
	 */
	@Parameter(description = "고객명", example = "", hidden = true, required = false)
	@Schema(description = "고객명", example = "", hidden = true, required = false, nullable = true)
	private String custNm;
	/**
	 * 계약자 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = false, required = false)
	@Schema(description = "계약자 통합고객번호", example = "", hidden = false, required = false, nullable = true)
	private String itgCustNo;
	/**
	 * 고객유형코드
	 */
	@Parameter(description = "고객유형코드", example = "", hidden = true, required = false)
	@Schema(description = "고객유형코드", example = "", hidden = true, required = false, nullable = true)
	private String custTyCd;
	/**
	 * 고객유형명
	 */
	@Parameter(description = "고객유형명", example = "", hidden = true, required = false)
	@Schema(description = "고객유형명", example = "", hidden = true, required = false, nullable = true)
	private String custTyCdnm;
	/**
	 * 고객유형상세코드
	 */
	@Parameter(description = "고객유형상세코드", example = "", hidden = true, required = false)
	@Schema(description = "고객유형상세코드", example = "", hidden = true, required = false, nullable = true)
	private String custTyDtlCd;
	/**
	 * 고객유형상세명
	 */
	@Parameter(description = "고객유형상세명", example = "", hidden = true, required = false)
	@Schema(description = "고객유형상세명", example = "", hidden = true, required = false, nullable = true)
	private String custTyDtlCdnm;
	/**
	 * 주문번호
	 */
	@Parameter(description = "주문번호", example = "", hidden = true, required = false)
	@Schema(description = "주문번호", example = "", hidden = true, required = false, nullable = true)
	private String ordNo;
	/**
	 * 주문번호순번
	 */
	@Parameter(description = "주문번호순번", example = "", hidden = true, required = false)
	@Schema(description = "주문번호순번", example = "", hidden = true, required = false, nullable = true)
	private Integer ordNoSn;
	/**
	 * 주문일자
	 */
	@Parameter(description = "주문일자", example = "", hidden = true, required = false)
	@Schema(description = "주문일자", example = "", hidden = true, required = false, nullable = true)
	private String ordDe;
	/**
	 * 주문상태코드
	 */
	@Parameter(description = "주문상태코드", example = "", hidden = true, required = false)
	@Schema(description = "주문상태코드", example = "", hidden = true, required = false, nullable = true)
	private String ordStsCd;
	/**
	 * 주문상태명
	 */
	@Parameter(description = "주문상태명", example = "", hidden = true, required = false)
	@Schema(description = "주문상태명", example = "", hidden = true, required = false, nullable = true)
	private String ordStsCdnm;
	/**
	 * 주문채널코드
	 */
	@Parameter(description = "주문채널코드", example = "", hidden = true, required = false)
	@Schema(description = "주문채널코드", example = "", hidden = true, required = false, nullable = true)
	private String ordChnCd;
	/**
	 * 주문구분코드
	 */
	@Parameter(description = "주문구분코드", example = "", hidden = true, required = false)
	@Schema(description = "주문구분코드", example = "", hidden = true, required = false, nullable = true)
	private String ordSeCd;
	/**
	 * 주문구분명
	 */
	@Parameter(description = "주문구분명", example = "", hidden = true, required = false)
	@Schema(description = "주문구분명", example = "", hidden = true, required = false, nullable = true)
	private String ordSeCdnm;
	/**
	 * 주문취소일자
	 */
	@Parameter(description = "주문취소일자", example = "", hidden = true, required = false)
	@Schema(description = "주문취소일자", example = "", hidden = true, required = false, nullable = true)
	private String ordCnclDe;
	/**
	 * 품목코드
	 */
	@Parameter(description = "품목코드", example = "", hidden = true, required = false)
	@Schema(description = "품목코드", example = "", hidden = true, required = false, nullable = true)
	private String itemCd;
	/**
	 * 품목명
	 */
	@Parameter(description = "품목명", example = "", hidden = true, required = false)
	@Schema(description = "품목명", example = "", hidden = true, required = false, nullable = true)
	private String itemNm;
	/**
	 * 품목그룹코드
	 */
	@Parameter(description = "품목그룹코드", example = "", hidden = true, required = false)
	@Schema(description = "품목그룹코드", example = "", hidden = true, required = false, nullable = true)
	private String itemGrpCd;
	/**
	 * 품목그룹명
	 */
	@Parameter(description = "품목그룹명", example = "", hidden = true, required = false)
	@Schema(description = "품목그룹명", example = "", hidden = true, required = false, nullable = true)
	private String itemGrpCdnm;
	/**
	 * 품목유형코드
	 */
	@Parameter(description = "품목유형코드", example = "", hidden = true, required = false)
	@Schema(description = "품목유형코드", example = "", hidden = true, required = false, nullable = true)
	private String itemTyCd;
	/**
	 * 품목유형명
	 */
	@Parameter(description = "품목유형명", example = "", hidden = true, required = false)
	@Schema(description = "품목유형명", example = "", hidden = true, required = false, nullable = true)
	private String itemTyCdnm;
	/**
	 * 품목유형상세코드
	 */
	@Parameter(description = "품목유형상세코드", example = "", hidden = true, required = false)
	@Schema(description = "품목유형상세코드", example = "", hidden = true, required = false, nullable = true)
	private String itemTyDtlCd;
	/**
	 * 품목유형상세명
	 */
	@Parameter(description = "품목유형상세명", example = "", hidden = true, required = false)
	@Schema(description = "품목유형상세명", example = "", hidden = true, required = false, nullable = true)
	private String itemTyDtlCdnm;
	/**
	 * 시리얼번호
	 */
	@Parameter(description = "시리얼번호", example = "", hidden = true, required = false)
	@Schema(description = "시리얼번호", example = "", hidden = true, required = false, nullable = true)
	private String serialNo;
	/**
	 * 판매유형코드
	 */
	@Parameter(description = "판매유형코드", example = "", hidden = true, required = false)
	@Schema(description = "판매유형코드", example = "", hidden = true, required = false, nullable = true)
	private String saleTyCd;
	/**
	 * 판매유형명
	 */
	@Parameter(description = "판매유형명", example = "", hidden = true, required = false)
	@Schema(description = "판매유형명", example = "", hidden = true, required = false, nullable = true)
	private String saleTyCdnm;
	/**
	 * 판매구분코드
	 */
	@Parameter(description = "판매구분코드", example = "", hidden = true, required = false)
	@Schema(description = "판매구분코드", example = "", hidden = true, required = false, nullable = true)
	private String saleSeCd;
	/**
	 * 판매구분명
	 */
	@Parameter(description = "판매구분명", example = "", hidden = true, required = false)
	@Schema(description = "판매구분명", example = "", hidden = true, required = false, nullable = true)
	private String saleSeCdnm;
	/**
	 * 판매그룹코드
	 */
	@Parameter(description = "판매그룹코드", example = "", hidden = true, required = false)
	@Schema(description = "판매그룹코드", example = "", hidden = true, required = false, nullable = true)
	private String saleGrpCd;
	/**
	 * 판매그룹명
	 */
	@Parameter(description = "판매그룹명", example = "", hidden = true, required = false)
	@Schema(description = "판매그룹명", example = "", hidden = true, required = false, nullable = true)
	private String saleGrpCdnm;
	/**
	 * 계약상태코드
	 */
	@Parameter(description = "계약상태코드", example = "", hidden = true, required = false)
	@Schema(description = "계약상태코드", example = "", hidden = true, required = false, nullable = true)
	private String cntrStsCd;
	/**
	 * 계약상태명
	 */
	@Parameter(description = "계약상태명", example = "", hidden = true, required = false)
	@Schema(description = "계약상태명", example = "", hidden = true, required = false, nullable = true)
	private String cntrStsCdnm;
	/**
	 * 계약상태상세코드
	 */
	@Parameter(description = "계약상태상세코드", example = "", hidden = true, required = false)
	@Schema(description = "계약상태상세코드", example = "", hidden = true, required = false, nullable = true)
	private String cntrStsDtlCd;
	/**
	 * 계약상태상세명
	 */
	@Parameter(description = "계약상태상세명", example = "", hidden = true, required = false)
	@Schema(description = "계약상태상세명", example = "", hidden = true, required = false, nullable = true)
	private String cntrStsDtlCdnm;
	/**
	 * 계약상태상세사유
	 */
	@Parameter(description = "계약상태상세사유", example = "", hidden = true, required = false)
	@Schema(description = "계약상태상세사유", example = "", hidden = true, required = false, nullable = true)
	private String cntrStsDtlRsn;
	/**
	 * 결제상태코드
	 */
	@Parameter(description = "결제상태코드", example = "", hidden = true, required = false)
	@Schema(description = "결제상태코드", example = "", hidden = true, required = false, nullable = true)
	private String setlStsCd;
	/**
	 * 결제상태명
	 */
	@Parameter(description = "결제상태명", example = "", hidden = true, required = false)
	@Schema(description = "결제상태명", example = "", hidden = true, required = false, nullable = true)
	private String setlStsCdnm;
	/**
	 * 설치상태코드
	 */
	@Parameter(description = "설치상태코드", example = "", hidden = true, required = false)
	@Schema(description = "설치상태코드", example = "", hidden = true, required = false, nullable = true)
	private String istStsCd;
	/**
	 * 설치상태명
	 */
	@Parameter(description = "설치상태명", example = "", hidden = true, required = false)
	@Schema(description = "설치상태명", example = "", hidden = true, required = false, nullable = true)
	private String istStsCdnm;
	/**
	 * 계약취소여부
	 */
	@Parameter(description = "계약취소여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "계약취소여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String cntrCnclYn;
	/**
	 * 계약취소일자
	 */
	@Parameter(description = "계약취소일자", example = "", hidden = true, required = false)
	@Schema(description = "계약취소일자", example = "", hidden = true, required = false, nullable = true)
	private String cntrCnclDe;
	/**
	 * 계약취소사유
	 */
	@Parameter(description = "계약취소사유", example = "", hidden = true, required = false)
	@Schema(description = "계약취소사유", example = "", hidden = true, required = false, nullable = true)
	private String cntrCnclRsn;
	/**
	 * 본부구분코드
	 */
	@Parameter(description = "본부구분코드", example = "", hidden = true, required = false)
	@Schema(description = "본부구분코드", example = "", hidden = true, required = false, nullable = true)
	private String hqSeCd;
	/**
	 * 판매인
	 */
	@Parameter(description = "판매인", example = "", hidden = true, required = false)
	@Schema(description = "판매인", example = "", hidden = true, required = false, nullable = true)
	private String seller;
	/**
	 * 판매인명
	 */
	@Parameter(description = "판매인명", example = "", hidden = true, required = false)
	@Schema(description = "판매인명", example = "", hidden = true, required = false, nullable = true)
	private String sellernm;
	/**
	 * 판매조직
	 */
	@Parameter(description = "판매조직", example = "", hidden = true, required = false)
	@Schema(description = "판매조직", example = "", hidden = true, required = false, nullable = true)
	private String saleOrgz;
	/**
	 * 설치예정조직
	 */
	@Parameter(description = "설치예정조직", example = "", hidden = true, required = false)
	@Schema(description = "설치예정조직", example = "", hidden = true, required = false, nullable = true)
	private String istDueOrgz;
	/**
	 * 설치예정기사
	 */
	@Parameter(description = "설치예정기사", example = "", hidden = true, required = false)
	@Schema(description = "설치예정기사", example = "", hidden = true, required = false, nullable = true)
	private String istDueEngr;
	/**
	 * 설치조직
	 */
	@Parameter(description = "설치조직", example = "", hidden = true, required = false)
	@Schema(description = "설치조직", example = "", hidden = true, required = false, nullable = true)
	private String istOrgz;
	/**
	 * 설치기사
	 */
	@Parameter(description = "설치기사", example = "", hidden = true, required = false)
	@Schema(description = "설치기사", example = "", hidden = true, required = false, nullable = true)
	private String istEngr;
	/**
	 * 설비번호
	 */
	@Parameter(description = "설비번호", example = "", hidden = true, required = false)
	@Schema(description = "설비번호", example = "", hidden = true, required = false, nullable = true)
	private String eqpNo;
	/**
	 * 창고코드
	 */
	@Parameter(description = "창고코드", example = "", hidden = true, required = false)
	@Schema(description = "창고코드", example = "", hidden = true, required = false, nullable = true)
	private String wrhCd;
	/**
	 * 창고명
	 */
	@Parameter(description = "창고명", example = "", hidden = true, required = false)
	@Schema(description = "창고명", example = "", hidden = true, required = false, nullable = true)
	private String wrhNm;
	/**
	 * 컨택순번
	 */
	@Parameter(description = "컨택순번", example = "", hidden = true, required = false)
	@Schema(description = "컨택순번", example = "", hidden = true, required = false, nullable = true)
	private Integer cntcSn;
	/**
	 * 고객컨택상태
	 */
	@Parameter(description = "고객컨택상태", example = "", hidden = true, required = false)
	@Schema(description = "고객컨택상태", example = "", hidden = true, required = false, nullable = true)
	private String custCntcSts;
	/**
	 * 고객컨택일자
	 */
	@Parameter(description = "고객컨택일자", example = "", hidden = true, required = false)
	@Schema(description = "고객컨택일자", example = "", hidden = true, required = false, nullable = true)
	private String custCntcDe;
	/**
	 * 설치요청일자
	 */
	@Parameter(description = "설치요청일자", example = "", hidden = true, required = false)
	@Schema(description = "설치요청일자", example = "", hidden = true, required = false, nullable = true)
	private String istReqDe;
	/**
	 * 설치일자
	 */
	@Parameter(description = "설치일자", example = "", hidden = true, required = false)
	@Schema(description = "설치일자", example = "", hidden = true, required = false, nullable = true)
	private String istDe;
	/**
	 * 설치확정여부
	 */
	@Parameter(description = "설치확정여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "설치확정여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String istDcsYn;
	/**
	 * 설치확정일자
	 */
	@Parameter(description = "설치확정일자", example = "", hidden = true, required = false)
	@Schema(description = "설치확정일자", example = "", hidden = true, required = false, nullable = true)
	private String istDcsDe;
	/**
	 * 계약시작일자
	 */
	@Parameter(description = "계약시작일자", example = "", hidden = true, required = false)
	@Schema(description = "계약시작일자", example = "", hidden = true, required = false, nullable = true)
	private String cntrStartDe;
	/**
	 * 계약종료예정일자
	 */
	@Parameter(description = "계약종료예정일자", example = "", hidden = true, required = false)
	@Schema(description = "계약종료예정일자", example = "", hidden = true, required = false, nullable = true)
	private String cntrEndDueDe;
	/**
	 * 계약종료여부
	 */
	@Parameter(description = "계약종료여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "계약종료여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String cntrEndYn;
	/**
	 * 계약종료일자
	 */
	@Parameter(description = "계약종료일자", example = "", hidden = true, required = false)
	@Schema(description = "계약종료일자", example = "", hidden = true, required = false, nullable = true)
	private String cntrEndDe;
	/**
	 * 매출확정여부
	 */
	@Parameter(description = "매출확정여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "매출확정여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String selngDcsYn;
	/**
	 * 매출확정일자
	 */
	@Parameter(description = "매출확정일자", example = "", hidden = true, required = false)
	@Schema(description = "매출확정일자", example = "", hidden = true, required = false, nullable = true)
	private String selngDcsDe;
	/**
	 * 신용조회여부
	 */
	@Parameter(description = "신용조회여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "신용조회여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String cdtSelYn;
	/**
	 * 가격정책번호
	 */
	@Parameter(description = "가격정책번호", example = "", hidden = true, required = false)
	@Schema(description = "가격정책번호", example = "", hidden = true, required = false, nullable = true)
	private String prcPlcNo;
	/**
	 * 약정기간코드
	 */
	@Parameter(description = "약정기간코드", example = "", hidden = true, required = false)
	@Schema(description = "약정기간코드", example = "", hidden = true, required = false, nullable = true)
	private String agrPdCd;
	/**
	 * 약정기간명
	 */
	@Parameter(description = "약정기간명", example = "", hidden = true, required = false)
	@Schema(description = "약정기간명", example = "", hidden = true, required = false, nullable = true)
	private String agrPdCdnm;
	/**
	 * 계약기간값
	 */
	@Parameter(description = "계약기간값", example = "", hidden = true, required = false)
	@Schema(description = "계약기간값", example = "", hidden = true, required = false, nullable = true)
	private Integer cntrPdVal;
	/**
	 * 서비스기간코드
	 */
	@Parameter(description = "서비스기간코드", example = "", hidden = true, required = false)
	@Schema(description = "서비스기간코드", example = "", hidden = true, required = false, nullable = true)
	private String svcPdCd;
	/**
	 * 점검주기
	 */
	@Parameter(description = "점검주기", example = "", hidden = true, required = false)
	@Schema(description = "점검주기", example = "", hidden = true, required = false, nullable = true)
	private String svcCycle;
	/**
	 * 선납여부
	 */
	@Parameter(description = "선납여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "선납여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String prepayYn;
	/**
	 * 선납금액
	 */
	@Parameter(description = "선납금액", example = "", hidden = true, required = false)
	@Schema(description = "선납금액", example = "", hidden = true, required = false, nullable = true)
	private Double prepayAmt;
	/**
	 * 선납주기
	 */
	@Parameter(description = "선납주기", example = "", hidden = true, required = false)
	@Schema(description = "선납주기", example = "", hidden = true, required = false, nullable = true)
	private String prepayCycle;
	/**
	 * 선납할인율
	 */
	@Parameter(description = "선납할인율", example = "", hidden = true, required = false)
	@Schema(description = "선납할인율", example = "", hidden = true, required = false, nullable = true)
	private Integer prepayDcrt;
	/**
	 * 등록비
	 */
	@Parameter(description = "등록비", example = "", hidden = true, required = false)
	@Schema(description = "등록비", example = "", hidden = true, required = false, nullable = true)
	private Double regfee;
	/**
	 * 설치비
	 */
	@Parameter(description = "설치비", example = "", hidden = true, required = false)
	@Schema(description = "설치비", example = "", hidden = true, required = false, nullable = true)
	private Double istct;
	/**
	 * 해체비
	 */
	@Parameter(description = "해체비", example = "", hidden = true, required = false)
	@Schema(description = "해체비", example = "", hidden = true, required = false, nullable = true)
	private Double dfee;
	/**
	 * 기본렌탈금액
	 */
	@Parameter(description = "기본렌탈금액", example = "", hidden = true, required = false)
	@Schema(description = "기본렌탈금액", example = "", hidden = true, required = false, nullable = true)
	private Double bassRentAmt;
	/**
	 * 렌탈금액
	 */
	@Parameter(description = "렌탈금액", example = "", hidden = true, required = false)
	@Schema(description = "렌탈금액", example = "", hidden = true, required = false, nullable = true)
	private Double rentAmt;
	/**
	 * 기본판매금액
	 */
	@Parameter(description = "기본판매금액", example = "", hidden = true, required = false)
	@Schema(description = "기본판매금액", example = "", hidden = true, required = false, nullable = true)
	private Double bassSaleAmt;
	/**
	 * 판매금액
	 */
	@Parameter(description = "판매금액", example = "", hidden = true, required = false)
	@Schema(description = "판매금액", example = "", hidden = true, required = false, nullable = true)
	private Double salesAmt;
	/**
	 * 결제금액
	 */
	@Parameter(description = "결제금액", example = "", hidden = true, required = false)
	@Schema(description = "결제금액", example = "", hidden = true, required = false, nullable = true)
	private Double setlAmt;
	/**
	 * 주문금액
	 */
	@Parameter(description = "주문금액", example = "", hidden = true, required = false)
	@Schema(description = "주문금액", example = "", hidden = true, required = false, nullable = true)
	private Double ordAmt;
	/**
	 * 주문부가세제외금액
	 */
	@Parameter(description = "주문부가세제외금액", example = "", hidden = true, required = false)
	@Schema(description = "주문부가세제외금액", example = "", hidden = true, required = false, nullable = true)
	private Double ordVatExclAmt;
	/**
	 * 주문부가세금액
	 */
	@Parameter(description = "주문부가세금액", example = "", hidden = true, required = false)
	@Schema(description = "주문부가세금액", example = "", hidden = true, required = false, nullable = true)
	private Double ordVatAmt;
	/**
	 * 매출금액
	 */
	@Parameter(description = "매출금액", example = "", hidden = true, required = false)
	@Schema(description = "매출금액", example = "", hidden = true, required = false, nullable = true)
	private Double selngAmt;
	/**
	 * 매출부가세제외금액
	 */
	@Parameter(description = "매출부가세제외금액", example = "", hidden = true, required = false)
	@Schema(description = "매출부가세제외금액", example = "", hidden = true, required = false, nullable = true)
	private Double selngVatExclAmt;
	/**
	 * 매출부가세금액
	 */
	@Parameter(description = "매출부가세금액", example = "", hidden = true, required = false)
	@Schema(description = "매출부가세금액", example = "", hidden = true, required = false, nullable = true)
	private Double selngVatAmt;
	/**
	 * 매출번호
	 */
	@Parameter(description = "매출번호", example = "", hidden = true, required = false)
	@Schema(description = "매출번호", example = "", hidden = true, required = false, nullable = true)
	private String selngNo;
	/**
	 * 부가세코드
	 */
	@Parameter(description = "부가세코드", example = "", hidden = true, required = false)
	@Schema(description = "부가세코드", example = "", hidden = true, required = false, nullable = true)
	private String vatCd;
	/**
	 * 판매채널코드
	 */
	@Parameter(description = "판매채널코드", example = "", hidden = true, required = false)
	@Schema(description = "판매채널코드", example = "", hidden = true, required = false, nullable = true)
	private String saleChnCd;
	/**
	 * 판매채널명
	 */
	@Parameter(description = "판매채널명", example = "", hidden = true, required = false)
	@Schema(description = "판매채널명", example = "", hidden = true, required = false, nullable = true)
	private String saleChnCdnm;
	/**
	 * 프로모션여부
	 */
	@Parameter(description = "프로모션여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "프로모션여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String prmtYn;
	/**
	 * 프로모션정책번호
	 */
	@Parameter(description = "프로모션정책번호", example = "", hidden = true, required = false)
	@Schema(description = "프로모션정책번호", example = "", hidden = true, required = false, nullable = true)
	private String prmtPlcNo;
	/**
	 * 프로모션번호
	 */
	@Parameter(description = "프로모션번호", example = "", hidden = true, required = false)
	@Schema(description = "프로모션번호", example = "", hidden = true, required = false, nullable = true)
	private String prmtNo;
	/**
	 * 패키지여부
	 */
	@Parameter(description = "패키지여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "패키지여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String pkgYn;
	/**
	 * 패키지정책번호
	 */
	@Parameter(description = "패키지정책번호", example = "", hidden = true, required = false)
	@Schema(description = "패키지정책번호", example = "", hidden = true, required = false, nullable = true)
	private String pkgPlcNo;
	/**
	 * 패키지번호
	 */
	@Parameter(description = "패키지번호", example = "", hidden = true, required = false)
	@Schema(description = "패키지번호", example = "", hidden = true, required = false, nullable = true)
	private String pkgNo;
	/**
	 * 단체여부
	 */
	@Parameter(description = "단체여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "단체여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String grpYn;
	/**
	 * 단체코드
	 */
	@Parameter(description = "단체코드", example = "", hidden = true, required = false)
	@Schema(description = "단체코드", example = "", hidden = true, required = false, nullable = true)
	private String grpCd;
	/**
	 * 단체번호
	 */
	@Parameter(description = "단체번호", example = "", hidden = true, required = false)
	@Schema(description = "단체번호", example = "", hidden = true, required = false, nullable = true)
	private String grpNo;
	/**
	 * 계약서파일번호
	 */
	@Parameter(description = "계약서파일번호", example = "", hidden = true, required = false)
	@Schema(description = "계약서파일번호", example = "", hidden = true, required = false, nullable = true)
	private String ctrtcFileNo;
	/**
	 * 서명파일번호
	 */
	@Parameter(description = "서명파일번호", example = "", hidden = true, required = false)
	@Schema(description = "서명파일번호", example = "", hidden = true, required = false, nullable = true)
	private String signFileNo;
	/**
	 * 서비스여부
	 */
	@Parameter(description = "서비스여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "서비스여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String svcYn;
	/**
	 * 기존계약번호
	 */
	@Parameter(description = "기존계약번호", example = "", hidden = true, required = false)
	@Schema(description = "기존계약번호", example = "", hidden = true, required = false, nullable = true)
	private String existCntrNo;
	/**
	 * 반품유형코드
	 */
	@Parameter(description = "반품유형코드", example = "", hidden = true, required = false)
	@Schema(description = "반품유형코드", example = "", hidden = true, required = false, nullable = true)
	private String rtgdTyCd;
	/**
	 * 반품요청일자
	 */
	@Parameter(description = "반품요청일자", example = "", hidden = true, required = false)
	@Schema(description = "반품요청일자", example = "", hidden = true, required = false, nullable = true)
	private String rtgdReqDe;
	/**
	 * 반품접수확정여부
	 */
	@Parameter(description = "반품접수확정여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "반품접수확정여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String rtgdDcsYn;
	/**
	 * 반품완료일자
	 */
	@Parameter(description = "반품완료일자", example = "", hidden = true, required = false)
	@Schema(description = "반품완료일자", example = "", hidden = true, required = false, nullable = true)
	private String rtgdEndDe;
	/**
	 * 약관정책번호
	 */
	@Parameter(description = "약관정책번호", example = "", hidden = true, required = false)
	@Schema(description = "약관정책번호", example = "", hidden = true, required = false, nullable = true)
	private String spltPlcNo;
	/**
	 * 설치예정일자
	 */
	@Parameter(description = "설치예정일자", example = "", hidden = true, required = false)
	@Schema(description = "설치예정일자", example = "", hidden = true, required = false, nullable = true)
	private String istDueDe;
	/**
	 * 추가증빙파일번호1
	 */
	@Parameter(description = "추가증빙파일번호1", example = "", hidden = true, required = false)
	@Schema(description = "추가증빙파일번호1", example = "", hidden = true, required = false, nullable = true)
	private String addPrufFileNo1;
	/**
	 * 추가증빙파일번호2
	 */
	@Parameter(description = "추가증빙파일번호2", example = "", hidden = true, required = false)
	@Schema(description = "추가증빙파일번호2", example = "", hidden = true, required = false, nullable = true)
	private String addPrufFileNo2;
	/**
	 * 신용등급코드
	 */
	@Parameter(description = "신용등급코드", example = "", hidden = true, required = false)
	@Schema(description = "신용등급코드", example = "", hidden = true, required = false, nullable = true)
	private String cdtGradCd;
	/**
	 * 등록자ID
	 */
	@Parameter(description = "등록자ID", example = "", hidden = true, required = false)
	@Schema(description = "등록자ID", example = "", hidden = true, required = false, nullable = true)
	private String regUsrId;
	/**
	 * 수정자ID
	 */
	@Parameter(description = "수정자ID", example = "", hidden = true, required = false)
	@Schema(description = "수정자ID", example = "", hidden = true, required = false, nullable = true)
	private String updUsrId;
	/**
	 * 수정일시
	 */
	@Parameter(description = "수정일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	@Schema(description = "수정일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false, nullable = true)
	private String updDt;
	/**
	 * 설치-우편번호
	 */
	@Parameter(description = "설치-우편번호", example = "", hidden = true, required = false)
	@Schema(description = "설치-우편번호", example = "", hidden = true, required = false, nullable = true)
	private String postNo;
	/**
	 * 설치-기본주소
	 */
	@Parameter(description = "설치-기본주소", example = "", hidden = true, required = false)
	@Schema(description = "설치-기본주소", example = "", hidden = true, required = false, nullable = true)
	private String bassAddr;
	/**
	 * 설치-상세주소
	 */
	@Parameter(description = "설치-상세주소", example = "", hidden = true, required = false)
	@Schema(description = "설치-상세주소", example = "", hidden = true, required = false, nullable = true)
	private String dtlAddr;
	/**
	 * 설치-모바일번호
	 */
	@Parameter(description = "설치-모바일번호", example = "", hidden = true, required = false)
	@Schema(description = "설치-모바일번호", example = "", hidden = true, required = false, nullable = true)
	private String mobNo;
	/**
	 * 설치-전화번호
	 */
	@Parameter(description = "설치-전화번호", example = "", hidden = true, required = false)
	@Schema(description = "설치-전화번호", example = "", hidden = true, required = false, nullable = true)
	private String telNo;
	/**
	 * 설치-특이사항
	 */
	@Parameter(description = "설치-특이사항", example = "", hidden = true, required = false)
	@Schema(description = "설치-특이사항", example = "", hidden = true, required = false, nullable = true)
	private String partclrMatter;
	/**
	 * 설치-설치고객명
	 */
	@Parameter(description = "설치-설치고객명", example = "", hidden = true, required = false)
	@Schema(description = "설치-설치고객명", example = "", hidden = true, required = false, nullable = true)
	private String istCustNm;
	/**
	 * 정기결제-카드번호
	 */
	@Parameter(description = "정기결제-카드번호", example = "", hidden = true, required = false)
	@Schema(description = "정기결제-카드번호", example = "", hidden = true, required = false, nullable = true)
	private String cardNo;
	/**
	 * 정기결제-카드사코드
	 */
	@Parameter(description = "정기결제-카드사코드", example = "", hidden = true, required = false)
	@Schema(description = "정기결제-카드사코드", example = "", hidden = true, required = false, nullable = true)
	private String cdcmpCd;
	/**
	 * 정기결제-소유주명
	 */
	@Parameter(description = "정기결제-소유주명", example = "", hidden = true, required = false)
	@Schema(description = "정기결제-소유주명", example = "", hidden = true, required = false, nullable = true)
	private String ownerNm;
	/**
	 * 정기결제-방법코드
	 */
	@Parameter(description = "정기결제-방법코드", example = "", hidden = true, required = false)
	@Schema(description = "정기결제-방법코드", example = "", hidden = true, required = false, nullable = true)
	private String fsetlMthCd;
	/**
	 * 정기결제-방법명
	 */
	@Parameter(description = "정기결제-방법명", example = "", hidden = true, required = false)
	@Schema(description = "정기결제-방법명", example = "", hidden = true, required = false, nullable = true)
	private String fsetlMthCdnm;
	/**
	 * 정기결제일자코드
	 */
	@Parameter(description = "정기결제일자코드", example = "", hidden = true, required = false)
	@Schema(description = "정기결제일자코드", example = "", hidden = true, required = false, nullable = true)
	private String fsetlDeCd;
	/**
	 * 계좌신청동의파일번호
	 */
	@Parameter(description = "계좌신청동의파일번호", example = "", hidden = true, required = false)
	@Schema(description = "계좌신청동의파일번호", example = "", hidden = true, required = false, nullable = true)
	private String acctAfileNo;
	/**
	 * 출고상태코드
	 */
	@Parameter(description = "출고상태코드", example = "", hidden = true, required = false)
	@Schema(description = "출고상태코드", example = "", hidden = true, required = false, nullable = true)
	private String otbnStsCd;
	/**
	 * 출고상태명
	 */
	@Parameter(description = "출고상태명", example = "", hidden = true, required = false)
	@Schema(description = "출고상태명", example = "", hidden = true, required = false, nullable = true)
	private String otbnStsCdnm;
	/**
	 * 비고
	 */
	@Parameter(description = "비고", example = "", hidden = true, required = false)
	@Schema(description = "비고", example = "", hidden = true, required = false, nullable = true)
	private String rm;
	/**
	 * 기본멤버십금액
	 */
	@Parameter(description = "기본멤버십금액", example = "", hidden = true, required = false)
	@Schema(description = "기본멤버십금액", example = "", hidden = true, required = false, nullable = true)
	private Double bassMbrshAmt;
	/**
	 * 멤버십금액
	 */
	@Parameter(description = "멤버십금액", example = "", hidden = true, required = false)
	@Schema(description = "멤버십금액", example = "", hidden = true, required = false, nullable = true)
	private Double mbrshAmt;
	/**
	 * 일시불무상종료예정일
	 */
	@Parameter(description = "일시불무상종료예정일", example = "", hidden = true, required = false)
	@Schema(description = "일시불무상종료예정일", example = "", hidden = true, required = false, nullable = true)
	private String lmpsFreeEndDueDe;
	/**
	 * 패키지해지여부
	 */
	@Parameter(description = "패키지해지여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "패키지해지여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String pkgTrmnYn;
	/**
	 * 배송유형코드
	 */
	@Parameter(description = "배송유형코드", example = "", hidden = true, required = false)
	@Schema(description = "배송유형코드", example = "", hidden = true, required = false, nullable = true)
	private String dlvTyCd;
	/**
	 * 배송유형명
	 */
	@Parameter(description = "배송유형명", example = "", hidden = true, required = false)
	@Schema(description = "배송유형명", example = "", hidden = true, required = false, nullable = true)
	private String dlvTyCdnm;
	/**
	 * 배송유형상세코드
	 */
	@Parameter(description = "배송유형상세코드", example = "", hidden = true, required = false)
	@Schema(description = "배송유형상세코드", example = "", hidden = true, required = false, nullable = true)
	private String dlvTyDtlCd;
	/**
	 * 배송유형상세명
	 */
	@Parameter(description = "배송유형상세명", example = "", hidden = true, required = false)
	@Schema(description = "배송유형상세명", example = "", hidden = true, required = false, nullable = true)
	private String dlvTyDtlCdnm;
	/**
	 * 약정기간값
	 */
	@Parameter(description = "약정기간값", example = "", hidden = true, required = false)
	@Schema(description = "약정기간값", example = "", hidden = true, required = false, nullable = true)
	private Integer agrPdVal;
	/**
	 * 계약기간구분코드
	 */
	@Parameter(description = "계약기간구분코드", example = "", hidden = true, required = false)
	@Schema(description = "계약기간구분코드", example = "", hidden = true, required = false, nullable = true)
	private String cntrPdSeCd;
	/**
	 * 계약기간구분명
	 */
	@Parameter(description = "계약기간구분명", example = "", hidden = true, required = false)
	@Schema(description = "계약기간구분명", example = "", hidden = true, required = false, nullable = true)
	private String cntrPdSeCdnm;
	/**
	 * 계약이후처리방법코드
	 */
	@Parameter(description = "계약이후처리방법코드", example = "", hidden = true, required = false)
	@Schema(description = "계약이후처리방법코드", example = "", hidden = true, required = false, nullable = true)
	private String cntrEndAfterProcMthCd;
	/**
	 * 계약종료이후처리방법
	 */
	@Parameter(description = "계약종료이후처리방법", example = "", hidden = true, required = false)
	@Schema(description = "계약종료이후처리방법", example = "", hidden = true, required = false, nullable = true)
	private String cntrEndAfterProcMthCdnm;
	/**
	 * 중고구분코드
	 */
	@Parameter(description = "중고구분코드", example = "", hidden = true, required = false)
	@Schema(description = "중고구분코드", example = "", hidden = true, required = false, nullable = true)
	private String uatcSeCd;
	/**
	 * 중고구분명
	 */
	@Parameter(description = "중고구분명", example = "", hidden = true, required = false)
	@Schema(description = "중고구분명", example = "", hidden = true, required = false, nullable = true)
	private String uatcSeCdnm;
	/**
	 * 중고등급코드
	 */
	@Parameter(description = "중고등급코드", example = "", hidden = true, required = false)
	@Schema(description = "중고등급코드", example = "", hidden = true, required = false, nullable = true)
	private String uatcGradCd;
	/**
	 * 중고등급명
	 */
	@Parameter(description = "중고등급명", example = "", hidden = true, required = false)
	@Schema(description = "중고등급명", example = "", hidden = true, required = false, nullable = true)
	private String uatcGradCdnm;
	/**
	 * 스케줄생성여부
	 */
	@Parameter(description = "스케줄생성여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "스케줄생성여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String shdeCreYn;
	/**
	 * 렌탈구분코드
	 */
	@Parameter(description = "렌탈구분코드", example = "", hidden = true, required = false)
	@Schema(description = "렌탈구분코드", example = "", hidden = true, required = false, nullable = true)
	private String rentSeCd;
	/**
	 * 렌탈구분명
	 */
	@Parameter(description = "렌탈구분명", example = "", hidden = true, required = false)
	@Schema(description = "렌탈구분명", example = "", hidden = true, required = false, nullable = true)
	private String rentSeCdnm;
	/**
	 * 홈체험청구할인기간코드
	 */
	@Parameter(description = "홈체험청구할인기간코드", example = "", hidden = true, required = false)
	@Schema(description = "홈체험청구할인기간코드", example = "", hidden = true, required = false, nullable = true)
	private String exprnDmdDcPdCd;
	/**
	 * 홈체험청구할인기간명
	 */
	@Parameter(description = "홈체험청구할인기간명", example = "", hidden = true, required = false)
	@Schema(description = "홈체험청구할인기간명", example = "", hidden = true, required = false, nullable = true)
	private String exprnDmdDcPdCdnm;
	/**
	 * 홈체험계약번호
	 */
	@Parameter(description = "홈체험계약번호", example = "", hidden = true, required = false)
	@Schema(description = "홈체험계약번호", example = "", hidden = true, required = false, nullable = true)
	private String exprnCntrNo;
	/**
	 * 추천인
	 */
	@Parameter(description = "추천인", example = "", hidden = true, required = false)
	@Schema(description = "추천인", example = "", hidden = true, required = false, nullable = true)
	private String rcmdr;
	/**
	 * 추천인명
	 */
	@Parameter(description = "추천인명", example = "", hidden = true, required = false)
	@Schema(description = "추천인명", example = "", hidden = true, required = false, nullable = true)
	private String rcmdrnm;
	/**
	 * 추천인조직코드
	 */
	@Parameter(description = "추천인조직코드", example = "", hidden = true, required = false)
	@Schema(description = "추천인조직코드", example = "", hidden = true, required = false, nullable = true)
	private String orgzCd;
	/**
	 * 추천인조직명
	 */
	@Parameter(description = "추천인조직명", example = "", hidden = true, required = false)
	@Schema(description = "추천인조직명", example = "", hidden = true, required = false, nullable = true)
	private String orgzNm;
	/**
	 * 본인영업구분코드
	 */
	@Parameter(description = "본인영업구분코드", example = "", hidden = true, required = false)
	@Schema(description = "본인영업구분코드", example = "", hidden = true, required = false, nullable = true)
	private String selfBsnSeCd;
	/**
	 * 본인영업구분명
	 */
	@Parameter(description = "본인영업구분명", example = "", hidden = true, required = false)
	@Schema(description = "본인영업구분명", example = "", hidden = true, required = false, nullable = true)
	private String selfBsnSeCdnm;
	/**
	 * 사은품내역
	 */
	@Parameter(description = "사은품내역", example = "", hidden = true, required = false)
	@Schema(description = "사은품내역", example = "", hidden = true, required = false, nullable = true)
	private String prsntDtls;
	/**
	 * 무상판매유형
	 */
	@Parameter(description = "무상판매유형", example = "", hidden = true, required = false)
	@Schema(description = "무상판매유형", example = "", hidden = true, required = false, nullable = true)
	private String freeSaleTy;
	/**
	 * 무상판매유형명
	 */
	@Parameter(description = "무상판매유형명", example = "", hidden = true, required = false)
	@Schema(description = "무상판매유형명", example = "", hidden = true, required = false, nullable = true)
	private String freeSaleTynm;
	/**
	 * 관리번호
	 */
	@Parameter(description = "관리번호", example = "", hidden = true, required = false)
	@Schema(description = "관리번호", example = "", hidden = true, required = false, nullable = true)
	private String mngNo;
	/**
	 * 컨택상태명
	 */
	@Parameter(description = "컨택상태명", example = "", hidden = true, required = false)
	@Schema(description = "컨택상태명", example = "", hidden = true, required = false, nullable = true)
	private String cntcStsCdnm;
	/**
	 * 기본판매요금
	 */
	@Parameter(description = "기본판매요금", example = "", hidden = true, required = false)
	@Schema(description = "기본판매요금", example = "", hidden = true, required = false, nullable = true)
	private Double bassSaleFee;
	/**
	 * 가격정책명
	 */
	@Parameter(description = "가격정책명", example = "", hidden = true, required = false)
	@Schema(description = "가격정책명", example = "", hidden = true, required = false, nullable = true)
	private String prcPlcNm;
	/**
	 * 계약수량
	 */
	@Parameter(description = "계약수량", example = "", hidden = true, required = false)
	@Schema(description = "계약수량", example = "", hidden = true, required = false, nullable = true)
	private Double cntrQy;
	/**
	 * 할인율
	 */
	@Parameter(description = "할인율", example = "", hidden = true, required = false)
	@Schema(description = "할인율", example = "", hidden = true, required = false, nullable = true)
	private String dcrt;
	/**
	 * 할인금액
	 */
	@Parameter(description = "할인금액", example = "", hidden = true, required = false)
	@Schema(description = "할인금액", example = "", hidden = true, required = false, nullable = true)
	private Double dcAmt;
	/**
	 * 이지렌탈계약번호
	 */
	@Parameter(description = "이지렌탈계약번호", example = "", hidden = true, required = false)
	@Schema(description = "이지렌탈계약번호", example = "", hidden = true, required = false, nullable = true)
	private String erCntrNo;
	/**
	 * 대표번호여부
	 */
	@Parameter(description = "대표번호여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "대표번호여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String rprsntvCntrYn;
	/**
	 * 주문유형코드
	 */
	@Parameter(description = "주문유형코드", example = "", hidden = true, required = false)
	@Schema(description = "주문유형코드", example = "", hidden = true, required = false, nullable = true)
	private String orTyCd;
	/**
	 * 주문유형
	 */
	@Parameter(description = "주문유형", example = "", hidden = true, required = false)
	@Schema(description = "주문유형", example = "", hidden = true, required = false, nullable = true)
	private String orTyCdnm;
	/**
	 * 사은품여부
	 */
	@Parameter(description = "사은품여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "사은품여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String prsntYn;
	/**
	 * 원계약번호(사은품)
	 */
	@Parameter(description = "원계약번호(사은품)", example = "", hidden = true, required = false)
	@Schema(description = "원계약번호(사은품)", example = "", hidden = true, required = false, nullable = true)
	private String prsntCntrNo;
	/**
	 * 건기식주문번호
	 */
	@Parameter(description = "건기식주문번호", example = "", hidden = true, required = false)
	@Schema(description = "건기식주문번호", example = "", hidden = true, required = false, nullable = true)
	private String ceramOrdNo;
	/**
	 * 선세금계산서발급여부
	 */
	@Parameter(description = "선세금계산서발급여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "선세금계산서발급여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String ptaxbilYn;
	/**
	 * 선세금계산서기준일자
	 */
	@Parameter(description = "선세금계산서기준일자", example = "", hidden = true, required = false)
	@Schema(description = "선세금계산서기준일자", example = "", hidden = true, required = false, nullable = true)
	private String ptaxbilDe;
	/**
	 * 선세금계산서담당자
	 */
	@Parameter(description = "선세금계산서담당자", example = "", hidden = true, required = false)
	@Schema(description = "선세금계산서담당자", example = "", hidden = true, required = false, nullable = true)
	private String ptaxbilChrgrSn;
	/**
	 * 담당자이메일
	 */
	@Parameter(description = "담당자이메일", example = "", hidden = true, required = false)
	@Schema(description = "담당자이메일", example = "", hidden = true, required = false, nullable = true)
	private String chrgrEmail;
	/**
	 * 담당자연락처
	 */
	@Parameter(description = "담당자연락처", example = "", hidden = true, required = false)
	@Schema(description = "담당자연락처", example = "", hidden = true, required = false, nullable = true)
	private String chrgrCttpc;
	/**
	 * 담당자부서명
	 */
	@Parameter(description = "담당자부서명", example = "", hidden = true, required = false)
	@Schema(description = "담당자부서명", example = "", hidden = true, required = false, nullable = true)
	private String chrgrDeptNm;
	/**
	 * 추천고객멤버십아이디
	 */
	@Parameter(description = "추천고객멤버십아이디", example = "", hidden = true, required = false)
	@Schema(description = "추천고객멤버십아이디", example = "", hidden = true, required = false, nullable = true)
	private String rcmdrMbrshId;
	/**
	 * 추천고객멤버십이름
	 */
	@Parameter(description = "추천고객멤버십이름", example = "", hidden = true, required = false)
	@Schema(description = "추천고객멤버십이름", example = "", hidden = true, required = false, nullable = true)
	private String rcmdrMbrshNm;
	/**
	 * 인수서파일번호
	 */
	@Parameter(description = "인수서파일번호", example = "", hidden = true, required = false)
	@Schema(description = "인수서파일번호", example = "", hidden = true, required = false, nullable = true)
	private String cfileNo;
	/**
	 * 조견표번호
	 */
	@Parameter(description = "조견표번호", example = "", hidden = true, required = false)
	@Schema(description = "조견표번호", example = "", hidden = true, required = false, nullable = true)
	private String insSerNo;
	/**
	 * 채권분류코드
	 */
	@Parameter(description = "채권분류코드", example = "", hidden = true, required = false)
	@Schema(description = "채권분류코드", example = "", hidden = true, required = false, nullable = true)
	private String bondCd;
	/**
	 * 채권분류명
	 */
	@Parameter(description = "채권분류명", example = "", hidden = true, required = false)
	@Schema(description = "채권분류명", example = "", hidden = true, required = false, nullable = true)
	private String bondCdnm;
	/**
	 * 사용쿠폰기본번호
	 */
	@Parameter(description = "사용쿠폰기본번호", example = "", hidden = true, required = false)
	@Schema(description = "사용쿠폰기본번호", example = "", hidden = true, required = false, nullable = true)
	private String useCoupnBasNo;
	/**
	 * 사용포인트금액
	 */
	@Parameter(description = "사용포인트금액", example = "", hidden = true, required = false)
	@Schema(description = "사용포인트금액", example = "", hidden = true, required = false, nullable = true)
	private Double usePointAmt;
	/**
	 * 캠페인번호
	 */
	@Parameter(description = "캠페인번호", example = "", hidden = true, required = false)
	@Schema(description = "캠페인번호", example = "", hidden = true, required = false, nullable = true)
	private String campBasNo;
	/**
	 * 프로모션코드
	 */
	@Parameter(description = "프로모션코드", example = "", hidden = true, required = false)
	@Schema(description = "프로모션코드", example = "", hidden = true, required = false, nullable = true)
	private String promNo;
	/**
	 * 품목코드(SAP코드)
	 */
	@Parameter(description = "품목코드(SAP코드)", example = "", hidden = true, required = false)
	@Schema(description = "품목코드(SAP코드)", example = "", hidden = true, required = false, nullable = true)
	private String baseItemCd;
	/**
	 * 판매조직 고객코드(SAP코드)
	 */
	@Parameter(description = "판매조직 고객코드(SAP코드)", example = "", hidden = true, required = false)
	@Schema(description = "판매조직 고객코드(SAP코드)", example = "", hidden = true, required = false, nullable = true)
	private String saleOrgzCustCd;
	/**
	 * 판매조직명
	 */
	@Parameter(description = "판매조직명", example = "", hidden = true, required = false)
	@Schema(description = "판매조직명", example = "", hidden = true, required = false, nullable = true)
	private String slaeOrgzNm;
	/**
	 * 상위판매조직코드
	 */
	@Parameter(description = "상위판매조직코드", example = "", hidden = true, required = false)
	@Schema(description = "상위판매조직코드", example = "", hidden = true, required = false, nullable = true)
	private String upperOrgzCd;
	/**
	 * 상위판매조직명
	 */
	@Parameter(description = "상위판매조직명", example = "", hidden = true, required = false)
	@Schema(description = "상위판매조직명", example = "", hidden = true, required = false, nullable = true)
	private String upperOrgzNm;
	/**
	 * 쿠폰할인금액
	 */
	@Parameter(description = "쿠폰할인금액", example = "", hidden = true, required = false)
	@Schema(description = "쿠폰할인금액", example = "", hidden = true, required = false, nullable = true)
	private Double coupnDcAmt;
	/**
	 * 제품상품구분코드
	 */
	@Parameter(description = "제품상품구분코드", example = "", hidden = true, required = false)
	@Schema(description = "제품상품구분코드", example = "", hidden = true, required = false, nullable = true)
	private String itemPrCd;
	/**
	 * 제품상품구분코드
	 */
	@Parameter(description = "제품상품구분코드", example = "", hidden = true, required = false)
	@Schema(description = "제품상품구분코드", example = "", hidden = true, required = false, nullable = true)
	private String itemPrCdNm;
}
