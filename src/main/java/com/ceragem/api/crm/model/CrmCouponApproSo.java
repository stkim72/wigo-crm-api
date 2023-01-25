package com.ceragem.api.crm.model;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "CRM멤버십쿠폰 사용 객체")
public class CrmCouponApproSo {

	/**
	 * 매장코드
	 */
	@Parameter(description = "쿠폰번호", example = "", hidden = false, required = false)
	private String coupnPblsBasNo;
	/**
	 * 매장코드
	 */
	@Parameter(description = "사용매장", example = "", hidden = false, required = false)
	private String storNo;
	/**
	 * 채널코드
	 */
	@Parameter(description = "채널코드", example = "", hidden = false, required = false)
	private String chlCd;
	/**
	 * 통합회원
	 */
	@Parameter(description = "통합회원", example = "", hidden = false, required = false)
	private String itgCustNo;
	/**
	 * 전표번호
	 */
	@Parameter(description = "전표번호", example = "", hidden = false, required = false)
	private String chitNo;
	/**
	 * 제품번호
	 */
	@Parameter(description = "제품번호", example = "", hidden = false, required = false)
	private String buyGodsCd;
	/**
	 * 주문금액
	 */
	@Parameter(description = "주문금액", example = "", hidden = false, required = false)
	private Integer ordrAmt;
	/**
	 * 결제금액
	 */
	@Parameter(description = "결제금액", example = "", hidden = false, required = false)
	private Integer payAmt;
	/**
	 * 할인금액
	 */
	@Parameter(description = "할인금액", example = "", hidden = false, required = false)
	private Integer saleAmt;
	/**
	 * 프로모션번호
	 */
	@Parameter(description = "프로모션번호", example = "", hidden = false, required = false)
	private String promNo;
	/**
	 * 캠페인번호
	 */
	@Parameter(description = "캠페인번호", example = "", hidden = false, required = false)
	private String campNo;

}
