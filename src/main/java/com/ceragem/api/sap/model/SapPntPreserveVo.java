package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPntPreserveVo
 * @author 이승빈
 * @date 2022. 6. 23.
 * @Version 1.0
 * @description SAP PNT 가맹점 포인트 보전 객체
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP PNT 가맹점 포인트 보전 객체")
public class SapPntPreserveVo {

	@Schema(description = "SAP PNT 가맹점 포인트 보전 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPntPreserveItemVo> items = null;
}
