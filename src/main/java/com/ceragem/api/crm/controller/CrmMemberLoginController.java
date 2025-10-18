package com.ceragem.api.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.api.crm.model.CrmCustVo;
import com.ceragem.api.crm.service.CrmCustService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * 
 * @ClassName CrmCustBasController
 * @author 김성태
 * @date 2022. 4. 8.
 * @Version 1.0
 * @description CRM고객 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

//@Tag(name = "CRM고객", description = "CRM고객 API")
//@RestController
//@RequestMapping("/crm/v1.0/auth")
public class CrmMemberLoginController extends BaseRestController {

	@Autowired
	CrmCustService service;

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 4. 19.
	 * @param loginId
	 * @param loginPwd
	 * @return
	 * @throws Exception
	 * @description
	 *
	 */
	@PostMapping("/loginMember")
	@Operation(summary = "CRM고객 로그인", description = "CRM고객 로그인")
	public ResponseEntity<ApiResultVo<CrmCustVo>> loginMember(
			@Parameter(description = "로그인 아이디") @RequestParam String loginId,
			@Parameter(description = "로그인 암호") @RequestParam String loginPwd,
			@Parameter(description = "접속 아이피") @RequestParam String ipAddr) throws Exception {
		CrmCustVo vo = new CrmCustVo();
		vo.setMshipLoginId(loginId);
		vo.setMshipLoginPwd(loginPwd);
		vo.setMshipLastLoginIpAddr(ipAddr);
		CrmCustVo user = service.login(vo);
		return successResponse(user);
	}

}
