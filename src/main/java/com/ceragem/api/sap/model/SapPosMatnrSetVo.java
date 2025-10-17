package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosMatnrSetVo
 * @author user
 * @date 2022. 7. 1.
 * @Version 1.0
 * @description 상품 세트 마스터 객체 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 상품 세트 마스터 객체")
public class SapPosMatnrSetVo {

	@Schema(description = "생성일자로 조회", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@NotEmpty
	private String ersda;

}
