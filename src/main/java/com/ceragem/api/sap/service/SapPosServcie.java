package com.ceragem.api.sap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.sap.model.SapPosCb5GiResultVo;
import com.ceragem.api.sap.model.SapPosCgiCcResultVo;
import com.ceragem.api.sap.model.SapPosCustomItemResultVo;
import com.ceragem.api.sap.model.SapPosCustomVo;
import com.ceragem.api.sap.model.SapPosFcStkSetResultItemVo;
import com.ceragem.api.sap.model.SapPosGiScheResultVo;
import com.ceragem.api.sap.model.SapPosGiScheVo;
import com.ceragem.api.sap.model.SapPosIncomSetResultVo;
import com.ceragem.api.sap.model.SapPosMatnrItemResultVo;
import com.ceragem.api.sap.model.SapPosMatnrSetResultVo;
import com.ceragem.api.sap.model.SapPosMatnrSetVo;
import com.ceragem.api.sap.model.SapPosMatnrVo;
import com.ceragem.api.sap.model.SapPosNvlGiSetResultVo;
import com.ceragem.api.sap.model.SapPosRcpItemResultVo;
import com.ceragem.api.sap.model.SapPosSalesResultVo;
import com.ceragem.api.sap.model.SapPosSpcHisResultVo;
import com.ceragem.api.sap.model.SapPosSpcItemResultVo;
import com.ceragem.api.sap.model.SapPosStduseSetResultVo;
import com.ceragem.api.sap.model.SapPosTenderResultVo;
import com.ceragem.api.sap.model.SapPosWcfBtResultVo;
import com.ceragem.api.sap.model.SapPosWcfGiResultVo;
import com.ceragem.api.sap.model.SapPosWcfGrResultVo;
import com.ceragem.api.sap.model.SapPosWcfStkResultVo;
import com.ceragem.crm.common.model.EzMap;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @ClassName SapPosServcie
 * @author 이승빈
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP POS Service
 */

@Service
public class SapPosServcie {

	// SAP시스템 API URL
	@Value("${sap.api.rest-url}")
	String restUrl;

	// POS 품목 마스터(식음료)
	private final static String POS_ITEM_SPC_MST = "/ZCRM_POS_001_SRV/ITEMSet";

	// POS 레시피 마스터(식음료)
	private final static String POS_ITEM_RCP_MST = "/ZCRM_POS_001_SRV/RECIPESet";

	// POS 품목마스터(식음료) 공급가
	private final static String POS_ITEM_SPC_HIS = "/ZCRM_POS_001_SRV/ITEMHistorySet";

	// 매장 정보 조회
	private final static String POS_CUSTOM_LIST = "/ZCRM_POS_001_SRV/CUSTSet";

	// POS 매출 전송(일별/품목별)
	private final static String POS_SALES_LIST = "/ZCRM_POS_001_SRV/SALESSet";

	// POS 신규 제,상품 송신
	private final static String POS_MATNR_RES = "/ZCRM_POS_001_SRV/MATSet";

	// POS 매출전송(영수증별)
	private final static String POS_TENDER_RES = "/ZCRM_POS_001_SRV/TENDERSet";

	// POS 웰카페)입고 확정 내역
	private final static String POS_WCF_GR_RES = "/ZCRM_POS_001_SRV/WCFGRSet";

	// POS 웰카페 점간 이동 내역
	private final static String POS_WCF_BT_RES = "/ZCRM_POS_001_SRV/WCFBTSet";

	// POS 매출 반품확정 내역
	private final static String POS_CGI_CC_RES = "/ZCRM_POS_001_SRV/GICancelSet";

	// POS 상품 세트 마스터
	private final static String POS_BOMMAT_RES = "/ZCRM_POS_001_SRV/BOMMATSet";

	// CB5)주문 출고 승인, 취소
	private final static String POS_CB5GI_RES = "/ZCRM_POS_001_SRV/CB5GISet";

	// 나비엘)주문 출고 승인, 취소
	private final static String POS_NVLGI_RES = "/ZCRM_POS_001_SRV/NVLGISet";

	// 웰카페)주문 이고 승인, 취소
	private final static String POS_WCFGI_RES = "/ZCRM_POS_001_SRV/WCFGISet";

	// 본사 재고 실사 내역
	private final static String POS_FCSTK_RES = "/ZCRM_POS_001_SRV/FCSTOCKSet";

