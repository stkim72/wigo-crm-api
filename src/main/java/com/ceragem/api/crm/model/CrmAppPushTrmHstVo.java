package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.DatetimeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmAppPushTrmHstVo
 * @author 김성태
 * @date 2023. 8. 7.
 * @Version 1.0
 * @description 앱PUSH전송이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "앱PUSH전송이력 객체")
public class CrmAppPushTrmHstVo extends ApiBaseVo {
	/**
	 * 전송이력ID
	 */
	@Schema(description = "전송이력ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String trmHstId;
	/**
	 * 발송이력ID
	 */
	@Schema(description = "발송이력ID", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String dspHstId;
	/**
	 * 통합고객번호
	 */
	@Schema(description = "통합고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String itgCustNo;
	/**
	 * 대상앱ID
	 */
	@Schema(description = "대상앱ID", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String tgtAppId;
	/**
	 * 앱PUSH토큰
	 */
	@Schema(description = "앱PUSH토큰", example = "", hidden = false, required = false, nullable = true, maxLength = 500)
	@MaxByte(max = 500)
	private String appPushTokn;
	/**
	 * 앱PUSHOS코드
	 */
	@Schema(description = "앱PUSHOS코드", example = "", hidden = false, required = false, nullable = true, maxLength = 2)
	@MaxByte(max = 2)
	private String appPushOsCd;

	/**
	 * 앱PUSHOS코드명
	 */
	@Schema(description = "앱PUSHOS코드명", example = "", hidden = false, required = false, nullable = true, maxLength = 2)
	private String appPushOsCdNm;

	/**
	 * 푸시명
	 */
	@Schema(description = "푸시명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String pushNm;
	/**
	 * 푸시메시지내역
	 */
	@Schema(description = "푸시메시지내역", example = "", hidden = false, required = false, nullable = true, maxLength = 4000)
	@MaxByte(max = 4000)
	private String pushMsgTxn;
	/**
	 * 푸시이미지URL
	 */
	@Schema(description = "푸시이미지URL", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String pushImgUrl;
	/**
	 * 푸시연결URL
	 */
	@Schema(description = "푸시연결URL", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String pushCnctUrl;
	/**
	 * 푸시데이터내역
	 */
	@Schema(description = "푸시데이터내역", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String pushDataTxn;
	/**
	 * 푸시전송일시
	 */
	@Schema(description = "푸시전송일시 (YYYYMMDDHH24MISS)", example = "20230807131415", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String pushTrmDt;
	/**
	 * 푸시수신동의여부
	 */
	@Schema(description = "푸시수신동의여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String pushRcvAgreeYn;
	/**
	 * 취소여부
	 */
	@Schema(description = "취소여부 [Y/N]", example = "N", hidden = false, required = true, nullable = false, maxLength = 1)
	@NotEmpty
	@YnValue
	@MaxByte(max = 1)
	private String cancelYn;
	/**
	 * 취소자ID
	 */
	@Schema(description = "취소자ID", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String cnclrId;
	/**
	 * 취소일시
	 */
	@Schema(description = "취소일시 (YYYYMMDDHH24MISS)", example = "20230807131415", hidden = false, required = false, nullable = true)
	@DatetimeValue
	private String cancelDt;
	/**
	 * 전송상태코드
	 */
	@Schema(description = "전송상태코드", example = "000", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String trmStatusCd;
	/**
	 * 전송상태코드
	 */
	@Schema(description = "전송상태코드명", example = "000", hidden = false, required = false, nullable = true, maxLength = 3)
	private String trmStatusCdNm;
	/**
	 * 푸시상태코드
	 */
	@Schema(description = "푸시상태코드", example = "000", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String pushStatusCd;
	/**
	 * 푸시상태코드
	 */
	@Schema(description = "푸시상태코드명", example = "000", hidden = false, required = false, nullable = true, maxLength = 3)
	private String pushStatusCdNm;
	/**
	 * 오류메시지코드
	 */
	@Schema(description = "오류메시지코드", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String errMsgCd;
	/**
	 * 오류메시지내역
	 */
	@Schema(description = "오류메시지내역", example = "", hidden = false, required = false, nullable = true)
	private String errMsgTxn;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS ,
	 * BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT , PRC : 부모님연구소 ,
	 * EON : 발송 , COM : 직영몰 , PUB : 공유사업자 , EXP : QR체험신청]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT , PRC : 부모님연구소 , EON : 발송 , COM : 직영몰 , PUB : 공유사업자 , EXP : QR체험신청]", example = "CRM", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP", "POS", "BOS", "MEM", "CRA", "DNA", "IoT", "PRC",
			"EON", "COM", "PUB",
			"EXP" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT , PRC : 부모님연구소 , EON : 발송 , COM : 직영몰 , PUB : 공유사업자 , EXP : QR체험신청] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;
}
