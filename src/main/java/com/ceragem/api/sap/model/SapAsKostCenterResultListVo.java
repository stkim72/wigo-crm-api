package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsKostCenterResultListVo
 * @author user
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description SAP 코스트센터 조회 결과 리스트 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 코스트센터 결과 리스트 객체")
public class SapAsKostCenterResultListVo {
	@Schema(description = "코스트센터", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	private String kostl;

	@Schema(description = "코스트센터명", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	private String ktext;
}