package com.testapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extend_report {
	public static WebDriver react=null;
	public static void main(String[] args) throws InterruptedException {
		
	
ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("extent.html");	

ExtentReports extent=new ExtentReports();
extent.attachReporter(htmlReporter);

ExtentTest test=extent.createTest("Google Search Test1","This is a Test to validate");
String path=System.getProperty("user.dir")+"\\reports\\index.html";

test.log(Status.INFO, "Starting Test Case");


 react = new FirefoxDriver();


react.get("http://localhost:3000");
test.pass("Navigate To Homepage");
Thread.sleep(1000);			
react.findElement(By.xpath("//button[normalize-space()='Rent a Car']")).click();
Thread.sleep(1000);		
test.pass("Navigate To Login");
react.findElement(By.xpath("//button[normalize-space()=\"Don't have an account? Sign Up\"]")).click();
test.pass("Navigate To signup Page");
react.findElement(By.id("firstName")).sendKeys("Arjun");
test.pass("Enter Firstname");
react.findElement(By.id("lastName")).sendKeys("das");
test.pass("Enter Lastname");
react.findElement(By.id("username")).sendKeys("Arjun");
test.pass("Enter username");
react.findElement(By.id("useremail")).sendKeys("arjun@gmail.com");
test.pass("Enter useremail");
react.findElement(By.id("phoneNumber")).sendKeys("7676556752");
test.pass("Enter phonenumber");
react.findElement(By.id("address")).sendKeys("Velachery");
test.pass("Enter address");
react.findElement(By.id("userpassword")).sendKeys("arjun@12345678");
test.pass("Enter userpassword");
react.findElement(By.id("confirmPassword")).sendKeys("arjun@12345678");
test.pass("Enter confirmpassword");

	}
}
