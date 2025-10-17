package com.ceragem.api.as.model;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmAsSubmitBasHstCountVo
 * @author 이윤성
 * @date 2022. 6. 15.
 * @Version 1.0
 * @description AS이력 건수(총건수, 취소건수) VO
 */
@Getter
@Setter
@Schema(description = "AS이력 건수(총건수, 취소건수) 객체")
public class AsmAsSubmitBasHstCountVo extends ApiBaseVo {

	/**
	 * AS총건수
	 */
	@Schema(description = "총건수", example = "", hidden = false, required = true, nullable = false)
	private String totalCnt;

	/**
	 * AS취소건수
	 */
	@Schema(description = "취소건수", example = "", hidden = false, required = true, nullable = false)
	private String cancelCnt;
}
