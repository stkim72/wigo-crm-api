package com.ceragem.api.com.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCustBosCntrtHstSo
 * @author 김성태
 * @date 2022. 10. 26.
 * @Version 1.0
 * @description CRMBOS계약이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustBosCancelCountSo {
	@Parameter(description = "취소일-검색시작일", example = "", hidden = false, required = true)
	@NotEmpty
	private String fromCancelYmd;

	@Parameter(description = "취소일-검색종료일", example = "", hidden = false, required = true)
	@NotEmpty
	private String toCancelYmd;
}
