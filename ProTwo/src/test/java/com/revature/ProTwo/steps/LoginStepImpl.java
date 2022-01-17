package com.revature.ProTwo.steps;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.ProTwo.pages.Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepImpl {

	private Page page;
	private WebDriver driver;

	{
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		page = new Page(driver);
	}


	@Given("the user is on the movie login page")
	public void the_user_is_on_the_movie_login_page() {
		page.navigateTo();
	}

	@When("the user enters the username and password")
	public void the_user_enters_the_username_and_password() {
		page.submitLogin("standard_user_id", "secret_passwd");
	}

	@Then("the user should be taken to a different page")
	public void the_user_should_be_taken_to_a_different_page() {
		assertNotEquals("http://localhost:8080",driver.getCurrentUrl());
	}

	@When("the user enters an incorrect username and password")
	public void the_user_enters_an_incorrect_username_and_password() {
		page.submitLogin("incorrect", "incorrect");
	}

	@Then("the appropriate error message should appear")
	public void the_appropriate_error_message_should_appear() {
		String errorMsg = page.getErrorMessage();

		assertTrue(errorMsg.contains("Username and password"));
	}

}
