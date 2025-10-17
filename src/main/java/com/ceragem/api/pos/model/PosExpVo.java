package com.ceragem.api.pos.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.as.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName PosExpVo
 * @author 최희원
 * @date 2023. 10. 10.
 * @Version 1.0
 * @description POS 체험대기등록 Vo
 */
@Getter
@Setter
@Schema(description = "POS 체험대기등록 신청 API 수신 객체")
public class PosExpVo {
//
//	/**
//	 * 인터페이스 아이디
//	 */
//	@Schema(description = "인터페이스 아이디", example = "INF_POS_001", hidden = false, required = true, nullable = false, maxLength = 20)
//	@NotEmpty
//	private String interfaceId;
//
//	/**
//	 * 요청 시스템명
//	 */
//	@Schema(description = "요청 시스템명", example = "EXP", hidden = false, required = true, nullable = false, maxLength = 20)
//	@NotEmpty
//	private String requestSystem;
//
	/**
	 * 요청 서버 고유번호
	 */
	@Schema(description = "요청 서버 고유번호", example = "172.23.1.92", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	private String requestHostname;
//
//	/**
//	 * 호출시각
//	 */
//	@Schema(description = "호출시각", example = "2022-01-01T15:10:10Z", hidden = false, required = true, accessMode = AccessMode.READ_ONLY)
//	@NotEmpty
//	private String timestamp = Utilities.getTimeStamp();
//
//	/**
//	 * API 버전 정보
//	 */
//	@Schema(description = "API 버전 정보", example = "1.0", hidden = false, required = true, nullable = false, maxLength = 5)
//	@NotEmpty
//	private String version;
//
//	/**
//	 * 요청 트렌잭션ID
//	 */
//	@Schema(description = "요청 트렌젝션ID", example = "posTransactionManager", hidden = false, required = true, nullable = false, maxLength = 64)
//	@NotEmpty
//	private String transactionId;

	/**
	 * 매장코드
	 */
	@Schema(description = "매장코드", example = "139170", hidden = false, required = true, nullable = false, maxLength = 6)
	@NotEmpty
	@MaxByte(max = 20)
	private String storNo;

	/**
	 * 체험대기날짜
	 */
	@Schema(description = "체험대기날짜", example = "20231115", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	@MaxByte(max = 8)
	private String exprnDt;

	/**
	 * 체험대기제품
	 */
	@Schema(description = "체험대기제품", example = "6", hidden = false, required = false, nullable = true, maxLength = 66)
	@NotEmpty
	@MaxByte(max = 30)
	private String exprnProdCd;

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "CST22082316334653443", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String itgCustNo;

	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "홍길동", hidden = false, required = true, nullable = false, maxLength = 16)
	@NotEmpty
	@MaxByte(max = 50)
	private String custNm;

	/**
	 * 전화번호
	 */
	@Schema(description = "전화번호", example = "01012341234", hidden = false, required = true, nullable = false, maxLength = 88)
	@NotEmpty
	@MaxByte(max = 88)
	private String mphonNo;

	/**
	 * 체험사항
	 */
	@Schema(description = "체험사항", example = "어깨통증이 있는 고객", hidden = false, required = true, nullable = false, maxLength = 166)
	@MaxByte(max = 500)
	private String exprnCtnts;

	/**
	 * 영업조직코드
	 */
	@Schema(description = "영업조직코드", example = "없음", hidden = true, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String salesOrgCd;

	/**
	 * 회사코드
	 */
	@Schema(description = "회사코드", example = "없음", hidden = true, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String cmpCd;

	/**
	 * 언어셋팅
	 */
	@Schema(description = "회사코드", example = "없음", hidden = true, required = true, nullable = false, maxLength = 50)
	@MaxByte(max = 50)
	private String langSetting;

	/**
	 * 체험 예상 대기 시간
	 */
	@Schema(description = "체험 예상 대기 시간", example = "없음", hidden = true, required = true, nullable = false, maxLength = 3)
	private int WAIT_HOUR;

	/**
	 * 체험 예상 대기 시간 get
	 */
	@Schema(description = "체험 예상 대기 시간", example = "1", hidden = true, required = true, nullable = false)
	public int setWAIT_HOUR(int WAIT_HOUR) {
		// TODO Auto-generated method stub
		return WAIT_HOUR;
	}

}
