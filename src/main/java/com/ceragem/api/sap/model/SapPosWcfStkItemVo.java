package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosWcfStkItemVo
 * @author 이승빈
 * @date 2022. 7. 14.
 * @Version 1.0
 * @description 웰카페) 실사 (재고조사) 내역 ITEM Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "웰카페) 실사 (재고조사) 내역 ITEM 객체")
public class SapPosWcfStkItemVo {

	@Schema(description = "품목 코드", example = "500971", hidden = false, required = true, nullable = false, maxLength = 18)
	private String matnr;

	@Schema(description = "실사 구분", example = "0001", hidden = false, required = true, nullable = false, maxLength = 4)
	private String zinsptDiv;

	@Schema(description = "재고 단위", example = "EA", hidden = false, required = true, nullable = false, maxLength = 3)
	private String zstockUnit;

	@Schema(description = "총 실사 수량", example = "100", hidden = false, required = true, nullable = false, maxLength = 13)
	private String ztotInsptQnty;

	@Schema(description = "등록자 ID", example = "id001", hidden = false, required = false, nullable = true, maxLength = 12)
	private String ernam;

	@Schema(description = "등록 일시", example = "20220701", hidden = false, required = false, nullable = true, maxLength = 8)
	private String ersda;

	@Schema(description = "수정자 ID", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	private String aenam;

	@Schema(description = "수정 일시", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	private String laeda;

}
