package com.ceragem.api.as.model;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.crm.validate.DateValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmBosInstallHstListVo
 * @author 이윤성
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description BOS설치이력(Merge) 목록 Vo
 */
@Getter
@Setter
@Schema(description = "BOS설치이력(Merge) 목록 객체")
public class AsmBosInstallHstListVo {

	/**
	 * 설치이력구분 (제품교환 , 신규설치 , 반환)
	 */
	@Schema(description = "", example = "설치이력구분 (제품교환 , 신규설치 , 반환)", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String installHstDiv;

	/**
	 * 접수일자
	 */
	@Schema(description = "접수일자", example = "", hidden = false, required = true, nullable = false)
	@DateValue
	private String strRegDt;

	/**
	 * 처리일자(교환:거래일자, 설치:설치일자, 반환:반환일자)
	 */
	@Schema(description = "처리일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String procDe;

	/**
	 * 처리시간(교환:처리시간, 설치:설치시간, 반환:반환시간)
	 */
	@Schema(description = "처리시간", example = "", hidden = false, required = true, nullable = false, maxLength = 6)
	@MaxByte(max = 6)
	private String procTime;

	/**
	 * 처리지점 (교환:처리지점, 설치:설치지점코드, 반환:반환지점)
	 */
	@Schema(description = "처리지점", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String procBhf;

	/**
	 * 처리지점명 (교환:처리지점명, 설치:설치지점명, 반환:반환지점명)
	 */
	@Schema(description = "처리지점명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procBhfNm;

	/**
	 * 처리기사
	 */
	@Schema(description = "처리기사", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String procEngr;

	/**
	 * 처리기사명
	 */
	@Schema(description = "처리기사명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procEngrNm;

	/**
	 * (휴대폰)설치기사연락처 (교환:처리기사, 설치:설치기사, 반환:반환기사)
	 */
	@Schema(description = "(휴대폰)설치기사연락처", example = "", hidden = false, required = true, nullable = false, maxLength = 11)
	@MaxByte(max = 11)
	private String istEngrMobNo;

	/**
	 * 계약번호
	 */
	@Schema(description = "계약번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String cntrNo;

	/**
	 * 판매구분코드
	 */
	@Schema(description = "판매구분코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String saleSe;

	/**
	 * 판매구분명
	 */
	@Schema(description = "판매구분명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String saleSeNm;

	/**
	 * 요금코드
	 */
	@Schema(description = "요금코드", example = "", hidden = false, required = true, nullable = false, maxLength = 15)
	@MaxByte(max = 15)
	private String feeCd;

	/**
	 * 가격정책명(요금제명)
	 */
	@Schema(description = "가격정책명(요금제명)", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String prcPlcNm;

	/**
	 * 설치S/N (교환:설치품목시리얼, 설치:상품바코드, 반환:제품바코드)
	 */
	@Schema(description = "설치S/N", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String prBrcd;

	/**
	 * 회수 S/N (교환:반환품목시리얼, 설치:N/A, 반환:확인바코드)
	 */
	@Schema(description = "회수S/N", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String cnfirmBrcd;

	/**
	 * 반환상태코드(SD137)
	 */
	@Schema(description = "반환상태코드(SD137)", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String rtnStsCd;

	/**
	 * 반환상태명
	 */
	@Schema(description = "반환상태명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String rtnStsCdNm;

	/**
	 * 접수유형
	 */
	@Schema(description = "접수유형", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String acptTyDtlNm;

	/**
	 * 처리유형상세명
	 */
	@Schema(description = "처리유형상세명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procTyDtlNm;

	/**
	 * 고객요청사항
	 */
	@Schema(description = "고객요청사항", example = "", hidden = false, required = true, nullable = false, maxLength = 200)
	@MaxByte(max = 200)
	private String rm;
	/**
	 * 설치 S/N (교환)
	 */
	@Schema(description = "설치S/N", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String istPrBrcd;
	/**
	 * 회수 S/N (교환)
	 */
	@Schema(description = "회수S/N", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String rtnPrBrcd;
}
