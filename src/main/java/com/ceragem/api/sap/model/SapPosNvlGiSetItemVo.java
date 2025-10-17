package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosNvlGiSetItemVo
 * @author 이승빈
 * @date 2022. 7. 4.
 * @Version 1.0
 * @description SAP POS 나비엘)주문 출고 승인, 취소 ITEM Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 나비엘)주문 출고 승인, 취소 ITEM 객체")
public class SapPosNvlGiSetItemVo {

	@Schema(description = "매장 코드", example = "140841", hidden = false, required = false, nullable = true, maxLength = 10)
	private String kunnr;

	@Schema(description = "발주 일자", example = "20220701", hidden = false, required = false, nullable = true, maxLength = 8)
	private String zrtDt;

	@Schema(description = "발주 구분", example = "01", hidden = false, required = false, nullable = true, maxLength = 4)
	private String zcrmGb;

	@Schema(description = "발주 상세 일련번호", example = "0001", hidden = false, required = false, nullable = true, maxLength = 10)
	private String zcrmDtlSeq;

	@Schema(description = "자재 번호", example = "500784", hidden = false, required = false, nullable = true, maxLength = 18)
	private String matnr;

	@Schema(description = "세트 품목 코드", example = "", hidden = false, required = false, nullable = true, maxLength = 18)
	private String zsetPitemCd;

	@Schema(description = "발주 단가", example = "1000", hidden = false, required = false, nullable = true, maxLength = 15)
	private String zpoPrc;

	@Schema(description = "발주 수량", example = "1", hidden = false, required = false, nullable = true, maxLength = 15)
	private String kwmeng;

	@Schema(description = "발주 금액	", example = "1000", hidden = false, required = false, nullable = true, maxLength = 15)
	private String zpoAmt;

	@Schema(description = "단위", example = "EA", hidden = false, required = false, nullable = true, maxLength = 0)
	private String zpoUnit;

	@Schema(description = "발주 입수", example = "1", hidden = false, required = false, nullable = true, maxLength = 13)
	private String zpoNoq;

	@Schema(description = "저장 위치", example = "3050", hidden = false, required = false, nullable = true, maxLength = 4)
	private String lgort;

	@Schema(description = "작업상태", example = "20", hidden = false, required = false, nullable = true, maxLength = 4)
	private String zwrkStatus;

	@Schema(description = "출고 처리 일시", example = "20220701", hidden = false, required = false, nullable = true, maxLength = 8)
	private String zofwTrtDt;

	@Schema(description = "계약자", example = "계약자명", hidden = false, required = false, nullable = true, maxLength = 200)
	private String zcontr;

	@Schema(description = "전화 번호", example = "0415291234", hidden = false, required = false, nullable = true, maxLength = 20)
	private String ztelNo;

	@Schema(description = "수령자", example = "수령자", hidden = false, required = false, nullable = true, maxLength = 200)
	private String zacptPrsn;

	@Schema(description = "배송 희망일자", example = "20220703", hidden = false, required = false, nullable = true, maxLength = 8)
	private String zdlvHopeDate;

	@Schema(description = "우편번호", example = "12345", hidden = false, required = false, nullable = true, maxLength = 10)
	private String zzipCd;

	@Schema(description = "주소1", example = "주소1", hidden = false, required = false, nullable = true, maxLength = 35)
	private String zaddr1;

	@Schema(description = "주소2", example = "주소2", hidden = false, required = false, nullable = true, maxLength = 35)
	private String zaddr2;

	@Schema(description = "주소3", example = "주소3", hidden = false, required = false, nullable = true, maxLength = 35)
	private String zaddr3;

	@Schema(description = "핸드폰 번호", example = "01010002000", hidden = false, required = false, nullable = true, maxLength = 20)
	private String zhpNo;

	@Schema(description = "배송요청사항", example = "배송요청사항", hidden = false, required = false, nullable = true, maxLength = 255)
	private String zdlvReqIssue;

	@Schema(description = "발주 번호", example = "pos0001", hidden = false, required = false, nullable = true, maxLength = 17)
	private String zpoNo;

	@Schema(description = "무상 유형", example = "01", hidden = false, required = false, nullable = true, maxLength = 50)
	private String zfreeType;

	@Schema(description = "등록자 ID", example = "ID001", hidden = false, required = false, nullable = true, maxLength = 12)
	private String ernam;

	@Schema(description = "등록 일시", example = "20220701", hidden = false, required = false, nullable = true, maxLength = 8)
	private String ersda;

	@Schema(description = "수정자 ID", example = "", hidden = false, required = false, nullable = true, maxLength = 12)
	private String aenam;

	@Schema(description = "수정 일시", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	private String laeda;

}
