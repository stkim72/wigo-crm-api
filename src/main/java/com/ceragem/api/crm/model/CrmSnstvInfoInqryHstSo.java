package com.ceragem.api.crm.model;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmSnstvInfoInqryHstSo
 * @author 김성태
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM민감정보조회이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM민감정보조회이력 검색 객체")
public class CrmSnstvInfoInqryHstSo extends CrmSnstvInfoInqrySo {
	/**
	 * 정보조회이력일련번호
	 */
	@Parameter(description = "정보조회이력일련번호", example = "", hidden = true, required = false)
	private String infoInqryHstSeq;
	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = true, required = false)
	private String itgCustNo;

	/**
	 * 등록채널코드
	 */
	@Parameter(description = "등록채널코드", example = "", hidden = true, required = false)
	private String regChlCd;
}
