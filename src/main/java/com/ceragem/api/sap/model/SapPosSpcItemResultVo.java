package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosSpcItemResultVo
 * @author 이승빈
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP POS 품목 마스터 결과 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Getter
@Setter
@Schema(description = "SAP POS 품목 마스터 결과 객체")
public class SapPosSpcItemResultVo {

	@Schema(description = "처리결과(S : 성공, E : 오류)", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	private String msgty;

	@Schema(description = "오류시 메세지ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	private String msgid;

	@Schema(description = "오류시 메세지번호", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String msgno;

	@Schema(description = "오류시 메세지", example = "", hidden = false, required = true, nullable = false, maxLength = 220)
	private String msgtx;

}
