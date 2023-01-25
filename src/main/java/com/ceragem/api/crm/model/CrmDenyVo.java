package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @ClassName CrmDenyVo
 * @author 김성태
 * @date 2022. 9. 7.
 * @Version 1.0
 * @description 수신거부
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Schema(description = "CRM 수신거부 객체")
public class CrmDenyVo extends ApiBaseVo {
	/**
	 * 수신거부번호
	 */
	@Schema(description = "수신거부번호")
	public String uNumber;
	/**
	 * 수신거부요청번호
	 */
	@Schema(description = "수신거부요청번호")
	@NotEmpty
	public String rNumber;
	/**
	 * 수신거부번호
	 */
	@Schema(description = "수신거부 전달 일시")
	public String requestAt;

	public String getUNumber() {
		return uNumber;
	}

	public void setUNumber(String uNumber) {
		this.uNumber = uNumber;
	}

	public String getRNumber() {
		return rNumber;
	}

	public void setRNumber(String rNumber) {
		this.rNumber = rNumber;
	}

	public String getRequestAt() {
		return requestAt;
	}

	public void setRequestAt(String requestAt) {
		this.requestAt = requestAt;
	}

}
