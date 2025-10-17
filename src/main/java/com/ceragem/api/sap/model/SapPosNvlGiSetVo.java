package com.ceragem.api.sap.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosNvlGiSetVo
 * @author 이승빈
 * @date 2022. 7. 4.
 * @Version 1.0
 * @description SAP POS 나비엘)주문 출고 승인, 취소 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 나비엘)주문 출고 승인, 취소 객체")
public class SapPosNvlGiSetVo {
	@Schema(description = "원 일련번호", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	private String zcrmSeqOgn;

	@Schema(description = "일련번호", example = "20220701001", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String zcrmSeq;

	@Schema(description = "회사 코드", example = "1000", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkorg;

	@Schema(description = "채널 코드", example = "9620", hidden = false, required = true, nullable = false, maxLength = 4)
	@NotEmpty
	private String vkbur;

	@Schema(description = "SAP POS 나비엘)주문 출고 승인, 취소 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapPosNvlGiSetItemVo> items = null;

}
