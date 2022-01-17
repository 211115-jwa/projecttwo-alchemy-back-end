package com.revature.ProTwo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {

	private WebDriver driver;

	@FindBy(id="user_id")
	private WebElement usernameInput;
	@FindBy(id="passwd")
	private WebElement passwordInput;
	@FindBy(id="loginBtn")
	private WebElement loginBtn;

	
	@FindBy(id="commentMovie")
	WebElement cmmtBtn;

	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo() {
		driver.get("http://localhost:8080");
	}

	public void submitLogin(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginBtn.click();
	}

	// Add Tag element from the front end if not use the next code with ID
	//	public String getErrorMessage() {
	//		WebElement errorMsg = driver.findElement(By.tagName(""));
	//		return errorMsg.getText();
	//	}

	public String getErrorMessage() {
		WebElement errorMsg = driver.findElement(By.id(""));
		return errorMsg.getText();
	}

	public void commentClick() {
		
		cmmtBtn.click();
	}
	
	@FindBy(id="review_id")
	WebElement rvwid;
	@FindBy(id="user_id")
	WebElement userid;
	@FindBy(id="commentText")
	WebElement cmmText;
	@FindBy(id="postComment")
	WebElement cmmSub;

	public void commentOnReview(int i, int j, String string) {
		
		rvwid.sendKeys(String.valueOf(i));
		userid.sendKeys(String.valueOf(j));
		cmmText.sendKeys(string);
	}

	public void postComment() {
		
		cmmSub.click();	
	}

	
	@FindBy(id="firstName") // This can change
	WebElement first;
	@FindBy(id="lastName")	// This can change
	WebElement last;
	@FindBy(id="saveBtn")	// This can change
	WebElement saveBtn;
	
	public void editProfile(String fst, String lst) {
		
		first.sendKeys(fst);
		last.sendKeys(lst);
	}
	
	public void saveEditClick() {
		
		saveBtn.click();
	}
	
	
}




