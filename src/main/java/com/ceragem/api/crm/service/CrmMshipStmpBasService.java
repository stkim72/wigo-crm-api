package com.ceragem.api.crm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmMshipStmpBasDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCouponVo;
import com.ceragem.api.crm.model.CrmMshipStmpAccumGodsVo;
import com.ceragem.api.crm.model.CrmMshipStmpAccumVo;
import com.ceragem.api.crm.model.CrmMshipStmpEventVo;
import com.ceragem.api.crm.model.CrmMshipStmpIssueVo;
import com.ceragem.api.crm.model.CrmPointHstVo;
import com.ceragem.api.crm.model.CrmPointInfoVo;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

/**
 *
 * @ClassName CrmMshipStmpBasService
 * @author user
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM멤버십스탬프기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipStmpBasService extends AbstractCrmService {
	@Autowired
	CrmMshipStmpBasDao dao;
	@Autowired
	CrmCouponService cpnService;
	@Autowired
	CrmPointHstService poiService;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	@SuppressWarnings("unchecked")
	public List<CrmMshipStmpIssueVo> accumlStmp(@Valid CrmMshipStmpAccumVo vo) throws Exception {

		List<CrmMshipStmpIssueVo> resultData = new ArrayList<CrmMshipStmpIssueVo>();

		// 매장 존재 여부
		if (vo.getStorNo() == null || vo.getStorNo().isEmpty()) {
			throw new EzApiException(Constants._API_STOR_NO_DATA, Constants._API_STOR_NO_DATA_MSG);
		}

		int storCnt = dao.checkStoreCnt(vo.getStorNo());
		if (storCnt == 0) {
			throw new EzApiException(Constants._API_STOR_CNT_NO_DATA, Constants._API_STOR_CNT_NO_DATA_MSG);
		}

		// 채널 존재 여부
		if (vo.getChlCd() == null || vo.getChlCd().isEmpty()) {
			throw new EzApiException(Constants._API_CHL_NO_DATA, Constants._API_CHL_NO_DATA_MSG);
		}

		int chlCnt = dao.checkChlCnt(vo.getChlCd());
		if (chlCnt == 0) {
			throw new EzApiException(Constants._API_CHL_CNT_NO_DATA, Constants._API_CHL_CNT_NO_DATA_MSG);
		}

		// 회원 존재 여부
		if (vo.getItgCustNo() == null || vo.getItgCustNo().isEmpty()) {
			throw new EzApiException(Constants._API_CUST_NO_DATA, Constants._API_CUST_NO_DATA_MSG);
		}

		int memCnt = dao.checkMemberCnt(vo.getItgCustNo());
		if (memCnt == 0) {
			throw new EzApiException(Constants._API_CUST_CNT_NO_DATA, Constants._API_CUST_CNT_NO_DATA_MSG);
		}

		if (vo.getChitNo() == null || vo.getChitNo().isEmpty()) {
			throw new EzApiException(Constants._API_CHIT_NO_DATA, Constants._API_CHIT_NO_DATA_MSG);
		}

		// 전표번호 중복체크
		int chitNoCheck = dao.checkChitNoCheck(vo.getChitNo());
		if (chitNoCheck > 0) {
			throw new EzApiException(Constants._API_CHIT_CNT_NO_DATA, Constants._API_CHIT_CNT_NO_DATA_MSG);
		}

		// 등급체크
		if (vo.getMshpGradeCd() == null || vo.getMshpGradeCd().isEmpty()) {
			throw new EzApiException(Constants._API_MSHP_CD_NO_DATA, Constants._API_MSHP_CD_NO_DATA_MSG);
		}

		// 회원구분
		if (vo.getMshipTypeCd() == null || vo.getMshipTypeCd().isEmpty()) {
			throw new EzApiException(Constants._API_MSHP_TYPE_NO_DATA, Constants._API_MSHP_TYPE_NO_DATA_MSG);
		}

		// 적립 예외 상품 제외하기
		List<CrmMshipStmpAccumGodsVo> itemList = vo.getItemList();
		if (itemList.size() < 1) {
			throw new EzApiException(Constants._API_GODS_NO_DATA, Constants._API_GODS_NO_DATA_MSG);
		}

		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getApplyYn().equals("Y")) {
				itemList.remove(i);
			}

			if (Utilities.isEmpty(itemList.get(i).getApplyQnty()) || itemList.get(i).getApplyQnty() == 0) {
				itemList.remove(i);
			}
		}

		if (itemList.size() < 1) {
			throw new EzApiException(Constants._API_GODS_NO_DATA, Constants._API_GODS_NO_DATA_MSG);
		}

		// 상품 중복 문제 동일한 적립 가능한 상품 1개이상일 경우

		/**
		 * @스탬프 마스터 데이터 셋팅 상품,매장,채널 기준으로 스탬프 마스터 조회
		 * @조회된 마스터 유호기간,판수제한,최소금액 기준으로 제외
		 * @해당마스터에 상품 리스트 , 주문상품 정보 결합
		 */
		List<EzMap> stmpInfoList = stmpInitData(vo, itemList);

		if (Utilities.isEmpty(stmpInfoList) || stmpInfoList.size() == 0) {
			throw new EzApiException(Constants._API_STMP_NO_DATA, Constants._API_STMP_NO_DATA_MSG);
		}

		/**
		 * @체크로직
		 */
		List<String> mshipStmpBasNos = new ArrayList<String>();
		for (int i = 0; i < stmpInfoList.size(); i++) {

			String coupnAccumDcYn = String.valueOf(stmpInfoList.get(i).get("coupnAccumDcYn"));

			List<EzMap> dataGodsList = (List<EzMap>) stmpInfoList.get(i).get("itemList");
//			List<CrmMshipStmpAccumGodsVo> ordrGodsList = null;
//			ordrGodsList = (List<CrmMshipStmpAccumGodsVo>) stmpInfoList.get(i).get("ordrGods");
			for (int j = 0; j < dataGodsList.size(); j++) {

				// 주문별 쿠폰적용 체크
				if (coupnAccumDcYn.equals("N") && dataGodsList.get(j).get("coupnYn").equals("Y")) {
					continue;
				}

				long condAmt = Utilities.parseLong(stmpInfoList.get(i).get("condAmt"));
				long payAmt = Utilities.parseLong(dataGodsList.get(j).get("payAmt")); 

				// 주문금액이 설정 최소 금액보다 적을경우
				if (condAmt > payAmt) {
					continue;
				}

				// 상품별 스탬프 적립수 기준
				/*
				 * 20220719 수정 : 주문수량 체크
				 */
				int applyQnty = Utilities.parseInt(dataGodsList.get(j).get("applyQnty"));
//				long itemCnt = Long.parseLong(String.valueOf(dataGodsList.get(j).get("itemAccumCnt"))) * applyQnty;
				// 적립회수 마스터에 추가함
				int condCnt = 1;
				if (stmpInfoList.get(i).get("condCnt") != null) {
					condCnt = Utilities.parseInt(stmpInfoList.get(i).getInt("condCnt"));
				}
				
				long itemCnt = Utilities.parseLong((condCnt)) * applyQnty;
				if (itemCnt == 0) {
					continue;
				}

//				long itemCnt = Long.parseLong(String.valueOf(dataGodsList.get(j).get("itemAccumCnt")));
//				long accumCnt = Long.parseLong(String.valueOf(stmpInfoList.get(i).get("accumCnt")));
//
//				// 적립최대 스탬프 개수 가 상품설정 개수보다 클경우
//				if (itemCnt > accumCnt) {
//					continue;
//				}

				for (int m = 0; m < itemCnt; m++) {

					// 스탬프 적립 수량 조회
					EzMap hisPrm = new EzMap();
					hisPrm.put("mshipStmpBasNo", stmpInfoList.get(i).get("mshipStmpBasNo"));
					hisPrm.put("itgCustNo", vo.getItgCustNo());
					int totHisStmp = dao.getStmpTotalHist(hisPrm);

					// 판수에 찍힌 스탬프 보다 많을경우
					if (stmpInfoList.get(i).get("stmpMaxYn").equals("N")) {
						long maxCnt = Utilities.parseLong(stmpInfoList.get(i).get("stmpMaxCnt"))
								* Utilities.parseLong(stmpInfoList.get(i).get("stmpQnty"));
						if (totHisStmp >= maxCnt) {
							continue;
						}
					}

					// 적립
					EzMap inHisPrm = new EzMap();
					inHisPrm.put("mshipStmpBasNo", stmpInfoList.get(i).get("mshipStmpBasNo")); // 스탬프 번호
					inHisPrm.put("itgCustNo", vo.getItgCustNo()); // 회원 통합번호
					inHisPrm.put("mshipGradeCd", vo.getMshipGradeCd()); // 회원 등급
					inHisPrm.put("storNo", vo.getStorNo()); // 매장 코드
					inHisPrm.put("stmpBasNm", stmpInfoList.get(i).get("stmpBasNm")); // 스탬프 명
					inHisPrm.put("fromUsePossDt", stmpInfoList.get(i).get("fromUsePossDt")); // from 사용가능
					inHisPrm.put("toUsePossDt", stmpInfoList.get(i).get("toUsePossDt")); // to 사용 가능
					inHisPrm.put("buyGodsNo", stmpInfoList.get(i).get("godsNo")); // 제품번호
					inHisPrm.put("ordrAmt", stmpInfoList.get(i).get("ordrAmt")); // 주문금액
					inHisPrm.put("payAmt", stmpInfoList.get(i).get("payAmt")); // 결제금액
					inHisPrm.put("payChlCd", vo.getChlCd()); // 결제채널
					inHisPrm.put("chitNo", vo.getChitNo()); // 전표번호

					String hstSeq = dao.getStmpHisSeq(inHisPrm);
					EzMap seqInfo = new EzMap();

					int stmpCnt = 0;
					int issueCnt = 0;
					if (hstSeq != null) {
						seqInfo = dao.getStmpMaxSeq(hstSeq);
						stmpCnt = Utilities.parseInt(seqInfo.get("stmpAccumQnty"));
						issueCnt = Utilities.parseInt(seqInfo.get("issueCnt"));
					}

					long stmpQnty = Utilities.parseLong(stmpInfoList.get(i).get("stmpQnty"));
					if (stmpCnt == stmpQnty) {
						stmpCnt = 0;
						issueCnt += 1;
					}

					// 쿠폰 , 포인트 적립
					if ((stmpCnt + 1) == stmpQnty) {

						// 쿠폰 마스터 정보로 쿠폰 발급연동 MCP22051315382955708 쿠폰 마스터
						// 쿠폰,포인트 전송
						if (stmpInfoList.get(i).get("bnfitCd").equals("001")) { // 포인트

							CrmPointHstVo poiVo = new CrmPointHstVo();
							// poiVo.setChitNo(vo.getChitNo());		// 수기 전표
							poiVo.setItgCustNo(vo.getItgCustNo()); // CST22042618203144252
							// poiVo.setPblsChlCd(vo.getChlCd());
							poiVo.setPblsDivCd("903"); // 스탬프 구분코드

							// 유효기간 1년 으로 설정
							Calendar cal = Calendar.getInstance();
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
							//SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
							cal.setTime(new Date());
							String validPerdStaYmd = simpleDateFormat.format(cal.getTime());
							cal.add(Calendar.MONTH, 12);
							String validPerdEndYmd = simpleDateFormat.format(cal.getTime());
							//String extncDt = simpleDateFormat1.format(cal.getTime());
							//poiVo.setExtncDt(extncDt); // 2022/06/15 오전 10:05:31
							poiVo.setValidPerdStaYmd(validPerdStaYmd); // 20220608
							poiVo.setValidPerdEndYmd(validPerdEndYmd); // 20240608

							poiVo.setChitNo(Utilities.getAutoSeq("CHT"));	// 전표중복 방지
							
							poiVo.setOccurPointScore(
									Utilities.parseInt(stmpInfoList.get(i).get("pointScore")));
							CrmPointInfoVo ret = poiService.saveDeposit(poiVo);
							if (ret == null) {
//								throw new EzApiException(Constants._API_POINT_NO_DATA,
//										Constants._API_POINT_NO_DATA_MSG);
								continue;
								// 에러시 다음 적립처리
							}
							inHisPrm.put("pointScore", stmpInfoList.get(i).get("pointScore"));

						} else if (stmpInfoList.get(i).get("bnfitCd").equals("002")) { // 쿠폰
							CrmCouponVo cpVo = new CrmCouponVo();
							cpVo.setMshipCoupnBasNo(String.valueOf(stmpInfoList.get(i).get("coupnNo")));
							cpVo.setItgCustNo(vo.getItgCustNo());
							cpVo.setChitNo(hstSeq);
							CrmCouponVo ret2 = cpnService.insertIssueTem(cpVo); // 스탬프 쿠폰발행 임시
							if (ret2 == null) {
//								throw new EzApiException(Constants._API_COUPN_NO_DATA,
//										Constants._API_COUPN_NO_DATA_MSG);
								continue;
								// 에러시 다음적립 처리 > 에러메세지 출력시 끓김
							}
							// 쿠폰 발급된 번호
							inHisPrm.put("coupnNo", ret2.getCoupnPblsBasNo());
						}
					}

					mshipStmpBasNos.add(String.valueOf(stmpInfoList.get(i).get("mshipStmpBasNo")));

					inHisPrm.put("stmpAccumQnty", (stmpCnt + 1)); // 스탬프수량
					inHisPrm.put("issueCnt", issueCnt); // 스탬프수량
					dao.insertStmpHis(inHisPrm);
				}

			}

		}

		// 중복제거
		List<String> mshipStmpBasNos2 = new ArrayList<String>();
		for (int j = 0; j < mshipStmpBasNos.size(); j++) {
			if (!mshipStmpBasNos2.contains(mshipStmpBasNos.get(j))) {
				mshipStmpBasNos2.add(mshipStmpBasNos.get(j));
			}
		}
		
		if (mshipStmpBasNos2.size() > 0) {
			EzMap resultParm = new EzMap();
			resultParm.put("mshipStmpBasNo", mshipStmpBasNos2);
			resultParm.put("itgCustNo", vo.getItgCustNo());
			resultData = dao.getStmpIssueList(resultParm);
		}

		return resultData;
	}

