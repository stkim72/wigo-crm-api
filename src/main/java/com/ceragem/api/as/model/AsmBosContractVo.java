package com.ceragem.api.as.model;

import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmBosContractVo
 * @author 이윤성
 * @date 2022. 5. 30.
 * @Version 1.0
 * @description BOS계약내역 목록조회 Vo
 */
@Getter
@Setter
@Schema(description = "BOS계약내역 목록조회 객체")
public class AsmBosContractVo extends ApiBaseVo {

	/**
	 * 조회 건수
	 */
	@Schema(description = "조회 건수", example = "0", hidden = false, required = true, nullable = false)
	private int rtnCnt;

	/**
	 * 계약내역 목록
	 */
	@Schema(description = "계약내역 목록", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmBosContractListVo> list = null;
}
