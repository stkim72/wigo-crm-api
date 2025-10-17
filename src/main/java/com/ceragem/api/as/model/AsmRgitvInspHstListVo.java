package com.ceragem.api.as.model;

import java.math.BigDecimal;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmRgitvInspHstListVo
 * @author 이윤성
 * @date 2022. 6. 17.
 * @Version 1.0
 * @description BOS정기점검 방문 이력 조회 목록 Vo
 */
@Getter
@Setter
@Schema(description = "BOS정기점검 방문 이력 조회 목록 객체")
public class AsmRgitvInspHstListVo extends ApiBaseVo {

	/**
	 * 계약번호
	 */
	@Schema(description = "계약번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String cntrNo;

	/**
	 * 작업구분코드
	 */
	@Schema(description = "작업구분코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String opertSeCd;

	/**
	 * 작업구분명
	 */
	@Schema(description = "작업구분명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String opertSeNm;

	/**
	 * 처리일자
	 */
	@Schema(description = "처리일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String procDe;

	/**
	 * 서비스준수여부
	 */
	@Schema(description = "서비스준수여부", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String serviceYn;

	/**
	 * 처리유형코드
	 */
	@Schema(description = "처리유형코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String procMthCd;

	/**
	 * 처리유형명
	 */
	@Schema(description = "처리유형명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procMthNm;

	/**
	 * 처리팀
	 */
	@Schema(description = "처리팀", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procBhfNm;

	/**
	 * 처리매니저
	 */
	@Schema(description = "처리매니저", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procEngrNm;

	/**
	 * 고객확인
	 */
	@Schema(description = "고객확인", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custCnfirm;

	/**
	 * 품목코드
	 */
	@Schema(description = "품목코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String itemCd;

	/**
	 * 품목 코드(SAP코드)
	 */
	@Schema(description = "품목 코드(SAP코드)", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String baseItemCd;

	/**
	 * 품목명
	 */
	@Schema(description = "품목명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String itemNm;

	/**
	 * 수량
	 */
	@Schema(description = "수량", example = "", hidden = false, required = true, nullable = false)
	private int qy;

	/**
	 * 유무상
	 */
	@Schema(description = "유무상", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String freeCd;

	/**
	 * 처리금액
	 */
	@Schema(description = "처리금액", example = "", hidden = false, required = true, nullable = false)
	private BigDecimal procAmt;

	/**
	 * 접수일자
	 */
	@Schema(description = "접수일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String acptDe;

	/**
	 * 차회예정일자
	 */
	@Schema(description = "차회예정일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String nextDueDe;

	/**
	 * 상담내용
	 */
	@Schema(description = "상담내용", example = "", hidden = false, required = true, nullable = false, maxLength = 2000)
	@MaxByte(max = 2000)
	private String procCslCn;

	/**
	 * 처리자연락처(휴대폰)
	 */
	@Schema(description = "처리자연락처(휴대폰)", example = "", hidden = false, required = true, nullable = false, maxLength = 11)
	@MaxByte(max = 11)
	private String procEngrMobNo;

	/**
	 * 고객구분
	 */
	@Schema(description = "고객구분", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custSe;

	/**
	 * 도착시간
	 */
	@Schema(description = "도착시간", example = "", hidden = false, required = true, nullable = false, maxLength = 4)
	@MaxByte(max = 4)
	private String arvlTime;

	/**
	 * 완료시간
	 */
	@Schema(description = "완료시간", example = "", hidden = false, required = true, nullable = false, maxLength = 4)
	@MaxByte(max = 4)
	private String procTime;

	/**
	 * 예정일자
	 */
	@Schema(description = "예정일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String dueDe;
}
