package com.ceragem.api.as.model;

import com.ceragem.api.sap.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmSapPrecChitTrmVo
 * @author 이윤성
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP 응답전송 Vo
 */
@Getter
@Setter
@Schema(description = "SAP 응답전송 객체")
public class AsmSapResultVo {

	/**
	 * 처리결과
	 */
	@Schema(description = "처리결과", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@MaxByte(max = 1)
	private String msgty;

	/**
	 * 오류시메세지번호
	 */
	@Schema(description = "오류시메세지번호", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	@MaxByte(max = 3)
	private String msgno;

	/**
	 * 오류시메세지
	 */
	@Schema(description = "오류시메세지", example = "", hidden = false, required = true, nullable = false, maxLength = 200)
	@MaxByte(max = 200)
	private String msgtx;
}
