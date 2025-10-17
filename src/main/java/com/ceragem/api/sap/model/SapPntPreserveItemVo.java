package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPntPreserveItemVo
 * @author 이승빈
 * @date 2022. 6. 23.
 * @Version 1.0
 * @description SAP PNT 가맹점 포인트 보전 item 객체
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP PNT 가맹점 포인트 보전 item 객체")
public class SapPntPreserveItemVo {

	@Schema(description = "거래일시", example = "20210731", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String zrtDt;

	@Schema(description = "거래처코드", example = "11", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	private String kunnr;

	@Schema(description = "거래처명", example = "test", hidden = false, required = false, nullable = true, maxLength = 255)
	private String kunnrNm;

	@Schema(description = "할인 구분", example = "1", hidden = false, required = true, nullable = false, maxLength = 1)
	@NotEmpty
	private String saleGb;

	@Schema(description = "부담 적립 포인트", example = "100", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String pntPaySave;

	@Schema(description = "부담 사용 포인트", example = "90", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String pntPayUse;

}
