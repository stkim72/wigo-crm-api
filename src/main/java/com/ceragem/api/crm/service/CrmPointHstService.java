package com.ceragem.api.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractCrmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.dao.CrmCustBasDao;
import com.ceragem.api.crm.dao.CrmMshipPlcyBasDao;
import com.ceragem.api.crm.dao.CrmPointGodsHstDao;
import com.ceragem.api.crm.dao.CrmPointHstDao;
import com.ceragem.api.crm.dao.CrmPointUseRelDao;
import com.ceragem.api.crm.dao.ICrmDao;
import com.ceragem.api.crm.model.CrmAdvncmtHstVo;
import com.ceragem.api.crm.model.CrmCustSo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.model.CrmMshipPlcyBasVo;
import com.ceragem.api.crm.model.CrmPointHstSo;
import com.ceragem.api.crm.model.CrmPointHstVo;
import com.ceragem.api.crm.model.CrmPointInfoVo;
import com.ceragem.api.crm.model.CrmPointItemVo;
import com.ceragem.api.crm.model.CrmPointUseRelVo;
import com.ceragem.api.crm.model.CrmPointVo;
import com.ceragem.crm.common.model.EzApiException;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName CrmPointHstService
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM포인트 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Service
public class CrmPointHstService extends AbstractCrmService {

	public final static String POINT_010 = "010"; /* 웰카페 체험추천 */
	public final static String POINT_020 = "020"; /* 홈체험 추천 */
	public final static String POINT_030 = "030"; /* 멤버십 가입 추천 */
	public final static String POINT_040 = "040"; /* 웰카페 체험 */
	public final static String POINT_050 = "050"; /* 홈체험 */
	public final static String POINT_060 = "060"; /* 멤버십회원 가입 */
	public final static String POINT_070 = "070"; /* 마케팅정보 수신동의 */
	public final static String POINT_080 = "080"; /* 앱 다운로드 */
	public final static String POINT_090 = "090"; /* 추가 정보 입력 */
	public final static String POINT_100 = "100"; /* 생일 */
	public final static String POINT_110 = "110"; /* 휴면방지 */
	public final static String POINT_120 = "120"; /* 휴면해제 */
	public final static String POINT_130 = "130"; /* 출석체크 */
	public final static String POINT_140 = "140"; /* 텍스트 후기 작성 */
	public final static String POINT_150 = "150"; /* 이미지 후기 작성 */
	public final static String POINT_160 = "160"; /* 동영상 후기 작성 */
	public final static String POINT_170 = "170"; /* 세라체크 */
	public final static String POINT_180 = "180"; /* 서베이 */
	public final static String POINT_190 = "190"; /* IoT */
	public final static String POINT_901 = "901"; /* 구매적립 */
	public final static String POINT_902 = "902"; /* 구매추천적립 */

	public final static String ADVNCMT_901 = "901"; /* 구매승급점수 */
	public final static String ADVNCMT_902 = "902"; /* 구매추천승급점수 */

	public final static String API_CODE_NO_POINT = "IAR0501";
	public final static String API_CODE_NO_POINT_MSG = "해당 포인트가 존재하지 않습니다.";

	public final static String API_CODE_EXCEED_POINT = "IAR0502";
	public final static String API_CODE_EXCEED_POINT_MSG = "포인트 적립한도를 초과했습니다.";

	public final static String API_CODE_EXIST_POINT = "IAR0503";
	public final static String API_CODE_EXIST_POINT_MSG = "이미 적립/사용한 포인트 입니다.";
	public final static String API_CODE_EXIST_CANCEL_MSG = "이미 취소한 포인트 입니다.";

	public final static String API_CODE_LACK_POINT = "IAR0504";
	public final static String API_CODE_LACK_POINT_MSG = "보유포인트가 부족합니다.";

	public final static String API_CODE_SAME_USER = "IAR0505";
	public final static String API_CODE_SAME_USER_MSG = "자신한테 포인트를 선물 할 수는 없습니다.";

	public final static String API_CODE_INVALID_USE_TYPE = "IAR0506";
	public final static String API_CODE_INVALID_USE_TYPE_MSG = "잘못된 사용 유형[useTypeCd] 입니다.";

	public final static String API_CODE_INVALID_CANCEL_TYPE = "IAR0507";
	public final static String API_CODE_INVALID_CANCEL_TYPE_MSG = "사용/적립과 취소를 동시에 적용할 수는 없습니다.";

	public final static String API_CODE_LMT_POINT = "IAR0508";
	public final static String API_CODE_LMT_POINT_MSG = "[OccurPointScore = 0] 적립/사용 포인트는 0일수 없습니다.";

	public final static String API_CODE_TODAY_POINT = "IAR0509";
	public final static String API_CODE_TODAY_POINT_MSG = "1일 적립 포인트 한도를 초과했습니다.";

	public final static String API_CODE_MEMSHIP_PLCY = "IAR0510";
	public final static String API_CODE_MEMSHIP_PLCY_MSG = "해당하는 멤버십 정책이 없습니다.";

	public final static String API_CODE_POINT_PLCY = "IAR0511";
	public final static String API_CODE_POINT_PLCY_MSG = "이벤트 포인트 정책이 없습니다.";

	public final static String API_CODE_POINT_ZERO = "IAR0512";
	public final static String API_CODE_POINT_ZERO_MSG = "[occurPointScore = 0] 사용할 포인트를 입력하세요.";

	public final static String USE_TYPE_WITHDRAWAL = "001";
	public final static String USE_TYPE_DEPOSIT = "002";
	public final static String USE_TYPE_CANCEL = "003";

	public final static String POINT_TYPE_GIFT = "101";

	@Autowired
	CrmPointHstService crmPointHstService;

	@Autowired
	CrmPointHstDao dao;

	@Autowired
	CrmPointUseRelDao relDao;

	@Autowired
	CrmCustBasDao custDao;

	@Autowired
	CrmMshipPlcyBasDao plcyDao;

	@Autowired
	CrmMshipPlcyBasService plcyBasService;

	@Autowired
	CrmPointGodsHstDao pointGodsHstDao;

	@Autowired
	CrmPointGodsHstService pointGodsHstService;

	@Autowired
	CrmAdvncmtHstService advnCmtHstService;

	@Autowired
	EonMessageService messageService;

