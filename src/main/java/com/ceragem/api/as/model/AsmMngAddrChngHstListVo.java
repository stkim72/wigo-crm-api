package com.ceragem.api.as.model;

import com.ceragem.api.as.validate.DateValue;
import com.ceragem.api.as.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmMngAddrChngHstListVo
 * @author 이윤성
 * @date 2022. 6. 23.
 * @Version 1.0
 * @description BOS관리주소변경이력 목록 Vo
 */
@Getter
@Setter
@Schema(description = "BOS관리주소변경이력 목록 객체")
public class AsmMngAddrChngHstListVo {

	/**
	 * CRM고객번호
	 */
	@Schema(description = "CRM고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String crmCustNo;

	/**
	 * 계약번호
	 */
	@Schema(description = "계약번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String cntrNo;

	/**
	 * 설비번호
	 */
	@Schema(description = "설비번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String eqpNo;

	/**
	 * 모바일번호
	 */
	@Schema(description = "모바일번호", example = "", hidden = false, required = true, nullable = false, maxLength = 24)
	@MaxByte(max = 24)
	private String mobNo;

	/**
	 * 전화번호
	 */
	@Schema(description = "전화번호", example = "", hidden = false, required = true, nullable = false, maxLength = 24)
	@MaxByte(max = 24)
	private String telNo;

	/**
	 * 고객상세주소
	 */
	@Schema(description = "고객상세주소", example = "", hidden = false, required = true, nullable = false, maxLength = 200)
	@MaxByte(max = 200)
	private String dtlAddr;

	/**
	 * 고객기본주소
	 */
	@Schema(description = "고객기본주소", example = "", hidden = false, required = true, nullable = false, maxLength = 200)
	@MaxByte(max = 200)
	private String bassAddr;

	/**
	 * 변경사유
	 */
	@Schema(description = "변경사유", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String chgRsn;

	/**
	 * 변경사유명
	 */
	@Schema(description = "변경사유명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String chgRsnNm;

	/**
	 * 변경사유상세
	 */
	@Schema(description = "변경사유상세", example = "", hidden = false, required = true, nullable = false, maxLength = 300)
	@MaxByte(max = 300)
	private String chgRsnDtl;

	/**
	 * 등록일자
	 */
	@Schema(description = "등록일자", example = "", hidden = false, required = true, nullable = false)
	@DateValue
	private String strRegDt;

	/**
	 * 수정자ID
	 */
	@Schema(description = "수정자ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String updUsrId;

	/**
	 * 수정일자
	 */
	@Schema(description = "수정일자", example = "", hidden = false, required = true, nullable = false)
	@DateValue
	private String strUpdDt;

	/**
	 * 고객요청내용
	 */
	@Schema(description = "고객요청내용", example = "", hidden = false, required = true, nullable = false, maxLength = 300)
	@MaxByte(max = 300)
	private String custReqCn;

}
