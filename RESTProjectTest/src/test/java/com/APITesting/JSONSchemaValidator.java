package com.APITesting;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.hasItems;
import static io.restassured.RestAssured.*;//Make a Static  to RestAssured Package

public class JSONSchemaValidator {

	@Test
	public  void testGet1(){
		baseURI="http://localhost:8888";
		given().get("/car").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
	}
}
