package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsCntrStkTransferVo
 * @author user
 * @date 2022. 8. 29.
 * @Version 1.0
 * @description SAP 센터간재고이전 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 센터간재고이전 객체")
public class SapAsCntrStkTransferVo {
	@Schema(description = "기타입출고IF키", example = "13", hidden = false, required = true, nullable = false, maxLength = 30)
	private String ifkey;

	@Schema(description = "플랜트", example = "8000", hidden = false, required = true, nullable = false, maxLength = 4)
	private String werks;

	@Schema(description = "출발지 SAP 창고번호", example = "8107", hidden = false, required = true, nullable = false, maxLength = 4)
	private String lgort;

	@Schema(description = "도착지 SAP 창고번호", example = "8114", hidden = false, required = true, nullable = false, maxLength = 4)
	private String umlgo;

	@Schema(description = "입/출고일자", example = "20220730", hidden = false, required = true, nullable = false, maxLength = 8)
	private String budat;

	@Schema(description = "처리 사유", example = "테스트1", hidden = false, required = true, nullable = false, maxLength = 25)
	private String bktxt;

	@Schema(description = "등록자 ID", example = "user11", hidden = false, required = true, nullable = false, maxLength = 30)
	private String regid;

	@Schema(description = "등록자 성명", example = "이름이다", hidden = false, required = true, nullable = false, maxLength = 20)
	private String regnm;

	@Schema(description = "센터간재고이전 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapAsCntrStkTransferItemVo> items = null;
}
