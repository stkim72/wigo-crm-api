package com.ceragem.api.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.ceragem.api.config.jwt.EzJwtService;
import com.ceragem.api.config.jwt.security.EzJwtAccessHandler;
import com.ceragem.api.config.jwt.security.EzJwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	EzJwtService ezJwtTokenProvider;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		StrictHttpFirewall hf = new StrictHttpFirewall();
		hf.setAllowSemicolon(true);
		web.ignoring()
				.antMatchers("/actuator/**", "/application/**", "/error/**", "/static/**", "/login/**", "/genGrid/**",
						"/commCode/**", "/util/**", "/swagger-ui.html", "/swagger-resources", "/swagger-resources/**",
						"/api-docs/**", "/v2/api-docs")
				.and().ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).and()
				.httpFirewall(hf);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable() // rest api 이므로 기본설정 사용안함. 기본설정은 비인증시 로그인폼 화면으로 리다이렉트 된다.
				// rest api이므로 csrf 보안이 필요없으므로 disable처리.
				.cors().configurationSource(corsConfigurationSource()).and().csrf().disable().sessionManagement()
				// jwt token으로 인증할것이므로 세션필요없으므로 생성안함.
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				// 다음 리퀘스트에 대한 사용권한 체크(리소스 별 허용 범위 설정)
				.antMatchers("/api/**").hasRole("API")
				// 인증 오류 발생 시 처리를 위한 핸들러 추가
				.and().exceptionHandling().accessDeniedHandler(new EzJwtAccessHandler()).and()
				// 인증 오류 발생 시 처리를 위한 핸들러 추가
				// iframe 사용가능, jwt token 필터를 id/password 인증 필터 전에 넣어라.
				.exceptionHandling().authenticationEntryPoint(new EzJwtAccessHandler()).and().headers().frameOptions()
				.disable().and().addFilterBefore(new EzJwtAuthenticationFilter(ezJwtTokenProvider),
						UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedOriginPattern("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
