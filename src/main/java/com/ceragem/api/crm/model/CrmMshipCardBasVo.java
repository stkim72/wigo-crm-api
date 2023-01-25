package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiBaseVo;
import javax.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.ceragem.api.crm.validate.YnValue;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipCardBasVo
 * @author 김성태
 * @date 2022. 4. 26.
 * @Version 1.0
 * @description CRM멤버십카드기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십카드기본 객체")
public class CrmMshipCardBasVo extends ApiBaseVo {
	/**
	 * 멤버십카드기본번호
	 */
	@Schema(description = "멤버십카드기본번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String mshipCardBasNo;
	/**
	 * 카드유형코드 공통코드 : CD010 [001 : 실물카드 , 002 : 모바일카드]
	 */
	@Schema(description = "카드유형코드  [001 : 실물카드 , 002 : 모바일카드]", example = "001", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	@CodeValue(codeId = "CD010", codes = { "001", "002" }, message = "[001 : 실물카드 , 002 : 모바일카드] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String cardTypeCd;

	@Schema(description = "카드유형코드명", example = "", hidden = false, required = true, nullable = false)
	private String cardTypeCdNm;
	/**
	 * 멤버십등급적용내용
	 */
	@Schema(description = "멤버십등급적용내용", example = "", hidden = false, required = false, nullable = true, maxLength = 6)
	@MaxByte(max = 6)
	private String mshipGradeApplyCtnts;
	/**
	 * 카드사용기간
	 */
	@Schema(description = "카드사용기간", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String cardUsePerd;
	/**
	 * 카드유효기간
	 */
	@Schema(description = "카드유효기간", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String cardValidPerd;
	/**
	 * 발급수
	 */
	@Schema(description = "발급수", example = "", hidden = false, required = false, nullable = true)
	private Integer issueCnt;
	/**
	 * 포인트적립율
	 */
	@Schema(description = "포인트적립율", example = "", hidden = false, required = false, nullable = true)
	private Integer pointAccumRate;
	/**
	 * 가입포인트점수
	 */
	@Schema(description = "가입포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer sbscPointScore;
	/**
	 * 가입포인트적용기준코드
	 */
	@Schema(description = "가입포인트적용기준코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String sbscPointApplyStdCd;
	@Schema(description = "가입포인트적용기준코드명", example = "", hidden = false, required = true, nullable = false)
	private String sbscPointApplyStdCdNm;
	/**
	 * 승급포인트점수
	 */
	@Schema(description = "승급포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer advncmtPointScore;
	/**
	 * 승급포인트적용기준코드
	 */
	@Schema(description = "승급포인트적용기준코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String advncmtPointApplyStdCd;
	@Schema(description = "승급포인트적용기준코드명", example = "", hidden = false, required = true, nullable = false)
	private String advncmtPointApplyStdCdNm;
	/**
	 * 음료할인율
	 */
	@Schema(description = "음료할인율", example = "", hidden = false, required = false, nullable = true)
	private Integer drnkDcRate;
	/**
	 * 일음료제공수
	 */
	@Schema(description = "일음료제공수", example = "", hidden = false, required = false, nullable = true)
	private Integer dayDrnkPrvCnt;
	/**
	 * 음료제공수
	 */
	@Schema(description = "음료제공수", example = "", hidden = false, required = false, nullable = true)
	private Integer drnkPrvCnt;
	/**
	 * 자사몰무료배송여부
	 */
	@Schema(description = "자사몰무료배송여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String mycomMallFreeDlvYn;
	/**
	 * 음료무료적용스탬프수
	 */
	@Schema(description = "음료무료적용스탬프수", example = "", hidden = false, required = false, nullable = true)
	private Integer drnkFreeApplyStmpCnt;
	/**
	 * 무료서비스연장개월수
	 */
	@Schema(description = "무료서비스연장개월수", example = "", hidden = false, required = false, nullable = true)
	private Integer freeSvcExtnsnMonsCnt;
	/**
	 * 세라케어쿠폰제공개월수
	 */
	@Schema(description = "세라케어쿠폰제공개월수", example = "", hidden = false, required = false, nullable = true)
	private Integer ceracCoupnPrvMonsCnt;
	/**
	 * 세라체크쿠폰제공개월수
	 */
	@Schema(description = "세라체크쿠폰제공개월수", example = "", hidden = false, required = false, nullable = true)
	private Integer crckCoupnPrvMonsCnt;
	/**
	 * 제품제한여부
	 */
	@Schema(description = "제품제한여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String godsRstrtnYn;
	/**
	 * 상태코드
	 */
	@Schema(description = "상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String statusCd;
	/**
	 * 카드기본명
	 */
	@Schema(description = "카드기본명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String cardBasNm;
	/**
	 * 카드기본내용
	 */
	@Schema(description = "카드기본내용", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String cardBasCtnts;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP",
			"test" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;

	@Schema(description = "등록채널코드명", example = "", hidden = false, required = false, nullable = true)
	private String regChlCdNm;
}
