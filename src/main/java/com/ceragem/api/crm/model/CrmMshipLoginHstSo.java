package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipLoginHstSo
 * @author 김성태
 * @date 2023. 3. 31.
 * @Version 1.0
 * @description CRM사용자로그인이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM사용자로그인이력 검색 객체")
public class CrmMshipLoginHstSo extends ApiPagination {
	/**
	 * 로그인이력ID
	 */
	@Parameter(description = "로그인이력ID", example = "", hidden = true, required = false)
	@Schema(description = "로그인이력ID", example = "", hidden = true, required = false, nullable = true)
	private String loginHstId;
	/**
	 * 사용자코드
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = true, required = false)
	@Schema(description = "통합고객번호", example = "", hidden = true, required = false, nullable = true)
	private String itgCustNo;
	/**
	 * 로그인일시
	 */
	@Parameter(description = "로그인일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	@Schema(description = "로그인일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false, nullable = true)
	private String loginDt;
	/**
	 * 로그인URL
	 */
	@Parameter(description = "로그인IP주소", example = "", hidden = true, required = false)
	@Schema(description = "로그인IP주소", example = "", hidden = true, required = false, nullable = true)
	private String loginIpAddr;
	/**
	 * 채널코드
	 */
	@Parameter(description = "채널코드", example = "", hidden = true, required = false)
	@Schema(description = "채널코드", example = "", hidden = true, required = false, nullable = true)
	private String chlCd;
}
