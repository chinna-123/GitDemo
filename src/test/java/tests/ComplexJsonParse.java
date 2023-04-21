package tests;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath js1 = new JsonPath(PayLoad.coursePrice());
		// Print the number of courses returned by API

		int count = js1.getInt("courses.size()");
		System.out.println(count);

		// Print Purchase Amount

		int purchaseAmount = js1.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);

		// Print Title of the first course

		String title = js1.getString("courses[0].title");
		System.out.println(title);

		// Print all courses Title and their respective Prices

		for (int i = 0; i < count; i++) {
			System.out.println(js1.get("courses[" + i + "].title"));
			System.out.println(js1.getInt("courses[" + i + "].price"));
		}
		// Print number of copies sold by RPA

		System.out.println(" ");
		System.out.println("Print number of copies sold by RPA");
		for (int i = 0; i < count; i++) {
			String courseTitle = js1.get("courses[" + i + "].title");
			if (courseTitle.equalsIgnoreCase("RPA")) {
				int copies = js1.getInt("courses[" + i + "].copies");
				System.out.println(copies);
				break;
			}
		}
	}
}
