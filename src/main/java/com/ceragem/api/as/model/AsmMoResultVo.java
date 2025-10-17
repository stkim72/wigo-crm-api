package com.ceragem.api.as.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmMoResultVo
 * @author 이윤성
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description MO서비스 정보수신결과 Vo
 */
@Getter
@Setter
@Schema(description = "MO서비스 정보수신결과 객체")
public class AsmMoResultVo {

	/**
	 * 처리결과내용
	 */
	@Schema(description = "처리결과내용", example = "success", hidden = false, required = true, nullable = false)
	private String trtRsltCtnts;
}
