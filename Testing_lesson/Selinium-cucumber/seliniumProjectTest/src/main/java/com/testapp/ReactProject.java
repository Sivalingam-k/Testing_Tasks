package com.testapp;




import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
public class ReactProject {

public static void main(String[] args) throws InterruptedException {


			WebDriver react = new FirefoxDriver();


			 react.get("http://localhost:3000");
Thread.sleep(1000);			
react.findElement(By.xpath("//button[normalize-space()='Rent a Car']")).click();
Thread.sleep(1000);		

			 react.findElement(By.xpath("//button[normalize-space()=\"Don't have an account? Sign Up\"]")).click();

			 react.findElement(By.id("firstName")).sendKeys("Arjun");

			 react.findElement(By.id("lastName")).sendKeys("das");

			 react.findElement(By.id("username")).sendKeys("Arjun");

			 react.findElement(By.id("useremail")).sendKeys("arjun@gmail.com");

			 react.findElement(By.id("phoneNumber")).sendKeys("7676556752");

			 react.findElement(By.id("address")).sendKeys("Velachery");

			 react.findElement(By.id("userpassword")).sendKeys("arjun@12345678");

			 react.findElement(By.id("confirmPassword")).sendKeys("arjun@12345678");

			 

		//	react.findElement(By.className("MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-fullWidth css-1vhaqj4-MuiButtonBase-root-MuiButton-root")).click();	
			 }

	}



