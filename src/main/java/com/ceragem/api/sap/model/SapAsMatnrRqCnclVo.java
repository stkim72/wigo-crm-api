package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsMatnrRqCnclVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP AS자재요청 취소
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP AS자재요청 취소 객체")
public class SapAsMatnrRqCnclVo {
	@Schema(description = "자재요청번호", example = "", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String intime;
}
