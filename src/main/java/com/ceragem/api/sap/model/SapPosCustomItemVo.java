package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosCustomItemVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP POS 매장 정보 조회 item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP POS 매장 정보 조회 item 객체")
public class SapPosCustomItemVo {

	@Schema(description = "고객", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	private String kunnr;

	@Schema(description = "판매조직", example = "", hidden = false, required = true, nullable = false, maxLength = 4)
	private String vkorg;

	@Schema(description = "사업장", example = "", hidden = false, required = true, nullable = false, maxLength = 4)
	private String vkbur;

	@Schema(description = "지점 구분", example = "", hidden = false, required = true, nullable = false, maxLength = 2)
	private String kdgrp;

	@Schema(description = "이름 1", example = "", hidden = false, required = true, nullable = false, maxLength = 35)
	private String name1;

	@Schema(description = "사업자등록번호", example = "", hidden = false, required = true, nullable = false, maxLength = 11)
	private String stcd2;

	@Schema(description = "개점일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zopen;

	@Schema(description = "폐점일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zclose;

	@Schema(description = "일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	private String erdat;

	@Schema(description = "생성자", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	private String ernam;

	@Schema(description = "변경일", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	private String zaedat;

}
