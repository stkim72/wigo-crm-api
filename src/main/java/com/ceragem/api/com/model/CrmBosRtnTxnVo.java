package com.ceragem.api.com.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmBosRtnTxnVo
 * @author 김성태
 * @date 2023. 6. 14.
 * @Version 1.0
 * @description CRMBOS반환내역 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRMBOS반환내역 객체")
public class CrmBosRtnTxnVo extends ApiBaseVo {
	/**
	 * 계약번호
	 */
	@Schema(description = "계약번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@NotEmpty
	@MaxByte(max = 12)
	private String cntrno;
	/**
	 * 반환순번
	 */
	@Schema(description = "반환순번", example = "", hidden = false, required = true, nullable = false)
	private Integer rtnsn;
	/**
	 * 고객번호
	 */
	@Schema(description = "고객번호", example = "", hidden = false, required = true, nullable = false, maxLength = 10)
	@NotEmpty
	@MaxByte(max = 10)
	private String custno;
	/**
	 * 주문번호
	 */
	@Schema(description = "주문번호", example = "", hidden = false, required = true, nullable = false, maxLength = 12)
	@NotEmpty
	@MaxByte(max = 12)
	private String ordno;
	/**
	 * 반환유형코드
	 */
	@Schema(description = "반환유형코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rtntycd;
	/**
	 * 반환유형
	 */
	@Schema(description = "반환유형", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rtntycdnm;
	/**
	 * 반환상태코드
	 */
	@Schema(description = "반환상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rtnstscd;
	/**
	 * 반환상태
	 */
	@Schema(description = "반환상태", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rtnstscdnm;
	/**
	 * 반환상태상세코드
	 */
	@Schema(description = "반환상태상세코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rtnstsdtlcd;
	/**
	 * 반환상태상세
	 */
	@Schema(description = "반환상태상세", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rtnstsdtlcdnm;
	/**
	 * 반환사유코드
	 */
	@Schema(description = "반환사유코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rtnrsncd;
	/**
	 * 반환사유
	 */
	@Schema(description = "반환사유", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rtnrsncdnm;
	/**
	 * 비고
	 */
	@Schema(description = "비고", example = "", hidden = false, required = false, nullable = true, maxLength = 300)
	@MaxByte(max = 300)
	private String rm;
	/**
	 * 반환결제상태코드
	 */
	@Schema(description = "반환결제상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rtnsetlstscd;
	/**
	 * 반환결제상태
	 */
	@Schema(description = "반환결제상태", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rtnsetlstscdnm;
	/**
	 * 반환컨택순번
	 */
	@Schema(description = "반환컨택순번", example = "", hidden = false, required = false, nullable = true)
	private Integer rtncntcsn;
	/**
	 * 반환컨택유형코드
	 */
	@Schema(description = "반환컨택유형코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rtncntctycd;
	/**
	 * 반환컨택유형
	 */
	@Schema(description = "반환컨택유형", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rtncntctycdnm;
	/**
	 * 반환컨택상태코드
	 */
	@Schema(description = "반환컨택상태코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rtncntcstscd;
	/**
	 * 반환컨택상태
	 */
	@Schema(description = "반환컨택상태", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rtncntcstscdnm;
	/**
	 * 품목코드
	 */
	@Schema(description = "품목코드", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String itemcd;
	/**
	 * 품목 코드(SAP코드)
	 */
	@Schema(description = "품목 코드(SAP코드)", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String baseitemcd;
	/**
	 * 품목그룹코드
	 */
	@Schema(description = "품목그룹코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String itemgrpcd;
	/**
	 * 품목그룹
	 */
	@Schema(description = "품목그룹", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String itemgrpcdnm;
	/**
	 * 판매유형코드
	 */
	@Schema(description = "판매유형코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String saletycd;
	/**
	 * 판매유형
	 */
	@Schema(description = "판매유형", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String saletycdnm;
	/**
	 * 판매구분코드
	 */
	@Schema(description = "판매구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String salesecd;
	/**
	 * 판매구분
	 */
	@Schema(description = "판매구분", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String salesecdnm;
	/**
	 * 약정기간코드
	 */
	@Schema(description = "약정기간코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String agrpdcd;
	/**
	 * 약정기간
	 */
	@Schema(description = "약정기간", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String agrpdcdnm;
	/**
	 * 계약기간값
	 */
	@Schema(description = "계약기간값", example = "", hidden = false, required = false, nullable = true)
	private Integer cntrpdval;
	/**
	 * 사용일수
	 */
	@Schema(description = "사용일수", example = "", hidden = false, required = false, nullable = true)
	private Integer usedayco;
	/**
	 * 사용개월수
	 */
	@Schema(description = "사용개월수", example = "", hidden = false, required = false, nullable = true)
	private Integer usemnco;
	/**
	 * 잔여일수
	 */
	@Schema(description = "잔여일수", example = "", hidden = false, required = false, nullable = true)
	private Integer remndayco;
	/**
	 * 잔여개월수
	 */
	@Schema(description = "잔여개월수", example = "", hidden = false, required = false, nullable = true)
	private Integer remnmnco;
	/**
	 * 반환요청일자
	 */
	@Schema(description = "반환요청일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String rtnreqde;
	/**
	 * 반환접수일자
	 */
	@Schema(description = "반환접수일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String rtnacptde;
	/**
	 * 반환접수확정일자
	 */
	@Schema(description = "반환접수확정일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String rtnacptdcsde;
	/**
	 * 반환완료일자
	 */
	@Schema(description = "반환완료일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String rtnendde;
	/**
	 * 반환취소일자
	 */
	@Schema(description = "반환취소일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String rtncnclde;
	/**
	 * 반환취소사유코드
	 */
	@Schema(description = "반환취소사유코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String rtncnclrsncd;
	/**
	 * 반환취소사유
	 */
	@Schema(description = "반환취소사유", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String rtncnclrsncdnm;
	/**
	 * 설치회수여부
	 */
	@Schema(description = "설치회수여부", example = "", hidden = false, required = false, nullable = true)
	private String istrvlyn;
	/**
	 * 가격정책번호
	 */
	@Schema(description = "가격정책번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String prcplcno;
	/**
	 * 위약금정책번호
	 */
	@Schema(description = "위약금정책번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String penltyplcno;
	/**
	 * 원월렌탈료
	 */
	@Schema(description = "원월렌탈료", example = "", hidden = false, required = false, nullable = true)
	private Double basemtrentfee;
	/**
	 * 원선납금액
	 */
	@Schema(description = "원선납금액", example = "", hidden = false, required = false, nullable = true)
	private Double baseprepayamt;
	/**
	 * 원판매금액
	 */
	@Schema(description = "원판매금액", example = "", hidden = false, required = false, nullable = true)
	private Double basesaleamt;
	/**
	 * 원등록비
	 */
	@Schema(description = "원등록비", example = "", hidden = false, required = false, nullable = true)
	private Double baseregfee;
	/**
	 * 원설치비
	 */
	@Schema(description = "원설치비", example = "", hidden = false, required = false, nullable = true)
	private Double baseistct;
	/**
	 * 원해체비
	 */
	@Schema(description = "원해체비", example = "", hidden = false, required = false, nullable = true)
	private Double basedfee;
	/**
	 * 반환총수납금액
	 */
	@Schema(description = "반환총수납금액", example = "", hidden = false, required = false, nullable = true)
	private Double rtntotrcivamt;
	/**
	 * 반환월렌탈료
	 */
	@Schema(description = "반환월렌탈료", example = "", hidden = false, required = false, nullable = true)
	private Double rtnmtrentfee;
	/**
	 * 반환선납금액
	 */
	@Schema(description = "반환선납금액", example = "", hidden = false, required = false, nullable = true)
	private Double rtnprepayamt;
	/**
	 * 반환판매금액
	 */
	@Schema(description = "반환판매금액", example = "", hidden = false, required = false, nullable = true)
	private Double rtnsaleamt;
	/**
	 * 반환등록비
	 */
	@Schema(description = "반환등록비", example = "", hidden = false, required = false, nullable = true)
	private Double rtnregfee;
	/**
	 * 반환설치비
	 */
	@Schema(description = "반환설치비", example = "", hidden = false, required = false, nullable = true)
	private Double rtnistct;
	/**
	 * 반환해체비
	 */
	@Schema(description = "반환해체비", example = "", hidden = false, required = false, nullable = true)
	private Double rtndfee;
	/**
	 * 위약금액
	 */
	@Schema(description = "위약금액", example = "", hidden = false, required = false, nullable = true)
	private Double bapamt;
	/**
	 * 조정위약금액
	 */
	@Schema(description = "조정위약금액", example = "", hidden = false, required = false, nullable = true)
	private Double mdfbapamt;
	/**
	 * 최종위약금액
	 */
	@Schema(description = "최종위약금액", example = "", hidden = false, required = false, nullable = true)
	private Double lastbapamt;
	/**
	 * 위약금율
	 */
	@Schema(description = "위약금율", example = "", hidden = false, required = false, nullable = true)
	private Double penltyrt;
	/**
	 * 패키지위약금액
	 */
	@Schema(description = "패키지위약금액", example = "", hidden = false, required = false, nullable = true)
	private Double pkgbapamt;
	/**
	 * 분실여부
	 */
	@Schema(description = "분실여부", example = "", hidden = false, required = false, nullable = true)
	private String lstyn;
	/**
	 * 분실금액
	 */
	@Schema(description = "분실금액", example = "", hidden = false, required = false, nullable = true)
	private Double lstamt;
	/**
	 * 조정분실금액
	 */
	@Schema(description = "조정분실금액", example = "", hidden = false, required = false, nullable = true)
	private Double mdflstamt;
	/**
	 * 최종분실금액
	 */
	@Schema(description = "최종분실금액", example = "", hidden = false, required = false, nullable = true)
	private Double lastlstamt;
	/**
	 * 우편번호
	 */
	@Schema(description = "우편번호", example = "", hidden = false, required = false, nullable = true, maxLength = 6)
	@MaxByte(max = 6)
	private String postno;
	/**
	 * 기본주소
	 */
	@Schema(description = "기본주소", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String bassaddr;
	/**
	 * 상세주소
	 */
	@Schema(description = "상세주소", example = "", hidden = false, required = false, nullable = true, maxLength = 200)
	@MaxByte(max = 200)
	private String dtladdr;
	/**
	 * 시리얼번호
	 */
	@Schema(description = "시리얼번호", example = "", hidden = false, required = false, nullable = true, maxLength = 23)
	@MaxByte(max = 23)
	private String serialno;
	/**
	 * 본부구분코드
	 */
	@Schema(description = "본부구분코드", example = "", hidden = false, required = false, nullable = true, maxLength = 10)
	@MaxByte(max = 10)
	private String hqsecd;
	/**
	 * 판매조직
	 */
	@Schema(description = "판매조직", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String saleorgz;
	/**
	 * 판매인
	 */
	@Schema(description = "판매인", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String seller;
	/**
	 * 반환예정조직
	 */
	@Schema(description = "반환예정조직", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String rtndueorgz;
	/**
	 * 반환예정기사
	 */
	@Schema(description = "반환예정기사", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String rtndueengr;
	/**
	 * 반환조직
	 */
	@Schema(description = "반환조직", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String rtnorgz;
	/**
	 * 반환창고코드
	 */
	@Schema(description = "반환창고코드", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String rtnwrhcd;
	/**
	 * 반환기사
	 */
	@Schema(description = "반환기사", example = "", hidden = false, required = false, nullable = true, maxLength = 9)
	@MaxByte(max = 9)
	private String rtnengr;
	/**
	 * 반환예정일자
	 */
	@Schema(description = "반환예정일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String rtnduede;
	/**
	 * 반환일자
	 */
	@Schema(description = "반환일자", example = "", hidden = false, required = false, nullable = true, maxLength = 8)
	@MaxByte(max = 8)
	private String rtnde;
	/**
	 * 선납렌탈료매출번호
	 */
	@Schema(description = "선납렌탈료매출번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String prepayrentfeeselngno;
	/**
	 * 위약금매출번호
	 */
	@Schema(description = "위약금매출번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String penltyselngno;
	/**
	 * 분실비용매출번호
	 */
	@Schema(description = "분실비용매출번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String lstctselngno;
	/**
	 * 해체비매출번호
	 */
	@Schema(description = "해체비매출번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String dfeeselngno;
	/**
	 * 렌탈료매출번호
	 */
	@Schema(description = "렌탈료매출번호", example = "", hidden = false, required = false, nullable = true, maxLength = 15)
	@MaxByte(max = 15)
	private String rentfeeselngno;
	/**
	 * 패키지해지여부
	 */
	@Schema(description = "패키지해지여부", example = "", hidden = false, required = false, nullable = true)
	private String pkgendyn;
	/**
	 * 계약수량
	 */
	@Schema(description = "계약수량", example = "", hidden = false, required = false, nullable = true)
	private Integer cntrqy;
	/**
	 * 반환수량
	 */
	@Schema(description = "반환수량", example = "", hidden = false, required = false, nullable = true)
	private Integer rtnqy;
	/**
	 * 등록자Id
	 */
	@Schema(description = "등록자Id", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String regusrid;

	/**
	 * 수정자Id
	 */
	@Schema(description = "수정자Id", example = "", hidden = false, required = false, nullable = true, maxLength = 20)
	@MaxByte(max = 20)
	private String updusrid;
	/**
	 * 수정일시
	 */
	@Schema(description = "수정일시", example = "", hidden = false, required = false, nullable = true)
	private String upddt;
	
	/**
	 * 판매조직 고객코드(SAP코드)
	 */
	@Schema(description = "판매조직 고객코드(SAP코드)", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String saleOrgzCustCd;
	
	
}
