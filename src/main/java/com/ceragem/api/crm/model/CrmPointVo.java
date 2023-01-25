package com.ceragem.api.crm.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmPointHstVo
 * @author 김성태
 * @date 2022. 4. 21.
 * @Version 1.0
 * @description CRM포인트이력 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
@Schema(description = "CRM포인트 객체")
public class CrmPointVo extends CrmPointHstVo {
	@Schema(description = "적립시상세내역[사용시 사용하지 않음]", example = "", hidden = false, required = true, nullable = true)
	@NotEmpty
	private List<CrmPointItemVo> itemList;
	


}