//	@SuppressWarnings("unchecked")
	private List<EzMap> stmpInitData(@Valid CrmMshipStmpAccumVo vo, List<CrmMshipStmpAccumGodsVo> itemList) {

		List<String> godsNos = new ArrayList<>();
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getApplyQnty() > 0) {
				godsNos.add(itemList.get(i).getBuyGodsNo());
			}
		}

		// 매장코드,채널코드,상품코드 스탬프 마스터 조회
		EzMap parm = new EzMap(vo);
		parm.put("itemList", godsNos);
		List<String> stmpMarstList = dao.getStmpMarstList(parm); // 상품별 그룹

		if (Utilities.isEmpty(stmpMarstList) || stmpMarstList.size() == 0) {
			return null;
		}

		List<EzMap> cancelList = new ArrayList<EzMap>();

		// 스탬프 마스터번호로 스탬프 정보 받아옴
		EzMap infoPrm = new EzMap();
		infoPrm.put("stmpList", stmpMarstList);
		List<EzMap> stmpInfoList = dao.getStmpInfoList(infoPrm); // 마스터 코드, 상품으로 교차값 배열 2개

		stmpInfoList = checkList(cancelList, stmpInfoList);
		cancelList.removeAll(cancelList);

		// 발급일 체크
		for (int i = 0; i < stmpInfoList.size(); i++) {
			// 날짜 제외
			Date toUsePossDt = (Date) stmpInfoList.get(i).get("toUsePossDt");
			Date toDay = new Date();
			if (toUsePossDt.before(toDay)) {
				cancelList.add(stmpInfoList.get(i));
			}
		}

		// 회원 구분 선체크 1. 임직원 2. 제휴 3.등급
		///////////////////////////////////////////////////////
