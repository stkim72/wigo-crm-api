package com.ceragem.api.crm.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmCoupnPblsHstDao;
import com.ceragem.api.crm.dao.CrmMshipCoupnBasDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmChlBasVo;
import com.ceragem.api.crm.model.CrmCouponCustNoSo;
import com.ceragem.api.crm.model.CrmCouponSo;
import com.ceragem.api.crm.model.CrmCouponVo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmGodsBasVo;
import com.ceragem.api.crm.model.CrmMshipApplyCoupnEventRelVo;
import com.ceragem.api.crm.model.CrmMshipCoupnBasVo;
import com.ceragem.api.crm.model.CrmPointHstVo;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName CrmCoupnPblsHstService
 * @author 김성태
 * @date 2022. 4. 28.
 * @Version 1.0
 * @description CRM쿠폰발행이력 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Service
public class CrmCouponService extends AbstractCrmService {
	private final static String[] DAY_FIELD = { "dow1UseYn", "dow2UseYn", "dow3UseYn", "dow4UseYn", "dow5UseYn",
			"dow6UseYn", "dow7UseYn" };
	private final static String[] DAY_NAME = { "월", "화", "수", "목", "금", "토", "일" };

	public final static String COUPON_TARGET_MEMBER = "001";
	public final static String COUPON_TARGET_ALL = "002";

	public final static String COUPON_KIND_POINT = "005";
	public final static String COUPON_POINT = "904";

	public final static String API_CODE_MASTER_NOT_FOUND = "IAR0501";
	public final static String API_CODE_MASTER_NOT_FOUND_MSG = "쿠폰마스터를 찾을 수 없습니다.";

	public final static String API_CODE_MEMBER_ONLY = "IAR0502";
	public final static String API_CODE_MEMBER_ONLY_MSG = "회원전용 쿠폰입니다.";

	public final static String API_CODE_DUPLICATED_ISSUE = "IAR0503";
	public final static String API_CODE_DUPLICATED_ISSUE_MSG = "이미 발행한 쿠폰입니다.";

	public final static String API_CODE_COUPON_NOT_FOUND = "IAR0504";
	public final static String API_CODE_COUPON_NOT_FOUND_MSG = "존재하지 않는 쿠폰입니다.";

	public final static String API_CODE_COUPON_USED = "IAR0505";
	public final static String API_CODE_COUPON_USED_MSG = "이미 사용한 쿠폰입니다.";

	public final static String API_CODE_COUPON_DAY = "IAR0506";
	public final static String API_CODE_COUPON_DAY_MSG = "사용가능한 요일이 아닙니다.";

	public final static String API_CODE_COUPON_HOUR = "IAR0507";
	public final static String API_CODE_COUPON_HOUR_MSG = "사용가능한 시간이 아닙니다.";

	public final static String API_CODE_COUPON_UNUSED = "IAR0508";
	public final static String API_CODE_COUPON_UNUSED_MSG = "아직 사용하지 않은 쿠폰입니다.";

	public final static String API_CODE_COUPON_POINT_CANCEL = "IAR0509";
	public final static String API_CODE_COUPON_POINT_CANCEL_MSG = "포인트 쿠폰은 취소 할 수 없습니다.";

	public final static String API_CODE_COUPON_EXIST = "IAR0510";
	public final static String API_CODE_COUPON_EXIST_MSG = "해당하는 이벤트 쿠폰이 없습니다.";

	public final static String API_CODE_PAY_OVER_01 = "IAR0511";
	public final static String API_CODE_PAY_OVER_01_MSG = "총지급 횟수를 초과했습니다.";

	public final static String API_CODE_PAY_OVER_02 = "IAR0512";
	public final static String API_CODE_PAY_OVER_02_MSG = "1개월 지급 횟수를 초과했습니다.";

	public final static String API_CODE_PAY_OVER_03 = "IAR0513";
	public final static String API_CODE_PAY_OVER_03_MSG = "1일 지급 횟수를 초과했습니다.";

	public final static String API_CODE_DAY_OVER = "IAR0514";
	public final static String API_CODE_DAY_OVER_MSG = "일 최대 사용매수를 초과했습니다.";

	public final static String API_CODE_MSHIP_NOT_FOUND = "IAR0515";
	public final static String API_CODE_MSHIP_NOT_FOUND_MSG = "멤버쉽 회원만 사용가능한 쿠폰입니다.";

