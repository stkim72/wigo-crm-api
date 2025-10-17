package com.ceragem.api.as.model;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmSapPrecChitTrmListVo
 * @author 이윤성
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description 입금정보/선수금전표 수신 Vo (현금입금, 카드승인 내역중 선수금 전표 생성 내역을 전송(반제되지 않은 건만))
 *
 *              (반제처리 된 이후에 카드승인 취소건은 안넘어감)
 */
@Getter
@Setter
@Schema(description = "입금정보/선수금전표 수신 객체")
public class AsmSapPrecChitTrmListVo {

	/**
	 * 순번
	 */
	@Schema(description = "순번", example = "", hidden = false, required = true, nullable = false)
	private int seq;

	/**
	 * 회사코드
	 *
	 * AS시스템에는 회사코드 8000만 전송
	 */
	@Schema(description = "회사코드 (CNS 코드 : 8000, 본사 : 1000)", example = "", hidden = false, required = true, nullable = false)
	private String bukrs;

	/**
	 * 대금유형
	 */
	@Schema(description = "결제 방식(01 : 카드, 03 : 현금)", example = "", hidden = false, required = true, nullable = false)
	private String paytype;

	/**
	 * 거래 번호 - 현금입금 및 카드승인건의 키필드
	 */
	@Schema(description = "거래 번호", example = "", hidden = false, required = true, nullable = false)
	private String ordno;

	/**
	 * 신규/변경/삭제
	 *
	 * 선수금전표가 변경되었을 경우 TRAN_TYPE = 'U'로 재전송
	 *
	 * 카드승인 취소되었을 경우 TRAN_TYPE = 'D'로 전송
	 */
	@Schema(description = "전송데이터유형 (I : 신규, U : 변경, D : 삭제)", example = "", hidden = false, required = true, nullable = false)
	private String trantype;

	/**
	 * 거래일자 - 현금입금일 또는 카드승인일자
	 */
	@Schema(description = "거래일자", example = "", hidden = false, required = true, nullable = false)
	private String paydate;

	/**
	 * 은행/카드사 - 현금 : 입금계좌 은행명, 카드 : 결제 카드사명
	 */
	@Schema(description = "은행/카드사", example = "", hidden = false, required = true, nullable = false)
	private String bankcd;

	/**
	 * 입금자
	 */
	@Schema(description = "입금자", example = "", hidden = false, required = true, nullable = false)
	private String ordnm;

	/**
	 * 현금입금액/카드승인금액
	 */
	@Schema(description = "현금입금액/카드승인금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal payamt;

	/**
	 * 승인번호 - 카드 승인번호
	 */
	@Schema(description = "승인번호", example = "", hidden = false, required = true, nullable = false)
	private String approvalno;

	/**
	 * 카드명
	 */
	@Schema(description = "카드명", example = "", hidden = false, required = true, nullable = false)
	private String cardname;

	/**
	 * 전표번호(선수금)
	 */
	@Schema(description = "전표번호(선수금)", example = "", hidden = false, required = true, nullable = false)
	private String belnr;

	/**
	 * 회계연도(선수금) - 선수금전표 회계연도 (회사코드+전표번호+회계연도 3개필드 조합이 SAP에서 Key임)
	 */
	@Schema(description = "회계연도(선수금)", example = "", hidden = false, required = true, nullable = false)
	private String gjahr;
}
