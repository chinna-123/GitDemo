package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPlace {
	// Validate if Add place API is working as expected
	// given - all input details
	// when - submit the api (resource,http method)
	// then - validate the response
	// Add place--> Update place with new address-->Get place to validate if New
	// Address in present in response
	@Test
	void addPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(PayLoad.addPlace())
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200)
				.body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.41 (Ubuntu)")
				.extract()
				.response()
				.asString();

		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String Place_Id = js.getString("place_id");
		System.out.println(Place_Id);

	}
}
