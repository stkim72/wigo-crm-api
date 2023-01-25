package com.ceragem.api.crm.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmMshipPromBasVo
 * @author 김성태
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description CRM멤버십프로모션기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십프로모션기본 객체")
public class CrmMshipPromBasVo extends ApiBaseVo {
	/**
	 * 멤버십프로모션기본번호
	 */
	@Schema(description = "멤버십프로모션기본번호", example = "", hidden = false, required = true, nullable = false, maxLength = 30)
	@NotEmpty
	@MaxByte(max = 30)
	private String mshipPromBasNo;
	/**
	 * 프로모션시작년월일
	 */
	@Schema(description = "프로모션시작년월일", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	@MaxByte(max = 8)
	private String promStaYmd;
	/**
	 * 프로모션유형코드 공통코드 : PM100 [001 : 정기 , 002 : 이벤트 , 003 : 할인행사 , 004 : 체험단모집 , 005
	 * : 한정제품판매]
	 */
	@Schema(description = "프로모션유형코드  [001 : 정기 , 002 : 이벤트 , 003 : 할인행사 , 004 : 체험단모집 , 005 : 한정제품판매]", example = "001", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	@CodeValue(codeId = "PM100", codes = { "001", "002", "003", "004",
			"005" }, message = "[001 : 정기 , 002 : 이벤트 , 003 : 할인행사 , 004 : 체험단모집 , 005 : 한정제품판매] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String promTypeCd;

	@Schema(description = "프로모션유형코드명", accessMode = AccessMode.READ_ONLY)
	private String promTypeCdNm;

	/**
	 * 프로모션종료년월일
	 */
	@Schema(description = "프로모션종료년월일", example = "", hidden = false, required = true, nullable = false, maxLength = 8)
	@NotEmpty
	@MaxByte(max = 8)
	private String promEndYmd;
	/**
	 * 프로모션기본내용
	 */
	@Schema(description = "프로모션기본내용", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String promBasCtnts;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS ,
	 * BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]
	 */
	@Schema(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]", example = "CRM", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "S000", codes = { "CRM", "CTC", "AS", "SAP", "POS", "BOS", "MEM", "CERA", "DNA",
			"IoT" }, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS , BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String regChlCd;
	/**
	 * 광고노출여부
	 */
	@Schema(description = "광고노출여부 [Y/N]", example = "N", hidden = false, required = true, nullable = false, maxLength = 1)
	@NotEmpty
	@YnValue
	@MaxByte(max = 1)
	private String advmShowYn;
	
//	/**
//	 * 사용채널정책코드
//	 */
//	@Schema(description = "사용채널정책코드", example = "", hidden = true, required = false, nullable = true, maxLength = 6)
//	@MaxByte(max = 6)
//	private String useChlPlcyCd;
	
	/**
	 * FROM적용매출금액
	 */
	@Schema(description = "FROM적용매출금액", example = "", hidden = false, required = false, nullable = true)
	private Integer fromApplySaleAmt;
	/**
	 * TO적용매출금액
	 */
	@Schema(description = "TO적용매출금액", example = "", hidden = false, required = false, nullable = true)
	private Integer toApplySaleAmt;
	/**
	 * FROM적용매출조건코드 공통코드 : MB050 [01 : 이상 , 02 : 초과]
	 */
	@Schema(description = "FROM적용매출조건코드  [01 : 이상 , 02 : 초과]", example = "01", hidden = false, required = false, nullable = true, maxLength = 2)
	@CodeValue(codeId = "MB050", codes = { "01", "02" }, message = "[01 : 이상 , 02 : 초과] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 2)
	private String fromApplySaleCondCd;

	@Schema(description = "FROM적용매출조건코드명", accessMode = AccessMode.READ_ONLY)

	private String fromApplySaleCondCdNm;

	/**
	 * TO적용매출조건코드 공통코드 : MB060 [01 : 이하 , 02 : 미만]
	 */
	@Schema(description = "TO적용매출조건코드  [01 : 이하 , 02 : 미만]", example = "01", hidden = false, required = false, nullable = true, maxLength = 2)
	@CodeValue(codeId = "MB060", codes = { "01", "02" }, message = "[01 : 이하 , 02 : 미만] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 2)
	private String toApplySaleCondCd;

	@Schema(description = "TO적용매출조건코드명", accessMode = AccessMode.READ_ONLY)

	private String toApplySaleCondCdNm;

	/**
	 * FROM적용결제금액
	 */
	@Schema(description = "FROM적용결제금액", example = "", hidden = false, required = false, nullable = true)
	private Integer fromApplyPayAmt;
	/**
	 * TO적용결제금액
	 */
	@Schema(description = "TO적용결제금액", example = "", hidden = false, required = false, nullable = true)
	private Integer toApplyPayAmt;
	/**
	 * FROM적용결제조건코드 공통코드 : MB050 [01 : 이상 , 02 : 초과]
	 */
	@Schema(description = "FROM적용결제조건코드  [01 : 이상 , 02 : 초과]", example = "01", hidden = false, required = false, nullable = true, maxLength = 2)
	@CodeValue(codeId = "MB050", codes = { "01", "02" }, message = "[01 : 이상 , 02 : 초과] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 2)
	private String fromApplyPayCondCd;

	@Schema(description = "FROM적용결제조건코드명", accessMode = AccessMode.READ_ONLY)

	private String fromApplyPayCondCdNm;

	/**
	 * TO적용결제조건코드 공통코드 : MB060 [01 : 이하 , 02 : 미만]
	 */
	@Schema(description = "TO적용결제조건코드  [01 : 이하 , 02 : 미만]", example = "01", hidden = false, required = false, nullable = true, maxLength = 2)
	@CodeValue(codeId = "MB060", codes = { "01", "02" }, message = "[01 : 이하 , 02 : 미만] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 2)
	private String toApplyPayCondCd;

	@Schema(description = "TO적용결제조건코드명", accessMode = AccessMode.READ_ONLY)

	private String toApplyPayCondCdNm;

	/**
	 * 적용멤버십등급코드
	 */
	@Schema(description = "적용멤버십등급코드", example = "", hidden = false, required = false, nullable = true, maxLength = 3)
	@MaxByte(max = 3)
	private String applyMshipGradeCd;
	/**
	 * 중복사용여부
	 */
	@Schema(description = "중복사용여부 [Y/N]", example = "N", hidden = false, required = false, nullable = true, maxLength = 1)
	@YnValue
	@MaxByte(max = 1)
	private String dupUseYn;
	/**
	 * 적용혜택코드 공통코드 : PM120 [001 : 포인트 , 002 : 쿠폰]
	 */
	@Schema(description = "적용혜택코드  [001 : 포인트 , 002 : 쿠폰]", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	@CodeValue(codeId = "PM120", codes = { "001", "002" }, message = "[001 : 포인트 , 002 : 쿠폰] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String applyBnfitCd;

	@Schema(description = "적용혜택코드명", accessMode = AccessMode.READ_ONLY)
	private String applyBnfitCdNm;
//	/**
//	 * 쿠폰적용구분코드1
//	 */
//	@Schema(description = "쿠폰적용구분코드1", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
//	@MaxByte(max = 3)
//	private String coupnApplyDivCd1;
//	/**
//	 * 쿠폰적용구분코드2
//	 */
//	@Schema(description = "쿠폰적용구분코드2", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
//	@MaxByte(max = 3)
//	private String coupnApplyDivCd2;
	/**
	 * 적용할인율
	 */
	@Schema(description = "적용할인율", example = "", hidden = false, required = false, nullable = true)
	private Integer applyDcRate;
	/**
	 * 적용할인금액
	 */
	@Schema(description = "적용할인금액", example = "", hidden = false, required = false, nullable = true)
	private Integer applyDcAmt;
	/**
	 * 포인트적립율
	 */
	@Schema(description = "포인트적립율", example = "", hidden = false, required = false, nullable = true)
	private Integer pointAccumRate;
	/**
	 * 스탬프제공수
	 */
	@Schema(description = "스탬프제공수", example = "", hidden = false, required = false, nullable = true)
	private Integer stmpPrvCnt;
	/**
	 * 제공쿠폰기본번호
	 */
	@Schema(description = "제공쿠폰기본번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String prvCoupnBasNo;
	/**
	 * 상태코드 공통코드 : PM110 [001 : 대기중 , 002 : 진행중 , 003 : 승인대기중 , 004 : 기타]
	 */
	@Schema(description = "상태코드  [001 : 대기중 , 002 : 진행중 , 003 : 승인대기중 , 004 : 기타]", example = "001", hidden = false, required = true, nullable = false, maxLength = 3)
	@NotEmpty
	@CodeValue(codeId = "PM110", codes = { "001", "002", "003",
			"004" }, message = "[001 : 대기중 , 002 : 진행중 , 003 : 승인대기중 , 004 : 기타] 등록된 코드가 아닙니다. ")
	@MaxByte(max = 3)
	private String statusCd;
	
	@Schema(description = "상태코드명", accessMode = AccessMode.READ_ONLY)
	private String statusCdNm;
	
	
	/**
	 * 프로모션기본명
	 */
	@Schema(description = "프로모션기본명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String promBasNm;
	/**
	 * 적용회원등급내용 공통코드 : MB020 [002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 :
	 * VIP , 001 : 일반]
	 */
	@Schema(description = "적용회원등급내용 ,구분 [002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드 , 006 : VIP , 001 : 일반]", example = "002,003", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String applyMshpGradeCtnts;
//	/**
//	 * 적용멤버십등급코드1
//	 */
//	@Schema(description = "적용멤버십등급코드1", example = "", hidden = true, required = false, nullable = true, maxLength = 3)
//	@MaxByte(max = 3)
//	private String applyMshipGradeCd1;
	/**
	 * 제휴회사번호
	 */
	@Schema(description = "제휴회사번호", example = "", hidden = false, required = false, nullable = true, maxLength = 30)
	@MaxByte(max = 30)
	private String cprtCmpNo;
	/**
	 * 적용포인트점수
	 */
	@Schema(description = "적용포인트점수", example = "", hidden = false, required = false, nullable = true)
	private Integer applyPointScore;

	@Schema(description = "적용매장", example = "", hidden = false, required = false, nullable = true)

	private List<CrmStorBasVo> storeList;

	@Schema(description = "적용상품", example = "", hidden = false, required = false, nullable = true)

	private List<CrmGodsBasVo> goodsList;

	public void setStoreList(String info) {
		storeList = null;
		if (Utilities.isEmpty(info))
			return;
		storeList = new ArrayList<CrmStorBasVo>();
		String[] arr = info.split(",");
		for (int i = 0; i < arr.length; i++) {
			String[] st = arr[i].split("/");
			if (st.length == 2) {
				CrmStorBasVo vo = new CrmStorBasVo();
				vo.setStorNo(st[0]);
				vo.setStorNm(st[1]);
				storeList.add(vo);
			}
		}
	}

	public void setGoodsList(String info) {
		storeList = null;
		if (Utilities.isEmpty(info))
			return;
		goodsList = new ArrayList<CrmGodsBasVo>();
		String[] arr = info.split(",");
		for (int i = 0; i < arr.length; i++) {
			String[] st = arr[i].split("/");
			if (st.length == 2) {
				CrmGodsBasVo vo = new CrmGodsBasVo();
				vo.setGodsNo(st[0]);
				vo.setGodsNm(st[1]);
				goodsList.add(vo);
			}
		}
	}
}
