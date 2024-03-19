package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC01_Login extends BaseClass{
	
	@BeforeTest
	public void testSetUp() {
		excelFileName = "TC01";
	}
	
	@Test(priority = 1)
	public void loginFieldVaidation() {
		boolean result = new LoginPage(driver)
		.verifyLoginElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void loginWithValidCredential(String uName,String password) {
		boolean result = new LoginPage(driver)
		.enterUserName(uName)
		.enterPassword(password)
		.clickOnLogin()
		.verifyHomeElement()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage(driver)
		.enterUserName("mathan@credosystemz.sanbox")
		.enterPassword("Mylearning$1")
		.clickOnLoginInValidCredential()
		.validateErrorMsg();
		Assert.assertTrue(result);
	}
	
	

}
