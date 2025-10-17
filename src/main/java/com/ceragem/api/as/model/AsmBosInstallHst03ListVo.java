package com.ceragem.api.as.model;

import com.ceragem.api.as.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmBosInstallHst03ListVo
 * @author 이윤성
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description BOS설치이력(반환) 목록 Vo
 */
@Getter
@Setter
@Schema(description = "BOS설치이력(반환) 목록 객체")
public class AsmBosInstallHst03ListVo {

	/**
	 * CRM고객번호
	 */
	@Schema(description = "CRM고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String crmCustNo;

	/**
	 * 반환일자
	 */
	@Schema(description = "반환일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String rtnDe;

	/**
	 * 반환시간
	 */
	@Schema(description = "반환시간", example = "", hidden = false, required = true, nullable = false, maxLength = 6)
	@MaxByte(max = 6)
	private String rtnTime;

	/**
	 * 반환접수일자
	 */
	@Schema(description = "반환접수일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String rtnAcptDe;

	/**
	 * 반환지점
	 */
	@Schema(description = "반환지점", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String rtnBhf;

	/**
	 * 반환지점명
	 */
	@Schema(description = "반환지점명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String rtnBhfNm;

	/**
	 * 반환기사
	 */
	@Schema(description = "반환기사", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String rtnEngr;

	/**
	 * 반환기사명
	 */
	@Schema(description = "반환기사명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String rtnEngrNm;

	/**
	 * 계약번호
	 */
	@Schema(description = "계약번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String cntrNo;

	/**
	 * 고객번호
	 */
	@Schema(description = "고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String custNo;

	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;

	/**
	 * 판매구분
	 */
	@Schema(description = "판매구분", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String saleSeNm;

	/**
	 * 본부 구분 명
	 */
	@Schema(description = "본부 구분 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String hqSeNm;

	/**
	 * 품목명
	 */
	@Schema(description = "품목명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String itemNm;

	/**
	 * 제품바코드
	 */
	@Schema(description = "제품바코드", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String prBrcd;

	/**
	 * 확인바코드
	 */
	@Schema(description = "확인바코드", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String cnfirmBrcd;

	/**
	 * 요금코드
	 */
	@Schema(description = "요금코드", example = "", hidden = false, required = true, nullable = false, maxLength = 15)
	@MaxByte(max = 15)
	private String feeCd;

	/**
	 * 가격정책명
	 */
	@Schema(description = "가격정책명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String prcPlcNm;

	/**
	 * 반환사유코드
	 */
	@Schema(description = "반환사유코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String rtnRsnCd;

	/**
	 * 반환사유명
	 */
	@Schema(description = "반환사유명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String rtnRsnNm;

	/**
	 * 모바일 처리 여부
	 */
	@Schema(description = "모바일 처리 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@MaxByte(max = 1)
	private String mobProcYn;

	/**
	 * 고객 확인
	 */
	@Schema(description = "고객 확인", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custCnfirm;

	/**
	 * 첨부 파일 번호
	 */
	@Schema(description = "첨부 파일 번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String atchFileNo;

	/**
	 * 반환 태코드(SD137)
	 */
	@Schema(description = "반환상태코드(SD137)", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String rtnStsCd;

	/**
	 * 고객요청사항
	 */
	@Schema(description = "고객요청사항", example = "", hidden = false, required = true, nullable = false, maxLength = 200)
	@MaxByte(max = 200)
	private String rm;

	/**
	 * 반환기사연락처(휴대폰)
	 */
	@Schema(description = "반환기사연락처(휴대폰)", example = "", hidden = false, required = true, nullable = false, maxLength = 11)
	@MaxByte(max = 11)
	private String rtnEngrMobNo;

	/**
	 * 반환상태명
	 */
	@Schema(description = "반환상태명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String rtnStsCdNm;
}
