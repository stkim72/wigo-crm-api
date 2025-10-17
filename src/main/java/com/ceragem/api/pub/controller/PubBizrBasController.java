package com.ceragem.api.pub.controller;

import java.util.List;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmFileVo;
import com.ceragem.api.pub.model.PubBizrBasSo;
import com.ceragem.api.pub.model.PubBizrBasSo2;
import com.ceragem.api.pub.model.PubBizrBasVo;
import com.ceragem.api.pub.service.PubBizrBasService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @ClassName PubBusinessBasController
 * @author user
 * @date 2023. 5. 7.
 * @Version 1.0
 * @description 공유사업자 기본정보 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Tag(name = "공유사업자 기본정보", description = "공유사업자 기본정보 API")
@RestController
@RequestMapping("/pub/v1.0/pub-business-bas")
public class PubBizrBasController extends BaseRestController {

	@Autowired
	PubBizrBasService service;

	/**
	 *
	 * @author user
	 * @date 2023. 5. 7.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 공유사업자 기본정보 검색
	 *
	 */
	@GetMapping("list")
	@Operation(summary = "공유사업자 기본정보 검색", description = "공유사업자 기본정보 검색")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<PubBizrBasVo>>> getCrmCustBasList(
			@Parameter(description = "공유사업자 기본정보 검색객체") @ParameterObject @Valid PubBizrBasSo so) throws Exception {
		EzMap param = new EzMap(so);
		List<PubBizrBasVo> list = service.getList(param);
		int cnt = service.getListCount(param);
		so.setTotalRecordCount(cnt);
		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author user
	 * @date 2023. 5. 7.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description 공유사업자 기본정보단건 검색
	 *
	 */
	@GetMapping("/{word}")
	@Operation(summary = "공유사업자 기본정보 단건", description = "공유사업자 기본정보 단건 검색")
	public ResponseEntity<ApiResultVo<PubBizrBasVo>> getPubBusinessBas(
			@Parameter(description = "검색데이터(공유사업자ID, 전화번호, 사업자번호 중 택1)") @PathVariable("word") String word)
			throws Exception {
		PubBizrBasSo so = new PubBizrBasSo();
		// so.setPubBizrBasNo(PubBizrBasNo);
		so.setSearchWord(word);
		PubBizrBasVo vo = service.get(so);
		if (vo == null)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(vo);
	}

	/**
	 *
	 * @author user
	 * @date 2023. 5. 7.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 공유사업자 기본정보 입력
	 *
	 */
	@PostMapping("")
	@Operation(summary = "공유사업자 기본정보 입력", description = "공유사업자 기본정보 입력")
	public ResponseEntity<ApiResultVo<PubBizrBasVo>> registerPubBusinessBas(
			@Parameter(description = "공유사업자 기본정보 객체") @RequestBody @Valid PubBizrBasVo vo) throws Exception {

		PubBizrBasVo pubBizrBasVo = new PubBizrBasVo();

		// 사업자번호 중복 검색
		pubBizrBasVo.setId(null);
		pubBizrBasVo.setMphonNo(null);
		pubBizrBasVo.setBizrNo(vo.getBizrNo());
		PubBizrBasVo pubInfo = service.get(pubBizrBasVo);

		if (pubInfo != null) {
			throw new EzApiException(Constants._API_PUB_BIZNO_EXIST, Constants._API_PUB_BIZNO_EXIST_MSG);
		}

		// 아이디 중복 검색
		pubBizrBasVo.setId(vo.getId());
		pubBizrBasVo.setMphonNo(null);
		pubBizrBasVo.setBizrNo(null);
		pubInfo = service.get(pubBizrBasVo);

		if (pubInfo != null) {
			throw new EzApiException(Constants._API_PUB_ID_EXIST, Constants._API_PUB_ID_EXIST_MSG);
		}

		// 전화번호 중복 검색
		pubBizrBasVo.setId(null);
		pubBizrBasVo.setMphonNo(vo.getMphonNo());
		pubBizrBasVo.setBizrNo(null);
		pubInfo = service.get(pubBizrBasVo);
		if (pubInfo != null) {
			throw new EzApiException(Constants._API_PUB_MPHON_EXIST, Constants._API_PUB_MPHON_EXIST_MSG);
		}

		// 비밀번호 뒷 4자리
		String newPass = vo.getMphonNo().substring(vo.getMphonNo().length() - 4);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		vo.setPwd(encoder.encode(newPass));

		int ret = service.insert(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author user
	 * @date 2023. 5. 7.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 공유사업자 기본정보 수정
	 *
	 */
	@PutMapping("")
	@Operation(summary = "공유사업자 기본정보 수정", description = "공유사업자 기본정보 수정")
	public ResponseEntity<ApiResultVo<PubBizrBasVo>> modifyPubBusinessBas(
			@Parameter(description = "공유사업자 기본정보 객체") @RequestBody @Valid PubBizrBasVo vo) throws Exception {
		int ret = service.update(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author user
	 * @date 2023. 5. 7.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 공유사업자 비밀번호 초기화
	 *
	 */
	@GetMapping("/{id}/{mphonNo}")
	@Operation(summary = "공유사업자 비밀번호 초기화", description = "공유사업자 비밀번호 초기화")
	public ResponseEntity<ApiResultVo<PubBizrBasVo>> resetPassword(
			@Parameter(description = "공유사업자계정") @PathVariable("id") String id,
			@Parameter(description = "휴대폰번호") @PathVariable("mphonNo") String mphonNo) throws Exception {

		PubBizrBasVo vo = new PubBizrBasVo();
		vo.setId(id);
		vo.setMphonNo(mphonNo);

		// 휴대폰 4자리로 초기화
		PubBizrBasVo rtnInfo = service.get(vo);
		if (rtnInfo != null && !"".equals(rtnInfo.getId())) {

			String newPass = mphonNo.substring(mphonNo.length() - 4);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			vo.setPwd(encoder.encode(newPass));

			int ret = service.update(vo);
			if (ret == 0)
				throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		} else {
			throw new EzApiException(Constants._API_PUB_NO_DATA, Constants._API_PUB_NO_DATA_MSG);
		}
		return successResponse(service.get(vo));
	}

	/**
	 *
	 * @author user
	 * @date 2023. 5. 7.
	 * @param id
	 * @return
	 * @throws Exception
	 * @description 공유사업자 기본정보 삭제
	 *
	 */
	@DeleteMapping("/{id}")
	@Operation(summary = "공유사업자 기본정보 탈퇴", description = "공유사업자 기본정보 탈퇴")
	public ResponseEntity<ApiResultVo<Object>> removePubBusinessBas(
			@Parameter(description = "공유사업자계정") @PathVariable("id") String id) throws Exception {
		PubBizrBasVo vo = new PubBizrBasVo();
		vo.setId(id);
		// int ret = service.delete(vo);
		vo.setStatusCd("005"); // 공통코드 PB010 (001 정상 005 탈퇴)
		int ret = service.update(vo);
		if (ret == 0)
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(null);
	}

	/**
	 *
	 * @author user
	 * @date 2023. 5. 7.
	 * @param so
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 공유사업자 유치고객 조회
	 *
	 */
	@GetMapping("list/cust")
	@Operation(summary = "공유사업자 유치고객 조회", description = "공유사업자 유치고객 조회")
	public ResponseEntity<ApiResultVo<ApiPagingPayload<CrmCustVo>>> getPubCustBasList(
			@Parameter(description = "공유사업자 유치고객 조회") @ParameterObject @Valid PubBizrBasSo2 so) throws Exception {

		EzMap param = new EzMap(so);
		List<CrmCustVo> list = service.getCustList(param);
		int cnt = service.getCustListCount(param);
		so.setTotalRecordCount(cnt);

		if (Utilities.isEmpty(list))
			throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
		return successResponse(list, so);
	}

	/**
	 *
	 * @author user
	 * @date 2023. 5. 7.
	 * @param vo
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 공유사업자 비밀번호 초기화
	 *
	 */
	@GetMapping("/pubmap")
	@Operation(summary = "공유사업자 유치고객 등록", description = "공유사업자 유치고객 등록")
	public ResponseEntity<ApiResultVo<PubBizrBasSo2>> savePubMap(
			@Parameter(description = "공유사업자계정") @RequestParam("id") String id,
			@Parameter(description = "통합고객번호") @RequestParam("itgCustNo") String itgCustNo,
			@Parameter(description = "웰라운지") @RequestParam("WellloungeCd") String WellloungeCd) throws Exception {

		PubBizrBasSo so = new PubBizrBasSo();
		so.setId(id);
		PubBizrBasVo vo = service.get(so);

		// 공유 사업자 체크
		if (vo == null) {
			throw new EzApiException(Constants._API_PUB_NO_DATA, Constants._API_PUB_NO_DATA_MSG);
		}

		// 회원 체크
		EzMap param = new EzMap();
		param.put("itgCustNo", itgCustNo);
		PubBizrBasSo2 custVo = service.selectChkPub(param);
		if (custVo == null) {
			throw new EzApiException(Constants._API_CODE_NO_USER, Constants._API_CODE_NO_USER_MSG);
		}

		// 이미 공유 사업자에 가입되어 있음
		if (!"".equals(custVo.getPubBizrBasNo()) && custVo.getPubBizrBasNo() != null) {
			throw new EzApiException(Constants._API_PUB_NO_CUST_EXIST, Constants._API_PUB_NO_CUST_EXIST_MSG);
		}

		// 웰라운지 코드 체크
		// if ("".equals(WellloungeCd) || WellloungeCd == null) {
		// throw new EzApiException(Constants._API_PUB_NO_WELL_EXIST,
		// Constants._API_PUB_NO_WELL_EXIST_MSG);
		// }

		PubBizrBasSo2 insVo = new PubBizrBasSo2();
		insVo.setItgCustNo(custVo.getItgCustNo());
		insVo.setPubBizrBasNo(vo.getPubBizrBasNo());
		// insVo.setWellloungeCd(WellloungeCd);
		insVo.setRegrId("PUB");

		int ret = service.insertPubMem(insVo);
		if (ret == 0)
			throw new EzApiException(Constants._API_PUB_NO_CUST_INSERT, Constants._API_PUB_NO_CUST_INSERT_MSG);

		return successResponse(insVo);
	}

	@PostMapping(value = "upload-image/{pubBizrBasNo}/{type}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	@RequestMapping(path = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "공유사업자 첨부파일 업로드", description = "공유사업자 첨부파일 업로드")
	public @ResponseBody ResponseEntity<ApiResultVo<CrmFileVo>> uploadFile(
			@Parameter(description = "업로드파일") @RequestPart("file") MultipartFile uploadfile,
			@Parameter(description = "공유사업자번호") @PathVariable("pubBizrBasNo") String pubBizrBasNo,
			@Parameter(description = "업로드유형 001:사업자등록증, 002:통장사본") @PathVariable("type") String type) throws Exception {
		EzMap param = new EzMap();
		param.setString("pubBizrBasNo", pubBizrBasNo);
		param.setString("type", type);
		CrmFileVo fileVo = service.uploadFile(uploadfile, param);
		return successResponse(fileVo);
	}
}
