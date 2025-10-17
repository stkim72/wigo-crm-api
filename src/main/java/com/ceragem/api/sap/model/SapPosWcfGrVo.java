package com.ceragem.api.sap.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosWcfGrVo
 * @author 이승빈
 * @date 2022. 7. 1.
 * @Version 1.0
 * @description SAP POS 웰카페)입고 확정 내역 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 웰카페)입고 확정 내역 객체")
public class SapPosWcfGrVo {

	@Schema(description = "일련번호", example = "20220701001", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String zcrmSeq;

	@Schema(description = "회사 코드", example = "1000", hidden = false, required = false, nullable = true, maxLength = 4)
	private String vkorg;

	@Schema(description = "채널 코드", example = "9620", hidden = false, required = false, nullable = true, maxLength = 4)
	private String vkbur;

	@Schema(description = "SAP POS 웰카페)입고 확정 내역 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosWcfGrItemVo> items = null;

}
