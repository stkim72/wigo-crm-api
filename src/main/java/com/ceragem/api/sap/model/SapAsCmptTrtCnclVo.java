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
 * @description SAP AS 완료취소 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP AS 완료취소 객체")
public class SapAsCmptTrtCnclVo {
	@Schema(description = "AS접수번호", example = "20220613001", hidden = false, required = true, nullable = false, maxLength = 35)
	@NotEmpty
	private String bstkd;
}
