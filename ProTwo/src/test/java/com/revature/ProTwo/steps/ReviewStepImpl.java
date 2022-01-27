//package com.revature.ProTwo.steps;
//
//import org.openqa.selenium.WebDriver;
//
//import com.revature.ProTwo.pages.Page;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class ReviewStepImpl {
//	
//	private WebDriver driver;
//	private Page page;
//	
//	@Given("the user is on the page of a movie")
//	public void the_user_is_on_the_page_of_a_movie() {
//	    
//		page.navigateTo("http://localhost:4200/review");
//	}
//	
//	@When("the user can enter a review on the input box")
//	public void the_user_can_enter_a_review_on_the_input_box() {
//	    
//		page.reviewOnMovie(1,1,"I really like this movie","Movie",4);
//	}
//
//	@Then("review is uploaded on the page of the movie by clicking the Button")
//	public void review_is_uploaded_on_the_page_of_the_movie_by_clicking_the_button() {
//	    
//		page.uploadReviewClick();
//	}
//}
