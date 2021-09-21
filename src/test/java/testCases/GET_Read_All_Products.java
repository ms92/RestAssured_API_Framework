package testCases;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GET_Read_All_Products {

	@Test
	public void get_Read_All_Products() {
		// https://techfios.com/api-prod/api/product

		//  given: all input details(base URL/ base URI,Headers,Payload/Body,QueryParameters)
		//  when:  submit api requests(Http method,Endpoint/Resource)
		//  then:  validate response(status code, Headers, responseTime, Payload/Body)
		
		Response response = 
			given()
			.baseUri("https://techfios.com/api-prod/api/product")
				.headers("Content-Type", "application/json").
			when()
				.get("/read.php").
			then()
				.extract().response();

		response.getBody().prettyPrint();

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}
}
