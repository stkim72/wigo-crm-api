package com.ceragem.api.crm.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmPointHstVo
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM포인트이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM적립포인트세목")
public class CrmPointItemVo extends ApiBaseVo {

	/**
	 * 전표번호
	 */	
	@Schema(description = "전표번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String chitNo;
	
	
	
	/**
	 * 구매제품번호
	 */
	@Schema(description = "구매제품번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	@NotEmpty
	private String buyGodsNo;
	/**
	 * 주문금액
	 */
	
	@Schema(description = "주문금액", example = "", hidden = false, required = true, nullable = false)
	private int ordrAmt;

	/**
	 * 적용금액
	 */
	@Schema(description = "포인트적용금액", example = "", hidden = false, required = true, nullable = false)
	private int applyAmt;

	/**
	 * 결제금액
	 */
	@Schema(description = "결제금액", example = "", hidden = false, required = true, nullable = false)
	private int payAmt;

	/**
	 * 적용여부
	
	@Schema(description = "적용여부 [Y/N]", example = "Y", hidden = false, required = true, nullable = false, maxLength = 1)
	@YnValue
	@NotEmpty
	@MaxByte(max = 1)
	private String applyYn;
	 */
	
	/**
	 * 적용여부
	 */
	@Schema(description = "적립여부 [Y/N]", example = "Y", hidden = false, required = true, nullable = false, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String accumYn;
	
	

	@Schema(description = "발생포인트점수 포인트점수가 입력된경우 계산하지 않고 적용", example = "0", hidden = false, required = false, nullable = true)
	private int occurPointScore;
	

	 /**
   * 구매보상승급율 
   */	
	@Schema(description = "구매보상승급점수", example = "", hidden = true, required = false, nullable = true)
   private int buyRewardAdvncmtScore;
   
   /**
   * 구매추천보상승급율 
   */   
	@Schema(description = "구매추천보상승급점수", example = "", hidden = true, required = false, nullable = true)
   private int buyRcmdRewardAdvncmtScore;
   
   /**
   * 구매적립포인트율 
   */
	@Schema(description = "구매적립포인트점수", example = "", hidden = true, required = false, nullable = true)
	private int buyAccumPointScore;
	
	/**
   * 구매추천포인트율 
   */
	@Schema(description = "구매추천포인트점수", example = "", hidden = true, required = false, nullable = true)
	private int buyRcmdPointScore;
	
	

	
	/**
    * 구매추천포인트율 
    */
	@Schema(description = "포인트지급리스트", example = "", hidden = true, required = false, nullable = true)
	private List<CrmPointItemVo> crmPointHsAllList;
	
	/**
    * 구매추천포인트율 
    */
	@Schema(description = "승급지급리스트", example = "", hidden = true, required = false, nullable = true)
	private List<CrmPointItemVo> crmAdvncmtHsAllList;


	
	/**
    * 구매추천포인트율 
    */
	@Schema(description = "포인트지급리스트", example = "", hidden = true, required = false, nullable = true)
	private List<CrmPointItemVo> crmPointHsItemList;
	
	/**
    * 구매추천포인트율 
    */
	@Schema(description = "승급지급리스트", example = "", hidden = true, required = false, nullable = true)
	private List<CrmPointItemVo> crmAdvncmtHsItemList;

	@Schema(description = "통합회원번호", example = "", hidden = true, required = false, nullable = true, maxLength = 30)
	private String itgCustNo;
	
	
	@Schema(description = "포인트이력고유번호", example = "", hidden = true, required = false, nullable = true, maxLength = 30)
	private String buySeq;

	@Schema(description = "추천인통합번호", example = "", hidden = true, required = false, nullable = true, maxLength = 30)
	private String rcmdrCustNo;
	
	@Schema(description = "발행구분코드", example = "", hidden = true, required = false, nullable = true, maxLength = 30)
	private String pblsDivCd;
	
	
	@Schema(description = "추천인회원등급", example = "", hidden = true, required = false, nullable = true)
    private String  rcmdrMshipGradeCd; // 추천인회원등급
	
	
	@Schema(description = "회원등급", example = "", hidden = true, required = false, nullable = true)
    private String mshipGradeCd;
	
	

	/**
	 * 사용포인트점수
	 */
	@Schema(description = "사용포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer usePoint;

	
	
}
