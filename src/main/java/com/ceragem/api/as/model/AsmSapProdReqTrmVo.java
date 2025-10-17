package com.ceragem.api.as.model;

import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmSapProdReqTrmVo
 * @author 이윤성
 * @date 2022. 6. 27.
 * @Version 1.0
 * @description 자재요청-구매입고 결과 수신 Vo (자재요청건의 구매입고시 처리 결과 전송)
 *
 */
@Getter
@Setter
@Schema(description = "자재요청-구매입고 결과 수신 객체")
public class AsmSapProdReqTrmVo extends ApiBaseVo {

	/**
	 * 자재요청-구매입고 결과 수신목록
	 */
	@Schema(description = "자재요청-구매입고 결과 수신목록", example = "", hidden = false, required = true, nullable = false)
	private List<AsmSapProdReqTrmListVo> items;
}
