package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPntUseSetVo
 * @author 이승빈
 * @date 2022. 6. 23.
 * @Version 1.0
 * @description SAP PNT 포인트 사용 완료 처리 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP PNT 포인트 사용 완료 처리 객체")
public class SapPntUseSetVo {

	@Schema(description = "SAP PNT 포인트 사용 완료 처리 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPntUserSetItemVo> items = null;

}
