package com.ceragem.api.as.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmAsHstVo
 * @author 이윤성
 * @date 2022. 5. 20.
 * @Version 1.0
 * @description AS이력 Vo
 */
@Getter
@Setter
@Schema(description = "AS이력 객체")
public class AsmAsHstVo extends ApiBaseVo {
	/**
	 * 이력일련번호
	 */
	@Schema(description = "이력일련번호", example = "1", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String hstSeq;

	/**
	 * AS접수번호
	 */
	@Schema(description = "AS접수번호", example = "330100", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String asSubmitNo;

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "857545", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String itgCustNo;

	/**
	 * 접수일자
	 */
	@Schema(description = "접수일자", example = "2022-01-01", hidden = false, required = true, nullable = false, maxLength = 14)
	@NotEmpty
	@MaxByte(max = 14)
	private String submitDate;

	/**
	 * 처리완료일시
	 */
	@Schema(description = "처리완료일시", example = "", hidden = false, required = true, nullable = false, maxLength = 14)
	@NotEmpty
	@MaxByte(max = 14)
	private String trtCmptDt;

	/**
	 * 제품일련번호
	 */
	@Schema(description = "제품일련번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String godsSrialNo;

	/**
	 * 제품설명명
	 */
	@Schema(description = "제품명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String godsExplnNm;

	/**
	 * 모델코드
	 */
	@Schema(description = "모델코드", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String modelCd;

	/**
	 * 모델명
	 */
	@Schema(description = "모델명", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
	@NotEmpty
	@MaxByte(max = 1000)
	private String modelNm;

	/**
	 * 불량증상명
	 */
	@Schema(description = "불량증상명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	@MaxByte(max = 100)
	private String badSymtmNm;

	/**
	 * 조치내용
	 */
	@Schema(description = "조치내용", example = "", hidden = false, required = false, nullable = false, maxLength = 1000)
	@NotEmpty
	@MaxByte(max = 1000)
	private String actnCtnts;

	/**
	 * 총금액
	 */
	@Schema(description = "총금액", example = "", hidden = false, required = false, nullable = true)
	private Integer totAmt;

	/**
	 * 출장비금액
	 */
	@Schema(description = "출장비금액", example = "", hidden = false, required = false, nullable = true)
	private Integer tvexpnsAmt;

	/**
	 * 결제금액(서비스비용)
	 */
	@Schema(description = "서비스비용", example = "", hidden = false, required = false, nullable = true)
	private Integer payAmt;

	/**
	 * 할인금액
	 */
	@Schema(description = "할인금액", example = "", hidden = false, required = false, nullable = true)
	private Integer dcAmt;

	/**
	 * SMS비고 (접수내용)
	 */
	@Schema(description = "SMS비고(접수내용)", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String smsRmark;

	/**
	 * 접수비고 (접수내용)
	 */
	@Schema(description = "접수비고(접수내용)", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String submitRmark;

	/**
	 * 처리비고 (조치사항)
	 */
	@Schema(description = "처리비고(조치사항)", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String trtRmark;

	/**
	 * 상담사사원ID
	 */
	@Schema(description = "AS접수자사원ID", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String csagEmpId;

	/**
	 * 상담자사원명
	 */
	@Schema(description = "AS접수자", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String cnslgPrsnEmpNm;

	/**
	 * AS처리담당자사원ID
	 */
	@Schema(description = "AS처리담당자사원ID", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String trtPicEmpId;

	/**
	 * 처리담당자명
	 */
	@Schema(description = "AS처리담당자", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String trtPicNm;

	/**
	 * AS상태코드
	 */
	@Schema(description = "AS상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String asStatusCd;

	/**
	 * AS상태코드명
	 */
	@Schema(description = "AS상태코드명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String asStatusNm;
}
