package com.ceragem.api.as.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ceragem.api.base.util.Utilities;

public class YnValidator implements ConstraintValidator<YnValue, CharSequence> {

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (Utilities.isEmpty(value)) {
			return true;
		}

		return "N".equals(value) || "Y".equals(value);
	}
}
