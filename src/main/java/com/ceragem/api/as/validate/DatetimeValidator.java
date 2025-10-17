package com.ceragem.api.as.validate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DatetimeValidator implements ConstraintValidator<DatetimeValue, CharSequence> {

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		try {
			if (value.length() != 14)
				return false;
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREAN);
			Date dt = df.parse(value.toString());
			String str = df.format(dt);
			return str.equals(value.toString());
		} catch (Exception e) {
			return false;
		}
	}
}
