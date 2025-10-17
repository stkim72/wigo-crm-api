package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipAppToknBasVo
 * @author 김성태
 * @date 2023. 5. 26.
 * @Version 1.0
 * @description 멤버십앱토큰기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "멤버십앱토큰기본 객체")
public class CrmMshipAppToknBasVo extends ApiBaseVo {
	/**
	 * 앱PUSH토큰
	 */
	@Schema(description = "앱PUSH토큰", example = "", hidden = false, required = true, nullable = false, maxLength = 100)
	@NotEmpty
	@MaxByte(max = 1000)
	private String appPushTokn;
	/**
	 * 앱PUSHOS코드
	 */
	@Schema(description = "앱PUSHOS코드", example = "1", hidden = false, required = true, nullable = false, maxLength = 2)
	@NotEmpty
	@MaxByte(max = 2)
	@CodeValue(codeId = "MB220", codes = { "1", "2", "3" }, message = "[1 : 안드로이드 , 2 : iOs , 3 : web] 등록된 코드가 아닙니다. ")
	private String appPushOsCd;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String itgCustNo;
	/**
	 * 동의여부
	 */
	@Schema(description = "동의여부 [Y/N] 동의/거부시에만 입력", example = "Y", hidden = false, required = false, nullable = true, maxLength = 20)
	@YnValue
	@MaxByte(max = 20)
	private String agreeYn;
	/**
	 * 동의일시
	 */
	@Schema(description = "동의일시 (YYYYMMDDHH24MISS) 현재시간이 아닐경우만 입력", example = "20230526114229", hidden = true, required = false, nullable = true)
	@DatetimeValue
	private String agreeDt;
	/**
	 * 거부일시
	 */
	@Schema(description = "거부일시 (YYYYMMDDHH24MISS) 현재시간이 아닐경우만 입력", example = "20230526114229", hidden = true, required = false, nullable = true)
	@DatetimeValue
	private String rfslDt;
	/**
	 * 등록채널코드 공통코드 : PS020 [MEM : 멤버십 , IoT : IoT , COM : 직영몰 ]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]", example = "CRM", hidden = true, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"POS" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;

	@Schema(description = "대상앱ID", example = "", hidden = true, required = false, nullable = false, maxLength = 20)
	@CodeValue(codeId = "PS030", codes = {}, message = " [] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 20)
	private String tgtAppId;

	/**
	 * 사용여부
	 */
	@Schema(description = "사용여부 [Y/N] ", example = "Y", hidden = false, required = false, nullable = true, maxLength = 20, accessMode = AccessMode.READ_ONLY)
	@YnValue
	@MaxByte(max = 20)
	@Hidden
	private String useYn;

	@Hidden
	public String getPushRcvAgreeYn() {
		return getAgreeYn();
	}
}
