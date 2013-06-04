package com.sirma.itt.javacourse.reflectionAnnotationsRegex;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates the priority of the user classes used for sorting them. Has an
 * interval [0 to 10] and is set to 10 (lowest priority) by default.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sorted {
	/**
	 * The priority of a class is a main attribute for sorting its instances in
	 * a particular order.
	 */
	int priority() default 10;
}
