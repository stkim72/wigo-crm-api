package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCardPblsHstVo
 * @author 김성태
 * @date 2022. 4. 26.
 * @Version 1.0
 * @description CRM카드발행이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM카드발행이력 객체")
public class CrmCardPblsHstVo extends CrmMshipCardBasVo {
	/**
	 * 카드발행이력일련번호
	 */
	@Schema(description = "카드발행이력일련번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String cardPblsHstSeq;

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;

	/**
	 * 회원명
	 */
	@Schema(description = "회원명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String mshpNm;
	/**
	 * 이동전화번호
	 */
	@Schema(description = "이동전화번호", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String mphonNo;
	/**
	 * 멤버십등급코드 공통코드 : MB020 [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드
	 * , 006 : VIP]
	 */
	@Schema(description = "멤버십등급코드  [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "MB020", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String mshipGradeCd;
	@Schema(description = "멤버십등급코드명", example = "", hidden = false, required = false, nullable = true)
	private String mshipGradeCdNm;
	/**
	 * FROM사용가능일시
	 */
	@Schema(description = "FROM사용가능일시 (YYYYMMDDHH24MISS)", example = "20220426102512", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String fromUsePossDt;
	/**
	 * TO사용가능일시
	 */
	@Schema(description = "TO사용가능일시 (YYYYMMDDHH24MISS)", example = "20220426102512", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String toUsePossDt;
	/**
	 * 포인트적립율
	 */
	@Schema(description = "포인트적립율", example = "", hidden = false, required = false, nullable = true)
	private Integer pointAccumRate;
	/**
	 * 가입포인트점수
	 */
	@Schema(description = "가입포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer sbscPointScore;
	/**
	 * 승급포인트점수
	 */
	@Schema(description = "승급포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer advncmtPointScore;
	/**
	 * 음료할인율
	 */
	@Schema(description = "음료할인율", example = "", hidden = false, required = false, nullable = true)
	private Integer drnkDcRate;
	/**
	 * 일음료제공수
	 */
	@Schema(description = "일음료제공수", example = "", hidden = false, required = false, nullable = true)
	private Integer dayDrnkPrvCnt;
	/**
	 * 음료제공수
	 */
	@Schema(description = "음료제공수", example = "", hidden = false, required = false, nullable = true)
	private Integer drnkPrvCnt;
	/**
	 * 자사몰무료배송여부
	 */
	@Schema(description = "자사몰무료배송여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String mycomMallFreeDlvYn;
	/**
	 * 음료무료적용스탬프수
	 */
	@Schema(description = "음료무료적용스탬프수", example = "", hidden = false, required = false, nullable = true)
	private Integer drnkFreeApplyStmpCnt;
	/**
	 * 무료서비스연장개월수
	 */
	@Schema(description = "무료서비스연장개월수", example = "", hidden = false, required = false, nullable = true)
	private Integer freeSvcExtnsnMonsCnt;
	/**
	 * 세라케어쿠폰제공개월수
	 */
	@Schema(description = "세라케어쿠폰제공개월수", example = "", hidden = false, required = false, nullable = true)
	private Integer ceracCoupnPrvMonsCnt;
	/**
	 * 세라체크쿠폰제공개월수
	 */
	@Schema(description = "세라체크쿠폰제공개월수", example = "", hidden = false, required = false, nullable = true)
	private Integer crckCoupnPrvMonsCnt;
	/**
	 * 제품제한여부
	 */
	@Schema(description = "제품제한여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String godsRstrtnYn;
//	/**
//	 * 상태코드
//	 */
//	@Schema(description = "상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
//	@MaxByte(max = 3)
//	private String statusCd;
	/**
	 * 인증번호
	 */
	@Schema(description = "인증번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String certfNo;
	/**
	 * 인증일시
	 */
	@Schema(description = "인증일시 (YYYYMMDDHH24MISS)", example = "20220426102512", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String certfDt;
	/**
	 * 사용여부
	 */
	@Schema(description = "사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String useYn;
	/**
	 * 카드구분코드 공통코드 : CD020 [001 : 멤버십 , 002 : 제휴 , 003 : 회원]
	 */
	@Schema(description = "카드구분코드  [001 : 멤버십 , 002 : 제휴 , 003 : 회원]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "CD020", codes = { "001", "002",
			"003" }, message = "[001 : 멤버십 , 002 : 제휴 , 003 : 회원] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String cardDivCd;

	@Schema(description = "카드번호", example = "", hidden = false, required = false, nullable = true)
	public String getCardNo() {
		return cardPblsHstSeq;
	}

	public void setCardNo(String cardNo) {
		this.cardPblsHstSeq = cardNo;
	}
}
