package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmGodsBasVo
 * @author 김성태
 * @date 2022. 6. 13.
 * @Version 1.0
 * @description CRM제품기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM채널기본 객체")
public class CrmChlBasVo extends ApiBaseVo {
	/**
	 * 채널번호
	 */
	@Schema(description = "채널번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String chlCd;
	/**
	 * 채널명
	 */
	@Schema(description = "채널명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String chlNm;

	@Schema(hidden = true)
	@Override
	public String getRegChlCd() {
		return super.getRegChlCd();
	}

}
