package com.ceragem.api.crm.model;

import java.util.List;

import javax.validation.constraints.Min;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DateValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCoupnBookPblsHstVo
 * @author 김성태
 * @date 2022. 5. 11.
 * @Version 1.0
 * @description CRM쿠폰북발행이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM쿠폰북 객체")
public class CrmCouponBookVo extends ApiBaseVo {

	/**
	 * 쿠폰북이력일련번호
	 */
	@Schema(description = "쿠폰북이력일련번호[자동생성]", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String coupnBookHstSeq;
	
	
	@Schema(description = "쿠폰북명", example = "", hidden = false, required = false, maxLength = 100)
	@MaxByte(max = 100)
	private String coupnBookNm;
	
	/**
	 * 멤버십쿠폰기본번호
	 */
	@Schema(description = "멤버십쿠폰기본번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String mshipCoupnBasNo;

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;

	/**
	 * 전표번호
	 */
	@Schema(description = "전표번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String chitNo;
	/**
	 * 매장번호
	 */
	@Schema(description = "매장번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String storNo;
	@Schema(description = "매장명", example = "", hidden = false, required = false, nullable = true,accessMode = AccessMode.READ_ONLY)
	private String storNoNm;
	/**
	 * 결제금액
	 */
	@Schema(description = "결제금액", example = "", hidden = false, required = false, nullable = true)
	private Integer payAmt;
	/**
	 * 구매일시
	 */
	@Schema(description = "구매일시 (YYYYMMDDHH24MISS)", example = "20220511094905", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String buyDt;
	/**
	 * 구매수량
	 */
	@Schema(description = "구매수량", example = "", hidden = false, required = false, nullable = true)
	@Min(value = 1, message = "구매수량은 최소 1개 이상이어야 합니다.")
	private int buyQnty;
	/**
	 * 사용시작년월일
	 */
	@Schema(description = "사용시작년월일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	@DateValue
	private String useStaYmd;
	/**
	 * 사용종료년월일
	 */
	@Schema(description = "사용종료년월일", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	@DateValue
	private String useEndYmd;
	/**
	 * 삭제여부
	 */
	@Schema(description = "삭제여부 [Y/N]", example = "N", hidden = true, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String delYn;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;
	@Schema(description = "등록채널코드명", example = "", hidden = false, required = false, nullable = true,accessMode = AccessMode.READ_ONLY)
	private String regChlCdNm;
	/**
	 * 사용횟수
	 */
	@Schema(description = "사용횟수", example = "1", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private Integer useCnt;

	/**
	 * 잔여횟수
	 */
	@Schema(description = "잔여횟수", example = "1", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private Integer remainCnt;

	/**
	 * 적용횟수
	 */
	@Schema(description = "적용횟수[승인/사용취소시 사용할 갯수]", example = "1", hidden = false, required = false, nullable = true)
	private Integer applyCnt;

	/*
	 * 쿠폰목록
	 */
	@Schema(description = "쿠폰목록", example = "", hidden = false, accessMode = AccessMode.READ_ONLY)
	private List<CrmCouponVo> couponList;

}
