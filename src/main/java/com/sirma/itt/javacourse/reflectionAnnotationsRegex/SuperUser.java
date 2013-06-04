package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

/**
 * The super user is the highest level user and has a priority of 1.
 */
@Sorted(priority = 1)
public class SuperUser extends User {
	/**
	 * A nullary constructor.
	 */
	public SuperUser() {
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
	public SuperUser(String username, String pass) {
		super(username, pass);
	}
}
