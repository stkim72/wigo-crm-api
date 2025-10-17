package com.ceragem.api.com.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiPagination;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmBosRtnTxnSo
 * @author 김성태
 * @date 2023. 6. 14.
 * @Version 1.0
 * @description CRMBOS반환내역 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmBosRtnTxnSo extends ApiPagination {

	@Parameter(description = "검색시작일", example = "", hidden = false, required = true)
	@NotEmpty
	private String fromYmd;

	@Parameter(description = "검색종료일", example = "", hidden = false, required = true)
	@NotEmpty
	private String toYmd;

}
