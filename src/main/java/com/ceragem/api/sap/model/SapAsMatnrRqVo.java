package com.ceragem.api.sap.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapAsMatnrRqVo
 * @author user
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description SAP AS 자재요청 Vo
 * @update 2023.02.22.
 * @Version 1.1
 * @description 서비스마스터아이디, 이름 추가
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "SAP AS 자재요청 객체")
public class SapAsMatnrRqVo {
	@Schema(description = "자재요청번호", example = "20220602141311801", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String intime;

	@Schema(description = "자재요청일자", example = "20220601", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	private String rqdat;

	@Schema(description = "센터번호", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	private String whsno;

	@Schema(description = "센터이름", example = "경기남부", hidden = false, required = true, nullable = false, maxLength = 18)
	@NotEmpty
	private String whsnam;

	@Schema(description = "서비스마스터아이디", example = "0123456789", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	private String masid;

	@Schema(description = "서비스마스터이름", example = "홍길동", hidden = false, required = true, nullable = false, maxLength = 25)
	@NotEmpty
	private String masnam;

	@Schema(description = "저장위치", example = "", hidden = false, required = false, nullable = true, maxLength = 4)
	private String lgort;

	@Schema(description = "요청구분", example = "R", hidden = false, required = true, nullable = false)
	@NotEmpty
	private String flag;

	@Schema(description = "AS 자재요청 ITEM", example = "", hidden = false, required = true, nullable = false)
	private List<SapAsMatnrRqItemVo> items = null;
}
