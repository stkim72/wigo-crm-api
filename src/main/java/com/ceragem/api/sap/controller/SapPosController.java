package com.ceragem.api.sap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.sap.model.SapPosCb5GiResultVo;
import com.ceragem.api.sap.model.SapPosCb5GiVo;
import com.ceragem.api.sap.model.SapPosCgiCcResultVo;
import com.ceragem.api.sap.model.SapPosCgiCcVo;
import com.ceragem.api.sap.model.SapPosCustomItemResultVo;
import com.ceragem.api.sap.model.SapPosCustomVo;
import com.ceragem.api.sap.model.SapPosFcStkSetResultItemVo;
import com.ceragem.api.sap.model.SapPosGiScheResultVo;
import com.ceragem.api.sap.model.SapPosGiScheVo;
import com.ceragem.api.sap.model.SapPosIncomSetResultVo;
import com.ceragem.api.sap.model.SapPosIncomSetVo;
import com.ceragem.api.sap.model.SapPosMatnrItemResultVo;
import com.ceragem.api.sap.model.SapPosMatnrSetResultVo;
import com.ceragem.api.sap.model.SapPosMatnrSetVo;
import com.ceragem.api.sap.model.SapPosMatnrVo;
import com.ceragem.api.sap.model.SapPosNvlGiSetResultVo;
import com.ceragem.api.sap.model.SapPosNvlGiSetVo;
import com.ceragem.api.sap.model.SapPosRcpItemResultVo;
import com.ceragem.api.sap.model.SapPosRcpVo;
import com.ceragem.api.sap.model.SapPosSalesResultVo;
import com.ceragem.api.sap.model.SapPosSpcHisResultVo;
import com.ceragem.api.sap.model.SapPosSpcHisVo;
import com.ceragem.api.sap.model.SapPosSpcItemResultVo;
import com.ceragem.api.sap.model.SapPosSpcVo;
import com.ceragem.api.sap.model.SapPosStduseSetResultVo;
import com.ceragem.api.sap.model.SapPosStduseSetVo;
import com.ceragem.api.sap.model.SapPosTenderResultVo;
import com.ceragem.api.sap.model.SapPosTenderVo;
import com.ceragem.api.sap.model.SapPosWcfBtResultVo;
import com.ceragem.api.sap.model.SapPosWcfBtVo;
import com.ceragem.api.sap.model.SapPosWcfGiResultVo;
import com.ceragem.api.sap.model.SapPosWcfGiVo;
import com.ceragem.api.sap.model.SapPosWcfGrResultVo;
import com.ceragem.api.sap.model.SapPosWcfGrVo;
import com.ceragem.api.sap.model.SapPosWcfStkResultVo;
import com.ceragem.api.sap.model.SapPosWcfStkVo;
import com.ceragem.api.sap.service.SapPosServcie;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "SAP POS", description = "SAP POS API")
@RestController
@RequestMapping("/sap/v1.0/pos")
public class SapPosController extends BaseRestController {

