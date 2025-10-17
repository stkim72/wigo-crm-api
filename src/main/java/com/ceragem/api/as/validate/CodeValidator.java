package com.ceragem.api.as.validate;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ceragem.api.base.util.Utilities;
import com.ceragem.api.crm.model.CrmComnCdBasVo;
import com.ceragem.api.crm.service.CrmComnCdBasService;

public class CodeValidator implements ConstraintValidator<CodeValue, CharSequence> {
	String codeId;
	String[] codes;
	CrmComnCdBasService codeService;

	@Override
	public void initialize(CodeValue constraintAnnotation) {
		codeService = Utilities.getBean(CrmComnCdBasService.class);
		codeId = constraintAnnotation.codeId();
		codes = constraintAnnotation.codes();
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (Utilities.isEmpty(value)) {
			return true;
		}
		if (Utilities.isNotEmpty(codeId)) {
			CrmComnCdBasVo vo = new CrmComnCdBasVo();
			vo.setTopComnCd(codeId);
			vo.setComnCd(value.toString());
			try {
				return codeService.get(vo) != null;
			} catch (Exception e) {
				return false;
			}
		}
		if (Utilities.isNotEmpty(codes))
			return Arrays.asList(codes).contains(value);

		return true;

	}
}