	public final static String API_CODE_USE_DAY_OVER = "IAR0516";
	public final static String API_CODE_USE_DAY_OVER_MSG = "사용기간 범위를 초과 하였습니다.";

	public final static String API_CODE_MIN_AMT_FOUND = "IAR0517";
	public final static String API_CODE_MIN_AMT_FOUND_MSG = "결제금액이 설정 최소결제 금액보다 적습니다.";

	public final static String API_CODE_CUST_FOUND = "IAR0518";
	public final static String API_CODE_CUST_FOUND_MSG = "회원쿠폰에 발급된 통합회원 번호가 없습니다.";
	
	public final static String API_CODE_GITG_FOUND = "IAR0519";
	public final static String API_CODE_GITG_FOUND_MSG = "선물하기 불가능한 쿠폰입니다.";
	
	public final static String API_COUPN_STOR_NOT_FOUND = "IAR0520";
	public final static String API_COUPN_STOR_NOT_FOUND_MSG = "사용매장으로 등록된 매장이 없습니다.";

	@Autowired
	CrmCoupnPblsHstDao dao;

	@Autowired
	CrmCustService custService;

	@Autowired
	CrmMshipCoupnBasDao couponDao;

	@Autowired
	CrmPointHstService pointService;

	// @Autowired
	// CrmCoupnBookPblsHstDao bookDao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 29.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 쿠폰발행
	 *
	 */
	public CrmCouponVo insertIssue(CrmCouponVo vo) throws Exception {

		// 아래로 수정
		// CrmMshipCoupnBasVo master = couponDao.select(vo);

		String itgCustNo = vo.getItgCustNo();

		// 고객 정보 취득
		CrmCustVo custVo = custService.getCustVo(itgCustNo);

		// 쿠폰 정책 취득
		// 필수 파라미터
		// 통합고객번호(itgCustNo), 멤버십등급(mshipTypeCd), 회원등급(mshipGradeCd),
		// 발행쿠폰리스트(coupnTypeCd)
		// custVo.setItgCustNo(itgCustNo);
		// custVo.setMshipTypeCd("");
		// custVo.setMshipGradeCd("");
		custVo.setCoupnTypeCd(vo.getCoupnTypeCd());

		CrmMshipApplyCoupnEventRelVo master = couponDao.selectCoupnInfo(custVo);

		if (master == null) {
			throw new EzApiException(API_CODE_COUPON_NOT_FOUND, API_CODE_COUPON_NOT_FOUND_MSG);
		}

		if (master.getMshipCoupnBasNo() == null)
			throw new EzApiException(API_CODE_MASTER_NOT_FOUND, API_CODE_MASTER_NOT_FOUND_MSG);
		if (Utilities.isNotEmpty(vo.getChitNo())) {
			CrmCouponSo so = new CrmCouponSo();
			so.setChitNo(vo.getChitNo());
			int cnt = dao.selectListCount(so);
			if (cnt > 0)
				throw new EzApiException(API_CODE_DUPLICATED_ISSUE, API_CODE_DUPLICATED_ISSUE_MSG);
		}

		applyCouponPolicy(master, vo);
		insert(vo);
		return get(vo);
	}

