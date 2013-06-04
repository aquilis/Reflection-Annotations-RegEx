package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

/**
 * The newbie user is the lowest level user and has a priority of 10.
 */
@Sorted(priority = 10)
public class NewbieUser extends User {
	/**
	 * A nullary constructor.
	 */
	public NewbieUser() {
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
	public NewbieUser(String username, String pass) {
		super(username, pass);
	}
}