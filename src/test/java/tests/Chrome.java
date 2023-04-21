package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Chrome {

	@Test
	public void chromePlace() {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all()
				.header("Content-Type", "application/json")
				.body("{\r\n"
						+ " \"name\" : \"Aman\",\r\n"
						+ " \"Job\" : \"Teacher\"\r\n"
						+ "}")
				.when().post("/api/users/2").then().log().all()
				.assertThat().statusCode(201).extract().response().asString();
		System.out.println(response);

	}
}