	private void applyCouponPolicy(CrmMshipCoupnBasVo master, CrmCouponVo coupon) throws Exception {

		String storNo = coupon.getStorNo();
		String campNo = coupon.getCampNo();
		String promNo = coupon.getPromNo();
		String chitNo = coupon.getChitNo();
		String itgCustNo = coupon.getItgCustNo();
		String coupnTypeCd = coupon.getCoupnTypeCd();
//		String mshipCoupnBasNo = coupon.getMshipCoupnBasNo();

		Utilities.beanToBean(coupon, master);
		// if(Utilities.isNotEmpty(storNo))
		coupon.setStorNo(storNo);
		coupon.setCampNo(campNo);
		coupon.setPromNo(promNo);
		coupon.setItgCustNo(itgCustNo);
		coupon.setChitNo(chitNo);
		coupon.setUseYn("N");

		String tgtCd = master.getCoupnTgtCd();

		CrmCustVo custVo = custService.getCustVo(itgCustNo);

		if (COUPON_TARGET_MEMBER.equals(tgtCd)) {

			if (Utilities.isEmpty(itgCustNo))
				throw new EzApiException(API_CODE_MEMBER_ONLY, API_CODE_MEMBER_ONLY_MSG);

			if (custVo == null)
				throw new EzApiException(Constants._API_CODE_NO_USER, Constants._API_CODE_NO_USER_MSG);

			// 05.25 김은성 쿠폰 정책 추가
			// 쿠폰 정책 번호 없이 넘어올때
			// 해당 회원등급,쿠폰유형에 맞는 정책을 찾아서 처리한다

			// 해당 회원에 맞는 정책이 있는 지 찾는다.
			// 필수 파라미터 itgCustNo, COUPN_TYPE_CD = '007' AND A.MSHIP_GRADE_CD = '003' AND
			// A.MSHP_GRADE_CD = '005'

			custVo.setCoupnTypeCd(coupnTypeCd);
			CrmMshipApplyCoupnEventRelVo coupnInfo = couponDao.selectCoupnInfo(custVo);

			if (coupnInfo == null) {
				throw new EzApiException(API_CODE_COUPON_EXIST, API_CODE_COUPON_EXIST_MSG);
			} else {

				// 멤버십정책 - 이벤트 쿠폰 지급 횟수 정책

				// 총지급횟수 초과
				if (coupnInfo.getTotAppntCnt() <= coupnInfo.getTodayCpnPlbsCnt()) {
					throw new EzApiException(API_CODE_PAY_OVER_01, API_CODE_PAY_OVER_01_MSG);
				}

				// 1개월 지급횟수 초과
				if (coupnInfo.getMonthAppntCnt() <= coupnInfo.getMonthCpnPlbsCnt()) {
					throw new EzApiException(API_CODE_PAY_OVER_02, API_CODE_PAY_OVER_02_MSG);
				}

				// 1일 지급횟수 초과
				if (coupnInfo.getDayAppntCnt() <= coupnInfo.getTodayCpnPlbsCnt()) {
					throw new EzApiException(API_CODE_PAY_OVER_03, API_CODE_PAY_OVER_03_MSG);
				}

			}

		}
	}

	public int updateApprove(CrmCouponVo param) throws Exception {

		CrmCouponVo coupon = validateApprove(param);
		if (COUPON_KIND_POINT.equals(coupon.getCoupnKndCd())) {
			// int amt = coupon.getApplyAmt();
			int amt = coupon.getApplyPoint(); // 쿠폰 포인트 컬럼 추가
			CrmPointHstVo pointVo = new CrmPointHstVo();
			pointVo.setChitNo(coupon.getCoupnPblsBasNo()); // 전표번호
			pointVo.setPblsChlCd(Utilities.getSystemCd());
			pointVo.setItgCustNo(coupon.getItgCustNo());
			pointVo.setOccurPointScore(amt);
			pointVo.setPblsDivCd(COUPON_POINT);
			pointService.saveDeposit(pointVo);
		}
		return dao.updateApprove(coupon);
	}

	public CrmCouponVo updateValidate(CrmCouponVo param) throws Exception {
		return validateApprove(param);
	}

	public int updateCancel(CrmCouponVo vo) throws Exception {
		CrmCouponVo coupon = dao.select(vo);
		if (coupon == null)
			throw new EzApiException(API_CODE_COUPON_NOT_FOUND, API_CODE_COUPON_NOT_FOUND_MSG);
		if (!"Y".equals(coupon.getUseYn()))
			throw new EzApiException(API_CODE_COUPON_UNUSED, API_CODE_COUPON_UNUSED_MSG);

		if (!"Y".equals(coupon.getUseYn()))
			throw new EzApiException(API_CODE_COUPON_UNUSED, API_CODE_COUPON_UNUSED_MSG);
		if (COUPON_KIND_POINT.equals(coupon.getCoupnKndCd()))
			throw new EzApiException(API_CODE_COUPON_POINT_CANCEL, API_CODE_COUPON_POINT_CANCEL_MSG);

		return dao.updateCancel(coupon);
	}

