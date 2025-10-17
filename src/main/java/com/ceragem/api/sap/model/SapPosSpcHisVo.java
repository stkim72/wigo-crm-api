package com.ceragem.api.sap.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosSpcHisVo
 * @author 이승빈
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP POS 품목마스터(식음료) 공급가 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 품목마스터(식음료) 공급가 객체")
public class SapPosSpcHisVo {

	@Schema(description = "판매조직", example = "1000", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkorg;

	@Schema(description = "채널 코드", example = "9620", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkbur;

	@Schema(description = "SAP POS 품목마스터(식음료) 공급가 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosSpcHisItemVo> items = null;

}
