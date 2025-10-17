package com.ceragem.api.crm.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.base.util.Utilities;
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
public class CrmCustVo extends ApiBaseVo {
	@Schema(description = "연락처목록", example = "", hidden = false, required = false, nullable = false, accessMode = AccessMode.READ_ONLY)
	private List<CrmCustCntplcBasVo> cntplcList = null;
	@Schema(description = "가족관계목록", example = "", hidden = false, required = false, nullable = false, accessMode = AccessMode.READ_ONLY)
	private List<CrmCustHshldBasVo> hshldList = null;
	@Schema(description = "개인정보동의내역")
	private CrmAgreementVo agreement;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호[자동생성]", example = "CST22041210355401087", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 법인구분여부
	 */
	@Schema(description = "법인구분여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String corpDivYn;
	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "김고객", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	@MaxByte(max = 100)
	private String custNm;
	/**
	 * 성별코드 공통코드 : S040 [M : 남 , F : 여]
	 */
	@Schema(description = "성별코드  [M : 남 , F : 여]", example = "M", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S040", codes = { "M", "F" }, message = "[M : 남 , F : 여] 등록된 코드가 아닙니다. ")
	private String gndrCd;
	/**
	 * 생년월일
	 */
	@Schema(description = "생년월일", example = "20000101", hidden = false, required = false, nullable = true, maxLength = 8)
//	@MaxByte(max = 8)
	@DateValue
	private String birthday;
	/**
	 * 사업자등록번호
	 */
	@Schema(description = "사업자등록번호", example = "100-00-12345", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String bizNo;
	/**
	 * 법인등록번호
	 */
	@Schema(description = "법인등록번호", example = "100000-1234567", hidden = false, required = false, nullable = true, maxLength = 13)
	@MaxByte(max = 13)
	private String corpRegNo;
	/**
	 * 법인전화번호
	 */
	@Schema(description = "법인전화번호", example = "0212345678", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String corpTelNo;
	/**
	 * 외국인여부
	 */
	@Schema(description = "외국인여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String fornYn;
	/**
	 * 대표명
	 */
	@Schema(description = "대표명", example = "김대표", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String repNm;
	/**
	 * 이동전화번호
	 */
	@Schema(description = "이동전화번호", example = "01012345678", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@Pattern(regexp = "^[0-9]*$", message = "전화번호는 숫자만 가능합니다")
	@MaxByte(max = 20)
	private String mphonNo;

	/**
	 * 이동전화번호암호화값
	 */
	@Schema(description = "이동전화번호암호화값", example = "", hidden = true, required = true, nullable = false, accessMode = AccessMode.READ_ONLY)
	private String mphonNoEncVal;

	/**
	 * 이동전화뒤자리번호
	 */
	@Schema(description = "이동전화뒤자리번호", example = "5678", hidden = true, required = false, nullable = true, maxLength = 4, accessMode = AccessMode.READ_ONLY)
	@MaxByte(max = 4)
	private String mphonBkDgtNo;
	/**
	 * 이메일주소
	 */
	@Schema(description = "이메일주소", example = "user@gmail.com", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String emailAddr;
	/**
	 * 담당자명
	 */
	@Schema(description = "담당자명", example = "김담당", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String picNm;
	/**
	 * 담당자이동전화번호
	 */
	@Schema(description = "담당자이동전화번호", example = "01012345678", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String picMphonNo;
	/**
	 * 담당자이동전화뒤자리번호
	 */
	@Schema(description = "담당자이동전화뒤자리번호", example = "5678", hidden = false, required = false, nullable = true, maxLength = 4)
	@MaxByte(max = 4)
	private String picMphonBkDgtNo;
	/**
	 * 담당자이메일주소
	 */
	@Schema(description = "담당자이메일주소", example = "agent@gmail.com", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String picEmailAddr;
	/**
	 * 개인정보유효기간시작일시
	 */
	@Schema(description = "개인정보유효기간시작일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String indiInfoValidPerdStaDt;
	/**
	 * 개인정보유효기간종료일시
	 */
	@Schema(description = "개인정보유효기간종료일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String indiInfoValidPerdEndDt;
	/**
	 * 고객상태코드 공통코드 : CU020 [001 : 정상 , 002 : 휴면 , 003 : 탈회]
	 */
	@Schema(description = "고객상태코드  [001 : 정상 , 002 : 휴면 , 003 : 탈회]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
	@CodeValue(codeId = "CU020", codes = { "001", "002",
			"003" }, message = "[001 : 정상 , 002 : 휴면 , 003 : 탈회] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String custStatusCd;
	@Schema(description = "고객상태코드", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String custStatusCdNm;
	/**
	 * 고객상태변경일시
	 */
	@Schema(description = "고객상태변경일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	@DatetimeValue
	private String custStatusChngDt;
	/**
	 * 고객정보변경일시
	 */
	@Schema(description = "고객정보변경일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	@DatetimeValue
	private String custInfoChngDt;
	/**
	 * 고객유형코드 공통코드 : CU030 [001 : 잠재고객 , 002 : 가망고객 , 003 : 체험고객 , 004 : 구매고객 , 005
	 * : 추천고객 , 006 : 충성고객]
	 */
	@Schema(description = "고객유형코드  [001 : 잠재고객 , 002 : 가망고객 , 003 : 체험고객 , 004 : 구매고객 , 005 : 추천고객 , 006 : 충성고객]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
	@CodeValue(codeId = "CU030", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 잠재고객 , 002 : 가망고객 , 003 : 체험고객 , 004 : 구매고객 , 005 : 추천고객 , 006 : 충성고객] 등록된 코드가 아닙니다. ")
	private String custTypeCd;
	@Schema(description = "고객유형코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String custTypeCdNm;
	/**
	 * 고객구분코드 공통코드 : CU010 [001 : 개인 , 002 : 법인]
	 */
	@Schema(description = "고객구분코드  [001 : 개인 , 002 : 법인]", example = "001", hidden = false, required = true, nullable = false, maxLength = 3)
	@CodeValue(codeId = "CU010", codes = { "001", "002" }, message = "[001 : 개인 , 002 : 법인] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String custDivCd = "001";
	@Schema(description = "고객구분코드명", example = "", hidden = false, required = false, nullable = true)
	private String custDivCdNm;
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
	@Schema(description = "지역코드명", example = "서울", accessMode = AccessMode.READ_ONLY)
	private String distrctCdNm;
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
	 * 추천매장번호
	 */
	@Schema(description = "추천매장번호", example = "1234567898", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String rcmdStorNo;
	@Schema(description = "추천매장명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String rcmdStorNoNm;
	/**
	 * 추천인고객번호
	 */
	@Schema(description = "추천인고객번호", example = "CST20220411121212001", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String rcmdrCustNo;
	/**
	 * 추천임직원번호
	 */
	@Schema(description = "추천임직원번호", example = "10000001", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String rcmdExecvdempNo;
	/**
	 * 결혼여부
	 */
	@Schema(description = "결혼여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String marryYn;
	/**
	 * 대표가구번호
	 */
	@Schema(description = "대표가구번호", example = "F00000001", hidden = false, required = false, nullable = true, maxLength = 30, accessMode = AccessMode.READ_ONLY)
	@MaxByte(max = 30)
	private String repHshldNo;
	/**
	 * 가족관계코드 공통코드 : CU040 [001 : 부모 , 002 : 배우자 , 003 : 자녀]
	 */
	@Schema(description = "가족관계코드  [001 : 부모 , 002 : 배우자 , 003 : 자녀]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
	@CodeValue(codeId = "CU040", codes = { "001", "002",
			"003" }, message = "[001 : 부모 , 002 : 배우자 , 003 : 자녀] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String famlyRelCd;
	@Schema(description = "가족관계코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String famlyRelCdNm;
	/**
	 * 주거평수코드 공통코드 : CU050 [001 : 1평 ~ 10평 , 002 : 11평 ~ 20평 , 003 : 21평 ~ 30평 , 004
	 * : 30평 ~ 40평 , 005 : 41평 ~ 50평 , 006 : 51평 ~ 60평 , 007 : 61평 ~ 70평 , 008 : 71평
	 * ~ 80평 , 009 : 81평 이상]
	 */
	@Schema(description = "주거평수코드  [001 : 1평 ~ 10평 , 002 : 11평 ~ 20평 , 003 : 21평 ~ 30평 , 004 : 30평 ~ 40평 , 005 : 41평 ~ 50평 , 006 : 51평 ~ 60평 , 007 : 61평 ~ 70평 , 008 : 71평 ~ 80평 , 009 : 81평 이상]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "CU050", codes = { "001", "002", "003", "004", "005", "006", "007", "008",
			"009" }, message = "[001 : 1평 ~ 10평 , 002 : 11평 ~ 20평 , 003 : 21평 ~ 30평 , 004 : 30평 ~ 40평 , 005 : 41평 ~ 50평 , 006 : 51평 ~ 60평 , 007 : 61평 ~ 70평 , 008 : 71평 ~ 80평 , 009 : 81평 이상] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String dwelNfpyCd;
	@Schema(description = "주거평수코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String dwelNfpyCdNm;
	/**
	 * 관심분야코드 공통코드 : CU060 [001 : 건강 , 002 : 음식 , 003 : 주거 , 004 : 의료 , 005 : 스포츠 ,
	 * 006 : 연예]
	 */
	@Schema(description = "관심분야코드[,구분]  [001 : 건강 , 002 : 음식 , 003 : 주거 , 004 : 의료 , 005 : 스포츠 , 006 : 연예]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
//	@CodeValue(codeId = "CU060", codes = { "001", "002", "003", "004", "005",
//			"006" }, message = "[001 : 건강 , 002 : 음식 , 003 : 주거 , 004 : 의료 , 005 : 스포츠 , 006 : 연예] 등록된 코드가 아닙니다. ")
//	@MaxByte(max = 3)
	private String intrstFildCd;
	@Schema(description = "관심분야코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String intrstFildCdNm;
	/**
	 * 대표제품번호
	 */
	@Schema(description = "대표제품번호", example = "PRD00000001", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String repGodsNo;
	@Schema(description = "대표제품번호명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String repGodsNoNm;
	/**
	 * 대표사용고객구분코드 공통코드 : CU010 [001 : 개인 , 002 : 법인]
	 */
	@Schema(description = "대표사용고객구분코드  [001 : 개인 , 002 : 법인]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "CU010", codes = { "001", "002" }, message = "[001 : 개인 , 002 : 법인] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String repUseCustDivCd;
	@Schema(description = "대표사용고객구분코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String repUseCustDivCdNm;
	/**
	 * SMS수신동의여부
	 */
	@Schema(description = "SMS수신동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
//	@YnValue
//	@MaxByte(max = 1)
	private String smsRcvAgreeYn;
	/**
	 * SMS수신동의일시
	 */
	@Schema(description = "SMS수신동의일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
//	@DatetimeValue
	private String smsRcvAgreeDt;
	/**
	 * SMS수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Schema(description = "SMS수신동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
//			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
//	@MaxByte(max = 3)
	private String smsRcvAgreeChlCd;
	@Schema(description = "SMS수신동의채널코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String smsRcvAgreeChlCdNm;
	/**
	 * 이메일수신동의여부
	 */
	@Schema(description = "이메일수신동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
//	@YnValue
//	@MaxByte(max = 1)
	private String emailRcvAgreeYn;
	/**
	 * 이메일수신동의일시
	 */
	@Schema(description = "이메일수신동의일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
//	@DatetimeValue
	private String emailRcvAgreeDt;
	/**
	 * 이메일수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Schema(description = "이메일수신동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
//			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
//	@MaxByte(max = 3)
	private String emailRcvAgreeChlCd;
	@Schema(description = "이메일수신동의채널코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String emailRcvAgreeChlCdNm;
	/**
	 * 알람톡수신동의여부
	 */
	@Schema(description = "알람톡수신동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
//	@YnValue
//	@MaxByte(max = 1)
	private String alrmTkRcvAgreeYn;
	/**
	 * 알람톡수신동의일시
	 */
	@Schema(description = "알람톡수신동의일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
//	@DatetimeValue
	private String alrmTkRcvAgreeDt;
	/**
	 * 알람톡수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Schema(description = "알람톡수신동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
//			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
//	@MaxByte(max = 3)
	private String alrmTkRcvAgreeChlCd;
	@Schema(description = "알람톡수신동의채널코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String alrmTkRcvAgreeChlCdNm;
	/**
	 * PUSH수신동의여부
	 */
	@Schema(description = "PUSH수신동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
//	@YnValue
//	@MaxByte(max = 1)
	private String pushRcvAgreeYn;
	/**
	 * PUSH수신동의일시
	 */
	@Schema(description = "PUSH수신동의일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
//	@DatetimeValue
	private String pushRcvAgreeDt;
	/**
	 * PUSH수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Schema(description = "PUSH수신동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
//			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String pushRcvAgreeChlCd;
	@Schema(description = "PUSH수신동의채널코드명", example = "", hidden = false, required = false, nullable = true)
	private String pushRcvAgreeChlCdNm;

	@Schema(description = "마케팅수신동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
//	@YnValue
//	@MaxByte(max = 1)
	private String marketingAgreeYn;

	@Schema(description = "마케팅수신동의일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
//	@DatetimeValue
	private String marketingAgreeDt;

	@Schema(description = "마케팅수신동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
//			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String marketingAgreeChlCd;

	@Schema(description = "마케팅수신동의채널코드명", example = "", hidden = false, required = false, nullable = true)
	private String marketingAgreeChlCdNm;

	/**
	 * SMS수신동의여부
	 */
	@Schema(description = "민감정보동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
//	@YnValue
//	@MaxByte(max = 1)
	private String infoAgreeYn;
	/**
	 * SMS수신동의일시
	 */
	@Schema(description = "민감정보동의여부일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
//	@DatetimeValue
	private String infoAgreeDt;

	@Schema(description = "민감정보동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
//			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String infoAgreeChlCd;

	@Schema(description = "민감정보동의채널코드명", example = "", hidden = false, required = false, nullable = true)
	private String infoAgreeChlCdNm;

	@Schema(description = "개인정보수집동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
//	@YnValue
//	@MaxByte(max = 1)
	private String collectAgreeYn;
	/**
	 * SMS수신동의일시
	 */
	@Schema(description = "개인정보수집동의여부일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
//	@DatetimeValue
	private String collectAgreeDt;

	@Schema(description = "개인정보수집동의여부코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
//			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String collectAgreeChlCd;

	@Schema(description = "개인정보수집동의여부채널코드명", example = "", hidden = false, required = false, nullable = true)
	private String collectAgreeChlCdNm;

	/**
	 * CI인증여부
	 */
	@Schema(description = "CI인증여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String ciCertfYn;
	/**
	 * CI
	 */
	@Schema(description = "CI", example = "", hidden = false, required = false, nullable = true, maxLength = 88)
	@MaxByte(max = 88)
	private String ci;
	/**
	 * DI인증여부
	 */
	@Schema(description = "DI인증여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String diCertfYn;
	/**
	 * DI
	 */
	@Schema(description = "DI", example = "", hidden = false, required = false, nullable = true, maxLength = 64)
	@MaxByte(max = 64)
	private String di;
	/**
	 * 수신거부여부
	 */
	@Schema(description = "수신거부여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
//	@YnValue
//	@MaxByte(max = 1)
	private String rcvRfslYn;
	/**
	 * 멤버십가입여부
	 */
	@Schema(description = "멤버십가입여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
	@YnValue
	@MaxByte(max = 1)
	private String mshipSbscYn;
	/**
	 * 멤버십로그인ID
	 */
	@Schema(description = "멤버십로그인ID", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String mshipLoginId;
	/**
	 * 멤버십대체번호
	 */
	@Schema(description = "멤버십대체번호", example = "", hidden = false, required = false, nullable = true, maxLength = 14)
	@MaxByte(max = 14)
	private String mshipSbtNo;
	/**
	 * 멤버십로그인비밀번호
	 */
	@Schema(description = "멤버십로그인비밀번호", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String mshipLoginPwd;
	/**
	 * 멤버십최종로그인일시
	 */
	@Schema(description = "멤버십최종로그인일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String mshipLastLoginDt;
	/**
	 * 멤버십최종로그인IP주소
	 */
	@Schema(description = "멤버십최종로그인IP주소", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String mshipLastLoginIpAddr;
	/**
	 * 멤버십최종매장방문일시
	 */
	@Schema(description = "멤버십최종매장방문일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String mshipLastStorVisitDt;
	/**
	 * 멤버십최종방문매장번호
	 */
	@Schema(description = "멤버십최종방문매장번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String mshipLastVisitStorNo;
	@Schema(description = "멤버십최종방문매장번호명", example = "", hidden = false, required = false, nullable = true)
	private String mshipLastVisitStorNoNm;
	/**
	 * 멤버십유형코드 공통코드 : MB010 [001 : 임직원 , 002 : 제휴 , 003 : 회원 , 004 : 비회원]
	 */
	@Schema(description = "멤버십유형코드  [001 : 임직원 , 002 : 제휴 , 003 : 회원 , 004 : 비회원]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "MB010", codes = { "001", "002", "003",
			"004" }, message = "[001 : 임직원 , 002 : 제휴 , 003 : 회원 , 004 : 비회원] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String mshipTypeCd;
	@Schema(description = "멤버십유형코드명", example = "", hidden = false, required = false, nullable = true)
	private String mshipTypeCdNm;
	/**
	 * 멤버십가입일시
	 */
	@Schema(description = "멤버십가입일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String mshipSbscDt;
	/**
	 * 멤버십등급코드 공통코드 : MB020 [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드
	 * , 006 : VIP]
	 */
	@Schema(description = "멤버십등급코드  [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "MB020", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String mshipGradeCd;
	/**
	 * 멤버십 등급명
	 */
	@Schema(description = "멤버십등급코드명", example = "", hidden = false, required = false, nullable = true)
	private String mshipGradeCdNm;
	/**
	 * 멤버십 등급컬러
	 */
	@Schema(description = "멤버십등급컬러", example = "", hidden = false, required = false, nullable = true)
	private String mshipGradeColor;
	/**
	 * 멤버십등급변경일시
	 */
	@Schema(description = "멤버십등급변경일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String mshipGradeChngDt;
	/**
	 * 멤버십정보변경일시
	 */
	@Schema(description = "멤버십정보변경일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String mshipInfoChngDt;
	/**
	 * 멤버십정보확인자임직원번호
	 */
	@Schema(description = "멤버십정보확인자임직원번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String mshipInfoConfrExecvdempNo;
	/**
	 * 제휴임직원번호
	 */
	@Schema(description = "제휴임직원번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String cprtExecvdempNo;
	/**
	 * 멤버십탈퇴일시
	 */
	@Schema(description = "멤버십탈퇴일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
//	@DatetimeValue
	private String mshipLeaveDt;
	/**
	 * 소멸포인트한도점수
	 */
	@Schema(description = "소멸포인트한도점수", example = "", hidden = false, required = false, nullable = true)
	private Integer extncPointLmtScore;
	/**
	 * 적립포인트한도점수
	 */
	@Schema(description = "적립포인트한도점수", example = "", hidden = false, required = false, nullable = true)
	private Integer accumPointLmtScore;

	/**
	 * 잔여포인트점수
	 */
	@Schema(description = "잔여포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer remainPointScore;

	/**
	 * 멤버십채널코드
	 */
	@Schema(description = "멤버십채널코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String mshipChlCd;
	@Schema(description = "멤버십채널코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String mshipChlCdNm;
	/**
	 * 주의고객등록매장번호
	 */
	@Schema(description = "주의고객등록매장번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30, accessMode = AccessMode.READ_ONLY)
	@MaxByte(max = 30)
	private String bllkRegStorNo;
	@Schema(description = "주의고객등록매장번호명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String bllkRegStorNoNm;
	/**
	 * 주의고객회원여부
	 */
	@Schema(description = "주의고객회원여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
//	@YnValue
//	@MaxByte(max = 1)
	private String bllkmshpYn;
	/**
	 * 주의고객등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Schema(description = "주의고객등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
//	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
//			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
//	@MaxByte(max = 3)
	private String bllkRegChlCd;
	@Schema(description = "주의고객등록채널코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String bllkRegChlCdNm;
	/**
	 * 주의고객등록사유내용
	 */
	@Schema(description = "주의고객등록사유내용", example = "", hidden = false, required = false, nullable = true, maxLength = 4000, accessMode = AccessMode.READ_ONLY)
//	@MaxByte(max = 4000)
	private String bllkRegWhyCtnts;
	/**
	 * 주의고객등록일시
	 */
	@Schema(description = "주의고객등록일시 (YYYYMMDDHH24MISS)", example = "20220408130044", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
//	@DatetimeValue
	private String bllkRegDt;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP", "POS", "BOS", "MEM", "CERA", "DNA",
			"IoT" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;
	@Schema(description = "등록채널코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String regChlCdNm;

//	@Schema(description = "설치처암호화전화번호", example = "", hidden = false, required = false, nullable = true)
//	private String instTelNoEncVal;
	@Schema(description = "설치처전화번호", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 20)
	private String instTelNo;
	@Schema(description = "설치처지역코드", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 3)
	@Pattern(regexp = "^[0-9]*$", message = "지역코드는 숫자만 가능합니다")
	private String instDistrctCd;
	@Schema(description = "설치처지역코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String instDistrctCdNm;
	@Schema(description = "설치처우편번호", example = "", hidden = false, required = false, nullable = true)
	@Pattern(regexp = "^[0-9]*$", message = "우편번호는 숫자만 가능합니다")
	@MaxByte(max = 5)
	private String instZipCd;
	@Schema(description = "설치처주소1", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 1000)
	private String instAddr1;
	@Schema(description = "설치처주소2", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 1000)
	private String instAddr2;

//	@Schema(description = "직장암호화전화번호", example = "", hidden = false, required = false, nullable = true)
//	private String jobTelNoEncVal;
	@Schema(description = "직장전화번호", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 20)
	private String jobTelNo;
	@Schema(description = "직장지역코드", example = "", hidden = false, required = false, nullable = true)
	@Pattern(regexp = "^[0-9]*$", message = "지역코드는 숫자만 가능합니다")
	@MaxByte(max = 3)
	private String jobDistrctCd;
	@Schema(description = "직장지역코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String jobDistrctCdNm;
	@Schema(description = "직장우편번호", example = "", hidden = false, required = false, nullable = true)
	@Pattern(regexp = "^[0-9]*$", message = "우편번호는 숫자만 가능합니다")
	@MaxByte(max = 5)
	private String jobZipCd;
	@Schema(description = "직장주소1", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 1000)
	private String jobAddr1;
	@Schema(description = "직장주소2", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 1000)
	private String jobAddr2;

//	@Schema(description = "자택암호화전화번호", example = "", hidden = false, required = false, nullable = true)
//	private String homeTelNoEncVal;
	@Schema(description = "자택전화번호", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 20)
	private String homeTelNo;
	@Schema(description = "자택지역코드", example = "", hidden = false, required = false, nullable = true)
	@Pattern(regexp = "^[0-9]*$", message = "지역코드는 숫자만 가능합니다")
	@MaxByte(max = 3)
	private String homeDistrctCd;
	@Schema(description = "자택지역코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String homeDistrctCdNm;
	@Schema(description = "자택우편번호", example = "", hidden = false, required = false, nullable = true)
	@Pattern(regexp = "^[0-9]*$", message = "우편번호는 숫자만 가능합니다")
	@MaxByte(max = 5)
	private String homeZipCd;
	@Schema(description = "자택주소1", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 1000)
	private String homeAddr1;
	@Schema(description = "자택주소2", example = "", hidden = false, required = false, nullable = true)
	@MaxByte(max = 1000)
	private String homeAddr2;

	@Schema(description = "주의고객등록횟수", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private Integer blackCnt;

	@Schema(description = "카드번호", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String cardNo;

	@Schema(description = "쿠폰유형", example = "", hidden = true, required = false, nullable = true)
	private String coupnTypeCd;

	@Schema(description = "이벤트유형", example = "", hidden = true, required = false, nullable = true)
	private String eventCd;

	@Schema(description = "보호가족여부", example = "", hidden = false, required = false, nullable = true)
	@YnValue
	private String prtctFamlyYn;

	/**
	 * 멤버십예정등급코드
	 */
	@Schema(description = "멤버십예정등급코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
//	@MaxByte(max = 3)
	private String mshipExptGradeCd;
	/**
	 * 멤버십승급점수
	 */
	@Schema(description = "멤버십승급점수", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private Integer mshipAdvncmtScore;

	/**
	 * 멤버십승급점수
	 */
	@Schema(description = "쿠폰갯수", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private Integer couponCnt;
	/**
	 * 서비스권 갯수
	 */
	@Schema(description = "서비스권갯수", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private Integer couponBookCnt;

	/**
	 * 개인정보취급자번호
	 */
	@Schema(description = "개인정보취급자번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String indiInfoHandlPrsnNo;
	/**
	 * 접속자IP주소
	 */
	@Schema(description = "접속자IP주소", example = "", hidden = false, required = false, nullable = true, maxLength = 100, accessMode = AccessMode.WRITE_ONLY)
	@MaxByte(max = 100)
	private String connPrsnIpAddr;

	@Schema(description = "다운로드사유", example = "", hidden = true, accessMode = AccessMode.WRITE_ONLY)
	private String dnldTxn;

	@Schema(description = "변경 사유", example = "", hidden = true, accessMode = AccessMode.WRITE_ONLY)
	@MaxByte(max = 1000)
	private String indiInfoAmdTxn;

	@Schema(description = "app토큰", hidden = false)
	private String appPushTokn;

	/**
	 * 앱PUSHOS코드 공통코드 : MB220 [1 : Android , 2 : iOs]
	 */
	@CodeValue(codeId = "MB220", codes = { "1", "2", "3" }, message = "[1 : Android , 2 : iOs, 3:Web] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 2)
	@Schema(description = "앱PUSHOS코드", hidden = false)
	private String appPushOsCd;

	@Schema(description = "체험여부", hidden = false)
	@YnValue
	private String exprnYn;

	@Schema(description = "복호화여부", hidden = true)
	private String decryptYn = "N";

	@Schema(description = "휴면기간코드[1:1년,3:3년,5:5년,99:탈퇴시까지]")
	@Deprecated
//	@CodeValue(codeId = "S160")
	private String dormPerdCd = "99";
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]", hidden = true)
	private String pblsChlCd; // 등록채널 코드

	@Schema(description = "제휴회사번호", accessMode = AccessMode.READ_ONLY)
	private String cprtCmpNo;

	@Schema(description = "제휴회사명", accessMode = AccessMode.READ_ONLY)
	private String cprtCmpNm;

	@Schema(description = "매출합계", accessMode = AccessMode.READ_ONLY)
	private Long saleAggrAmt;

	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "CST22041210355401087", hidden = true, required = false, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String orgItgCustNo;

	@Schema(description = "고객등급코드", example = "001", hidden = true, required = false, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String orgMshipGradeCd;

	@Schema(description = "고객정책코드", example = "", hidden = true, required = false, nullable = false, maxLength = 30, accessMode = AccessMode.READ_ONLY)
	private String mshipPlcyBasNo;
	@Schema(description = "등급별고객정책코드", example = "", hidden = true, required = false, nullable = false, maxLength = 30, accessMode = AccessMode.READ_ONLY)
	private String orgMshipPlcyBasNo;
	/**
	 * 추천인고객번호
	 */
	@Schema(description = "추천인고객번호", example = "CST20220411121212001", hidden = true, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String rcmdrCustNo2;

	@Schema(description = "추천인고객번호", example = "CST20220411121212001", hidden = true, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String storNo;

	@Schema(description = "추천인명", example = "김X김", hidden = true, required = false, nullable = true, maxLength = 30)
	private String rcmdrCustNm;

	@Schema(description = "멤버십회원가입 추가지급여부", example = "Y/N", hidden = true, required = false, nullable = true, maxLength = 30)
	private String cpnPblsAddYn;
	@Schema(description = "메시지코드", hidden = true)
	private String codeCd;
	@Schema(description = "유입경로코드[001 : TV,홈쇼핑광고 , 002 : 인터넷검색 , 003 : 홍보활동 , 004 : 지인추천 , 005 : 자연방문 , 006 : POS]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String ingrsPathCd;

	@Schema(description = "멤버십앱 푸시 안읽은 메시지수", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private Integer mshipPushUnreadCnt;

	@Schema(description = "의료가전건수", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String medicalHomeCnt;
	@Schema(description = "안마의자건수", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String massageChairCnt;
	@Schema(description = "프리미엄 안마의자건수", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String premiumMassageChairCnt;

	@Schema(description = "유리듬건수", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String youridmCnt;

	@Schema(description = "레이디건수", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String raydCnt;

	@Schema(description = "밸런스워터 건수", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String balanceCnt;

	@Schema(description = "셀루닉 건수", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String cellunicCnt;

	@Schema(description = "의료가전주문일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String medicalHomeOrdDe;
	@Schema(description = "안마의자주문일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String massageChairOrdDe;
	@Schema(description = "프리미엄 안마의자주문일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String premiumMassageChairOrdDe;
	@Schema(description = "유리듬주문일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String youridmOrdDe;
	@Schema(description = "레이디주문일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String raydOrdDe;

	@Schema(description = "밸런스워터 주문일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String balanceOrdDe;
	@Schema(description = "셀루닉 주문일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String cellunicOrdDe;

	@Schema(description = "의료가전설치일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String medicalHomeIstDcsDe;
	@Schema(description = "안마의자설치일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String massageChairIstDcsDe;
	@Schema(description = "프리미엄 안마의자설치일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String premiumMassageChairIstDcsDe;
	@Schema(description = "유리듬설치일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String youridmIstDcsDe;
	@Schema(description = "레이디설치일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String raydIstDcsDe;

	@Schema(description = "밸런스워터설치일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String balanceIstDcsDe;
	@Schema(description = "셀루닉설치일자", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String cellunicIstDcsDe;

	@Schema(description = "최초구매일", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String firstBuyDe;
	@Schema(description = "체험합계", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String tot;
	@Schema(description = "구매후체험", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String upCnt;
	@Schema(description = "구매전체험", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String dwCnt;
	@Schema(description = "최초체험일", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String firstDe;
	@Schema(description = "마지막체험일", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String lastDe;
	@Schema(description = "최초구매매장", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String firstStore;
	@Schema(description = "최초구매매장명", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String firstStoreNm;
	@Schema(description = "마지막체험매장", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String lastStore;
	@Schema(description = "마지막체험매장명", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String lastStoreNm;

	public String getDistrctCd() {
		if (Utilities.isNotEmpty(distrctCd))
			return distrctCd;
		return Utilities.getLocationCd(zipCd);
	}

	@Schema(description = "관심분야코드 - MB240[01 : 스킨케어 , 02 : 영양케어 , 03 : 멘탈케어 , 04 : 운동케어]", example = "01, 03", hidden = false, required = false, nullable = true)
	private String hlthIntrstFildCd;

	@Schema(description = "관심분야코드명 - MB240[01 : 스킨케어 , 02 : 영양케어 , 03 : 멘탈케어 , 04 : 운동케어]", example = "스킨케어, 멘탈케어", hidden = false, required = false, nullable = true)
	private String hlthIntrstFildCdNm;

	/**
	 * 체험 정보 동의 여부
	 */
	@Schema(description = "체험 정보 동의 여부[Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1, accessMode = AccessMode.READ_ONLY)
	private String exprnInfoAgreeYn;

	/**
	 * 체험 정보 동의 일시
	 */
	@Schema(description = "체험 정보 동의 일시 (YYYYMMDDHH24MISS)", example = "20231016150045", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String exprnInfoAgreeDt;
	/**
	 * 체험 정보 동의 채널 코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Schema(description = "체험 정보 동의 채널 코드 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
	private String exprnInfoAgreeChlCd;

	@Schema(description = "익월멤버십등급코드  [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3, accessMode = AccessMode.READ_ONLY)
	@CodeValue(codeId = "MB020", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String nextMshipGradeCd;

	/**
	 * 멤버십 등급명
	 */
	@Schema(description = "익월멤버십등급코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String nextMshipGradeCdNm;

	@Schema(description = "익월멤버십등급변경코드", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String nextMshipGradeTypeCd;
	@Schema(description = "익월멤버십등급변경코드명", example = "", hidden = false, required = false, nullable = true, accessMode = AccessMode.READ_ONLY)
	private String nextMshipGradeTypeCdNm;
//	

//	@Schema(description = "구매금액", accessMode = AccessMode.READ_ONLY)
//	private int purchaseAmt = 0;

	@Schema(description = "로그인패스워드변경일", hidden = false, accessMode = AccessMode.READ_ONLY)
	private String mshipLoginPwdChngDt;
}
