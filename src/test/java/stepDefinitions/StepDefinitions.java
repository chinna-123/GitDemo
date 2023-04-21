package stepDefinitions;

import java.util.List;

import org.junit.runner.RunWith;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class) // Just to say that these methods will run with cucumber features....

public class StepDefinitions {

	@Given("User is on NetBanking landing page")
	public void user_is_on_net_banking_landing_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("navigated to login URL");
	}

	@When("User login into application with {string} and password {string}")
	public void user_login_into_application_with_and_password(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(string);
		System.out.println(string2);
	}

	@Then("Home page is populated")
	public void home_page_is_populated() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("validated home page");
	}

	@And("Cards displayed are {string}")
	public void cards_displayed_are(String string) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(string);
	}

	@When("User sign up with following details")
	public void user_sign_up_with_following_details(DataTable data) {
		// Write code here that turns the phrase above into concrete actions
		List<List<String>> obj = data.asLists();
		System.out.println(obj.get(0).get(0));
		System.out.println(obj.get(0).get(1));
		System.out.println(obj.get(0).get(2));
		System.out.println(obj.get(0).get(3));
		System.out.println(obj.get(0).get(4));
	}
	
	@When("^User login in to application with (.+) and password (.+)$")
	public void user_login_in_to_application_with_and_password(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		
	}
	
	@Given("Validate the browser")
	public void validate_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("deciding the browser to open");
	}

	@When("Browser is triggered")
	public void browser_is_triggered() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Browser is triggered");
	}

	@Then("check if browser is started")
	public void check_if_browser_is_started() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Browser is started");
	}
}
