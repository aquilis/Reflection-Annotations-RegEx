package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

/**
 * An abstract superclaass of all user classes.
 */
@SuppressWarnings("unused")
public abstract class User implements Comparable<User> {

	private String username;
	private String password;
	private int priority;

	/**
	 * A nullalry constructor.
	 */
	public User() {
		setPriority();
	}

	/**
	 * Constructs the user with the given username and pass.
	 * 
	 * @param username
	 *            is the username to login with
	 * @param pass
	 *            is the password to login with
	 */
	public User(String username, String pass) {
		this();
		this.username = username;
		this.password = pass;
	}

	/**
	 * A username getter.
	 * 
	 * @return the username of the user.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * A getter method for the priority of the user.
	 * 
	 * @return the priority of the user
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Parses the class annotations (if any) and adjusts the prioiority of the
	 * object.
	 */
	private void setPriority() {
		Class<?> cls = this.getClass();
		if (cls.isAnnotationPresent(Sorted.class)) {
			Sorted sorted = cls.getAnnotation(Sorted.class);
			this.priority = sorted.priority();
		}
	}

	/**
	 * Login to the system.
	 */
	public void logIn() {
	}

	/**
	 * Log out of the system.
	 */
	public void logOut() {
	}

	@Override
	public int compareTo(User user) {
		if (this.getPriority() == user.getPriority()) {
			return 0;
		} else if (this.getPriority() > user.getPriority()) {
			return 1;
		}
		return -1;
	}
}
