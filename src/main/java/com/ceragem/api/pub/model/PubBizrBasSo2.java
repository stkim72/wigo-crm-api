package com.ceragem.api.pub.model;

import com.ceragem.api.base.model.ApiPagination;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName PubBusinessBasSo
 * @author user
 * @date 2023. 5. 7.
 * @Version 1.0
 * @description 공유사업자 기본정보 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "공유사업자 기본정보 검색 객체")
public class PubBizrBasSo2 extends ApiPagination {
	/**
	 * 아이디
	 */
	@Parameter(description = "공유사업자 계정", example = "", hidden = false, required = true)
	@Schema(description = "공유사업자 계정", example = "", hidden = false, required = false, nullable = false)
	private String id;

	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = false, required = false)
	@Schema(description = "통합고객번호", example = "", hidden = false, required = false, nullable = true)
	private String itgCustNo;

	/**
	 * 고객명
	 */
	@Parameter(description = "고객명", example = "", hidden = false, required = false)
	@Schema(description = "고객명", example = "", hidden = false, required = false, nullable = true)
	private String custNm;

	/**
	 * 휴대전화
	 */
	@Parameter(description = "고객 휴대전화", example = "", hidden = false, required = false)
	@Schema(description = "고객 휴대전화", example = "", hidden = false, required = false, nullable = true)
	private String mphonNo;

	/**
	 * 공유사업자 고유번호
	 */
	@Parameter(description = "공유사업자 고유번호", example = "", hidden = true, required = false)
	@Schema(description = "공유사업자 고유번호", example = "", hidden = true, required = false, nullable = true)
	private String pubBizrBasNo;

	/**
	 * 웰라운지 코드
	 */
	@Parameter(description = "웰라운지 코드", example = "", hidden = true, required = false)
	@Schema(description = "웰라운지 코드", example = "", hidden = true, required = false, nullable = true)
	private String wellloungeCd;

}
