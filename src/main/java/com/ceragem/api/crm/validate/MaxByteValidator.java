package com.ceragem.api.crm.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.util.Utilities;

public class MaxByteValidator implements ConstraintValidator<MaxByte, CharSequence> {
	int max;

	@Override
	public void initialize(MaxByte constraintAnnotation) {
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (Utilities.isEmpty(value)) {
			return true;
		}
		if (max <= 0)
			return true;
		try {
			return max >= value.toString().getBytes(Constants._DB_ENCODING).length;
		} catch (Exception e) {
			return true;
		}
	}
}
