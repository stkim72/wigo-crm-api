package com.ceragem.api.sap.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosRcpVo
 * @author 이승빈
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP POS 레시피 마스터 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 레시피 마스터 객체")
public class SapPosRcpVo {

	@Schema(description = "판매조직", example = "1000", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkorg;

	@Schema(description = "채널코드", example = "9200", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkbur;

	@Schema(description = "SAP POS 레시피 마스터 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosRcpItemVo> items = null;

}
