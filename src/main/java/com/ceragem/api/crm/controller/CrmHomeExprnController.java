package com.ceragem.api.crm.controller;

import javax.validation.Valid;

import com.ceragem.api.crm.model.*;
import com.ceragem.api.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.controller.BaseRestController;
import com.ceragem.api.base.model.ApiResultVo;
import com.ceragem.crm.common.model.EzApiException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@Tag(name = "CRM 홈체험이력", description = "CRM 홈체험이력 API")
@RestController
@RequestMapping("/crm/v1.0/exprn")
public class CrmHomeExprnController extends BaseRestController {

    @Autowired
    CrmHomeExprnService service;

    @PostMapping("")
    @Operation(summary = "홈체험이력 등록", description = "홈체험이력 등록")
    public ResponseEntity<ApiResultVo<CrmHomeExprnVo>> registHomeExprn(
            @Parameter(description = "CRM홈체험이력 객체") @RequestBody @Valid CrmHomeExprnVo vo) throws Exception {
        int ret = service.insert(vo);
        if (ret == 0)
            throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
        return successResponse(vo);
    }

}
