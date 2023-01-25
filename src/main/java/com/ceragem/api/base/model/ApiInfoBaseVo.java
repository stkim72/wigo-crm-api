package com.ceragem.api.base.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiInfoBaseVo extends ApiBaseVo {
	/**
	 * <p>
	 * API코드
	 * </p>
	 */
	private String apiCd;
	/**
	 * <p>
	 * 시스템코드
	 * </p>
	 */
	private String sysCd;
	/**
	 * <p>
	 * APIURL
	 * </p>
	 */
	private String apiUrl;

	/*
	 * API명
	 * */
	private String apiNm;
	/**
	 * <p>
	 * 호출메쏘드코드
	 * </p>
	 */
	private String callMthdCd;
	/**
	 * <p>
	 * API권한여부
	 * </p>
	 */
	private String apiAuthYn;
	/**
	 * <p>
	 * 사용여부
	 * </p>
	 */
	private String useYn;
}