	// 웰카페 표준소요량
	private final static String POS_STDUSE_RES = "/ZCRM_POS_001_SRV/STDUSESet";

	// 웰카페) 실사 (재고조사) 내역
	private final static String POS_WCF_STK_RES = "/ZCRM_POS_001_SRV/STOCKSet";

	// 매장 출고 내역(매장 입고 예정)
	private final static String POS_GI_SCHE_RES = "/ZCRM_POS_001_SRV/ALLGISet";

	// FC사업부 입금내역 수신
	private final static String POS_INCOM_SET_RES = "/ZCRM_POS_001_SRV/INCOMESet";

	// (SAP 공통) Restful API Call Service
	@Autowired
	SapRestApiCallService restApiCallService;

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;

	@SuppressWarnings("unchecked")
	public SapPosSpcItemResultVo sapPosSpcItem(EzMap param) throws Exception {

		// SAP POS 품목 마스터 VO
		SapPosSpcItemResultVo sapPosSpcItemResultVo = new SapPosSpcItemResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 영업관리시스템에서 등록한 품목(식음료 자재)마스터 정보 SAP로 전송
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_ITEM_SPC_MST, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosSpcItemResultVo.setMsgty("E");
			sapPosSpcItemResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosSpcItemResultVo.setMsgid(code);
				sapPosSpcItemResultVo.setMsgtx(value);
			}

		} else {
			sapPosSpcItemResultVo = Utilities.beanToBean(d, SapPosSpcItemResultVo.class);

			sapPosSpcItemResultVo.setMsgty("S");
			sapPosSpcItemResultVo.setMsgno("200");
		}

		return sapPosSpcItemResultVo;
	}

	@SuppressWarnings("unchecked")
	public SapPosRcpItemResultVo sapPosRcpItem(EzMap param) throws Exception {

		// SAP POS 레시피 마스터(식음료) VO
		SapPosRcpItemResultVo sapPosRcpItemResultVo = new SapPosRcpItemResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 영업관리시스템에서 관리하는 레시피(식음료 자재)마스터 정보를 SAP로 전송한다
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_ITEM_RCP_MST, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosRcpItemResultVo.setMsgty("E");
			sapPosRcpItemResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosRcpItemResultVo.setMsgid(code);
				sapPosRcpItemResultVo.setMsgtx(value);
			}

		} else {
			sapPosRcpItemResultVo = Utilities.beanToBean(d, SapPosRcpItemResultVo.class);

			sapPosRcpItemResultVo.setMsgty("S");
			sapPosRcpItemResultVo.setMsgno("200");
		}

		return sapPosRcpItemResultVo;
	}

	@SuppressWarnings("unchecked")
	public SapPosSpcHisResultVo sapPosSpcItemHis(EzMap param) throws Exception {

		// SAP POS 레시피 마스터(식음료) VO
		SapPosSpcHisResultVo sapPosSpcHisResultVo = new SapPosSpcHisResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 영업관리시스템에서 등록된 품목(식음료 자재) 공급가 정보를 SAP으로 송신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_ITEM_SPC_HIS, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosSpcHisResultVo.setMsgty("E");
			sapPosSpcHisResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosSpcHisResultVo.setMsgid(code);
				sapPosSpcHisResultVo.setMsgtx(value);
			}

		} else {
			sapPosSpcHisResultVo = Utilities.beanToBean(d, SapPosSpcHisResultVo.class);

			sapPosSpcHisResultVo.setMsgty("S");
			sapPosSpcHisResultVo.setMsgno("200");
		}

		return sapPosSpcHisResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 매장 정보를 조회
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosCustomItemResultVo sapPosCustom(SapPosCustomVo sapPosCustomVo) throws Exception {

		SapPosCustomItemResultVo sapPosCustomItemResultVo = new SapPosCustomItemResultVo();
		// 헤더 세팅
		EzMap header = reqHeaderParam("GET");

		// 매장 정보를 조회하여 송신한다
		String resJsonData = restApiCallService.httpCallApi(
				restUrl + POS_CUSTOM_LIST + "?erdat='" + sapPosCustomVo.getErdat() + "'", null, "GET", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosCustomItemResultVo.setMsgty("E");
			sapPosCustomItemResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosCustomItemResultVo.setMsgid(code);
				sapPosCustomItemResultVo.setMsgtx(value);
			}

		} else {
			// 매장정보 리스트
			List<SapPosCustomItemResultVo> results = (ArrayList<SapPosCustomItemResultVo>) d.get("results");
			Iterator<SapPosCustomItemResultVo> iter = results.iterator();

			while (iter.hasNext()) {
				Map<String, Object> resultsMap = (Map<String, Object>) iter.next();

				resultsMap.remove("__metadata");
			}

			sapPosCustomItemResultVo.setItems(results);

			sapPosCustomItemResultVo.setMsgty("S");
			sapPosCustomItemResultVo.setMsgno("200");
		}

		return sapPosCustomItemResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description POS 매출 전송(일별/품목별)
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosSalesResultVo sapPosSales(EzMap param) throws Exception {

		// SAP PNT 포인트 VO
		SapPosSalesResultVo sapPosSalesResultVo = new SapPosSalesResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// POS에서 SAP로 매출 데이터를 전송한다(일별/품목별)
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_SALES_LIST, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosSalesResultVo.setMsgty("E");
			sapPosSalesResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosSalesResultVo.setMsgid(code);
				sapPosSalesResultVo.setMsgtx(value);
			}

		} else {
			sapPosSalesResultVo = Utilities.beanToBean(d, SapPosSalesResultVo.class);

			sapPosSalesResultVo.setMsgty("S");
			sapPosSalesResultVo.setMsgno("200");
		}

		return sapPosSalesResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP POS 신규 제,상품 전송
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosMatnrItemResultVo sapPosMatnr(SapPosMatnrVo sapPosMatnrVo) throws Exception {

		SapPosMatnrItemResultVo sapPosMatnrItemResultVo = new SapPosMatnrItemResultVo();
		// 헤더 세팅
		EzMap header = reqHeaderParam("GET");

		// SAP POS 신규 제,상품 전송한다
		String resJsonData = restApiCallService.httpCallApi(
				restUrl + POS_MATNR_RES + "?ersda='" + sapPosMatnrVo.getErsda() + "'", null, "GET", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosMatnrItemResultVo.setMsgty("E");
			sapPosMatnrItemResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosMatnrItemResultVo.setMsgid(code);
				sapPosMatnrItemResultVo.setMsgtx(value);
			}

		} else {
			// SAP POS 신규 제,상품 리스트
			List<SapPosMatnrItemResultVo> results = (ArrayList<SapPosMatnrItemResultVo>) d.get("results");
			Iterator<SapPosMatnrItemResultVo> iter = results.iterator();

			while (iter.hasNext()) {
				Map<String, Object> resultsMap = (Map<String, Object>) iter.next();

				resultsMap.remove("__metadata");
				resultsMap.remove("meins"); // meins 사용하지않은 데이터 삭제
			}

			sapPosMatnrItemResultVo.setItems(results);

			sapPosMatnrItemResultVo.setMsgty("S");
			sapPosMatnrItemResultVo.setMsgno("200");
		}

		return sapPosMatnrItemResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 6. 28.
	 * @param
	 * @return
	 * @throws Exception
	 * @description POS에서 발생한 매출에 대해 영수증 별로 데이터를 수신
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosTenderResultVo sapPosTender(EzMap param) throws Exception {

		// SAP POS 매출전송(영수증별) 결과 VO
		SapPosTenderResultVo sapPosTenderResultVo = new SapPosTenderResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// POS에서 발생한 매출에 대해 영수증 별로 데이터를 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_TENDER_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosTenderResultVo.setMsgty("E");
			sapPosTenderResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosTenderResultVo.setMsgid(code);
				sapPosTenderResultVo.setMsgtx(value);
			}

		} else {
			sapPosTenderResultVo = Utilities.beanToBean(d, SapPosTenderResultVo.class);

			sapPosTenderResultVo.setMsgty("S");
			sapPosTenderResultVo.setMsgno("200");
		}

		return sapPosTenderResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페 매장에서 입고 확정 내역을 SAP으로 전송한다
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosWcfGrResultVo sapPosWcfGr(EzMap param) throws Exception {

		// 웰카페)입고 확정 내역 결과 Vo
		SapPosWcfGrResultVo sapPosWcfGrResultVo = new SapPosWcfGrResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 입고 확정 내역 전송 결과 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_WCF_GR_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosWcfGrResultVo.setMsgty("E");
			sapPosWcfGrResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosWcfGrResultVo.setMsgid(code);
				sapPosWcfGrResultVo.setMsgtx(value);
			}

		} else {
			sapPosWcfGrResultVo = Utilities.beanToBean(d, SapPosWcfGrResultVo.class);

			sapPosWcfGrResultVo.setMsgty("S");
			sapPosWcfGrResultVo.setMsgno("200");
		}

		return sapPosWcfGrResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페 매장간의 점간 이동 확정 내역을 SAP으로 전송한다.
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosWcfBtResultVo sapPosWcfBt(EzMap param) throws Exception {

		// 웰카페)점간 이동 내역 결과 Vo
		SapPosWcfBtResultVo sapPosWcfBtResultVo = new SapPosWcfBtResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 점간 이동 내역 전송 결과 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_WCF_BT_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosWcfBtResultVo.setMsgty("E");
			sapPosWcfBtResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosWcfBtResultVo.setMsgid(code);
				sapPosWcfBtResultVo.setMsgtx(value);
			}

		} else {
			sapPosWcfBtResultVo = Utilities.beanToBean(d, SapPosWcfBtResultVo.class);

			sapPosWcfBtResultVo.setMsgty("S");
			sapPosWcfBtResultVo.setMsgno("200");
		}

		return sapPosWcfBtResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 전 매장(cb5, 나비엘, 웰카페)의 본사로의 반품확정 내역을 SAP으로 전송한다.
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosCgiCcResultVo sapPosCgiCc(EzMap param) throws Exception {

		// 매출 반품확정내역 Vo
		SapPosCgiCcResultVo sapPosCgiCcResultVo = new SapPosCgiCcResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 매출 반품확정내역 결과 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_CGI_CC_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosCgiCcResultVo.setMsgty("E");
			sapPosCgiCcResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosCgiCcResultVo.setMsgid(code);
				sapPosCgiCcResultVo.setMsgtx(value);
			}

		} else {
			sapPosCgiCcResultVo = Utilities.beanToBean(d, SapPosCgiCcResultVo.class);

			sapPosCgiCcResultVo.setMsgty("S");
			sapPosCgiCcResultVo.setMsgno("200");
		}

		return sapPosCgiCcResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP POS 제, 상품 세트 마스터 전송
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosMatnrSetResultVo sapPosMatnrSet(SapPosMatnrSetVo sapPosMatnrVo) throws Exception {

		SapPosMatnrSetResultVo sapPosMatnrSetResultVo = new SapPosMatnrSetResultVo();
		// 헤더 세팅
		EzMap header = reqHeaderParam("GET");

		// SAP POS 신규 제,상품 전송한다
		String resJsonData = restApiCallService.httpCallApi(
				restUrl + POS_BOMMAT_RES + "?ersda='" + sapPosMatnrVo.getErsda() + "'", null, "GET", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosMatnrSetResultVo.setMsgty("E");
			sapPosMatnrSetResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosMatnrSetResultVo.setMsgid(code);
				sapPosMatnrSetResultVo.setMsgtx(value);
			}

		} else {
			// SAP POS 신규 제,상품 리스트
			List<SapPosMatnrSetResultVo> results = (ArrayList<SapPosMatnrSetResultVo>) d.get("results");
			Iterator<SapPosMatnrSetResultVo> iter = results.iterator();

			while (iter.hasNext()) {
				Map<String, Object> resultsMap = (Map<String, Object>) iter.next();

				resultsMap.remove("__metadata");
			}

			sapPosMatnrSetResultVo.setItems(results);

			sapPosMatnrSetResultVo.setMsgty("S");
			sapPosMatnrSetResultVo.setMsgno("200");
		}

		return sapPosMatnrSetResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 4.
	 * @param
	 * @return
	 * @throws Exception
	 * @description CB5의 주문승인, 승인취소내역을 SAP으로 전송한다
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosCb5GiResultVo sapPosCb5GiSet(EzMap param) throws Exception {

		// CB5의 주문승인, 승인취소내역 Vo
		SapPosCb5GiResultVo sapPosCb5GiResultVo = new SapPosCb5GiResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// CB5의 주문승인, 승인취소 결과 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_CB5GI_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosCb5GiResultVo.setMsgty("E");
			sapPosCb5GiResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosCb5GiResultVo.setMsgid(code);
				sapPosCb5GiResultVo.setMsgtx(value);
			}

		} else {
			sapPosCb5GiResultVo = Utilities.beanToBean(d, SapPosCb5GiResultVo.class);

			sapPosCb5GiResultVo.setMsgty("S");
			sapPosCb5GiResultVo.setMsgno("200");
		}

		return sapPosCb5GiResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 4.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 나비엘의 주문승인, 승인취소내역을 SAP으로 전송한다
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosNvlGiSetResultVo sapPosNvlGiSet(EzMap param) throws Exception {

		// 나비엘)주문 출고 승인, 취소 Vo
		SapPosNvlGiSetResultVo sapPosNvlGiSetResultVo = new SapPosNvlGiSetResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 나비엘)주문 출고 승인, 취소 결과 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_NVLGI_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosNvlGiSetResultVo.setMsgty("E");
			sapPosNvlGiSetResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosNvlGiSetResultVo.setMsgid(code);
				sapPosNvlGiSetResultVo.setMsgtx(value);
			}

		} else {
			sapPosNvlGiSetResultVo = Utilities.beanToBean(d, SapPosNvlGiSetResultVo.class);

			sapPosNvlGiSetResultVo.setMsgty("S");
			sapPosNvlGiSetResultVo.setMsgno("200");
		}

		return sapPosNvlGiSetResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 4.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페의 주문 이고승인, 이고 취소 내역을 SAP으로 전송한다
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosWcfGiResultVo sapPosWcfGiSet(EzMap param) throws Exception {

		// 웰카페)주문 이고 승인, 취소 Vo
		SapPosWcfGiResultVo sapPosWcfGiResultVo = new SapPosWcfGiResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 웰카페)주문 이고 승인, 취소 결과 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_WCFGI_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosWcfGiResultVo.setMsgty("E");
			sapPosWcfGiResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosWcfGiResultVo.setMsgid(code);
				sapPosWcfGiResultVo.setMsgtx(value);
			}

		} else {
			sapPosWcfGiResultVo = Utilities.beanToBean(d, SapPosWcfGiResultVo.class);

			sapPosWcfGiResultVo.setMsgty("S");
			sapPosWcfGiResultVo.setMsgno("200");
		}

		return sapPosWcfGiResultVo;
	}

	@SuppressWarnings("unchecked")
	public SapPosFcStkSetResultItemVo sapPosFcStkSet() throws Exception {

		SapPosFcStkSetResultItemVo sapPosFcStkSetResultItemVo = new SapPosFcStkSetResultItemVo();
		// 헤더 세팅
		EzMap header = reqHeaderParam("GET");

		// 본사 재고 실사 내역 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_FCSTK_RES, null, "GET", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosFcStkSetResultItemVo.setMsgty("E");
			sapPosFcStkSetResultItemVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosFcStkSetResultItemVo.setMsgid(code);
				sapPosFcStkSetResultItemVo.setMsgtx(value);
			}

		} else {
			// SAP POS 신규 제,상품 리스트
			List<SapPosFcStkSetResultItemVo> results = (ArrayList<SapPosFcStkSetResultItemVo>) d.get("results");
			Iterator<SapPosFcStkSetResultItemVo> iter = results.iterator();

			while (iter.hasNext()) {
				Map<String, Object> resultsMap = (Map<String, Object>) iter.next();

				resultsMap.remove("__metadata");
			}

			sapPosFcStkSetResultItemVo.setItems(results);

			sapPosFcStkSetResultItemVo.setMsgty("S");
			sapPosFcStkSetResultItemVo.setMsgno("200");
		}

		return sapPosFcStkSetResultItemVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 4.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페 매장의 매출기준으로 품목(자재) 표준소요량을 매장별,일별,품목별로 집계하여 SAP으로 전송한다
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosStduseSetResultVo sapPosStduseSet(EzMap param) throws Exception {

		// 웰카페 표준소요량 Vo
		SapPosStduseSetResultVo sapPosStduseSetResultVo = new SapPosStduseSetResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 웰카페 표준소요량 결과 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_STDUSE_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosStduseSetResultVo.setMsgty("E");
			sapPosStduseSetResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosStduseSetResultVo.setMsgid(code);
				sapPosStduseSetResultVo.setMsgtx(value);
			}

		} else {
			sapPosStduseSetResultVo = Utilities.beanToBean(d, SapPosStduseSetResultVo.class);

			sapPosStduseSetResultVo.setMsgty("S");
			sapPosStduseSetResultVo.setMsgno("200");
		}

		return sapPosStduseSetResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페 매장의 실사(재고조사) 내역을 영업관리 시스템으로부터 수신 받는다.
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosWcfStkResultVo sapPosWcfStk(EzMap param) throws Exception {

		// 웰카페) 실사 (재고조사) 결과 Vo
		SapPosWcfStkResultVo sapPosWcfStkResultVo = new SapPosWcfStkResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// 웰카페 매장의 실사(재고조사) 내역을 영업관리 시스템으로부터 수신 받는다.
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_WCF_STK_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosWcfStkResultVo.setMsgty("E");
			sapPosWcfStkResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosWcfStkResultVo.setMsgid(code);
				sapPosWcfStkResultVo.setMsgtx(value);
			}

		} else {
			sapPosWcfStkResultVo = Utilities.beanToBean(d, SapPosWcfStkResultVo.class);

			sapPosWcfStkResultVo.setMsgty("S");
			sapPosWcfStkResultVo.setMsgno("200");
		}

		return sapPosWcfStkResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 7. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 매장 출고 내역(매장 입고 예정)
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosGiScheResultVo sapPosGiSche(SapPosGiScheVo sapPosGiScheVo) throws Exception {

		SapPosGiScheResultVo sapPosGiScheResultVo = new SapPosGiScheResultVo();
		// 헤더 세팅
		EzMap header = reqHeaderParam("GET");

		// 매장 출고 내역(매장 입고 예정)
		String resJsonData = restApiCallService.httpCallApi(
				restUrl + POS_GI_SCHE_RES + "?zofwDate='" + sapPosGiScheVo.getZofwDate() + "'", null, "GET", null,
				header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosGiScheResultVo.setMsgty("E");
			sapPosGiScheResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosGiScheResultVo.setMsgid(code);
				sapPosGiScheResultVo.setMsgtx(value);
			}
		} else {
			// 코스트센터 리스트
			List<SapPosGiScheResultVo> results = (ArrayList<SapPosGiScheResultVo>) d.get("results");
			Iterator<SapPosGiScheResultVo> iter = results.iterator();

			while (iter.hasNext()) {
				Map<String, Object> resultsMap = (Map<String, Object>) iter.next();
				resultsMap.remove("__metadata");
			}

			sapPosGiScheResultVo.setItems(results);

			sapPosGiScheResultVo.setMsgty("S");
			sapPosGiScheResultVo.setMsgno("200");

			if (Utilities.isEmpty(results)) {
				sapPosGiScheResultVo.setMsgid("POS");
				sapPosGiScheResultVo.setMsgtx("조회된 데이터가 없습니다.");
			}
		}

		return sapPosGiScheResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 8. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description FC사업부 입금내역 수신
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapPosIncomSetResultVo income(EzMap param) throws Exception {

		// FC사업부 입금내역 수신 결과 Vo
		SapPosIncomSetResultVo sapPosIncomSetResultVo = new SapPosIncomSetResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// FC사업부 입금내역 수신
		String resJsonData = restApiCallService.httpCallApi(restUrl + POS_INCOM_SET_RES, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapPosIncomSetResultVo.setMsgty("E");
			sapPosIncomSetResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapPosIncomSetResultVo.setMsgid(code);
				sapPosIncomSetResultVo.setMsgtx(value);
			}

		} else {
			sapPosIncomSetResultVo = Utilities.beanToBean(d, SapPosIncomSetResultVo.class);

			sapPosIncomSetResultVo.setMsgty("S");
			sapPosIncomSetResultVo.setMsgno("200");
		}

		return sapPosIncomSetResultVo;
	}

	/**
	 * @author 이승빈
	 * @date 2022. 6. 24.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 헤더세팅
	 *
	 */
	public static EzMap reqHeaderParam(String method) throws Exception {
		EzMap header = new EzMap();

		header.put("Content-Type", "application/json");
		header.put("Accept", "application/json");

		if (!method.equals("GET")) {
			header.put("X-Requested-With", "X");
		}

		header.put("SYSID", "002");
		header.put("AUTHID", "crmAPI@2022");

		return header;
	}
}