	public CrmCouponVo validateApprove(CrmCouponVo vo) throws Exception {

//		220623 
//		1. 변경전 > 쿠폰번호,통합회원,결제금액 으로 쿠폰 마스터 제약 조건체크함 
//		2. 변경후 > 회원별 쿠폰 조회 에서 상세 마스터 정보 내려줌 포함 상품,채널 사용 여부는 포스에서 진행 
//		3. 관리자 에서는 매장코드 [없을시 회원쿠폰] , 쿠폰번호 로 사용 가능 [USE_YN = N] 체크 후 사용처리
//		4. 사용매장, 발급매장 분리되면서 3번 무시
//		5. 사용시 시간 요일 체크 추가 (매장추가)
//		6. 채널코드 추가 필수
// 		7. 마스터 매장코드 없을시 전부 매장 체크 안함 , 있을시에만 체크함 | 쿠폰발급 후 매장 생성 시 문제 
//		8. 사용매장 있을시 마스타에서 등록 매자 없으면 사용가능 , 사용매장 있고 마스타 등록 있을시 매장 체크 , 사용매장 없을시 체크 안함
		
		CrmCouponVo coupon = null;
		if (Utilities.isEmpty(vo.getStorNo()) || Utilities.isEmpty(vo.getStorNo().trim())) {
			coupon = dao.select(vo);
		} else {
			EzMap storCnt = dao.selectStorCnt(vo);
			vo.setMshipCoupnBasNo(null);
			if (Utilities.isNotEmpty(storCnt) && storCnt.getInt("storCnt") > 0) {
				vo.setMshipCoupnBasNo(storCnt.getString("mshipCoupnBasNo"));
			} 
			coupon = dao.selectJoinStore(vo);
		}

		if (coupon == null)
			throw new EzApiException(API_CODE_COUPON_NOT_FOUND, API_CODE_COUPON_NOT_FOUND_MSG);
//		if (Utilities.isEmpty(coupon.getItgCustNo()) || Utilities.isEmpty(coupon.getItgCustNo().trim())) {
//			throw new EzApiException(API_CODE_CUST_FOUND, API_CODE_CUST_FOUND_MSG);
//		}
		
		// coupon = dao.select(vo);
//		if (coupon == null)
//			throw new EzApiException(API_CODE_COUPON_NOT_FOUND, API_CODE_COUPON_NOT_FOUND_MSG);
		
		if ("Y".equals(coupon.getUseYn()))
			throw new EzApiException(API_CODE_COUPON_USED, API_CODE_COUPON_USED_MSG);	// 이미사용
		if ("0".equals(coupon.getChkStor()))
			throw new EzApiException(API_COUPN_STOR_NOT_FOUND, API_COUPN_STOR_NOT_FOUND_MSG);	// 등록매장
		
		// 업데이트 정보 저장
		coupon.setChitNo(vo.getChitNo());
		coupon.setBuyGodsCd(vo.getBuyGodsCd());
		coupon.setOrdrAmt(vo.getOrdrAmt());
		coupon.setPayAmt(vo.getPayAmt());
		coupon.setSaleAmt(vo.getSaleAmt());
		coupon.setPromNo(vo.getPromNo());
		coupon.setCampNo(vo.getCampNo());
		
		if (Utilities.isNotEmpty(coupon.getSgntYn()) && coupon.getSgntYn().equals("Y")) {
			coupon.setItgCustNo(vo.getItgCustNo());
		}
		
		// 적용매장 체크
		
		
		// 사용기간 체크
//		long nano = System.currentTimeMillis();
//		int toDay = Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(nano));
//		if (coupon.getUseStdDayCondCd().equals("Y")) {
//
//			long issueDt = Long.valueOf(coupon.getRegDt().substring(0, 8));
//			if (toDay - issueDt > Long.valueOf(coupon.getCoupnUsePossDay())) {
//				throw new EzApiException(API_CODE_USE_DAY_OVER, API_CODE_USE_DAY_OVER_MSG);
//			}
//		} else {
//
//			int fromPblsStdDay = Integer.valueOf(coupon.getFromPblsStdDay());
//			int toPblsStdDay = Integer.valueOf(coupon.getToPblsStdDay());
//			if (toDay < fromPblsStdDay || toDay > toPblsStdDay) {
//				throw new EzApiException(API_CODE_USE_DAY_OVER, API_CODE_USE_DAY_OVER_MSG);
//			}
//		}

		// 일 최대 사용
//		Integer maxUseCnt = coupon.getMaxUseCnt();
//		int cpnMaxIssue = dao.getMaxIssuDay(coupon.getMshipCoupnBasNo());
//		if ((cpnMaxIssue + 1) > maxUseCnt) {
//			throw new EzApiException(API_CODE_DAY_OVER, API_CODE_DAY_OVER_MSG);
//			// return false;
//		}

		// 회원체크 (전체,비회원 체크 필요없음 | 회원만 체크 회원정보에 멈버쉽 여부)
//		if (coupon.getUseDivCd().equals("001")) {
//			CrmCustVo custVo = custService.getCustVo(vo.getItgCustNo());
//			if (custVo.getMshipSbscYn() == null || custVo.getMshipSbscYn().isEmpty()
//					|| custVo.getMshipSbscYn().equals("N")) {
//				throw new EzApiException(API_CODE_MSHIP_NOT_FOUND, API_CODE_MSHIP_NOT_FOUND_MSG);
//			}
//		}

		// 쿠폰 종류 [coupnKndCd 001 정액,002 정율,005 포인트]
		// 적용금액 applyAmt , 최소구매금액 minBuyAmt
//		if (coupon.getCoupnKndCd().equals("001") || coupon.getCoupnKndCd().equals("002")) {
//			if (coupon.getMinBuyAmt() > vo.getTotAmt()) {
//				throw new EzApiException(API_CODE_MIN_AMT_FOUND, API_CODE_MIN_AMT_FOUND_MSG);
//			}
//		}

		// 요일체크
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek == 0)
			dayOfWeek = 7;

