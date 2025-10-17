package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsMatnrRqItemVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP AS 자재요청 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP AS 자재요청 item 객체")
public class SapAsMatnrRqItemVo {
	@Schema(description = "자재코드", example = "100323", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String matnr;

	@Schema(description = "요청수량", example = "5", hidden = false, required = true, nullable = false, maxLength = 13)
	@NotEmpty
	private String rqMenge;

	@Schema(description = "접수수량", example = "4", hidden = false, required = true, nullable = false, maxLength = 13)
	@NotEmpty
	private String acMenge;

	@Schema(description = "단위", example = "EA", hidden = false, required = false, nullable = true, maxLength = 3)
	private String meins;
}
