package io.cal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class ConditionalAssumptionsTest {

	@Test
	@EnabledOnOs(OS.LINUX)
	void testOperatingSys() {
		System.out.println("I am Working On Linux");
	}
	
}
