package com.ceragem.api.crm.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.ws.http.HTTPException;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.model.ApiVoidResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmChlBasVo;
import com.ceragem.api.crm.model.CrmCouponApproSo;
import com.ceragem.api.crm.model.CrmCouponCustNoSo;
import com.ceragem.api.crm.model.CrmCouponSo;
import com.ceragem.api.crm.model.CrmCouponVo;
import com.ceragem.api.crm.model.CrmGodsBasVo;
import com.ceragem.api.crm.model.CrmMshipCoupnBasSo;
import com.ceragem.api.crm.model.CrmMshipCoupnBasVo;
import com.ceragem.api.crm.service.CrmCouponService;
import com.ceragem.api.crm.service.CrmMshipCoupnBasService;
import com.ceragem.crm.common.model.EzApiException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName CrmCoupnPblsHstController
 * @author 김성태
 * @date 2022. 4. 28.
 * @Version 1.0
 * @description CRM쿠폰 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Tag(name = "CRM쿠폰", description = "CRM쿠폰 API")
@RestController
@RequestMapping("/crm/v1.0/coupon")
public class CrmCouponController extends BaseRestController {

	@Autowired
	CrmCouponService service;

	@Autowired
	CrmMshipCoupnBasService masterService;

	@GetMapping("barcode/{coupnPblsHstSeq}")
	@Operation(summary = "CRM쿠폰바코드", description = "CRM쿠폰바코드 스캐너 테스트용", hidden = true)
	public void coupon(@PathVariable("coupnPblsHstSeq") String coupnPblsHstSeq,
			@RequestParam(value = "width", required = false) Integer width,
			@RequestParam(value = "height", required = false) Integer height, HttpServletResponse response) {
		Integer wd = width;
		Integer ht = height;
		ByteArrayInputStream in = null;
		try {
			if (wd == null || wd == 0)
				wd = 800;
			if (ht == null || ht == 0)
				ht = 150;
			in = new ByteArrayInputStream(service.createBarcode(coupnPblsHstSeq, wd, ht));
			String contentsType = "image/png";
			response.setContentType(contentsType);
			response.setHeader("Content-Disposition",
					"filename=\"" + URLEncoder.encode(coupnPblsHstSeq + ".png", "UTF-8") + "\";");
			Utilities.DownloadStream(response.getOutputStream(), in);
		} catch (Exception ex) {
			throw new HTTPException(404);
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
		}
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰 검색
	 *
	 */
	@GetMapping("master/list")
	@Operation(summary = "CRM쿠폰마스터 검색", description = "CRM마스터 검색", hidden = false)
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmMshipCoupnBasVo>>> getCrmCustMasterList(
			@Parameter(description = "CRM쿠폰 검색객체") @ParameterObject @Valid CrmMshipCoupnBasSo so) throws Exception {
		List<CrmMshipCoupnBasVo> list = masterService.getList(so);
		int cnt = masterService.getListCount(so);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰 검색
	 *
	 */
	@GetMapping("master/{mshipCoupnBasNo}")
	@Operation(summary = "CRM쿠폰마스터 검색", description = "CRM마스터 검색", hidden = false)
	public ResponseEntity<ApiResultVo<CrmMshipCoupnBasVo>> getCrmCustMasterList(
			@Parameter(description = "쿠폰마스터일련번호") @PathVariable("mshipCoupnBasNo") String mshipCoupnBasNo

	) throws Exception {
		CrmMshipCoupnBasSo so = new CrmMshipCoupnBasSo();
		so.setMshipCoupnBasNo(mshipCoupnBasNo);
		CrmMshipCoupnBasVo vo = masterService.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM쿠폰 검색", description = "CRM쿠폰 검색", hidden = false)
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCouponVo>>> getCrmCustBasList(
			@Parameter(description = "CRM쿠폰 검색객체") @ParameterObject @Valid CrmCouponSo so) throws Exception {

		List<CrmCouponVo> list = service.getList(so);
		int cnt = service.getListCount(so);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM회원 쿠폰 검색
	 *
	 */
	@GetMapping("membership/{itgCustNo}")
	@Operation(summary = "CRM 회원 쿠폰 목록", description = "CRM 회원 쿠폰 목록")
	public ResponseEntity<ApiResultVo<List<CrmCouponVo>>> getCrmCustBasList(
			@Parameter(description = "통합고객번호") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "CRM쿠폰 검색객체") @ModelAttribute @ParameterObject @Valid CrmCouponCustNoSo no)
			throws Exception {

		no.setItgCustNo(itgCustNo);
		CrmCouponSo so = Utilities.beanToBean(no, CrmCouponSo.class);

		// 주일 , 시간
		Calendar cal = Calendar.getInstance();
		int dayNum = cal.get(Calendar.DAY_OF_WEEK);
		switch (dayNum) {
		case 1:
			so.setDow7UseYn("Y"); // 일
			break;
		case 2:
			so.setDow1UseYn("Y"); // 월
			break;
		case 3:
			so.setDow2UseYn("Y"); // 화
			break;
		case 4:
			so.setDow3UseYn("Y"); // 수
			break;
		case 5:
			so.setDow4UseYn("Y"); // 목
			break;
		case 6:
			so.setDow5UseYn("Y"); // 금
			break;
		case 7:
			so.setDow6UseYn("Y"); // 토
			break;
		default:
			break;
		}

		so.setUseHour(String.format("%02d", cal.get(Calendar.HOUR_OF_DAY)) + ""
				+ String.format("%02d", cal.get(Calendar.MINUTE)));

		List<CrmCouponVo> list = service.getList(so);

		for (CrmCouponVo crmCouponVo : list) {
			// LISTAGG 4000 바이트 이상시 에러 발생
			List<CrmGodsBasVo> godsList = service.getGodsList(crmCouponVo.getMshipCoupnBasNo());
			crmCouponVo.setGodsList(godsList);

			List<CrmChlBasVo> chlList = service.getChlList(crmCouponVo.getMshipCoupnBasNo());
			crmCouponVo.setChlList(chlList);
		}

		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰단건 검색
	 *
	 */
	@GetMapping("/{coupnPblsBasNo}")
	@Operation(summary = "CRM쿠폰 상세", description = "CRM쿠폰 상세")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> getCrmCoupnPblsHst(
			@Parameter(description = "쿠폰번호") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo) throws Exception {
		CrmCouponSo so = new CrmCouponSo();
		so.setCoupnPblsBasNo(coupnPblsBasNo);
		CrmCouponVo vo = service.get(so);

		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);

		List<CrmGodsBasVo> godsList = service.getGodsList(vo.getMshipCoupnBasNo());
		vo.setGodsList(godsList);

		List<CrmChlBasVo> chlList = service.getChlList(vo.getMshipCoupnBasNo());
		vo.setChlList(chlList);

		return successResponse(vo);
	}

	@GetMapping("validate/{coupnPblsBasNo}")
	@Operation(summary = "CRM쿠폰 유효성", description = "CRM쿠폰 유효성")
	public ResponseEntity<ApiVoidResultVo> validCoupon(
			@Parameter(description = "쿠폰번호") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo,
			@Parameter(description = "쿠폰정보", hidden = true) @ModelAttribute CrmCouponVo param) throws Exception {
		param.setCoupnPblsBasNo(coupnPblsBasNo);
		service.updateValidate(param);
		return successResponse();
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰발행이력 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM 쿠폰 발행", description = "CRM 쿠폰 발행")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> registerCrmCoupn(
			@Parameter(description = "CRM 쿠폰 객체") @RequestBody @Valid CrmCouponVo vo) throws Exception {
		CrmCouponVo ret = service.insertIssue(vo);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰발행이력 입력
	 *
	 */
	@PostMapping("approve/{coupnPblsBasNo}")
	@Operation(summary = "CRM쿠폰 사용", description = "CRM쿠폰 사용")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> useCrmCoupnPblsHsts(
			@Parameter(description = "쿠폰번호") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo,
			@Parameter(description = "쿠폰정보") @ModelAttribute @ParameterObject @Valid CrmCouponApproSo so
	/* @Parameter(description = "쿠폰정보") @ModelAttribute CrmCouponVo param */) throws Exception {

		CrmCouponVo vo = new CrmCouponVo();
		vo.setCoupnPblsBasNo(coupnPblsBasNo);
		vo.setStorNo(so.getStorNo());
		// 있을시 저장
		vo.setBuyGodsCd(so.getBuyGodsCd());
		vo.setOrdrAmt(so.getOrdrAmt());
		vo.setPayAmt(so.getPayAmt());
		vo.setSaleAmt(so.getSaleAmt());
		vo.setChitNo(so.getChitNo());
		vo.setPromNo(so.getPromNo());
		vo.setCampNo(so.getCampNo());
		vo.setItgCustNo(so.getItgCustNo());
		vo.setUseChlCd(so.getChlCd());

		int ret = service.updateApprove(vo);
		if (Utilities.isEmpty(ret))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰 사용
	 *
	 */
	@PostMapping("cancel/{coupnPblsBasNo}")
	@Operation(summary = "CRM쿠폰 사용 취소", description = "CRM쿠폰 사용 취소")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> cancelCrmCoupnPblsHst(
			@Parameter(description = "쿠폰번호") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo,
			@Parameter(hidden = true) @ModelAttribute CrmCouponVo vo) throws Exception {
		vo.setCoupnPblsBasNo(coupnPblsBasNo);
		int ret = service.updateCancel(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM쿠폰 선물
	 *
	 */
	@PostMapping("gift/{coupnPblsBasNo}/{fromItgCustNo}/{toItgCustNo}")
	@Operation(summary = "CRM쿠폰 선물", description = "CRM쿠폰 선물")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> gift(
			@Parameter(description = "보내는 통합회원 번호") @PathVariable("fromItgCustNo") String fromItgCustNo,
			@Parameter(description = "받는 통합회원 번호") @PathVariable("toItgCustNo") String toItgCustNo,
			@Parameter(description = "쿠폰번호") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo) throws Exception {
		CrmCouponVo ret = service.saveGiftCoupn(coupnPblsBasNo, fromItgCustNo, toItgCustNo);
		if (ret == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

}