		EzMap cMap = new EzMap(Utilities.beanToMap(coupon));
		String fd = DAY_FIELD[dayOfWeek - 1];
		if (!"Y".equals(cMap.getString(fd))) {
			StringBuffer msg = new StringBuffer();
			for (int i = 0; i < DAY_FIELD.length; i++) {
				if (!"Y".equals(cMap.getString(DAY_FIELD[i])))
					continue;
				if (msg.length() > 0)
					msg.append(",");
				msg.append(DAY_NAME[i]);
			}
			throw new EzApiException(API_CODE_COUPON_DAY,
					"[사용가능요일-(" + msg.toString() + ")]" + API_CODE_COUPON_DAY_MSG);
		}

		// 시간체크
		int nowTime = Utilities.parseInt(Utilities.getTimeString().substring(0, 4));
		int fromUseHour = Utilities.parseInt(coupon.getFromUseHour());
		int toUseHour = Utilities.parseInt(coupon.getToUseHour());
		if (nowTime < fromUseHour || nowTime > toUseHour) {
			String from = coupon.getFromUseHour();
			String to = coupon.getToUseHour();
			from = from.substring(0, 2) + ":" + from.substring(2);
			to = to.substring(0, 2) + ":" + to.substring(2);
			throw new EzApiException(API_CODE_COUPON_HOUR,
					"[사용가능시간-(" + from + "-" + to + ")]" + API_CODE_COUPON_HOUR_MSG);
		}

		// String ch = Utilities.getSystemCd();

//		coupon.setBuyGodsCd(vo.getBuyGodsCd());
//		coupon.setOrdrAmt(vo.getOrdrAmt());
//		coupon.setPayAmt(vo.getPayAmt());
//		coupon.setSaleAmt(vo.getSaleAmt());
//		coupon.setChitNo(vo.getChitNo());
//		coupon.setPromNo(vo.getPromNo());
//		coupon.setCampNo(vo.getCampNo());
//		coupon.setApplyPoint(vo.getApplyPoint());

