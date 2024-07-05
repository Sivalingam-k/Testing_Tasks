package com.APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;//Make a Static  to RestAssured Package
import io.restassured.response.Response;
// Need Output in Json Formet
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ReactProjectHomepage {

	//@Test
	public void HomepageApiTest() {
		Response response=get("http://localhost:8888");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		System.out.println("statuscode:  "+statuscode);
	}
	
	@Test
	public void LoginApiTest() {
		baseURI="http://localhost:8888";
		given().get("/users").then().statusCode(200).body("[1].username",equalTo("siva") ).log().all();
	}
}
