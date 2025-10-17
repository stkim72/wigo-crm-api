package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAs3000MatnrItemVo
 * @author user
 * @date 2022. 8. 29.
 * @Version 1.0
 * @description SAP 본사 3000번 창고 현재고 조회 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 본사 3000번 창고 현재고 조회")
public class SapAs3000MatnrItemVo {
	@Schema(description = "자재코드 번호", example = "108438", hidden = false, required = true, nullable = false, maxLength = 18)
	private String matnr;
}