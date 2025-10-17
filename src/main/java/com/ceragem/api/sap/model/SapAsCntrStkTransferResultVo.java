package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsCntrStkTransferResultVo
 * @author user
 * @date 2022. 8. 29.
 * @Version 1.0
 * @description SAP 센터간재고이전 결과 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 센터간재고이전 결과 객체")
public class SapAsCntrStkTransferResultVo {
	@Schema(description = "처리결과", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	private String msgty;

	@Schema(description = "오류시메세지ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	private String msgid;

	@Schema(description = "오류시메세지번호", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String msgno;

	@Schema(description = "오류시메세지", example = "", hidden = false, required = true, nullable = false, maxLength = 220)
	private String msgtx;

	@Schema(description = "자재전표번호", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	private String mblnr;

	@Schema(description = "자재전표년도", example = "", hidden = false, required = false, nullable = true, maxLength = 4)
	private String mjahr;
}
