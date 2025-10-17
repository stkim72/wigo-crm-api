package com.ceragem.api.ctc.model;

import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName homepageQustnAsRegVo
 * @author 임형진
 * @date 2022. 4. 15.
 * @Version 1.0
 * @description 1대1문의 AS등록 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "1대1문의  AS등록")
public class QustnAsRegVo {

	
	/**
	 * 문의구분 01: homepage: AS접수,02: homepage: 1:1문의,03: IoT:AS 접수
	 */
	@Schema(description = "문의구분  01: homepage: AS접수,02: homepage: 1:1문의,03: IoT:AS 접수 ", example = "01", hidden = false, required = true, nullable = false, maxLength = 2)
	@MaxByte(max = 2)
	private String qustnDiv;
	
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "232824", hidden = false, required = false, nullable = false, maxLength = 64)
	@MaxByte(max = 64)
	private String custNo;
	
	/**
	 * 이메일
	 */
	@Schema(description = "이메일", example = "aa@email", hidden = false, required = false, nullable = false, maxLength = 90)
	@MaxByte(max = 90)
	private String email;
	
	
	/**
	 * 고객주소
	 */
	@Schema(description = "고객주소", example = "서울특별시", hidden = false, required = false, nullable = false, maxLength = 160)
	@MaxByte(max = 160)
	private String custAddr;
	
	
	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "홍길동", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;

	/**
	 * 접수일자
	 */
	@Schema(description = "접수일자", example = "20110909", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String submitDt;

	
	/**
	 * 고객_핸드폰번호
	 */
	@Schema(description = "고객_핸드폰번호", example = "01051769999", hidden = false, required = true, nullable = false, maxLength = 64)
	@MaxByte(max = 64)
	private String mobilNo;

	/**
	 * 제품명
	 */
	@Schema(description = "제품명", example = "Mster 제품", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String prodNm;
	/**
	 * 접수내용
	 */
	@Schema(description = "접수내용", example = "AS접수문의", hidden = false, required = false, nullable = true, maxLength = 3000)
	@MaxByte(max = 3000)
	private String submitCntn;
	/**
	 * 처리구분
	 */
	@Schema(description = "처리구분 [01:접수중,02:처리중,03:처리완료]", example = "01", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String procTy;
	/**
	 * 등록자ID
	 */
	@Schema(description = "등록자ID", example = "hong", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String regrId;

	/**
	 * 변경자ID
	 */
	@Schema(description = "변경자ID", example = "hong", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String updId;

}
