package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "CRM멤버십쿠폰이력 검색 객체")
public class CrmMshipStmpIssueSo extends ApiPagination {
	/**
	 * 매장코드
	 */
	@Parameter(description = "매장코드", example = "", hidden = false, required = false)
	private String storNo;
	/**
	 * 통합회원아이디
	 */
	@Parameter(description = "통합회원아이디", example = "", hidden = false, required = true)
	private String itgCustNo;
	
	@Parameter(description = "사용가능여부[Y : 사용가능, N : 사용불가 유효기간 지남]", example = "", hidden = false, required = false)
	@YnValue
	private String availableYn;

}
