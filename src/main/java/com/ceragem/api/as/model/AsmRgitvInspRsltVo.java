package com.ceragem.api.as.model;

import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmRgitvInspRsltVo
 * @author 이윤성
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description BOS정기점검 처리 결과 정보조회 Vo
 */
@Getter
@Setter
@Schema(description = "BOS정기점검 처리 결과 정보조회 객체")
public class AsmRgitvInspRsltVo extends ApiBaseVo {

	/**
	 * 조회 건수
	 */
	@Schema(description = "조회 건수", example = "0", hidden = false, required = true, nullable = false)
	private int rtnCnt;

	/**
	 * 정기점검 처리 결과 목록
	 */
	@Schema(description = "정기점검 처리 결과 목록", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmRgitvInspRsltListVo> list = null;
}
