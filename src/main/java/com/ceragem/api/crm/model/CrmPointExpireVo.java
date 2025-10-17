package com.ceragem.api.crm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmPointHstVo
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM포인트이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM포인트 소멸 정보", accessMode = AccessMode.READ_ONLY)
public class CrmPointExpireVo {

	/**
	 * 전표번호
	 */
	@Schema(description = "통합고객번호")
	private String itgCustNo;

	/**
	 * 발급일시
	 */
	@Schema(description = "발급일시")
	private String pblsDt;

	/**
	 * 발급년월일
	 */
	@Schema(description = "발급년월일")
	private String pblsYmd;
	/**
	 * 구매제품번호
	 */
	@Schema(description = "소멸년월일")
	private String expireYmd;

	/**
	 * 발급포인트
	 */

	@Schema(description = "발급포인트")
	private int pblsPoint;

	/**
	 * 사용포인트
	 */

	@Schema(description = "사용포인트")
	private int usePoint;

	/**
	 * 소멸포인트
	 */
	@Schema(description = "소멸포인트")
	private int expirePoint;

	/**
	 * 사용유형코드
	 */
	@Schema(description = "사용유형코드")
	private String useTypeCd;

	/**
	 * 사용유형코드명
	 */
	@Schema(description = "사용유형코드명")
	private String useTypeCdNm;
	/**
	 * 발급구분코드
	 */
	@Schema(description = "발급구분코드")
	private String pblsDivCd;
	/**
	 * 발급구분코드명
	 */
	@Schema(description = "발급구분코드명")
	private String pblsDivCdNm;
	/**
	 * 발급채널
	 */
	@Schema(description = "발급채널")
	private String pblsChlCd;

	/**
	 * 발급채널명
	 */
	@Schema(description = "발급채널명")
	private String pblsChlCdNm;
}
