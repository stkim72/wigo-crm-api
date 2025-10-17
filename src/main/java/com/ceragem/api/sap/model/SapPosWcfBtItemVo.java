package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosWcfGrItemVo
 * @author 이승빈
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP POS 웰카페)점간 이동 내역 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 웰카페)점간 이동 내역 item 객체")
public class SapPosWcfBtItemVo {

	@Schema(description = "매장 코드", example = "140841", hidden = false, required = true, nullable = false, maxLength = 10)
	private String kunnr;

	@Schema(description = "입고확정 일자", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zstwhConfrmDate;

	@Schema(description = "입고 매장 코드", example = "140842", hidden = false, required = true, nullable = false, maxLength = 10)
	private String zstwhStorCd;

	@Schema(description = "전표 번호", example = "2022070101", hidden = false, required = true, nullable = false, maxLength = 10)
	private String zslipNo;

	@Schema(description = "전표 생성 일련번호", example = "00001", hidden = false, required = true, nullable = false, maxLength = 20)
	private String zslipCreateSeq;

	@Schema(description = "품목 코드", example = "P00001", hidden = false, required = true, nullable = false, maxLength = 18)
	private String matnr;

	@Schema(description = "점간이동 일자", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 8)
	private String stockMovDate;

	@Schema(description = "재고 단위", example = "EA", hidden = false, required = true, nullable = false, maxLength = 3)
	private String zstockUnit;

	@Schema(description = "발주 단위", example = "EA", hidden = false, required = true, nullable = false, maxLength = 3)
	private String zpoUnit;

	@Schema(description = "재고 환산 수량", example = "1", hidden = false, required = true, nullable = false, maxLength = 13)
	private String labst;

	@Schema(description = "이동 단위", example = "EA", hidden = false, required = true, nullable = false, maxLength = 2)
	private String zmovUnit;

	@Schema(description = "이동 수량", example = "1", hidden = false, required = true, nullable = false, maxLength = 13)
	private String zmovQnty;

	@Schema(description = "등록자 ID", example = "ID001", hidden = false, required = true, nullable = false, maxLength = 12)
	private String ernam;

	@Schema(description = "등록 일시", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 8)
	private String ersda;

	@Schema(description = "수정자 ID", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	private String aenam;

	@Schema(description = "수정 일시", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	private String laeda;

}
