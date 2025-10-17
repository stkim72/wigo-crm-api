package com.ceragem.api.sap.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName SapPosTenderItemVo
 * @author 이승빈
 * @date 2022. 6. 28.
 * @Version 1.0
 * @description POS 매출전송(영수증별) item Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "POS 매출전송(영수증별) item 객체")
public class SapPosTenderItemVo {

	@Schema(description = "직영점 코드(SAP 고객코드)", example = "140841", hidden = false, required = false, nullable = true, maxLength = 15)
	private String kunnr;

	@Schema(description = "POS 매출일자", example = "20220627", hidden = false, required = false, nullable = true, maxLength = 8)
	private String bstdk;

	@Schema(description = "POS 번호", example = "pos001", hidden = false, required = false, nullable = true, maxLength = 10)
	private String posNo;

	@Schema(description = "POS 매출번호", example = "POS001-2022050105", hidden = false, required = false, nullable = true, maxLength = 35)
	private String bstkd;

	@Schema(description = "POS 매출번호의 결제 순번", example = "001", hidden = false, required = false, nullable = true, maxLength = 3)
	private String ztseq;

	@Schema(description = "결제 방식(10:현금, 12:카드, 14:모바일상품권, 16:멤버십 포인트, 99:기타(쿠폰))", example = "10", hidden = false, required = false, nullable = true, maxLength = 2)
	private String zpayMethod;

	@Schema(description = "번호(현금영수증 발급 시 고객 확인번호, 카드 결제 시 카드번호, 모바일 상품권 : 카드번호) * 미 발급 시 번호 없음", example = "TEST3111", hidden = false, required = false, nullable = true, maxLength = 20)
	private String zpayData;

	@Schema(description = "승인번호", example = "TEST3112", hidden = false, required = false, nullable = true, maxLength = 20)
	private String zcapprno;

	@Schema(description = "승인구분", example = "01", hidden = false, required = false, nullable = true, maxLength = 4)
	private String zcapprtp;

	@Schema(description = "승인일자", example = "20220627", hidden = false, required = false, nullable = true, maxLength = 8)
	private String zcapprdt;

	@Schema(description = "승인시간", example = "090101", hidden = false, required = false, nullable = true, maxLength = 6)
	private String zcapprtm;

	@Schema(description = "판매 금액", example = "1100", hidden = false, required = false, nullable = true, maxLength = 13)
	private String zcnetwr;

	@Schema(description = "단말기 ID", example = "TEST4111", hidden = false, required = false, nullable = true, maxLength = 30)
	private String zdevId;

	@Schema(description = "전송 일자", example = "20220628", hidden = false, required = false, nullable = true, maxLength = 8)
	private String ifdat;

}
