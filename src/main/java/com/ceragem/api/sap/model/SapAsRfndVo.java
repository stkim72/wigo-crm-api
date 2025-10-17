package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsRfndVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP AS 환불처리 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP AS 환불처리 객체")
public class SapAsRfndVo {
	@Schema(description = "AS접수번호", example = "", hidden = false, required = true, nullable = false, maxLength = 35)
	@NotEmpty
	private String bstkd;

	@Schema(description = "판매조직", example = "", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkorg;

	@Schema(description = "사업장", example = "", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkbur;

	@Schema(description = "영업그룹", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	private String vkgrp;

	@Schema(description = "환불일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String bstdk;

	@Schema(description = "카드결제여부", example = "1", hidden = false, required = true, nullable = false, maxLength = 1)
	@NotEmpty
	private String cardchk;

	@Schema(description = "현금결제여부", example = "1", hidden = false, required = true, nullable = false, maxLength = 1)
	@NotEmpty
	private String cashchk;

	@Schema(description = "세금계산서발급유무", example = "0", hidden = false, required = true, nullable = false, maxLength = 1)
	private String taxchk;

	@Schema(description = "카드결제금액(부가세포함)", example = "10000", hidden = false, required = false, nullable = true, maxLength = 13)
	private String cardDmbtr;

	@Schema(description = "현금결제금액(부가세포함)", example = "2000", hidden = false, required = false, nullable = true, maxLength = 13)
	private String cashDmbtr;

	@Schema(description = "사업자등록번호", example = "", hidden = false, required = false, nullable = true, maxLength = 11)
	private String stcd2;

	@Schema(description = "대표자명", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	private String j1kfrepre;

	@Schema(description = "사업유형", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	private String j1kftbus;

	@Schema(description = "업태", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	private String j1kftind;

	@Schema(description = "전자메일주소", example = "", hidden = false, required = false, nullable = true, maxLength = 241)
	private String email;
}
