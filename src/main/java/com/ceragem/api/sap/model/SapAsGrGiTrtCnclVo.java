package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsGrGiTrtCnclVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP 입/출고 취소
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 입/출고 취소 객체")
public class SapAsGrGiTrtCnclVo {
	@Schema(description = "기타입출고IF키", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	private String ifkey;
}
