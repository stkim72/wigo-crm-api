package com.ceragem.api.as.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmCrmCustResultVo
 * @author 이윤성
 * @date 2022. 6. 7.
 * @Version 1.0
 * @description CRM 고객정보수신 저장결과 Vo
 */
@Getter
@Setter
@Schema(description = "CRM 고객정보수신 저장결과 객체")
public class AsmCrmCustResultVo extends ApiBaseVo {

	/**
	 * AS접수번호
	 */
	@Schema(description = "AS접수번호", example = "001002", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String asSubmitNo;

	/**
	 * AS접수 바로가기링크
	 */
	@Schema(description = "AS접수바로가기링크", example = "", hidden = false, required = true, nullable = false)
	@NotEmpty
	private String directUrl;
}
