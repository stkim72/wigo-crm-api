package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosStduseSetItemVo
 * 
 * 
 * @author 이승빈
 * @date 2022. 7. 4.
 * @Version 1.0
 * @description SAP POS 웰카페 표준소요량 ITEM Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 웰카페 표준소요량 ITEM 객체")
public class SapPosStduseSetItemVo {

	@Schema(description = "매출 일자", example = "20220701", hidden = false, required = false, nullable = true, maxLength = 8)
	private String bstdk;

	@Schema(description = "매장 코드", example = "140841", hidden = false, required = false, nullable = true, maxLength = 10)
	private String kunnr;

	@Schema(description = "품목코드", example = "P00001", hidden = false, required = false, nullable = true, maxLength = 18)
	private String matnr;

	@Schema(description = "재고 단위", example = "EA", hidden = false, required = false, nullable = true, maxLength = 3)
	private String zstockUnit;

	@Schema(description = "판매 수량", example = "10", hidden = false, required = false, nullable = true, maxLength = 15)
	private String zsaleQty;

	@Schema(description = "LOSS 수량	", example = "1", hidden = false, required = false, nullable = true, maxLength = 15)
	private String zlossQty;

	@Schema(description = "폐기 수량", example = "2", hidden = false, required = false, nullable = true, maxLength = 15)
	private String zdsuseQty;

	@Schema(description = "등록자 ID", example = "ID001", hidden = false, required = false, nullable = true, maxLength = 12)
	private String ernam;

	@Schema(description = "등록 일시", example = "20220701", hidden = false, required = false, nullable = true, maxLength = 8)
	private String ersda;

	@Schema(description = "수정자 ID", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	private String aenam;

	@Schema(description = "수정 일시", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	private String laeda;

}
