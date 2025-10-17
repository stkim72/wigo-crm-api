package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosCustomVo
 * @author user
 * @date 2022. 6. 27.
 * @Version 1.0
 * @description 매장 정보 조회 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "매장 정보 조회 객체")
public class SapPosCustomVo {

	@Schema(description = "생성일자로 조회", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@NotEmpty
	private String erdat;

}
