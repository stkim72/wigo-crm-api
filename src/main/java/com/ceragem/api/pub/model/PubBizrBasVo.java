package com.ceragem.api.pub.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName PubBusinessBasVo
 * @author user
 * @date 2023. 5. 7.
 * @Version 1.0
 * @description 공유사업자 기본정보 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "공유사업자 기본정보 객체")
public class PubBizrBasVo extends ApiBaseVo {

	/**
	 * 아이디
	 */
	@Schema(description = "아이디", example = "", hidden = false, required = true, nullable = false, maxLength = 50)
	@NotEmpty
	@MaxByte(max = 50)
	private String id;
	/**
	 * 암호
	 */
	@Schema(description = "암호", example = "", hidden = true, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String pwd;
	/**
	 * 사업자명
	 */
	@Schema(description = "사업자명", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	@MaxByte(max = 100)
	private String bizrNm;
	/**
	 * 사업자번호
	 */
	@Schema(description = "사업자번호", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	@MaxByte(max = 100)
	private String bizrNo;
	/**
	 * 휴대전화
	 */
	@Schema(description = "휴대전화", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	@MaxByte(max = 100)
	private String mphonNo;
	/**
	 * 이메일
	 */
	@Schema(description = "이메일", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String emailAddr;
	/**
	 * 법인여부
	 */
	@Schema(description = "법인여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true)
	@YnValue
	private String corpDivYn;
	/**
	 * 팩스번호
	 */
	@Schema(description = "팩스번호", example = "", hidden = false, required = false, nullable = true, maxLength = 50)
	@MaxByte(max = 50)
	private String faxNo;

	/**
	 * 우편번호
	 */
	@Schema(description = "우편번호", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String zipCd;

	/**
	 * 주소
	 */
	@Schema(description = "주소", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String addrCtnts;

	/**
	 * 상세주소
	 */
	@Schema(description = "상세주소", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String addr2Ctnts;

	/**
	 * 은행명
	 */
	@Schema(description = "은행명", example = "", hidden = false, required = false, nullable = true, maxLength = 50)
	@MaxByte(max = 50)
	private String bankNm;
	/**
	 * 계좌번호
	 */
	@Schema(description = "계좌번호", example = "", hidden = false, required = false, nullable = true, maxLength = 50)
	@MaxByte(max = 50)
	private String bankNo;
	/**
	 * 웰라운지
	 */
	@Schema(description = "웰라운지", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String wellloungeCd;
	/**
	 * 상태
	 */
	@Schema(description = "상태(001 정상, 005 탈퇴)", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String statusCd;
	/**
	 * 탈퇴일자
	 */
	@Schema(description = "탈퇴일자 (YYYYMMDDHH24MISS)", example = "20230507124058", hidden = true, required = false, nullable = true)
	@DatetimeValue
	private String leaveDt;
	/**
	 * 공유사업자기본번호
	 */
	@Schema(description = "공유사업자기본번호", example = "", hidden = true, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String pubBizrBasNo;

	/**
	 * 사업자번호 파일번호
	 */
	@Schema(description = "사업자번호 파일번호", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String bizrFileCd;

	/**
	 * 계좌번호 파일번호
	 */
	@Schema(description = "계좌번호 파일번호", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String bankFileCd;

	/**
	 * 계좌번호 파일번호
	 */
	@Schema(description = "통합회원번호", example = "", hidden = true, required = false, nullable = true, maxLength = 100)
	private String itgCustNo;

	/**
	 * 검색어
	 */
	@Schema(description = "검색어", example = "", hidden = true, required = false, nullable = true)
	private String searchWord;
}
