package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapMaProcessVo
 * @author 이승빈
 * @date 2022. 7. 12.
 * @Version 1.0
 * @description SAP 마일리지 통합 완료 처리 내역 수신 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 마일리지 통합 완료 처리 내역 수신 객체")
public class SapMaProcessVo {

	@Schema(description = "SAP 마일리지 통합 완료 처리 내역 수신 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapMaProcessItemVo> items = null;

}
