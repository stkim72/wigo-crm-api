package com.ceragem.api.pub.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName PubBusinessBasSo
 * @author user
 * @date 2023. 5. 7.
 * @Version 1.0
 * @description 공유사업자 기본정보 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "공유사업자 기본정보 검색 객체")
public class PubBizrBasSo extends ApiPagination {
	/**
	 * 아이디
	 */
	@Parameter(description = "아이디", example = "", hidden = false, required = false)
	@Schema(description = "아이디", example = "", hidden = false, required = false, nullable = true)
	private String id;
	/**
	 * 암호
	 */
	@Parameter(description = "암호", example = "", hidden = true, required = false)
	@Schema(description = "암호", example = "", hidden = true, required = false, nullable = true)
	private String pwd;
	/**
	 * 사업자명
	 */
	@Parameter(description = "사업자명", example = "", hidden = false, required = false)
	@Schema(description = "사업자명", example = "", hidden = false, required = false, nullable = true)
	private String bizrNm;
	/**
	 * 사업자번호
	 */
	@Parameter(description = "사업자번호", example = "", hidden = false, required = false)
	@Schema(description = "사업자번호", example = "", hidden = false, required = false, nullable = true)
	private String bizrNo;
	/**
	 * 휴대전화
	 */
	@Parameter(description = "휴대전화", example = "", hidden = false, required = false)
	@Schema(description = "휴대전화", example = "", hidden = false, required = false, nullable = true)
	private String mphonNo;
	/**
	 * 이메일
	 */
	@Parameter(description = "이메일", example = "", hidden = true, required = false)
	@Schema(description = "이메일", example = "", hidden = true, required = false, nullable = true)
	private String emailAddr;
	/**
	 * 법인여부
	 */
	@Parameter(description = "법인여부 [Y/N]", example = "", hidden = true, required = false)
	@Schema(description = "법인여부 [Y/N]", example = "", hidden = true, required = false, nullable = true)
	@YnValue
	private String corpDivYn;
	/**
	 * 팩스번호
	 */
	@Parameter(description = "팩스번호", example = "", hidden = true, required = false)
	@Schema(description = "팩스번호", example = "", hidden = true, required = false, nullable = true)
	private String faxNo;
	/**
	 * 주소
	 */
	@Parameter(description = "주소", example = "", hidden = true, required = false)
	@Schema(description = "주소", example = "", hidden = true, required = false, nullable = true)
	private String addrCtnts;
	/**
	 * 주소
	 */
	@Parameter(description = "상세주소", example = "", hidden = true, required = false)
	@Schema(description = "상세주소", example = "", hidden = true, required = false, nullable = true)
	private String addr2Ctnts;
	/**
	 * 은행명
	 */
	@Parameter(description = "은행명", example = "", hidden = true, required = false)
	@Schema(description = "은행명", example = "", hidden = true, required = false, nullable = true)
	private String bankNm;
	/**
	 * 계좌번호
	 */
	@Parameter(description = "계좌번호", example = "", hidden = true, required = false)
	@Schema(description = "계좌번호", example = "", hidden = true, required = false, nullable = true)
	private String bankNo;
	/**
	 * 웰라운지
	 */
	@Parameter(description = "웰라운지", example = "", hidden = true, required = false)
	@Schema(description = "웰라운지", example = "", hidden = true, required = false, nullable = true)
	private String wellloungeCd;
	/**
	 * 상태
	 */
	@Parameter(description = "상태", example = "", hidden = true, required = false)
	@Schema(description = "상태", example = "", hidden = true, required = false, nullable = true)
	private String statusCd;
	/**
	 * 탈퇴일자
	 */
	@Parameter(description = "탈퇴일자 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false)
	@Schema(description = "탈퇴일자 (YYYYMMDDHH24MISS)", example = "", hidden = true, required = false, nullable = true)
	private String leaveDt;
	/**
	 * 공유사업자기본번호
	 */
	@Parameter(description = "공유사업자기본번호", example = "", hidden = false, required = false)
	@Schema(description = "공유사업자기본번호", example = "", hidden = false, required = false, nullable = true)
	private String pubBizrBasNo;
	/**
	 * 사업자번호 파일번호
	 */
	@Parameter(description = "사업자번호 파일번호", example = "", hidden = true, required = false)
	@Schema(description = "사업자번호 파일번호", example = "", hidden = true, required = false, nullable = true)
	private String bizrFileCd;
	/**
	 * 계좌번호 파일번호
	 */
	@Parameter(description = "계좌번호 파일번호", example = "", hidden = true, required = false)
	@Schema(description = "계좌번호 파일번호", example = "", hidden = true, required = false, nullable = true)
	private String bankFileCd;

	/**
	 * 검색어
	 */
	@Parameter(description = "검색어", example = "", hidden = true, required = false)
	@Schema(description = "검색어", example = "", hidden = true, required = false, nullable = true)
	private String searchWord;
}
