package com.ceragem.api.crm.model;

import com.ceragem.api.base.util.Utilities;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName	MsgIfVo
 * @author		김성태
 * @date		2022. 8. 9.
 * @Version		1.0
 * @description	
 * @Company		Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class MsgCodeVo extends CrmComnCdBasVo {
	private String templateCode;
	private String tranSysDcd;
	private String sendProfileKey;
	private String reqUserId;
	private String reqDept;
	private String subject;
	private String content;
	private String btnInfo;
	private String ispStatusCode;
	private String tmplStatusCode;
	private String ispCplYn;
	private String errMsg;
	private String etc1;
	private String etc2;
	private String etc3;
	private String etc4;
	private String etc5;
	private String eaiStatus;
	private String createDate;
	private String modifyDate;
	private String sendYnCols;
	
	/**
	 * 바코드타입 
	 */
	private String barcodeType;
	/**
	 * 바코드생성폭 
	 */
	private String barcodeWidth;
	/**
	 * 바코드생성높이 
	 */
	private String barcodeHeight;
	/**
	 * 바코드삽입위치 X 좌표 
	 */
	private String barcodePosX;
	/**
	 * 바코드삽입위치 Y 좌표 
	 */
	private String barcodePosY;
	/**
	 * 바코드를 생성할 값 
	 */
	private String barcodeValue;


	private String barcodeOrgImg;

	private String barcodeImg;
	
	private String templateType;
	
	private String senderKey;
	
	

	public String getTalkTemplate() {
		return content;
	}

	public String getSmsTemplate() {
		return null;
	}

	public String getMailTemplate() {
		return null;
	}

	public String getTalkTemplateId() {
		return getRfrn1ComnCd();
	}

	public String getSmsTemplateId() {
		return getRfrn3ComnCd();
	}

	public String getMailTemplateId() {
		return getRfrn5ComnCd();
	}

	public String getTalkSendTime() {
		if (Utilities.isEmpty(getRfrn2ComnCd()))
			return null;
		else
			return (getRfrn2ComnCd() + "0000").substring(0, 6);
	}

	public String getSmsSendTime() {
		if (Utilities.isEmpty(getRfrn4ComnCd()))
			return null;
		else
			return (getRfrn4ComnCd() + "0000").substring(0, 6);

	}

	public String getMailSendTime() {
		if (Utilities.isEmpty(getRfrn6ComnCd()))
			return null;
		else
			return (getRfrn6ComnCd() + "0000").substring(0, 6);
	}

	public String getBtnTemplate() {
//		return getRfrn7ComnCd();
		return btnInfo;
	}
}
