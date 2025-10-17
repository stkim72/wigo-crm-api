package com.ceragem.api.as.model;

import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmSapRfndTrtTrmVo
 * @author 이윤성
 * @date 2022. 6. 27.
 * @Version 1.0
 * @description 유상매출 반제처리 결과 수신 Vo (SAP매출반제 처리 프로그램에서 반제처리시 AS시스템으로 처리 결과 전송)
 *
 */
@Getter
@Setter
@Schema(description = "유상매출 반제처리 결과 수신 객체")
public class AsmSapRfndTrtTrmVo extends ApiBaseVo {

	/**
	 * 유상매출 반제처리 결과 수신목록
	 */
	@Schema(description = "유상매출 반제처리 결과 수신목록", example = "", hidden = false, required = true, nullable = false)
	private List<AsmSapRfndTrtTrmListVo> items;
}
