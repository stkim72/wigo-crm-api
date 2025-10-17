package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsKostCenterResultVo
 * @author user
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description SAP 코스트센터 조회 결과 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 코스트센터 결과 객체")
public class SapAsKostCenterResultVo {
	@Schema(description = "처리결과", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	private String msgty;

	@Schema(description = "오류시메세지ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	private String msgid;

	@Schema(description = "오류시메세지번호", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String msgno;

	@Schema(description = "오류시메세지", example = "", hidden = false, required = true, nullable = false, maxLength = 220)
	private String msgtx;

	@Schema(description = "코스트센터 리스트", example = "[]", hidden = false, required = true, nullable = false)
	private List<SapAsKostCenterResultListVo> results = null;
}