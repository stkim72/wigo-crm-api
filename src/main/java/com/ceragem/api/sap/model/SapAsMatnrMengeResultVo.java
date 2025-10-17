package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsMatnrMengeResultVo
 * @author user
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description SAP 자재현재고 조회 결과 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 자재현재고 조회 결과 객체")
public class SapAsMatnrMengeResultVo {
	@Schema(description = "처리결과", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	private String msgty;

	@Schema(description = "오류시메세지ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	private String msgid;

	@Schema(description = "오류시메세지번호", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String msgno;

	@Schema(description = "오류시메세지", example = "", hidden = false, required = true, nullable = false, maxLength = 220)
	private String msgtx;

	@Schema(description = "본사재고(3000번창고)", example = "", hidden = false, required = true, nullable = false, maxLength = 13)
	private String menge1000;

	@Schema(description = "C&S현재고(3000번창고)", example = "", hidden = false, required = true, nullable = false, maxLength = 13)
	private String menge8000;

	@Schema(description = "단위", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String meins;
}
