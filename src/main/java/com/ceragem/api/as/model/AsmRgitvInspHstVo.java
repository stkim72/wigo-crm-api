package com.ceragem.api.as.model;

import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmRgitvInspHstVo
 * @author 이윤성
 * @date 2022. 6. 17.
 * @Version 1.0
 * @description BOS정기점검 방문 이력 조회 Vo
 */
@Getter
@Setter
@Schema(description = "BOS정기점검 방문 이력 조회 객체")
public class AsmRgitvInspHstVo extends ApiBaseVo {

	/**
	 * 조회건수
	 */
	@Schema(description = "조회건수", example = "0", hidden = false, required = true, nullable = false)
	private int rtnCnt;

	/**
	 * 정기점검방문이력목록
	 */
	@Schema(description = "정기점검방문이력목록", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmRgitvInspHstListVo> list = null;
}
