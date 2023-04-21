package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
				.body(PayLoad.addBook(isbn, aisle))
				.when().post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();

		JsonPath js1 = ReUsableMethods.rawToJson(response);
		String id = js1.get("ID");
		System.out.println(id);

		// delete Book
	}

 /*	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		// array = collection of elements
		// multi-dimensional array = collection of arrays

		return new Object[][] { { "abhs", "1234" }, { "bchn", "4567" }, { "ghjk", "8765" } };
	} */
	
	@DataProvider(name="BooksData")

	public Object[][]  getData()

	{
		return new Object [][] { { "abhs", "1234" }, { "bchn", "4567" }, { "ghjk", "8765" } };
	}
}
