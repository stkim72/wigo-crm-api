package com.ceragem.api.config.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.model.ApiExecHstVo;
import com.ceragem.api.base.util.Utilities;
import com.ceragem.crm.common.model.EzMap;

/**
 * <pre>
 * com.ceragem.crm.common.aop - BaseDaoAspect.java
 * </pre>
 *
 * @ClassName : BaseDaoAspect
 * @Description : TODO
 * @author : MKH
 * @date : 2021. 1. 11.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */

@Aspect
@Component
public class ParamAspect {
	@Before(value = "execution(* *..*Controller.*(..))")
	public void sqlBeforeController(JoinPoint jp) {

		getParamString(jp);
	}

	private void getParamString(JoinPoint jp) {
		HttpServletRequest req = Utilities.getRequest();
		if (req == null)
			return;
		ApiExecHstVo apiInfo = (ApiExecHstVo) req.getAttribute(Constants._API_INFO_KEY);
		if (apiInfo == null || Utilities.isNotEmpty(apiInfo.getApiParamTxn()))
			return;
		EzMap p = new EzMap();

		Enumeration<String> params = req.getParameterNames();
		p.setString("token", apiInfo.getApiCallToken());

		StringBuffer parameters = new StringBuffer();
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			if (parameters.length() > 0)
				parameters.append("&");
			parameters.append(name);
			parameters.append("=");
			parameters.append(Utilities.nullCheck(req.getParameter(name)));
//			parameters += name + "=" + Utilities.nullCheck(req.getParameter(name));

		}
		p.setString("requestParam", parameters);
		Object[] param = jp.getArgs();
		p.put("methodParam", param);
		try {
			apiInfo.setApiParamTxn(Utilities.getJsonString(p));
		} catch (Exception e) {
			apiInfo.setApiParamTxn(parameters.toString());
		}

	}
}
