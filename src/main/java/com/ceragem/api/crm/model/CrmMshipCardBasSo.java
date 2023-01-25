package com.ceragem.api.crm.model;

import com.ceragem.api.base.model.ApiPagination;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.YnValue;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmMshipCardBasSo
 * @author    김성태
 * @date    2022. 4. 26.
 * @Version    1.0
 * @description    CRM멤버십카드기본 So
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM멤버십카드기본 검색 객체")
public class CrmMshipCardBasSo extends ApiPagination {
    /**
    * 멤버십카드기본번호 
    */
    @Parameter(description = "멤버십카드기본번호", example = "", hidden = true, required = false)
    private String mshipCardBasNo;
    /**
    * 카드유형코드 
    * 공통코드 : CD010 [001 : 실물카드 , 002 : 모바일카드]
    */
    @Parameter(description = "카드유형코드  [001 : 실물카드 , 002 : 모바일카드]", example = "", hidden = true, required = false)
    @CodeValue(codeId = "CD010", codes = {"001","002"}, message = "[001 : 실물카드 , 002 : 모바일카드] 등록된 코드가 아닙니다. ")
    private String cardTypeCd;
    /**
    * 멤버십등급적용내용 
    */
    @Parameter(description = "멤버십등급적용내용", example = "", hidden = true, required = false)
    private String mshipGradeApplyCtnts;
    /**
    * 카드사용기간 
    */
    @Parameter(description = "카드사용기간", example = "", hidden = true, required = false)
    private String cardUsePerd;
    /**
    * 카드유효기간 
    */
    @Parameter(description = "카드유효기간", example = "", hidden = true, required = false)
    private String cardValidPerd;
    /**
    * 발급수 
    */
    @Parameter(description = "발급수", example = "", hidden = true, required = false)
    private Integer issueCnt;
    /**
    * 포인트적립율 
    */
    @Parameter(description = "포인트적립율", example = "", hidden = true, required = false)
    private Integer pointAccumRate;
    /**
    * 가입포인트점수 
    */
    @Parameter(description = "가입포인트점수", example = "", hidden = true, required = false)
    private Integer sbscPointScore;
    /**
    * 가입포인트적용기준코드 
    */
    @Parameter(description = "가입포인트적용기준코드", example = "", hidden = true, required = false)
    private String sbscPointApplyStdCd;
    /**
    * 승급포인트점수 
    */
    @Parameter(description = "승급포인트점수", example = "", hidden = true, required = false)
    private Integer advncmtPointScore;
    /**
    * 승급포인트적용기준코드 
    */
    @Parameter(description = "승급포인트적용기준코드", example = "", hidden = true, required = false)
    private String advncmtPointApplyStdCd;
    /**
    * 음료할인율 
    */
    @Parameter(description = "음료할인율", example = "", hidden = true, required = false)
    private Integer drnkDcRate;
    /**
    * 일음료제공수 
    */
    @Parameter(description = "일음료제공수", example = "", hidden = true, required = false)
    private Integer dayDrnkPrvCnt;
    /**
    * 음료제공수 
    */
    @Parameter(description = "음료제공수", example = "", hidden = true, required = false)
    private Integer drnkPrvCnt;
    /**
    * 자사몰무료배송여부 
    */
    @Parameter(description = "자사몰무료배송여부 [Y/N]", example = "", hidden = true, required = false)
    @YnValue
    private String mycomMallFreeDlvYn;
    /**
    * 음료무료적용스탬프수 
    */
    @Parameter(description = "음료무료적용스탬프수", example = "", hidden = true, required = false)
    private Integer drnkFreeApplyStmpCnt;
    /**
    * 무료서비스연장개월수 
    */
    @Parameter(description = "무료서비스연장개월수", example = "", hidden = true, required = false)
    private Integer freeSvcExtnsnMonsCnt;
    /**
    * 세라케어쿠폰제공개월수 
    */
    @Parameter(description = "세라케어쿠폰제공개월수", example = "", hidden = true, required = false)
    private Integer ceracCoupnPrvMonsCnt;
    /**
    * 세라체크쿠폰제공개월수 
    */
    @Parameter(description = "세라체크쿠폰제공개월수", example = "", hidden = true, required = false)
    private Integer crckCoupnPrvMonsCnt;
    /**
    * 제품제한여부 
    */
    @Parameter(description = "제품제한여부 [Y/N]", example = "", hidden = true, required = false)
    @YnValue
    private String godsRstrtnYn;
    /**
    * 상태코드 
    */
    @Parameter(description = "상태코드", example = "", hidden = true, required = false)
    private String statusCd;
    /**
    * 카드기본명 
    */
    @Parameter(description = "카드기본명", example = "", hidden = true, required = false)
    private String cardBasNm;
    /**
    * 카드기본내용 
    */
    @Parameter(description = "카드기본내용", example = "", hidden = true, required = false)
    private String cardBasCtnts;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]
    */
    @Parameter(description = "등록채널코드  [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test]", example = "", hidden = true, required = false)
    @CodeValue(codeId = "S000", codes = {"CRM","CTC","AS","SAP","test"}, message = "[CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , test : test] 등록된 코드가 아닙니다. ")
    private String regChlCd;
}
