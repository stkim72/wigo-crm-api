package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsCmptTrtVo
 * @author user
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description SAP AS 완료처리 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP AS 완료처리 item 객체")
public class SapAsCmptTrtItemVo {
	@Schema(description = "품목순번", example = "1", hidden = false, required = true, nullable = false)
	@NotEmpty
	private String seqNr;

	@Schema(description = "자재번호", example = "100323", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String matnr;

	@Schema(description = "수량", example = "2", hidden = false, required = true, nullable = false, maxLength = 13)
	@NotEmpty
	private String mqty;

	@Schema(description = "가격(부가세포함)", example = "10000", hidden = false, required = false, nullable = true, maxLength = 13)
	private String price;

	@Schema(description = "저장위치", example = "", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String lgort;

	@Schema(description = "영업 문서 품목 범주", example = "ZTAN", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String pstyv;
}
