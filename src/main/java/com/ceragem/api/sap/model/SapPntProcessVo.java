package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPntProcessVo
 * @author 이승빈
 * @date 2022. 6. 22.
 * @Version 1.0
 * @description SAP PNT 포인트적립/소멸 완료처리 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP PNT 포인트적립/소멸 완료처리 객체")
public class SapPntProcessVo {

	@Schema(description = "SAP PNT 포인트적립/소멸 완료처리 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPntProcessItemVo> items = null;

}
