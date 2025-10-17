package com.ceragem.api.pos.service;

import java.net.InetAddress;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.dao.IAsmDao;
import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.service.AbstractAsmService;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.pos.dao.PosMshipSelfExpDao;
import com.ceragem.api.pos.model.PosExpCustListVo;
import com.ceragem.api.pos.model.PosExpListVo;
import com.ceragem.api.pos.model.PosExpResultVo;
import com.ceragem.api.pos.model.PosExpVo;
import com.ceragem.crm.common.model.EzApiException;

/**
 *
 * @ClassName PosMshipSelfExpService
 * @author 최희원
 * @date 2023. 10. 10.
 * @Version 1.0
 * @description POS 체험대기등록 신청 Service
 */
@Service
public class PosMshipSelfExpService extends AbstractAsmService {
	@Autowired
	PosMshipSelfExpDao dao;

	@Override
	public IAsmDao getDao() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author 최희원
	 * @date 2023. 10. 10.
	 * @param PosExpVo
	 * @return
	 * @throws Exception
	 * @description POS체험대기등록 신청 API
	 *
	 */
	public int selectExpWaitHourNullYn(PosExpVo vo) throws Exception {

		int cnt = 0;
		cnt = dao.selectExpWaitHourNullYn(vo);
		return cnt;
	}

	/**
	 * @author 최희원
	 * @date 2023. 10. 10.
	 * @param PosExpVo
	 * @return
	 * @throws Exception
	 * @description POS체험대기등록 신청 API
	 *
	 */
	public PosExpResultVo selectExpWaitHour(PosExpVo vo) throws Exception {
		int expWaitCnt = 0;
		int storCdCnt = 0;
		PosExpResultVo posExpResultVo = new PosExpResultVo();
		System.out.println("vo.getRequestHostname() ::: " + vo.getRequestHostname());
		// vo에 필요한 값 셋팅하기
		posExpResultVo.setInterfaceId("INF_POS_001");
		posExpResultVo.setResponseSystem("POS");
		posExpResultVo.setResponseHostname(InetAddress.getLocalHost().getHostAddress());
		posExpResultVo.setTransactionId("posTransactionManager");
		posExpResultVo.setTimestamp(Utilities.getTimeStamp());
		// 요청서버의 IP주소를 가져와서 응답서버에서 내려준다.
		Object ob = vo.getRequestHostname();
		posExpResultVo.setRequestHostname(ob.toString());
		// 체험대기 등록은 현재날짜를 받아야 한다.
		// in parameter exprnDt날짜를 체크해서 현재일자가 아니면
		// 현재일자,현재일자 이후의 날짜를 입력하셔야 합니다. 메세지 리턴
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));

		// yyyyMMdd 포맷 설정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		// 비교할 date와 today를데이터 포맷으로 변경
		Date date = new Date(dateFormat.parse(vo.getExprnDt()).getTime());
		Date todaydiff = new Date(dateFormat.parse(today).getTime());

		int compare = date.compareTo(todaydiff);

		// 체험일자 < 현재일자일 경우 현재일자 또는 현재일자 이후의 날짜 입력
		if (compare < 0) {
			throw new EzApiException(Constants._API_POS_CHK_DAY_BEFORE, Constants._API_POS_CHK_DAY_BEFORE_MSG);

			// 체험일자 > 현재일자 OR 체험일자 = 현재일자일 경우
		} else {
			// 1.in parameter의 storNo를 받아서 존재하는 매장인지 먼저 체크하여
			storCdCnt = dao.selectStorcdNullchk(vo);
			// 2.존재하는 매장일 경우
			if (storCdCnt == 1) {
				// 체험대기예상시간이 null 인지 조회
				expWaitCnt = dao.selectExpWaitHourNullYn(vo);
				// null인 경우 0으로 update
				if (expWaitCnt == 0) {
					dao.updateExpHourNull(vo);
				}
				// 체험 대기 예상 시간 조회
				List<PosExpResultVo> expWaitHourList = dao.selectExpWaitHour(vo);

				if (expWaitHourList.size() != 0) {
					PosExpResultVo expWaitHourData = expWaitHourList.get(0);
					// 현재 체험대기 예상 시간 사용하지 않음.back단 소스는 수정하지 않고 그대로 둔 상태
					// 체험 대기 예상 시간
					vo.setWAIT_HOUR(Integer.parseInt(expWaitHourData.getExprnWaitNo()));
					// 대기 등록
					dao.insertExpWaitList(vo);

					// 체험대기예상시간 업데이트
//					dao.saveExpWaitHourS(vo);
				} else {
//					// 대기 등록
					dao.insertExpWaitList(vo);
				}

				List<PosExpResultVo> posExpResultVoList = dao.getMshipSelfExpList(vo);
				posExpResultVo.setExprnWaitNo(posExpResultVoList.get(0).getExprnWaitNo());

				// 3.존재하지 않는 매장일 경우 -> "존재하지 않는 매장 매장번호 입니다."
			} else if (storCdCnt == 0) {
				throw new EzApiException(Constants._API_STOR_NO_DATA, Constants._API_CODE_NO_STORE_MSG);
			}
		}

		return posExpResultVo;
	}

	/**
	 * 체험대기예상시간 업데이트
	 * 
	 * @param parameter
	 * @return int 변경 건수
	 */
	public int saveExpWaitHourS(PosExpVo vo) {
		return dao.saveExpWaitHourS(vo);
	}

	/**
	 * @author 최희원
	 * @date 2023. 10. 10.
	 * @param PosExpVo
	 * @return
	 * @throws Exception
	 * @description POS체험대기등록 신청 API
	 *
	 */
	public void insertExpWaitList(PosExpVo vo) throws Exception {
		dao.insertExpWaitList(vo);
	}

	/**
	 * @author 최희원
	 * @date 2023. 10. 10.
	 * @param PosExpVo
	 * @return
	 * @throws Exception
	 * @description POS체험대기등록 신청 API
	 *
	 */
	public List<PosExpResultVo> getCustExpWiatRegList(PosExpVo vo) throws Exception {
		return dao.getMshipSelfExpList(vo);
	}

	/**
	 * @author 최희원
	 * @date 2023. 10. 10.
	 * @param PosExpListVo
	 * @return
	 * @throws Exception
	 * @description POS체험대기등록 조회 API
	 *
	 */
	public List<PosExpCustListVo> getCustExpWaitList(PosExpListVo vo) throws Exception {
		return dao.getCustExpList(vo);

	}

}
