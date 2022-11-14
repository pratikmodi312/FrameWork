package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory- OR:
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password; 
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn; 
	
	//Initialize page object 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pw) {
		email.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage(); 
	}
	
	

}
