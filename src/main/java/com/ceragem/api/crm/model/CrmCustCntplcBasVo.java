package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import javax.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

import com.ceragem.api.crm.validate.YnValue;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCustCntplcBasVo
 * @author 김성태
 * @date 2022. 4. 12.
 * @Version 1.0
 * @description CRM고객연락처기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객연락처기본 객체")
public class CrmCustCntplcBasVo extends ApiBaseVo {
	/**
	 * 연락처일련번호
	 */
	@Schema(description = "연락처일련번호[자동생성]", example = "CNT22041212050001174", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String cntplcSeq;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "CST22041210355401087", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	@NotEmpty
	private String itgCustNo;
	/**
	 * 연락처유형코드 공통코드 : CU300 [001 : 설치장소 , 002 : 직장 , 003 : 자택 , 004 : 휴대전화]
	 */
	@Schema(description = "연락처유형코드  [001 : 설치장소 , 002 : 직장 , 003 : 자택 , 004 : 휴대전화]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "CU300", codes = { "001", "002", "003",
			"004" }, message = "[001 : 설치장소 , 002 : 직장 , 003 : 자택 , 004 : 휴대전화] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String cntplcTypeCd;
	@Schema(description = "연락처유형코드명")
	private String cntplcTypeCdNm;
	/**
	 * 대표연락처여부
	 */
	@Schema(description = "대표연락처여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String repCntplcYn;
	/**
	 * 전화번호
	 */
	@Schema(description = "전화번호", example = "01012345678", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	@NotEmpty
	private String telNo;
	/**
	 * 전화번호암호화값
	 */
	@Schema(description = "전화번호암호화값", example = "", hidden = true, required = true, nullable = false, maxLength = 10004, accessMode = AccessMode.READ_ONLY)
	@MaxByte(max = 1000)
	private String telNoEncVal;
	/**
	 * 전화뒤자리번호
	 */
	@Schema(description = "전화뒤자리번호", example = "", hidden = false, required = false, nullable = true, maxLength = 4, accessMode = AccessMode.READ_ONLY)
	@MaxByte(max = 4)
	private String telBkDgtNo;
	/**
	 * 지역코드 공통코드 : CU100 [42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 ,
	 * 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시
	 * , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 ,
	 * 99 : 기타]
	 */
	@Schema(description = "지역코드  [42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 , 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시 , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 , 99 : 기타]", example = "42", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "CU100", codes = { "42", "41", "48", "47", "29", "27", "30", "26", "11", "36", "31", "28", "46",
			"45", "50", "44", "43",
			"99" }, message = "[42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 , 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시 , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 , 99 : 기타] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String distrctCd;
	/**
	 * 지역코드명
	 */
	@Schema(description = "지역코드명", example = "서울")
	private String distrctCdNm;

	/**
	 * 우편번호
	 */
	@Schema(description = "우편번호", example = "", hidden = false, required = false, nullable = true, maxLength = 5)
	@MaxByte(max = 5)
	private String zipCd;
	/**
	 * 주소1내용
	 */
	@Schema(description = "주소1내용", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String addr1Ctnts;
	/**
	 * 주소2내용
	 */
	@Schema(description = "주소2내용", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String addr2Ctnts;
	/**
	 * 이메일주소
	 */
	@Schema(description = "이메일주소", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String emailAddr;
	/**
	 * 삭제여부
	 */
	@Schema(description = "삭제여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String delYn;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;

	@Schema(description = "등록채널코드명")
	private String regChlCdNm;
	
	@Schema(description = "고객명",accessMode = AccessMode.READ_ONLY)
	private String custNm;
	
	
	
}
