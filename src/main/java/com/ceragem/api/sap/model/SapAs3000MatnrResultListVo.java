package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAs3000MatnrResultListVo
 * @author user
 * @date 2022. 9. 20.
 * @Version 1.0
 * @description SAP 본사 3000번 창고 현재고 조회
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 센터간재고이전 객체")
public class SapAs3000MatnrResultListVo {
	@Schema(description = "자재코드 번호", example = "", hidden = false, required = true, nullable = false, maxLength = 18)
	private String matnr;

	@Schema(description = "수량", example = "", hidden = false, required = true, nullable = false, maxLength = 17)
	private String menge;

	@Schema(description = "단위", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String meins;
}