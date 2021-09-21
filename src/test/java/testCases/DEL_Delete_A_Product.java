package testCases;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class DEL_Delete_A_Product {

	SoftAssert softassert = new SoftAssert();
	
	@Test
	public void del_Delete_A_Product() {
		//https://techfios.com/api-prod/api/product?id=2160
		
	//  given: all input details(base URL/ base URI,Headers,Payload/Body,QueryParameters)
	//  when:  submit api requests(Http method,Endpoint/Resource)
	//  then:  validate response(status code, Headers, responseTime, Payload/Body)
		
		Response response = 
			given()
			.baseUri("https://techfios.com/api-prod/api/product/delete.php")
			.headers("Content-Type", "application/json")
			.body(new File("src\\main\\java\\data\\delete_payload.json")).
			when()
				.delete("/delete.php").
			then()
				.extract().response();

		response.getBody().prettyPrint();

		String responseBody = response.getBody().asString();
		System.out.println("Response Body:"+ responseBody );;

	}
}
