package com.ceragem.api.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.as.service.AsmBosService;
import com.ceragem.api.base.controller.BaseRestController;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @ClassName AsmCustController
 * @author 이윤성
 * @date 2022. 5. 30.
 * @Version 1.0
 * @description BOS고객상세조회 Controller ====> 사용안함, 삭제예정
 */
@Tag(name = "BOS고객상세조회", description = "BOS고객상세조회 API")
@RestController
@RequestMapping("/as/v1.0/test")
public class AsmCustController extends BaseRestController {

	@Autowired
	AsmBosService service;
}
