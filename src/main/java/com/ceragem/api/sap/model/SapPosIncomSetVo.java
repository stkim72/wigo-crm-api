package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosIncomSetVo
 * @author 이승빈
 * @date 2022. 8. 1.
 * @Version 1.0
 * @description SAP POS 사업부 입금내역 수신 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "POS 사업부 입금내역 객체")
public class SapPosIncomSetVo {

	@Schema(description = "POS 사업부 입금내역 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosIncomSetItemVo> items = null;

}
