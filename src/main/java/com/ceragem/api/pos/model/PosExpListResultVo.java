package com.ceragem.api.pos.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName PosExpListResultVo
 * @author 최희원
 * @date 2023. 10. 10.
 * @Version 1.0
 * @description POS 체험대기등록 Vo
 */
@Getter
@Setter
@Schema(description = "POS 체험대기등록 조회 API 송신 객체")
public class PosExpListResultVo {

	/**
	 * 인터페이스 아이디
	 */
	@Schema(description = "인터페이스 아이디", example = "INF_POS_002", hidden = false, required = true, nullable = false, maxLength = 20)
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
	 * 요청 서버 고유번호
	 */
	@Schema(description = "요청 서버 고유번호", example = "172.23.1.92", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String requestHostname;

	/**
	 * 요청 트렌잭션ID
	 */
	@Schema(description = "요청 트렌젝션ID", example = "posTransactionManager", hidden = false, required = true, nullable = false, maxLength = 64)
	@NotEmpty
	private String transactionId;

	/**
	 * 고객대기목록
	 */
	@Schema(description = "고객대기목록", example = "", hidden = false, required = false, nullable = false, accessMode = AccessMode.READ_ONLY)
	private List<PosExpCustListVo> contList = null;

}
