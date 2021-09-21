package testCases;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class POST_Create_A_Product {

	@Test
	public void post_Create_A_Product() {
		//https://techfios.com/api-prod/api/product/create.php

			//  given: all input details(base URL/ base URI,Headers,Payload/Body,QueryParameters)
			//  when:  submit api requests(Http method,Endpoint/Resource)
			//  then:  validate response(status code, Headers, responseTime, Payload/Body)
Response response=
			given()
			.baseUri("https://techfios.com/api-prod/api/product")
				.headers("Content-Type", "application/json")
				.body(new File("src\\main\\java\\data\\payload.json")).
			when()
				.post("/create.php").
			then()
				.extract().response();

			
			  String responseBody = response.getBody().asString();
			  System.out.println("Response Body:"+ responseBody);
			 
		

	}
}
