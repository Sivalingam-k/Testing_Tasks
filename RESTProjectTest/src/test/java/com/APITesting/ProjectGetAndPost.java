package com.APITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;//Make a Static  to RestAssured Package

import io.restassured.http.ContentType;
import io.restassured.response.Response;
// Need Output in Json Formet
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

public class ProjectGetAndPost {
	//@Test
		public void testGet1() {
			baseURI="http://localhost:8888";
			given().get("/users").then().statusCode(200).body("[1].id",equalTo("3") ).log().all();
		
			//given().get("/users").then().statusCode(200).body("users[0].username",equalTo("sandeep") ).body("users[1].id",equalTo("3")).log().all();
		}
		//@Test
		public void GETRequest2() {
			baseURI="http://localhost:8888";
			given().get("/users").then().statusCode(200).body("username",hasItems("siva","sandeep") ).log().all();
		}
		@Test
		public void POSTRequest1() {
			Map<String,Object> map=new HashMap<String,Object>();
			JSONObject request=new JSONObject(map);
			request.put("name", "Siva");
			request.put("job", "Tester");
			System.out.println(request.toJSONString());
			
		baseURI="http://localhost:8888";
			given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).post("/users").then().statusCode(201).log().all();
		}
}