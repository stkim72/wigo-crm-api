package com.ceragem.api.crm.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmPointHstSo;
import com.ceragem.api.crm.model.CrmPointHstVo;
import com.ceragem.api.crm.model.CrmPointInfoVo;
import com.ceragem.api.crm.model.CrmPointVo;
import com.ceragem.api.crm.service.CrmCustService;
import com.ceragem.api.crm.service.CrmPointHstService;
import com.ceragem.api.crm.validate.CodeValue;
import com.ceragem.api.crm.validate.MaxByte;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName CrmPointHstController
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM포인트이력 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "CRM멤버십포인트", description = "CRM멤버십 API")
@Validated
@RestController
@RequestMapping("/crm/v1.0/point")
public class CrmPointHstController extends BaseRestController {

	@Autowired
	CrmPointHstService service;
	
	@Autowired
	CrmCustService custService;

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM포인트이력 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "CRM포인트 검색", description = "CRM포인트 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmPointHstVo>>> getCrmCustBasList(
			@Parameter(description = "CRM포인트이력 검색객체") @ParameterObject @Valid CrmPointHstSo so) throws Exception {
		EzMap param = new EzMap(so);
		List<CrmPointHstVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM포인트 검색
	 *
	 */
	@GetMapping("info/{itgCustNo}")
	@Operation(summary = "CRM 회원 포인트 정보", description = "CRM 회원 포인트 정보")
	public ResponseEntity<ApiResultVo<CrmPointInfoVo>> getCrmCustBasList(
			@Parameter(description = "통합회원번호") @PathVariable("itgCustNo") String itgCustNo) throws Exception {
		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(itgCustNo);
		CrmPointInfoVo info = service.getPointInfo(vo);
		return successResponse(info);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM포인트이력단건 검색
	 *
	 */
	@GetMapping("/{pointHstSeq}")
	@Operation(summary = "CRM포인트이력 단건", description = "CRM포인트이력 단건 검색")
	public ResponseEntity<ApiResultVo<CrmPointHstVo>> getCrmPointHst(
			@Parameter(description = "포인트이력일련번호") @PathVariable("pointHstSeq") String pointHstSeq) throws Exception {
		CrmPointHstSo so = new CrmPointHstSo();
		so.setPointHstSeq(pointHstSeq);
		CrmPointHstVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description CRM포인트이력단건 검색
	 *
	 */
	@GetMapping("/{pblsChlCd}/{chitNo}")
	@Operation(summary = "CRM 전표별 포인트 적립/사용 조회", description = "CRM 전표별 포인트 적립/사용 조회")
	public ResponseEntity<ApiResultVo<List<CrmPointHstVo>>> getCrmPointHst(
			@Parameter(description = "포인트 적립/사용 채널") @PathVariable("pblsChlCd") String pblsChlCd,
			@Parameter(description = "채널별 적립시 사용한 전표번호 또는 고유번호") @PathVariable("chitNo") String chitNo,
			@Parameter(description = "사용유형코드 [001 : 사용 , 002 : 적립 , 003 : 취소]", required = false) @RequestParam(value = "useTypeCd", required = false) String useTypeCd)
			throws Exception {
		CrmPointHstSo so = new CrmPointHstSo();
		so.setChitNo(chitNo);
		so.setPblsChlCd(pblsChlCd);
		so.setUseTypeCd(useTypeCd);
		List<CrmPointHstVo> list = service.getPointList(so);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM포인트이력 적립
	 *
	 */
	@PostMapping("deposit/{pblsChlCd}/{chitNo}")
	@Operation(summary = "CRM포인트 적립", description = "CRM포인트 적립")
	public ResponseEntity<ApiResultVo<CrmPointInfoVo>> deposit(
			@Parameter(description = "포인트 적립 채널") @PathVariable("pblsChlCd") String pblsChlCd,
			@Parameter(description = "채널별 적립시 사용한 전표번호 또는 고유번호") @PathVariable("chitNo") String chitNo,
			@Parameter(description = "CRM포인트이력 객체") @RequestBody @Valid CrmPointHstVo vo) throws Exception {
		vo.setChitNo(chitNo);
		vo.setPblsChlCd(pblsChlCd);

		CrmPointInfoVo ret = service.saveDeposit(vo);
		if (ret == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM포인트이력 사용
	 *
	 */
	@PostMapping("deposit-amt/{pblsChlCd}/{chitNo}")
	@Operation(summary = "CRM포인트 구매내역으로 포인트 적립", description = "CRM포인트 구매내역으로 포인트 적립")
	public ResponseEntity<ApiResultVo<CrmPointInfoVo>> depositAmt(
			@Parameter(description = "포인트 사용 채널") @PathVariable("pblsChlCd") String pblsChlCd,
			@Parameter(description = "채널별 사용시 사용한 전표번호 또는 고유번호") @PathVariable("chitNo") String chitNo,
			@Parameter(description = "CRM포인트 객체") @RequestBody @Valid CrmPointVo vo) throws Exception {
		vo.setChitNo(chitNo);
		vo.setPblsChlCd(pblsChlCd);

		// 일반회원 일 경우 정책 없으므로 에러
//		if ( "001".equals( vo.getUseTypeCd() ) ) {
//			throw new EzApiException( Constants._API_CODE_NO_USETYPE ,   Constants._API_CODE_NO_USETYPE_MSG );
//		}
		
		
		CrmCustVo cVo = new CrmCustVo();
		cVo.setItgCustNo( vo.getItgCustNo() );
	
		
		// 010, 020, 030, "901" 일 경우 무조건 추천 히스토리 작성
		CrmCustVo custVo = custService.get(cVo);	
		
		if (custVo == null || Constants._USER_STATUS_DELETE.equals(custVo.getCustStatusCd()))
			throw new EzApiException(Constants._API_CODE_NO_USER,
					"[" + vo.getItgCustNo() + "] " + Constants._API_CODE_NO_USER_MSG);
		
		
		String[] rcmdEventCd = { "010", "020", "030", "901"};
		if (Arrays.asList(rcmdEventCd).contains(vo.getPblsDivCd()) &&  !"".equals( vo.getRcmdrCustNo()) &&vo.getRcmdrCustNo() != null ) {	
			
			// 강제로 추천인 맵핑 처리
				custVo.setRcmdrCustNo( vo.getRcmdrCustNo() );
				custVo.setOrgItgCustNo( vo.getItgCustNo() );
			
			// 2022-09-27 
			// 구매추천은 구매가 이루어진 건에 대해서만 추천이력을 남긴다.
			// 그래서 무조건 저장하던 걸 주석처리 함
			//custService.saveRcmdHst(custVo);			
					
		}
		
		CrmPointInfoVo ret = service.savePosPoint(vo);
		if (ret == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM포인트이력 사용
	 *
	 */
	@PostMapping("approve/{pblsChlCd}/{chitNo}")
	@Operation(summary = "CRM포인트 전표별 승인 적립/사용", description = "CRM포인트 전표별 승인 적립/사용")
	public ResponseEntity<ApiResultVo<CrmPointInfoVo>> approve(
			@Parameter(description = "포인트 사용 채널") @PathVariable("pblsChlCd") String pblsChlCd,
			@Parameter(description = "채널별 사용시 사용한 전표번호 또는 고유번호") @PathVariable("chitNo") String chitNo,
			@Parameter(description = "CRM포인트") @RequestBody @Valid List<CrmPointVo> list) throws Exception {

		CrmPointInfoVo ret = service.saveApprove(pblsChlCd, chitNo, list);
		if (ret == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM포인트이력 사용
	 *
	 */
	@PostMapping("withdrawal/{pblsChlCd}/{chitNo}")
	@Operation(summary = "CRM포인트 사용", description = "CRM포인트 사용")
	public ResponseEntity<ApiResultVo<CrmPointInfoVo>> withdrawal(
			@Parameter(description = "포인트 사용 채널") @PathVariable("pblsChlCd") String pblsChlCd,
			@Parameter(description = "채널별 사용시 사용한 전표번호 또는 고유번호") @PathVariable("chitNo") String chitNo,
			@Parameter(description = "CRM포인트이력 객체") @RequestBody @Valid CrmPointHstVo vo) throws Exception {
		vo.setChitNo(chitNo);
		vo.setPblsChlCd(pblsChlCd);
		if(Utilities.isEmpty(vo.getPblsDivCd()))
			vo.setPblsDivCd("901");
		Utilities.validate(vo);
		CrmPointInfoVo ret = service.saveWithdrawal(vo);
		if (ret == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM포인트 적립 취소
	 *
	 */
	@PostMapping("cancel/{pblsChlCd}/{chitNo}")
	@Operation(summary = "CRM포인트 적립/사용 취소", description = "CRM포인트 적립/사용 취소")
	public ResponseEntity<ApiResultVo<CrmPointInfoVo>> cancelDeposit(
			@Parameter(description = "포인트 적립용 채널") @PathVariable("pblsChlCd") @CodeValue(codeId = "S000") String pblsChlCd,
			@Parameter(description = "채널별 적립시 사용한 전표번호 또는 고유번호") @PathVariable("chitNo") @MaxByte(max = 30) String chitNo)
			throws Exception {
		CrmPointHstVo vo = new CrmPointHstVo();

		vo.setChitNo(chitNo);
		vo.setPblsChlCd(pblsChlCd);
		

		// 22.09.29 추가
		// 승급점수 취소 - 처리
		// 포인트 유무와 상관없이 처리
		service.cancelAdvnCmt(vo);
		
		
		CrmPointInfoVo ret = service.saveCancel(vo);
		if (ret == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM포인트 선물
	 *
	 */
	@PostMapping("gift/{fromItgCustNo}/{toItgCustNo}")
	@Operation(summary = "CRM포인트 선물", description = "CRM포인트 선물")
	public ResponseEntity<ApiResultVo<CrmPointInfoVo>> gift(
			@Parameter(description = "보내는 통합회원 번호") @PathVariable("fromItgCustNo") String fromItgCustNo,
			@Parameter(description = "받는 통합회원 번호") @PathVariable("toItgCustNo") String toItgCustNo,
			@Parameter(description = "CRM포인트 객체") @RequestBody @Valid CrmPointHstVo vo) throws Exception {
		CrmPointInfoVo ret = service.saveGiftPoint(vo, fromItgCustNo, toItgCustNo);
		if (ret == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(ret);
	}

	/**
	 *
	 * @author 김성태
	 * @date 2022. 4. 21.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM포인트 선물
	 *
	 */
	@PostMapping("gift-cancel/{fromItgCustNo}/{toItgCustNo}")
	@Operation(summary = "CRM포인트 선물 취소", description = "CRM포인트 선물 취소", hidden = true)
	public ResponseEntity<ApiResultVo<CrmPointHstVo>> cancelGift(
			@Parameter(description = "포인트 사용 채널") @PathVariable("pblsChlCd") String pblsChlCd,
			@Parameter(description = "채널별 사용시 사용한 전표번호 또는 고유번호") @PathVariable("chitNo") String chitNo,
			@Parameter(description = "CRM포인트이력 객체") @RequestBody @Valid CrmPointHstVo vo) throws Exception {
//		int ret = service.update(vo);
//		if (ret == 0)
//			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

}
