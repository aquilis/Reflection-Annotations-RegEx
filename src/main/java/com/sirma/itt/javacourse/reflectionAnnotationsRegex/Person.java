package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

import java.util.Date;

/**
 * A sample class designed to be examined and tested by the java reflection API.
 */
@SuppressWarnings("unused")
public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private String address;

	/**
	 * A nullary constructor.
	 */
	public Person() {
		this.name = "Unnamed";
		this.age = 0;
		this.address = "Unknown";
	}

	/**
	 * Construct the person with initial name, age and address.
	 * 
	 * @param name
	 *            is the name of the citizen
	 * @param age
	 *            is the age of the citizen
	 * @param address
	 *            is the address of the citizen
	 */
	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	/**
	 * Test method.
	 */
	private void payBills() {
		System.out.println("Bills paid");
	}

	/**
	 * Test method.
	 * 
	 * @param newAddress
	 *            is the new address to set
	 */
	public void changeAddress(String newAddress) {
		System.out.println("The address was changed to " + newAddress);
	}

	/**
	 * Test method.
	 * 
	 * @return the date of birth of the citizen
	 */
	public Date getBirthDate() {
		return new Date();
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
