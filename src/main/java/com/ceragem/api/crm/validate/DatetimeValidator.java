package com.ceragem.api.crm.validate;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ceragem.api.base.constant.Constants;
import com.ceragem.api.base.util.Utilities;

public class DatetimeValidator implements ConstraintValidator<DatetimeValue, CharSequence> {

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (Utilities.isEmpty(value)) {
			return true;
		}
		try {
			if (value.length() != 14)
				return false;
			Date dt = Constants._DATETIME_FORMAT.parse(value.toString());
			String str = Constants._DATETIME_FORMAT.format(dt);
			return str.equals(value.toString());
		} catch (Exception e) {
			return false;
		}
	}
}
