package com.ceragem.api.as.model;

import java.util.List;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmSapPrecChitTrmVo
 * @author 이윤성
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description 입금정보/선수금전표 수신 Vo (현금입금, 카드승인 내역중 선수금 전표 생성 내역을 전송(반제되지 않은 건만))
 *
 *              (반제처리 된 이후에 카드승인 취소건은 안넘어감)
 */
@Getter
@Setter
@Schema(description = "입금정보/선수금전표 수신 객체")
public class AsmSapPrecChitTrmVo extends ApiBaseVo {

	/**
	 * 입금정보/선수금전표 수신목록
	 */
	@Schema(description = "입금정보/선수금전표 수신목록", example = "", hidden = false, required = true, nullable = false)
	private List<AsmSapPrecChitTrmListVo> items;
}
