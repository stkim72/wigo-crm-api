package com.ceragem.api.as.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.as.validate.DatetimeValue;
import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmAsSubmitBasHstVo
 * @author 이윤성
 * @date 2022. 5. 26.
 * @Version 1.0
 * @description A/S마스터 이력 VO
 */
@Getter
@Setter
@Schema(description = "A/S마스터 이력 객체")
public class AsmAsSubmitBasHstVo extends ApiBaseVo {

	/**
	 * 이력일련번호
	 */
	@Schema(description = "HST_SEQ", example = "1", hidden = false, required = true, nullable = false, maxLength = 30)
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
	 * BOS고객번호
	 */
	@Schema(description = "BOS고객번호", example = "857545", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String bosCustNo;

	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	@MaxByte(max = 100)
	private String custNm;

	/**
	 * 이동전화번호
	 */
	@Schema(description = "이동전화번호", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String mphonNo;

	/**
	 * 우편번호
	 */
	@Schema(description = "우편번호", example = "", hidden = false, required = true, nullable = false, maxLength = 5)
	@NotEmpty
	@MaxByte(max = 5)
	private String zipCd;

	/**
	 * 주소1내용
	 */
	@Schema(description = "주소1내용", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
	@NotEmpty
	@MaxByte(max = 1000)
	private String addr1Ctnts;

	/**
	 * 주소2내용
	 */
	@Schema(description = "주소2내용", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
	@NotEmpty
	@MaxByte(max = 1000)
	private String addr2Ctnts;

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
	 * AS상태코드
	 */
	@Schema(description = "AS접수상태  [30 : 접수 , 32 : 완료 , 33 : 취소 , 35 : 해피콜완료]", example = "3", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "C07", codes = { "30", "32", "33",
			"35" }, message = "[30 : 접수 , 32 : 완료 , 33 : 취소 , 35 : 해피콜완료] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String asStatusCd;

	/**
	 * AS상태코드명
	 */
	@Schema(description = "AS접수상태명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String asStatusCdNm;

	/**
	 * AS처리구분코드
	 */
	@Schema(description = "AS처리구분코드  [AS1101001 : 방문처리 , AS1101003 : 기타 , AS1101002 : 소품발송]", example = "AS1101001", hidden = false, required = true, nullable = false, maxLength = 100)
	@CodeValue(codeId = "AS110", codes = { "AS1101001", "AS1101003",
			"AS1101002" }, message = "[AS1101001 : 방문처리 , AS1101003 : 기타 , AS1101002 : 소품발송] 등록된 코드가 아닙니다. ")
	@NotEmpty
	@MaxByte(max = 100)
	private String asTrtDivCd;

	/**
	 * AS처리구분코드명
	 */
	@Schema(description = "AS처리구분코드명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String asTrtDivCdNm;

	/**
	 * 상담사사원ID
	 */
	@Schema(description = "상담사사원ID", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String csagEmpId;

	/**
	 * 상담자사원명
	 */
	@Schema(description = "AS접수자", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String cnslgPrsnEmpNm;

	/**
	 * 방문예정일
	 */
	@Schema(description = "방문예정일", example = "", hidden = false, required = false, nullable = true, maxLength = 25)
	@MaxByte(max = 25)
	private String visitExptDay;

	/**
	 * 방문예정시간
	 */
	@Schema(description = "방문예정시간", example = "", hidden = false, required = false, nullable = true, maxLength = 25)
	@MaxByte(max = 25)
	private String visitExptHour;

	/**
	 * 처리첨부파일ID
	 */
	@Schema(description = "첨부사진", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String trtAttchFileId;

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
	 * 할인금액
	 */
	@Schema(description = "할인금액", example = "", hidden = false, required = false, nullable = true)
	private Integer dcAmt;

	/**
	 * 결제금액
	 */
	@Schema(description = "서비스비용", example = "", hidden = false, required = false, nullable = true)
	private Integer payAmt;

	/**
	 * 처리담당자명
	 */
	@Schema(description = "AS담당자", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String trtPicNm;

	/**
	 * 처리담당자사원연락처
	 */
	@Schema(description = "AS담당자 연락처", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String trtPicMphonNo;

	/**
	 * 처리완료일시
	 */
	@Schema(description = "처리완료일시(YYYYMMDDHH24MISS)", example = "", hidden = false, required = false, nullable = true, maxLength = 25)
	@DatetimeValue
	@MaxByte(max = 25)
	private String trtCmptDt;

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
}
