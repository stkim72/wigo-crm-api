package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosSpcItemVo
 * @author 이승빈
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP POS 품목 마스터 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 품목 마스터 item 객체")
public class SapPosSpcItemVo {

	@Schema(description = "품목코드", example = "P00001", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String matnr;

	@Schema(description = "품목 명", example = "원두/10KG", hidden = false, required = true, nullable = false, maxLength = 40)
	@NotEmpty
	private String maktx;

	@Schema(description = "품목약 명", example = "원두", hidden = false, required = true, nullable = false, maxLength = 40)
	@NotEmpty
	private String maktg;

	@Schema(description = "세트여부", example = "X", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String zsetGb;

	@Schema(description = "규격", example = "10KG", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	private String zspec;

	@Schema(description = "분류 구분", example = "1", hidden = false, required = false, nullable = true, maxLength = 12)
	private String zpitemGb;

	@Schema(description = "배송 구분", example = "01", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String zdlvGb;

	@Schema(description = "발주 단위", example = "EA", hidden = false, required = false, nullable = true, maxLength = 3)
	private String zpoUint;

	@Schema(description = "발주 입수", example = "2", hidden = false, required = true, nullable = false, maxLength = 13)
	@NotEmpty
	private String zpoNoq;

	@Schema(description = "재고 단위", example = "EA", hidden = false, required = false, nullable = true, maxLength = 3)
	private String meins;

	@Schema(description = "재고 입수", example = "3", hidden = false, required = true, nullable = false, maxLength = 13)
	@NotEmpty
	private String brgew;

	@Schema(description = "레시피 단위", example = "G", hidden = false, required = false, nullable = true, maxLength = 3)
	private String zrcpUnit;

	@Schema(description = "레시피 입수", example = "1", hidden = false, required = false, nullable = true, maxLength = 13)
	private String zrcpNoq;

	@Schema(description = "레시피 입수 분모", example = "1", hidden = false, required = false, nullable = true, maxLength = 13)
	private String zrcpNoqD;

	@Schema(description = "발주 배수", example = "10", hidden = false, required = false, nullable = true, maxLength = 2)
	private String zpoMultip;

	@Schema(description = "부가세 여부", example = "X", hidden = false, required = false, nullable = true, maxLength = 2)
	private String zvatYn;

	@Schema(description = "유통기한 일자", example = "20221231", hidden = false, required = false, nullable = true, maxLength = 8)
	private String zexpryDate;

	@Schema(description = "일반 발주 시작 일자", example = "20220624", hidden = false, required = false, nullable = true, maxLength = 8)
	private String zgnrlPoStaDate;

	@Schema(description = "일반 발주 종료 일자", example = "20220731", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String zgnrlPoEndDate;

	@Schema(description = "대분류 코드", example = "001", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String zlClssCd;

	@Schema(description = "중분류 코드", example = "010", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String zmClssCd;

	@Schema(description = "소분류 코드", example = "0101", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String zsClssCd;

	@Schema(description = "사용구분", example = "02", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String zuseDiv;

	@Schema(description = "등록자 ID", example = "id-0001", hidden = false, required = false, nullable = true, maxLength = 12)
	private String ernam;

	@Schema(description = "등록 일시", example = "20220624", hidden = false, required = false, nullable = true, maxLength = 8)
	private String ersda;

	@Schema(description = "수정자 ID", example = "id-0001", hidden = false, required = false, nullable = true, maxLength = 12)
	private String aenam;

	@Schema(description = "수정 일시", example = "20220624", hidden = false, required = false, nullable = true, maxLength = 8)
	private String laeda;
}
