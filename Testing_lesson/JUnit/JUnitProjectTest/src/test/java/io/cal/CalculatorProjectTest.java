package io.cal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.lang.NullPointerException;
class CalculatorProjectTest {

	@Test
	void add() {
		CalculatorProject cp=new CalculatorProject();
	int expected=2;
	int actual=cp.add(1,1);
	
	
	assertEquals(expected,actual,"Add Function can Calulate Two Integers..!");
	}
	
	@Test
	void sub() {
		CalculatorProject cp=new CalculatorProject();
	int expected=3;
	int actual=cp.sub(6,3);
	
	
	assertEquals(expected,actual,"Subtraction Function can Calulate Two Integers..!");
	}

	@Test
	void mul() {
		CalculatorProject cp=new CalculatorProject();
	int expected=18;
	int actual=cp.mul(6,3);
	
	
	assertEquals(expected,actual,"MUltiply Function can Calulate Two Integers..!");
	}

	@Test
	void div() {
		CalculatorProject cp=new CalculatorProject();

	int expected=0;
	int actual=6;
	
	assertThrows(NullPointerException.class,()->cp.div(0, 6),"Divide Function will Divide Two Integer");
	}
	
	@Test
	void AreaOfCircle() {
		CalculatorProject cp=new CalculatorProject();
		assertEquals(314.1592653589793,cp.AreaOfCircle(10));
	}
	
@Test
	void positiveNumber() {
		CalculatorProject cp=new CalculatorProject();
		boolean actual=cp.positiveNumber(5);
		boolean expected=true;
		assertEquals(actual,expected,"Checking Positive Number");
	
	}


}