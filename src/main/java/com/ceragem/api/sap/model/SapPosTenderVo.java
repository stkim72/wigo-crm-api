package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosTenderVo
 * @author 이승빈
 * @date 2022. 6. 28.
 * @Version 1.0
 * @description POS 매출전송(영수증별) 객체 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "POS 매출전송(영수증별) 객체")
public class SapPosTenderVo {

	@Schema(description = "POS 매출전송(영수증별) ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosTenderItemVo> items = null;

}
