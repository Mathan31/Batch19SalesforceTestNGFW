package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import libraries.FakerDataFactory;
import pages.LoginPage;

public class TC02_CreateLead extends BaseClass{
	
	@BeforeTest
	public void testSetUp() {
		excelFileName = "TC02";
		authors = "Aravind";
		category = "Sanity";
		testName = "Create Lead Test";
		testDescription = "Validate create lead with only mandatory fields";
		testModule = "Create Lead module";
	}
			
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void createSalesLeadWithmandatoryFields(String uName,String password) {
		boolean result = new LoginPage(driver,node)
		.enterUserName(uName)
		.enterPassword(password)
		.clickOnLogin()
		.verifyHomeElement()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.clickOnSales()
		.clickOnLeadsLink()
		.clickOnNewButton()
		.enterLastName(FakerDataFactory.getLastName())
		.enterCompanyName(FakerDataFactory.getCompanyName())
		.clickAndSelectLeadStatus()
		.clickOnSaveButton()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElement();
		Assert.assertTrue(result);
		
		
	}
	
	
}
