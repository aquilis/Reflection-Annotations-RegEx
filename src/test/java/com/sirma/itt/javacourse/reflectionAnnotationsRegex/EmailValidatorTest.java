package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Test the e-mail validator with different input strings.
 */
@RunWith(Parameterized.class)
public class EmailValidatorTest {
	private final String input;
	private final boolean result;

	/**
	 * Check if the method throws the proper exceptipn when null input.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNull() {
		EmailValidator.isValid(null);
	}

	/**
	 * Constructor taking the parameters for the tests.
	 * 
	 * @param input
	 *            is the input emails to validate
	 * @param result
	 *            is the expected result
	 */
	public EmailValidatorTest(String input, boolean result) {
		this.input = input;
		this.result = result;
	}

	/**
	 * The collection of parameters for the test.
	 * 
	 * @return a collection with input emails and the expected boolean result of
	 *         the validation
	 */
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection passValidationParameters() {
		return Arrays.asList(new Object[][] { { "test.t-s@sir-ma.com", true },
				{ "h1ello@sirma999.com", true }, { "test@sirma.com", true },
				{ "eee@s-sirma.com", true }, { "5asdad@test.com", false },
				{ "test#w@test.com", false }, { "loltest.com", false },
				{ "", false } });
	}

	/**
	 * Test case with the validation parameters.
	 */
	@Test
	public void testValidation() {
		assertEquals(result, EmailValidator.isValid(input));
	}

}
