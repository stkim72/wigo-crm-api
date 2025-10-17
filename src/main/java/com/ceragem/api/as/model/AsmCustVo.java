package com.ceragem.api.as.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.as.validate.MaxByte;
import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @ClassName AsmCustVo
 * @author 이윤성
 * @date 2022. 5. 30.
 * @Version 1.0
 * @description BOS 고객상세조회 Vo
 */
@Getter
@Setter
@Schema(description = "BOS 고객상세조회 객체")
public class AsmCustVo extends ApiBaseVo {

	/**
	 * 고객 주소 리스트
	 */
	@Schema(description = "고객 주소 리스트", example = "[]", hidden = false, required = false, nullable = false)
	private List<AsmCustAddrListVo> addrList = null;

	/**
	 * 고객번호
	 */
	@Schema(description = "고객번호", example = "CU10002946", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	@MaxByte(max = 10)
	private String custNo;

	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;

	/**
	 * 고객 구분 코드
	 */
	@Schema(description = "고객 구분 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String custSeCd;

	/**
	 * 고객 구분
	 */
	@Schema(description = "고객 구분", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custSeNm;

	/**
	 * 고객 유형 코드
	 */
	@Schema(description = "고객 유형 코드  [1 : 개인 , 2 : 법인]", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@CodeValue(codeId = "0000", codes = { "1", "2" }, message = "[1 : 개인 , 2 : 법인] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 10)
	private String custTyCd;

	/**
	 * 고객 유형 명
	 */
	@Schema(description = "고객 유형 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custTyNm;

	/**
	 * 고객 유형 상세 코드
	 */
	@Schema(description = "고객 유형 상세 코드  [1001 : 개인 , 2001 : 개인사업자(2:법인) , 3001 : 법인(2:법인)]", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@CodeValue(codeId = "0000", codes = { "1001", "2001",
			"3001" }, message = "[1001 : 개인 , 2001 : 개인사업자(2:법인) , 3001 : 법인(2:법인)] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 10)
	private String custTyDtlCd;

	/**
	 * 고객 유형 상세 명
	 */
	@Schema(description = "고객 유형 상세 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custTyDtlNm;

	/**
	 * 고객 계약 구분 코드
	 */
	@Schema(description = "고객 계약 구분 코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String custCntrSeCd;

	/**
	 * 고객 계약 구분
	 */
	@Schema(description = "고객 계약 구분", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String custCntrSeNm;

	/**
	 * 성별코드
	 */
	@Schema(description = "성별코드  [F : 여자 , M : 남자]", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@CodeValue(codeId = "0000", codes = { "F", "M" }, message = "[F : 여자 , M : 남자] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 10)
	private String sexCd;

	/**
	 * 성별
	 */
	@Schema(description = "성별", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String sex;

	/**
	 * 생일
	 */
	@Schema(description = "생일", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String bthd;

	/**
	 * 국가코드
	 */
	@Schema(description = "국가코드", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String nationCd;

	/**
	 * 국가명
	 */
	@Schema(description = "국가명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String nationNm;

	/**
	 * 내국인 코드
	 */
	@Schema(description = "내국인 코드  [0 : 내국인 , 1 : 외국인]", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@CodeValue(codeId = "0000", codes = { "0", "1" }, message = "[0 : 내국인 , 1 : 외국인] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 10)
	private String dmstcCd;

	/**
	 * 여권 번호
	 */
	@Schema(description = "여권 번호", example = "", hidden = false, required = true, nullable = false, maxLength = 24)
	@MaxByte(max = 24)
	private String pasportNo;

	/**
	 * 모바일번호
	 */
	@Schema(description = "모바일번호", example = "", hidden = false, required = true, nullable = false, maxLength = 24)
	@MaxByte(max = 24)
	private String mobNo;

	/**
	 * 전화번호
	 */
	@Schema(description = "전화번호", example = "", hidden = false, required = true, nullable = false, maxLength = 24)
	@MaxByte(max = 24)
	private String telNo;

	/**
	 * 직장전화번호
	 */
	@Schema(description = "직장전화번호", example = "", hidden = false, required = true, nullable = false, maxLength = 64)
	@MaxByte(max = 64)
	private String wrcTelNo;

	/**
	 * 이메일
	 */
	@Schema(description = "이메일", example = "", hidden = false, required = true, nullable = false, maxLength = 88)
	@MaxByte(max = 88)
	private String email;

	/**
	 * 사업자 번호
	 */
	@Schema(description = "사업자 번호", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String bsnmNo;

	/**
	 * 회사 명
	 */
	@Schema(description = "회사 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String cmpNm;

	/**
	 * 대표자 명
	 */
	@Schema(description = "대표자 명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@MaxByte(max = 100)
	private String rprsntvNm;

	/**
	 * 회사 규모
	 */
	@Schema(description = "회사 규모", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@MaxByte(max = 10)
	private String cmpScale;

	/**
	 * 업태
	 */
	@Schema(description = "업태", example = "", hidden = false, required = true, nullable = false, maxLength = 200)
	@MaxByte(max = 200)
	private String bizcnd;

	/**
	 * 업종
	 */
	@Schema(description = "업종", example = "", hidden = false, required = true, nullable = false, maxLength = 200)
	@MaxByte(max = 200)
	private String induty;

	/**
	 * 과세 유형 코드
	 */
	@Schema(description = "과세 유형 코드  [1 : 과세 , 2 : 비과세]", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@CodeValue(codeId = "0000", codes = { "1", "2" }, message = "[1 : 과세 , 2 : 비과세] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 10)
	private String taxtTy;

	/**
	 * 최초 가입 일자
	 */
	@Schema(description = "최초 가입 일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String frstSscrDe;

	/**
	 * 가입 일자
	 */
	@Schema(description = "가입 일자", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String sscrDe;

	/**
	 * 비고
	 */
	@Schema(description = "비고", example = "", hidden = false, required = true, nullable = false, maxLength = 200)
	@MaxByte(max = 200)
	private String rm;

	/**
	 * 마케팅 수신 동의 여부
	 */
	@Schema(description = "마케팅 수신 동의 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String marktRcvAgreYn;

	/**
	 * SMS 수신 동의 여부
	 */
	@Schema(description = "SMS 수신 동의 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String smsRcvAgreYn;

	/**
	 * EMAIL 수신 동의 여부
	 */
	@Schema(description = "EMAIL 수신 동의 여부", example = "", hidden = false, required = true, nullable = false, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String emailRcvAgreYn;

	/**
	 * 이름 확인 최종 일시
	 */
	@Schema(description = "이름 확인 최종 일시", example = "", hidden = false, required = true, nullable = false, maxLength = 14)
	@MaxByte(max = 14)
	private String nmCnfirmLastDt;

	/**
	 * SAFEKEY
	 */
	@Schema(description = "SAFEKEY", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@MaxByte(max = 20)
	private String safekey;

	/**
	 * 신용 확인 최종 일시
	 */
	@Schema(description = "신용 확인 최종 일시", example = "", hidden = false, required = true, nullable = false, maxLength = 14)
	@MaxByte(max = 14)
	private String cdtCnfirmLastDt;

	/**
	 * 세금 신고 유형 코드
	 */
	@Schema(description = "세금 신고 유형 코드  [10 : 세금계산서발행 , 20 : 현금영수증 , 30 : 현금영수증 자진신고 , 50 : 미발행]", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@CodeValue(codeId = "0000", codes = { "10", "20", "30",
			"50" }, message = "[10 : 세금계산서발행 , 20 : 현금영수증 , 30 : 현금영수증 자진신고 , 50 : 미발행] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 10)
	private String taxRtnTyCd;

	/**
	 * 개인인증 구분 코드
	 */
	@Schema(description = "개인인증 구분 코드  [11 : 사업자번호 , 13 : 휴대폰번호]", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@CodeValue(codeId = "0000", codes = { "11", "13" }, message = "[11 : 사업자번호 , 13 : 휴대폰번호] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 10)
	private String psnCertSeCd;

	/**
	 * 개인인증 정보
	 */
	@Schema(description = "개인인증 정보 ", example = "", hidden = false, required = true, nullable = false, maxLength = 64)
	@MaxByte(max = 64)
	private String psnCertInfo;

	/**
	 * 현금영수증 발급유형코드
	 */
	@Schema(description = "현금영수증 발급유형코드  [10 : 소득공제 , 11 : 지출증빙 , 12 : 미발행]", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@CodeValue(codeId = "0000", codes = { "10", "11",
			"12" }, message = "[10 : 소득공제 , 11 : 지출증빙 , 12 : 미발행] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 10)
	private String cashrcIssuTyCd;
}
