package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

//import files.PayLoad;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {
	// Validate if Add place API is working as expected
	// given - all input details
	// when - submit the api (resource,http method)
	// then - validate the response
	// Add place--> Update place with new address-->Get place to validate if New Address in present in response
	
	@Test
	void updatePlace() throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\ADUGGI\\OneDrive - Capgemini\\Documents\\learnings\\Testing\\Rest Assured\\static.json"))))
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
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
