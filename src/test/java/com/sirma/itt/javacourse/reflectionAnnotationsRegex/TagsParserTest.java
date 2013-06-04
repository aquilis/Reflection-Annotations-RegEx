package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Tests the Tags parser with different input strings.
 */
@RunWith(Parameterized.class)
public class TagsParserTest {
	private final String input;
	private final String expectedResult;

	/**
	 * Check if the method throws the proper exceptipn when null input.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNull() {
		TagsParser.trimXTags(null);
	}

	/**
	 * Constructor taking the parameters for the tests.
	 * 
	 * @param input
	 *            is the input emails to validate
	 * @param result
	 *            is the expected result
	 */
	public TagsParserTest(String input, String result) {
		this.input = input;
		this.expectedResult = result;
	}

	/**
	 * The collection of parameters for the test.
	 * 
	 * @return a collection with input texts consisitng of tagged content and
	 *         its expected condition after the trim is made.
	 */
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection passValidationParameters() {
		return Arrays.asList(new Object[][] { {
				"<x><b></b><x>Hello world</x><b>sdfsdf</b><x>Good"
						+ "morning</x><x>69</x><x>sdfsdfsdf</x></x>",
								"<x><b></b><x/><b>sdfsdf</b><x/><x/><x/></x>" },
						{ "before<x>this should be removed</x>after",
								"before<x/>after" } });
	}

	/**
	 * Test case with the validation parameters.
	 */
	@Test
	public void testValidation() {
		assertEquals(expectedResult, TagsParser.trimXTags(input));
	}

}