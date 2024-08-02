package io.cal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class LifeCycleAnnotationTest {

	
	LifeCycleAnnotation m;
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("This will run before all the methods");
	}
	@AfterAll
	static void afterAll() {
		System.out.println("This will run at Last");
	}
	
	@BeforeEach
void init() {
		m=new LifeCycleAnnotation();
		System.out.println("InIt method is Working!");
}
	
	@AfterEach
void cleanUp() {
	System.out.println("Clean Up Now!");
}
	//@Test
void testSquare() {
	
		int expected=25;
		int actual=m.square(5);
		assertEquals(expected, actual,"Pass");
}
	//@Test
void testCube() {
		int expected=27;
		int actual=m.cube(3);
		assertEquals(expected, actual,"Pass");
}
	
	
	@Nested
	class testPositiveNumber{
		@Test
		void testNegativeNo() {
			int expected=-2;
			int actual=m.positive(-2,-2);
			assertEquals(expected,actual,()->"Should return -ve Value only");
		}
		//@Test
		void testPositiveNo() {
			int expected=-2;
			int actual=-2;
			assertEquals(expected,actual,"pass");
			assertEquals(2,m.positive(2, 2),"Should return a positive Value");
		}
	}

}
