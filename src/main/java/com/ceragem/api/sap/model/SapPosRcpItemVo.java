package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.sap.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosRcpItemVo
 * @author 이승빈
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP POS 레시피 마스터 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 레시피 마스터 item 객체")
public class SapPosRcpItemVo {

	@Schema(description = "제상품 코드", example = "MAT1123", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String zitemCd;

	@Schema(description = "품목 코드", example = "P00001", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String matnr;

	@Schema(description = "레시피 일련번호", example = "202206240001", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	private String zrcpSeq;

	@Schema(description = "재고 처리구분", example = "X", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String zstockTrtDiv;

	@Schema(description = "세트 구분", example = "X", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String zsetGb;

	@Schema(description = "레시피(사용)단위", example = "EA", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	private String meins;

	@Schema(description = "레시피 입수 분모", example = "1", hidden = false, required = false, nullable = true, maxLength = 13)
	@NotEmpty
	private String zrcpNoqD;

	@Schema(description = "사용 량", example = "1", hidden = false, required = true, nullable = false, maxLength = 13)
	@NotEmpty
	private String zuseQnty;

	@Schema(description = "LOSS 율", example = "0", hidden = false, required = true, nullable = false, maxLength = 13)
	@NotEmpty
	private String zlossRate;

	@Schema(description = "사용 여부", example = "Y", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String zuseYn;

	@Schema(description = "비고", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String zrmark;

	@Schema(description = "등록자 ID", example = "id-0001", hidden = false, required = false, nullable = true, maxLength = 12)
	private String ernam;

	@Schema(description = "등록 일시", example = "20220624", hidden = false, required = false, nullable = true, maxLength = 8)
	private String ersda;

	@Schema(description = "수정자 ID", example = "id-0001", hidden = false, required = false, nullable = true, maxLength = 12)
	private String aenam;

	@Schema(description = "수정 일시", example = "20220624", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String laeda;
}
