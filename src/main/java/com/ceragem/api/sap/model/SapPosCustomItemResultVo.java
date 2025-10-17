package com.ceragem.api.sap.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosCustomItemResultVo
 * @author user
 * @date 2022. 6. 27.
 * @Version 1.0
 * @description SAP POS 매장 정보 조회 결과 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 매장 정보 조회 결과 객체")
public class SapPosCustomItemResultVo {

	@Schema(description = "매장 정보 리스트", example = "[]", hidden = false, required = false, nullable = false)
	private List<SapPosCustomItemResultVo> items = null;

	@Schema(description = "처리결과", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	private String msgty;

	@Schema(description = "오류시메세지ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	private String msgid;

	@Schema(description = "오류시메세지번호", example = "", hidden = false, required = true, nullable = false, maxLength = 3)
	private String msgno;

	@Schema(description = "오류시메세지", example = "", hidden = false, required = true, nullable = false, maxLength = 220)
	private String msgtx;
}
