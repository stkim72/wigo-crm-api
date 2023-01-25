package com.ceragem.api.crm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmComnCdBasVo
 * @author 김성태
 * @date 2022. 4. 8.
 * @Version 1.0
 * @description 공통코드 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "공통코드 객체")
public class CrmCommonCodeVo {
	/**
	 * 공통코드
	 */
	@Schema(description = "대분류코드", example = "", hidden = false, required = true, nullable = false)
	private String largeCd;
	/**
	 * 공통코드
	 */
	@Schema(description = "대분류명", example = "", hidden = false, required = true, nullable = false)
	private String largeNm;

	@Schema(description = "대분류사용여부", example = "", hidden = false, required = true, nullable = false)
	private String largeUseYn;

	/**
	 * 공통코드
	 */
	@Schema(description = "소분류코드", example = "", hidden = false, required = true, nullable = false)
	private String smallCd;
	/**
	 * 공통코드
	 */
	@Schema(description = "소분류명", example = "", hidden = false, required = true, nullable = false)
	private String smallNm;

	@Schema(description = "소분류사용여부", example = "", hidden = false, required = true, nullable = false)
	private String smallUseYn;
}
