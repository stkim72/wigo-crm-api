
package com.ceragem.api.sap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.sap.model.SapAs3000MatnrResultVo;
import com.ceragem.api.sap.model.SapAs3000MatnrVo;
import com.ceragem.api.sap.model.SapAsCmptTrtCnclResultVo;
import com.ceragem.api.sap.model.SapAsCmptTrtCnclVo;
import com.ceragem.api.sap.model.SapAsCmptTrtResultVo;
import com.ceragem.api.sap.model.SapAsCmptTrtVo;
import com.ceragem.api.sap.model.SapAsCntrStkTransferResultVo;
import com.ceragem.api.sap.model.SapAsCntrStkTransferVo;
import com.ceragem.api.sap.model.SapAsGrGiTrtCnclResultVo;
import com.ceragem.api.sap.model.SapAsGrGiTrtCnclVo;
import com.ceragem.api.sap.model.SapAsGrGiTrtResultVo;
import com.ceragem.api.sap.model.SapAsGrGiTrtVo;
import com.ceragem.api.sap.model.SapAsKostCenterResultVo;
import com.ceragem.api.sap.model.SapAsKostCenterSo;
import com.ceragem.api.sap.model.SapAsMatnrMengeResultVo;
import com.ceragem.api.sap.model.SapAsMatnrMengeVo;
import com.ceragem.api.sap.model.SapAsMatnrRqCnclResultVo;
import com.ceragem.api.sap.model.SapAsMatnrRqCnclVo;
import com.ceragem.api.sap.model.SapAsMatnrRqResultVo;
import com.ceragem.api.sap.model.SapAsMatnrRqVo;
import com.ceragem.api.sap.model.SapAsRfndResultVo;
import com.ceragem.api.sap.model.SapAsRfndTrtCnclResultVo;
import com.ceragem.api.sap.model.SapAsRfndTrtCnclVo;
import com.ceragem.api.sap.model.SapAsRfndTrtResultVo;
import com.ceragem.api.sap.model.SapAsRfndTrtVo;
import com.ceragem.api.sap.model.SapAsRfndVo;
import com.ceragem.api.sap.service.SapAsService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @ClassName SapAsCmptTrtController
 * @author 김연지
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description SAP AS Controller
 */

@Tag(name = "SAP AS", description = "SAP AS API")
@RestController
@RequestMapping("/sap/v1.0/as")
public class SapAsController extends BaseRestController {

	@Autowired
	SapAsService service;

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP AS 완료처리
	 *
	 */
	@PostMapping("/so")
	@Operation(summary = "SAP AS처리 - AS 완료처리", description = "SAP AS처리 - AS 완료처리 API")
	public ResponseEntity<ApiResultVo<SapAsCmptTrtResultVo>> sapAsCmptTrt(
			@Parameter(description = "SAP AS 완료처리 객체") @RequestBody @Valid SapAsCmptTrtVo paramVo) throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP AS 완료처리, SAP시스템으로 전달
		SapAsCmptTrtResultVo sapAsCmptTrtResultVo = service.sapAsCmptTrt(param);

