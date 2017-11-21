package com.vinodh.webservices.test.domain;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsForAll;

import org.junit.Test;

import pl.pojo.tester.api.DefaultPackageFilter;
import pl.pojo.tester.api.assertion.Method;

public class PojoTester {

	@Test
	public void pojoTesting() {
		final Class<?>[] entityClasses = DefaultPackageFilter
				.forPackage("com.vinodh.webservices.springwebservices.entity").getClasses();
		final Class<?>[] domainClasses = DefaultPackageFilter
				.forPackage("com.vinodh.webservices.springwebservices.domain").getClasses();
		assertPojoMethodsForAll(entityClasses)
				.testing(Method.GETTER, Method.SETTER, Method.TO_STRING, Method.CONSTRUCTOR).areWellImplemented();
		assertPojoMethodsForAll(domainClasses)
				.testing(Method.GETTER, Method.SETTER, Method.TO_STRING, Method.CONSTRUCTOR).areWellImplemented();
	}
}
