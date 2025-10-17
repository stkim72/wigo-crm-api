package com.ceragem.api.as.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmCrmCustReceiveVo
 * @author 이윤성
 * @date 2022. 6. 7.
 * @Version 1.0
 * @description CRM 고객정보수신 Vo
 */
@Getter
@Setter
@Schema(description = "CRM 고객정보수신 객체")
public class AsmCrmCustReceiveVo extends ApiBaseVo {

	/**
	 * 통합고객아이디
	 */
	@Schema(description = "통합고객번호", example = "CST22041210355401087", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	@NotEmpty
	private String itgCustNo;

	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "", hidden = false, required = true, nullable = false)
	private String custNm;

	/**
	 * 고객등급 코드
	 */
	@Schema(description = "고객등급 코드", example = "", hidden = false, required = true, nullable = false)
	private String gradeCd;

	/**
	 * 고객등급
	 */
	@Schema(description = "고객등급", example = "", hidden = false, required = true, nullable = false)
	private String gradeNm;

	/**
	 * 접수채널 코드
	 */
	@Schema(description = "접수채널 코드", example = "", hidden = false, required = true, nullable = false)
	private String submitChlCd;

	/**
	 * 접수채널
	 */
	@Schema(description = "접수채널", example = "", hidden = false, required = true, nullable = false)
	private String submitChlNm;

	/**
	 * 고객구분 코드
	 */
	@Schema(description = "고객구분 코드", example = "", hidden = false, required = true, nullable = false)
	private String custDivCd;

	/**
	 * 고객구분
	 */
	@Schema(description = "고객구분", example = "", hidden = false, required = true, nullable = false)
	private String custDivNm;

	/**
	 * 고객성향 코드
	 */
	@Schema(description = "고객성향 코드", example = "", hidden = false, required = true, nullable = false)
	private String custInclnCd;

	/**
	 * 고객성향
	 */
	@Schema(description = "고객성향", example = "", hidden = false, required = true, nullable = false)
	private String custInclnNm;

	/**
	 * 연락처 (핸드폰)
	 */
	@Schema(description = "연락처 (핸드폰)", example = "", hidden = false, required = true, nullable = false)
	private String mphonNo;

	/**
	 * 연락처 (집)
	 */
	@Schema(description = "연락처 (집)", example = "", hidden = false, required = true, nullable = false)
	private String homeTelNo;

	/**
	 * 연락처 (직장)
	 */
	@Schema(description = "연락처 (직장)", example = "", hidden = false, required = true, nullable = false)
	private String wkplcTelNo;

	/**
	 * 대표번호 구분
	 */
	@Schema(description = "대표번호 구분", example = "", hidden = false, required = true, nullable = false)
	private String smsTgtDivCd;

	/**
	 * 판매점(판매조직) 코드
	 */
	@Schema(description = "판매점(판매조직) 코드", example = "", hidden = false, required = true, nullable = false)
	private String salesOrgCd;

	/**
	 * 판매점(판매조직) 명
	 */
	@Schema(description = "판매점(판매조직) 명", example = "", hidden = false, required = true, nullable = false)
	private String salesOrgNm;

	/**
	 * 주소(우편번호)
	 */
	@Schema(description = "주소(우편번호)", example = "", hidden = false, required = true, nullable = false, maxLength = 5)
	@MaxByte(max = 5)
	private String zipCd;

	/**
	 * 주소(도로명 상세)
	 */
	@Schema(description = "주소(도로명 상세)", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
	@MaxByte(max = 1000)
	private String addr1Ctnts;

	/**
	 * 주소(상세)
	 */
	@Schema(description = "주소(상세)", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
	@MaxByte(max = 1000)
	private String addr2Ctnts;

	/**
	 * 설치우편번호
	 */
	@Schema(description = "설치우편번호", example = "", hidden = false, required = true, nullable = false, maxLength = 5)
	@MaxByte(max = 5)
	private String instllZipCd;

	/**
	 * 설치주소1내용
	 */
	@Schema(description = "설치주소1내용", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
	@MaxByte(max = 1000)
	private String instllAddr1Ctnts;

	/**
	 * 설치주소2내용
	 */
	@Schema(description = "설치주소2내용", example = "", hidden = false, required = true, nullable = false, maxLength = 1000)
	@MaxByte(max = 1000)
	private String instllAddr2Ctnts;

	/**
	 * 상담자사번
	 */
	@Schema(description = "상담자사번", example = "", hidden = false, required = true, nullable = false)
	private String csagEmpId;

	/**
	 * 상담자명
	 */
	@Schema(description = "상담자명", example = "", hidden = false, required = true, nullable = false)
	private String cnslgPrsnEmpNm;

	/**
	 * 상담일시
	 */
	@Schema(description = "상담일시", example = "", hidden = false, required = true, nullable = false)
	private String cnslgYmdhms;
}
