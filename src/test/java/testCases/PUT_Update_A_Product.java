package testCases;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PUT_Update_A_Product {

	@Test
	public void put_Update_A_Product() {
		// https://techfios.com/api-prod/api/product

		//  given: all input details(base URL/ base URI,Headers,Payload/Body,QueryParameters)
		//  when:  submit api requests(Http method,Endpoint/Resource)
		//  then:  validate response(status code, Headers, responseTime, Payload/Body)
		
		Response response = 
			given()
			.baseUri("https://techfios.com/api-prod/api/product")
				.headers("Content-Type", "application/json")
				.body(new File("src\\main\\java\\data\\update_payload.json")).
			when()
				.put("/update.php").
			then()
				.extract().response();

		String responseBody = response.getBody().prettyPrint();
System.out.println("Response Body:"+ responseBody);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}
}
