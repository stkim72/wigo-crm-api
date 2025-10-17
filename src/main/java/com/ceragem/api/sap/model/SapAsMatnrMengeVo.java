package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsMatnrMengeVo
 * @author user
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description SAP 자재현재고 조회 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 자재현재고 조회 객체")
public class SapAsMatnrMengeVo {
	@Schema(description = "자재코드", example = "100323", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String matnr;

	@Schema(description = "저장위치", example = "", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String lgort;
}
