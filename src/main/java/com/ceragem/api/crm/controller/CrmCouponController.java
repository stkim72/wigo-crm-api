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
 * @author ?????????
 * @date 2022. 4. 28.
 * @Version 1.0
 * @description CRM?????? Controller
 * @Company Copyright ??? wigo.ai. All Right Reserved
 */
@Slf4j
@Tag(name = "CRM??????", description = "CRM?????? API")
@RestController
@RequestMapping("/crm/v1.0/coupon")
public class CrmCouponController extends BaseRestController {

	@Autowired
	CrmCouponService service;

	@Autowired
	CrmMshipCoupnBasService masterService;

	@GetMapping("barcode/{coupnPblsHstSeq}")
	@Operation(summary = "CRM???????????????", description = "CRM??????????????? ????????? ????????????", hidden = true)
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
	 * @author ?????????
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM?????? ??????
	 *
	 */
	@GetMapping("master/list")
	@Operation(summary = "CRM??????????????? ??????", description = "CRM????????? ??????", hidden = false)
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmMshipCoupnBasVo>>> getCrmCustMasterList(
			@Parameter(description = "CRM?????? ????????????") @ParameterObject @Valid CrmMshipCoupnBasSo so) throws Exception {
		List<CrmMshipCoupnBasVo> list = masterService.getList(so);
		int cnt = masterService.getListCount(so);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author ?????????
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM?????? ??????
	 *
	 */
	@GetMapping("master/{mshipCoupnBasNo}")
	@Operation(summary = "CRM??????????????? ??????", description = "CRM????????? ??????", hidden = false)
	public ResponseEntity<ApiResultVo<CrmMshipCoupnBasVo>> getCrmCustMasterList(
			@Parameter(description = "???????????????????????????") @PathVariable("mshipCoupnBasNo") String mshipCoupnBasNo

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
	 * @author ?????????
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM?????? ??????
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM?????? ??????", description = "CRM?????? ??????", hidden = false)
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCouponVo>>> getCrmCustBasList(
			@Parameter(description = "CRM?????? ????????????") @ParameterObject @Valid CrmCouponSo so) throws Exception {

		List<CrmCouponVo> list = service.getList(so);
		int cnt = service.getListCount(so);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author ?????????
	 * @date 2022. 4. 28.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM?????? ?????? ??????
	 *
	 */
	@GetMapping("membership/{itgCustNo}")
	@Operation(summary = "CRM ?????? ?????? ??????", description = "CRM ?????? ?????? ??????")
	public ResponseEntity<ApiResultVo<List<CrmCouponVo>>> getCrmCustBasList(
			@Parameter(description = "??????????????????") @PathVariable("itgCustNo") String itgCustNo,
			@Parameter(description = "CRM?????? ????????????") @ModelAttribute @ParameterObject @Valid CrmCouponCustNoSo no)
			throws Exception {

		no.setItgCustNo(itgCustNo);
		CrmCouponSo so = Utilities.beanToBean(no, CrmCouponSo.class);

		// ?????? , ??????
		Calendar cal = Calendar.getInstance();
		int dayNum = cal.get(Calendar.DAY_OF_WEEK);
		switch (dayNum) {
		case 1:
			so.setDow7UseYn("Y"); // ???
			break;
		case 2:
			so.setDow1UseYn("Y"); // ???
			break;
		case 3:
			so.setDow2UseYn("Y"); // ???
			break;
		case 4:
			so.setDow3UseYn("Y"); // ???
			break;
		case 5:
			so.setDow4UseYn("Y"); // ???
			break;
		case 6:
			so.setDow5UseYn("Y"); // ???
			break;
		case 7:
			so.setDow6UseYn("Y"); // ???
			break;
		default:
			break;
		}

		so.setUseHour(String.format("%02d", cal.get(Calendar.HOUR_OF_DAY)) + ""
				+ String.format("%02d", cal.get(Calendar.MINUTE)));

		List<CrmCouponVo> list = service.getList(so);

		for (CrmCouponVo crmCouponVo : list) {
			// LISTAGG 4000 ????????? ????????? ?????? ??????
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
	 * @author ?????????
	 * @date 2022. 4. 28.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM???????????? ??????
	 *
	 */
	@GetMapping("/{coupnPblsBasNo}")
	@Operation(summary = "CRM?????? ??????", description = "CRM?????? ??????")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> getCrmCoupnPblsHst(
			@Parameter(description = "????????????") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo) throws Exception {
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
	@Operation(summary = "CRM?????? ?????????", description = "CRM?????? ?????????")
	public ResponseEntity<ApiVoidResultVo> validCoupon(
			@Parameter(description = "????????????") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo,
			@Parameter(description = "????????????", hidden = true) @ModelAttribute CrmCouponVo param) throws Exception {
		param.setCoupnPblsBasNo(coupnPblsBasNo);
		service.updateValidate(param);
		return successResponse();
	}

	/**
	 *
	 * @author ?????????
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM?????????????????? ??????
	 *
	 */
	@PostMapping("")
	@Operation(summary = "CRM ?????? ??????", description = "CRM ?????? ??????")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> registerCrmCoupn(
			@Parameter(description = "CRM ?????? ??????") @RequestBody @Valid CrmCouponVo vo) throws Exception {
		CrmCouponVo ret = service.insertIssue(vo);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

	/**
	 *
	 * @author ?????????
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM?????????????????? ??????
	 *
	 */
	@PostMapping("approve/{coupnPblsBasNo}")
	@Operation(summary = "CRM?????? ??????", description = "CRM?????? ??????")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> useCrmCoupnPblsHsts(
			@Parameter(description = "????????????") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo,
			@Parameter(description = "????????????") @ModelAttribute @ParameterObject @Valid CrmCouponApproSo so
	/* @Parameter(description = "????????????") @ModelAttribute CrmCouponVo param */) throws Exception {

		CrmCouponVo vo = new CrmCouponVo();
		vo.setCoupnPblsBasNo(coupnPblsBasNo);
		vo.setStorNo(so.getStorNo());
		// ????????? ??????
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
	 * @author ?????????
	 * @date 2022. 4. 28.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM?????? ??????
	 *
	 */
	@PostMapping("cancel/{coupnPblsBasNo}")
	@Operation(summary = "CRM?????? ?????? ??????", description = "CRM?????? ?????? ??????")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> cancelCrmCoupnPblsHst(
			@Parameter(description = "????????????") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo,
			@Parameter(hidden = true) @ModelAttribute CrmCouponVo vo) throws Exception {
		vo.setCoupnPblsBasNo(coupnPblsBasNo);
		int ret = service.updateCancel(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author ?????????
	 * @date 2022. 4. 21.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM?????? ??????
	 *
	 */
	@PostMapping("gift/{coupnPblsBasNo}/{fromItgCustNo}/{toItgCustNo}")
	@Operation(summary = "CRM?????? ??????", description = "CRM?????? ??????")
	public ResponseEntity<ApiResultVo<CrmCouponVo>> gift(
			@Parameter(description = "????????? ???????????? ??????") @PathVariable("fromItgCustNo") String fromItgCustNo,
			@Parameter(description = "?????? ???????????? ??????") @PathVariable("toItgCustNo") String toItgCustNo,
			@Parameter(description = "????????????") @PathVariable("coupnPblsBasNo") String coupnPblsBasNo) throws Exception {
		CrmCouponVo ret = service.saveGiftCoupn(coupnPblsBasNo, fromItgCustNo, toItgCustNo);
		if (ret == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

}
