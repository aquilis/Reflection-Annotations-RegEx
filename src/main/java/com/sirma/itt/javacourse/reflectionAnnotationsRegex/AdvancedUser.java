package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

/**
 * The advanced user is one step behind the super user. It has a slightly less
 * priority (3), but still more than the medium and newbie users.
 */
@Sorted(priority = 3)
public class AdvancedUser extends User {
	/**
	 * A nullary constructor.
	 */
	public AdvancedUser() {
	}

	/**
	 * Constructs the super user with the given username and pass.
	 * 
	 * @param username
	 *            is the username to login with
	 * @param pass
	 *            is the password to login with
	 */
	public AdvancedUser(String username, String pass) {
		super(username, pass);
	}
}
