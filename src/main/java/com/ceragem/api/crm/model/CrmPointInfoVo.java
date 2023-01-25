package com.ceragem.api.crm.model;

import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmPointHstVo
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM포인트정보 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM포인트이력 객체")
public class CrmPointInfoVo {

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = true, nullable = true, maxLength = 30, accessMode = AccessMode.READ_ONLY)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 전체포인트
	 */
	@Schema(description = "전체포인트", example = "1000", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private int totalPoint = 0;

	/**
	 * 가용포인트
	 */
	@Schema(description = "가용포인트", example = "1000", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private int availablePoint = 0;

	
	/**
	 *  누적적립
	 */
	@Schema(description = "누적적립", example = "1000", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private int totalDeposit = 0;
	
	/**
	 * 누적사용
	 */
	@Schema(description = "누적사용", example = "1000", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private int totalWithdrawal = 0;
	
	
	/**
	 * 만료된포인트
	 */
	@Schema(description = "만료된포인트", example = "1000", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private int expiredPoint = 0;
	
	
	
	/**
	 * 소멸예정포인트
	 */
	@Schema(description = "발생포인트", example = "1000", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private int occurPointScore = 0;
	
	
}
