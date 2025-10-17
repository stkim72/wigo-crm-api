package com.ceragem.api.as.model;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmWebAppApiVo
 * @author 이윤성
 * @date 2022. 6. 15.
 * @Version 1.0
 * @description AS네이티브앱 WebApp API VO
 */
@Getter
@Setter
@Schema(description = "AS네이티브앱 WebApp API 객체")
public class AsmWebAppApiVo extends ApiBaseVo {

	/**
	 * 네이티브앱 버전(Ver.)
	 */
	@Schema(description = "네이티브앱버전(Ver.)", example = "", hidden = false, required = true, nullable = false)
	private String comnCd;

	/**
	 * 네이티브앱 버전명
	 */
	@Schema(description = "네이티브앱버전명", example = "", hidden = false, required = true, nullable = false)
	private String comnCdNm;
}
