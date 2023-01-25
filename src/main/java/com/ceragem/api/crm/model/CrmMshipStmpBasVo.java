package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipStmpBasVo
 * @author user
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM멤버십스탬프기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십스탬프기본 객체")
public class CrmMshipStmpBasVo extends ApiBaseVo {
	/**
	 * 스탬프발행기본번호
	 */
	@Schema(description = "스탬프발행기본번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String mshipStmpBasNo;
	/**
	 * 스탬프기본명
	 */
	@Schema(description = "스탬프기본명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String stmpBasNm;
	/**
	 * 스탬프유형코드
	 */
	@Schema(description = "스탬프유형코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String stmpTypeCd;
	/**
	 * 스탬프이벤트코드
	 */
	@Schema(description = "스탬프이벤트코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String stmpEventCd;
	/**
	 * FROM사용가능일시
	 */
	@Schema(description = "FROM사용가능일시 (YYYYMMDDHH24MISS)", example = "20220517135655", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String fromUsePossDt;
	/**
	 * TO사용가능일시
	 */
	@Schema(description = "TO사용가능일시 (YYYYMMDDHH24MISS)", example = "20220517135655", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String toUsePossDt;
	/**
	 * 유효여부
	 */
	@Schema(description = "유효여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String validYn;
	/**
	 * 유효기간
	 */
	@Schema(description = "유효기간", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String validPerd;
	/**
	 * 스탬프최대여부
	 */
	@Schema(description = "스탬프최대여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String stmpMaxYn;
	/**
	 * 스탬프최대수
	 */
	@Schema(description = "스탬프최대수", example = "", hidden = false, required = false, nullable = true)
	private Integer stmpMaxCnt;
	/**
	 * 스탬프수량
	 */
	@Schema(description = "스탬프수량", example = "", hidden = false, required = false, nullable = true)
	private Integer stmpQnty;
	/**
	 * 사용여부
	 */
	@Schema(description = "사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String useYn;
	/**
	 * 조건여부
	 */
	@Schema(description = "조건여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String condYn;
	/**
	 * 조건금액
	 */
	@Schema(description = "조건금액", example = "", hidden = false, required = false, nullable = true)
	private Integer condAmt;
	/**
	 * 쿠폰적립할인여부
	 */
	@Schema(description = "쿠폰적립할인여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String coupnAccumDcYn;
	/**
	 * 적립수
	 */
	@Schema(description = "적립수", example = "", hidden = false, required = false, nullable = true)
	private Integer accumCnt;
	/**
	 * 주문여부
	 */
	@Schema(description = "주문여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String ordrYn;
	/**
	 * 주문금액
	 */
	@Schema(description = "주문금액", example = "", hidden = false, required = false, nullable = true)
	private Integer ordrAmt;
	/**
	 * 적립매장내역
	 */
	@Schema(description = "적립매장내역", example = "", hidden = false, required = false, nullable = true)
	private String accumStorTxn;
	/**
	 * 조건상품내역
	 */
	@Schema(description = "조건상품내역", example = "", hidden = false, required = false, nullable = true)
	private String condItemTxn;
	/**
	 * 적립채널내역
	 */
	@Schema(description = "적립채널내역", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String accumChlTxn;
	/**
	 * 혜택코드
	 */
	@Schema(description = "혜택코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String bnfitCd;
	/**
	 * 포인트점수
	 */
	@Schema(description = "포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer pointScore;
	/**
	 * 쿠폰번호
	 */
	@Schema(description = "쿠폰번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String coupnNo;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;
	/**
	 * 멤버십등급코드
	 */
	@Schema(description = "멤버십등급코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String mshipGradeCd;
	/**
	 * 회원등급코드
	 */
	@Schema(description = "회원등급코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String mshpGradeCd;
	/**
	 * 제휴회사번호
	 */
	@Schema(description = "제휴회사번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String cprtCmpNo;
	/**
	 * 총금액
	 */
	@Schema(description = "총금액", example = "", hidden = false, required = false, nullable = true)
	private Integer totAmt;

}
