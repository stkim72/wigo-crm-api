package com.ceragem.api.pos.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.as.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName PosExpCustListVo
 * @author 최희원
 * @date 2023. 10. 10.
 * @Version 1.0
 * @description POS 체험대기등록 Vo
 */
@Getter
@Setter
@Schema(description = "POS 체험대기등록 조회 고객대기목록 객체")
public class PosExpCustListVo {

	/**
	 * 매장코드
	 */
	@Schema(description = "매장코드", example = "139170", hidden = false, required = true, nullable = false, maxLength = 6)
	@NotEmpty
	@MaxByte(max = 20)
	private String storNo;

	/**
	 * 체험대기번호
	 */
	@Schema(description = "체험대기번호", example = "1", hidden = false, required = false, nullable = true, maxLength = 10)
	@NotEmpty
	@MaxByte(max = 3)
	private String exprnWaitNo;

	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "홍길동", hidden = false, required = false, nullable = true, maxLength = 16)
	@NotEmpty
	@MaxByte(max = 50)
	private String custNm;

	/**
	 * 전화번호
	 */
	@Schema(description = "전화번호", example = "01012341234", hidden = false, required = false, nullable = true, maxLength = 88)
	@NotEmpty
	@MaxByte(max = 88)
	private String mphonNo;

	/**
	 * 대기경과시간
	 */
	@Schema(description = "대기경과시간", example = "1", hidden = false, required = false, nullable = true, maxLength = 10)
	@NotEmpty
	@MaxByte(max = 4)
	private String exprnWaitTime;

	/**
	 * 체험기기
	 */
	@Schema(description = "체험기기", example = "Master V4", hidden = false, required = false, nullable = true, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 200)
	private String exprnProdNm;

	/**
	 * 고객요청사항
	 */
	@Schema(description = "고객요청사항", example = "어깨통증이 있는 고객", hidden = false, required = false, nullable = true, maxLength = 100)
	@NotEmpty
	@MaxByte(max = 500)
	private String exprnCtnts;

}
