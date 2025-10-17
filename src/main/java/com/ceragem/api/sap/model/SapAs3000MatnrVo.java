package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAs3000MatnrVo
 * @author user
 * @date 2022. 9. 20.
 * @Version 1.0
 * @description 본사 3000번 창고 현재고 조회 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 본사 3000번 창고 현재고 조회")
public class SapAs3000MatnrVo {
	@Schema(description = "본사 3000번 창고 현재고 조회 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapAs3000MatnrItemVo> items = null;
}
