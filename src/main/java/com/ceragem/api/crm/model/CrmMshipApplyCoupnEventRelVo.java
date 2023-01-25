package com.ceragem.api.crm.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipApplyCoupnEventRelVo
 * @author user
 * @date 2022. 5. 13.
 * @Version 1.0
 * @description 맴버십기본정책-이벤트쿠폰정책 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipApplyCoupnEventRelVo extends CrmMshipCoupnBasVo {
	/**
	*
	*/
	public static final long serialVersionUID = 1L;
	/**
	 * 등급쿠폰기본번호
	 */
	private String coupnEventBasNo;
	/**
	 * 이벤트공통코드
	 */
	private String eventComnCd;
	/**
	 * 쿠폰리스트코드
	 */
	private String coupnTypeCd;
	/**
	 * 멤버십정책기본번호
	 */
	private String mshipPlcyBasNo;
	/**
	 * 멤버십쿠폰기본번호
	 */
	private String mshipCoupnBasNo;
	/**
	 * 총지정수
	 */
	private Integer totAppntCnt;
	/**
	 * 일지정수
	 */
	private Integer dayAppntCnt;
	/**
	 * 월지정수
	 */
	private Integer monthAppntCnt;

	private String comnCdNm;
	private Integer todayCpnPlbsCnt;
	private Integer monthCpnPlbsCnt;
	private Integer allCpnPlbsCnt;
	
	private Integer doubleClickChk; // double 클릭 체크

}
