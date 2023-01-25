package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmCustBasVo
 * @author 김성태
 * @date 2022. 4. 8.
 * @Version 1.0
 * @description CRM고객기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객기본 객체")
public class CrmCustInstallLocVo extends ApiBaseVo {
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호[자동생성]", example = "CST22041210355401087", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;

	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "김고객", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	@MaxByte(max = 100)
	private String custNm;

	/**
	 * 이동전화번호
	 */
	@Schema(description = "이동전화번호", example = "01012345678", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String mphonNo;
	/**
	 * 이메일주소
	 */
	@Schema(description = "이메일주소", example = "user@gmail.com", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String emailAddr;
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
	 * 우편번호
	 */
	@Schema(description = "우편번호", example = "12345", hidden = false, required = false, nullable = true, maxLength = 5)
	@MaxByte(max = 5)
	private String zipCd;
	/**
	 * 주소1내용
	 */
	@Schema(description = "주소1내용", example = "서울특별시 강남구 강남대로 362(역삼동)", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String addr1Ctnts;
	/**
	 * 주소2내용
	 */
	@Schema(description = "주소2내용", example = "123-456", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String addr2Ctnts;

	/**
	 * 개인정보취급자번호
	 */
	@Schema(description = "개인정보취급자번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String indiInfoHandlPrsnNo;
	/**
	 * 접속자IP주소
	 */
	@Schema(description = "접속자IP주소", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String connPrsnIpAddr;

	public String getDistrctCd() {
		if (Utilities.isNotEmpty(distrctCd))
			return distrctCd;
		return Utilities.getLocationCd(zipCd);
	}
}
