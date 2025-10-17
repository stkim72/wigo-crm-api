package com.ceragem.api.sap.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsCmptTrtVo
 * @author user
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description SAP AS 완료처리 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP AS 완료처리 객체")
public class SapAsCmptTrtVo {
	@Schema(description = "AS접수번호", example = "20220613001", hidden = false, required = true, nullable = false, maxLength = 35)
	@NotEmpty
	private String bstkd;

	@Schema(description = "판매조직", example = "8000", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkorg;

	@Schema(description = "사업장", example = "8010", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkbur;

	@Schema(description = "영업그룹", example = "800", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	private String vkgrp;

	@Schema(description = "AS처리완료일", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String bstdk;

	@Schema(description = "오더사유(거래사유)", example = "S02", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	private String augru;

	@Schema(description = "고객명", example = "고객명", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	private String cname;

	@Schema(description = "전화번호", example = "0415294259", hidden = false, required = false, nullable = true, maxLength = 20)
	private String telno;

	@Schema(description = "휴대폰번호", example = "01020127913", hidden = false, required = false, nullable = true, maxLength = 20)
	private String cellno;

	@Schema(description = "우편번호", example = "", hidden = false, required = false, nullable = true, maxLength = 7)
	private String zipcode;

	@Schema(description = "주소", example = "", hidden = false, required = false, nullable = true, maxLength = 255)
	private String addr1;

	@Schema(description = "상세주소", example = "", hidden = false, required = false, nullable = true, maxLength = 255)
	private String addr2;

	@Schema(description = "카드결제여부", example = "1", hidden = false, required = true, nullable = false, maxLength = 1)
	@NotEmpty
	private String cardchk;

	@Schema(description = "현금결제여부", example = "1", hidden = false, required = true, nullable = false, maxLength = 1)
	@NotEmpty
	private String cashchk;

	@Schema(description = "세금계산서발급유무", example = "0", hidden = false, required = false, nullable = true, maxLength = 1)
	private String taxchk;

	@Schema(description = "카드결제금액(부가세포함)", example = "10000", hidden = false, required = false, nullable = true, maxLength = 13)
	private String cardDmbtr;

	@Schema(description = "현금결제금액(부가세포함)", example = "2000", hidden = false, required = false, nullable = true, maxLength = 13)
	private String cashDmbtr;

	@Schema(description = "할인금액", example = "0", hidden = false, required = false, nullable = true, maxLength = 13)
	private String discount;

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

	@Schema(description = "AS완료처리 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapAsCmptTrtItemVo> items = null;
}
