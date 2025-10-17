package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPntUserSetItemVo
 * @author 이승빈
 * @date 2022. 6. 22.
 * @Version 1.0
 * @description SAP PNT 포인트 사용 완료 처리
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP PNT 포인트 사용 완료 처리 item 객체")
public class SapPntUserSetItemVo {

	@Schema(description = "거래일시", example = "20210731", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String zrtDt;

	@Schema(description = "설치완료일", example = "20210731", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String suReqDt;

	@Schema(description = "거래번호", example = "20220613003", hidden = false, required = true, nullable = false, maxLength = 35)
	@NotEmpty
	private String bstkd;

	@Schema(description = "거래처코드", example = "111", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	private String kunnr;

	@Schema(description = "거래처명", example = "test", hidden = false, required = false, nullable = true, maxLength = 255)
	private String kunnrNm;

	@Schema(description = "고객 그룹", example = "13", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String kdgrp;

	@Schema(description = "통합고객번호", example = "111", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	private String custNoWrms;

	@Schema(description = "할인 구분", example = "1", hidden = false, required = true, nullable = false, maxLength = 1)
	@NotEmpty
	private String saleGb;

	@Schema(description = "포인트", example = "100", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String pntPay;

}