//		for (int i = 0; i < stmpInfoList.size(); i++) {
//			if (stmpInfoList.size() <= 0) {
//				return null;
//			}
//			String mshipTypeCd = String.valueOf(stmpInfoList.get(i).get("mshipTypeCds"));
//			if (!Utilities.isEmpty(mshipTypeCd)) {
//				if (!Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd()) || ) {
//					stmpInfoList.remove(i);
//				} 
//				
//			}
//		}

		stmpInfoList = checkList(cancelList, stmpInfoList);
		cancelList.removeAll(cancelList);

		for (int i = 0; i < stmpInfoList.size(); i++) {
			String mshipTypeCd = String.valueOf(stmpInfoList.get(i).get("mshipTypeCds"));
			String applyMshpGradeCtnts = String.valueOf(stmpInfoList.get(i).get("applyMshpGradeCtnts"));
//			if (!Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd())
//					&& !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//				if (vo.getMshipTypeCd().equals("002")
//						&& !String.valueOf(stmpInfoList.get(i).get("cprtCmpNo")).equals(vo.getCprtCmpNo())) { // 제휴사 시
//																												// 코드체크
//					return null;
//				}
//				cancelList.add(stmpInfoList.get(i));
//			} else if (!Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd())
//					&& !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//				cancelList.add(stmpInfoList.get(i));
//			}

			// 타입 동일 등급불일치 
			// 타입 불일치 등급 일치 
			// 타입 불일치 등급 불일치
			// 타입 동일 제휴사일경우 코드동일 
//			if (Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd()) ) {
//				if (vo.getMshipTypeCd().equals("002") && !String.valueOf(stmpInfoList.get(i).get("cprtCmpNo")).equals(vo.getCprtCmpNo())) {
//					cancelList.add(stmpInfoList.get(i));
//				}
//			} else if (!Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd())) {
//				
//			}
			
			// 003 회원 002 제휴 001 임직
			
//			if (vo.getMshipTypeCd().equals("003") && !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//				cancelList.add(stmpInfoList.get(i));
//			} else {
//				if (!Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd()) || !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//					cancelList.add(stmpInfoList.get(i));
//				} else if (vo.getMshipTypeCd().equals("002") ) {
//					if (Utilities.isEmpty(stmpInfoList.get(i).get("cprtCmpNo")) && !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//						cancelList.add(stmpInfoList.get(i));
//					} else if (Utilities.isNotEmpty(stmpInfoList.get(i).get("cprtCmpNo")) &&!String.valueOf(stmpInfoList.get(i).get("cprtCmpNo")).equals(vo.getCprtCmpNo())) {
//						cancelList.add(stmpInfoList.get(i));
//					}
//				}
//				
//			}
			// System.out.println(stmpInfoList.get(i).get("mshipStmpBasNo"));
			if (!Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
				if (vo.getMshipTypeCd().equals("001") && !Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd())) {
					cancelList.add(stmpInfoList.get(i));
				} else if (vo.getMshipTypeCd().equals("002") ) {
					if (Utilities.isEmpty(stmpInfoList.get(i).get("cprtCmpNo")))  {
						cancelList.add(stmpInfoList.get(i));
					} else if (Utilities.isNotEmpty(stmpInfoList.get(i).get("cprtCmpNo")) && !String.valueOf(stmpInfoList.get(i).get("cprtCmpNo")).equals(vo.getCprtCmpNo())) {
						cancelList.add(stmpInfoList.get(i));
					}
				} else if (vo.getMshipTypeCd().equals("003") ) {
					cancelList.add(stmpInfoList.get(i));
				}
			}
			
		}

		stmpInfoList = checkList(cancelList, stmpInfoList);
		cancelList.removeAll(cancelList);

		// 스탬프 마스터 체크 시작
		for (int i = 0; i < stmpInfoList.size(); i++) {
			// 유효기간 체크
			if (stmpInfoList.get(i).get("validYn").equals("Y")) {
				// 유효기간 있을시 마지막 적립 일자 로 부터 설정한 일수 초과 시 적립 불가
				Calendar getToday = Calendar.getInstance();
				getToday.setTime(new Date()); // 금일 날짜 validPerd

				EzMap lastDt = new EzMap();
				lastDt.put("mshipStmpBasNo", String.valueOf(stmpInfoList.get(i).get("mshipStmpBasNo")));
				lastDt.put("itgCustNo", vo.getItgCustNo());
				String seq = dao.getStmpHisSeq(lastDt);

				if (!Utilities.isEmpty(seq)) {
					EzMap last = dao.getStmpMaxSeq(seq);
					Date date = (Date) last.get("accumDt");
					Calendar cmpDate = Calendar.getInstance();
					cmpDate.setTime(date); // 특정 일자

					long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
					long diffDays = diffSec / (24 * 60 * 60); // 일자수 차이

					if (diffDays > Long.parseLong(String.valueOf(stmpInfoList.get(i).get("validPerd")))) {
						cancelList.add(stmpInfoList.get(i));
					}
				}

			}
		}

		stmpInfoList = checkList(cancelList, stmpInfoList);
		cancelList.removeAll(cancelList);

		// 판수제한
		for (int i = 0; i < stmpInfoList.size(); i++) {
			// 판수 제한 체크
			EzMap hisPrm = new EzMap();
			hisPrm.put("mshipStmpBasNo", stmpInfoList.get(i).get("mshipStmpBasNo"));
			hisPrm.put("itgCustNo", vo.getItgCustNo());
			int hisTotCnt = dao.getStmpTotalHist(hisPrm);

			Long totCnt = (long) 0;

			if (stmpInfoList.get(i).get("stmpMaxYn").equals("N")) {
				totCnt = Utilities.parseLong(stmpInfoList.get(i).get("stmpQnty"))
						* Utilities.parseLong(stmpInfoList.get(i).get("stmpMaxCnt"));

				if (hisTotCnt > totCnt) {
					cancelList.add(stmpInfoList.get(i));
				}
			}
		}

		stmpInfoList = checkList(cancelList, stmpInfoList);
		cancelList.removeAll(cancelList);

		// 최소금액 제한
		for (int i = 0; i < stmpInfoList.size(); i++) {
			if (stmpInfoList.size() <= 0) {
				return null;
			}
			// 판수 제한 체크
			if (stmpInfoList.get(i).get("condYn").equals("N")) {
				Long minAmt = Utilities.parseLong(stmpInfoList.get(i).get("condAmt"));
				if (vo.getTotAmt() < minAmt) {
					cancelList.add(stmpInfoList.get(i));
				}
			}
		}

		stmpInfoList = checkList(cancelList, stmpInfoList);
		cancelList.removeAll(cancelList);

		// 상품 조회 후 추가 >> 주문 수량 금액 쿠폰사용 합침
		for (int i = 0; i < stmpInfoList.size(); i++) {
			EzMap godsPrm = new EzMap();
			godsPrm.put("mshipStmpBasNo", stmpInfoList.get(i).get("mshipStmpBasNo"));
			godsPrm.put("itemList", itemList);
			List<EzMap> stmpGodsList = dao.getStmpGodsList(godsPrm);

			stmpInfoList.get(i).put("itemList", stmpGodsList);
		}

		return stmpInfoList;
	}

	@SuppressWarnings("unchecked")
	public List<CrmMshipStmpIssueVo> cancelStmp(@Valid CrmMshipStmpAccumVo vo) {

		List<CrmMshipStmpIssueVo> resultData = new ArrayList<CrmMshipStmpIssueVo>();

		// 매장 존재 여부
		if (vo.getStorNo() == null || vo.getStorNo().isEmpty()) {
			throw new EzApiException(Constants._API_STOR_NO_DATA, Constants._API_STOR_NO_DATA_MSG);
		}

		int storCnt = dao.checkStoreCnt(vo.getStorNo());
		if (storCnt == 0) {
			throw new EzApiException(Constants._API_STOR_CNT_NO_DATA, Constants._API_STOR_CNT_NO_DATA_MSG);
		}

		// 채널 존재 여부
		if (vo.getChlCd() == null || vo.getChlCd().isEmpty()) {
			throw new EzApiException(Constants._API_CHL_NO_DATA, Constants._API_CHL_NO_DATA_MSG);
		}

		int chlCnt = dao.checkChlCnt(vo.getChlCd());
		if (chlCnt == 0) {
			throw new EzApiException(Constants._API_CHL_CNT_NO_DATA, Constants._API_CHL_CNT_NO_DATA_MSG);
		}

		// 회원 존재 여부
		if (vo.getItgCustNo() == null || vo.getItgCustNo().isEmpty()) {
			throw new EzApiException(Constants._API_CUST_NO_DATA, Constants._API_CUST_NO_DATA_MSG);
		}

		int memCnt = dao.checkMemberCnt(vo.getItgCustNo());
		if (memCnt == 0) {
			throw new EzApiException(Constants._API_CUST_CNT_NO_DATA, Constants._API_CUST_CNT_NO_DATA_MSG);
		}

//		if (vo.getChitNo() == null || vo.getChitNo().isEmpty()) {
//			throw new EzApiException(Constants._API_CHIT_NO_DATA, Constants._API_CHIT_NO_DATA_MSG);
//		}

		// 적립 예외 상품 제외하기
		List<CrmMshipStmpAccumGodsVo> itemList = vo.getItemList();
		if (itemList.size() < 1) {
			throw new EzApiException(Constants._API_GODS_NO_DATA, Constants._API_GODS_NO_DATA_MSG);
		}

		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getApplyYn().equals("Y")) {
				itemList.remove(i);
			}

			if (Utilities.isEmpty(itemList.get(i).getApplyQnty()) || itemList.get(i).getApplyQnty() == 0) {
				itemList.remove(i);
			}
		}

		if (itemList.size() < 1) {
			throw new EzApiException(Constants._API_GODS_NO_DATA, Constants._API_GODS_NO_DATA_MSG);
		}

		for (int i = 0; i < itemList.size(); i++) {
			if (Utilities.isEmpty(itemList.get(i).getApplyQnty()) || itemList.get(i).getApplyQnty() == 0) {
				itemList.remove(i);
			}
		}

		if (itemList.size() < 1) {
			throw new EzApiException(Constants._API_GODS_NO_DATA, Constants._API_GODS_NO_DATA_MSG);
		}

		// 스탬프 마스터 코드 존재 여부
		List<String> checkGodsNos = new ArrayList<>();
		for (int i = 0; i < itemList.size(); i++) {
			checkGodsNos.add(itemList.get(i).getBuyGodsNo());
		}

		// 매장코드,채널코드,상품코드 스탬프 마스터 조회
		EzMap checkParm = new EzMap(vo);
		checkParm.put("itemList", checkGodsNos);
		List<String> stmpMarstList = dao.getStmpMarstList(checkParm);

		if (stmpMarstList == null || stmpMarstList.size() < 1) {
			throw new EzApiException(Constants._API_STMP_NO_DATA, Constants._API_STMP_NO_DATA_MSG);
		}

		// 취소 데이터 셋팅
		List<EzMap> stmpInfoList = cancelStmpInitData(vo, itemList);

		if (stmpInfoList == null) {
			throw new EzApiException(Constants._API_STMP_NO_DATA, Constants._API_STMP_NO_DATA_MSG);
		}

		List<String> mshipStmpBasNos = new ArrayList<String>();
		// 취소 진행
		for (int i = 0; i < stmpInfoList.size(); i++) {

			List<String> cancelSeqs = (List<String>) stmpInfoList.get(i).get("cancelSeq");
			if (cancelSeqs.size() > 0) {
				for (String hisSeq : cancelSeqs) {
					EzMap delParm = new EzMap();
					delParm.put("stmpHstSeq", hisSeq);
					dao.deleteStmpHis(delParm);
				}
				mshipStmpBasNos.add(String.valueOf(stmpInfoList.get(i).get("mshipStmpBasNo"))); // 취소부분
			}
		}

		if (mshipStmpBasNos.size() > 0) {
//			EzMap resultParm = new EzMap();
//			resultParm.put("mshipStmpBasNo", mshipStmpBasNos);
//			resultParm.put("itgCustNo", vo.getItgCustNo());
//			resultData = dao.getStmpIssueList(resultParm);
			// 빈값 내려줌
			CrmMshipStmpIssueVo vo2 = new CrmMshipStmpIssueVo();
			resultData.add(vo2);
		}

		return resultData;
	}

	private List<EzMap> cancelStmpInitData(@Valid CrmMshipStmpAccumVo vo, List<CrmMshipStmpAccumGodsVo> itemList) {

		List<String> godsNos = new ArrayList<>();
		for (int i = 0; i < itemList.size(); i++) {
			godsNos.add(itemList.get(i).getBuyGodsNo());
		}

		EzMap parm = new EzMap(vo);
		parm.put("itemList", godsNos);
		List<String> stmpMarstList = dao.getStmpMarstList(parm); // 상품별 그룹

		if (stmpMarstList == null) {
			return null;
		}

		// 스탬프 마스터번호로 스탬프 정보 받아옴
		EzMap infoPrm = new EzMap();
		infoPrm.put("stmpList", stmpMarstList);
		List<EzMap> stmpInfoList = dao.getStmpInfoList(infoPrm); // 마스터 코드, 상품으로 교차값 배열 2개

		List<EzMap> cancelList = new ArrayList<EzMap>();
		stmpInfoList = checkList(cancelList, stmpInfoList);
		cancelList.removeAll(cancelList);

		// 발급일 체크
		for (int i = 0; i < stmpInfoList.size(); i++) {
			// 날짜 제외
			Date toUsePossDt = (Date) stmpInfoList.get(i).get("toUsePossDt");
			Date toDay = new Date();
			if (toUsePossDt.before(toDay)) {
				cancelList.add(stmpInfoList.get(i));
			}
		}

		// 회원 구분 선체크 1. 임직원 2. 제휴 3.등급
		stmpInfoList = checkList(cancelList, stmpInfoList);
		cancelList.removeAll(cancelList);

		for (int i = 0; i < stmpInfoList.size(); i++) {
			String mshipTypeCd = String.valueOf(stmpInfoList.get(i).get("mshipTypeCds"));
			String applyMshpGradeCtnts = String.valueOf(stmpInfoList.get(i).get("applyMshpGradeCtnts"));
//			if (!Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd())
//					&& !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//				if (vo.getMshipTypeCd().equals("002")
//						&& !String.valueOf(stmpInfoList.get(i).get("cprtCmpNo")).equals(vo.getCprtCmpNo())) { // 제휴사 시
//																												// 코드체크
//					return null;
//				}
//				cancelList.add(stmpInfoList.get(i));
//			} else if (!Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd())
//					&& !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//				cancelList.add(stmpInfoList.get(i));
//			}
//			if (vo.getMshipTypeCd().equals("003") && !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//				cancelList.add(stmpInfoList.get(i));
//			} else {
//				if (!Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd()) && !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//					cancelList.add(stmpInfoList.get(i));
//				} else if (vo.getMshipTypeCd().equals("002") && !String.valueOf(stmpInfoList.get(i).get("cprtCmpNo")).equals(vo.getCprtCmpNo())) {
//					cancelList.add(stmpInfoList.get(i));
//				}
//			}
			
//			if (vo.getMshipTypeCd().equals("003") && !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//				cancelList.add(stmpInfoList.get(i));
//			} else {
//				if (!Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd()) && !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//					cancelList.add(stmpInfoList.get(i));
//				} else if (vo.getMshipTypeCd().equals("002") ) {
//					if (Utilities.isEmpty(stmpInfoList.get(i).get("cprtCmpNo")) && !Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
//						cancelList.add(stmpInfoList.get(i));
//					} else if (!String.valueOf(stmpInfoList.get(i).get("cprtCmpNo")).equals(vo.getCprtCmpNo())) {
//						cancelList.add(stmpInfoList.get(i));
//					}
//				} 
//			}
			// 003 회원 , 002 제휴 , 001 임직
			if (!Arrays.asList(applyMshpGradeCtnts.split(",")).contains(vo.getMshpGradeCd())) {
				if (vo.getMshipTypeCd().equals("001") && !Arrays.asList(mshipTypeCd.split(",")).contains(vo.getMshipTypeCd())) {
					cancelList.add(stmpInfoList.get(i));
				} else if (vo.getMshipTypeCd().equals("002") ) {
					if (Utilities.isEmpty(stmpInfoList.get(i).get("cprtCmpNo")))  {
						cancelList.add(stmpInfoList.get(i));
					} else if (Utilities.isNotEmpty(stmpInfoList.get(i).get("cprtCmpNo")) && !String.valueOf(stmpInfoList.get(i).get("cprtCmpNo")).equals(vo.getCprtCmpNo())) {
						cancelList.add(stmpInfoList.get(i));
					}
				} else if (vo.getMshipTypeCd().equals("003") ) {
					cancelList.add(stmpInfoList.get(i));
				}
			}
		}

		stmpInfoList = checkList(cancelList, stmpInfoList);
		cancelList.removeAll(cancelList);

		List<EzMap> stmpMarstInfoList = new ArrayList<>();
		for (int i = 0; i < stmpInfoList.size(); i++) {

			parm.put("mshipStmpBasNo", stmpInfoList.get(i).getString("mshipStmpBasNo"));
			EzMap stmpMarstInfo = dao.getStmpMarstInfo(parm);

			// 상품 카운터
			parm.put("itemList", itemList);
			List<EzMap> stmpGodsList = dao.getStmpGodsList(parm);
			stmpMarstInfo.put("itemList", stmpGodsList);

			// 해당 마스터 에서 취소 가능한 수량
			int condCnt = 1;
			if (stmpInfoList.get(i).get("condCnt") != null) {
				condCnt = stmpInfoList.get(i).getInt("condCnt");
			}
			
			int cancelCnt = stmpGodsList.get(0).getInt("applyQnty") * condCnt;
			parm.put("cancelCnt", cancelCnt);
			List<EzMap> cancelData = dao.getStmpCancelData(parm);

			List<String> cancelSeq = new ArrayList<>();
			for (EzMap cData : cancelData) {
				// 혜택지급 제외
				if (cData.getInt("coupnNo") != 0 || cData.getInt("pointScore") != 0) {
					break;
				}
				// 없을시 제외
//				if (Utilities.isEmpty(cData.getString("issueCnt")) && Utilities.isEmpty(cData.getString("pointScore")) ) {
//					continue;
//				}
				cancelSeq.add(cData.getString("stmpHstSeq"));
			}

			stmpMarstInfo.put("cancelSeq", cancelSeq);
			stmpMarstInfoList.add(stmpMarstInfo);

		}

		return stmpMarstInfoList;
	}

	public List<CrmMshipStmpIssueVo> eventStmp(@Valid CrmMshipStmpEventVo vo) throws Exception {

		List<CrmMshipStmpIssueVo> resultData = new ArrayList<CrmMshipStmpIssueVo>();
//		매장 있으면 체크 없으면 전부
//		if (vo.getStorNo() == null || vo.getStorNo().isEmpty()) {
//			throw new EzApiException(Constants._API_STOR_NO_DATA, Constants._API_STOR_NO_DATA_MSG);
//		}

		if (vo.getChlCd() == null || vo.getChlCd().isEmpty()) {
			throw new EzApiException(Constants._API_CHL_NO_DATA, Constants._API_CHL_NO_DATA_MSG);
		}

		if (vo.getItgCustNo() == null || vo.getItgCustNo().isEmpty()) {
			throw new EzApiException(Constants._API_CUST_NO_DATA, Constants._API_CUST_NO_DATA_MSG);
		}

		long itemCnt = vo.getStmpQnty();
		if (itemCnt == 0) {
			throw new EzApiException(Constants._API_STMP_CNT_DATA, Constants._API_STMP_CNT_DATA_MSG);
		}

		List<EzMap> stmpInfoList = eventStmpInitData(vo);

		List<String> mshipStmpBasNos = new ArrayList<String>();
		for (int i = 0; i < stmpInfoList.size(); i++) {

			for (int m = 0; m < itemCnt; m++) {
				EzMap hisPrm = new EzMap();
				hisPrm.put("mshipStmpBasNo", stmpInfoList.get(i).get("mshipStmpBasNo"));
				hisPrm.put("itgCustNo", vo.getItgCustNo());
				int totHisStmp = dao.getStmpTotalHist(hisPrm);

				// 판수에 찍힌 스탬프 보다 많을경우
				if (stmpInfoList.get(i).get("stmpMaxYn").equals("N")) {
					long maxCnt = Long.parseLong(String.valueOf(stmpInfoList.get(i).get("stmpMaxCnt")))
							* Long.parseLong(String.valueOf(stmpInfoList.get(i).get("stmpQnty")));
					if (totHisStmp >= maxCnt) {
						continue;
					}
				}

				// 적립
				EzMap inHisPrm = new EzMap();
				inHisPrm.put("mshipStmpBasNo", stmpInfoList.get(i).get("mshipStmpBasNo")); // 스탬프 번호
				inHisPrm.put("itgCustNo", vo.getItgCustNo()); // 회원 통합번호
				inHisPrm.put("storNo", vo.getStorNo()); // 매장 코드
				inHisPrm.put("stmpBasNm", stmpInfoList.get(i).get("stmpBasNm")); // 스탬프 명
				inHisPrm.put("fromUsePossDt", stmpInfoList.get(i).get("fromUsePossDt")); // from 사용가능
				inHisPrm.put("toUsePossDt", stmpInfoList.get(i).get("toUsePossDt")); // to 사용 가능
				inHisPrm.put("payChlCd", vo.getChlCd()); // 결제채널

				String hstSeq = dao.getStmpHisSeq(inHisPrm);
				EzMap seqInfo = new EzMap();

				int stmpCnt = 0;
				int issueCnt = 0;
				if (hstSeq != null) {
					seqInfo = dao.getStmpMaxSeq(hstSeq);
					stmpCnt = Integer.parseInt(String.valueOf(seqInfo.get("stmpAccumQnty")));
					issueCnt = Integer.parseInt(String.valueOf(seqInfo.get("issueCnt")));
				}

				long stmpQnty = Long.parseLong(String.valueOf(stmpInfoList.get(i).get("stmpQnty")));
				if (stmpCnt == stmpQnty) {
					stmpCnt = 0;
					issueCnt += 1;
				}

				// 쿠폰 , 포인트 적립
				if ((stmpCnt + 1) == stmpQnty) {

					// 쿠폰 마스터 정보로 쿠폰 발급연동 MCP22051315382955708 쿠폰 마스터
					// 쿠폰,포인트 전송
					if (stmpInfoList.get(i).get("bnfitCd").equals("001")) { // 포인트

						// 유효기간 1년 으로 설정
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
						//SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
						cal.setTime(new Date());
						String validPerdStaYmd = simpleDateFormat.format(cal.getTime());
						cal.add(Calendar.MONTH, 12);
						String validPerdEndYmd = simpleDateFormat.format(cal.getTime());
						//String extncDt = simpleDateFormat1.format(cal.getTime());

						CrmPointHstVo poiVo = new CrmPointHstVo();
						poiVo.setChitNo(Utilities.getAutoSeq("CHT")); // 전표번호
						poiVo.setItgCustNo(vo.getItgCustNo()); // CST22042618203144252
						poiVo.setPblsDivCd("903"); // 스탬프 구분코드
						//poiVo.setExtncDt(extncDt); // 2022/06/15 오전 10:05:31
						poiVo.setValidPerdStaYmd(validPerdStaYmd); // 20220608
						poiVo.setValidPerdEndYmd(validPerdEndYmd); // 20240608
						poiVo.setMessageYn("Y");	 				
						poiVo.setOccurPointScore(
								Integer.parseInt(String.valueOf(stmpInfoList.get(i).get("pointScore"))));
						CrmPointInfoVo ret = poiService.saveDeposit(poiVo);
						if (ret == null) {
//							throw new EzApiException(Constants._API_POINT_NO_DATA, Constants._API_POINT_NO_DATA_MSG);
							continue;
						}
						inHisPrm.put("pointScore", stmpInfoList.get(i).get("pointScore"));

					} else if (stmpInfoList.get(i).get("bnfitCd").equals("002")) { // 쿠폰
						CrmCouponVo cpVo = new CrmCouponVo();
						cpVo.setMshipCoupnBasNo(String.valueOf(stmpInfoList.get(i).get("coupnNo")));
						cpVo.setItgCustNo(vo.getItgCustNo());
						cpVo.setChitNo(hstSeq);
						CrmCouponVo ret2 = cpnService.insertIssueTem(cpVo); // 스탬프 쿠폰발행 임시
						if (ret2 == null) {
//							throw new EzApiException(Constants._API_COUPN_NO_DATA, Constants._API_COUPN_NO_DATA_MSG);
							continue;
						}
						// 쿠폰 발급된 번호
						inHisPrm.put("coupnNo", ret2.getCoupnPblsBasNo());
					}
				}

				mshipStmpBasNos.add(String.valueOf(stmpInfoList.get(i).get("mshipStmpBasNo")));
				inHisPrm.put("stmpAccumQnty", (stmpCnt + 1)); // 스탬프수량
				inHisPrm.put("issueCnt", issueCnt); // 스탬프수량
				dao.insertStmpHis(inHisPrm);

			}

		}

		if (mshipStmpBasNos.size() > 0) {
			EzMap resultParm = new EzMap();
			resultParm.put("mshipStmpBasNo", mshipStmpBasNos);
			resultParm.put("itgCustNo", vo.getItgCustNo());
			resultData = dao.getStmpIssueList(resultParm);
		}

		return resultData;
	}

	private List<EzMap> eventStmpInitData(@Valid CrmMshipStmpEventVo vo) throws ParseException {

		EzMap parm = new EzMap(vo);
		List<EzMap> stmpMarstList = dao.getStmpMarstListForEvent(parm);

		for (int i = 0; i < stmpMarstList.size(); i++) {

			// 날짜 제외
			Date date1 = (Date) stmpMarstList.get(i).get("toUsePossDt");
			Date date2 = new Date();
			if (date1.before(date2)) {
				stmpMarstList.remove(i);
				continue;
			}

			// 유효기간 제외
			if (stmpMarstList.get(i).get("validYn").equals("Y")) {

				Calendar getToday = Calendar.getInstance();
				getToday.setTime(new Date()); // 금일 날짜 validPerd

				Date fromDate = (Date) stmpMarstList.get(i).get("fromUsePossDt");
				Calendar cmpDate = Calendar.getInstance();
				cmpDate.setTime(fromDate); // 특정 일자

				long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
				long diffDays = diffSec / (24 * 60 * 60); // 일자수 차이

				if (diffDays > Long.parseLong(String.valueOf(stmpMarstList.get(i).get("validPerd")))) {
					stmpMarstList.remove(i);
					continue;
				}
			}

			// 판당 0 제외
			if (Long.parseLong(String.valueOf(stmpMarstList.get(i).get("stmpQnty"))) < 1) {
				stmpMarstList.remove(i);
				continue;
			}
		}

		return stmpMarstList;
	}

	public List<CrmMshipStmpIssueVo> getStmpIssueList(EzMap param) {

		return dao.getStmpIssueList(param);
	}

	public List<EzMap> checkList(List<EzMap> cancelList, List<EzMap> stmpInfoList) {

		if (cancelList.size() == 0) {
			return stmpInfoList;
		}

		for (int i = 0; i < stmpInfoList.size(); i++) {
			for (int j = 0; j < cancelList.size(); j++) {
				if (stmpInfoList.get(i).getString("mshipStmpBasNo")
						.equals(cancelList.get(j).getString("mshipStmpBasNo"))) {
					stmpInfoList.remove(i);
				}
			}
		}
		return stmpInfoList;
	}

}
