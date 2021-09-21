package testCases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class GET_Read_A_Product {

	SoftAssert softassert = new SoftAssert();
	
	@Test
	public void get_Read_A_Product() {
		//https://techfios.com/api-prod/api/product?id=2160
		
	//  given: all input details(base URL/ base URI,Headers,Payload/Body,QueryParameters)
	//  when:  submit api requests(Http method,Endpoint/Resource)
	//  then:  validate response(status code, Headers, responseTime, Payload/Body)
		
		Response response = 
			given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.headers("Content-Type", "application/json")
			.queryParam("id","2160").
			when()
				.get("read_one.php").
			then()
				.extract().response();

		response.getBody().prettyPrint();

		String responseBody = response.getBody().asString();
		System.out.println("Response Body:"+ responseBody );;

	}
}
