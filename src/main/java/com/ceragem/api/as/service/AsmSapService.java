package com.ceragem.api.as.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.dao.AsmSapDao;
import com.ceragem.api.as.dao.IAsmDao;
import com.ceragem.api.as.model.AsmSapPrecChitTrmListVo;
import com.ceragem.api.as.model.AsmSapPrecChitTrmVo;
import com.ceragem.api.as.model.AsmSapProdReqTrmListVo;
import com.ceragem.api.as.model.AsmSapProdReqTrmVo;
import com.ceragem.api.as.model.AsmSapResultVo;
import com.ceragem.api.as.model.AsmSapRfndTrtTrmListVo;
import com.ceragem.api.as.model.AsmSapRfndTrtTrmVo;
import com.ceragem.api.base.service.AbstractAsmService;
import com.ceragem.api.base.util.Utilities;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @ClassName AsmSapService
 * @author 이윤성
 * @date 2022. 6. 24.
 * @Version 1.0
 * @description SAP CRM Service
 */
@Slf4j
@Service
public class AsmSapService extends AbstractAsmService {

	@Resource(name = "jacksonObjectMapper")
	ObjectMapper objectMapper;

	@Autowired
	AsmSapDao dao;

	@Override
	public IAsmDao getDao() {
		return dao;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 24.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 수금반제-입금정보/선수금전표 수신
	 *
	 */
	public AsmSapResultVo precChitRrm(AsmSapPrecChitTrmVo param) {
		AsmSapResultVo asmSapResultVo = new AsmSapResultVo();

		try {
			log.debug("SAP Request Body ======>" + Utilities.getJsonString(param));
			log.debug("SAP Request Body size ======>" + param.getItems().size());

			for (int i = 0; i < param.getItems().size(); i++) {

				AsmSapPrecChitTrmListVo items = objectMapper.convertValue(param.getItems().get(i),
						AsmSapPrecChitTrmListVo.class);
				log.debug("items=====>" + Utilities.getJsonString(items));

				// (SAP수신데이터) SAP선수금내역 저장
				dao.insertPrecChitRrm(items);

				// 전송데이터유형 (I : 신규, U : 변경, D : 삭제)
				String trantype = items.getTrantype();

				log.debug("trantype=====>" + trantype);

				if ("I".equals(trantype)) {
					dao.insertAsRmnyBatchTmp(items); // Batch Temp 신규저장
				} else if ("U".equals(trantype)) {
					dao.updateAsRmnyBatchTmp(items); // Batch Temp 변경처리
				} else if ("D".equals(trantype)) {
					dao.deleteAsRmnyBatchTmp(items); // Batch Temp 삭제처리
				}
			}

			asmSapResultVo.setMsgty("S");
			asmSapResultVo.setMsgno("200");
			asmSapResultVo.setMsgtx("정상");
		} catch (Exception e) {
			e.printStackTrace();
			asmSapResultVo.setMsgty("F");
			asmSapResultVo.setMsgno("400");
			asmSapResultVo.setMsgtx(e.getMessage());
		}

		return asmSapResultVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 수금반제-유상매출 반제처리 결과 수신
	 *
	 */
	public AsmSapResultVo rfndTrtTrm(AsmSapRfndTrtTrmVo param) {
		AsmSapResultVo asmSapResultVo = new AsmSapResultVo();

		try {
			log.debug("SAP Request Body ======>" + Utilities.getJsonString(param));
			log.debug("SAP Request Body size ======>" + param.getItems().size());

			for (int i = 0; i < param.getItems().size(); i++) {

				AsmSapRfndTrtTrmListVo items = objectMapper.convertValue(param.getItems().get(i),
						AsmSapRfndTrtTrmListVo.class);
				log.debug("items=====>" + Utilities.getJsonString(items));
				log.debug("items result=====>"
						+ String.format("[%s] %s", items.getResult(), items.getMessage()));

				// 관리번호순번
				items.setSeq(String.valueOf(i + 1));

				// (SAP수신데이터) SAP 반제처리결과 기록
				dao.insertRfndTrtTrm(items);

				// (SAP수신데이터) SAP 반제처리
				dao.updateRfndTrtTrm(items);

				// (SAP수신데이터) SAP 반제처리 (수납테이블)
				dao.updateRfndTrtTrm2(items);

			}

			asmSapResultVo.setMsgty("S");
			asmSapResultVo.setMsgno("200");
			asmSapResultVo.setMsgtx("정상");

		} catch (Exception e) {
			e.printStackTrace();
			asmSapResultVo.setMsgty("F");
			asmSapResultVo.setMsgno("400");
			asmSapResultVo.setMsgtx(e.getMessage());
		}

		return asmSapResultVo;
	}

	/**
	 * @author 이윤성
	 * @date 2022. 6. 27.
	 * @param
	 * @return
	 * @throws Exception
	 * @description 자재요청-구매입고 결과 수신
	 *
	 */
	public AsmSapResultVo prodReqTrm(AsmSapProdReqTrmVo param) {
		AsmSapResultVo asmSapResultVo = new AsmSapResultVo();

		try {
			log.debug("SAP Request Body ======>" + Utilities.getJsonString(param));
			log.debug("SAP Request Body size ======>" + param.getItems().size());

			for (int i = 0; i < param.getItems().size(); i++) {

				AsmSapProdReqTrmListVo items = objectMapper.convertValue(param.getItems().get(i),
						AsmSapProdReqTrmListVo.class);
				log.debug("items=====>" + Utilities.getJsonString(items));

				// 매시간 SAP에서 자동 PO입고 후 처리결과를 AS시스템으로 전송
				// 또는 본사 SO가 출고처리될때 PO자동입고 후 전송

				// 전송데이터유형 (I : 신규, U : 변경, D : 삭제)
				String trantype = items.getTrantype();
				String budat = items.getBudat();

				if ("I".equals(trantype) || "U".equals(trantype)) {
					// (SAP수신데이터) AS자재수불마스터상세 - PO입고처리
					if (!"00000000".equals(budat)) {
						dao.updateProdReqTrm(items);
						asmSapResultVo.setMsgtx("정상");
					}
				} else {
					asmSapResultVo.setMsgtx("Non Update");
				}
			}

			asmSapResultVo.setMsgty("S");
			asmSapResultVo.setMsgno("200");

		} catch (Exception e) {
			asmSapResultVo.setMsgty("F");
			asmSapResultVo.setMsgno("400");
			asmSapResultVo.setMsgtx(e.getMessage());
		}
		return asmSapResultVo;
	}
}
