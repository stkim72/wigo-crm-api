package com.ceragem.api.base.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.model.ApiErrorResultVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.config.jwt.EzJwtService;
import com.ceragem.api.crm.model.CrmCommonCodeVo;
import com.ceragem.api.crm.service.CrmComnCdBasService;
import com.ceragem.crm.common.model.EzAjaxException;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzException;
import com.ceragem.crm.common.model.EzMap;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * com.ceragem.crm.common.controller - ErrorController.java
 * </pre>
 *
 * @ClassName : ErrorController
 * @Description : ??????
 * @author : MKH
 * @date : 2021. 1. 21.
 * @Version : 1.0
 * @Company : Copyright ??? wigo.ai. All Right Reserved
 */
@Slf4j
@RestController
@RestControllerAdvice
//@ControllerAdvice
@RequestMapping(value = { "/error" })
public class ApiErrorController implements ErrorController {
	private static final String ERROR_PATH = "/error";
	@Autowired
	EzJwtService jwtService;

	@Autowired
	CrmComnCdBasService codeService;

//	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	private ResponseEntity<ApiErrorResultVo> getUnknownError(HttpServletRequest request, HttpServletResponse response,
			Throwable exception) {
		String errorCode = Constants._API_CODE_FAIL;// (Integer)
													// request.getAttribute("javax.servlet.error.status_code");
		String message = "????????? ????????? ?????? ?????? ???????????????. ?????? ?????? ????????????.";// (String) request.getAttribute("javax.servlet.error.message");
//		response.setStatus(200);

		if (exception != null) {
			log.debug(exception.getMessage(), exception);
		}
		return getErrorResult(errorCode, message, request, response, exception);
	}

	private ResponseEntity<ApiErrorResultVo> getNotFoundError(HttpServletRequest request,
			HttpServletResponse response) {
		return getErrorResult(Constants._API_CODE_NOT_FOUND, "?????? API??? ?????? ??? ????????????.", request, response, null);
	}

	private ResponseEntity<ApiErrorResultVo> getErrorResult(String errorCode, String errorMessage,
			HttpServletRequest request, HttpServletResponse response, Throwable ex) {
		Throwable exception = ex;
		if (exception != null && exception instanceof EzException)
			exception = null;
		if (request == null || response == null)
			log.debug("request is null");
//		response.setStatus(200);
		ApiErrorResultVo result = new ApiErrorResultVo(errorCode, errorMessage, exception);

		jwtService.addErrorHist(result);
		if (exception != null && !(exception instanceof EzException))
			result.setPayload(exception.getClass().getSimpleName());
		else
			result.setPayload(null);
		return new ResponseEntity<ApiErrorResultVo>(result, HttpStatus.OK);

//		return result;
	}

	private Object parseError(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int errorCode = Utilities.parseInt(request.getAttribute("javax.servlet.error.status_code"));
		if (errorCode == 0)
			errorCode = response.getStatus();
//		String errorMessage  = (String) request.getAttribute("javax.servlet.error.message");
//		Object errortype = request.getAttribute("javax.servlet.error.exception_type");
		Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");
//		String uri = (String) request.getAttribute("javax.servlet.error.request_uri");

		if (exception != null)
			return parseException(exception, request, response);
		if (errorCode == 404)
			return getNotFoundError(request, response);
		return getUnknownError(request, response, exception);
	}

	private Object parseException(Throwable ex, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (ex instanceof EzApiException) {
			return ezApiError((EzApiException) ex, request, response);
		} else if (ex instanceof ExpiredJwtException) {
			return expiredKey((ExpiredJwtException) ex, request, response);
		} else if (ex instanceof MalformedJwtException) {
			return malformedKey((MalformedJwtException) ex, request, response);
		} else if (ex instanceof SignatureException) {
			return signatureKey((SignatureException) ex, request, response);
		} else if (ex instanceof MissingServletRequestParameterException) {
			return missingServletRequestParameterException((MissingServletRequestParameterException) ex, request,
					response);
		} else if (ex instanceof BindException) {
			return bindException((BindException) ex, request, response);
		} else if (ex instanceof DuplicateKeyException) {
			return duplicateKeyException((DuplicateKeyException) ex, request, response);
		}

		return getUnknownError(request, response, ex);
	}

	@RequestMapping(value = { "", "index" })
	public Object init(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		return parseError(request, response);

	}

	@RequestMapping(value = { "/jwt" })
	public Object jwtError(HttpServletRequest request, HttpServletResponse response) {
		return getNotFoundError(request, response);

	}

	@RequestMapping(value = { "/jwt/epe" })
	public Object jwtEpeError(HttpServletRequest request, HttpServletResponse response) {
		return getNotFoundError(request, response);
	}

	@RequestMapping(value = { "/jwt/ade" })
	public Object jwtApeError(HttpServletRequest request, HttpServletResponse response) {
//		EzJwtAccessDeniedException e = new EzJwtAccessDeniedException(null);
		return getNotFoundError(request, response);
	}

	@ExceptionHandler(Exception.class)
	public Object exception(Exception ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getUnknownError(request, response, ex);
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public Object duplicateKeyException(DuplicateKeyException ex, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return getErrorResult(Constants._API_CODE_DUPLICATED_PARAM, Constants._API_CODE_DUPLICATED_PARAM_MSG, request,
				response, ex);

	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public Object keyError(SQLIntegrityConstraintViolationException ex, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return getErrorResult(Constants._API_CODE_DUPLICATED_PARAM, Constants._API_CODE_DUPLICATED_PARAM_MSG, request,
				response, ex);

	}

	@ExceptionHandler(ExpiredJwtException.class)
	public Object expiredKey(ExpiredJwtException ex, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getErrorResult(Constants._API_CODE_EXPIRED_KEY, Constants._API_CODE_EXPIRED_KEY_MSG, request, response,
				ex);

	}

	@ExceptionHandler(MalformedJwtException.class)
	public Object malformedKey(MalformedJwtException ex, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getErrorResult(Constants._API_CODE_MALFROMED_KEY, Constants._API_CODE_MALFROMED_KEY_MSG, request,
				response, ex);

	}

	@ExceptionHandler(SignatureException.class)
	public Object signatureKey(SignatureException ex, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getErrorResult(Constants._API_CODE_MALFROMED_KEY, Constants._API_CODE_MALFROMED_KEY_MSG, request,
				response, ex);

	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Object httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getErrorResult(Constants._API_CODE_NO_METHOD, Constants._API_CODE_NO_METHOD_MSG, request, response, ex);

	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Object httpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return getErrorResult(Constants._API_CODE_INVALID_PARAM, Constants._API_CODE_INVALID_PARAM_MSG, request,
				response, ex);

	}

	@ExceptionHandler(EzAjaxException.class)
	public Object ezAjaxError(EzAjaxException ex, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getErrorResult("IAR0" + ex.getErrorCode(), ex.getMessage(), request, response, ex);
	}

	@ExceptionHandler(EzApiException.class)
	public Object ezApiError(EzApiException ex, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return getErrorResult(ex.getApiErrorCode(), ex.getMessage(), request, response, ex);
	}

	@ExceptionHandler(EzException.class)
	public Object ezError(EzException ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getErrorResult(Constants._API_CODE_FAIL, ex.getMessage(), request, response, ex);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public Object ezAccessDeniedException(EzException ex, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EzApiException e = new EzApiException(Constants._API_CODE_NO_RIGHT, ex.getMessage(), ex);
		return getErrorResult(Constants._API_CODE_NO_RIGHT, ex.getMessage(), request, response, e);
	}

	@ExceptionHandler(AuthenticationException.class)
	public Object ezAuthenticationException(EzException ex, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EzApiException e = new EzApiException(Constants._API_CODE_NOT_FOUND, ex.getMessage(), ex);
		return getErrorResult(Constants._API_CODE_NOT_FOUND, ex.getMessage(), request, response, e);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public Object missingServletRequestParameterException(MissingServletRequestParameterException ex,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = ex.getParameterName();
		EzApiException e = new EzApiException(Constants._API_CODE_INVALID_PARAM, "[" + name + "] ??????????????? ???????????? ???????????????.",
				ex);
		return getErrorResult(Constants._API_CODE_INVALID_PARAM, e.getMessage(), request, response, e);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Object methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request,
//			HttpServletResponse response) {
//		BindingResult br = ex.getBindingResult();
//		String name = null;
//		String msg = null;
//		if (br != null && br.getFieldErrorCount() > 0) {
//			name = "[" + br.getFieldError().getField() + "]";
//			msg = br.getFieldError().getDefaultMessage();
//
//		} else {
//			name = "??????";
//		}
//		if (Utilities.isEmpty(msg)) {
//			msg = name + " ??????????????? ???????????? ???????????????.";
//		} else {
//			msg = name + " " + msg;
//		}
//		EzApiException e = new EzApiException(Constants._API_CODE_INVALID_PARAM, msg, ex);
//		return getErrorResult(Constants._API_CODE_INVALID_PARAM, e.getMessage(), request, response, e);
//	}
	@ExceptionHandler(ConstraintViolationException.class)
	public Object constraintViolationException(ConstraintViolationException ex, HttpServletRequest request,
			HttpServletResponse response) {
		Set<ConstraintViolation<?>> cv = ex.getConstraintViolations();
		Iterator<ConstraintViolation<?>> it = cv.iterator();
		ConstraintViolation<?> v = null;
		if(it.hasNext())
		{
			v = it.next();
		}
		StringBuffer msg = new StringBuffer();
		
		if (v != null) {
			log.debug(v.getPropertyPath().toString());
			String[] pt = v.getPropertyPath().toString().split("\\.");
			String prop = pt[pt.length - 1];
			msg.append("[");
			msg.append(prop);
			msg.append("-");
			msg.append(v.getInvalidValue());
			msg.append("]");
			msg.append(v.getMessage());
		}
		EzApiException e = new EzApiException(Constants._API_CODE_INVALID_PARAM, msg.toString(), ex);
		return getErrorResult(Constants._API_CODE_INVALID_PARAM, e.getMessage(), request, response, e);
	}

	@ExceptionHandler(BindException.class)
	public Object bindException(BindException ex, HttpServletRequest request, HttpServletResponse response) {
		BindingResult br = ex.getBindingResult();
		String name = null;
		String msg = null;
		if (br != null && br.getFieldErrorCount() > 0) {
			String cd = br.getFieldError().getCode();
			Object value = br.getFieldValue(br.getFieldError().getField());
			if (Utilities.isEmpty(value))
				value = "";
			else
				value = " - '" + value + "'";
			name = "[" + br.getFieldError().getField() + value.toString() + "]";
			if ("CodeValue".equals(cd)) {
				Object[] arr = br.getFieldError().getArguments();
				if (arr != null && arr.length > 1 && arr[1] != null) {

					try {
						String topComnCd = (String) arr[1].toString();
						EzMap param = new EzMap();
						param.setString("topComnCd", topComnCd);
						List<CrmCommonCodeVo> list = codeService.getList(param);
						StringBuffer bf = new StringBuffer();

						for (int i = 0; i < list.size(); i++) {
							CrmCommonCodeVo vo = list.get(i);
							if (i > 0)
								bf.append(" , ");
							else {
								bf.append("[");
								bf.append(vo.getLargeCd());
								bf.append(" : ");
								bf.append(vo.getLargeNm());
								bf.append(" ][");
							}

							bf.append(vo.getSmallCd());
							bf.append(" : ");
							bf.append(vo.getSmallNm());
						}
						bf.append("] ????????? ????????? ????????????.");
						msg = bf.toString();
					} catch (Exception e) {
						Utilities.trace(e);
					}

				}

			}

//			String value = br.getFieldValue(br.getFieldError().getField()));
//			if(Utilities.isNotEmpty(br.getFieldValue(br.getFieldError().getField()))
			if (Utilities.isEmpty(msg))
				msg = br.getFieldError().getDefaultMessage();

		} else {
			name = "??????";
		}
		if (Utilities.isEmpty(msg)) {
			msg = name + " ??????????????? ???????????? ???????????????.";
		} else {
			msg = name + " " + msg;
		}
		EzApiException e = new EzApiException(Constants._API_CODE_INVALID_PARAM, msg, ex);
		return getErrorResult(Constants._API_CODE_INVALID_PARAM, e.getMessage(), request, response, e);
	}
}
