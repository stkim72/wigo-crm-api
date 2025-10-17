package com.ceragem.api.base.model;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.config.jwt.EzJwtService;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "API void 공통 result")
@Getter
@Setter
public class ApiVoidResultVo {
	@Schema(description = "성공 메세지", accessMode = AccessMode.READ_ONLY)
	public static final String _MSG_SUCCESS = "성공";

	@Schema(description = "코드", required = true, example = "IAR0200", accessMode = AccessMode.READ_ONLY)
	private String code;
	@Schema(description = "메세지", required = true, example = "성공", accessMode = AccessMode.READ_ONLY)
	private String message;

	@Schema(description = "시스템코드", required = true, example = "001", accessMode = AccessMode.READ_ONLY)
	private String systemCd = EzJwtService.getSystemCd();

	@Schema(description = "호출일시(표준시간)", required = true, example = "2022-01-01T15:10:10Z", accessMode = AccessMode.READ_ONLY)
	private String timestamp = Utilities.getTimeStamp();

	public ApiVoidResultVo() {
//		super(HttpStatus.OK);
		code = Constants._API_CODE_OK;
		message = _MSG_SUCCESS;
	}

	public ApiVoidResultVo(String code, String message) {
//		super(HttpStatus.OK);
		this.code = code;
		this.message = message;
	}

}
