package com.ceragem.api.sap.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsGrGiTrtVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP 입/출고처리 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP 입/출고처리 객체")
public class SapAsGrGiTrtVo {
	@Schema(description = "기타입출고 IF키", example = "13", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	private String ifkey;

	@Schema(description = "입/출고구분", example = "GR", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String mbtyp;

	@Schema(description = "이동유형", example = "501", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	private String bwart;

	@Schema(description = "입/출고일자", example = "20210730", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String budat;

	@Schema(description = "처리사유", example = "테스트1", hidden = false, required = false, nullable = true, maxLength = 25)
	private String bktxt;

	@Schema(description = "등록자ID", example = "user11", hidden = false, required = false, nullable = true, maxLength = 30)
	private String regid;

	@Schema(description = "등록자 성명", example = "이름이다", hidden = false, required = false, nullable = true, maxLength = 20)
	private String regnm;

	@Schema(description = "입/출고처리 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapAsGrGiTrtItemVo> items = null;
}
