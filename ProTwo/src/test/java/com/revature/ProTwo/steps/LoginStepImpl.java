package com.revature.ProTwo.steps;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.ProTwo.pages.Page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepImpl {

	private Page page;
	private WebDriver driver = null;

	{
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		page = new Page(driver);
	}


//	@Given("the user is on the movie login page")
//	public void the_user_is_on_the_movie_login_page() {
//		page.navigate().to(http://localhost:4200/movie);
//	}
//
//	@When("the user enters the username and password")
//	public void the_user_enters_the_username_and_password() {
//		page.submitLogin("standard_user_id", "secret_passwd");
//	}
//
//	@Then("the user should be taken to a different page")
//	public void the_user_should_be_taken_to_a_different_page() {
//		assertNotEquals("http://localhost:4200",driver.getCurrentUrl());
//	}
//
//	@When("the user enters an incorrect username and password")
//	public void the_user_enters_an_incorrect_username_and_password() {
//		page.submitLogin("incorrect", "incorrect");
//	}
//
//	@Then("the appropriate error message should appear")
//	public void the_appropriate_error_message_should_appear() {
//		String errorMsg = page.getErrorMessage();
//
//		assertTrue(errorMsg.contains("Username and password"));
//	}
//	
//	@Then("the user is still on the movie login page")
//	public void the_user_is_still_on_the_movie_login_page() {
//		page.navigateTo();
//	}
	

	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		page.navigateTo("http://localhost:4200/movie");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
	    
	    page.submitLogin("buster", "pass");
	}
	
	@And("user click on Submit")
	public void user_click_on_submit() {
		page.clickSubmitLogin();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		page.navigateTo("http://localhost:4200/movie");
		driver.close();
		driver.quit();
	}

}



