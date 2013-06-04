package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

/**
 * A static validator class for bulgamrian IBAN numbers.
 * 
 * @author vtsonev
 */
public final class IBANValidator {
	/**
	 * Constructs the IBAN validator.
	 */
	private IBANValidator() {
	}

	/**
	 * Scans the input text for valid bulgarian IBAN codes and replaces their
	 * first 20 characters with ****.
	 * 
	 * @param code
	 *            is the input text that can contain 0 or more IBAN codes.
	 * @return is the newly modified text
	 */
	public static String maskIBANCodes(String code) {
		if (code == null) {
			throw new IllegalArgumentException(
					"Can't validate a null string for an IBAN code");
		}
		return code.replaceAll(
				"(<iban>)(BG80)([A-Z0-9\\s]{21})([0-9]{4})(</iban>)",
				"<iban>****$4</iban>");
	}
}