	@Autowired
	SapPosServcie service;

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 24.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP POS 품목마스터(식음료)
	 *
	 */
	@PostMapping("/spc-item")
	@Operation(summary = "SAP POS 품목마스터(식음료)", description = "SAP POS 품목마스터(식음료) API")
	public ResponseEntity<ApiResultVo<SapPosSpcItemResultVo>> sapPosSpcItem(
			@Parameter(description = "SAP POS 품목마스터(식음료) 객체") @RequestBody @Valid SapPosSpcVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP POS 품목마스터(식음료), SAP시스템으로 전달
		SapPosSpcItemResultVo sapPosSpcItemResultVo = service.sapPosSpcItem(param);

		if (Utilities.isEmpty(sapPosSpcItemResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosSpcItemResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 24.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP POS 레시피 마스터(식음료)
	 *
	 */
	@PostMapping("/rcp-item")
	@Operation(summary = "SAP POS 레시피 마스터(식음료)", description = "SAP POS 레시피 마스터(식음료) API")
	public ResponseEntity<ApiResultVo<SapPosRcpItemResultVo>> sapPosRcpItem(
			@Parameter(description = "SAP POS 레시피 마스터(식음료) 객체") @RequestBody @Valid SapPosRcpVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP POS 레시피 마스터(식음료), SAP시스템으로 전달
		SapPosRcpItemResultVo sapPosRcpItemResultVo = service.sapPosRcpItem(param);

		if (Utilities.isEmpty(sapPosRcpItemResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosRcpItemResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 24.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP POS 품목마스터(식음료) 공급가
	 *
	 */
	@PostMapping("/spc-item-his")
	@Operation(summary = "SAP POS 품목마스터(식음료) 공급가", description = "SAP POS 품목마스터(식음료) 공급가 API")
	public ResponseEntity<ApiResultVo<SapPosSpcHisResultVo>> sapPosSpcItemHis(
			@Parameter(description = "SAP POS 품목마스터(식음료) 공급가 객체") @RequestBody @Valid SapPosSpcHisVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// 품목마스터(식음료) 공급가, SAP시스템으로 전달
		SapPosSpcHisResultVo sapPosSpcHisResultVo = service.sapPosSpcItemHis(param);

		if (Utilities.isEmpty(sapPosSpcHisResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosSpcHisResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 매장 정보를 조회
	 *
	 */
	@GetMapping("/custom")
	@Operation(summary = "SAP POS 매장 정보 조회", description = "SAP POS 매장 정보 조회 API")
	public ResponseEntity<ApiResultVo<SapPosCustomItemResultVo>> sapPosCustom(
			@Parameter(description = "일자", required = false) @RequestParam(required = false, value = "erdat") String erdat)
			throws Exception {

		SapPosCustomVo sapPosCustomVo = new SapPosCustomVo();
		sapPosCustomVo.setErdat(erdat);

		// 매장 정보를 조회하여 송신한다
		SapPosCustomItemResultVo sapPosCustomItemResultVo = service.sapPosCustom(sapPosCustomVo);

		if (Utilities.isEmpty(sapPosCustomItemResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosCustomItemResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description POS 매출 전송(일별/품목별)
	 *
	 */
	@PostMapping("/sales")
	@Operation(summary = "POS 매출 전송(일별/품목별)", description = "POS 매출 전송(일별/품목별) API")
	public ResponseEntity<ApiResultVo<SapPosSalesResultVo>> sapPosSales(
			@Parameter(description = "POS 매출 전송(일별/품목별) 객체") @RequestBody @Valid SapPosSalesResultVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 매출 데이터를 전송한다(일별/품목별)
		SapPosSalesResultVo sapPosSalesResultVo = service.sapPosSales(param);

		if (Utilities.isEmpty(sapPosSalesResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosSalesResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP POS 신규 제,상품 전송
	 *
	 */
	@GetMapping("/matnr")
	@Operation(summary = "SAP POS 신규 제,상품 전송", description = "SAP POS 신규 제,상품 전송 API")
	public ResponseEntity<ApiResultVo<SapPosMatnrItemResultVo>> sapPosMatnr(
			@Parameter(description = "일자", required = false) @RequestParam(required = false, value = "ersda") String ersda)
			throws Exception {

		SapPosMatnrVo sapPosMatnrVo = new SapPosMatnrVo();
		sapPosMatnrVo.setErsda(ersda);

		// SAP POS 신규 제,상품 전송
		SapPosMatnrItemResultVo sapPosMatnrItemResultVo = service.sapPosMatnr(sapPosMatnrVo);

		if (Utilities.isEmpty(sapPosMatnrItemResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosMatnrItemResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 6. 28.
	 * @param
	 * @return
	 * @throws Exception
	 * @description POS 매출전송(영수증별)
	 *
	 */
	@PostMapping("/tender")
	@Operation(summary = "POS 매출전송(영수증별)", description = "POS 매출전송(영수증별) API")
	public ResponseEntity<ApiResultVo<SapPosTenderResultVo>> sapPosTender(
			@Parameter(description = "POS 매출전송(영수증별) 객체") @RequestBody @Valid SapPosTenderVo paramVo) throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 매출전송(영수증별)
		SapPosTenderResultVo sapPosTenderResultVo = service.sapPosTender(param);

		if (Utilities.isEmpty(sapPosTenderResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosTenderResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페)입고 확정 내역
	 *
	 */
	@PostMapping("/wcf-gr")
	@Operation(summary = "POS 웰카페)입고 확정 내역", description = "POS 웰카페)입고 확정 내역 API")
	public ResponseEntity<ApiResultVo<SapPosWcfGrResultVo>> sapPosWcfGr(
			@Parameter(description = "POS 웰카페)입고 확정 내역 객체") @RequestBody @Valid SapPosWcfGrVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 POS 웰카페)입고 확정 내역 전송
		SapPosWcfGrResultVo sapPosWcfGrResultVo = service.sapPosWcfGr(param);

		if (Utilities.isEmpty(sapPosWcfGrResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosWcfGrResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페)점간 이동 내역
	 *
	 */
	@PostMapping("/wcf-bt")
	@Operation(summary = "웰카페)점간 이동 내역", description = "웰카페)점간 이동 내역 API")
	public ResponseEntity<ApiResultVo<SapPosWcfBtResultVo>> sapPosWcfBt(
			@Parameter(description = "웰카페)점간 이동 내역 객체") @RequestBody @Valid SapPosWcfBtVo paramVo) throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 POS 웰카페)점간 이동 내역 전송
		SapPosWcfBtResultVo sapPosWcfBtResultVo = service.sapPosWcfBt(param);

		if (Utilities.isEmpty(sapPosWcfBtResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosWcfBtResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 매출 반품확정내역
	 *
	 */
	@PostMapping("/cgi-cc")
	@Operation(summary = "매출 반품확정내역", description = "매출 반품확정내역 API")
	public ResponseEntity<ApiResultVo<SapPosCgiCcResultVo>> sapPosCgiCc(
			@Parameter(description = "매출 반품확정내역 객체") @RequestBody @Valid SapPosCgiCcVo paramVo) throws Exception {

		EzMap param = new EzMap(paramVo);

		// 전 매장(cb5, 나비엘, 웰카페)의 본사로의 반품확정을 SAP으로 전송한다.
		SapPosCgiCcResultVo sapPosCgiCcResultVo = service.sapPosCgiCc(param);

		if (Utilities.isEmpty(sapPosCgiCcResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosCgiCcResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 상품 세트 마스터
	 *
	 */
	@GetMapping("/matnr-set")
	@Operation(summary = "SAP POS 상품 세트 마스터", description = "SAP POS 상품 세트 마스터 API")
	public ResponseEntity<ApiResultVo<SapPosMatnrSetResultVo>> sapPosMatnrSet(
			@Parameter(description = "일자", required = false) @RequestParam(required = false, value = "ersda") String ersda)
			throws Exception {

		SapPosMatnrSetVo sapPosMatnrSetVo = new SapPosMatnrSetVo();
		sapPosMatnrSetVo.setErsda(ersda);

		// SAP POS 상품 세트를 조회하여 송신한다
		SapPosMatnrSetResultVo sapPosMatnrSetResultVo = service.sapPosMatnrSet(sapPosMatnrSetVo);

		if (Utilities.isEmpty(sapPosMatnrSetResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosMatnrSetResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 4.
	 * @param
	 * @return
	 * @throws Exception
	 * @description CB5)주문 출고 승인, 취소
	 *
	 */
	@PostMapping("/cb5-gi")
	@Operation(summary = "SAP POS CB5)주문 출고 승인, 취소", description = "SAP POS CB5)주문 출고 승인, 취소 API")
	public ResponseEntity<ApiResultVo<SapPosCb5GiResultVo>> sapPosCb5GiSet(
			@Parameter(description = "SAP POS CB5)주문 출고 승인, 취소 객체") @RequestBody @Valid SapPosCb5GiVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 CB5의 주문승인, 승인취소내역을 SAP으로 전송한다
		SapPosCb5GiResultVo sapPosCb5GiResultVo = service.sapPosCb5GiSet(param);

		if (Utilities.isEmpty(sapPosCb5GiResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosCb5GiResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 4.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 나비엘)주문 출고 승인, 취소
	 *
	 */
	@PostMapping("/nvl-gi")
	@Operation(summary = "SAP POS 나비엘)주문 출고 승인, 취소", description = "SAP POS 나비엘)주문 출고 승인, 취소 API")
	public ResponseEntity<ApiResultVo<SapPosNvlGiSetResultVo>> sapPosNvlGiSet(
			@Parameter(description = "SAP POS CB5)주문 출고 승인, 취소 객체") @RequestBody @Valid SapPosNvlGiSetVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 나비엘의 주문승인, 승인취소내역을 SAP으로 전송한다
		SapPosNvlGiSetResultVo sapPosNvlGiSetResultVo = service.sapPosNvlGiSet(param);

		if (Utilities.isEmpty(sapPosNvlGiSetResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosNvlGiSetResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 4.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페)주문 이고 승인, 취소
	 *
	 */
	@PostMapping("/wcf-gi")
	@Operation(summary = "SAP POS 웰카페)주문 이고 승인, 취소", description = "SAP POS 웰카페)주문 이고 승인, 취소 API")
	public ResponseEntity<ApiResultVo<SapPosWcfGiResultVo>> sapPosWcfGiSet(
			@Parameter(description = "SAP POS 웰카페)주문 이고 승인, 취소 객체") @RequestBody @Valid SapPosWcfGiVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 웰카페의 주문 이고승인, 이고 취소 내역을 SAP으로 전송한다
		SapPosWcfGiResultVo sapPosWcfGiResultVo = service.sapPosWcfGiSet(param);

		if (Utilities.isEmpty(sapPosWcfGiResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosWcfGiResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 4.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 본사 현재고 조회
	 *
	 */
	@GetMapping("/fc-stk")
	@Operation(summary = "본사 현재고 조회", description = "SAP POS 본사 재고 실사 내역 API")
	public ResponseEntity<ApiResultVo<SapPosFcStkSetResultItemVo>> sapPosFcStkSet() throws Exception {

		// SAP 창고재고(CB5, 나비엘) 내역을 영업관리시스템으로 송신한다.
		SapPosFcStkSetResultItemVo sapPosFcStkSetResultItemVo = service.sapPosFcStkSet();

		if (Utilities.isEmpty(sapPosFcStkSetResultItemVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosFcStkSetResultItemVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 4.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페 표준소요량
	 *
	 */
	@PostMapping("/stduse")
	@Operation(summary = "SAP POS 웰카페 표준소요량", description = "SAP POS 웰카페 표준소요량 API")
	public ResponseEntity<ApiResultVo<SapPosStduseSetResultVo>> sapPosStduseSet(
			@Parameter(description = "SAP POS 웰카페 표준소요량 객체") @RequestBody @Valid SapPosStduseSetVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 웰카페의 주문 이고승인, 이고 취소 내역을 SAP으로 전송한다
		SapPosStduseSetResultVo sapPosStduseSetResultVo = service.sapPosStduseSet(param);

		if (Utilities.isEmpty(sapPosStduseSetResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosStduseSetResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 웰카페) 실사 (재고조사) 내역
	 *
	 */
	@PostMapping("/wcf-stk")
	@Operation(summary = "SAP POS 웰카페) 실사 (재고조사) 내역", description = "SAP POS 웰카페) 실사 (재고조사) 내역 API")
	public ResponseEntity<ApiResultVo<SapPosWcfStkResultVo>> sapPosWcfStk(
			@Parameter(description = "SAP POS 웰카페) 실사 (재고조사) 내역 객체") @RequestBody @Valid SapPosWcfStkVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 웰카페 매장의 실사(재고조사) 내역을 영업관리 시스템으로부터 수신 받는다.
		SapPosWcfStkResultVo sapPosWcfStkResultVo = service.sapPosWcfStk(param);

		if (Utilities.isEmpty(sapPosWcfStkResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosWcfStkResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 7. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 매장 출고 내역(매장 입고 예정)
	 *
	 */
	@GetMapping("/gi-sche/{zofwDate}")
	@Operation(summary = "SAP POS 매장 출고 내역(매장 입고 예정)", description = "SAP POS 매장 출고 내역(매장 입고 예정) API")
	public ResponseEntity<ApiResultVo<SapPosGiScheResultVo>> sapPosGiSche(
			@Parameter(description = "출고 일자(재고 이고 일자)") @PathVariable("zofwDate") String zofwDate) throws Exception {

		SapPosGiScheVo sapPosGiScheVo = new SapPosGiScheVo();
		sapPosGiScheVo.setZofwDate(zofwDate);

		SapPosGiScheResultVo sapPosGiScheResultVo = service.sapPosGiSche(sapPosGiScheVo);

		if (Utilities.isEmpty(sapPosGiScheResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosGiScheResultVo);
	}

	/**
	 *
	 * @author 이승빈
	 * @date 2022. 8. 1.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 사업부 입금내역 수신
	 *
	 */
	@PostMapping("/income")
	@Operation(summary = "SAP POS FC사업부 입금내역 수신 내역", description = "SAP POS FC사업부 입금내역 수신 API")
	public ResponseEntity<ApiResultVo<SapPosIncomSetResultVo>> income(
			@Parameter(description = "POS FC사업부 입금내역 수신 객체") @RequestBody @Valid SapPosIncomSetVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// POS에서 SAP로 매출전송(영수증별)
		SapPosIncomSetResultVo sapPosIncomSetResultVo = service.income(param);

		if (Utilities.isEmpty(sapPosIncomSetResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapPosIncomSetResultVo);
	}

}
