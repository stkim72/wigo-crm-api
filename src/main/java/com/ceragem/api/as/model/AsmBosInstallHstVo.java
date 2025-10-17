package com.ceragem.api.as.model;

import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmBosInstallHstVo
 * @author 이윤성
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description BOS설치이력 목록조회 Vo
 */
@Getter
@Setter
@Schema(description = "BOS설치이력 목록조회 객체")
public class AsmBosInstallHstVo extends ApiBaseVo {

	/**
	 * 조회 건수
	 */
	@Schema(description = "조회 건수", example = "0", hidden = false, required = true, nullable = false)
	private int rtnCnt;

	/**
	 * 설치이력(신규설치) 목록
	 */
	@Schema(description = "설치이력(신규설치) 목록", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmBosInstallHst01ListVo> list01 = null;

	/**
	 * 설치이력(제품교환) 목록
	 */
	@Schema(description = "설치이력(제품교환) 목록", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmBosInstallHst02ListVo> list02 = null;

	/**
	 * 설치이력(반환) 목록
	 */
	@Schema(description = "설치이력(반환) 목록", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmBosInstallHst03ListVo> list03 = null;

	/**
	 * 설치이력(Merge) 목록
	 */
	@Schema(description = "설치이력(Merge) 목록", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmBosInstallHstListVo> list = null;
}
