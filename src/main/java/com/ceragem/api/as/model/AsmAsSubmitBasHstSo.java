package com.ceragem.api.as.model;

import com.ceragem.api.base.model.ApiPagination;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmAsSubmitBasHstSo
 * @author 이윤성
 * @date 2022. 5. 25.
 * @Version 1.0
 * @description A/S마스터이력 So
 */
@Getter
@Setter
@Schema(description = "A/S마스터이력 검색 객체")
public class AsmAsSubmitBasHstSo extends ApiPagination {

	/**
	 * 이력일련번호
	 */
	@Schema(description = "HST_SEQ", example = "1", hidden = false, required = false, nullable = true)
	private String hstSeq;

	/**
	 * AS접수번호
	 */
	@Schema(description = "AS접수번호", example = "330100", hidden = false, required = false, nullable = true)
	private String asSubmitNo;

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "857545", hidden = false, required = false, nullable = true)
	private String itgCustNo;
}
