package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosIncomSetItemVo
 * @author 이승빈
 * @date 2022. 8. 1.
 * @Version 1.0
 * @description SAP POS 사업부 입금내역 수신 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 사업부 입금내역 수신 item 객체")
public class SapPosIncomSetItemVo {

	@Schema(description = "회원번호", example = "TEST111", hidden = false, required = true, nullable = false, maxLength = 20)
	private String storCd;

	@Schema(description = "실제입금일", example = "20220801", hidden = false, required = true, nullable = false, maxLength = 8)
	private String dpsDate;

	@Schema(description = "입금액", example = "100000", hidden = false, required = true, nullable = false, maxLength = 13)
	private String dpsAmt;

	@Schema(description = "거래번호", example = "TRD0001", hidden = false, required = true, nullable = false, maxLength = 20)
	private String txnId;

	@Schema(description = "입금자명(입금자전달메세지)", example = "입금자", hidden = false, required = true, nullable = false, maxLength = 20)
	private String dpsNm;

	@Schema(description = "상태", example = "00001", hidden = false, required = true, nullable = false, maxLength = 20)
	private String status;

	@Schema(description = "등록날짜", example = "20220801", hidden = false, required = true, nullable = false, maxLength = 8)
	private String regDt;

	@Schema(description = "등록자", example = "USE001", hidden = false, required = true, nullable = false, maxLength = 12)
	private String regrId;

	@Schema(description = "수정날짜", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	private String amdDt;

	@Schema(description = "수정자", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	private String amdrId;

}
