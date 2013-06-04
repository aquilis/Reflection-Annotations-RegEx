package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests the priority annotation used to sort the user classes.
 */
public class TestUserAnnotations {

	/**
	 * Test if the priority of the super users is properly set.
	 */
	@Test
	public void testSuperusersPriority() {
		User spr = new SuperUser();
		assertEquals(spr.getPriority(), 1);
		spr = new AdvancedUser();
		assertEquals(spr.getPriority(), 3);
	}

	/**
	 * Test if the priority of the medium user is properly set.
	 */
	@Test
	public void testMediumUserPriority() {
		User med = new MediumUser();
		assertEquals(med.getPriority(), 5);
	}

	/**
	 * Test if the priority of the newbie user is properly set.
	 */
	@Test
	public void testNewbieUserPriority() {
		User nwb = new NewbieUser();
		assertEquals(nwb.getPriority(), 10);
	}
	
	/**
	 * Constructs an array of users that are mixed and then sorted according to
	 * the order indicated by the annotation. Print the sorted array on the
	 * console.
	 */
	@Test
	public void printArrayUsers() {
		User[] users = { new NewbieUser("newbie2", ""),
				new SuperUser("spr", ""), new SuperUser("spr2", ""),
				new NewbieUser("newbie", ""), new MediumUser("med", "") };
		Arrays.sort(users);
		System.out.println("Sorted arrays of users from top to low priortiy:");
		for (User user : users) {
			System.out.println(user.getUsername());
		}
	}
}
