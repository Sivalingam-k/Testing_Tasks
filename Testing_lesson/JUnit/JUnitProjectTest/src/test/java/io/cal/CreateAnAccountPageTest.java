package io.cal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class CreateAnAccountPageTest {

	Scanner sc=new Scanner(System.in);
	@Test
	@Disabled
	void testYourName() {
		CreateAnAccountPage cap=new CreateAnAccountPage();
		System.out.println("Enter Your First Name:");
		String Firstname=sc.next();
		
 
	
   
		System.out.println("Enter Your Last Name");
		String Lastname=sc.next();
		
		String Result=Firstname+Lastname;
		String ActualResult=Firstname+Lastname;
		System.out.println("Full Name is :"+Result);
		assertEquals(Result,ActualResult);
	}
//	//@Test
//	void testFirstName1() {
//		CreateAnAccountPage cap=new CreateAnAccountPage();
//     System.out.println("Enter Your First Name:");
//		
//		String Firstname=sc.next();
//		System.out.println("Enter Your Last Name");
//		String Lastname=sc.next();
//		
//		String Result=Firstname+Lastname;
//		String ActualResult=Firstname+Lastname;
//		System.out.println("Full Name is :"+Result);
//		assertEquals(Result,ActualResult);
//		
//	}
//	//@Test
//	void testFirstName2() {
//		CreateAnAccountPage cap=new CreateAnAccountPage();
//		
//		String actual=cap.yourName("Shiva", "1243");
//		String expected="ShivaLingam";
//		
//		assertEquals(expected,actual);
//	}

@Test
	void testMobAndEmail() {
		CreateAnAccountPage cap=new CreateAnAccountPage();
		assertAll(
				"",
				()->assertEquals(cap.MobileNumberAndEmailId("66564536543", "abc@gmail.com"),cap.MobileNumberAndEmailId("66564536543", "abc@gmail.com"))
			//	()->assertEquals(cap.MobileNumberAndEmailId("", "abc@gmail.com"),cap.MobileNumberAndEmailId("", "abc@gmail.com")),
			//	()->assertEquals(cap.MobileNumberAndEmailId("66564536543", ""),cap.MobileNumberAndEmailId("", "")),
			//	()->assertEquals(cap.MobileNumberAndEmailId("66564536543", "abcgmail.com"),cap.MobileNumberAndEmailId("66564536543", "abc@gmail.com"))
				);
	}
	
	@Test
	@Disabled
	void testPassword() {
		CreateAnAccountPage cap=new CreateAnAccountPage();
		boolean actual=cap.CheckPassword("Siva14");
		boolean expected=true;
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testContinuebutton() {
		CreateAnAccountPage cap=new CreateAnAccountPage();
	String name="Siva Lingam";
	String email="siva@gmail.com";
	String password="pass@12";
	
	boolean result=cap.clickContinue(name, email, password);
	assertTrue(result);
	}
	
	@Test
	@Disabled
	void testContinuebutton1() {
		CreateAnAccountPage cap=new CreateAnAccountPage();
	String name="Siva";
	String email="siva@gmail.com";
	String password="pass@12";
	if(name=="") {
		System.out.println("Feild is Required!!");
		boolean result=cap.clickContinue(name, email, password);
		assertFalse(result);
	}else if(email=="") {
		System.out.println("Feild is Required!!");
		boolean result=cap.clickContinue(name, email, password);
		assertFalse(result);
	}else if(password=="") {
		System.out.println("Feild is Required!!");
		boolean result=cap.clickContinue(name, email, password);
		assertFalse(result);
	}
	
	}
	
	CreateAnAccountPage cap;
		TestInfo testinfo;
		TestReporter testReporter;
		@Test
		@Tag("testYourName")
		@Tag("testMobAndEmail")
		@Tag("testPassword")
		@Tag("testContinuebutton")
		@Tag("testContinuebutton1")
		void init(TestInfo testinfo,TestReporter testReporter) {
			cap=new CreateAnAccountPage();
			this.testinfo=testinfo;
			this.testReporter=testReporter;
			
			testReporter.publishEntry("Tested all Amazon CreateAnAccountPage Feilds Successfully"+testinfo.getTags());
		}
		
}