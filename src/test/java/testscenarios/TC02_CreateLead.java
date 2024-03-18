package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

public class TC02_CreateLead extends BaseClass{
	
	@BeforeTest
	public void testSetUp() {
		excelFileName = "TC02";
	}
			
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void createSalesLeadWithmandatoryFields(String uName,String password,String lName,String companyName) {
		boolean result = new LoginPage()
		.enterUserName(uName)
		.enterPassword(password)
		.clickOnLogin()
		.verifyHomeElement()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.clickOnSales()
		.clickOnLeadsLink()
		.clickOnNewButton()
		.enterLastName(lName)
		.enterCompanyName(companyName)
		.clickAndSelectLeadStatus()
		.clickOnSaveButton()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElement();
		Assert.assertTrue(result);
		
		
	}
	
	
}
