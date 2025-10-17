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
 * @description SAP POS 웰카페)입고 확정 내역 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 웰카페)입고 확정 내역 item 객체")
public class SapPosWcfGrItemVo {

	@Schema(description = "매장 코드", example = "140841", hidden = false, required = true, nullable = false, maxLength = 10)
	private String kunnr;

	@Schema(description = "SPC 출고 일자", example = "20220801", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zofwDate;

	@Schema(description = "발주 일자", example = "20220601", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zrtDt;

	@Schema(description = "발주 구분", example = "10", hidden = false, required = true, nullable = false, maxLength = 4)
	private String zcrmGb;

	@Schema(description = "상세 일련번호", example = "001", hidden = false, required = true, nullable = false, maxLength = 10)
	private String zcrmDtlSeq;

	@Schema(description = "품목 코드", example = "P00001", hidden = false, required = true, nullable = false, maxLength = 18)
	private String matnr;

	@Schema(description = "세트 품목 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 18)
	private String zsetPitemCd;

	@Schema(description = "입고 일자", example = "20220530", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zstwhDate;

	@Schema(description = "거래 구분", example = "0", hidden = false, required = false, nullable = true, maxLength = 1)
	private String zdealDiv;

	@Schema(description = "단가", example = "1000", hidden = false, required = true, nullable = false, maxLength = 15)
	private String netpr;

	@Schema(description = "금액(공급가액)", example = "100", hidden = false, required = true, nullable = false, maxLength = 15)
	private String zcostPrice;

	@Schema(description = "부가세 금액", example = "100", hidden = false, required = true, nullable = false, maxLength = 15)
	private String mwsbp;

	@Schema(description = "입고 확정 일자", example = "20220601", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zstwhConfrmDate;

	@Schema(description = "입고 수량", example = "1", hidden = false, required = true, nullable = false, maxLength = 15)
	private String zstwhQnty;

	@Schema(description = "사유 코드", example = "1", hidden = false, required = true, nullable = false, maxLength = 10)
	private String zwhyCd;

	@Schema(description = "작업 상태", example = "1", hidden = false, required = true, nullable = false, maxLength = 10)
	private String zwrkStatus;

	@Schema(description = "발주 번호", example = "pos0001", hidden = false, required = true, nullable = false, maxLength = 17)
	private String zpoNo;

	@Schema(description = "등록자 ID", example = "ID001", hidden = false, required = true, nullable = false, maxLength = 12)
	private String ernam;

	@Schema(description = "등록 일시", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 8)
	private String ersda;

	@Schema(description = "수정자 ID", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	private String aenam;

	@Schema(description = "수정 일시", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	private String laeda;

}
