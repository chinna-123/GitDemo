package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before("@MobileTest")
	public void beforeValidation() {
		System.out.println("Before Mobile Hooks : ");
		
	}
	@After("@MobileTest")
	public void afterValidation() {
		System.out.println("After Mobile Hooks : ");
		
	}
	
	@Before("@WebTest")
	public void beforeWebValidation() {
		System.out.println("Before Web Hooks : ");
		
	}
	@After("@WebTest")
	public void afterWebValidation() {
		System.out.println("After Web Hooks : ");
		
	}
}

	// https://github.com/selenium-cucumber/selenium-cucumber-java-maven-example
	// https://github.com/mubbashir/appium-java-cucumber-gradle