		return coupon;
	}

	public List<CrmCouponVo> insertIssues(List<CrmCouponVo> list) throws Exception {
		List<CrmCouponVo> ret = new ArrayList<CrmCouponVo>();
		for (int i = 0; i < list.size(); i++) {
			CrmCouponVo vo = list.get(i);
			ret.add(insertIssue(vo));
		}
		return ret;
	}

	// public List<CrmCouponVo> updateCancel(List<CrmCouponVo> list) throws
	// Exception {
	// // TODO Auto-generated method stub
	// return null;
	// }

	public byte[] createBarcode(String text, int width, int height) throws Exception {
		log.debug("[text:%s],width:%d,height:%d", text, width, height);
		BufferedImage barcode = Utilities.createBarcodeImage(text, width, height);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(barcode, "png", bos);
		return bos.toByteArray();
	}

	public int deletelIssues(String chitNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public CrmCouponVo insertIssueTem(CrmCouponVo cpVo) throws Exception {
		
		CrmCouponVo voTem = dao.selectMaster(cpVo);
		if (voTem == null) {
//			throw new EzApiException(Constants._API_COUPN_NO_DATA, Constants._API_COUPN_NO_DATA_MSG);
			return null;
		}

		// 발행기간체크
		long now = System.currentTimeMillis();
		String toDay = new SimpleDateFormat("yyyyMMdd",Locale.KOREA).format(now);
		if (Integer.parseInt(voTem.getToPblsStdDay()) < Integer.parseInt(toDay) || Integer.parseInt(voTem.getFromPblsStdDay()) > Integer.parseInt(toDay)) {
			//throw new EzApiException(Constants._API_COUPN_OVER_DAY_DATA, Constants._API_COUPN_OVER_DAY_DATA_MSG);
			return null;
		}
		
		// 일최대발급체크
		int dayCoupnCnt = dao.getDayCoupnCnt(voTem); // 당일 발급된수량
		int maxIssueCnt = voTem.getMaxIssueCnt();	 // 마스터 설정 수량

		// 일최대 발급 체크
		if ((dayCoupnCnt + 1) > maxIssueCnt) {
			//throw new EzApiException(Constants._API_COUPN_OVER_ISSUE_DATA, Constants._API_COUPN_OVER_ISSUE_DATA_MSG);
			return null;
		}
		
		// 적용회원 체크
		CrmCustVo custVo = custService.getCustVo(cpVo.getItgCustNo());
//		String mshipTypeCd = String.valueOf(voTem.getMshipTypeCds());
		String applyMshpGradeCtnts = String.valueOf(voTem.getApplyMshpGradeCtnts());
		
		if (!Arrays.asList(applyMshpGradeCtnts.split(",")).contains(custVo.getMshipGradeCd())) {
			//throw new EzApiException(Constants._API_COUPN_GRADE_DATA, Constants._API_COUPN_GRADE_DATA_MSG);
			return null;
		} else if (Utilities.isNotEmpty(voTem.getCprtCmpNo())) {
			//throw new EzApiException(Constants._API_COUPN_CMPNO_DATA, Constants._API_COUPN_CMPNO_DATA_MSG);
			if(custVo.getMshipTypeCd().equals("002") && !(voTem.getCprtCmpNo().equals(custVo.getCprtCmpNo()))) {
				return null;
			}
		}
		
//		if (!Arrays.asList(mshipTypeCd.split(",")).contains(custVo.getMshipTypeCd())) {
//			
//		} else if (!Arrays.asList(applyMshpGradeCtnts.split(",")).contains(custVo.getMshipGradeCd())) {
//			
//		} else if (custVo.getMshipTypeCd().equals("002") && !(voTem.getCprtCmpNo().equals(custVo.getCprtCmpNo()))) {
//			
//		}
		
//		int cnt = 
		dao.insertIssueTem(cpVo);

		return dao.getMaxCoupnHstSeq(cpVo);
	}

	public List<CrmGodsBasVo> getGodsList(String mshipCoupnBasNo) {
		return dao.getGodsList(mshipCoupnBasNo);
	}

	public List<CrmChlBasVo> getChlList(String mshipCoupnBasNo) {
		return dao.getChlList(mshipCoupnBasNo);
	}

	public List<CrmCouponVo> getCouponMasterList(CrmCouponCustNoSo so) {
		return dao.getCouponMasterList(so);
	}

	public CrmCouponVo saveGiftCoupn(String coupnPblsBasNo, String fromItgCustNo, String toItgCustNo) {
		
		// 해당쿠폰 으로 선물가능 여부 체크 , 사용가능
		// 양도자 양수자 체크
		// 받은선물 재 선물 불가
		CrmCouponVo prm = new CrmCouponVo();
		prm.setItgCustNo(fromItgCustNo);
		prm.setCoupnPblsBasNo(coupnPblsBasNo);
		CrmCouponVo coupon = dao.select(prm);
		
		if (coupon == null)
			throw new EzApiException(API_CODE_COUPON_NOT_FOUND, API_CODE_COUPON_NOT_FOUND_MSG);
		if ("Y".equals(coupon.getUseYn()))
			throw new EzApiException(API_CODE_COUPON_USED, API_CODE_COUPON_USED_MSG);
		if (coupon.getTrns() != null || !"Y".equals(coupon.getGiftPossYn()))
			throw new EzApiException(API_CODE_GITG_FOUND, API_CODE_GITG_FOUND_MSG);
		// 쿠폰 사용자 변경
		CrmCouponVo vo = new CrmCouponVo();
		vo.setItgCustNo(toItgCustNo);
		vo.setCoupnPblsBasNo(coupnPblsBasNo);
		vo.setTrns(fromItgCustNo);
		int result = dao.updateGiftCoupn(vo);
		
		if (result == 0) {
			return null;
		}
		prm.setItgCustNo(toItgCustNo);
		CrmCouponVo resultCoupon = dao.select(prm);
		return resultCoupon;
	}

}
