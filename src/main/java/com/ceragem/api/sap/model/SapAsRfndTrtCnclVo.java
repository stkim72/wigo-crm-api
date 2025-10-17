package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsRfndTrtCnclVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP 유상매출 반제취소 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 유상매출 반제취소 객체")
public class SapAsRfndTrtCnclVo {
	@Schema(description = "반제관리번호", example = "", hidden = false, required = true, nullable = false, maxLength = 11)
	@NotEmpty
	private String rfndadmno;

	@Schema(description = "대금유형", example = "", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String paytype;
}
