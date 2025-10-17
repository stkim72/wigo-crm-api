package com.ceragem.api.as.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmMoReceiveVo
 * @author 이윤성
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description MO서비스 정보수신 Vo
 */
@Getter
@Setter
@Schema(description = "MO서비스 정보수신 객체")
public class AsmMoReceiveVo extends ApiBaseVo {

	/**
	 * 송신전화번호(고객전화번호)
	 */
	@Schema(description = "송신전화번호(고객전화번호)", example = "", hidden = false, required = true, nullable = false)
	@NotEmpty
	private String sendTelNo;

	/**
	 * Mo수신번호(서비스번호)
	 */
	@Schema(description = "Mo수신번호(서비스번호)", example = "", hidden = false, required = true, nullable = false)
	@NotEmpty
	private String receiveServiceNo;

	/**
	 * 수신시각
	 */
	@Schema(description = "수신시각 ", example = "YYYYMMDDHH24MISS", hidden = false, required = true, nullable = false)
	private String receiveHour;

	/**
	 * 이미지개수
	 */
	@Schema(description = "이미지개수", example = "", hidden = false, required = true, nullable = false)
	private int imageCnt;

	/**
	 * 이미지경로(Path1)
	 */
	@Schema(description = "이미지경로(Path1)", example = "", hidden = false, required = true, nullable = false)
	private String imagePath01;

	/**
	 * 이미지경로(Path2)
	 */
	@Schema(description = "이미지경로(Path2)", example = "", hidden = false, required = true, nullable = false)
	private String imagePath02;

	/**
	 * 이미지경로(Path3)
	 */
	@Schema(description = "이미지경로(Path3)", example = "", hidden = false, required = true, nullable = false)
	private String imagePath03;

	/**
	 * 수신문자내용 - BASE64 인코딩문자열
	 */
	@Schema(description = "수신문자내용", example = "", hidden = false, required = false, nullable = true)
	private String receiveSmsCtnts;
}
