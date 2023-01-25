package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipStmpBasVo
 * @author user
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM멤버십스탬프기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십스탬프상품 객체")
public class CrmMshipStmpAccumGodsVo extends ApiBaseVo {

	/**
	 * 구매제품번호
	 */
	@Schema(description = "구매제품번호", example = "", hidden = false, required = true, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String buyGodsNo;

	/**
	 * 주문금액
	 */
	@Schema(description = "주문금액", example = "", hidden = false, required = true, nullable = true)
	private Integer ordrAmt;

	/**
	 * 결제금액
	 */
	@Schema(description = "결제금액", example = "", hidden = false, required = true, nullable = true)
	private Integer payAmt;

	/**
	 * 주문수량
	 */
	@Schema(description = "주문수량", example = "", hidden = false, required = true, nullable = true)
	private Integer applyQnty;

	/**
	 * 적립제외
	 */
	@Schema(description = "제외여부 [Y/N]", example = "N", hidden = false, required = true, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String applyYn;

	/**
	 * 적립제외
	 */
	@Schema(description = "쿠폰여부 [Y/N]", example = "N", hidden = false, required = true, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String coupnYn;

//	@Schema(description = "FROM사용가능일시 (YYYYMMDDHH24MISS)", example = "20220517135655", hidden = false, required = false, nullable = true)
//	@DatetimeValue
//	private String fromUsePossDt;
//	/**
//	 * TO사용가능일시
//	 */
//	@Schema(description = "TO사용가능일시 (YYYYMMDDHH24MISS)", example = "20220517135655", hidden = false, required = false, nullable = true)
//	@DatetimeValue
//	private String toUsePossDt;
//	/**
//	 * 유효여부
//	 */
//	@Schema(description = "유효여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
//	@YnValue
//	@MaxByte(max = 1)
//	private String validYn;

}
