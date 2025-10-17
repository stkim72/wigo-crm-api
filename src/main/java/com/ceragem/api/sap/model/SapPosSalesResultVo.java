package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosSalesResultVo
 * @author user
 * @date 2022. 6. 27.
 * @Version 1.0
 * @description POS 매출 전송(일별/품목별) 결과 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "POS 매출 전송(일별/품목별) 결과 객체")
public class SapPosSalesResultVo {

	@Schema(description = "처리결과(S : 성공, E : 오류)", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	private String msgty;

	@Schema(description = "오류시 메세지ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	private String msgid;

	@Schema(description = "오류시 메세지번호", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String msgno;

	@Schema(description = "오류시 메세지", example = "", hidden = false, required = true, nullable = false, maxLength = 220)
	private String msgtx;

	@Schema(description = "POS 매출 전송(일별/품목별) ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosSalesItemVo> items1 = null;

	@Schema(description = "POS 매출 전송(일별/품목별) ITEM2", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosSalesItem2Vo> items2 = null;

}
