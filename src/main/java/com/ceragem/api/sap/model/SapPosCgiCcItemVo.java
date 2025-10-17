package com.ceragem.api.sap.model;

import com.ceragem.api.sap.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosCgiCcItemVo
 * @author 이승빈
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP POS 매출 반품확정내역 결과 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 매출 반품확정내역 결과 item 객체")
public class SapPosCgiCcItemVo {

	@Schema(description = "매장 코드", example = "140841", hidden = false, required = true, nullable = false, maxLength = 10)
	private String kunnr;

	@Schema(description = "반품 확정 일자", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zrgoodConfrmDate;

	@Schema(description = "전표 번호", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 10)
	private String zslipNo;

	@Schema(description = "품목 코드", example = "P00001", hidden = false, required = true, nullable = false, maxLength = 18)
	private String matnr;

	@Schema(description = "상세 일련번호", example = "0001", hidden = false, required = true, nullable = false, maxLength = 10)
	private String zcrmDtlSeq;

	@Schema(description = "발주 구분", example = "", hidden = false, required = true, nullable = false, maxLength = 4)
	private String zcrmGb;

	@Schema(description = "반품 일자", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zrgoodDate;

	@Schema(description = "반품 단위", example = "EA", hidden = false, required = true, nullable = false, maxLength = 3)
	private String zrgoodUnit;

	@Schema(description = "반품 단가", example = "1000", hidden = false, required = true, nullable = false, maxLength = 15)
	private String zrgoodPrc;

	@Schema(description = "반품 확정 수량", example = "1", hidden = false, required = true, nullable = false, maxLength = 15)
	private String zrgoodConfrmQnty;

	@Schema(description = "반품 금액", example = "1000", hidden = false, required = true, nullable = false, maxLength = 15)
	private String zrgoodAmt;

	@Schema(description = "발주 번호", example = "20220701001", hidden = false, required = true, nullable = false, maxLength = 17)
	@MaxByte(max = 17)
	private String zpoNo;

	@Schema(description = "창고 코드", example = "5000", hidden = false, required = true, nullable = false, maxLength = 4)
	private String reLgort;

	@Schema(description = "등록자 ID", example = "ID001", hidden = false, required = true, nullable = false, maxLength = 12)
	private String ernam;

	@Schema(description = "등록 일시", example = "20220701", hidden = false, required = true, nullable = false, maxLength = 8)
	private String ersda;

	@Schema(description = "수정자 ID", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	private String aenam;

	@Schema(description = "수정 일시", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	private String laeda;

}
