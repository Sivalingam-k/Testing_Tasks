package com.testapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		

		//WebDriver wd=new ChromeDriver();
		
		//wd.get("http://www.mahendra.info/");
		
//		WebDriver driverfox=new FirefoxDriver();
//		driverfox.get("http://www.mahendra.info/");
		
//		WebDriver driveredge=new EdgeDriver();
//	driveredge.get("https://www.google.com/intl/en-US/gmail/about/");
		
//		WebDriver driver=new FirefoxDriver();//Launching the Browser
//		driver.get("https://www.google.com/");//opening front page
		
	
//			Thread.sleep(500);//Giving time to search gmail
//	
//		
//		driver.findElement(By.id("APjFqb")).sendKeys("gmail");
//		Thread.sleep(500);
//		driver.findElement(By.className("gNO89b")).click();
//		
//		Thread.sleep(500);
//		driver.findElement(By.className("LC20lb MBeuO DKV0Md")).click();
//		
//    	Thread.sleep(500);
//		driver.findElement(By.className("button button--medium button--mobile-before-hero-only  ")).click();
		
		
		
		WebDriver driver=new FirefoxDriver();//Launching the Browser
		driver.get("https://www.google.com/intl/en/gmail/about/");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();		
		
		driver.findElement(By.id("identifierId")).sendKeys("siva48359@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("button[class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b'] span[class='VfPpkd-vQzf8d']")).click();	
		
		
		
		
		
}}