package com.ceragem.api.ctc.model;


import com.ceragem.api.as.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CtcInquiryVo
 * @author 임형진
 * @date 2022. 7. 06.
 * @Version 1.0
 * @description 문의접수 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CTC 문의접수 객체")
public class CtcInquiryVo {
	
	/**
	 * 문의번호
	 */
	@Schema(description = "문의번호", example = "1234", hidden = false, required = true, nullable = false, maxLength = 22)
	@MaxByte(max = 30)
	private Integer qustnSeq;
	
	/**
	 * 접수일자
	 */
	@Schema(description = "접수일자", example = "20220630", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 30)
	private String submitDt;
	
	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "홍길동", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;
	
	/**
	 * 고객전화번호
	 */
	@Schema(description = "고객전화번호", example = "01051763688", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String mobilNo;
	
	/**
	 * 제품명
	 */
	@Schema(description = "제품명", example = "제품", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 20)
	private String prodNm;
	
	/**
	 * 접수내용
	 */
	@Schema(description = "접수내용", example = "접수 진행했습니다.", hidden = false, required = true, nullable = false, maxLength = 1000)
	@MaxByte(max = 1000)
	private String submitCntn;
	
	/**
	 * 상담접수완료일자
	 */
	@Schema(description = "상담접수완료일자", example = "220524", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String updDttm;
	
	/**
	 * 처리구분명
	 */
	@Schema(description = "처리구분명", example = "접수중", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String procNm;
	
	/**
	 * 처리구분코드
	 */
	@Schema(description = "처리구분코드", example = "01", hidden = false, required = true, nullable = false, maxLength = 2)
	@MaxByte(max = 2)
	private String procTy;
	
	
}
