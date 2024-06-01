package com.elaa.fancode.common;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetMethod {

	public static int ResponseStatusCode(String BaseURI, String Resource) {
		RestAssured.baseURI = BaseURI;
		int ResponseCode = given()
				.header("Content-Type", "application/json")
				.when()
				.get(Resource)
				.then()
				.extract()
				.statusCode();

		return ResponseCode;
	}

	public static Response ResponseBody(String BaseURI, String Resource) {
		RestAssured.baseURI = BaseURI;
		Response Response = given()
				.header("Content-Type", "application/json")
				.when().get(Resource)
				.then()
				.extract()
				.response();
				//.asPrettyString();

		return Response;
	}

}
