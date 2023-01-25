package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import javax.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

import com.ceragem.api.crm.validate.MaxByte;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmSnstvInfoInqryHstVo
 * @author 김성태
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM민감정보조회이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM민감정보조회이력 객체")
public class CrmSnstvInfoInqryHstVo extends ApiBaseVo {
	/**
	 * 정보조회이력일련번호
	 */
	@Schema(description = "정보조회이력일련번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String infoInqryHstSeq;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 개인정보취급자번호
	 */
	@Schema(description = "개인정보취급자번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String indiInfoHandlPrsnNo;
	/**
	 * 접속자IP주소
	 */
	@Schema(description = "접속자IP주소", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String connPrsnIpAddr;
	/**
	 * 수행업무코드
	 */
	@Schema(description = "수행업무코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
	@MaxByte(max = 3)
	private String pfmWorkCd;
	/**
	 * 등록채널코드
	 */
	@Schema(description = "등록채널코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String regChlCd;

	@Schema(description = "강제복호화", example = "", hidden = true)
	private boolean forceDecrypt = false;

	@Schema(description = "조회수", example = "", hidden = true)
	private Integer inqryCnt;
	@Schema(description = "다운로드사유", example = "", hidden = true)
	private String dnldTxn;

	@Schema(description = "조회내역", example = "", hidden = true)
	private String inqryTxn;

	@Schema(description = "목록조회", example = "", hidden = true)
	private boolean listMode = false;

}
