package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.base.util.Utilities;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmSnstvInfoInqryHstSo
 * @author 김성태
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM민감정보조회이력 So
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM민감정보조회이력 검색 객체")
public class CrmSnstvInfoInqrySo extends ApiPagination {

	/**
	 * 개인정보취급자번호
	 */
	@Parameter(description = "개인정보취급자번호", example = "10000001", hidden = false, required = false)
	@Schema(description = "개인정보취급자번호", example = "10000001", hidden = false, required = false)
	private String indiInfoHandlPrsnNo;
	/**
	 * 접속자IP주소
	 */
	@Parameter(description = "접속자IP주소", example = "", hidden = false, required = false)
	@Schema(description = "접속자IP주소", example = "", hidden = false, required = false)
	private String connPrsnIpAddr;
	/**
	 * 수행업무코드
	 */
	@Parameter(description = "수행업무코드", example = "001", hidden = true, required = false)
	@Schema(description = "수행업무코드", example = "001", hidden = false, required = false)
	private String pfmWorkCd;

	/**
	 * 다운로드사유
	 */
	@Parameter(description = "다운로드사유", example = "", hidden = true, required = false)
	@Schema(description = "다운로드사유", example = "", hidden = false, required = false)
	private String dnldTxn;
	
	@Parameter(description = "강제복호화", example = "", hidden = true)
	@Schema(description = "강제복호화", example = "", hidden = true)
	private boolean forceDecrypt = false;
	
	

	@Parameter(description = "", example = "", hidden = true, required = false)
	@Schema(description = "", example = "", hidden = true, required = false)
	public void setSo(CrmSnstvInfoInqrySo so) {
		if (so == null)
			return;
		this.indiInfoHandlPrsnNo = so.indiInfoHandlPrsnNo;
		this.connPrsnIpAddr = so.connPrsnIpAddr;
		this.pfmWorkCd = so.pfmWorkCd;
	}

	@Parameter(description = "", example = "", hidden = true, required = false)
	@Schema(description = "", example = "", hidden = true, required = false)
	public String getDecryptYn() {
		return this.forceDecrypt
				|| (Utilities.isNotEmpty(this.indiInfoHandlPrsnNo) && Utilities.isNotEmpty(this.connPrsnIpAddr)) ? "Y"
						: "N";
	}

}
