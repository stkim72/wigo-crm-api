package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsGrGiTrtItemVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP 입/출고처리 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 입/출고처리 item 객체")
public class SapAsGrGiTrtItemVo {
	@Schema(description = "코스트센터", example = "8002004", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	private String kostl;

	@Schema(description = "플랜트", example = "8000", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String werks;

	@Schema(description = "저장위치", example = "3000", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String lgort;

	@Schema(description = "자재코드번호", example = "100323", hidden = false, required = true, nullable = false, maxLength = 18)
	private String matnr;

	@Schema(description = "수량", example = "1.00", hidden = false, required = true, nullable = false, maxLength = 13)
	@NotEmpty
	private String menge;

	@Schema(description = "단위", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String meins;
}
