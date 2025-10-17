package com.ceragem.api.crm.model;

import javax.validation.constraints.NotEmpty;

import com.ceragem.api.base.model.ApiBaseVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.validate.MaxByte;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmFileBasVo
 * @author 김성태
 * @date 2023. 5. 15.
 * @Version 1.0
 * @description CRM파일기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM파일기본 객체")
public class CrmFileVo extends ApiBaseVo {
	/**
	 * 파일코드
	 */
	@Schema(description = "파일코드", example = "", hidden = false, required = true, nullable = false, maxLength = 20)
	@NotEmpty
	@MaxByte(max = 20)
	private String fileCd;
	/**
	 * 파일순번
	 */
	@Schema(description = "파일순번", example = "", hidden = false, required = true, nullable = false)
	private Integer fileOdrg;
	/**
	 * 파일명
	 */
	@Schema(description = "파일명", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String fileNm;
	/**
	 * 파일크기
	 */
	@Schema(description = "파일크기", example = "", hidden = false, required = false, nullable = true)
	private Long fileSize;
	/**
	 * 파일저장명
	 */
	@Schema(description = "파일저장명", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String fileSaveNm;
	/**
	 * 파일URL
	 */
	@Schema(description = "파일URL", example = "", hidden = false, required = false, nullable = true, maxLength = 1000)
	@MaxByte(max = 1000)
	private String fileUrl;
	/**
	 * 파일확장자명
	 */
	@Schema(description = "파일확장자명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String fileExtNm;
	/**
	 * MIME유형명
	 */
	@Schema(description = "MIME유형명", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String mimeTypeNm;
	@Schema(description = "파일카테고리", example = "", hidden = false, required = false, nullable = true, maxLength = 100)
	@MaxByte(max = 100)
	private String fileCtgryCd;

	public String getFileSizeText() {
		return Utilities.getSizeString(getFileSize()) + "B";
	};
}
