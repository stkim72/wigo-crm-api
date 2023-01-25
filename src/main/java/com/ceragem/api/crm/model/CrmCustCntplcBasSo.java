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
 * @ClassName CrmCustCntplcBasSo
 * @author 김성태
 * @date 2022. 4. 12.
 * @Version 1.0
 * @description CRM고객연락처기본 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객연락처기본 검색 객체")
public class CrmCustCntplcBasSo extends CrmSnstvInfoInqrySo {

	/**
	 * 연락처일련번호
	 */
	@Schema(description = "연락처일련번호", example = "", hidden = true, required = false)
	@Parameter(description = "연락처일련번호", example = "", hidden = true, required = false)
	private String cntplcSeq;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "CST22041210355401087", hidden = false, required = false)
	@Parameter(description = "통합고객번호", example = "CST22041210355401087", hidden = false, required = false)
	@NotEmpty
	private String itgCustNo;
	/**
	 * 연락처유형코드 공통코드 : CU300 [001 : 설치장소 , 002 : 직장 , 003 : 자택 , 004 : 휴대전화]
	 */
	@Schema(description = "연락처유형코드  [001 : 설치장소 , 002 : 직장 , 003 : 자택 , 004 : 휴대전화]", example = "004", hidden = false, required = false)
	@Parameter(description = "연락처유형코드  [001 : 설치장소 , 002 : 직장 , 003 : 자택 , 004 : 휴대전화]", example = "004", hidden = false, required = false)
	@CodeValue(codeId = "CU300", codes = { "001", "002", "003",
			"004" }, message = "[001 : 설치장소 , 002 : 직장 , 003 : 자택 , 004 : 휴대전화] 등록된 코드가 아닙니다. ")
	private String cntplcTypeCd;
	/**
	 * 대표연락처여부
	 */
	@Parameter(description = "대표연락처여부 [Y/N]", example = "N", hidden = false, required = false)
	@Schema(description = "대표연락처여부 [Y/N]", example = "N", hidden = false, required = false)
	@YnValue
	private String repCntplcYn;
	/**
	 * 전화번호
	 */
	@Parameter(description = "전화번호", example = "01012345678", hidden = false, required = false)
	@Schema(description = "전화번호", example = "01012345678", hidden = false, required = false)
	private String telNo;
//	/**
//	 * 전화번호암호화값
//	 */
//	@Parameter(description = "전화번호암호화값", example = "", hidden = true, required = false)
//	@Schema(description = "전화번호암호화값", example = "", hidden = true, required = false)
//	private String telNoEncVal;
	/**
	 * 전화뒤자리번호
	 */
	@Parameter(description = "전화뒤자리번호", example = "5678", hidden = false, required = false)
	@Schema(description = "전화뒤자리번호", example = "5678", hidden = false, required = false)
	private String telBkDgtNo;
	/**
	 * 지역코드 공통코드 : CU100 [42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 ,
	 * 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시
	 * , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 ,
	 * 99 : 기타]
	 */
	@Parameter(description = "지역코드  [42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 , 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시 , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 , 99 : 기타]", example = "42", hidden = false, required = false)
	@Schema(description = "지역코드  [42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 , 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시 , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 , 99 : 기타]", example = "42", hidden = false, required = false, maxLength = 3)
	@CodeValue(codeId = "CU100", codes = { "42", "41", "48", "47", "29", "27", "30", "26", "11", "36", "31", "28", "46",
			"45", "50", "44", "43",
			"99" }, message = "[42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 , 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시 , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 , 99 : 기타] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String distrctCd;
	/**
	 * 우편번호
	 */
	@Parameter(description = "우편번호", example = "", hidden = true, required = false)
	@Schema(description = "우편번호", example = "", hidden = true, required = false)
	private String zipCd;
	/**
	 * 주소1내용
	 */
	@Parameter(description = "주소1내용", example = "", hidden = true, required = false)
	@Schema(description = "주소1내용", example = "", hidden = true, required = false)
	private String addr1Ctnts;
	/**
	 * 주소2내용
	 */
	@Parameter(description = "주소2내용", example = "", hidden = true, required = false)
	@Schema(description = "주소2내용", example = "", hidden = true, required = false)
	private String addr2Ctnts;
	/**
	 * 이메일주소
	 */
	@Parameter(description = "이메일주소", example = "", hidden = false, required = false)
	@Schema(description = "이메일주소", example = "", hidden = false, required = false)
	private String emailAddr;
	/**
	 * 삭제여부
	 */
	@Parameter(description = "삭제여부 [Y/N]", example = "N", hidden = true, required = false)
	@Schema(description = "삭제여부 [Y/N]", example = "N", hidden = true, required = false)
	@YnValue
	private String delYn = "N";
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	private String regChlCd;

	@Parameter(description = "최신여부", example = "Y", hidden = true, required = false)
	@Schema(description = "최신여부", example = "Y", hidden = true, required = false)
	private String lastYn;
}
