package com.ceragem.api.ctc.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmBllkCustHstVo
 * @author 임형진
 * @date 2022. 4. 15.
 * @Version 1.0
 * @description CTC고객정보조회 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CTC고객정보조회 객체")
public class ConsultHstInqryDetailSendVo {

	/**
	 * 상담이력번호
	 */
	@Schema(description = "상담이력번호", example = "468069", hidden = false, required = true, nullable = false, maxLength = 30)
	@MaxByte(max = 30)
	private String cnslHistNo;
	/**
	 * 상담일시
	 */
	@Schema(description = "상담일시", example = "20220103", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String cnslBeginDate;

	/**
	 * 상담시간
	 */
	@Schema(description = "상담시간", example = "145320", hidden = false, required = true, nullable = false, maxLength = 6)
	@MaxByte(max = 6)
	@NotEmpty
	private String cnslBeginTime;
	/**
	 * 콜유형
	 */
	@Schema(description = "콜유형", example = "20220101", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String callTy;
	/**
	 * 인입채널
	 */
	@Schema(description = "인입채널", example = "11", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String channel;
	/**
	 * 제품명
	 */
	@Schema(description = "제품명", example = "", hidden = false, required = false, nullable = true, maxLength = 300)
	@MaxByte(max = 300)
	private String productNm;
	/**
	 * 제품코드
	 */
	@Schema(description = "제품코드", example = "", hidden = false, required = false, nullable = true, maxLength = 60)
	@MaxByte(max = 60)
	private String productCd;
	/**
	 * as접수번호
	 */
	@Schema(description = "as접수번호", example = "", hidden = false, required = false, nullable = true, maxLength = 64)
	@MaxByte(max = 64)
	private String asRecpNo;
	/**
	 * 고객명
	 */
	@Schema(description = "고객명", example = "홍길동", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String custNm;
	/**
	 * 인입접수번호
	 */
	@Schema(description = "인입접수번호", example = "01051763688", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String custTelNo;
	/**
	 * 상담유형
	 */
	@Schema(description = "상담유형", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String cnslTypCd;
	/**
	 * 상담유형2
	 */
	@Schema(description = "상담유형2", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String cnslTypCd2;
	/**
	 * 상담유형3
	 */
	@Schema(description = "상담유형3", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String cnslTypCd3;

	/**
	 * 상담유형명
	 */
	@Schema(description = "상담유형명", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String cnslTypNm;
	/**
	 * 상담유형2
	 */
	@Schema(description = "상담유형명2", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String cnslTypNm2;
	/**
	 * 상담유형명3
	 */
	@Schema(description = "상담유형명3", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String cnslTypNm3;
	/**
	 * 불만여부
	 */
	@Schema(description = "불만여부", example = "", hidden = false, required = false, nullable = true, maxLength = 1)
	@MaxByte(max = 1)
	private String cmplYn;
	/**
	 * 녹취
	 */
	@Schema(description = "녹취ID", example = "", hidden = false, required = false, nullable = true, maxLength = 150)
	@MaxByte(max = 150)
	private String rdwtId;

	/**
	 * 접수자명
	 */
	@Schema(description = "접수자명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String userNm;

	/**
	 * 처리코드
	 */
	@Schema(description = "처리코드", example = "20220103", hidden = false, required = true, nullable = false, maxLength = 8)
	@MaxByte(max = 8)
	private String procCodeLcls;

	/**
	 * 처리코드명
	 */
	@Schema(description = "처리코드명", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String procNmLcls;
	/**
	 * 상담내용
	 */
	@Schema(description = "상담내용", example = "", hidden = false, required = false, nullable = true, maxLength = 4000)
	@MaxByte(max = 4000)
	private String cnslCntn;
	/**
	 * 답변내용
	 */
	@Schema(description = "답변내용", example = "", hidden = false, required = false, nullable = true, maxLength = 4000)
	@MaxByte(max = 4000)
	private String repleCntn;

}
