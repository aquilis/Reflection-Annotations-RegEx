package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Tests the IBAN validator with different input strings.
 */
@RunWith(Parameterized.class)
public class IBANValidatorTest {
	private final String input;
	private final String expectedResult;

	/**
	 * Check if the method throws the proper exceptipn when null input.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNull() {
		IBANValidator.maskIBANCodes(null);
	}

	/**
	 * Constructor taking the parameters for the tests.
	 * 
	 * @param input
	 *            is the input emails to validate
	 * @param result
	 *            is the expected result
	 */
	public IBANValidatorTest(String input, String result) {
		this.input = input;
		this.expectedResult = result;
	}

	/**
	 * The collection of parameters for the test.
	 * 
	 * @return a collection with input IBAN codes and their expected condition
	 *         after the manipulation is made.
	 */
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection passValidationParameters() {
		return Arrays.asList(new Object[][] {
				{ "<iban>GR16 0110 1050 0000 1054 7023 795</iban>",
						"<iban>GR16 0110 1050 0000 1054 7023 795</iban>" },
				{ "<iban>BG80 BNBG 9661 1020 3456 7840</iban>",
						"<iban>****7840</iban>" },
				{ "<iban>IL30 01BG 0300 0009 6339 234</iban>",
						"<iban>IL30 01BG 0300 0009 6339 234</iban>" },
				{ "<iban>BG80 BNBG 9661 1020 3456 7843</iban>",
						"<iban>****7843</iban>" }, });
	}

	/**
	 * Test case with the validation parameters.
	 */
	@Test
	public void testValidation() {
		assertEquals(expectedResult, IBANValidator.maskIBANCodes(input));
	}

}