	@Autowired
	CrmCustService custService;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @return
	 * @description 통합고객검색
	 *
	 */
	private CrmCustVo getCustVo(CrmPointHstVo vo) {
		CrmCustSo so = new CrmCustSo();
		so.setItgCustNo(vo.getItgCustNo());
		CrmCustVo custVo = custDao.select(so);
		if (custVo == null || Constants._USER_STATUS_DELETE.equals(custVo.getCustStatusCd()))
			throw new EzApiException(Constants._API_CODE_NO_USER,
					"[" + vo.getItgCustNo() + "] " + Constants._API_CODE_NO_USER_MSG);
		if (Constants._USER_STATUS_DELETE.equals(custVo.getCustStatusCd()))
			throw new EzApiException(Constants._API_CODE_NO_USER, Constants._API_CODE_NO_USER_MSG);
		return custVo;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param so
	 * @return
	 * @throws Exception
	 * @description 포인트 목록 검색
	 *
	 */
	public List<CrmPointHstVo> getPointList(CrmPointHstSo so) throws Exception {
		so.setRecordCountPerPage(10000);
		List<CrmPointHstVo> list = getList(so);
		return list;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param so
	 * @param useType
	 * @return
	 * @throws Exception
	 * @description 유형에 맞츤 포인트 검색(전표)
	 *
	 */
	public CrmPointHstVo getPoint(CrmPointHstSo so, String useType) throws Exception {
//		so.setUseTypeCd(useType);
		List<CrmPointHstVo> list = getPointList(so);
		if (Utilities.isEmpty(list))
			return null;
		for (int i = 0; i < list.size(); i++) {
			CrmPointHstVo hst = list.get(i);
			if (!USE_TYPE_CANCEL.equals(useType) && hst.getUseTypeCd().equals(USE_TYPE_CANCEL))
				throw new EzApiException(API_CODE_EXIST_POINT, API_CODE_EXIST_CANCEL_MSG);
//				return null;
			if (hst.getUseTypeCd().equals(useType))
				return hst;
		}
		return null;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 고객별 포인트 보유현황
	 *
	 */
	public CrmPointInfoVo getPointInfo(Object vo) throws Exception {
		CrmPointInfoVo info = dao.selectPointInfo(vo);
		return info;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 포인트 적립
	 *
	 */
	public CrmPointInfoVo saveDeposit(CrmPointHstVo vo) throws Exception {

		CrmPointHstSo so = new CrmPointHstSo();
		so.setChitNo(vo.getChitNo());
		so.setPblsChlCd(vo.getPblsChlCd());
		so.setItgCustNo(vo.getItgCustNo());
		CrmPointHstVo point = getPoint(so, USE_TYPE_DEPOSIT);
		if (point != null) {
			throw new EzApiException(API_CODE_EXIST_POINT, API_CODE_EXIST_POINT_MSG);
		}

		CrmPointInfoVo info = dao.selectPointInfo(vo);
		int score = vo.getOccurPointScore();

		info.setTotalPoint(info.getTotalPoint() + score);
		info.setAvailablePoint(info.getAvailablePoint() + score);
		info.setItgCustNo(vo.getItgCustNo());

		if (Utilities.isEmpty(vo.getUseTypeCd()))
			vo.setUseTypeCd(USE_TYPE_DEPOSIT);

		vo.setRemainPointScore(info.getAvailablePoint());

		insert(vo);
		insertDepositHst(vo);
		info = dao.selectPointInfo(vo);
		info.setOccurPointScore(vo.getOccurPointScore());
		updateRemainPoint(info);
		if (!"N".equals(vo.getMessageYn()))
			messageService.sendAsyncPointMessage(vo.getItgCustNo(), vo.getOccurPointScore(),
					Constants._TALK_CODE_POINT_DEPOSIT, vo.getStorNo(), "B".equals(vo.getMessageYn()));
		return info;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 포인트 적립
	 *
	 */
	public CrmPointInfoVo saveBuyDeposit(CrmPointHstVo vo) throws Exception {

		CrmPointHstSo so = new CrmPointHstSo();
		so.setChitNo(vo.getChitNo());
		so.setPblsChlCd(vo.getPblsChlCd());
		so.setItgCustNo(vo.getItgCustNo());

		// 추천인 지급 체크
		if ("Y".equals(vo.getRcmdYn())) {
			so.setItgCustNo(vo.getRcmdrCustNo());
		}

		CrmPointHstVo point = getPoint(so, USE_TYPE_DEPOSIT);

		if (point != null) {
			throw new EzApiException(API_CODE_EXIST_POINT, API_CODE_EXIST_POINT_MSG);
		}

		checkDepositPolicy(vo);

		// 05.20 김은성 멤버십 정책 추가
		CrmMshipPlcyBasVo plcyVo = new CrmMshipPlcyBasVo();
		plcyVo.setItgCustNo(vo.getItgCustNo()); // 통합고객번호
		plcyVo.setStorNo(vo.getStorNo()); // 매장코드
		plcyVo.setChitNo(vo.getChitNo()); // 전표번호
		plcyVo.setAccumYn(vo.getAccumYn()); // 적립여부
		plcyVo.setBuyGodsNo(vo.getBuyGodsNo()); // 구매상품코드
		plcyVo.setPblsDivCd(vo.getPblsDivCd()); // 쿠폰종류코드
		plcyVo.setStatusCd("Y"); // 사용유무

//		String div = 
		Utilities.nullCheck(vo.getPblsDivCd());

		// 정책을 불러온다.
		CrmMshipPlcyBasVo plcyInfo = plcyDao.selectPlcyInfo(plcyVo);

		// 해당 정책이 없다면
		if (plcyInfo == null || "".equals(plcyInfo.getMshipPlcyBasNo())) {
			vo.setOccurPointScore(0);
			vo.setPlcyChkSatus(API_CODE_MEMSHIP_PLCY);
			throw new EzApiException(API_CODE_MEMSHIP_PLCY, API_CODE_MEMSHIP_PLCY_MSG);
		}

		vo.setUseTypeCd(USE_TYPE_DEPOSIT); // 적립코드

		plcyInfo.setPblsDivCd(vo.getPblsDivCd());
		vo.setAccumLmtPointScore(plcyInfo.getAccumLmtPointScore()); // 1일 적립한도
		vo.setTodayPblsPnt(plcyInfo.getTodayPblsPnt()); // 1일 회원 적립 포인트

		// 추천인 지급 체크
		if ("Y".equals(vo.getRcmdYn())) {
			vo.setItgCustNo(vo.getRcmdrCustNo());
		}

		CrmPointInfoVo info = dao.selectPointInfo(vo);

		int score = Math.abs(vo.getOccurPointScore());

		// 지급 횟수 정책에 맞지않으면 오류
		if (vo.getOccurPointScore() == 0 || vo.getOccurPointScore() == null) {
			throw new EzApiException(API_CODE_LMT_POINT, API_CODE_LMT_POINT_MSG);
		}

		// 1일적립한도 < 1일 고객적립금액이 클 경우 남머지 포인트만 적립
		if (vo.getAccumLmtPointScore() < (vo.getTodayPblsPnt() + vo.getOccurPointScore())) {
			if (vo.getAccumLmtPointScore() < vo.getTodayPblsPnt()) {
				score = 0;
			} else {
				score = vo.getAccumLmtPointScore() - vo.getTodayPblsPnt();
			}
		}

		// 1일 적립한도 초과시 오류
//		if (vo.getAccumLmtPointScore() < (vo.getTodayPblsPnt() + vo.getOccurPointScore())) {
		// throw new EzApiException(API_CODE_TODAY_POINT, API_CODE_TODAY_POINT_MSG);
//		}
//		if(score == 0) {
//		return info;
//	}
		// 1일 적립금액의 남은 금액 계산 후 저장
		vo.setOccurPointScore(score);

		info.setTotalPoint(info.getTotalPoint() + score);
		info.setAvailablePoint(info.getAvailablePoint() + score);
		info.setItgCustNo(vo.getItgCustNo());

		if (Utilities.isEmpty(vo.getUseTypeCd()))
			vo.setUseTypeCd(USE_TYPE_DEPOSIT);

		vo.setRemainPointScore(info.getAvailablePoint());

		insert(vo);
		insertDepositHst(vo);
		info = dao.selectPointInfo(vo);
		info.setOccurPointScore(vo.getOccurPointScore());
		updateRemainPoint(info);
		return info;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @description 포인트 사용정책 검증
	 *
	 */
	private void checkWithdrawalPolicy(CrmPointHstVo vo) {
		int maxPoint = vo.getRemainPointScore();
		int score = Math.abs(vo.getOccurPointScore());

		if (maxPoint < score) {
			throw new EzApiException(API_CODE_LACK_POINT,
					"[보유포인트 : " + maxPoint + ", 사용포인트 : " + score + "]" + API_CODE_LACK_POINT_MSG);
		}

		String div = vo.getPblsDivCd();
		switch (div) {
		case POINT_010: /* 웰카페 체험추천 */
		case POINT_020: /* 홈체험 추천 */
		case POINT_030: /* 멤버십 가입 추천 */
		case POINT_040: /* 웰카페 체험 */
		case POINT_050: /* 홈체험 */
		case POINT_060: /* 멤버십회원 가입 */
		case POINT_070: /* 마케팅정보 수신동의 */
		case POINT_080: /* 앱 다운로드 */
		case POINT_090: /* 추가 정보 입력 */
		case POINT_100: /* 생일 */
		case POINT_110: /* 휴면방지 */
		case POINT_120: /* 휴면해제 */
		case POINT_130: /* 출석체크 */
		case POINT_140: /* 텍스트 후기 작성 */
		case POINT_150: /* 이미지 후기 작성 */
		case POINT_160: /* 동영상 후기 작성 */
		case POINT_170: /* 세라체크 */
		case POINT_180: /* 서베이 */
		case POINT_190: /* IoT */
		case POINT_901: /* 구매 */
		default:
			break;
		}

	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @description 포인트 적립정책 검증
	 *
	 */
	private void checkDepositPolicy(CrmPointHstVo vo) {

		CrmCustVo custVo = getCustVo(vo);
		int maxPoint = custVo.getAccumPointLmtScore() == null ? 0 : custVo.getAccumPointLmtScore();
		int score = Math.abs(vo.getOccurPointScore());
		if (maxPoint > 0 && maxPoint < score) {
			int offset = score - maxPoint;
			if (offset >= score)
				throw new EzApiException(API_CODE_EXCEED_POINT, API_CODE_EXCEED_POINT_MSG);
			vo.setOccurPointScore(score - offset);
		}
		// vo.setMshipGradeCd(custVo.getMshipGradeCd());

	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @description 포인트 취소정책 검증
	 *
	 */
	private void checkCancelPolicy(CrmPointHstVo vo) {
		String div = vo.getPblsDivCd();
		switch (div) {
		case POINT_010: /* 웰카페 체험추천 */
		case POINT_020: /* 홈체험 추천 */
		case POINT_030: /* 멤버십 가입 추천 */
		case POINT_040: /* 웰카페 체험 */
		case POINT_050: /* 홈체험 */
		case POINT_060: /* 멤버십회원 가입 */
		case POINT_070: /* 마케팅정보 수신동의 */
		case POINT_080: /* 앱 다운로드 */
		case POINT_090: /* 추가 정보 입력 */
		case POINT_100: /* 생일 */
		case POINT_110: /* 휴면방지 */
		case POINT_120: /* 휴면해제 */
		case POINT_130: /* 출석체크 */
		case POINT_140: /* 텍스트 후기 작성 */
		case POINT_150: /* 이미지 후기 작성 */
		case POINT_160: /* 동영상 후기 작성 */
		case POINT_170: /* 세라체크 */
		case POINT_180: /* 서베이 */
		case POINT_190: /* IoT */
		case POINT_901: /* 구매 */
		default:
			break;
		}

	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param info
	 * @return
	 * @throws Exception
	 * @description 통합회원정보의 잔여포인트 업데이트
	 *
	 */
	public int updateRemainPoint(CrmPointInfoVo info) throws Exception {
		CrmCustVo vo = new CrmCustVo();
		vo.setItgCustNo(info.getItgCustNo());
//		vo.setRemainPointScore(info.getTotalPoint());
		vo.setRemainPointScore(info.getAvailablePoint());
		return custDao.updateRemainPoint(vo);
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 포인트 사용처리
	 *
	 */
	public CrmPointInfoVo saveWithdrawal(CrmPointHstVo vo) throws Exception {
		CrmCustVo custVo = getCustVo(vo);

		CrmPointHstSo so = new CrmPointHstSo();
		so.setChitNo(vo.getChitNo());
		so.setPblsChlCd(vo.getPblsChlCd());
		so.setItgCustNo(vo.getItgCustNo());
		CrmPointHstVo point = getPoint(so, USE_TYPE_WITHDRAWAL);
		if (point != null && USE_TYPE_WITHDRAWAL.equals(point.getUseTypeCd())) {
			throw new EzApiException(API_CODE_EXIST_POINT, API_CODE_EXIST_POINT_MSG);
		}

		CrmPointInfoVo info = dao.selectPointInfo(vo);
		if (vo.getOccurPointScore() == null || vo.getOccurPointScore() == 0) {
			throw new EzApiException(API_CODE_POINT_ZERO, API_CODE_POINT_ZERO_MSG);
		}
		int score = Math.abs(vo.getOccurPointScore());
		vo.setRemainPointScore(info.getAvailablePoint());
		checkWithdrawalPolicy(vo);

		info.setTotalPoint(info.getTotalPoint() - score);
		info.setAvailablePoint(info.getAvailablePoint() - score);
		info.setItgCustNo(vo.getItgCustNo());
		if (Utilities.isEmpty(vo.getUseTypeCd()))
			vo.setUseTypeCd(USE_TYPE_WITHDRAWAL);
		vo.setMshipGradeCd(custVo.getMshipGradeCd());
		if (score > 0)
			vo.setOccurPointScore(score * -1);
		vo.setRemainPointScore(info.getAvailablePoint());

		crmPointHstService.insert(vo);

		insertUseHst(vo);
		vo.setOccurPointScore(score);
		info = dao.selectPointInfo(vo);
		info.setOccurPointScore(vo.getOccurPointScore());
		updateRemainPoint(info);
		messageService.sendAsyncPointMessage(vo.getItgCustNo(), vo.getOccurPointScore(),
				Constants._TALK_CODE_POINT_WITHDRAWAL, vo.getStorNo(), "B".equals(vo.getMessageYn()));
		return info;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 포인트사용시 적용된 발급포인트 저장
	 *
	 */
	private int insertUseHst(CrmPointHstVo vo) throws Exception {

		int cnt = 0;
		int score = vo.getOccurPointScore();
		if (score < 0)
			score *= -1;
		List<CrmPointHstVo> list = dao.selectAvailableList(vo);
		if (Utilities.isEmpty(list)) {
			if (USE_TYPE_CANCEL.equals(vo.getUseTypeCd()))
				return score;
			throw new EzApiException(API_CODE_LACK_POINT, API_CODE_LACK_POINT_MSG);
		}
		for (int i = 0; i < list.size(); i++) {
			CrmPointHstVo pt = list.get(i);
			int av = pt.getAvailableScore();
			score -= av;
			if (score >= 0) {
				CrmPointUseRelVo rel = new CrmPointUseRelVo();
				rel.setOccurPointHstSeq(pt.getPointHstSeq());
				rel.setUsePointHstSeq(vo.getPointHstSeq());
				rel.setUsePointScore(av);
				relDao.insert(rel);
				cnt++;
				dao.updateExtncDt(pt);
				if (score == 0)
					break;

				continue;

			} else {
				CrmPointUseRelVo rel = new CrmPointUseRelVo();
				rel.setOccurPointHstSeq(pt.getPointHstSeq());
				rel.setUsePointHstSeq(vo.getPointHstSeq());
				rel.setUsePointScore(av + score);
				relDao.insert(rel);
				cnt++;

				if (score == 0) {
					dao.updateExtncDt(vo);
				}
				break;
			}
		}

		return cnt;
	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 포인트 적립시 미수포인트 사용처리
	 *
	 */
	public int insertDepositHst(CrmPointHstVo vo) throws Exception {
		try {
			List<CrmPointHstVo> list = dao.selectDebtList(vo);
			for (int i = 0; i < list.size(); i++) {
				CrmPointHstVo pt = list.get(i);
				int oc = pt.getOccurPointScore() + pt.getUsePointScore();
				if (oc > 0)
					continue;
				pt.setOccurPointScore(oc);
				int score = insertUseHst(pt);
				if (score != 0)
					break;
			}
		} catch (Exception ex) {
			log.debug(ex.getMessage());
		}
		return 0;

	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 포인트 취소처리
	 *
	 */
	public CrmPointInfoVo saveCancel(CrmPointHstVo vo) throws Exception {

		CrmPointHstSo so = new CrmPointHstSo();
		so.setChitNo(vo.getChitNo());
		so.setPblsChlCd(vo.getPblsChlCd());
		List<CrmPointHstVo> list = getPointList(so);
		if (Utilities.isEmpty(list))
			throw new EzApiException(API_CODE_NO_POINT, API_CODE_NO_POINT_MSG);
		List<CrmPointHstVo> arr = new ArrayList<>();
		int totalPoint = 0;

		for (int i = 0; i < list.size(); i++) {

			CrmPointHstVo pt = list.get(i);
			if (pt.getUseTypeCd().equals(USE_TYPE_CANCEL))
				throw new EzApiException(API_CODE_EXIST_POINT, API_CODE_EXIST_CANCEL_MSG);
			vo.setItgCustNo(pt.getItgCustNo());
			totalPoint += pt.getOccurPointScore();

			arr.add(pt);
		}

		if (arr.size() == 0) {
			throw new EzApiException(API_CODE_EXIST_POINT, API_CODE_EXIST_CANCEL_MSG);
		}

		totalPoint *= -1;
		CrmPointInfoVo info = dao.selectPointInfo(vo);

		CrmPointHstVo point = list.get(0);
		point.setChitNo(vo.getChitNo());
		point.setPblsChlCd(vo.getPblsChlCd());
		point.setUseTypeCd(USE_TYPE_CANCEL);
		point.setOccurPointScore(totalPoint);
		point.setUseDt(null);
		point.setAmdDt(null);
		point.setAmdrId(null);
		point.setRegDt(null);
		point.setRegrId(null);
		point.setExtncDt(null);
		point.setValidPerdStaYmd(null);
		point.setValidPerdEndYmd(null);
		point.setRemainPointScore(info.getTotalPoint() + totalPoint);
		checkCancelPolicy(point);
		crmPointHstService.insert(point);

		if (totalPoint < 0) {
			// 사용처리
			insertUseHst(point);

		} else if (totalPoint > 0) {
			insertDepositHst(point);
		}
		info = dao.selectPointInfo(vo);
		updateRemainPoint(info);
		info.setOccurPointScore(totalPoint);

		messageService.sendAsyncPointMessage(vo.getItgCustNo(), totalPoint, Constants._TALK_CODE_POINT_CANCEL,
				vo.getStorNo(), false);
		return info;
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 09. 29.
	 * @param vo
	 * @param fromItgCustNo
	 * @param toItgCustNo
	 * @return
	 * @throws Exception
	 * @description 승급점수 취소처리 - 포인트 유무와 상관없이 처리
	 *
	 */
	public void cancelAdvnCmt(CrmPointHstVo vo) throws Exception {

		// 2022.09.29 추가 승급점수 - 취소처리
		// 2022.10.17 구매자와 추천자의 승급점수 모두 취소 처리 추가
		List<CrmAdvncmtHstVo> arrAdvnInfo = advnCmtHstService.selectAdvnCmt(vo);
		if (arrAdvnInfo != null) {

			// N 인 경우만 취소 처리
			CrmAdvncmtHstVo advnInfo = null;
			for (int i = 0; i < arrAdvnInfo.size(); i++) {

				if ("N".equals(arrAdvnInfo.get(i).getCancelYn())) {
					advnInfo = arrAdvnInfo.get(i);
					advnInfo.setAdvncmtHstSeq(null);
					advnInfo.setOrgChitNo(advnInfo.getChitNo());
					advnInfo.setChitNo(advnInfo.getChitNo());
					if (advnInfo.getOrdrAmt() != null)
						advnInfo.setOrdrAmt(advnInfo.getOrdrAmt() * -1);
					if (advnInfo.getApplyAmt() != null)
						advnInfo.setApplyAmt(advnInfo.getApplyAmt() * -1);
					if (advnInfo.getPayAmt() != null)
						advnInfo.setPayAmt(advnInfo.getPayAmt() * -1);
					advnInfo.setRemainAdvncmtScore(advnInfo.getTotalAdvnCmt() - advnInfo.getOccurAdvncmtScore());
					advnInfo.setOccurAdvncmtScore(advnInfo.getOccurAdvncmtScore() * -1);
					advnCmtHstService.insertAdVnCmt(advnInfo);

				}
			}

		}

	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param vo
	 * @param fromItgCustNo
	 * @param toItgCustNo
	 * @return
	 * @throws Exception
	 * @description 포인트 선물하기
	 *
	 */
	public CrmPointInfoVo saveGiftPoint(CrmPointHstVo vo, String fromItgCustNo, String toItgCustNo) throws Exception {
		if (fromItgCustNo.equals(toItgCustNo))
			throw new EzApiException(API_CODE_SAME_USER, API_CODE_SAME_USER_MSG);
		int point = vo.getOccurPointScore();
		String id = Utilities.getAutoSeq("PTG");
		vo.setChitNo(id);
		vo.setPblsChlCd(Utilities.getSystemCd());
		vo.setUseTypeCd(USE_TYPE_WITHDRAWAL);
		vo.setItgCustNo(fromItgCustNo);
		vo.setPblsDivCd(POINT_TYPE_GIFT);
		vo.setOccurPointScore(point);

		CrmPointInfoVo info = saveWithdrawal(vo);
		vo.setUseTypeCd(USE_TYPE_DEPOSIT);
		vo.setItgCustNo(toItgCustNo);
		vo.setPblsDivCd(POINT_TYPE_GIFT);
		vo.setOccurPointScore(point);
		saveDeposit(vo);
		return info;
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 5. 4.
	 * @param vo
	 * @param fromItgCustNo
	 * @param toItgCustNo
	 * @return
	 * @throws Exception
	 * @description 구매 적립 상품 히스토리 저장
	 *
	 */
	public void saveBuyGodsList(CrmPointHstVo vo, String pblsDivCd) throws Exception {

		// 제품 포인트 히스토리 작성
		if (vo.getCrmPointHsItemList().size() > 0) {

			for (int i = 0; i < vo.getCrmPointHsItemList().size(); i++) {

				// 추천인 일 경우 - 통합회원 번호를 추천인 코드로 변경한다.
				if (pblsDivCd.equals(POINT_902)) {
					vo.getCrmPointHsItemList().get(i).setPblsDivCd(POINT_902);
					vo.getCrmPointHsItemList().get(i).setItgCustNo(vo.getCrmPointHsItemList().get(i).getRcmdrCustNo());
				} else {
					vo.getCrmPointHsItemList().get(i).setPblsDivCd(pblsDivCd);
				}

			}

			pointGodsHstService.insertList(vo.getCrmPointHsItemList());

		}

	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 5. 3.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 포스용 포인트 계산
	 *
	 */
	public CrmPointInfoVo savePosPoint(CrmPointVo vo) throws Exception {
//		List<CrmPointItemVo> itemList = vo.getItemList();
		CrmCustSo so = Utilities.beanToBean(vo, CrmCustSo.class);
		CrmCustVo custVo = custDao.select(so);
		if (custVo == null || Constants._USER_STATUS_DELETE.equals(custVo.getCustStatusCd()))
			throw new EzApiException(Constants._API_CODE_NO_USER,
					"[" + vo.getItgCustNo() + "] " + Constants._API_CODE_NO_USER_MSG);

		// 회원등급이 일반일 경우 포인트 정책없음
		if ("001".equals(custVo.getMshipGradeCd())) {
			throw new EzApiException(Constants._API_CODE_NO_USETYPE, Constants._API_CODE_NO_USETYPE_MSG);
		}

		// 2022.10.17 추가
		// 이미 사용한 전표 번호인지 체크한다. 에러를 발생시킴 안됨~~!!!
		// null 일 경우 사용안 한 전표임
		CrmPointHstVo existChitChk = dao.selectChitNoChk(vo);
		if (existChitChk != null) {
			log.debug("#### 이미 사용된 전표번호 입니다. ####");
			return dao.selectPointInfo(vo);
		}

		CrmPointHstVo deposit = getBuyPoint(custVo, vo);

		if (deposit.getRegrId() == null)
			deposit.setRegrId("CRM");
		if (deposit.getRegChlCd() == null)
			deposit.setRegChlCd("CRM");

		CrmPointInfoVo info = null;

		// 구매적립 포인트 점수 등록
		if (deposit.getBuyAccumPointScore() > 0) {

			deposit.setItgCustNo(deposit.getItgCustNo());
			deposit.setPblsDivCd(POINT_901); // 구매포인트
			deposit.setOccurPointScore(deposit.getBuyAccumPointScore());
			deposit.setAccumYn(deposit.getAccumYn());
			deposit.setMshipGradeCd(custVo.getMshipGradeCd());
			deposit.setValidPerdStaYmd(null);
			deposit.setValidPerdEndYmd(null);

			info = saveBuyDeposit(deposit);
			saveBuyGodsList(deposit, POINT_901);

		}

		// 구매보상 승금점수 등록
		if (deposit.getBuyRewardAdvncmtScore() > 0) {

			deposit.setMshipGradeCd(custVo.getMshipGradeCd());
			deposit.setPblsDivCd(ADVNCMT_901);
			deposit.setItgCustNo(custVo.getItgCustNo());
			deposit.setAccumYn(deposit.getAccumYn());
			deposit.setOccurAdvncmtScore(deposit.getBuyRewardAdvncmtScore());
			deposit.setValidPerdStaYmd(null);
			deposit.setValidPerdEndYmd(null);
			deposit.setOrgChitNo(null);
			advnCmtHstService.insertAdVnCmt(deposit);

		}

		// 구매추천 포인트 점수 등록
		// 추천인이 있을 경우 처리
		String orgChitNo = deposit.getChitNo();
		CrmCustVo custVo2 = null;

		
		// 22.10.18 0원이더라도 추천이력을 찍어준다
		if (!"".equals(deposit.getRcmdrCustNo()) && deposit.getRcmdrCustNo() != null) {

			// 추천 히스토리 작성
			custVo2 = new CrmCustVo();
			custVo2.setItgCustNo(deposit.getItgCustNo());
			custVo2.setRcmdrCustNo(deposit.getRcmdrCustNo());
			custVo2.setEventCd(POINT_902);
			custVo2.setPblsChlCd(deposit.getPblsChlCd());

			custVo2.setRegChlCd(vo.getRegChlCd());
			custVo2.setRcmdrCustNo(vo.getRcmdrCustNo());
			// custVo2.setRcmdStorNo( vo.getStorNo() );
			custVo2.setPblsChlCd(vo.getPblsChlCd());

			custService.saveRcmdHst(custVo2);
		}

		// 22.10.18 0원이더라도 추천을 찍어준다
		if (deposit.getBuyRcmdPointScore() > 0 && !"".equals(deposit.getRcmdrCustNo())
				&& deposit.getRcmdrCustNo() != null) {

			deposit.setRcmdYn("Y");
			// deposit.setItgCustNo( deposit.getRcmdrCustNo() );
			deposit.setPblsDivCd(POINT_902); // 구매추천포인트
			deposit.setOccurPointScore(deposit.getBuyRcmdPointScore());
			deposit.setAccumYn(deposit.getAccumYn());
			deposit.setMshipGradeCd(deposit.getRcmdrMshipGradeCd());
			deposit.setValidPerdStaYmd(null);
			deposit.setValidPerdEndYmd(null);

			deposit.setOrgChitNo(orgChitNo);
			deposit.setChitNo(Utilities.getAutoSeq("CHT"));
//
//			// 추천 히스토리 작성
//			custVo2 = new CrmCustVo();
//			custVo2.setItgCustNo(deposit.getItgCustNo());
//			custVo2.setRcmdrCustNo(deposit.getRcmdrCustNo());
//			custVo2.setEventCd(POINT_902);
//			custVo2.setPblsChlCd(deposit.getPblsChlCd());
//
//			custVo2.setRegChlCd(vo.getRegChlCd());
//			custVo2.setRcmdrCustNo(vo.getRcmdrCustNo());
//			// custVo2.setRcmdStorNo( vo.getStorNo() );
//			custVo2.setPblsChlCd(vo.getPblsChlCd());
//
//			custService.saveRcmdHst(custVo2);

			saveBuyDeposit(deposit);
			saveBuyGodsList(deposit, POINT_902);

		}

		// 구매추천 보상승급점수 등록
		if (deposit.getBuyRcmdRewardAdvncmtScore() > 0) {

			deposit.setMshipGradeCd(deposit.getRcmdrMshipGradeCd());
			deposit.setPblsDivCd(ADVNCMT_902);
			deposit.setItgCustNo(deposit.getRcmdrCustNo());
			deposit.setAccumYn(deposit.getAccumYn());
			deposit.setOccurAdvncmtScore(deposit.getBuyRcmdRewardAdvncmtScore());
			deposit.setValidPerdStaYmd(null);
			deposit.setValidPerdEndYmd(null);
			deposit.setOrgChitNo(orgChitNo);

			advnCmtHstService.insertAdVnCmt(deposit);

		}

		if (info == null)
			info = dao.selectPointInfo(vo);
		if (info != null && deposit.getOccurPointScore() != null)
			info.setOccurPointScore(deposit.getOccurPointScore());
		messageService.sendAsyncPointMessage(info.getItgCustNo(), info.getOccurPointScore(),
				Constants._TALK_CODE_POINT_DEPOSIT, vo.getStorNo(), "B".equals(vo.getMessageYn()));

		// 추천인 메세지 전송 kes 추가
		if (deposit.getBuyRcmdPointScore() > 0 && !"".equals(deposit.getRcmdrCustNo())
				&& deposit.getRcmdrCustNo() != null) {

			CrmCustVo cVo = new CrmCustVo();
			cVo.setItgCustNo(info.getItgCustNo());

			CrmCustVo rcmdrVo = custDao.select(cVo);

			if (rcmdrVo != null) {
				String rcmdrCustNm = rcmdrVo.getCustNm();

				messageService.sendPointRcmdrMessage(custVo2.getRcmdrCustNo(), deposit.getBuyRcmdPointScore(),
						Constants._TALK_CODE_POINT_RECOM, vo.getStorNo(), "B".equals(vo.getMessageYn()), rcmdrCustNm);
			}

		}

		return info;
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 4. 29.
	 * @param custVo
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 적립포인트계산
	 *
	 */
	private CrmPointHstVo getBuyPoint(CrmCustVo custVo, CrmPointVo vo) throws Exception {
		CrmPointHstVo hstVo = Utilities.beanToBean(vo, CrmPointHstVo.class);
		hstVo.setUseTypeCd(USE_TYPE_DEPOSIT);
		List<CrmPointItemVo> list = vo.getItemList();
		CrmPointItemVo status = new CrmPointItemVo();

		// 05.20 김은성 멤버십 정책 추가
		CrmMshipPlcyBasVo plcyVo = new CrmMshipPlcyBasVo();
		plcyVo.setItgCustNo(custVo.getItgCustNo()); // 통합고객번호
		plcyVo.setMshipGradeCd(custVo.getMshipTypeCd()); // 멤버십 구분
		plcyVo.setMshpGradeCd(custVo.getMshipGradeCd()); // 회원등급 구분
		plcyVo.setStorNo(vo.getStorNo()); // 매장코드
		plcyVo.setChitNo(vo.getChitNo()); // 전표번호
		// plcyVo.setAccumYn(vo.getAccumYn()); // 적립여부
		// plcyVo.setMshipGradeCd( vo.getRcmdrMshipGradeCd() ); // 구매추천자회원등급
		plcyVo.setStatusCd("Y"); // 사용유무

		CrmMshipPlcyBasVo plcyInfo = null;

		CrmMshipPlcyBasVo plcyInfoRcmd = null;
		CrmMshipPlcyBasVo plcyVoRcmd = new CrmMshipPlcyBasVo();
		plcyVoRcmd.setItgCustNo(custVo.getRcmdrCustNo()); // 통합고객번호
		plcyVoRcmd.setMshipGradeCd(custVo.getMshipTypeCd()); // 멤버십 구분
		plcyVoRcmd.setMshpGradeCd(custVo.getMshipGradeCd()); // 회원등급 구분
		plcyVoRcmd.setStorNo(vo.getStorNo()); // 매장코드
		plcyVoRcmd.setChitNo(vo.getChitNo()); // 전표번호
		plcyVoRcmd.setStatusCd("Y"); // 사용유무

		List<CrmPointItemVo> pointItemList = new ArrayList<CrmPointItemVo>(); // 제품별 발생 포인트 이력 저장
		for (int i = 0; i < list.size(); i++) {

			CrmPointItemVo item = list.get(i);

			Utilities.validate(item);
			// 실제 비용이 0 원일 경우 패스
			if (item.getPayAmt() < 0) {
				continue;
			}

			plcyVo.setAccumYn(item.getAccumYn());

			plcyVo.setBuyGodsNo(item.getBuyGodsNo()); // 구매상품코드
			plcyVo.setChitNo(vo.getChitNo()); // 구매전표번호

			// 2022-08-02
			// 추천인을 직접 받아온걸로 처리형식으로 수정
			plcyVo.setRcmdrCustNo(vo.getRcmdrCustNo());

			// 구매자 정책을 불러온다.
			plcyInfo = plcyDao.selectPlcyInfo(plcyVo);

			// 구매 추천자
			plcyVoRcmd.setItgCustNo(vo.getRcmdrCustNo());
			plcyInfoRcmd = plcyDao.selectPlcyInfo(plcyVoRcmd);

			// 해당 정책이 없다면
			if (plcyInfo == null || "".equals(plcyInfo.getMshipPlcyBasNo())) {
				throw new EzApiException(API_CODE_MEMSHIP_PLCY, API_CODE_MEMSHIP_PLCY_MSG);
			}

			plcyInfo.setChitNo(vo.getChitNo());
			plcyInfo.setItgCustNo(vo.getItgCustNo());

			vo.setRcmdrMshipGradeCd(plcyInfo.getRcmdrMshipGradeCd());

			vo.setAccumLmtPointScore(plcyInfo.getAccumLmtPointScore()); // 1일 적립한도
			vo.setTodayPblsPnt(plcyInfo.getTodayPblsPnt()); // 1일 회원 적립 포인트

			item.setChitNo(plcyVo.getChitNo());
			item.setItgCustNo(plcyVo.getItgCustNo());
			item.setRcmdrCustNo(plcyInfo.getRcmdrCustNo());
			item.setRcmdrMshipGradeCd(plcyInfo.getRcmdrMshipGradeCd());

			status.setAccumYn(item.getAccumYn());

			calcBuyPoint(custVo, item, status, plcyInfo, plcyInfoRcmd);

			pointItemList.add(item);

		}

		hstVo.setRcmdrCustNo(status.getRcmdrCustNo());

		hstVo.setRcmdrMshipGradeCd(plcyInfo.getRcmdrMshipGradeCd());

		int buyAccumPointScore = status.getBuyAccumPointScore();
		int buyRcmdPointScore = status.getBuyRcmdPointScore();
		int buyRewardAdvncmtScore = status.getBuyRewardAdvncmtScore();
		int buyRcmdRewardAdvncmtScore = status.getBuyRcmdRewardAdvncmtScore();

		// 사용포인트가 있을 시
		if (vo.getUsePoint() != null) {

			// 구매자 포인트
			if (buyAccumPointScore > 0) {
				buyAccumPointScore = buyAccumPointScore
						- (int) (vo.getUsePoint() * (plcyInfo.getBuyAccumPointRate() / 100));
				if (buyAccumPointScore < 0)
					buyAccumPointScore = 0;
			}

			// 구매자 승급점수
			if (buyRewardAdvncmtScore > 0) {
				buyRewardAdvncmtScore = buyRewardAdvncmtScore
						- (int) (vo.getUsePoint() * (plcyInfo.getBuyRewardAdvncmtRate() / 100));
				if (buyRewardAdvncmtScore < 0)
					buyRewardAdvncmtScore = 0;
			}

			// 추천자 포인트
			if (buyRcmdPointScore > 0) {
				buyRcmdPointScore = buyRcmdPointScore
						- (int) (vo.getUsePoint() * (plcyInfoRcmd.getBuyRcmdPointRate() / 100));
				if (buyRcmdPointScore < 0)
					buyRcmdPointScore = 0;
			}

			// 추천자 승급점수
			if (buyRcmdRewardAdvncmtScore > 0) {
				buyRcmdRewardAdvncmtScore = buyRcmdRewardAdvncmtScore
						- (int) (vo.getUsePoint() * (plcyInfoRcmd.getBuyRcmdRewardAdvncmtRate() / 100));
				if (buyRcmdRewardAdvncmtScore < 0)
					buyRcmdRewardAdvncmtScore = 0;
			}

		}

		hstVo.setBuyAccumPointScore(buyAccumPointScore);
		hstVo.setBuyRcmdPointScore(buyRcmdPointScore);
		hstVo.setBuyRewardAdvncmtScore(buyRewardAdvncmtScore);
		hstVo.setBuyRcmdRewardAdvncmtScore(buyRcmdRewardAdvncmtScore);

		hstVo.setMshipGradeCd(status.getMshipGradeCd());

		// 구매 제품별 포인트 지급 내역 히스토리
		hstVo.setCrmPointHsItemList(pointItemList);

		hstVo.setOrdrAmt(status.getOrdrAmt());
		hstVo.setPayAmt(status.getPayAmt());
		hstVo.setApplyAmt(status.getApplyAmt());
		hstVo.setAccumYn(status.getAccumYn());

		return hstVo;
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 5. 4.
	 * @param custVo
	 * @param item
	 * @param status
	 * @throws Exception
	 * @description 구매포인트 계산
	 *
	 */
	private void calcBuyPoint(CrmCustVo custVo, CrmPointItemVo item, CrmPointItemVo status, CrmMshipPlcyBasVo plcyInfo,
			CrmMshipPlcyBasVo plcyInfoRcmd) throws Exception {
		if (custVo == null)
			return;
		status.setOrdrAmt(status.getOrdrAmt() + item.getOrdrAmt());
		status.setPayAmt(status.getPayAmt() + item.getPayAmt());
		status.setApplyAmt(status.getApplyAmt() + item.getApplyAmt());
		status.setAccumYn(item.getAccumYn());

		// 적립유무 Y/N
		if (!"Y".equals(item.getAccumYn())) {
			return;
		}

		// 등급별 상품 포인트 계산
		double amt = item.getPayAmt();

		int point = 0;

		List<CrmPointItemVo> pointAllList = new ArrayList<CrmPointItemVo>();
		List<CrmPointItemVo> pointItemList = new ArrayList<CrmPointItemVo>(); // 제품별 발생 포인트 이력 저장
		if (plcyInfo != null) {

			item.setChitNo(plcyInfo.getChitNo()); // 전표번호
			item.setRcmdrCustNo(plcyInfo.getRcmdrCustNo()); // 추천인번호
			item.setRcmdrMshipGradeCd(plcyInfo.getRcmdrMshipGradeCd()); // 추천인번호

			// 구매적립포인트
			point = 0;

			if (plcyInfo.getBuyAccumPointRate() != null) {

				// 제외 상품 또는 제외 매장일 경우
				if (plcyInfo.getMshipGodsChk() > 0 || plcyInfo.getMshipStoreChk() > 0) {
					item.setBuyAccumPointScore(0);
				} else {
					point = (int) (amt * (plcyInfo.getBuyAccumPointRate() / 100));

					if (point < 0)
						point = 0;
					item.setBuyAccumPointScore((int) point);

				}

				status.setBuyAccumPointScore(status.getBuyAccumPointScore() + item.getBuyAccumPointScore());
				status.setRcmdrCustNo(plcyInfo.getItgCustNo());
				status.setMshipGradeCd(plcyInfo.getMshipGradeCd());
				pointAllList.add(status);
				pointItemList.add(item);
			}

			// 구매보상승급점수
			point = 0;
			if (plcyInfo.getBuyRewardAdvncmtRate() != null) {

				// 제외 상품 또는 제외 매장일 경우
				if ((plcyInfo.getMshipGodsChk() > 0 || plcyInfo.getMshipStoreChk() > 0)) {
					item.setBuyRewardAdvncmtScore(0);
				} else {
					point = (int) (amt * (plcyInfo.getBuyRewardAdvncmtRate() / 100));

					if (point < 0)
						point = 0;

					item.setBuyRewardAdvncmtScore((int) point);
				}
				status.setBuyRewardAdvncmtScore(status.getBuyRewardAdvncmtScore() + item.getBuyRewardAdvncmtScore());
				status.setRcmdrCustNo(plcyInfo.getItgCustNo());
				status.setMshipGradeCd(plcyInfo.getMshipGradeCd());
				pointAllList.add(status);
				pointItemList.add(item);
			}

			// 구매추천포인트
			point = 0;
			if (plcyInfoRcmd != null) {

				if (plcyInfoRcmd.getBuyAccumPointRate() != null && plcyInfoRcmd.getItgCustNo() != null) {

					if (plcyInfoRcmd.getMshipGodsChk() > 0 || plcyInfoRcmd.getMshipStoreChk() > 0) {
						item.setBuyRcmdPointScore(0);
					} else {
						point = (int) (amt * (plcyInfoRcmd.getBuyRcmdPointRate() / 100));
						item.setBuyRcmdPointScore((int) point);
					}
					status.setBuyRcmdPointScore(status.getBuyRcmdPointScore() + item.getBuyRcmdPointScore());
					status.setRcmdrCustNo(plcyInfoRcmd.getItgCustNo());
					status.setMshipGradeCd(plcyInfoRcmd.getMshipGradeCd());
					pointAllList.add(status);
					pointItemList.add(item);
				}

				// 구매추천보상승급점수
				point = 0;
//				usePoint = 0;
				if (plcyInfoRcmd.getBuyRewardAdvncmtRate() != null && plcyInfoRcmd.getItgCustNo() != null) {

					// 제외 상품 또는 제외 매장일 경우
					if (plcyInfoRcmd.getMshipGodsChk() > 0 || plcyInfoRcmd.getMshipStoreChk() > 0) {
						item.setBuyRcmdRewardAdvncmtScore(0);
					} else {
						point = (int) (amt * (plcyInfoRcmd.getBuyRcmdRewardAdvncmtRate() / 100));
						item.setBuyRcmdRewardAdvncmtScore((int) point);
					}
					status.setBuyRcmdRewardAdvncmtScore(
							status.getBuyRcmdRewardAdvncmtScore() + item.getBuyRcmdRewardAdvncmtScore());
					status.setRcmdrCustNo(plcyInfoRcmd.getItgCustNo());
					status.setMshipGradeCd(plcyInfoRcmd.getMshipGradeCd());
					pointAllList.add(status);
					pointItemList.add(item);
				}

			}

			status.setCrmPointHsAllList(pointAllList);
			item.setCrmPointHsItemList(pointItemList);
		}

	}

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 5. 4.
	 * @param pblsChlCd
	 * @param chitNo
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 전표내 포인트 적립/사용/취소 동시 처리
	 *
	 */
	public CrmPointInfoVo saveApprove(String pblsChlCd, String chitNo, List<CrmPointVo> list) throws Exception {
		List<CrmPointVo> depositList = new ArrayList<CrmPointVo>();
		List<CrmPointVo> withDrawalList = new ArrayList<CrmPointVo>();
		for (int i = 0; i < list.size(); i++) {
			CrmPointVo pt = list.get(i);
			if (USE_TYPE_DEPOSIT.equals(pt.getUseTypeCd()))
				depositList.add(pt);
			else if (USE_TYPE_WITHDRAWAL.equals(pt.getUseTypeCd()))
				withDrawalList.add(pt);
			else if (USE_TYPE_CANCEL.equals(pt.getUseTypeCd())) {
				if (i != 0 || list.size() != 0)
					throw new EzApiException(API_CODE_INVALID_CANCEL_TYPE, API_CODE_INVALID_CANCEL_TYPE_MSG);
				pt.setPblsChlCd(pblsChlCd);
				pt.setChitNo(chitNo);
				CrmPointHstVo vo = Utilities.beanToBean(pt, CrmPointHstVo.class);
				Utilities.validate(vo);
				return saveCancel(vo);
			} else
				throw new EzApiException(API_CODE_INVALID_USE_TYPE, API_CODE_INVALID_USE_TYPE_MSG);
		}
		CrmPointInfoVo info = null;
		for (int i = 0; i < withDrawalList.size(); i++) {
			CrmPointVo pt = withDrawalList.get(i);
			pt.setPblsChlCd(pblsChlCd);
			pt.setChitNo(chitNo);
			CrmPointHstVo vo = Utilities.beanToBean(pt, CrmPointHstVo.class);
			Utilities.validate(vo);
			info = saveWithdrawal(vo);
		}

		for (int i = 0; i < depositList.size(); i++) {
			CrmPointVo pt = depositList.get(i);
			pt.setPblsChlCd(pblsChlCd);
			pt.setChitNo(chitNo);
			if (Utilities.isNotEmpty(pt.getItemList())) {
				Utilities.validate(pt);
				info = savePosPoint(pt);
			} else {
				CrmPointHstVo vo = Utilities.beanToBean(pt, CrmPointHstVo.class);
				Utilities.validate(vo);
				info = saveDeposit(vo);
			}
		}

		return info;
	}

}
