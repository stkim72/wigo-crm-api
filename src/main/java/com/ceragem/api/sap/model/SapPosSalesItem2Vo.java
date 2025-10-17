package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosSalesItem2Vo
 * @author user
 * @date 2022. 6. 27.
 * @Version 1.0
 * @description POS 매출 전송(일별/품목별) item2 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "POS 매출 전송(일별/품목별) item2 객체")
public class SapPosSalesItem2Vo {

	@Schema(description = "직영점 코드(SAP 고객코드)", example = "140841", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String kunnr;

	@Schema(description = "POS 매출일자", example = "20220501", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String bstdk;

	@Schema(description = "POS 번호", example = "pos001", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	private String posNo;

	@Schema(description = "POS 매출번호", example = "POS001-2022050101", hidden = false, required = true, nullable = false, maxLength = 35)
	@NotEmpty
	private String bstkd;

	@Schema(description = "POS 매출번호의 아이템 순번", example = "002", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	private String ztseq;

	@Schema(description = "판매 상품코드", example = "P00001", hidden = false, required = false, nullable = true, maxLength = 18)
	private String pmatnr;

	@Schema(description = "판매 상품명", example = "아메리카노", hidden = false, required = false, nullable = true, maxLength = 40)
	private String pmaktx;

	@Schema(description = "판매 상품분류", example = "음료", hidden = false, required = false, nullable = true, maxLength = 30)
	private String pcate;

	@Schema(description = "판매 상품분류코드", example = "커피", hidden = false, required = false, nullable = true, maxLength = 20)
	private String pcater;

	@Schema(description = "판매 수량", example = "1", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String kwmeng;

	@Schema(description = "판매 단위", example = "EA", hidden = false, required = false, nullable = true, maxLength = 3)
	private String meins;

	@Schema(description = "판매 단가", example = "1100", hidden = false, required = false, nullable = true, maxLength = 11)
	private String netpr;

	@Schema(description = "판매 금액", example = "1100", hidden = false, required = false, nullable = true, maxLength = 13)
	private String netwr;

	@Schema(description = "할인 금액", example = "0", hidden = false, required = false, nullable = true, maxLength = 11)
	private String netwrDc;

	@Schema(description = "과세 or 면세", example = "VB", hidden = false, required = false, nullable = true, maxLength = 2)
	private String mwskz;

	@Schema(description = "무상 구분", example = "", hidden = false, required = false, nullable = true, maxLength = 1)
	private String zfreeGb;

	@Schema(description = "할인 구분", example = "", hidden = false, required = false, nullable = true, maxLength = 1)
	private String zdcGb;

	@Schema(description = "전송 일자", example = "20220627", hidden = false, required = false, nullable = true, maxLength = 8)
	private String ifdat;
}