		if (Utilities.isEmpty(sapAsCmptTrtResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapAsCmptTrtResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP AS 완료취소
	 *
	 */
	@DeleteMapping("/so/{bstkd}")
	@Operation(summary = "SAP AS처리 - AS 완료취소", description = "SAP AS처리 - AS 완료취소 API")
	public ResponseEntity<ApiResultVo<Object>> sapAsCmptCncl(
			@Parameter(description = "AS접수번호") @PathVariable("bstkd") String bstkd) throws Exception {

		SapAsCmptTrtCnclVo sapAsCmptTrtCnclVo = new SapAsCmptTrtCnclVo();
		sapAsCmptTrtCnclVo.setBstkd(bstkd);

		SapAsCmptTrtCnclResultVo sapAsCmptTrtCnclResultVo = service.sapAsCmptTrtCncl(sapAsCmptTrtCnclVo);

		return successResponse(sapAsCmptTrtCnclResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP AS 환불처리
	 *
	 */
	@PostMapping("/cm")
	@Operation(summary = "SAP AS처리 - AS 환불처리", description = "SAP AS처리 - AS 환불처리 API")
	public ResponseEntity<ApiResultVo<SapAsRfndResultVo>> sapAsRfnd(
			@Parameter(description = "SAP AS 환불처리 객체") @RequestBody @Valid SapAsRfndVo paramVo) throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP AS 환불처리
		SapAsRfndResultVo sapAsRfndResultVo = service.sapAsRfnd(param);

		if (Utilities.isEmpty(sapAsRfndResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapAsRfndResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP 자재현재고조회
	 *
	 */
	@GetMapping("/mb52/{matnr}/{lgort}")
	@Operation(summary = "SAP 기준정보 - 자재현재고 조회", description = "기준정보 - SAP 자재현재고 조회 API")
	public ResponseEntity<ApiResultVo<SapAsMatnrMengeResultVo>> sapAsMantrMenge(
			@Parameter(description = "자재코드") @PathVariable("matnr") String matnr,
			@Parameter(description = "저장위치") @PathVariable("lgort") String lgort) throws Exception {

		SapAsMatnrMengeVo sapAsMatnrMengeVo = new SapAsMatnrMengeVo();
		sapAsMatnrMengeVo.setMatnr(matnr);
		sapAsMatnrMengeVo.setLgort(lgort);

		// 자재현재고조회
		SapAsMatnrMengeResultVo sapAsMatnrMengeResultVo = service.sapAsMantrMenge(sapAsMatnrMengeVo);

		if (Utilities.isEmpty(sapAsMatnrMengeResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapAsMatnrMengeResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 14.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP 코스트센터
	 *
	 */
	@GetMapping("/ks13/{bukrs}")
	@Operation(summary = "SAP 기준정보 - 코스트센터 조회", description = "SAP 기준정보 - 코스트센터 조회 API")
	public ResponseEntity<ApiResultVo<SapAsKostCenterResultVo>> sapAsKostCenter(
			@Parameter(description = "회사코드") @PathVariable("bukrs") String bukrs) throws Exception {

		SapAsKostCenterSo sapAsKostCenterSo = new SapAsKostCenterSo();
		sapAsKostCenterSo.setBukrs(bukrs);

		SapAsKostCenterResultVo sapAsKostCenterResultVo = service.sapAsKostCenter(sapAsKostCenterSo);

		if (Utilities.isEmpty(sapAsKostCenterResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapAsKostCenterResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP 유상매출 반제처리
	 *
	 */
	@PostMapping("/f32")
	@Operation(summary = "SAP 수금반제 - 유상매출 반제처리", description = "SAP 수금반제 - 유상매출 반제처리 API")
	public ResponseEntity<ApiResultVo<SapAsRfndTrtResultVo>> sapAsRfndTrt(
			@Parameter(description = "SAP 유상매출 반제처리 객체") @RequestBody @Valid SapAsRfndTrtVo paramVo) throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP 유상매출 반제처리
		SapAsRfndTrtResultVo sapAsRfndTrtResultVo = service.sapAsRfndTrt(param);

		if (Utilities.isEmpty(sapAsRfndTrtResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapAsRfndTrtResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP 유상매출 반제취소
	 *
	 */
	@DeleteMapping("/f32/{rfndadmno}/{paytype}")
	@Operation(summary = "SAP 수금반제 - 유상매출 반제취소", description = "SAP 수금반제 - 유상매출 반제취소 API")
	public ResponseEntity<ApiResultVo<Object>> sapAsRfndCncl(
			@Parameter(description = "반제관리번호") @PathVariable("rfndadmno") String rfndadmno,
			@Parameter(description = "대금유형") @PathVariable("paytype") String paytype) throws Exception {

		SapAsRfndTrtCnclVo sapAsRfndTrtCnclVo = new SapAsRfndTrtCnclVo();
		sapAsRfndTrtCnclVo.setRfndadmno(rfndadmno);
		sapAsRfndTrtCnclVo.setPaytype(paytype);

		SapAsRfndTrtCnclResultVo sapAsRfndTrtCnclResultVo = service.sapAsRfndCncl(sapAsRfndTrtCnclVo);

		return successResponse(sapAsRfndTrtCnclResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP AS 자재요청
	 *
	 */
	@PostMapping("/pr")
	@Operation(summary = "SAP 자재요청 - AS 자재요청", description = "SAP 자재요청 - AS 자재요청 API")
	public ResponseEntity<ApiResultVo<SapAsMatnrRqResultVo>> sapAsMatnrRq(
			@Parameter(description = "SAP AS 자재요청 객체") @RequestBody @Valid SapAsMatnrRqVo paramVo) throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP AS 자재요청
		SapAsMatnrRqResultVo sapAsMatnrRqResultVo = service.sapAsMatnrRq(param);

		if (Utilities.isEmpty(sapAsMatnrRqResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapAsMatnrRqResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP AS 자재요청 취소
	 *
	 */
	@DeleteMapping("/pr/{intime}")
	@Operation(summary = "SAP 자재요청 - AS 자재요청 취소", description = "SAP 자재요청 - AS 자재요청 취소 API")
	public ResponseEntity<ApiResultVo<Object>> sapAsMatnrRqCncl(
			@Parameter(description = "자재요청번호") @PathVariable("intime") String intime) throws Exception {

		SapAsMatnrRqCnclVo sapAsMatnrRqCnclVo = new SapAsMatnrRqCnclVo();
		sapAsMatnrRqCnclVo.setIntime(intime);

		SapAsMatnrRqCnclResultVo sapAsMatnrRqCnclResultVo = service.sapAsMatnrRqCncl(sapAsMatnrRqCnclVo);

		return successResponse(sapAsMatnrRqCnclResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP 입/출고처리
	 *
	 */
	@PostMapping("/mb1")
	@Operation(summary = "SAP 기타 - 입/출고처리", description = "SAP 기타 - 입/출고처리 API")
	public ResponseEntity<ApiResultVo<SapAsGrGiTrtResultVo>> sapAsGrGiTrt(
			@Parameter(description = "SAP 입/출고처리 객체") @RequestBody @Valid SapAsGrGiTrtVo paramVo) throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP 입/출고처리
		SapAsGrGiTrtResultVo sapAsGrGiTrtResultVo = service.sapAsGrGiTrt(param);

		if (Utilities.isEmpty(sapAsGrGiTrtResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapAsGrGiTrtResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 6. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP 입/출고 취소
	 *
	 */
	@DeleteMapping("/mb1/{ifkey}")
	@Operation(summary = "SAP 기타 - 입/출고취소", description = "SAP 기타 - 입/출고취소 API")
	public ResponseEntity<ApiResultVo<Object>> sapAsGrGiTrtCncl(
			@Parameter(description = "기타입출고 IF키") @PathVariable("ifkey") String ifkey) throws Exception {

		SapAsGrGiTrtCnclVo sapAsGrGiTrtCnclVo = new SapAsGrGiTrtCnclVo();
		sapAsGrGiTrtCnclVo.setIfkey(ifkey);

		SapAsGrGiTrtCnclResultVo sapAsGrGiTrtCnclResultVo = service.sapAsGrGiTrtCncl(sapAsGrGiTrtCnclVo);

		return successResponse(sapAsGrGiTrtCnclResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 8. 29.
	 * @param
	 * @return
	 * @throws Exception
	 * @description SAP 센터간재고이전
	 *
	 */
	@PostMapping("/bt")
	@Operation(summary = "SAP 센터간재고이전", description = "SAP 센터간재고이전")
	public ResponseEntity<ApiResultVo<SapAsCntrStkTransferResultVo>> sapAsCntrStkTransfer(
			@Parameter(description = "SAP 센터간재고이전 객체") @RequestBody @Valid SapAsCntrStkTransferVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP 센터간재고이전, SAP시스템으로 전달
		SapAsCntrStkTransferResultVo sapAsCntrStkTransferResultVo = service.sapAsCntrStkTransfer(param);

		if (Utilities.isEmpty(sapAsCntrStkTransferResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapAsCntrStkTransferResultVo);
	}

	/**
	 *
	 * @author 김연지
	 * @date 2022. 9. 20.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 본사 3000번 창고 현재고 조회
	 *
	 */
	@PostMapping("/mb52list")
	@Operation(summary = "SAP 본사 3000번 창고 현재고 조회", description = "SAP 본사 3000번 창고 현재고 조회")
	public ResponseEntity<ApiResultVo<SapAs3000MatnrResultVo>> sapAs3000Matnr(
			@Parameter(description = "SAP 본사 3000번 창고 현재고 조회 객체") @RequestBody @Valid SapAs3000MatnrVo paramVo)
			throws Exception {

		EzMap param = new EzMap(paramVo);

		// SAP 본사 3000번 창고 현재고 조회
		SapAs3000MatnrResultVo sapAs3000MatnrResultVo = service.sapAs3000Matnr(param);

		if (Utilities.isEmpty(sapAs3000MatnrResultVo)) {
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		}

		return successResponse(sapAs3000MatnrResultVo);
	}
}
