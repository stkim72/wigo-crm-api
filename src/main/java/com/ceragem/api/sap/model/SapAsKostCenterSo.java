package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiPagination;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsKostCenterSo {
 * @author user
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description SAP 코스트센터 SO
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 코스트센터 검색 객체")
public class SapAsKostCenterSo extends ApiPagination {
	@Schema(description = "회사코드", example = "1000", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String bukrs;
}