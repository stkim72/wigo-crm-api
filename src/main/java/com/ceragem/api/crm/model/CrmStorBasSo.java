package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmStorBasSo
 * @author 김성태
 * @date 2022. 5. 24.
 * @Version 1.0
 * @description CRM매장기본 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM매장기본 검색 객체")
public class CrmStorBasSo extends ApiPagination {
	/**
	 * 매장번호
	 */
	@Parameter(description = "매장번호", example = "", hidden = true, required = false)
	private String storNo;
	/**
	 * 매장명
	 */
	@Parameter(description = "매장명", example = "", hidden = true, required = false)
	private String storNm;
	/**
	 * 전화번호
	 */
	@Parameter(description = "전화번호", example = "", hidden = true, required = false)
	private String telNo;
	/**
	 * 우편번호
	 */
	@Parameter(description = "우편번호", example = "", hidden = true, required = false)
	private String zipCd;
	/**
	 * 주소1내용
	 */
	@Parameter(description = "주소1내용", example = "", hidden = true, required = false)
	private String addr1Ctnts;
	/**
	 * 주소2내용
	 */
	@Parameter(description = "주소2내용", example = "", hidden = true, required = false)
	private String addr2Ctnts;
	/**
	 * 위도
	 */
	@Parameter(description = "위도", example = "", hidden = true, required = false)
	private String lati;
	/**
	 * 경도
	 */
	@Parameter(description = "경도", example = "", hidden = true, required = false)
	private String longi;
	/**
	 * 지역코드
	 */
	@Parameter(description = "지역코드", example = "", hidden = true, required = false)
	private String distrctCd;
	/**
	 * 시작시간
	 */
	@Parameter(description = "시작시간", example = "", hidden = true, required = false)
	private String staHour;
	/**
	 * 종료시간
	 */
	@Parameter(description = "종료시간", example = "", hidden = true, required = false)
	private String endHour;
	/**
	 * 사업자등록번호
	 */
	@Parameter(description = "사업자등록번호", example = "", hidden = true, required = false)
	private String bizNo;
	/**
	 * 오픈일자
	 */
	@Parameter(description = "오픈일자", example = "", hidden = true, required = false)
	private String openDate;
	/**
	 * POS매장번호
	 */
	@Parameter(description = "POS매장번호", example = "", hidden = true, required = false)
	private String posStorNo;
	/**
	 * 매장채널코드
	 */
	@Parameter(description = "매장채널코드", example = "", hidden = true, required = false)
	private String storChlCd;
	/**
	 * 매장구분코드
	 */
	@Parameter(description = "매장구분코드", example = "", hidden = true, required = false)
	private String storDivCd;
	/**
	 * 매장유형코드
	 */
	@Parameter(description = "매장유형코드", example = "", hidden = true, required = false)
	private String storTypeCd;
	/**
	 * 매장상태코드
	 */
	@Parameter(description = "매장상태코드", example = "", hidden = true, required = false)
	private String storStatusCd;
	/**
	 * 메모내용
	 */
	@Parameter(description = "메모내용", example = "", hidden = true, required = false)
	private String memoCtnts;
	/**
	 * 상태코드
	 */
	@Parameter(description = "상태코드", example = "", hidden = true, required = false)
	private String statusCd;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	private String regChlCd;
}
