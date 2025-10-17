package com.ceragem.api.as.model;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmRgitvInspRsltListVo
 * @author 이윤성
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description BOS정기점검 처리 결과 정보조회 목록 Vo
 */
@Getter
@Setter
@Schema(description = "BOS정기점검 처리 결과 정보조회 목록 객체")
public class AsmRgitvInspRsltListVo extends ApiBaseVo {

	/**
	 * 거래일자
	 */
	@Schema(description = "거래일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String procDe;

	/**
	 * 처리시간
	 */
	@Schema(description = "처리시간", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procTime;

	/**
	 * 예정일자
	 */
	@Schema(description = "예정일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String dueDe;

	/**
	 * 처리지점
	 */
	@Schema(description = "처리지점", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procBhf;

	/**
	 * 처리지점명
	 */
	@Schema(description = "처리지점명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procBhfNm;

	/**
	 * 처리기사
	 */
	@Schema(description = "처리기사", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procEngr;

	/**
	 * 처리기사명
	 */
	@Schema(description = "처리기사명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String procEngrNm;

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
	 * CRM고객번호
	 */
	@Schema(description = "CRM고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String crmCustNo;

	/**
	 * 판매구분코드
	 */
	@Schema(description = "판매구분코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String saleSeCd;

	/**
	 * 판매구분
	 */
	@Schema(description = "판매구분", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String saleSeNm;

	/**
	 * 품목코드
	 */
	@Schema(description = "품목코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String itemCd;

	/**
	 * SAP품목코드
	 */
	@Schema(description = "SAP품목코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String baseItemCd;

	/**
	 * 품목명
	 */
	@Schema(description = "품목명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String itemNm;

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
	 * 첨부파일번호
	 */
	@Schema(description = "첨부파일번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@MaxByte(max = 12)
	private String atchFileNo;

	/**
	 * 매출확정여부
	 */
	@Schema(description = "매출확정여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@MaxByte(max = 1)
	private String selngDcsYn;

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
	 * 제품바코드
	 */
	@Schema(description = "제품바코드", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String prBrcd;

	/**
	 * 수량
	 */
	@Schema(description = "수량", example = "", hidden = false, required = true, nullable = false)
	private int qy;

	/**
	 * 차회예정일자
	 */
	@Schema(description = "차회예정일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String nextDueDe;

	/**
	 * 처리상담내용
	 */
	@Schema(description = "처리상담내용", example = "", hidden = false, required = true, nullable = false, maxLength = 2000)
	@MaxByte(max = 2000)
	private String procCslCn;

	/**
	 * 처리시간
	 */
	@Schema(description = "처리시간", example = "", hidden = false, required = true, nullable = false)
	private String serviceTime;

	/**
	 * 서비스준수여부
	 */
	@Schema(description = "서비스준수여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@MaxByte(max = 1)
	private String serviceYn;

	/**
	 * 도착시간
	 */
	@Schema(description = "도착시간", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String arvlTime;

	/**
	 * 완료시간
	 */
	@Schema(description = "완료시간", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String endTime;
}
