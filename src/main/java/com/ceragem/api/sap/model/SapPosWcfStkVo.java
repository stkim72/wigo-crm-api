package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosWcfStkVo
 * @author user
 * @date 2022. 7. 14.
 * @Version 1.0
 * @description 웰카페) 실사 (재고조사) 내역 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "웰카페) 실사 (재고조사) 내역 객체")
public class SapPosWcfStkVo {

	@Schema(description = "일련번호", example = "20220701001", hidden = false, required = true, nullable = false, maxLength = 20)
	private String zcrmSeq;

	@Schema(description = "회사 코드", example = "1000", hidden = false, required = true, nullable = false, maxLength = 4)
	private String vkorg;

	@Schema(description = "채널 코드", example = "9620", hidden = false, required = true, nullable = false, maxLength = 4)
	private String vkbur;

	@Schema(description = "매장 코드", example = "140841", hidden = false, required = true, nullable = false, maxLength = 10)
	private String kunnr;

	@Schema(description = "실사 일자", example = "20220630", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zinsptDate;

	@Schema(description = "웰카페) 실사 (재고조사) 내역 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosWcfStkItemVo> items = null;
}
