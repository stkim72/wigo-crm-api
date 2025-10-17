package com.ceragem.api.crm.model;

import org.hibernate.validator.constraints.Length;

import com.ceragem.api.base.util.Utilities;
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
 * @ClassName CrmCustBasSo
 * @author 김성태
 * @date 2022. 4. 8.
 * @Version 1.0
 * @description CRM고객기본 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM고객기본 검색 객체")
public class CrmCustSo extends CrmSnstvInfoInqrySo {

	/**
	 * 제외할 통합사용자아이디
	 */
	@Parameter(description = "제외할 통합사용자아이디", example = "10012345", hidden = true, required = false)
	private String exceptItgCustNo;

	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호", example = "CST22041210355401087", hidden = false, required = false)
	private String itgCustNo;

	/**
	 * 통합고객번호
	 */
	@Parameter(description = "통합고객번호 [,]로 구분", example = "CST22041913333604374,CST22041913333604375,CST22041913333604295", hidden = false, required = false)
	private String itgCustNos;
	/**
	 * 법인구분여부
	 */
	@Parameter(description = "법인구분여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String corpDivYn;
	/**
	 * 고객명
	 */
	@Parameter(description = "고객명", example = "김고객", hidden = false, required = false)
	private String custNm;

	/**
	 * 고객명
	 */
	@Parameter(description = "고객명 부분검색", example = "고객", hidden = false, required = false)
	@Length(min = 2)
	private String custNmLike;

	/**
	 * 성별코드 공통코드 : S040 [M : 남 , F : 여]
	 */
	@Parameter(description = "성별코드  [M : 남 , F : 여]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S040", codes = { "M", "F" }, message = "[M : 남 , F : 여] 등록된 코드가 아닙니다. ")
	private String gndrCd;

	/**
	 * 생년월일
	 */
	@Parameter(description = "생년월일[YYYYMMDD]", example = "20211212", hidden = false, required = false)
	private String birthYmd;

	/**
	 * 생년월일
	 */
	@Parameter(description = "시작생년월일[YYYYMMDD]", example = "19910101", hidden = false, required = false)
	@DateValue
	private String fromBirthYmd;

	/**
	 * 생년월일
	 */
	@Parameter(description = "종료생년월일[YYYYMMDD]", example = "19991231", hidden = false, required = false)
	@DateValue
	private String toBirthYmd;

	/**
	 * 생일
	 */
	@Parameter(description = "생일[MMDD]", example = "0515", hidden = false, required = false)
	@Length(min = 4, max = 4, message = "생일은 MMDD 4자리 형식입니다.")
	private String birthday;
	/**
	 * 생년월일
	 */
	@Parameter(description = "시작생일[MMDD]", example = "0501", hidden = false, required = false)
	@Length(min = 4, max = 4, message = "생일은 MMDD 4자리 형식입니다.")
	private String fromBirthday;

	/**
	 * 생년월일
	 */
	@Parameter(description = "종료생일[MMDD]", example = "0531", hidden = false, required = false)
	@Length(min = 4, max = 4, message = "생일은 MMDD 4자리 형식입니다.")
	private String toBirthday;

	/**
	 * 사업자등록번호
	 */
	@Parameter(description = "사업자등록번호", example = "", hidden = false, required = false)
	private String bizNo;
	/**
	 * 법인등록번호
	 */
	@Parameter(description = "법인등록번호", example = "", hidden = false, required = false)
	private String corpRegNo;
	/**
	 * 법인전화번호
	 */
	@Parameter(description = "법인전화번호", example = "", hidden = false, required = false)
	private String corpTelNo;
	/**
	 * 외국인여부
	 */
	@Parameter(description = "외국인여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String fornYn;
	/**
	 * 대표명
	 */
	@Parameter(description = "대표명", example = "", hidden = true, required = false)
	private String repNm;
	/**
	 * 이동전화번호
	 */
	@Parameter(description = "이동전화번호", example = "01012345678", hidden = false, required = false)
	private String mphonNo;

//	/**
//	 * 이동전화번호암호화값
//	 */
//	@Parameter(description = "이동전화번호암호화값", example = "", hidden = true, required = true)
//	private String mphonNoEncVal;

	/**
	 * 이동전화뒤자리번호
	 */
	@Parameter(description = "이동전화뒤자리번호", example = "5678", hidden = false, required = false)
	private String mphonBkDgtNo;
	/**
	 * 이메일주소
	 */
	@Parameter(description = "이메일주소", example = "", hidden = true, required = false)
	private String emailAddr;
	/**
	 * 담당자명
	 */
	@Parameter(description = "담당자명", example = "", hidden = true, required = false)
	private String picNm;
	/**
	 * 담당자이동전화번호
	 */
	@Parameter(description = "담당자이동전화번호", example = "", hidden = true, required = false)
	private String picMphonNo;
	/**
	 * 담당자이동전화뒤자리번호
	 */
	@Parameter(description = "담당자이동전화뒤자리번호", example = "", hidden = true, required = false)
	private String picMphonBkDgtNo;
	/**
	 * 담당자이메일주소
	 */
	@Parameter(description = "담당자이메일주소", example = "", hidden = true, required = false)
	private String picEmailAddr;
	/**
	 * 개인정보유효기간시작일시
	 */
	@Parameter(description = "개인정보유효기간시작일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String indiInfoValidPerdStaDt;
	/**
	 * 개인정보유효기간종료일시
	 */
	@Parameter(description = "개인정보유효기간종료일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String indiInfoValidPerdEndDt;
	/**
	 * 고객상태코드 공통코드 : CU020 [001 : 정상 , 002 : 휴면 , 003 : 탈회]
	 */
	@Parameter(description = "고객상태코드  [001 : 정상 , 002 : 휴면 , 003 : 탈회]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "CU020", codes = { "001", "002",
			"003" }, message = "[001 : 정상 , 002 : 휴면 , 003 : 탈회] 등록된 코드가 아닙니다. ")
	private String custStatusCd;

	/**
	 * 고객상태코드 공통코드 : CU020 [001 : 정상 , 002 : 휴면 , 003 : 탈회]
	 */
	@Parameter(description = "고객상태코드  [001 : 정상 , 002 : 휴면 , 003 : 탈회]", example = "", hidden = true, required = false)
	private String[] custStatusCds;

	/**
	 * 고객상태코드 공통코드 : CU020 [001 : 정상 , 002 : 휴면 , 003 : 탈회]
	 */
	@Parameter(description = "고객상태코드  [001 : 정상 , 002 : 휴면 , 003 : 탈회]", example = "", hidden = false, required = false)
	@CodeValue(codeId = "CU020", codes = { "001", "002",
			"003" }, message = "[001 : 정상 , 002 : 휴면 , 003 : 탈회] 등록된 코드가 아닙니다. ")
	private String custStatusCdNot;

	/**
	 * 고객상태변경일시
	 */
	@Parameter(description = "고객상태변경일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String custStatusChngDt;
	/**
	 * 고객정보변경일시
	 */
	@Parameter(description = "고객정보변경일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String custInfoChngDt;
	/**
	 * 고객유형코드 공통코드 : CU030 [001 : 잠재고객 , 002 : 가망고객 , 003 : 체험고객 , 004 : 구매고객 , 005
	 * : 추천고객 , 006 : 충성고객]
	 */
	@Parameter(description = "고객유형코드  [001 : 잠재고객 , 002 : 가망고객 , 003 : 체험고객 , 004 : 구매고객 , 005 : 추천고객 , 006 : 충성고객]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "CU030", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 잠재고객 , 002 : 가망고객 , 003 : 체험고객 , 004 : 구매고객 , 005 : 추천고객 , 006 : 충성고객] 등록된 코드가 아닙니다. ")

	private String custTypeCd;
	/**
	 * 고객구분코드 공통코드 : CU010 [001 : 개인 , 002 : 법인]
	 */
	@Parameter(description = "고객구분코드  [001 : 개인 , 002 : 법인]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "CU010", codes = { "001", "002" }, message = "[001 : 개인 , 002 : 법인] 등록된 코드가 아닙니다. ")
	private String custDivCd;
	/**
	 * 지역코드 공통코드 : CU100 [42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 ,
	 * 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시
	 * , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 ,
	 * 99 : 기타]
	 */
	@Parameter(description = "지역코드  [42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 , 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시 , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 , 99 : 기타]", example = "42", hidden = false, required = false)
	@CodeValue(codeId = "CU100", codes = { "42", "41", "48", "47", "29", "27", "30", "26", "11", "36", "31", "28", "46",
			"45", "50", "44", "43",
			"99" }, message = "[42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 , 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시 , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 , 99 : 기타] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String distrctCd;
	/**
	 * 우편번호
	 */
	@Parameter(description = "우편번호", example = "", hidden = true, required = false)
	private String zipCd;
	/**
	 * 주소1내용
	 */
	@Parameter(description = "주소1내용", example = "강남대로", hidden = true, required = false)
	@Length(min = 2, message = "주소는 최소 2이상 입력해야합니다.")
	private String addr1Ctnts;
	/**
	 * 주소2내용
	 */
	@Parameter(description = "주소2내용", example = "", hidden = true, required = false)
	private String addr2Ctnts;
	/**
	 * 추천매장번호
	 */
	@Parameter(description = "추천매장번호 [,로 구분]", example = "", hidden = false, required = false)
	private String rcmdStorNo;

	/**
	 * 추천인고객번호
	 */
	@Parameter(description = "추천인고객번호", example = "", hidden = false, required = false)
	private String rcmdrCustNo;
	/**
	 * 추천임직원번호
	 */
	@Parameter(description = "추천임직원번호", example = "", hidden = true, required = false)
	private String rcmdExecvdempNo;
	/**
	 * 결혼여부
	 */
	@Parameter(description = "결혼여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String marryYn;
	/**
	 * 대표가구번호
	 */
	@Parameter(description = "대표가구번호", example = "", hidden = true, required = false)
	private String repHshldNo;
	/**
	 * 가족관계코드 공통코드 : CU040 [001 : 부모 , 002 : 배우자 , 003 : 자녀]
	 */
	@Parameter(description = "가족관계코드  [001 : 부모 , 002 : 배우자 , 003 : 자녀]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "CU040", codes = { "001", "002",
			"003" }, message = "[001 : 부모 , 002 : 배우자 , 003 : 자녀] 등록된 코드가 아닙니다. ")
	private String famlyRelCd;
	/**
	 * 주거평수코드 공통코드 : CU050 [001 : 1평 ~ 10평 , 002 : 11평 ~ 20평 , 003 : 21평 ~ 30평 , 004
	 * : 30평 ~ 40평 , 005 : 41평 ~ 50평 , 006 : 51평 ~ 60평 , 007 : 61평 ~ 70평 , 008 : 71평
	 * ~ 80평 , 009 : 81평 이상]
	 */
	@Parameter(description = "주거평수코드  [001 : 1평 ~ 10평 , 002 : 11평 ~ 20평 , 003 : 21평 ~ 30평 , 004 : 30평 ~ 40평 , 005 : 41평 ~ 50평 , 006 : 51평 ~ 60평 , 007 : 61평 ~ 70평 , 008 : 71평 ~ 80평 , 009 : 81평 이상]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "CU050", codes = { "001", "002", "003", "004", "005", "006", "007", "008",
			"009" }, message = "[001 : 1평 ~ 10평 , 002 : 11평 ~ 20평 , 003 : 21평 ~ 30평 , 004 : 30평 ~ 40평 , 005 : 41평 ~ 50평 , 006 : 51평 ~ 60평 , 007 : 61평 ~ 70평 , 008 : 71평 ~ 80평 , 009 : 81평 이상] 등록된 코드가 아닙니다. ")
	private String dwelNfpyCd;
	/**
	 * 관심분야코드 공통코드 : CU060 [001 : 건강 , 002 : 음식 , 003 : 주거 , 004 : 의료 , 005 : 스포츠 ,
	 * 006 : 연예]
	 */
	@Parameter(description = "관심분야코드  [001 : 건강 , 002 : 음식 , 003 : 주거 , 004 : 의료 , 005 : 스포츠 , 006 : 연예]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "CU060", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 건강 , 002 : 음식 , 003 : 주거 , 004 : 의료 , 005 : 스포츠 , 006 : 연예] 등록된 코드가 아닙니다. ")
	private String intrstFildCd;
	/**
	 * 대표제품번호
	 */
	@Parameter(description = "대표제품번호", example = "", hidden = true, required = false)
	private String repGodsNo;
	/**
	 * 대표사용고객구분코드 공통코드 : CU010 [001 : 개인 , 002 : 법인]
	 */
	@Parameter(description = "대표사용고객구분코드  [001 : 개인 , 002 : 법인]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "CU010", codes = { "001", "002" }, message = "[001 : 개인 , 002 : 법인] 등록된 코드가 아닙니다. ")
	private String repUseCustDivCd;
	/**
	 * SMS수신동의여부
	 */
	@Parameter(description = "SMS수신동의여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String smsRcvAgreeYn;
	/**
	 * SMS수신동의일시
	 */
	@Parameter(description = "SMS수신동의일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String smsRcvAgreeDt;
	/**
	 * SMS수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Parameter(description = "SMS수신동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	private String smsRcvAgreeChlCd;
	/**
	 * 이메일수신동의여부
	 */
	@Parameter(description = "이메일수신동의여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String emailRcvAgreeYn;
	/**
	 * 이메일수신동의일시
	 */
	@Parameter(description = "이메일수신동의일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String emailRcvAgreeDt;
	/**
	 * 이메일수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Parameter(description = "이메일수신동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	private String emailRcvAgreeChlCd;
	/**
	 * 알람톡수신동의여부
	 */
	@Parameter(description = "알람톡수신동의여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String alrmTkRcvAgreeYn;
	/**
	 * 알람톡수신동의일시
	 */
	@Parameter(description = "알람톡수신동의일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String alrmTkRcvAgreeDt;
	/**
	 * 알람톡수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Parameter(description = "알람톡수신동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	private String alrmTkRcvAgreeChlCd;
	/**
	 * PUSH수신동의여부
	 */
	@Parameter(description = "PUSH수신동의여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String pushRcvAgreeYn;
	/**
	 * PUSH수신동의일시
	 */
	@Parameter(description = "PUSH수신동의일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String pushRcvAgreeDt;
	/**
	 * PUSH수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Parameter(description = "PUSH수신동의채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	private String pushRcvAgreeChlCd;
	/**
	 * CI인증여부
	 */
	@Parameter(description = "CI인증여부 [Y/N]", example = "N", hidden = true, required = false)
	@YnValue
	private String ciCertfYn;
	/**
	 * CI
	 */
	@Parameter(description = "CI", example = "abcdefghijklmnopqrstr123456789", hidden = false, required = false)
	private String ci;
	/**
	 * DI인증여부
	 */
	@Parameter(description = "DI인증여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String diCertfYn;
	/**
	 * DI
	 */
	@Parameter(description = "DI", example = "", hidden = true, required = false)
	private String di;
	/**
	 * 수신거부여부
	 */
	@Parameter(description = "수신거부여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String rcvRfslYn;
	/**
	 * 멤버십가입여부
	 */
	@Parameter(description = "멤버십가입여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String mshipSbscYn;
	/**
	 * 멤버십로그인ID
	 */
	@Parameter(description = "멤버십로그인ID", example = "", hidden = false, required = false)
	private String mshipLoginId;
	/**
	 * 멤버십대체번호
	 */
	@Parameter(description = "멤버십대체번호", example = "", hidden = true, required = false)
	private String mshipSbtNo;
	/**
	 * 멤버십로그인비밀번호
	 */
	@Parameter(description = "멤버십로그인비밀번호", example = "", hidden = true, required = false)
	private String mshipLoginPwd;
	/**
	 * 멤버십최종로그인일시
	 */
	@Parameter(description = "멤버십최종로그인일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String mshipLastLoginDt;
	/**
	 * 멤버십최종로그인IP주소
	 */
	@Parameter(description = "멤버십최종로그인IP주소", example = "", hidden = true, required = false)
	private String mshipLastLoginIpAddr;
	/**
	 * 멤버십최종매장방문일시
	 */
	@Parameter(description = "멤버십최종매장방문일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String mshipLastStorVisitDt;
	/**
	 * 멤버십최종방문매장번호
	 */
	@Parameter(description = "멤버십최종방문매장번호", example = "", hidden = true, required = false)
	private String mshipLastVisitStorNo;
	/**
	 * 멤버십유형코드 공통코드 : MB010 [001 : 임직원 , 002 : 제휴 , 003 : 회원 , 004 : 비회원]
	 */
	@Parameter(description = "멤버십유형코드  [001 : 임직원 , 002 : 제휴 , 003 : 회원 , 004 : 비회원]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "MB010", codes = { "001", "002", "003",
			"004" }, message = "[001 : 임직원 , 002 : 제휴 , 003 : 회원 , 004 : 비회원] 등록된 코드가 아닙니다. ")
	private String mshipTypeCd;
	/**
	 * 멤버십가입일시
	 */
	@Parameter(description = "멤버십가입일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String mshipSbscDt;
	/**
	 * 멤버십등급코드 공통코드 : MB020 [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드
	 * , 006 : VIP]
	 */
	@Parameter(description = "멤버십등급코드  [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "MB020", codes = { "001", "002", "003", "004", "005",
			"006" }, message = "[001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP] 등록된 코드가 아닙니다. ")
	private String mshipGradeCd;
	/**
	 * 멤버십등급변경일시
	 */
	@Parameter(description = "멤버십등급변경일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String mshipGradeChngDt;
	/**
	 * 멤버십정보변경일시
	 */
	@Parameter(description = "멤버십정보변경일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String mshipInfoChngDt;
	/**
	 * 멤버십정보확인자임직원번호
	 */
	@Parameter(description = "멤버십정보확인자임직원번호", example = "", hidden = true, required = false)
	private String mshipInfoConfrExecvdempNo;
	/**
	 * 제휴임직원번호
	 */
	@Parameter(description = "제휴임직원번호", example = "", hidden = true, required = false)
	private String cprtExecvdempNo;
	/**
	 * 멤버십탈퇴일시
	 */
	@Parameter(description = "멤버십탈퇴일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String mshipLeaveDt;
	/**
	 * 소멸포인트한도점수
	 */
	@Parameter(description = "소멸포인트한도점수", example = "", hidden = true, required = false)
	private Integer extncPointLmtScore;
	/**
	 * 적립포인트한도점수
	 */
	@Parameter(description = "적립포인트한도점수", example = "", hidden = true, required = false)
	private Integer accumPointLmtScore;

	/**
	 * 잔여포인트점수
	 */
	@Parameter(description = "잔여포인트점수", example = "", hidden = true, required = false)
	private Integer remainPointScore;

	/**
	 * 멤버십채널코드
	 */
	@Parameter(description = "멤버십채널코드", example = "", hidden = true, required = false)
	private String mshipChlCd;
	/**
	 * 주의고객등록매장번호
	 */
	@Parameter(description = "주의고객등록매장번호", example = "", hidden = true, required = false)
	private String bllkRegStorNo;
	/**
	 * 주의고객회원여부
	 */
	@Parameter(description = "주의고객회원여부 [Y/N]", example = "", hidden = true, required = false)
	@YnValue
	private String bllkmshpYn;
	/**
	 * 주의고객등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Parameter(description = "주의고객등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	private String bllkRegChlCd;
	/**
	 * 주의고객등록사유내용
	 */
	@Parameter(description = "주의고객등록사유내용", example = "", hidden = true, required = false)
	private String bllkRegWhyCtnts;
	/**
	 * 주의고객등록일시
	 */
	@Parameter(description = "주의고객등록일시 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	private String bllkRegDt;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
	 */
	@Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]", example = "", hidden = true, required = false)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS",
			"SAP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP] 등록된 코드가 아닙니다. ")
	private String regChlCd;

	/**
	 * 단골매장번호
	 */
	@Parameter(description = "단골매장번호", example = "123456", hidden = false, required = false)
	@MaxByte(max = 30)
	private String patronStorNo;

	/**
	 * 카드번호
	 */
	@Parameter(description = "카드번호", example = "1234123412341234", hidden = false, required = false)
	@MaxByte(max = 30)
	private String cardNo;

	/**
	 * 전화번호
	 */
	@Parameter(description = "전화번호", example = "01012345678", hidden = false, required = false)
	@MaxByte(max = 30)
	private String phoneNo;

	/**
	 * 전화번호
	 */
	@Parameter(description = "전화번호뒷자리", example = "5678", hidden = false, required = false)
	@MaxByte(max = 4)
	private String phoneBackNo;

	/**
	 * 전화번호
	 */
	@Parameter(description = "연락처포함여부", example = "N", hidden = false, required = false)
	@MaxByte(max = 1)
	@YnValue
	private String includeContactYn;

	@Parameter(description = "멤버십만 검색여부", hidden = false, example = "Y")
	@YnValue
	private String membershipOnly;

	@Parameter(description = "최종방문시작일", hidden = false)
	@DateValue
	private String visitStartYmd;

	@Parameter(description = "최종방문종료일", hidden = false)
	@DateValue
	private String visitEndYmd;

	@Parameter(description = "미방문일", hidden = false)
	private Integer noVisitDays;

	@Parameter(description = "보호가족여부", example = "", hidden = false, required = false)
	@YnValue
	private String prtctFamlyYn;
	/**
	 * 멤버십예정등급코드
	 */
	@Parameter(description = "멤버십예정등급코드", example = "", hidden = true, required = false)
	private String mshipExptGradeCd;
	/**
	 * 멤버십승급점수
	 */
	@Parameter(description = "멤버십승급점수", example = "", hidden = true, required = false)
	private Integer mshipAdvncmtScore;

	@Parameter(description = "시작멤버십승급점수", example = "", hidden = false, required = false)
	private Integer fromMshipAdvncmtScore;

	@Parameter(description = "종료멤버십승급점수", example = "", hidden = false, required = false)
	private Integer toMshipAdvncmtScore;

	@Parameter(description = "시작매출합계", example = "", hidden = false, required = false)
	private Long fromSaleAggrAmt;

	@Parameter(description = "종료매출합계", example = "", hidden = false, required = false)
	private Long toSaleAggrAmt;

//	@Parameter(description = "복호화여부", example = "", hidden = true, required = false)
//	private String decryptYn;

//	@Parameter(description = "구매시작일", hidden = false)
//	@DateValue
//	private String purchaseStartYmd;
//
//	@Parameter(description = "구매종료일", hidden = false)
//	@DateValue
//	private String purchaseEndYmd;
//	
//	@Parameter(description = "매장번호", hidden = false)
//	private String storNo;
//	
//	@Parameter(description = "체험시작일", hidden = false)
//	@DateValue
//	private String exprnStartYmd;
//
//	@Parameter(description = "체험종료일", hidden = false)
//	@DateValue
//	private String exprnEndYmd;
	@Parameter(description = "app토큰", hidden = false)
	private String appPushTokn;
	@Parameter(description = "체험여부", hidden = false)
	@YnValue
	private String exprnYn;

	@Parameter(description = "계약번호(CSS)")
	private String cntrNo;

	/**
	 * 전화번호
	 */
	@Parameter(description = "전화번호", example = "01012345678", hidden = true, required = false)
	public String getPhoneEncNo() {
		if (Utilities.isNotEmpty(phoneNo))
			try {
				return Utilities.encrypt(phoneNo);
			} catch (Exception e) {
				return phoneNo;
			}
		return phoneNo;
	}

	@Parameter(description = "통합고객번호리스트", example = "", hidden = true, required = false)
	public String[] getItgCustNoArray() {
		if (Utilities.isNotEmpty(itgCustNos))
			try {
				return itgCustNos.replace(" ", "").split(",");
			} catch (Exception e) {
				return null;
			}
		return null;
	}

	@Parameter(description = "추천매장번호 [,로 구분]", example = "", hidden = true, required = false)
	public String[] getRcmdStorNos() {
		if (Utilities.isEmpty(rcmdStorNo))
			return null;
		return rcmdStorNo.split(",");
	}
//	@AssertTrue(message = "통합고객번호[itgCustNo],고객명[custNm],이동전화번호[mphonNo],이동전화번호뒷자리[mphonBkDgtNo],전화번호[phoneNo],ci[ci],추천매장번호[rcmdStorNo],단골매장번호[patronStorNo],추천인고객번호[rcmdrCustNo] 중 하나 이상은 설정해야 합니다.")
//	protected boolean hasParam() {
//		return Utilities.isNotEmpty(itgCustNo) || Utilities.isNotEmpty(custNm) || Utilities.isNotEmpty(mphonNo)
//				|| Utilities.isNotEmpty(mphonBkDgtNo) || Utilities.isNotEmpty(ci) || Utilities.isNotEmpty(rcmdStorNo)
//				|| Utilities.isNotEmpty(patronStorNo) || Utilities.isNotEmpty(rcmdrCustNo)
//				|| Utilities.isNotEmpty(phoneNo);
//	}
}
