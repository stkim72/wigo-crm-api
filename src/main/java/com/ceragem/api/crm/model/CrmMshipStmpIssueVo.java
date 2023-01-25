package com.ceragem.api.crm.model;

import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "CRM멤버십스탬프 이력 객체")
public class CrmMshipStmpIssueVo {

	/**
	 * 스탬프 마스터 코드
	 */
	@Schema(description = "스탬프 마스터 코드", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String mshipStmpBasNo;
	/**
	 * 스탬프 마스터 코드
	 */
	@Schema(description = "스탬프 마스터 명", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String stmpBasNm;
	/**
	 * FROM사용기준일
	 */
	@Schema(description = "FROM사용기준일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String fromUseStdDay;
	/**
	 * TO사용기준일
	 */
	@Schema(description = "TO사용기준일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String toUseStdDay;
	/**
	 * 판당스탬프수
	 */
	@Schema(description = "판당스탬프수", example = "", hidden = false, required = false, nullable = true)
	private Integer stmpQnty;
	/**
	 * 스탬프판수
	 */
	@Schema(description = "스탬프판수 0 무제한", example = "", hidden = false, required = false, nullable = true)
	private Integer stmpBoardCnt;
	/**
	 * 완료판수
	 */
	@Schema(description = "완료판수", example = "", hidden = false, required = false, nullable = true)
	private Integer accumCnt;
	/**
	 * 스탬프 적립수
	 */
	@Schema(description = "스탬프 적립수", example = "", hidden = false, required = false, nullable = true)
	private Integer stmpAccumQnty;
	/**
	 * 발급혜택
	 */
	@Schema(description = "발급혜택", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String accumType;
}
