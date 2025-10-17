package com.ceragem.api.crm.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipApplyPointRelVo
 * @author user
 * @date 2022. 5. 15.
 * @Version 1.0
 * @description 맴버십기본정책-이벤트쿠폰정책 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipApplyPointRelVo extends BaseVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * 등급쿠폰기본번호
	 */
	private String eventPointBasNo;
	/**
	 * 이벤트공통코드
	 */
	private String eventComnCd;
	/**
	 * 멤버십정책기본번호
	 */
	private String mshipPlcyBasNo;
	/**
	 * 적립포인트점수
	 */
	private Integer accumPointScore;
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

	/**
	 * 유효기간
	 */
	private String validPerd;

	/* 기간코드 */
	private String validPerdCd;

	/* 유효기간Ymd */
	private String validPerdYmd;

	/**
	 * 선물가능여부
	 */
	private String giftPossYn;

	private String comnCdNm;
	private String mshipmshipPlcyBasNo;

	/**
	 * 통합회원번호
	 */
	private String itgCustNo; // 통합회원번호
	private int todayPntPlbsCnt; // 일지급횟수
	private int monthPntPlbsCnt; // 월지급횟수
	private int allPntPlbsCnt; // 총지급횟수
	private int todayPblsPnt; // 1일 적립한도

	private String pblsDivCd; // 이벤트코드

	private int doubleClickChk; // double 클릭 체크

	private int accumLmtPointScore;

}
