package com.ceragem.api.as.model;

import java.math.BigDecimal;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.crm.validate.DateValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmBosInstallHst02ListVo
 * @author 이윤성
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description BOS설치이력(제품교환) 목록 Vo
 */
@Getter
@Setter
@Schema(description = "BOS설치이력(제품교환) 목록 객체")
public class AsmBosInstallHst02ListVo {

	/**
	 * CRM고객번호
	 */
	@Schema(description = "CRM고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String crmCustNo;

	/**
	 * 처리번호
	 */
	@Schema(description = "처리번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String procNo;

	/**
	 * 접수번호
	 */
	@Schema(description = "접수번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String acptNo;

	/**
	 * 계약번호
	 */
	@Schema(description = "계약번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String cntrNo;

	/**
	 * 처리지점
	 */
	@Schema(description = "처리지점", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String procBhf;

	/**
	 * 처리지점명
	 */
	@Schema(description = "처리지점명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procBhfNm;

	/**
	 * 처리기사
	 */
	@Schema(description = "처리기사", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String procEngr;

	/**
	 * 처리기사명
	 */
	@Schema(description = "처리기사명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procEngrNm;

	/**
	 * 거래일자
	 */
	@Schema(description = "거래일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String procDe;

	/**
	 * 처리시간
	 */
	@Schema(description = "처리시간", example = "", hidden = false, required = true, nullable = false, maxLength = 6)
	@MaxByte(max = 6)
	private String procTime;

	/**
	 * 고객확인
	 */
	@Schema(description = "고객확인", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custCnfirm;

	/**
	 * 처리유형코드
	 */
	@Schema(description = "처리유형코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String procTyCd;

	/**
	 * 처리유형상세코드
	 */
	@Schema(description = "처리유형상세코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String procTyDtlCd;

	/**
	 * 고객번호
	 */
	@Schema(description = "고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String custNo;

	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;

	/**
	 * 판매구분코드명
	 */
	@Schema(description = "판매구분코드명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String saleSeCdNm;

	/**
	 * 본부 구분 명
	 */
	@Schema(description = "본부 구분 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String hqSeNm;

	/**
	 * 설비 번호
	 */
	@Schema(description = "설비 번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String eqpNo;

	/**
	 * 품목코드
	 */
	@Schema(description = "품목코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String itemCd;

	/**
	 * 품목명
	 */
	@Schema(description = "품목명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String itemNm;

	/**
	 * 품목 그룹 코드
	 */
	@Schema(description = "품목 그룹 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String itemGrpCd;

	/**
	 * 요금코드
	 */
	@Schema(description = "요금코드", example = "", hidden = false, required = true, nullable = false, maxLength = 15)
	@MaxByte(max = 15)
	private String feeCd;

	/**
	 * 매출 확정 여부
	 */
	@Schema(description = "매출 확정 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@MaxByte(max = 1)
	private String selngDcsYn;

	/**
	 * 거래금액
	 */
	@Schema(description = "거래금액", example = "", hidden = false, required = true, nullable = false)
	private int procAmt;

	/**
	 * 모바일 처리 여부
	 */
	@Schema(description = "모바일 처리 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@MaxByte(max = 1)
	private String mobProcYn;

	/**
	 * 첨부 파일 번호
	 */
	@Schema(description = "첨부 파일 번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String atchFileNo;

	/**
	 * 부품 순번
	 */
	@Schema(description = "부품 순번", example = "", hidden = false, required = true, nullable = false)
	private int partSn;

	/**
	 * 부품 코드
	 */
	@Schema(description = "부품 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String partCd;

	/**
	 * 부품명
	 */
	@Schema(description = "부품명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String partNm;

	/**
	 * 바코드 관리 상품 여부
	 */
	@Schema(description = "바코드 관리 상품 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@MaxByte(max = 1)
	private String brcdMngPrYn;

	/**
	 * 제품 바코드
	 */
	@Schema(description = "제품 바코드", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String prBrcd;

	/**
	 * 수량
	 */
	@Schema(description = "수량", example = "", hidden = false, required = true, nullable = false)
	private int qy;

	/**
	 * 무상 코드
	 */
	@Schema(description = "무상 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String freeCd;

	/**
	 * 무상코드명
	 */
	@Schema(description = "무상코드명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String freeNm;

	/**
	 * 부품 단가
	 */
	@Schema(description = "부품 단가", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal partUprc;

	/**
	 * 처리금액
	 */
	@Schema(description = "처리금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal partProcAmt;

	/**
	 * 할인금액
	 */
	@Schema(description = "할인금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal dcAmt;

	/**
	 * 접수유형코드명
	 */
	@Schema(description = "접수유형코드명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String acptTyCdNm;

	/**
	 * 접수유형상세명
	 */
	@Schema(description = "접수유형상세명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String acptTyDtlNm;

	/**
	 * 처리유형명
	 */
	@Schema(description = "처리유형명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procTyNm;

	/**
	 * 처리유형상세명
	 */
	@Schema(description = "처리유형상세명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procTyDtlNm;

	/**
	 * 특이 사항
	 */
	@Schema(description = "특이 사항", example = "", hidden = false, required = true, nullable = false, maxLength = 300)
	@MaxByte(max = 300)
	private String partclrMatter;

	/**
	 * 배정 일자
	 */
	@Schema(description = "배정 일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String asignDe;

	/**
	 * 배정 시간
	 */
	@Schema(description = "배정 시간", example = "", hidden = false, required = true, nullable = false, maxLength = 6)
	@MaxByte(max = 6)
	private String asignTime;

	/**
	 * 발령 일자
	 */
	@Schema(description = "발령 일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String appnDe;

	/**
	 * 약속시간
	 */
	@Schema(description = "약속시간", example = "", hidden = false, required = true, nullable = false, maxLength = 6)
	@MaxByte(max = 6)
	private String appnTime;

	/**
	 * 접수일자
	 */
	@Schema(description = "접수일자", example = "", hidden = false, required = true, nullable = false)
	@DateValue
	private String strRegDt;

	/**
	 * 수납 완료 여부
	 */
	@Schema(description = "수납 완료 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@MaxByte(max = 1)
	private String rcivEndYn;

	/**
	 * 반환 제품 바코드
	 */
	@Schema(description = "반환 제품 바코드", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String rtnPrBrcd;

	/**
	 * 설치 제품 바코드
	 */
	@Schema(description = "설치 제품 바코드", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String istPrBrcd;

	/**
	 * 신청 내용
	 */
	@Schema(description = "신청 내용", example = "", hidden = false, required = true, nullable = false, maxLength = 300)
	@MaxByte(max = 300)
	private String reqCn;

	/**
	 * 승인 상태 코드(AM002)
	 */
	@Schema(description = "승인 상태 코드(AM002)", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String authStsCd;

	/**
	 * 승인상태명
	 */
	@Schema(description = "승인상태명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String authStsNm;

	/**
	 * 출고 번호
	 */
	@Schema(description = "출고 번호", example = "", hidden = false, required = true, nullable = false, maxLength = 15)
	@MaxByte(max = 15)
	private String otbnNo;

	/**
	 * 출고 상태 코드(WM016)
	 */
	@Schema(description = "출고 상태 코드(WM016)", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String otbnStsCd;

	/**
	 * 출고상태명
	 */
	@Schema(description = "출고상태명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String otbnStsNm;

	/**
	 * 처리기사연락처(휴대폰)
	 */
	@Schema(description = "처리기사연락처(휴대폰)", example = "", hidden = false, required = true, nullable = false, maxLength = 11)
	@MaxByte(max = 11)
	private String procEngrMobNo;
}
