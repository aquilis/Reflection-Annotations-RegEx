package com.sirma.itt.javacourse.reflectionAnnotationsRegex;


/**
 * The medium user has a medium priority for sorting.
 */
@Sorted(priority = 5)
public class MediumUser extends User {
	/**
	 * A nullary constructor.
	 */
	public MediumUser() {
		super();
	}

	/**
	 * Constructs the super user with the given username and pass.
	 * 
	 * @param username
	 *            is the username to login with
	 * @param pass
	 *            is the password to login with
	 */
	public MediumUser(String username, String pass) {
		super(username, pass);
	}
}
