package com.ceragem.api.pos.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.base.util.Utilities;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName PosExpResultVo
 * @author 최희원
 * @date 2023. 10. 10.
 * @Version 1.0
 * @description POS 체험대기등록 Vo
 */
@Getter
@Setter
@Schema(description = "POS 체험대기등록 신청 API 송신 객체")
public class PosExpResultVo {

	/**
	 * 인터페이스 아이디
	 */
	@Schema(description = "인터페이스 아이디", example = "INF_POS_001", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String interfaceId;

	/**
	 * 응답 시스템
	 */
	@Schema(description = "응답 시스템", example = "POS", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String responseSystem;

	/**
	 * 응답 서버 고유번호
	 */
	@Schema(description = "응답 서버 고유번호", example = "172.23.1.92", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String responseHostname;

	/**
	 * 호출시각
	 */
	@Schema(description = "호출시각", example = "2022-01-01T15:10:10Z", hidden = false, required = true, accessMode = AccessMode.READ_ONLY)
	@NotEmpty
	private String timestamp = Utilities.getTimeStamp();

	/**
	 * 요청 트렌잭션ID
	 */
	@Schema(description = "요청 트렌젝션ID", example = "posTransactionManager", hidden = false, required = true, nullable = false, maxLength = 64)
	@NotEmpty
	private String transactionId;

	/**
	 * 요청 서버 고유번호
	 */
	@Schema(description = "요청 서버 고유번호", example = "172.23.1.92", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String requestHostname;

	/**
	 * 체험대기번호
	 */
	@Schema(description = "체험대기번호", example = "1", hidden = false, required = false, nullable = true, maxLength = 3)
	@NotEmpty
	@MaxByte(max = 3)
	private String exprnWaitNo;

}
