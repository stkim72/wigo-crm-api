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
import com.ceragem.api.sap.model.SapAs3000MatnrResultListVo;
import com.ceragem.api.sap.model.SapAs3000MatnrResultVo;
import com.ceragem.api.sap.model.SapAsCmptTrtCnclResultVo;
import com.ceragem.api.sap.model.SapAsCmptTrtCnclVo;
import com.ceragem.api.sap.model.SapAsCmptTrtResultVo;
import com.ceragem.api.sap.model.SapAsCntrStkTransferResultVo;
import com.ceragem.api.sap.model.SapAsGrGiTrtCnclResultVo;
import com.ceragem.api.sap.model.SapAsGrGiTrtCnclVo;
import com.ceragem.api.sap.model.SapAsGrGiTrtResultVo;
import com.ceragem.api.sap.model.SapAsKostCenterResultListVo;
import com.ceragem.api.sap.model.SapAsKostCenterResultVo;
import com.ceragem.api.sap.model.SapAsKostCenterSo;
import com.ceragem.api.sap.model.SapAsMatnrMengeResultVo;
import com.ceragem.api.sap.model.SapAsMatnrMengeVo;
import com.ceragem.api.sap.model.SapAsMatnrRqCnclResultVo;
import com.ceragem.api.sap.model.SapAsMatnrRqCnclVo;
import com.ceragem.api.sap.model.SapAsMatnrRqResultVo;
import com.ceragem.api.sap.model.SapAsRfndResultVo;
import com.ceragem.api.sap.model.SapAsRfndTrtCnclResultVo;
import com.ceragem.api.sap.model.SapAsRfndTrtCnclVo;
import com.ceragem.api.sap.model.SapAsRfndTrtResultVo;
import com.ceragem.crm.common.model.EzMap;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @ClassName SapAsCmptTrtService
 * @author 김연지
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description SAP AS 완료처리 Service
 */

@Service
public class SapAsService {
	// SAP시스템 API URL
	@Value("${sap.api.rest-url}")
	String restUrl;

	// SAP AS 완료처리
	private final static String AS_CMPT_TRT = "/ZCRM_AS_000_SRV/SOSet";

	// SAP 자재현재고
	private final static String AS_MATNR_MENGE = "/ZCRM_AS_000_SRV/ZCRM_AS_MB52_LIST";

	// SAP 코스트센터 조회
	private final static String KOST_CENTER = "/ZCRM_AS_000_SRV/ZCRM_AS_KS13_LIST";

	// SAP 유상매출 반제처리
	private final static String RFND_TRT = "/ZCRM_AS_000_SRV/F32Set";

	// SAP AS 자재요청
	private final static String MATNR_RQ = "/ZCRM_AS_000_SRV/PRSet";

	// SAP 입/출고처리
	private final static String GR_GI_TRT = "/ZCRM_AS_000_SRV/MB1Set";

	// SAP AS 환불처리
	private final static String AS_RFND = "/ZCRM_AS_000_SRV/CreditMemoSet";

	// SAP AS 센터간재고이전
	private final static String AS_CNTR_STK_TRANSFER = "/ZCRM_AS_000_SRV/MB1BSet";

	// SAP 본사 3000번 창고 현재고 조회
	private final static String AS_3000_MATNR = "/ZCRM_AS_000_SRV/MB52ListSet";

	// (SAP 공통) Restful API Call Service
	@Autowired
	SapRestApiCallService restApiCallService;

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;

