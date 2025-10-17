package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapMaProcessItemVo
 * @author 이승빈
 * @date 2022. 6. 22.
 * @Version 1.0
 * @description SAP 마일리지 통합 완료 처리 내역 수신 ITEM Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 마일리지 통합 완료 처리 내역 수신 item 객체")
public class SapMaProcessItemVo {

	@Schema(description = "전기일", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String zrtDt;

	@Schema(description = "마일리지 키", example = "202207011408101", hidden = false, required = false, nullable = true, maxLength = 15)
	private String maKey;

	@Schema(description = "마일리지 구분", example = "01", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String maGb;

	@Schema(description = "거래처코드", example = "327012", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	private String kunnr;

	@Schema(description = "마일리지 금액", example = "110000", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String maPay;

	@Schema(description = "수수료 금액", example = "0", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String maPaycom;

	@Schema(description = "부가세 금액", example = "10000", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String maAdd;

	@Schema(description = "미수금 금액", example = "", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String maReceiv;

	@Schema(description = "미지급 금액", example = "", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String maOutsand;

}
