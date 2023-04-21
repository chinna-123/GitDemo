package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UpdatePlace {
	// Validate if Add place API is working as expected
	// given - all input details
	// when - submit the api (resource,http method)
	// then - validate the response
	// Add place--> Update place with new address-->Get place to validate if New Address in present in response
	
	@Test
	void updatePlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(PayLoad.addPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);		
		JsonPath js = new JsonPath(response);
		String Place_Id = js.getString("place_id");
		System.out.println(Place_Id);
	
	// Update Place
		String newAddress = "Sunkesula , Peddaraveedu Mandal";
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+Place_Id+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
	// Get Place
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", Place_Id)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
	//	JsonPath js1 = new JsonPath(getPlaceResponse);
		JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
	// cucumber Junit , TestNg	
	}
}
