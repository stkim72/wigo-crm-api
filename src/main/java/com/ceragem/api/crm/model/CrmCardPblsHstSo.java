package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCardPblsHstSo
 * @author 김성태
 * @date 2022. 4. 26.
 * @Version 1.0
 * @description CRM카드발행이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM카드발행이력 검색 객체")
public class CrmCardPblsHstSo extends CrmMshipCardBasSo {
	/**
	 * 카드발행이력일련번호
	 */
	@Parameter(description = "카드발행이력일련번호", example = "", hidden = true, required = false)
	private String cardPblsHstSeq;

	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = false, required = true)
	@NotEmpty
	private String itgCustNo;
	/**
	 * 회원명
	 */
	@Parameter(description = "회원명", example = "", hidden = true, required = false)
	private String mshpNm;
	/**
	 * 이동전화번호
	 */
	@Parameter(description = "이동전화번호", example = "", hidden = true, required = false)
	private String mphonNo;
	/**
	 * 멤버십등급코드 공통코드 : MB020 [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드
	 * , 006 : VIP]
	 */
	@Parameter(description = "멤버십등급코드  [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "MB020", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP] 등록된 코드가 아닙니다. ")
	private String mshipGradeCd;
	/**
	 * FROM사용가능일시
	 */
	@Parameter(description = "FROM사용가능일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String fromUsePossDt;
	/**
	 * TO사용가능일시
	 */
	@Parameter(description = "TO사용가능일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String toUsePossDt;
	/**
	 * 포인트적립율
	 */
	@Parameter(description = "포인트적립율", example = "", hidden = true, required = false)
	private Integer pointAccumRate;
	/**
	 * 가입포인트점수
	 */
	@Parameter(description = "가입포인트점수", example = "", hidden = true, required = false)
	private Integer sbscPointScore;
	/**
	 * 가입포인트적용기준코드
	 */
	@Parameter(description = "가입포인트적용기준코드", example = "", hidden = true, required = false)
	private String sbscPointApplyStdCd;
	/**
	 * 승급포인트점수
	 */
	@Parameter(description = "승급포인트점수", example = "", hidden = true, required = false)
	private Integer advncmtPointScore;
	/**
	 * 승급포인트적용기준코드
	 */
	@Parameter(description = "승급포인트적용기준코드", example = "", hidden = true, required = false)
	private String advncmtPointApplyStdCd;
	/**
	 * 음료할인율
	 */
	@Parameter(description = "음료할인율", example = "", hidden = true, required = false)
	private Integer drnkDcRate;
	/**
	 * 일음료제공수
	 */
	@Parameter(description = "일음료제공수", example = "", hidden = true, required = false)
	private Integer dayDrnkPrvCnt;
	/**
	 * 음료제공수
	 */
	@Parameter(description = "음료제공수", example = "", hidden = true, required = false)
	private Integer drnkPrvCnt;
	/**
	 * 자사몰무료배송여부
	 */
	@Parameter(description = "자사몰무료배송여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String mycomMallFreeDlvYn;
	/**
	 * 음료무료적용스탬프수
	 */
	@Parameter(description = "음료무료적용스탬프수", example = "", hidden = true, required = false)
	private Integer drnkFreeApplyStmpCnt;
	/**
	 * 무료서비스연장개월수
	 */
	@Parameter(description = "무료서비스연장개월수", example = "", hidden = true, required = false)
	private Integer freeSvcExtnsnMonsCnt;
	/**
	 * 세라케어쿠폰제공개월수
	 */
	@Parameter(description = "세라케어쿠폰제공개월수", example = "", hidden = true, required = false)
	private Integer ceracCoupnPrvMonsCnt;
	/**
	 * 세라체크쿠폰제공개월수
	 */
	@Parameter(description = "세라체크쿠폰제공개월수", example = "", hidden = true, required = false)
	private Integer crckCoupnPrvMonsCnt;
	/**
	 * 제품제한여부
	 */
	@Parameter(description = "제품제한여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String godsRstrtnYn;
	/**
	 * 상태코드
	 */
	@Parameter(description = "상태코드", example = "", hidden = true, required = false)
	private String statusCd;
	/**
	 * 인증번호
	 */
	@Parameter(description = "인증번호", example = "", hidden = true, required = false)
	private String certfNo;
	/**
	 * 인증일시
	 */
	@Parameter(description = "인증일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String certfDt;
	/**
	 * 사용여부
	 */
	@Parameter(description = "사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String useYn;
	/**
	 * 카드구분코드 공통코드 : CD020 [001 : 멤버십 , 002 : 제휴 , 003 : 회원]
	 */
	@Parameter(description = "카드구분코드  [001 : 멤버십 , 002 : 제휴 , 003 : 회원]", example = "001", hidden = false, required = false)
	@CodeValue(codeId = "CD020", codes = { "001", "002",
			"003" }, message = "[001 : 멤버십 , 002 : 제휴 , 003 : 회원] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String cardDivCd;

	@Parameter(description = "카드번호", example = "", hidden = false, required = false)
	public String getCardNo() {
		return cardPblsHstSeq;
	}

	public void setCardNo(String cardNo) {
		this.cardPblsHstSeq = cardNo;
	}

}
