package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipStmpBasSo
 * @author user
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM멤버십스탬프기본 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십스탬프기본 검색 객체")
public class CrmMshipStmpBasSo extends ApiPagination {
	/**
	 * 스탬프발행기본번호
	 */
	@Parameter(description = "스탬프발행기본번호", example = "", hidden = true, required = false)
	private String mshipStmpBasNo;
	/**
	 * 스탬프기본명
	 */
	@Parameter(description = "스탬프기본명", example = "", hidden = true, required = false)
	private String stmpBasNm;
	/**
	 * 스탬프유형코드
	 */
	@Parameter(description = "스탬프유형코드", example = "", hidden = true, required = false)
	private String stmpTypeCd;
	/**
	 * 스탬프이벤트코드
	 */
	@Parameter(description = "스탬프이벤트코드", example = "", hidden = true, required = false)
	private String stmpEventCd;
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
	 * 유효여부
	 */
	@Parameter(description = "유효여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String validYn;
	/**
	 * 유효기간
	 */
	@Parameter(description = "유효기간", example = "", hidden = true, required = false)
	private String validPerd;
	/**
	 * 스탬프최대여부
	 */
	@Parameter(description = "스탬프최대여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String stmpMaxYn;
	/**
	 * 스탬프최대수
	 */
	@Parameter(description = "스탬프최대수", example = "", hidden = true, required = false)
	private Integer stmpMaxCnt;
	/**
	 * 스탬프수량
	 */
	@Parameter(description = "스탬프수량", example = "", hidden = true, required = false)
	private Integer stmpQnty;
	/**
	 * 사용여부
	 */
	@Parameter(description = "사용여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String useYn;
	/**
	 * 조건여부
	 */
	@Parameter(description = "조건여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String condYn;
	/**
	 * 조건금액
	 */
	@Parameter(description = "조건금액", example = "", hidden = true, required = false)
	private Integer condAmt;
	/**
	 * 쿠폰적립할인여부
	 */
	@Parameter(description = "쿠폰적립할인여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String coupnAccumDcYn;
	/**
	 * 적립수
	 */
	@Parameter(description = "적립수", example = "", hidden = true, required = false)
	private Integer accumCnt;
	/**
	 * 주문여부
	 */
	@Parameter(description = "주문여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String ordrYn;
	/**
	 * 주문금액
	 */
	@Parameter(description = "주문금액", example = "", hidden = true, required = false)
	private Integer ordrAmt;
	/**
	 * 적립매장내역
	 */
	@Parameter(description = "적립매장내역", example = "", hidden = true, required = false)
	private String accumStorTxn;
	/**
	 * 조건상품내역
	 */
	@Parameter(description = "조건상품내역", example = "", hidden = true, required = false)
	private String condItemTxn;
	/**
	 * 적립채널내역
	 */
	@Parameter(description = "적립채널내역", example = "", hidden = true, required = false)
	private String accumChlTxn;
	/**
	 * 혜택코드
	 */
	@Parameter(description = "혜택코드", example = "", hidden = true, required = false)
	private String bnfitCd;
	/**
	 * 포인트점수
	 */
	@Parameter(description = "포인트점수", example = "", hidden = true, required = false)
	private Integer pointScore;
	/**
	 * 쿠폰번호
	 */
	@Parameter(description = "쿠폰번호", example = "", hidden = true, required = false)
	private String coupnNo;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;
	/**
	 * 멤버십등급코드
	 */
	@Parameter(description = "멤버십등급코드", example = "", hidden = true, required = false)
	private String mshipGradeCd;
	/**
	 * 회원등급코드
	 */
	@Parameter(description = "회원등급코드", example = "", hidden = true, required = false)
	private String mshpGradeCd;
	/**
	 * 제휴회사번호
	 */
	@Parameter(description = "제휴회사번호", example = "", hidden = true, required = false)
	private String cprtCmpNo;
}
