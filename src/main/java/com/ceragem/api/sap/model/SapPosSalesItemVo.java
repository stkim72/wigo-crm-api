package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosSalesItemVo
 * @author user
 * @date 2022. 6. 27.
 * @Version 1.0
 * @description POS 매출 전송(일별/품목별) item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "POS 매출 전송(일별/품목별) item 객체")
public class SapPosSalesItemVo {

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

	@Schema(description = "정상/환불 구분", example = "01", hidden = false, required = false, nullable = true, maxLength = 2)
	private String zsoGb;

	@Schema(description = "결제 방식", example = "10", hidden = false, required = false, nullable = true, maxLength = 2)
	private String zpayMethod;

	@Schema(description = "총 판매 수량", example = "1", hidden = false, required = false, nullable = true, maxLength = 15)
	private String tkwmeng;

	@Schema(description = "총 판매 금액", example = "1100", hidden = false, required = false, nullable = true, maxLength = 13)
	private String tnetwr;

	@Schema(description = "총 할인 금액", example = "0", hidden = false, required = false, nullable = true, maxLength = 13)
	private String tnetwrDc;

	@Schema(description = "현금 공급가액", example = "0", hidden = false, required = false, nullable = true, maxLength = 13)
	private String zcashSupply;

	@Schema(description = "현금 부가세", example = "0", hidden = false, required = false, nullable = true, maxLength = 15)
	private String zcashVat;

	@Schema(description = "카드 공급가액", example = "1100", hidden = false, required = false, nullable = true, maxLength = 13)
	private String zcardSupply;

	@Schema(description = "카드 부가세", example = "100", hidden = false, required = false, nullable = true, maxLength = 15)
	private String zcardVat;

	@Schema(description = "모바일 상품권 공급가액", example = "0", hidden = false, required = false, nullable = true, maxLength = 13)
	private String zmoSupply;

	@Schema(description = "모바일 상품권 부가세", example = "0", hidden = false, required = false, nullable = true, maxLength = 15)
	private String zmoVat;

	@Schema(description = "멤버십 포인트 공급가액", example = "0", hidden = false, required = false, nullable = true, maxLength = 13)
	private String zpintSupply;

	@Schema(description = "공급가액", example = "1100", hidden = false, required = false, nullable = true, maxLength = 13)
	private String tsupply;

	@Schema(description = "부가세", example = "100", hidden = false, required = false, nullable = true, maxLength = 15)
	private String tvat;

	@Schema(description = "POS 원매출번호", example = "", hidden = false, required = false, nullable = true, maxLength = 35)
	private String bstkdOrg;

	@Schema(description = "전송일자", example = "20220627", hidden = false, required = false, nullable = true, maxLength = 8)
	private String ifdat;

}
