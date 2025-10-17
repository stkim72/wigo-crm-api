package com.ceragem.api.ctc.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmBllkCustHstVo
 * @author 임형진
 * @date 2022. 4. 15.
 * @Version 1.0
 * @description CTC고객정보조회 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CTC고객정보조회 객체")
public class ConsultHstInqrySendSo extends ApiPagination {
	/**
	 * 전화번호
	 */
	@Schema(description = "전화번호", example = "01051763688", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String custTelNo;
	/**
	 * 통합고객번호*
	 */
	@Schema(description = "통합고객번호", example = "CST22041410024201688", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;

	/**
	 * 시작일자
	 */
	@Schema(description = "시작일자", example = "20220101", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String startDt;
	/**
	 * 종료일자
	 */
	@Schema(description = "종료일자", example = "20220501", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String endDt;
	
	/**
	 * 상담이력번호
	 */
	@Schema(description = "상담이력번호", example = "20220615130827723PLT514", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 30)
	private String cnslHistNo;
	

}
