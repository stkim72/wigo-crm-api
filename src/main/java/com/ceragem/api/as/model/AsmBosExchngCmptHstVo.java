package com.ceragem.api.as.model;

import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmBosExchngCmptHstVo
 * @author 이윤성
 * @date 2022. 6. 10.
 * @Version 1.0
 * @description BOS교환완료 이력조회 Vo
 */
@Getter
@Setter
@Schema(description = "BOS교환완료 이력조회 객체")
public class AsmBosExchngCmptHstVo extends ApiBaseVo {

	/**
	 * 조회 건수
	 */
	@Schema(description = "조회 건수", example = "0", hidden = false, required = true, nullable = false)
	private int rtnCnt;

	/**
	 * 교환완료 이력 목록
	 */
	@Schema(description = "교환완료 이력 목록", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmBosExchngCmptHstListVo> list = null;
}
