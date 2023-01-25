package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DateValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCoupnBookPblsHstSo
 * @author 김성태
 * @date 2022. 5. 11.
 * @Version 1.0
 * @description CRM쿠폰북발행이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM쿠폰북발행이력 검색 객체")
public class CrmCouponBookSo extends ApiPagination {
	/**
	 * 쿠폰북이력일련번호
	 */
	@Parameter(description = "쿠폰북이력일련번호", example = "", hidden = false, required = false)
	private String coupnBookHstSeq;
	
	@Schema(description = "쿠폰북명", example = "", hidden = false, required = false, maxLength = 100)
	@MaxByte(max = 100)
	private String coupnBookNm;
	
	/**
	 * 멤버십쿠폰기본번호
	 */
	@Parameter(description = "쿠폰마스터번호", example = "", hidden = false, required = false)
	private String mshipCoupnBasNo;
	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "", hidden = false, required = false)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 전표번호
	 */
	@Parameter(description = "전표번호", example = "", hidden = false, required = false)
	private String chitNo;
	/**
	 * 매장번호
	 */
	@Parameter(description = "매장번호", example = "", hidden = false, required = false)
	private String storNo;
	/**
	 * 결제금액
	 */
	@Parameter(description = "결제금액", example = "", hidden = true, required = false)
	private Integer payAmt;
	/**
	 * 구매일시
	 */
	@Parameter(description = "구매일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String buyDt;
	/**
	 * 구매수량
	 */
	@Parameter(description = "구매수량", example = "", hidden = true, required = false)
	private Integer buyQnty;
	/**
	 * 사용시작년월일
	 */
	@Parameter(description = "사용시작년월일", example = "", hidden = true, required = false)
	private String useStaYmd;
	/**
	 * 사용종료년월일
	 */
	@Parameter(description = "사용종료년월일", example = "", hidden = true, required = false)
	private String useEndYmd;

	@Parameter(description = "사용가능기준일", example = "20211212", hidden = true, required = false)
	@DateValue
	private String useStdYmd;

	/**
	 * 삭제여부
	 */
	@Parameter(description = "삭제여부 [Y/N]", example = "", hidden = false, required = false)
	@YnValue
	private String delYn;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;
}
