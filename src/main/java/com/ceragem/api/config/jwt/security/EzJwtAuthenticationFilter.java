package com.ceragem.api.config.jwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.config.jwt.EzJwtService;

/**
 * <pre>
 * com.ceragem.crm.common.jwt.security - EzJwtAuthenticationFilter.java
 * </pre>
 *
 * @ClassName : EzJwtAuthenticationFilter
 * @Description : JWT 인증필터
 * @author : 김성태
 * @date : 2021. 1. 22.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

public class EzJwtAuthenticationFilter extends GenericFilterBean {
	private final EzJwtService jwtTokenProvider;

	// Jwt Provier 주입
	public EzJwtAuthenticationFilter(EzJwtService jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setAttribute("httpServletResponse", response);
		HttpServletRequest req = (HttpServletRequest) request;
		request.setAttribute(Constants._API_CALL_URL_KEY, req.getRequestURI());
		String token = EzJwtService.resolveToken((HttpServletRequest) request);
		Authentication auth = jwtTokenProvider.getAuthentication(token, (HttpServletRequest) request);
		SecurityContextHolder.getContext().setAuthentication(auth);

		chain.doFilter(request, response);

	}

}
