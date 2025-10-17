package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosGiScheVo {
 * @author 이승빈
 * @date 2022. 7. 27.
 * @Version 1.0
 * @description 매장 출고 내역(매장 입고 예정) SO
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 매장 출고 내역(매장 입고 예정) 검색 객체")
public class SapPosGiScheVo {

	@Schema(description = "출고 일자(재고 이고 일자)", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String zofwDate;

}
