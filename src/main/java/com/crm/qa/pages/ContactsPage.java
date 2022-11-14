package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	////a[text()='test tester']//parent::td//preceding-sibling::td//input[@name='id']
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement createBtn;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//form[@class='ui form segment custom-form-container']/div[4]/div[2]/div[1]/div[1]")
	WebElement categoryDropDwn;
	
	@FindBy(xpath ="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	
	//@FindBy(xpath="//table[@class='ui celled sortable striped table custom-grid']//tbody//tr")
	//WebElement checkbox;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verfiyContactsLabel() {
		String contactLabelDisp = contactsLabel.getText();
		Assert.assertEquals(contactLabelDisp, "Contacts");
		
	
	}
	
	public void selectContactsByName(String name) throws InterruptedException {
		
		//WebElement mousemove = driver.findElement(By.xpath("//th[contains(text(),'Address')])"));
		//Actions builder = new Actions(driver);
		//builder.moveByOffset(1500, 0);
		
		
		Actions builder = new Actions(driver);
		builder.moveByOffset(38,36).build().perform();
		
		//Thread.sleep(4000);
		
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div[@class=\"ui fitted read-only checkbox\"]")).click();
		//driver.findElement(By.xpath("//div[@class='ui fitted read-only checkbox']//label")).click();
		//checkbox.click();
		////a[text()='test tester']//parent::td//preceding-sibling::td//input[@name='id']
	}
	
	public void crateNewContact( String ftName, String ltName, String category) {
		
		createBtn.click();
		
		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		
//		Select select = new Select(driver.findElement(By.xpath("//div[@class=\"ui selection dropdown\" and @name=\"category\"]")));
//		select.selectByVisibleText(category);
		
		categoryDropDwn.click();
		driver.findElement(By.xpath("//span[contains(text(),'"+category+"')]")).click();
		saveBtn.click();
	}
	
	
	
}
