package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsGrGiTrtCnclResultVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP 입/출고 취소 결과
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 입/출고 취소 결과 객체")
public class SapAsGrGiTrtCnclResultVo {
	@Schema(description = "처리결과", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	private String msgty;

	@Schema(description = "오류시메세지ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	private String msgid;

	@Schema(description = "오류시메세지번호", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String msgno;

	@Schema(description = "오류시메세지", example = "", hidden = false, required = true, nullable = false, maxLength = 220)
	private String msgtx;
}
