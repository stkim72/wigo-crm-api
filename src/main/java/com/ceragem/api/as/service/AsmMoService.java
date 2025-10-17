package com.ceragem.api.as.service;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.api.as.dao.AsmMoDao;
import com.ceragem.api.as.dao.IAsmDao;
import com.ceragem.api.as.model.AsFileBaseVo;
import com.ceragem.api.as.model.AsmMoReceiveVo;
import com.ceragem.api.as.model.AsmMoResultVo;
import com.ceragem.api.base.service.AbstractAsmService;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.BaseUtilities;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @ClassName AsmMoService
 * @author 이윤성
 * @date 2022. 6. 14.
 * @Version 1.0
 * @description MO서비스 인터페이스 Service
 */
@Slf4j
@Service
public class AsmMoService extends AbstractAsmService {

	@Autowired
	AsmMoDao dao;

	@Override
	public IAsmDao getDao() {
		return dao;
	}

	// @Value("${spring.nas.path}")
	// String nasPath;

	// @Value("${spring.nas.url}")
	// String nasUrl;

	/**
	 * @author 이윤성
	 * @date 2022. 6. 14.
	 * @param EzMap
	 * @return
	 * @throws Exception
	 * @description MO서비스 정보 수신
	 *
	 */
	public AsmMoResultVo getInfoReceive(AsmMoReceiveVo mo) throws Exception {

		log.debug("Mo Body ======>" + mo);

		String testFile = "/NFS/as/upload/mofiles/2022/06/22/test.JPG";
		log.debug("Mo FileEx======>" + BaseUtilities.getFileExtension(testFile));
		log.debug("Mo FileName======>" + BaseUtilities.getFileName(testFile));

		log.debug("sms contents decodeBase64 ======>" + BaseUtilities.decodeBase64("c21zIOyImOyLoO2FjOyKpO2KuCAy"));

		// File Cd 채번 (MO + yyyyMMddHHmmss)
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREAN);
		String moFileCd = "MO" + format.format(System.currentTimeMillis());
		log.debug("Mo FileCd ======>" + moFileCd);
		log.debug("Mo ImageCnt ======>" + mo.getImageCnt());

		// MO서비스 최대, 파일3개 등록가능
		for (int i = 0; i < mo.getImageCnt(); i++) {

			log.debug("====================File DB Start============================");

			AsFileBaseVo asFileBaseVo = new AsFileBaseVo();
			asFileBaseVo.setFileCd(moFileCd); // (pk1) 파일코드
			asFileBaseVo.setFileOdrg(i + 1); // (pk2) 파일순번

			/*
			 * MO에서 받는 파일경로가 풀패스인지 확인 필요, 이후에 실제 파일이 업로드 되고 전달 받는 경로 확인후 수정필요함
			 */

			String fileNm = ""; // 파일명
			String fileSaveNm = ""; // 파일저장명 (/upload/mofiles/2022/06/22/test.JPG)
			String fileUrl = "https://files.ceragem.com/as/"; // 파일URL (변수처리 예정~~~), 경로수정
			String fileExtNm = ""; // 파일확장자명
			long fileSize = (long) 0; // 파일크기

			// PMD 수정
			StringBuilder sb = new StringBuilder();
			sb.append(fileUrl);

			// 이미지 사이즈 ==> BaseUtilities.getImageSize(파일패스), 실제 파일 업로드 되면

			if (i == 0) {
				// 이미지경로(Path1)
				fileNm = BaseUtilities.getFileName(mo.getImagePath01());
				fileSaveNm = mo.getImagePath01();
				// fileUrl += mo.getImagePath01(); (PMD)
				sb.append(mo.getImagePath01());
				fileExtNm = BaseUtilities.getFileExtension(mo.getImagePath01()).toLowerCase();
			} else if (i == 1) {
				// 이미지경로(Path2)
				fileNm = BaseUtilities.getFileName(mo.getImagePath02());
				fileSaveNm = mo.getImagePath02();
				// fileUrl += mo.getImagePath02();
				sb.append(mo.getImagePath02());
				fileExtNm = BaseUtilities.getFileExtension(mo.getImagePath02()).toLowerCase();
			} else if (i == 2) {
				// 이미지경로(Path3)
				fileNm = BaseUtilities.getFileName(mo.getImagePath03());
				fileSaveNm = mo.getImagePath03();
				// fileUrl += mo.getImagePath03();
				sb.append(mo.getImagePath03());
				fileExtNm = BaseUtilities.getFileExtension(mo.getImagePath03()).toLowerCase();
			}
			asFileBaseVo.setFileNm(fileNm);
			asFileBaseVo.setFileSize(fileSize);
			asFileBaseVo.setFileSaveNm(fileSaveNm);
			// asFileBaseVo.setFileUrl(fileUrl);
			asFileBaseVo.setFileUrl(sb.toString());
			asFileBaseVo.setFileExtNm(fileExtNm);

			asFileBaseVo.setRegrId("moservice");
			asFileBaseVo.setAmdrId("moservice");

			log.debug("Mo asFileBaseVo ======>" + asFileBaseVo);

			// MO서비스에서 받은 File 정보를 저장
			dao.moFileInsert(asFileBaseVo);

			// AS접수기본, MO파일 정보 업데이트
			EzMap moParam = new EzMap();
			moParam.put("fileCd", moFileCd); // 파일코드
			moParam.put("sendTelNo", mo.getSendTelNo()); // 고객전화번호
			dao.moFileUpdate(moParam);
		}

		AsmMoResultVo asmMoResultVo = new AsmMoResultVo();
		asmMoResultVo.setTrtRsltCtnts("success");

		return asmMoResultVo;
	}
}
