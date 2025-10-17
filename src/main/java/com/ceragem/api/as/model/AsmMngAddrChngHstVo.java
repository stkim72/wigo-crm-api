package com.ceragem.api.as.model;

import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmMngAddrChngHstVo
 * @author 이윤성
 * @date 2022. 6. 23.
 * @Version 1.0
 * @description BOS관리주소변경이력 조회 Vo
 */
@Getter
@Setter
@Schema(description = "BOS관리주소변경이력 조회 객체")
public class AsmMngAddrChngHstVo extends ApiBaseVo {

	/**
	 * 조회건수
	 */
	@Schema(description = "조회건수", example = "0", hidden = false, required = true, nullable = false)
	private int rtnCnt;

	/**
	 * 관리주소변경이력목록
	 */
	@Schema(description = "관리주소변경이력목록", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmMngAddrChngHstListVo> list = null;
}
