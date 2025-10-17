package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsCntrStkTransferItemVo
 * @author user
 * @date 2022. 8. 29.
 * @Version 1.0
 * @description SAP 센터간재고이전 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 센터간재고이전 객체")
public class SapAsCntrStkTransferItemVo {
	@Schema(description = "자재코드 번호", example = "109824", hidden = false, required = true, nullable = false, maxLength = 18)
	private String matnr;

	@Schema(description = "수량", example = "1.00", hidden = false, required = true, nullable = false, maxLength = 17)
	private String menge;

	@Schema(description = "단위", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String meins;
}
