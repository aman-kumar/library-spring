package com.aman.libraryspring;

import static org.junit.Assert.*;

import org.junit.Test;

public class ApplicationConfigurationTest {

	@Test
	public void testGetValue() {
		assertEquals("org.hsqldb.jdbcDriver",
				ApplicationConfiguration.INSTANCE.getValue("test.jdbc.drivername"));
	}
}
