package com.ceragem.api.as.model;

import com.ceragem.api.as.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmBosInstallHst01ListVo
 * @author 이윤성
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description BOS설치이력(신규설치) 목록 Vo
 */
@Getter
@Setter
@Schema(description = "BOS설치이력(신규설치) 목록 객체")
public class AsmBosInstallHst01ListVo {

	/**
	 * CRM고객번호
	 */
	@Schema(description = "CRM고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String crmCustNo;

	/**
	 * 설치일자(계약시작일)
	 */
	@Schema(description = "설치일자(계약시작일)", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String istDe;

	/**
	 * 설치시간
	 */
	@Schema(description = "설치시간", example = "", hidden = false, required = true, nullable = false, maxLength = 6)
	@MaxByte(max = 6)
	private String istTime;

	/**
	 * 주문일자
	 */
	@Schema(description = "주문일자", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String ordDe;

	/**
	 * 설치지점코드
	 */
	@Schema(description = "설치지점코드", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String istBhfCd;

	/**
	 * 설치지점명
	 */
	@Schema(description = "설치지점명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String istBhfNm;

	/**
	 * 설치기사
	 */
	@Schema(description = "설치기사", example = "", hidden = false, required = true, nullable = false, maxLength = 9)
	@MaxByte(max = 9)
	private String istEngr;

	/**
	 * 설치기사명
	 */
	@Schema(description = "설치기사명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String istEngrNm;

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
	 * 판매구분코드
	 */
	@Schema(description = "판매구분코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String saleSe;

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
	 * 첨부파일번호
	 */
	@Schema(description = "첨부파일번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String afileNo;

	/**
	 * 모바일처리여부
	 */
	@Schema(description = "모바일처리여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@MaxByte(max = 1)
	private String mobProcYn;

	/**
	 * 고객확인
	 */
	@Schema(description = "고객확인", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custCnfirm;

	/**
	 * 고객SIGN번호
	 */
	@Schema(description = "고객SIGN번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String custSign;

	/**
	 * 부품코드
	 */
	@Schema(description = "부품코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String partCd;

	/**
	 * 부품명
	 */
	@Schema(description = "부품명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String partNm;

	/**
	 * 확인바코드
	 */
	@Schema(description = "확인바코드", example = "", hidden = false, required = true, nullable = false, maxLength = 23)
	@MaxByte(max = 23)
	private String confirmBrcd;

	/**
	 * 수량
	 */
	@Schema(description = "수량", example = "", hidden = false, required = true, nullable = false)
	private int qy;

	/**
	 * 판매구분
	 */
	@Schema(description = "판매구분", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String saleSeNm;

	/**
	 * 지역
	 */
	@Schema(description = "지역", example = "", hidden = false, required = true, nullable = false, maxLength = 300)
	@MaxByte(max = 300)
	private String addr;

	/**
	 * 모바일번호
	 */
	@Schema(description = "모바일번호", example = "", hidden = false, required = true, nullable = false, maxLength = 24)
	@MaxByte(max = 24)
	private String mobNo;

	/**
	 * 예정일자
	 */
	@Schema(description = "예정일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String dueDe;

	/**
	 * 설치기사연락처(휴대폰)
	 */
	@Schema(description = "설치기사연락처(휴대폰)", example = "", hidden = false, required = true, nullable = false, maxLength = 11)
	@MaxByte(max = 11)
	private String istEngrMobNo;
}
