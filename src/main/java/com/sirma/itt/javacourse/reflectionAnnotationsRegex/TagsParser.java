package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

/**
 * Designed to parse or edit input string containing HTML tags in a particulat
 * way.
 */
public final class TagsParser {
	/**
	 * Not designed to be instantiated.
	 */
	private TagsParser() {
	}
	
	/**
	 * Scans the input text and replaces all the data between <x> and < /x> with
	 * < /x>. Uses the greedy regex match.
	 * 
	 * @param input
	 *            is the input text of HTML tags to trim
	 * @return the newly modified text
	 */
	public static String trimXTags(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Can't trim a null string");
		}
		return input.replaceAll("<x>[^</x>]*</x>", "<x/>");
	}
}
