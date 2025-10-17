package com.ceragem.api.as.model;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.DatetimeValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmBosExchngCmptHstListVo
 * @author 이윤성
 * @date 2022. 6. 10.
 * @Version 1.0
 * @description BOS교환완료 이력조회 목록 Vo
 */
@Getter
@Setter
@Schema(description = "BOS교환완료 이력조회 목록 객체")
public class AsmBosExchngCmptHstListVo extends ApiBaseVo {

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
	 * 판매구분코드
	 */
	@Schema(description = "판매구분코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String saleSeCd;

	/**
	 * 고객번호
	 */
	@Schema(description = "고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String custNo;

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String crmCustNo;

	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;

	/**
	 * 품목코드
	 */
	@Schema(description = "품목코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String itemCd;

	/**
	 * SAP품목코드
	 */
	@Schema(description = "SAP품목코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String baseItemCd;

	/**
	 * 품목명
	 */
	@Schema(description = "품목명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String itemNm;

	/**
	 * 접수유형코드
	 */
	@Schema(description = "접수유형코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String acptTyCd;

	/**
	 * 접수유형상세코드
	 */
	@Schema(description = "접수유형상세코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String acptTyDtlCd;

	/**
	 * 처리예정기사
	 */
	@Schema(description = "처리예정기사", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String procDueEngr;

	/**
	 * 처리예정지점
	 */
	@Schema(description = "처리예정지점", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String procDueBhf;

	/**
	 * 처리예정지점명
	 */
	@Schema(description = "처리예정지점명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procDueBhfNm;

	/**
	 * 접수상태
	 */
	@Schema(description = "접수상태", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String acptSts;

	/**
	 * 예정일자
	 */
	@Schema(description = "예정일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String dueDe;

	/**
	 * 신청일자(YYYYMMDD)
	 */
	@Schema(description = "신청일자(YYYYMMDD)", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String reqDe;

	/**
	 * 신청조직코드
	 */
	@Schema(description = "신청조직코드", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String reqOrgzCd;

	/**
	 * 신청조직명
	 */
	@Schema(description = "신청조직명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String reqOrgzNm;

	/**
	 * 신청자
	 */
	@Schema(description = "신청자", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String reqUsr;

	/**
	 * 승인상태코드(AM002)
	 */
	@Schema(description = "승인상태코드(AM002)", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String authStsCd;

	/**
	 * 등록일시
	 */
	@Schema(description = "등록일시", example = "", hidden = false, required = true, nullable = false)
	@DatetimeValue
	private String regDt;

	/**
	 * 수정일시
	 */
	@Schema(description = "수정일시", example = "", hidden = false, required = true, nullable = false)
	@DatetimeValue
	private String updDt;

}
