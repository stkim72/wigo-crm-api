package com.ceragem.api.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ceragem.api.base.model.ApiBasePagination;
import com.ceragem.api.base.model.ApiPagingPayload;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.base.model.ApiVoidResultVo;
import com.ceragem.api.config.jwt.EzJwtService;

public class BaseRestController {

	@Autowired
	EzJwtService jwtService;

	public <T> ResponseEntity<ApiResultVo<ApiPagingPayload<T>>> successResponse(List<T> list, ApiBasePagination so) {

		ApiPagingPayload<T> payload = new ApiPagingPayload<T>(list, so);
		return successResponse(payload);
	}

	public <T> ResponseEntity<ApiResultVo<T>> successResponse(T payload) {
		ApiResultVo<T> apiResult = new ApiResultVo<T>(payload);
		jwtService.addExecHist(apiResult);
		return new ResponseEntity<>(apiResult, HttpStatus.OK);
	}

	public <T> ResponseEntity<ApiResultVo<T>> successResponse(T payload, HttpHeaders headers) {
		ApiResultVo<T> apiResult = new ApiResultVo<T>(payload);
		jwtService.addExecHist(apiResult);
		return new ResponseEntity<>(apiResult, headers, HttpStatus.OK);
	}

	public <T> ResponseEntity<ApiResultVo<T>> getErrorResult(String errorCode, String errorMsg, T payload) {
		ApiResultVo<T> apiResult = new ApiResultVo<T>(errorCode, errorMsg, payload);
		jwtService.addExecHist(apiResult);
		return new ResponseEntity<ApiResultVo<T>>(apiResult, HttpStatus.OK);
	}

	public ResponseEntity<ApiVoidResultVo> successResponse() {
		ApiVoidResultVo apiResult = new ApiVoidResultVo();
		jwtService.addExecHist(new ApiResultVo<Object>());
		return new ResponseEntity<ApiVoidResultVo>(apiResult, HttpStatus.OK);

	}

	public ResponseEntity<ApiVoidResultVo> getVoidResult(String errorCode, String errorMsg) {
		ApiVoidResultVo apiResult = new ApiVoidResultVo();
		jwtService.addExecHist(new ApiResultVo<Object>(errorCode, errorMsg));
		return new ResponseEntity<ApiVoidResultVo>(apiResult, HttpStatus.OK);
	}
}
