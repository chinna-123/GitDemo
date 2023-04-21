package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumValidation() {
		int sum = 0;
		JsonPath js1 = new JsonPath(PayLoad.coursePrice());
		int count = js1.getInt("courses.size()");

		for (int i = 0; i < count; i++) {
			int copies = js1.getInt("courses[" + i + "].copies");
			int price = js1.getInt("courses[" + i + "].price");
			int amount = copies * price;
			System.out.println(amount);
			sum += amount;
		}
		System.out.println(sum);
		int purchaseAmount = js1.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}

}
