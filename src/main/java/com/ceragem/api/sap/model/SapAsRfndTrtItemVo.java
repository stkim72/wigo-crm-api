package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsRfndTrtItemVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP 유상매출 반제처리 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 유상매출 반제처리 item 객체")
public class SapAsRfndTrtItemVo {
	@Schema(description = "회사코드", example = "1000", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String bukrs;

	@Schema(description = "전표번호(선수금)", example = "1003230", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	private String belnr;

	@Schema(description = "회계연도(선수금)", example = "2021", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String gjahr;

	@Schema(description = "AS접수번호", example = "20210730001", hidden = false, required = false, nullable = true, maxLength = 35)
	private String bstkd;
}
