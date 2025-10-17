package com.ceragem.api.as.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmSapProdReqTrmListVo
 * @author 이윤성
 * @date 2022. 6. 27.
 * @Version 1.0
 * @description 자재요청-구매입고 결과 수신 Vo (자재요청건의 구매입고시 처리 결과 전송)
 *
 */
@Getter
@Setter
@Schema(description = "자재요청-구매입고 결과 수신 객체")
public class AsmSapProdReqTrmListVo {

	/**
	 * 자재요청번호
	 */
	@Schema(description = "자재요청번호", example = "", hidden = false, required = true, nullable = false)
	private String intime;

	/**
	 * 전송데이터유형 (I : 신규, U : 변경, D : 삭제)
	 */
	@Schema(description = "전송데이터유형 (I : 신규, U : 변경, D : 삭제)", example = "", hidden = false, required = true, nullable = false)
	private String trantype;

	/**
	 * SAP구매오더(구매오더번호) -> 예약/종속소요량번호
	 */
	@Schema(description = "SAP구매오더", example = "", hidden = false, required = false, nullable = false)
	private String ebeln;
	/**
	 * 예약/종속소요량번호
	 */
	@Schema(description = "소요번호", example = "", hidden = false, required = false, nullable = false)
	private String rsnum;

	/**
	 * 입고일자(구매오더의입고일자)
	 */
	@Schema(description = "입고일자", example = "", hidden = false, required = true, nullable = false)
	private String budat;

	/**
	 * 입고완료여부(X : 입고완료, 공란 : 미처리)
	 */
	@Schema(description = "입고완료지시자", example = "", hidden = false, required = true, nullable = false)
	private String elikz;
}
