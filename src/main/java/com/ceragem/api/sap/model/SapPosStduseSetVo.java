package com.ceragem.api.sap.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosStduseSetVo
 * @author 이승빈
 * @date 2022. 7. 4.
 * @Version 1.0
 * @description SAP POS 웰카페 표준소요량 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 웰카페 표준소요량 객체")
public class SapPosStduseSetVo {

	@Schema(description = "순번", example = "20220701001", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String zcrmSeq;

	@Schema(description = "회사 코드", example = "100", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String vkorg;

	@Schema(description = "채널 코드", example = "9620", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkbur;

	@Schema(description = "SAP POS 웰카페 표준소요량 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosStduseSetItemVo> items = null;

}
