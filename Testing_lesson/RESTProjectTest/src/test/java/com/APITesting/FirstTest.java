package com.APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;//Make a Static  to RestAssured Package
import io.restassured.response.Response;
// Need Output in Json Formet
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class FirstTest {

	//@Test	//Execute the Function
	public void GETapiTest1() {

		Response response=get("https://reqres.in/api/users?page=2");

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		System.out.println("statuscode:  "+statuscode);
	}
	//BDD
	@Test
	public void GETApiTest2() {
		baseURI="https://reqres.in/api";//Starting or base url
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();//EndPOint & Json Format
	given().get("/users?page=2").then().statusCode(200).body("data[1].email", equalTo("lindsay.ferguson@reqres.in"
			+ ""));
	
	}
}