package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Class examining the fields and methods of the Person class using the java
 * reflection API.
 */
@SuppressWarnings("unused")
public final class Examiner {
	/**
	 * A static class not designed to be instantiated.
	 */
	private Examiner() {
	}

	/**
	 * Examines the methods of the person class.
	 */
	private static void examinePersonMethods() {
		Person person = new Person("John", 30, "NY, foo str.");
		Class<?> personClass = person.getClass();

		Method[] declaredMethods = personClass.getDeclaredMethods();
		System.out.println("Person's methods declared in its own class:");
		for (Method mtd : declaredMethods) {
			System.out.println(mtd.toGenericString());
		}

		Method[] allMethods = personClass.getMethods();
		System.out
				.println("\nAll person's methods (incl. those inherited from the superclasses):");
		for (Method mtd : allMethods) {
			System.out.println(mtd.toGenericString());
		}
	}

	/**
	 * Examines the private fields of the person class and retrieves their
	 * values.
	 * 
	 * @throws IllegalAccessException
	 *             if this Field object is enforcing Java language access
	 *             control and the underlying field is inaccessible.
	 */
	private static void examinePersonFields() throws IllegalAccessException {
		Person person = new Person("John", 30, "NY, foo str.");
		Class<?> personClass = person.getClass();
		Field[] fields = personClass.getDeclaredFields();
		System.out.println("\nAll fields declared by the Person class:");
		for (Field fl : fields) {
			fl.setAccessible(true);
			System.out.println(fl.toGenericString() + " = " + fl.get(person));
		}
	}

	/**
	 * Instantiates the class by its name and examines its superclasses and the
	 * interfaces it implements.
	 * 
	 * @throws ClassNotFoundException
	 *             if the class cannot be located
	 * @throws IllegalAccessException
	 *             if the class or its nullary constructor is not accessible.
	 * @throws InstantiationException
	 *             if this Class represents an abstract class, an interface, an
	 *             array class, a primitive type, or void; or if the class has
	 *             no nullary constructor; or if the instantiation fails for
	 *             some other reason.
	 */
	public static void instantiateByName() throws ClassNotFoundException,
			IllegalAccessException, InstantiationException {
		Class<?> cls = Class.forName(Person.class.getCanonicalName());
		Object person = cls.newInstance();
		System.out.println("Superclass: " + cls.getSuperclass());
		System.out.println("Implemented interfaces: ");
		Type[] intfs = cls.getGenericInterfaces();
		for (Type intf : intfs) {
			System.out.println(intf);
		}
	}

	/**
	 * Invokes all public and private methods declared in the person class.
	 * 
	 * @throws NoSuchMethodException
	 *             if a matching method is not found.
	 * @throws InvocationTargetException
	 *             if the underlying method throws an exception.
	 * @throws IllegalAccessException
	 *             if this Method object is enforcing Java language access
	 *             control and the underlying method is inaccessible.
	 */
	public static void invokePersonMethods() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		Class<?> cls = Person.class;
		Method mtd = cls.getDeclaredMethod("changeAddress",
				new Class[] { String.class });
		mtd.invoke(new Person(), "In the middle of nowhere");

		mtd = cls.getDeclaredMethod("getBirthDate");
		System.out.println(mtd.invoke(new Person(), new Object[] {}));

		mtd = cls.getDeclaredMethod("payBills");
		mtd.setAccessible(true);
		mtd.invoke(new Person(), new Object[] {});
	}

	/**
	 * Entry point. Use this method to see the results of the class examination.
	 * 
	 * @param args
	 *            are the cmd args
	 * @throws IllegalAccessException
	 *             if this Field object is enforcing Java language access
	 *             control and the underlying field is inaccessible.
	 * @throws InstantiationException
	 *             if this Class represents an abstract class, an interface, an
	 *             array class, a primitive type, or void; or if the class has
	 *             no nullary constructor; or if the instantiation fails for
	 *             some other reason.
	 * @throws ClassNotFoundException
	 *             if the class cannot be located
	 * @throws InvocationTargetException
	 *             if the underlying method throws an exception.
	 * @throws NoSuchMethodException
	 *             if a matching method is not found.
	 */
	public static void main(String[] args) throws IllegalAccessException,
			ClassNotFoundException, InstantiationException,
			NoSuchMethodException, InvocationTargetException {
		instantiateByName();
	}

}
