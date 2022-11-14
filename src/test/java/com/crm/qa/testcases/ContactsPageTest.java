package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	String sheetname="Contacts";

	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage  = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
				
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		contactsPage.verfiyContactsLabel();
		
	}
	
	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException {	
		contactsPage.selectContactsByName("test tester");
		
		contactsPage.selectContactsByName("cnc  programmer");
	}
	
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
		

	}
	
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCrateNewContactTest(String firstname, String lastname, String category) {
		
		//contactsPage.crateNewContact("Pratik", "Modi", "Lead");
		contactsPage.crateNewContact(firstname, lastname, category);
	
	}

	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
