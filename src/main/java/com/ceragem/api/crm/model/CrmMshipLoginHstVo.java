package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipLoginHstVo
 * @author 김성태
 * @date 2023. 3. 31.
 * @Version 1.0
 * @description CRM사용자로그인이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM사용자로그인이력 객체")
public class CrmMshipLoginHstVo extends ApiBaseVo {
	/**
	 * 로그인이력ID
	 */
	@Schema(description = "로그인이력ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String loginHstId;
	/**
	 * 사용자코드
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String itgCustNo;
	/**
	 * 로그인일시
	 */
	@Schema(description = "로그인일시 (YYYYMMDDHH24MISS)", example = "20230331093950", hidden = false, required = true, nullable = false)
	@NotEmpty
	@DatetimeValue
	private String loginDt;
	/**
	 * 로그인URL
	 */
	@Schema(description = "로그인IP주소", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String loginIpAddr;
	/**
	 * 채널코드
	 */
	@Schema(description = "채널코드", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String chlCd;
}
