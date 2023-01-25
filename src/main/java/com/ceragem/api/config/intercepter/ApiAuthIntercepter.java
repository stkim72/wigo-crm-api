package com.ceragem.api.config.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.model.ApiExecHstVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <pre>
 * com.ceragem.crm.interceptor - AuthInterceptor.java
 * </pre>
 *
 * @ClassName : AuthInterceptor
 * @Description : 권한 인터셉터
 * @author : 김성태
 * @date : 2021. 1. 5.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

// public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
@Slf4j
@Component
public class ApiAuthIntercepter implements HandlerInterceptor {

//	@Autowired
//	private EzJwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getAttribute("javax.servlet.error.status_code") != null)
			return true;
		
		ApiExecHstVo apiInfo = (ApiExecHstVo) request.getAttribute(Constants._API_INFO_KEY);
		if (log.isDebugEnabled() && apiInfo != null
//				&& request.getAttribute("javax.servlet.error.status_code") == null
		) {
			StringBuilder sb = new StringBuilder();
			// request 정보
			sb.append("[API Authentication] <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			sb.append("\n#remoteIp   : ").append(request.getRemoteAddr());
			sb.append("\n#targetURI  : ").append(request.getServletPath());
			sb.append("\n#reqUrl     : ").append(request.getRequestURL().toString());
			sb.append("\n#userAgent  : ").append(request.getHeader("User-Agent"));
			sb.append("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			log.debug(sb.toString());
		}
		
		return true;
	}

}
