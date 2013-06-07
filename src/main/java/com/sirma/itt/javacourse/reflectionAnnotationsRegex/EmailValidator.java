package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Has a public method for validating a given input string if it\s a valid
 * e-mail address.
 */
public final class EmailValidator {
	/**
	 * Not designed to be instantiated.
	 */
	private EmailValidator() {
	}

	/**
	 * Validates the input string if it's a valid e-mail address.
	 * 
	 * @param mail
	 *            is the e-mail to validate
	 * @return true if the input string is a valid e-maild adddress.
	 */
	public static boolean isValid(String mail) {
		if (mail == null) {
			throw new IllegalArgumentException(
					"Can't validate a null string for an email");
		}
		Pattern emailPattern = Pattern.compile("^[a-z][\\w.-]+@[a-z][\\w.-]+$");
		Matcher matcher = emailPattern.matcher(mail);
		return matcher.find();
	}
}
