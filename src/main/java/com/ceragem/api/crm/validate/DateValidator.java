package com.ceragem.api.crm.validate;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.util.Utilities;

public class DateValidator implements ConstraintValidator<DateValue, CharSequence> {

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (Utilities.isEmpty(value) ) {
			return true;
		}
		try {
			if (value.length() != 8)
				return false;
			Date dt = Constants._DATE_FORMAT.parse(value.toString());
			String str = Constants._DATE_FORMAT.format(dt);
			return str.equals(value.toString());
		} catch (Exception e) {
			return false;
		}
	}
}
