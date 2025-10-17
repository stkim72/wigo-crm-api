package com.ceragem.api.sap.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsRfndTrtVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP 유상매출 반제처리 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 유상매출 반제처리 객체")
public class SapAsRfndTrtVo {
	@Schema(description = "반제관리번호", example = "20220613001", hidden = false, required = true, nullable = false, maxLength = 11)
	@NotEmpty
	private String rfndadmno;

	@Schema(description = "대금유형", example = "01", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String paytype;

	@Schema(description = "반제처리일자", example = "20210730", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String augdt;

	@Schema(description = "유상매출 반제처리 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapAsRfndTrtItemVo> items = null;
}
