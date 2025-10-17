package com.ceragem.api.as.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmSapRfndTrtTrmListVo
 * @author 이윤성
 * @date 2022. 6. 27.
 * @Version 1.0
 * @description 유상매출 반제처리 결과 수신 Vo (SAP매출반제 처리 프로그램에서 반제처리시 AS시스템으로 처리 결과 전송)
 *
 */
@Getter
@Setter
@Schema(description = "유상매출 반제처리 결과 수신 객체")
public class AsmSapRfndTrtTrmListVo {

	/**
	 * 반제관리번호(AS시스템에서 관리하는 번호)
	 */
	@Schema(description = "반제관리번호", example = "", hidden = false, required = true, nullable = false)
	private String rfndadmno;

	/**
	 * 관리번호순번
	 */
	@Schema(description = "관리번호순번", example = "", hidden = false, required = true, nullable = false)
	private String seq;

	/**
	 * 대금유형
	 */
	@Schema(description = "대금유형", example = "", hidden = false, required = true, nullable = false)
	private String paytype;

	/**
	 * 반제처리구분(X : 반제처리됨, 공란 : 미처리)
	 */
	@Schema(description = "반제처리구분", example = "", hidden = false, required = false, nullable = false)
	private String rfndtrtdiv;

	/**
	 * 반제처리결과
	 */
	@Schema(description = "반제처리결과", example = "", hidden = false, required = false, nullable = false)
	private String result;

	/**
	 * 오류메시지
	 */
	@Schema(description = "오류메시지", example = "", hidden = false, required = false, nullable = false)
	private String message;
}
