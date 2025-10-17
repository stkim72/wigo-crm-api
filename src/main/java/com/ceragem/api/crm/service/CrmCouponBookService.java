package com.ceragem.api.crm.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmCoupnBookPblsHstDao;
import com.ceragem.api.crm.dao.CrmCoupnPblsHstDao;
import com.ceragem.api.crm.dao.CrmMshipCoupnBasDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmCouponBookSo;
import com.ceragem.api.crm.model.CrmCouponBookVo;
import com.ceragem.api.crm.model.CrmCouponSo;
import com.ceragem.api.crm.model.CrmCouponVo;
import com.ceragem.api.crm.model.CrmMshipCoupnBasSo;
import com.ceragem.api.crm.model.CrmMshipCoupnBasVo;
import com.ceragem.crm.common.model.EzApiException;

/**
 * 
 * @ClassName CrmCoupnBookPblsHstService
 * @author 김성태
 * @date 2022. 5. 11.
 * @Version 1.0
 * @description CRM쿠폰북발행이력 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCouponBookService extends AbstractCrmService {
	public final static String API_CODE_NO_MASTER = "IAR0501";
	public final static String API_CODE_NO_MASTER_MSG = "쿠폰마스터가 존재하지 않습니다.";

	private final static String API_CODE_EXIST_BOOK = "IAR0502";
	private final static String API_CODE_EXIST_BOOK_MSG = "이미 생성한 서비스권 입니다.";

	private final static String API_CODE_EXIST_USE_COUPON = "IAR0503";
	private final static String API_CODE_EXIST_USE_COUPON_MSG = "사용한 내역이 존재합니다.";

	public final static String API_CODE_BOOK_NOT_FOUND = "IAR0504";
	public final static String API_CODE_BOOK_NOT_FOUND_MSG = "서비스권 존재하지 않습니다.";

	public final static String API_CODE_APPLYCNT_INVALID = "IAR0505";
	public final static String API_CODE_APPLYCNT_INVALID_MSG = "적용횟수는 최소 1회 이상이어야 합니다.";

	public final static String API_CODE_REMAINCNT_LACK = "IAR0506";
	public final static String API_CODE_REMAINCNT_LACK_MSG = "잔여횟수가 부족합니다.";

	public final static String API_CODE_INVALID_PERIOD = "IAR0507";
	public final static String API_CODE_INVALID_PERIOD_MSG = "사용가능 기간이 아닙니다.";

	public final static String API_CODE_USECNT_LACK = "IAR0508";
	public final static String API_CODE_USECNT_LACK_MSG = "사용횟수가 부족합니다.";

	public final static String API_CODE_STORE_NOT_MATCH = "IAR0509";
	public final static String API_CODE_STORE_NOT_MATCH_MSG = "발급매장과 사용매장이 다릅니다.";

	private final static String COUPON_TYPE_SERVICE = "013";

	@Autowired
	CrmCoupnBookPblsHstDao dao;

	@Autowired
	CrmCouponService couponService;

	@Autowired
	CrmCoupnPblsHstDao couponDao;

	@Autowired
	CrmMshipCoupnBasDao masterDao;

	@Autowired
	CrmCustService custService;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public CrmCouponBookVo insertServiceIssue(CrmCouponBookVo vo) throws Exception {
		if (Utilities.isNotEmpty(vo.getChitNo())) {
			CrmCouponBookSo bso = new CrmCouponBookSo();
			bso.setChitNo(vo.getChitNo());
			int cnt = dao.selectListCount(bso);
			if (cnt > 0) {
				throw new EzApiException(API_CODE_EXIST_BOOK, API_CODE_EXIST_BOOK_MSG);
			}
		}

		CrmMshipCoupnBasVo master = null;
		CrmMshipCoupnBasSo so = new CrmMshipCoupnBasSo();
		so.setCoupnTypeCd(COUPON_TYPE_SERVICE);
		so.setMshipCoupnBasNo(vo.getMshipCoupnBasNo());
		if (Utilities.isEmpty(so.getMshipCoupnBasNo()))
			master = masterDao.selectMasterCoupon(so);
		else
			master = masterDao.select(so);
		if (master == null)
			throw new EzApiException(API_CODE_NO_MASTER, API_CODE_NO_MASTER_MSG);
		CrmCouponVo coupon = Utilities.beanToBean(master, CrmCouponVo.class);
		if (Utilities.isEmpty(vo.getUseStaYmd())) {
			vo.setUseStaYmd(coupon.getUseStartYmd());
		}
		if (Utilities.isEmpty(vo.getUseEndYmd())) {
			vo.setUseEndYmd(coupon.getUseEndYmd());
		}
//		CrmCustVo custVo = null;
		if (Utilities.isNotEmpty(vo.getItgCustNo())) {
//			custVo = 
			custService.getCustVo(vo.getItgCustNo());
		}
//		if (custVo != null) {
//
//		}
		vo.setMshipCoupnBasNo(master.getMshipCoupnBasNo());
		int ret = insert(vo);
		if (ret == 0)
			return null;

		CrmCouponBookVo book = get(vo);
		if (book == null)
			return null;

		coupon.setItgCustNo(vo.getItgCustNo());
		coupon.setCoupnBookHstSeq(book.getCoupnBookHstSeq());
		coupon.setUseYn("N");
		coupon.setStorNo(null);
		for (int i = 0; i < vo.getBuyQnty(); i++) {
			couponService.insert(coupon);
		}
		CrmCouponSo s = new CrmCouponSo();
		s.setBookYn("Y");
		s.setCoupnBookHstSeq(book.getCoupnBookHstSeq());
		List<CrmCouponVo> list = couponService.getList(s);
		book.setCouponList(list);
		return book;
	}

	@Override
	public int delete(Object param) throws Exception {
		CrmCouponBookVo vo = (CrmCouponBookVo) param;
		CrmCouponBookVo book = null;
		if (Utilities.isEmpty(vo.getChitNo()))
			book = get(param);
		else {
			CrmCouponBookSo so = new CrmCouponBookSo();
			so.setChitNo(vo.getChitNo());
			List<CrmCouponBookVo> list = getList(so);
			if (Utilities.isNotEmpty(list))
				book = list.get(0);
		}
		if (book == null)
			return 0;
		if (book.getUseCnt() > 0)
			throw new EzApiException(API_CODE_EXIST_USE_COUPON, API_CODE_EXIST_USE_COUPON_MSG);
		int ret = super.delete(book);
		couponDao.deleteBook(book);
		return ret;
	}

	private CrmCouponBookVo validateApprove(CrmCouponBookVo param) throws Exception {
		if (param.getApplyCnt() == null || param.getApplyCnt() < 1)
			throw new EzApiException(API_CODE_APPLYCNT_INVALID, API_CODE_APPLYCNT_INVALID_MSG);

		CrmCouponBookVo book = getBookInfo(param);
		if (book == null) {
			throw new EzApiException(API_CODE_BOOK_NOT_FOUND, API_CODE_BOOK_NOT_FOUND_MSG);
		}
		if (book.getRemainCnt() < param.getApplyCnt())
			throw new EzApiException(API_CODE_REMAINCNT_LACK,
					"[잔여횟수 " + book.getRemainCnt() + "회]" + API_CODE_REMAINCNT_LACK_MSG);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd", Locale.KOREAN);
		String today = df.format(cal.getTime());
		if ((book.getUseStaYmd() != null && today.compareTo(book.getUseStaYmd()) < 0)
				|| (book.getUseEndYmd() != null && today.compareTo(book.getUseEndYmd()) > 0)) {
			throw new EzApiException(API_CODE_INVALID_PERIOD,
					"[사용가능기간-(" + book.getUseStaYmd() + "-" + book.getUseEndYmd() + ")]" + API_CODE_INVALID_PERIOD_MSG);
		}

		if (Utilities.isNotEmpty(book.getStorNo()) && !book.getStorNo().equals(param.getStorNo())) {
			throw new EzApiException(API_CODE_STORE_NOT_MATCH, "[발급매장(" + book.getStorNo() + ") : 사용매장("
					+ param.getStorNo() + ")]" + API_CODE_STORE_NOT_MATCH_MSG);

		}
//		String master = book.getMshipCoupnBasNo();

		return book;
	}

	public CrmCouponBookVo updateValidate(CrmCouponBookVo param) throws Exception {
		return validateApprove(param);

	}

	public int updateApprove(CrmCouponBookVo vo) throws Exception {
		CrmCouponBookVo book = validateApprove(vo);
		List<CrmCouponVo> list = book.getCouponList();
		int applyCnt = vo.getApplyCnt();
		for (int i = list.size() - 1; i >= 0 && applyCnt > 0; i--) {
			CrmCouponVo coupon = list.get(i);
			coupon.setStorNo(vo.getStorNo());
			if ("Y".equals(coupon.getUseYn()))
				continue;
			couponDao.updateApprove(coupon);
			applyCnt--;

		}
		return vo.getApplyCnt();
	}

	public int updateCancel(CrmCouponBookVo param) throws Exception {
		if (param.getApplyCnt() == null || param.getApplyCnt() < 1)
			throw new EzApiException(API_CODE_APPLYCNT_INVALID, API_CODE_APPLYCNT_INVALID_MSG);

		CrmCouponBookVo book = getBookInfo(param);
		if (book == null) {
			throw new EzApiException(API_CODE_BOOK_NOT_FOUND, API_CODE_BOOK_NOT_FOUND_MSG);
		}

		int applyCnt = param.getApplyCnt();
		if (book.getUseCnt() < applyCnt)
			throw new EzApiException(API_CODE_USECNT_LACK,
					"[사용횟수 " + book.getUseCnt() + "회]" + API_CODE_USECNT_LACK_MSG);
		List<CrmCouponVo> list = book.getCouponList();

		for (int i = 0; i < list.size() && applyCnt > 0; i++) {
			CrmCouponVo coupon = list.get(i);
			if (!"Y".equals(coupon.getUseYn()))
				continue;
			couponDao.updateCancel(coupon);
			applyCnt--;

		}
		return param.getApplyCnt();
	}

	public CrmCouponBookVo getBookInfo(Object vo) throws Exception {
		CrmCouponBookVo book = get(vo);
		if (book == null)
			throw new EzApiException(API_CODE_BOOK_NOT_FOUND, API_CODE_BOOK_NOT_FOUND_MSG);
		CrmCouponSo s = new CrmCouponSo();
		s.setBookYn("Y");
		s.setCoupnBookHstSeq(book.getCoupnBookHstSeq());
		List<CrmCouponVo> list = couponService.getList(s);
		book.setCouponList(list);
		return book;
	}

}
