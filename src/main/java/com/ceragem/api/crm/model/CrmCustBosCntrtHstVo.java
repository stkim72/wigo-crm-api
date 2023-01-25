package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCustBosCntrtHstVo
 * @author 김성태
 * @date 2022. 10. 26.
 * @Version 1.0
 * @description CRMBOS계약이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "BOS계약 객체")
public class CrmCustBosCntrtHstVo extends ApiBaseVo {
	/**
	 * 계약번호
	 */
	@Schema(description = "계약번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@NotEmpty
	@MaxByte(max = 12)
	private String cntrNo;
	/**
	 * 고객번호
	 */
	@Schema(description = "고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String custNo;
	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;
	/**
	 * 계약자 통합고객번호
	 */
	@Schema(description = "계약자 통합고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 고객유형코드
	 */
	@Schema(description = "고객유형코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String custTyCd;
	/**
	 * 고객유형명
	 */
	@Schema(description = "고객유형명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String custTyCdnm;
	/**
	 * 고객유형상세코드
	 */
	@Schema(description = "고객유형상세코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String custTyDtlCd;
	/**
	 * 고객유형상세명
	 */
	@Schema(description = "고객유형상세명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String custTyDtlCdnm;
	/**
	 * 주문번호
	 */
	@Schema(description = "주문번호", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String ordNo;
	/**
	 * 주문번호순번
	 */
	@Schema(description = "주문번호순번", example = "", hidden = false, required = false, nullable = true)
	private Integer ordNoSn;
	/**
	 * 주문일자
	 */
	@Schema(description = "주문일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String ordDe;
	/**
	 * 주문상태코드
	 */
	@Schema(description = "주문상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String ordStsCd;
	/**
	 * 주문상태명
	 */
	@Schema(description = "주문상태명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String ordStsCdnm;
	/**
	 * 주문채널코드
	 */
	@Schema(description = "주문채널코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String ordChnCd;
	/**
	 * 주문구분코드
	 */
	@Schema(description = "주문구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String ordSeCd;
	/**
	 * 주문구분명
	 */
	@Schema(description = "주문구분명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String ordSeCdnm;
	/**
	 * 주문취소일자
	 */
	@Schema(description = "주문취소일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String ordCnclDe;
	/**
	 * 품목코드
	 */
	@Schema(description = "품목코드", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String itemCd;
	/**
	 * 품목명
	 */
	@Schema(description = "품목명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String itemNm;
	/**
	 * 품목그룹코드
	 */
	@Schema(description = "품목그룹코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String itemGrpCd;
	/**
	 * 품목그룹명
	 */
	@Schema(description = "품목그룹명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String itemGrpCdnm;
	/**
	 * 품목유형코드
	 */
	@Schema(description = "품목유형코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String itemTyCd;
	/**
	 * 품목유형명
	 */
	@Schema(description = "품목유형명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String itemTyCdnm;
	/**
	 * 품목유형상세코드
	 */
	@Schema(description = "품목유형상세코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String itemTyDtlCd;
	/**
	 * 품목유형상세명
	 */
	@Schema(description = "품목유형상세명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String itemTyDtlCdnm;
	/**
	 * 시리얼번호
	 */
	@Schema(description = "시리얼번호", example = "", hidden = false, required = false, nullable = true, maxLength = 23)
	@MaxByte(max = 23)
	private String serialNo;
	/**
	 * 판매유형코드
	 */
	@Schema(description = "판매유형코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String saleTyCd;
	/**
	 * 판매유형명
	 */
	@Schema(description = "판매유형명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String saleTyCdnm;
	/**
	 * 판매구분코드
	 */
	@Schema(description = "판매구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String saleSeCd;
	/**
	 * 판매구분명
	 */
	@Schema(description = "판매구분명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String saleSeCdnm;
	/**
	 * 판매그룹코드
	 */
	@Schema(description = "판매그룹코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String saleGrpCd;
	/**
	 * 판매그룹명
	 */
	@Schema(description = "판매그룹명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String saleGrpCdnm;
	/**
	 * 계약상태코드
	 */
	@Schema(description = "계약상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String cntrStsCd;
	/**
	 * 계약상태명
	 */
	@Schema(description = "계약상태명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String cntrStsCdnm;
	/**
	 * 계약상태상세코드
	 */
	@Schema(description = "계약상태상세코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String cntrStsDtlCd;
	/**
	 * 계약상태상세명
	 */
	@Schema(description = "계약상태상세명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String cntrStsDtlCdnm;
	/**
	 * 계약상태상세사유
	 */
	@Schema(description = "계약상태상세사유", example = "", hidden = false, required = false, nullable = true, maxLength = 300)
	@MaxByte(max = 300)
	private String cntrStsDtlRsn;
	/**
	 * 결제상태코드
	 */
	@Schema(description = "결제상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String setlStsCd;
	/**
	 * 결제상태명
	 */
	@Schema(description = "결제상태명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String setlStsCdnm;
	/**
	 * 설치상태코드
	 */
	@Schema(description = "설치상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String istStsCd;
	/**
	 * 설치상태명
	 */
	@Schema(description = "설치상태명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String istStsCdnm;
	/**
	 * 계약취소여부
	 */
	@Schema(description = "계약취소여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String cntrCnclYn;
	/**
	 * 계약취소일자
	 */
	@Schema(description = "계약취소일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String cntrCnclDe;
	/**
	 * 계약취소사유
	 */
	@Schema(description = "계약취소사유", example = "", hidden = false, required = false, nullable = true, maxLength = 300)
	@MaxByte(max = 300)
	private String cntrCnclRsn;
	/**
	 * 본부구분코드
	 */
	@Schema(description = "본부구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String hqSeCd;
	/**
	 * 판매인
	 */
	@Schema(description = "판매인", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String seller;
	/**
	 * 판매인명
	 */
	@Schema(description = "판매인명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String sellernm;
	/**
	 * 판매조직
	 */
	@Schema(description = "판매조직", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String saleOrgz;
	/**
	 * 설치예정조직
	 */
	@Schema(description = "설치예정조직", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String istDueOrgz;
	/**
	 * 설치예정기사
	 */
	@Schema(description = "설치예정기사", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String istDueEngr;
	/**
	 * 설치조직
	 */
	@Schema(description = "설치조직", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String istOrgz;
	/**
	 * 설치기사
	 */
	@Schema(description = "설치기사", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String istEngr;
	/**
	 * 설비번호
	 */
	@Schema(description = "설비번호", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String eqpNo;
	/**
	 * 창고코드
	 */
	@Schema(description = "창고코드", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String wrhCd;
	/**
	 * 창고명
	 */
	@Schema(description = "창고명", example = "", hidden = false, required = false, nullable = true, maxLength = 50)
	@MaxByte(max = 50)
	private String wrhNm;
	/**
	 * 컨택순번
	 */
	@Schema(description = "컨택순번", example = "", hidden = false, required = false, nullable = true)
	private Integer cntcSn;
	/**
	 * 고객컨택상태
	 */
	@Schema(description = "고객컨택상태", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String custCntcSts;
	/**
	 * 고객컨택일자
	 */
	@Schema(description = "고객컨택일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String custCntcDe;
	/**
	 * 설치요청일자
	 */
	@Schema(description = "설치요청일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String istReqDe;
	/**
	 * 설치일자
	 */
	@Schema(description = "설치일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String istDe;
	/**
	 * 설치확정여부
	 */
	@Schema(description = "설치확정여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String istDcsYn;
	/**
	 * 설치확정일자
	 */
	@Schema(description = "설치확정일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String istDcsDe;
	/**
	 * 계약시작일자
	 */
	@Schema(description = "계약시작일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String cntrStartDe;
	/**
	 * 계약종료예정일자
	 */
	@Schema(description = "계약종료예정일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String cntrEndDueDe;
	/**
	 * 계약종료여부
	 */
	@Schema(description = "계약종료여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String cntrEndYn;
	/**
	 * 계약종료일자
	 */
	@Schema(description = "계약종료일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String cntrEndDe;
	/**
	 * 매출확정여부
	 */
	@Schema(description = "매출확정여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String selngDcsYn;
	/**
	 * 매출확정일자
	 */
	@Schema(description = "매출확정일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String selngDcsDe;
	/**
	 * 신용조회여부
	 */
	@Schema(description = "신용조회여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String cdtSelYn;
	/**
	 * 가격정책번호
	 */
	@Schema(description = "가격정책번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String prcPlcNo;
	/**
	 * 약정기간코드
	 */
	@Schema(description = "약정기간코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String agrPdCd;
	/**
	 * 약정기간명
	 */
	@Schema(description = "약정기간명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String agrPdCdnm;
	/**
	 * 계약기간값
	 */
	@Schema(description = "계약기간값", example = "", hidden = false, required = false, nullable = true)
	private Integer cntrPdVal;
	/**
	 * 서비스기간코드
	 */
	@Schema(description = "서비스기간코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String svcPdCd;
	/**
	 * 점검주기
	 */
	@Schema(description = "점검주기", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String svcCycle;
	/**
	 * 선납여부
	 */
	@Schema(description = "선납여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String prepayYn;
	/**
	 * 선납금액
	 */
	@Schema(description = "선납금액", example = "", hidden = false, required = false, nullable = true)
	private Double prepayAmt;
	/**
	 * 선납주기
	 */
	@Schema(description = "선납주기", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String prepayCycle;
	/**
	 * 선납할인율
	 */
	@Schema(description = "선납할인율", example = "", hidden = false, required = false, nullable = true)
	private Integer prepayDcrt;
	/**
	 * 등록비
	 */
	@Schema(description = "등록비", example = "", hidden = false, required = false, nullable = true)
	private Double regfee;
	/**
	 * 설치비
	 */
	@Schema(description = "설치비", example = "", hidden = false, required = false, nullable = true)
	private Double istct;
	/**
	 * 해체비
	 */
	@Schema(description = "해체비", example = "", hidden = false, required = false, nullable = true)
	private Double dfee;
	/**
	 * 기본렌탈금액
	 */
	@Schema(description = "기본렌탈금액", example = "", hidden = false, required = false, nullable = true)
	private Double bassRentAmt;
	/**
	 * 렌탈금액
	 */
	@Schema(description = "렌탈금액", example = "", hidden = false, required = false, nullable = true)
	private Double rentAmt;
	/**
	 * 기본판매금액
	 */
	@Schema(description = "기본판매금액", example = "", hidden = false, required = false, nullable = true)
	private Double bassSaleAmt;
	/**
	 * 판매금액
	 */
	@Schema(description = "판매금액", example = "", hidden = false, required = false, nullable = true)
	private Double salesAmt;
	/**
	 * 결제금액
	 */
	@Schema(description = "결제금액", example = "", hidden = false, required = false, nullable = true)
	private Double setlAmt;
	/**
	 * 주문금액
	 */
	@Schema(description = "주문금액", example = "", hidden = false, required = false, nullable = true)
	private Double ordAmt;
	/**
	 * 주문부가세제외금액
	 */
	@Schema(description = "주문부가세제외금액", example = "", hidden = false, required = false, nullable = true)
	private Double ordVatExclAmt;
	/**
	 * 주문부가세금액
	 */
	@Schema(description = "주문부가세금액", example = "", hidden = false, required = false, nullable = true)
	private Double ordVatAmt;
	/**
	 * 매출금액
	 */
	@Schema(description = "매출금액", example = "", hidden = false, required = false, nullable = true)
	private Double selngAmt;
	/**
	 * 매출부가세제외금액
	 */
	@Schema(description = "매출부가세제외금액", example = "", hidden = false, required = false, nullable = true)
	private Double selngVatExclAmt;
	/**
	 * 매출부가세금액
	 */
	@Schema(description = "매출부가세금액", example = "", hidden = false, required = false, nullable = true)
	private Double selngVatAmt;
	/**
	 * 매출번호
	 */
	@Schema(description = "매출번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String selngNo;
	/**
	 * 부가세코드
	 */
	@Schema(description = "부가세코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String vatCd;
	/**
	 * 판매채널코드
	 */
	@Schema(description = "판매채널코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String saleChnCd;
	/**
	 * 판매채널명
	 */
	@Schema(description = "판매채널명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String saleChnCdnm;
	/**
	 * 프로모션여부
	 */
	@Schema(description = "프로모션여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String prmtYn;
	/**
	 * 프로모션정책번호
	 */
	@Schema(description = "프로모션정책번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String prmtPlcNo;
	/**
	 * 프로모션번호
	 */
	@Schema(description = "프로모션번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String prmtNo;
	/**
	 * 패키지여부
	 */
	@Schema(description = "패키지여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String pkgYn;
	/**
	 * 패키지정책번호
	 */
	@Schema(description = "패키지정책번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String pkgPlcNo;
	/**
	 * 패키지번호
	 */
	@Schema(description = "패키지번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String pkgNo;
	/**
	 * 단체여부
	 */
	@Schema(description = "단체여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String grpYn;
	/**
	 * 단체코드
	 */
	@Schema(description = "단체코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String grpCd;
	/**
	 * 단체번호
	 */
	@Schema(description = "단체번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String grpNo;
	/**
	 * 계약서파일번호
	 */
	@Schema(description = "계약서파일번호", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String ctrtcFileNo;
	/**
	 * 서명파일번호
	 */
	@Schema(description = "서명파일번호", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String signFileNo;
	/**
	 * 서비스여부
	 */
	@Schema(description = "서비스여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String svcYn;
	/**
	 * 기존계약번호
	 */
	@Schema(description = "기존계약번호", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String existCntrNo;
	/**
	 * 반품유형코드
	 */
	@Schema(description = "반품유형코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rtgdTyCd;
	/**
	 * 반품요청일자
	 */
	@Schema(description = "반품요청일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String rtgdReqDe;
	/**
	 * 반품접수확정여부
	 */
	@Schema(description = "반품접수확정여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String rtgdDcsYn;
	/**
	 * 반품완료일자
	 */
	@Schema(description = "반품완료일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String rtgdEndDe;
	/**
	 * 약관정책번호
	 */
	@Schema(description = "약관정책번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String spltPlcNo;
	/**
	 * 설치예정일자
	 */
	@Schema(description = "설치예정일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String istDueDe;
	/**
	 * 추가증빙파일번호1
	 */
	@Schema(description = "추가증빙파일번호1", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String addPrufFileNo1;
	/**
	 * 추가증빙파일번호2
	 */
	@Schema(description = "추가증빙파일번호2", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String addPrufFileNo2;
	/**
	 * 신용등급코드
	 */
	@Schema(description = "신용등급코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String cdtGradCd;
	/**
	 * 등록자ID
	 */
	@Schema(description = "등록자ID", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String regUsrId;
	/**
	 * 수정자ID
	 */
	@Schema(description = "수정자ID", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String updUsrId;
	/**
	 * 수정일시
	 */
	@Schema(description = "수정일시 (YYYYMMDDHH24MISS)", example = "20221026143856", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String updDt;
	/**
	 * 설치-우편번호
	 */
	@Schema(description = "설치-우편번호", example = "", hidden = false, required = false, nullable = true, maxLength = 6)
	@MaxByte(max = 6)
	private String postNo;
	/**
	 * 설치-기본주소
	 */
	@Schema(description = "설치-기본주소", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String bassAddr;
	/**
	 * 설치-상세주소
	 */
	@Schema(description = "설치-상세주소", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String dtlAddr;
	/**
	 * 설치-모바일번호
	 */
	@Schema(description = "설치-모바일번호", example = "", hidden = false, required = false, nullable = true, maxLength = 152)
	@MaxByte(max = 152)
	private String mobNo;
	/**
	 * 설치-전화번호
	 */
	@Schema(description = "설치-전화번호", example = "", hidden = false, required = false, nullable = true, maxLength = 88)
	@MaxByte(max = 88)
	private String telNo;
	/**
	 * 설치-특이사항
	 */
	@Schema(description = "설치-특이사항", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String partclrMatter;
	/**
	 * 설치-설치고객명
	 */
	@Schema(description = "설치-설치고객명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String istCustNm;
	/**
	 * 정기결제-카드번호
	 */
	@Schema(description = "정기결제-카드번호", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String cardNo;
	/**
	 * 정기결제-카드사코드
	 */
	@Schema(description = "정기결제-카드사코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String cdcmpCd;
	/**
	 * 정기결제-소유주명
	 */
	@Schema(description = "정기결제-소유주명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String ownerNm;
	/**
	 * 정기결제-방법코드
	 */
	@Schema(description = "정기결제-방법코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String fsetlMthCd;
	/**
	 * 정기결제-방법명
	 */
	@Schema(description = "정기결제-방법명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String fsetlMthCdnm;
	/**
	 * 정기결제일자코드
	 */
	@Schema(description = "정기결제일자코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String fsetlDeCd;
	/**
	 * 계좌신청동의파일번호
	 */
	@Schema(description = "계좌신청동의파일번호", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String acctAfileNo;
	/**
	 * 출고상태코드
	 */
	@Schema(description = "출고상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String otbnStsCd;
	/**
	 * 출고상태명
	 */
	@Schema(description = "출고상태명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String otbnStsCdnm;
	/**
	 * 비고
	 */
	@Schema(description = "비고", example = "", hidden = false, required = false, nullable = true, maxLength = 3000)
	@MaxByte(max = 3000)
	private String rm;
	/**
	 * 기본멤버십금액
	 */
	@Schema(description = "기본멤버십금액", example = "", hidden = false, required = false, nullable = true)
	private Double bassMbrshAmt;
	/**
	 * 멤버십금액
	 */
	@Schema(description = "멤버십금액", example = "", hidden = false, required = false, nullable = true)
	private Double mbrshAmt;
	/**
	 * 일시불무상종료예정일
	 */
	@Schema(description = "일시불무상종료예정일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String lmpsFreeEndDueDe;
	/**
	 * 패키지해지여부
	 */
	@Schema(description = "패키지해지여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String pkgTrmnYn;
	/**
	 * 배송유형코드
	 */
	@Schema(description = "배송유형코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String dlvTyCd;
	/**
	 * 배송유형명
	 */
	@Schema(description = "배송유형명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String dlvTyCdnm;
	/**
	 * 배송유형상세코드
	 */
	@Schema(description = "배송유형상세코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String dlvTyDtlCd;
	/**
	 * 배송유형상세명
	 */
	@Schema(description = "배송유형상세명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String dlvTyDtlCdnm;
	/**
	 * 약정기간값
	 */
	@Schema(description = "약정기간값", example = "", hidden = false, required = false, nullable = true)
	private Integer agrPdVal;
	/**
	 * 계약기간구분코드
	 */
	@Schema(description = "계약기간구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String cntrPdSeCd;
	/**
	 * 계약기간구분명
	 */
	@Schema(description = "계약기간구분명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String cntrPdSeCdnm;
	/**
	 * 계약이후처리방법코드
	 */
	@Schema(description = "계약이후처리방법코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String cntrEndAfterProcMthCd;
	/**
	 * 계약종료이후처리방법
	 */
	@Schema(description = "계약종료이후처리방법", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String cntrEndAfterProcMthCdnm;
	/**
	 * 중고구분코드
	 */
	@Schema(description = "중고구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String uatcSeCd;
	/**
	 * 중고구분명
	 */
	@Schema(description = "중고구분명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String uatcSeCdnm;
	/**
	 * 중고등급코드
	 */
	@Schema(description = "중고등급코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String uatcGradCd;
	/**
	 * 중고등급명
	 */
	@Schema(description = "중고등급명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String uatcGradCdnm;
	/**
	 * 스케줄생성여부
	 */
	@Schema(description = "스케줄생성여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String shdeCreYn;
	/**
	 * 렌탈구분코드
	 */
	@Schema(description = "렌탈구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rentSeCd;
	/**
	 * 렌탈구분명
	 */
	@Schema(description = "렌탈구분명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rentSeCdnm;
	/**
	 * 홈체험청구할인기간코드
	 */
	@Schema(description = "홈체험청구할인기간코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String exprnDmdDcPdCd;
	/**
	 * 홈체험청구할인기간명
	 */
	@Schema(description = "홈체험청구할인기간명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String exprnDmdDcPdCdnm;
	/**
	 * 홈체험계약번호
	 */
	@Schema(description = "홈체험계약번호", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String exprnCntrNo;
	/**
	 * 추천인
	 */
	@Schema(description = "추천인", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String rcmdr;
	/**
	 * 추천인명
	 */
	@Schema(description = "추천인명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rcmdrnm;
	/**
	 * 추천인조직코드
	 */
	@Schema(description = "추천인조직코드", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String orgzCd;
	/**
	 * 추천인조직명
	 */
	@Schema(description = "추천인조직명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String orgzNm;
	/**
	 * 본인영업구분코드
	 */
	@Schema(description = "본인영업구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String selfBsnSeCd;
	/**
	 * 본인영업구분명
	 */
	@Schema(description = "본인영업구분명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String selfBsnSeCdnm;
	/**
	 * 사은품내역
	 */
	@Schema(description = "사은품내역", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String prsntDtls;
	/**
	 * 무상판매유형
	 */
	@Schema(description = "무상판매유형", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String freeSaleTy;
	/**
	 * 무상판매유형명
	 */
	@Schema(description = "무상판매유형명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String freeSaleTynm;
	/**
	 * 관리번호
	 */
	@Schema(description = "관리번호", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String mngNo;
	/**
	 * 컨택상태명
	 */
	@Schema(description = "컨택상태명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String cntcStsCdnm;
	/**
	 * 기본판매요금
	 */
	@Schema(description = "기본판매요금", example = "", hidden = false, required = false, nullable = true)
	private Double bassSaleFee;
	/**
	 * 가격정책명
	 */
	@Schema(description = "가격정책명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String prcPlcNm;
	/**
	 * 계약수량
	 */
	@Schema(description = "계약수량", example = "", hidden = false, required = false, nullable = true)
	private Double cntrQy;
	/**
	 * 할인율
	 */
	@Schema(description = "할인율", example = "", hidden = false, required = false, nullable = true, maxLength = 41)
	@MaxByte(max = 41)
	private String dcrt;
	/**
	 * 할인금액
	 */
	@Schema(description = "할인금액", example = "", hidden = false, required = false, nullable = true)
	private Double dcAmt;
	/**
	 * 이지렌탈계약번호
	 */
	@Schema(description = "이지렌탈계약번호", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String erCntrNo;
	/**
	 * 대표번호여부
	 */
	@Schema(description = "대표번호여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String rprsntvCntrYn;
	/**
	 * 주문유형코드
	 */
	@Schema(description = "주문유형코드", example = "", hidden = false, required = false, nullable = true)
	private String orTyCd;
	/**
	 * 주문유형
	 */
	@Schema(description = "주문유형", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String orTyCdnm;
	/**
	 * 사은품여부
	 */
	@Schema(description = "사은품여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String prsntYn;
	/**
	 * 원계약번호(사은품)
	 */
	@Schema(description = "원계약번호(사은품)", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String prsntCntrNo;
	/**
	 * 건기식주문번호
	 */
	@Schema(description = "건기식주문번호", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String ceramOrdNo;
	/**
	 * 선세금계산서발급여부
	 */
	@Schema(description = "선세금계산서발급여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String ptaxbilYn;
	/**
	 * 선세금계산서기준일자
	 */
	@Schema(description = "선세금계산서기준일자", example = "", hidden = false, required = false, nullable = true, maxLength = 2)
	@MaxByte(max = 2)
	private String ptaxbilDe;
	/**
	 * 선세금계산서담당자
	 */
	@Schema(description = "선세금계산서담당자", example = "", hidden = false, required = false, nullable = true, maxLength = 64)
	@MaxByte(max = 64)
	private String ptaxbilChrgrSn;
	/**
	 * 담당자이메일
	 */
	@Schema(description = "담당자이메일", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String chrgrEmail;
	/**
	 * 담당자연락처
	 */
	@Schema(description = "담당자연락처", example = "", hidden = false, required = false, nullable = true, maxLength = 152)
	@MaxByte(max = 152)
	private String chrgrCttpc;
	/**
	 * 담당자부서명
	 */
	@Schema(description = "담당자부서명", example = "", hidden = false, required = false, nullable = true, maxLength = 64)
	@MaxByte(max = 64)
	private String chrgrDeptNm;
	/**
	 * 추천고객멤버십아이디
	 */
	@Schema(description = "추천고객멤버십아이디", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String rcmdrMbrshId;
	/**
	 * 추천고객멤버십이름
	 */
	@Schema(description = "추천고객멤버십이름", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rcmdrMbrshNm;
	/**
	 * 인수서파일번호
	 */
	@Schema(description = "인수서파일번호", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	@MaxByte(max = 12)
	private String cfileNo;
	/**
	 * 조견표번호
	 */
	@Schema(description = "조견표번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String insSerNo;
	/**
	 * 채권분류코드
	 */
	@Schema(description = "채권분류코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String bondCd;
	/**
	 * 채권분류명
	 */
	@Schema(description = "채권분류명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String bondCdnm;
	/**
	 * 사용쿠폰기본번호
	 */
	@Schema(description = "사용쿠폰기본번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String useCoupnBasNo;
	/**
	 * 사용포인트금액
	 */
	@Schema(description = "사용포인트금액", example = "", hidden = false, required = false, nullable = true)
	private Double usePointAmt;
	/**
	 * 캠페인번호
	 */
	@Schema(description = "캠페인번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String campBasNo;
	/**
	 * 프로모션코드
	 */
	@Schema(description = "프로모션코드", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String promNo;
	/**
	 * 품목코드(SAP코드)
	 */
	@Schema(description = "품목코드(SAP코드)", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String baseItemCd;
	/**
	 * 판매조직 고객코드(SAP코드)
	 */
	@Schema(description = "판매조직 고객코드(SAP코드)", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String saleOrgzCustCd;
	/**
	 * 판매조직명
	 */
	@Schema(description = "판매조직명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String slaeOrgzNm;
	/**
	 * 상위판매조직코드
	 */
	@Schema(description = "상위판매조직코드", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String upperOrgzCd;
	/**
	 * 상위판매조직명
	 */
	@Schema(description = "상위판매조직명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String upperOrgzNm;
	/**
	 * 쿠폰할인금액
	 */
	@Schema(description = "쿠폰할인금액", example = "", hidden = false, required = false, nullable = true)
	private Double coupnDcAmt;
	/**
	 * 제품상품구분코드
	 */
	@Schema(description = "제품상품구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String itemPrCd;
	/**
	 * 제품상품구분코드
	 */
	@Schema(description = "제품상품구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String itemPrCdNm;
}
