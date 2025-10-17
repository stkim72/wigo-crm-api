package com.ceragem.api.crm.validate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ceragem.api.base.util.Utilities;

public class DateValidator implements ConstraintValidator<DateValue, CharSequence> {

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (Utilities.isEmpty(value)) {
			return true;
		}
		try {
			if (value.length() != 8)
				return false;
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd", Locale.KOREAN);

			Date dt = df.parse(value.toString());
			String str = df.format(dt);
			return str.equals(value.toString());
		} catch (Exception e) {
			return false;
		}
	}
}
