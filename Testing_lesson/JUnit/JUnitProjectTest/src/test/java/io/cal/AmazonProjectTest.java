package io.cal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AmazonProjectTest {

	@Test
	void testAmazonLine() {
	
		String expected="spend less ,Smile more";
		String actual="spend less ,Smile more";
		
		assertEquals(expected,actual);
		assertSame(expected,actual,"Expected result should match with actual");
	}

}
