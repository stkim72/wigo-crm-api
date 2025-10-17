package com.ceragem.api.as.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmCustAddrListVo
 * @author 이윤성
 * @date 2022. 5. 30.
 * @Version 1.0
 * @description BOS고객 주소 리스트 Vo
 */
@Getter
@Setter
@Schema(description = "BOS고객 주소 리스트 객체")
public class AsmCustAddrListVo extends ApiBaseVo {

	/**
	 * 주소구분코드(PK) (기본주소는 한건만 등록 가능함)
	 */
	@Schema(description = "주소구분코드  [10 : 기본 , 11 : 거주지]", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@CodeValue(codeId = "0000", codes = { "10", "11" }, message = "[10 : 기본 , 11 : 거주지] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 10)
	private String addrSe;

	/**
	 * 우편번호
	 */
	@Schema(description = "우편번호", example = "", hidden = false, required = true, nullable = false, maxLength = 5)
	@MaxByte(max = 5)
	private String zip;

	/**
	 * 기본 주소
	 */
	@Schema(description = "기본 주소", example = "", hidden = false, required = true, nullable = false, maxLength = 200)
	@MaxByte(max = 200)
	private String bassAddr;

	/**
	 * 상세 주소
	 */
	@Schema(description = "상세 주소", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String dtlAddr;
}
