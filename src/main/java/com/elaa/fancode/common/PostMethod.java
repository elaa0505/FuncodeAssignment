package com.elaa.fancode.common;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class PostMethod {

public static int ResponseStatusCode(String BaseURI, String Resource, String requestBody) {
		
		RestAssured.baseURI = BaseURI;	
		int statusCode = given().header("Content-Type","application/json").body(requestBody)
				.when().post(Resource).then().extract().statusCode();
		
		
		return statusCode;
	}
	
	public static String ResponseBody(String BaseURI, String Resource, String requestBody) {
		RestAssured.baseURI = BaseURI;	
		String responseBody = given().header("Content-Type","application/json").body(requestBody)
				.when().post(Resource).then().extract().response().asPrettyString();
		
		return responseBody;
	}

}
