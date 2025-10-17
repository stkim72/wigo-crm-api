package com.ceragem.api.sap.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosSpcHisItemVo
 * @author 이승빈
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP POS 품목마스터(식음료) 공급가 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 품목마스터(식음료) 공급가 item 객체")
public class SapPosSpcHisItemVo {

	@Schema(description = "품목코드", example = "P00001", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String matnr;

	@Schema(description = "시작일자", example = "20220624", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String zstaDate;

	@Schema(description = "종료일자", example = "20220731", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String zendDate;

	@Schema(description = "공급가", example = "10000", hidden = false, required = true, nullable = false, maxLength = 15)
	@NotEmpty
	private String zcostPrice;

	@Schema(description = "비고", example = "", hidden = false, required = false, nullable = true, maxLength = 255)
	private String znote;

	@Schema(description = "사용 여부", example = "Y", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	private String zuseYn;

	@Schema(description = "등록자 ID", example = "id-0001", hidden = false, required = false, nullable = true, maxLength = 12)
	private String ernam;

	@Schema(description = "등록 일시", example = "20220624", hidden = false, required = false, nullable = true, maxLength = 8)
	private String ersda;

	@Schema(description = "수정자 ID", example = "id-0001", hidden = false, required = false, nullable = true, maxLength = 12)
	private String aenam;

	@Schema(description = "수정 일시", example = "20220624", hidden = false, required = false, nullable = true, maxLength = 8)
	private String laeda;

}