	/**
	 * @author 김연지
	 * @date 2022. 6. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description AS 완료처리 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsCmptTrtResultVo sapAsCmptTrt(EzMap param) throws Exception {

		// AS 완료처리 결과 VO
		SapAsCmptTrtResultVo sapAsCmptTrtResultVo = new SapAsCmptTrtResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// SAP AS 완료처리 요청
		String resJsonData = restApiCallService.httpCallApi(restUrl + AS_CMPT_TRT, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsCmptTrtResultVo.setMsgty("E");
			sapAsCmptTrtResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsCmptTrtResultVo.setMsgid(code);
				sapAsCmptTrtResultVo.setMsgtx(value);
			}
		} else {
			sapAsCmptTrtResultVo = Utilities.beanToBean(d, SapAsCmptTrtResultVo.class);

			sapAsCmptTrtResultVo.setMsgty("S");
			sapAsCmptTrtResultVo.setMsgno("200");
		}

		return sapAsCmptTrtResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description AS 완료취소 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsCmptTrtCnclResultVo sapAsCmptTrtCncl(SapAsCmptTrtCnclVo sapAsCmptTrtCnclVo) throws Exception {

		// AS 완료취소 결과 VO
		SapAsCmptTrtCnclResultVo sapAsCmptTrtCnclResultVo = new SapAsCmptTrtCnclResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("DELETE");

		String resJsonData = restApiCallService.httpCallApi(
				restUrl + AS_CMPT_TRT + "('" + sapAsCmptTrtCnclVo.getBstkd() + "')", null, "DELETE", null, header);

		// Response Data
		Map<String, Object> map = null;

		if (!resJsonData.isEmpty()) {
			map = Utilities.getJson(resJsonData);
			Map<String, Object> err = (Map<String, Object>) map.get("error");
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsCmptTrtCnclResultVo.setMsgty("E");
			sapAsCmptTrtCnclResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsCmptTrtCnclResultVo.setMsgid(code);
				sapAsCmptTrtCnclResultVo.setMsgtx(value);
			}
		} else {
			sapAsCmptTrtCnclResultVo.setMsgty("S");
			sapAsCmptTrtCnclResultVo.setMsgno("200");
		}
		return sapAsCmptTrtCnclResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description AS 환불처리 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsRfndResultVo sapAsRfnd(EzMap param) throws Exception {

		// AS 환불처리 결과 VO
		SapAsRfndResultVo sapAsRfndResultVo = new SapAsRfndResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// SAP AS 환불처리 요청
		String resJsonData = restApiCallService.httpCallApi(restUrl + AS_RFND, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsRfndResultVo.setMsgty("E");
			sapAsRfndResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsRfndResultVo.setMsgid(code);
				sapAsRfndResultVo.setMsgtx(value);
			}
		} else {
			sapAsRfndResultVo = Utilities.beanToBean(d, SapAsRfndResultVo.class);

			sapAsRfndResultVo.setMsgty("S");
			sapAsRfndResultVo.setMsgno("200");
		}

		return sapAsRfndResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 자재현재고 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsMatnrMengeResultVo sapAsMantrMenge(SapAsMatnrMengeVo sapAsMatnrMengeVo) throws Exception {

		// 자재현재고 결과 VO
		SapAsMatnrMengeResultVo sapAsMatnrMengeResultVo = new SapAsMatnrMengeResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("GET");

		// SAP 자재 현재고 조회
		String resJsonData = restApiCallService.httpCallApi(restUrl + AS_MATNR_MENGE + "?matnr='"
				+ sapAsMatnrMengeVo.getMatnr() + "'&lgort='" + sapAsMatnrMengeVo.getLgort() + "'", null, "GET", null,
				header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsMatnrMengeResultVo.setMsgty("E");
			sapAsMatnrMengeResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsMatnrMengeResultVo.setMsgid(code);
				sapAsMatnrMengeResultVo.setMsgtx(value);
			}
		} else {
			sapAsMatnrMengeResultVo = Utilities.beanToBean(d, SapAsMatnrMengeResultVo.class);

			sapAsMatnrMengeResultVo.setMsgty("S");
			sapAsMatnrMengeResultVo.setMsgno("200");
		}

		return sapAsMatnrMengeResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 코스트센터 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsKostCenterResultVo sapAsKostCenter(SapAsKostCenterSo sapAsKostCenterSo) throws Exception {

		SapAsKostCenterResultVo sapAsKostCenterResultVo = new SapAsKostCenterResultVo();
		// 헤더 세팅
		EzMap header = reqHeaderParam("GET");

		// SAP 코스트센터 조회
		String resJsonData = restApiCallService.httpCallApi(
				restUrl + KOST_CENTER + "?bukrs='" + sapAsKostCenterSo.getBukrs() + "'", null, "GET", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsKostCenterResultVo.setMsgty("E");
			sapAsKostCenterResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsKostCenterResultVo.setMsgid(code);
				sapAsKostCenterResultVo.setMsgtx(value);
			}
		} else {
			// 코스트센터 리스트
			List<SapAsKostCenterResultListVo> results = (ArrayList<SapAsKostCenterResultListVo>) d.get("results");
			Iterator<SapAsKostCenterResultListVo> iter = results.iterator();

			while (iter.hasNext()) {
				Map<String, Object> resultsMap = (Map<String, Object>) iter.next();
				resultsMap.remove("__metadata");
				resultsMap.remove("bukrs");
			}

			sapAsKostCenterResultVo.setResults(results);

			sapAsKostCenterResultVo.setMsgty("S");
			sapAsKostCenterResultVo.setMsgno("200");
		}

		return sapAsKostCenterResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description AS 유상매출 반제처리
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsRfndTrtResultVo sapAsRfndTrt(EzMap param) throws Exception {

		// 유상매출 반제처리 결과 VO
		SapAsRfndTrtResultVo sapAsRfndTrtResultVo = new SapAsRfndTrtResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// SAP 유상매출 반제처리 요청
		String resJsonData = restApiCallService.httpCallApi(restUrl + RFND_TRT, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsRfndTrtResultVo.setMsgty("E");
			sapAsRfndTrtResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsRfndTrtResultVo.setMsgid(code);
				sapAsRfndTrtResultVo.setMsgtx(value);
			}
		} else {
			sapAsRfndTrtResultVo = Utilities.beanToBean(d, SapAsRfndTrtResultVo.class);

			sapAsRfndTrtResultVo.setMsgty("S");
			sapAsRfndTrtResultVo.setMsgno("200");
		}

		return sapAsRfndTrtResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description AS 유상매출 반제취소
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsRfndTrtCnclResultVo sapAsRfndCncl(SapAsRfndTrtCnclVo sapAsRfndTrtCnclVo) throws Exception {

		SapAsRfndTrtCnclResultVo sapAsRfndTrtCnclResultVo = new SapAsRfndTrtCnclResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("DELETE");

		String resJsonData = restApiCallService.httpCallApi(restUrl + RFND_TRT + "(rfndadmno='"
				+ sapAsRfndTrtCnclVo.getRfndadmno() + "',paytype='" + sapAsRfndTrtCnclVo.getPaytype() + "')", null,
				"DELETE", null, header);

		// Response Data
		Map<String, Object> map = null;

		if (!resJsonData.isEmpty()) {
			map = Utilities.getJson(resJsonData);
			Map<String, Object> err = (Map<String, Object>) map.get("error");
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsRfndTrtCnclResultVo.setMsgty("E");
			sapAsRfndTrtCnclResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsRfndTrtCnclResultVo.setMsgid(code);
				sapAsRfndTrtCnclResultVo.setMsgtx(value);
			}
		} else {
			sapAsRfndTrtCnclResultVo.setMsgty("S");
			sapAsRfndTrtCnclResultVo.setMsgno("200");
		}

		return sapAsRfndTrtCnclResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description AS 자재요청
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsMatnrRqResultVo sapAsMatnrRq(EzMap param) throws Exception {

		// AS 자재요청 결과 VO
		SapAsMatnrRqResultVo sapAsMatnrRqResultVo = new SapAsMatnrRqResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// SAP AS 자재요청 요청
		String resJsonData = restApiCallService.httpCallApi(restUrl + MATNR_RQ, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsMatnrRqResultVo.setMsgty("E");
			sapAsMatnrRqResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsMatnrRqResultVo.setMsgid(code);
				sapAsMatnrRqResultVo.setMsgtx(value);
			}
		} else {
			sapAsMatnrRqResultVo = Utilities.beanToBean(d, SapAsMatnrRqResultVo.class);

			sapAsMatnrRqResultVo.setMsgty("S");
			sapAsMatnrRqResultVo.setMsgno("200");
		}

		return sapAsMatnrRqResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description AS 자재요청 취소
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsMatnrRqCnclResultVo sapAsMatnrRqCncl(SapAsMatnrRqCnclVo sapAsMatnrRqCnclVo) throws Exception {

		SapAsMatnrRqCnclResultVo sapAsMatnrRqCnclResultVo = new SapAsMatnrRqCnclResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("DELETE");

		String resJsonData = restApiCallService.httpCallApi(
				restUrl + MATNR_RQ + "('" + sapAsMatnrRqCnclVo.getIntime() + "')", null, "DELETE", null, header);

		// Response Data
		Map<String, Object> map = null;

		if (!resJsonData.isEmpty()) {
			map = Utilities.getJson(resJsonData);
			Map<String, Object> err = (Map<String, Object>) map.get("error");
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsMatnrRqCnclResultVo.setMsgty("E");
			sapAsMatnrRqCnclResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsMatnrRqCnclResultVo.setMsgid(code);
				sapAsMatnrRqCnclResultVo.setMsgtx(value);
			}
		} else {
			sapAsMatnrRqCnclResultVo.setMsgty("S");
			sapAsMatnrRqCnclResultVo.setMsgno("200");
		}
		return sapAsMatnrRqCnclResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 입/출고처리
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsGrGiTrtResultVo sapAsGrGiTrt(EzMap param) throws Exception {

		// AS 입/출고처리 결과 VO
		SapAsGrGiTrtResultVo sapAsGrGiTrtResultVo = new SapAsGrGiTrtResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// SAP 입/출고처리
		String resJsonData = restApiCallService.httpCallApi(restUrl + GR_GI_TRT, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsGrGiTrtResultVo.setMsgty("E");
			sapAsGrGiTrtResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsGrGiTrtResultVo.setMsgid(code);
				sapAsGrGiTrtResultVo.setMsgtx(value);
			}
		} else {
			sapAsGrGiTrtResultVo = Utilities.beanToBean(d, SapAsGrGiTrtResultVo.class);

			sapAsGrGiTrtResultVo.setMsgty("S");
			sapAsGrGiTrtResultVo.setMsgno("200");
		}

		return sapAsGrGiTrtResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description AS 입/출고취소
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsGrGiTrtCnclResultVo sapAsGrGiTrtCncl(SapAsGrGiTrtCnclVo sapAsGrGiTrtCnclVo) throws Exception {

		SapAsGrGiTrtCnclResultVo sapAsGrGiTrtCnclResultVo = new SapAsGrGiTrtCnclResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("DELETE");

		String resJsonData = restApiCallService.httpCallApi(
				restUrl + GR_GI_TRT + "('" + sapAsGrGiTrtCnclVo.getIfkey() + "')", null, "DELETE", null, header);

		// Response Data
		Map<String, Object> map = null;

		if (!resJsonData.isEmpty()) {
			map = Utilities.getJson(resJsonData);
			Map<String, Object> err = (Map<String, Object>) map.get("error");
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsGrGiTrtCnclResultVo.setMsgty("E");
			sapAsGrGiTrtCnclResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsGrGiTrtCnclResultVo.setMsgid(code);
				sapAsGrGiTrtCnclResultVo.setMsgtx(value);
			}
		} else {
			sapAsGrGiTrtCnclResultVo.setMsgty("S");
			sapAsGrGiTrtCnclResultVo.setMsgno("200");
		}
		return sapAsGrGiTrtCnclResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 8. 29.
	 * @param
	 * @return
	 * @throws Exception
	 * @description AS 센터간재고이전 API
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAsCntrStkTransferResultVo sapAsCntrStkTransfer(EzMap param) throws Exception {

		// AS 센터간재고이전 결과 VO
		SapAsCntrStkTransferResultVo sapAsCntrStkTransferResultVo = new SapAsCntrStkTransferResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// SAP AS 센터간재고이전 요청
		String resJsonData = restApiCallService.httpCallApi(restUrl + AS_CNTR_STK_TRANSFER, param, "POST", null,
				header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAsCntrStkTransferResultVo.setMsgty("E");
			sapAsCntrStkTransferResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAsCntrStkTransferResultVo.setMsgid(code);
				sapAsCntrStkTransferResultVo.setMsgtx(value);
			}
		} else {
			sapAsCntrStkTransferResultVo = Utilities.beanToBean(d, SapAsCntrStkTransferResultVo.class);

			sapAsCntrStkTransferResultVo.setMsgty("S");
			sapAsCntrStkTransferResultVo.setMsgno("200");
		}

		return sapAsCntrStkTransferResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 9.20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 본사3000번 재고조회
	 *
	 */
	@SuppressWarnings("unchecked")
	public SapAs3000MatnrResultVo sapAs3000Matnr(EzMap param) throws Exception {

		// 본사 3000번 재고조회
		SapAs3000MatnrResultVo sapAs3000MatnrResultVo = new SapAs3000MatnrResultVo();

		// 헤더 세팅
		EzMap header = reqHeaderParam("POST");

		// SAP 본사 3000번 재고조회
		String resJsonData = restApiCallService.httpCallApi(restUrl + AS_3000_MATNR, param, "POST", null, header);

		// Response Data
		Map<String, Object> map = Utilities.getJson(resJsonData);
		Map<String, Object> err = (Map<String, Object>) map.get("error");
		Map<String, Object> d = (Map<String, Object>) map.get("d");

		if (!Utilities.isEmpty(err)) {
			Map<String, Object> msg = (Map<String, Object>) err.get("message");

			String code = (String) err.get("code");
			String value = (String) msg.get("value");

			sapAs3000MatnrResultVo.setMsgty("E");
			sapAs3000MatnrResultVo.setMsgno("400");

			if (Utilities.isNotEmpty(value)) {
				sapAs3000MatnrResultVo.setMsgid(code);
				sapAs3000MatnrResultVo.setMsgtx(value);
			}
		} else {
			Map<String, Object> items = (Map<String, Object>) d.get("items");
			List<SapAs3000MatnrResultListVo> results = (ArrayList<SapAs3000MatnrResultListVo>) items.get("results");
			Iterator<SapAs3000MatnrResultListVo> iter = results.iterator();

			while (iter.hasNext()) {
				Map<String, Object> resultsMap = (Map<String, Object>) iter.next();
				resultsMap.remove("__metadata");
			}

			sapAs3000MatnrResultVo.setResults(results);

			sapAs3000MatnrResultVo.setMsgty("S");
			sapAs3000MatnrResultVo.setMsgno("200");
		}

		return sapAs3000MatnrResultVo;
	}

	/**
	 * @author 김연지
	 * @date 2022. 6. 14.
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
