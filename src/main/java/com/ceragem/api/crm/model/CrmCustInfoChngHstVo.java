package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCustInfoChngHstVo
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM고객정보변경이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객정보변경이력 객체")
public class CrmCustInfoChngHstVo extends ApiBaseVo {
	/**
	 * 고객정보변경이력일련번호
	 */
	@Schema(description = "고객정보변경이력일련번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String custInfoChngHstSeq;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 변경항목내용
	 */
	@Schema(description = "변경항목", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String chngClusCtnts;
	/**
	 * 변경사유내용
	 */
	@Schema(description = "변경사유", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String chngWhyCtnts;
	/**
	 * 보존기간
	 */
	@Schema(description = "보존기간", example = "", hidden = true, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String keepPerd;
	/**
	 * 변경전내용
	 */
	@Schema(description = "변경전내용", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String chngPreCtnts;
	/**
	 * 변경내용
	 */
	@Schema(description = "변경내용", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String chngCtnts;

}
