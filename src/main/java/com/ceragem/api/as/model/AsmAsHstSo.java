package com.ceragem.api.as.model;

import com.ceragem.api.base.model.ApiPagination;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmAsHstSo
 * @author 이윤성
 * @date 2022. 5. 20.
 * @Version 1.0
 * @description AS이력 So
 */
@Getter
@Setter
@Schema(description = "AS이력 검색 객체")
public class AsmAsHstSo extends ApiPagination {

	/**
	 * 이력일련번호(AS상세조회)
	 */
	@Schema(description = "이력일련번호", example = "1", hidden = true, required = false, nullable = true)
	private String hstSeq;

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "857545", hidden = false, required = true, nullable = false)
	private String itgCustNo;

	/**
	 * AS접수기간 시작일자
	 */
	@Schema(description = "시작접수일자", example = "20220101", hidden = false, required = false, nullable = true)
	private String staSubmitDate;

	/**
	 * AS접수기간 종료일자
	 */
	@Schema(description = "종료접수일자", example = "20220101", hidden = false, required = false, nullable = true)
	private String endSubmitDate;

	/**
	 * AS완료기간 시작일자
	 */
	@Schema(description = "시작완료일자", example = "20220101", hidden = false, required = false, nullable = true)
	private String staCmptDate;

	/**
	 * AS완료기간 종료일자
	 */
	@Schema(description = "종료완료일자", example = "20220101", hidden = false, required = false, nullable = true)
	private String endCmptDate;

	/**
	 * 조치내용
	 */
	@Schema(description = "조치내용", example = "기타", hidden = true, required = false, nullable = true)
	private String actnCtnts;

}
