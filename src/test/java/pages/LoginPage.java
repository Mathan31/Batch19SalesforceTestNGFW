package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends MenuPage{
	
	private By usernameTxt=By.id("username");
	private By passwordTxt=By.id("password");
	private By loginBtn=By.id("Login");
	private By remembermeChBox=By.xpath("//label[text()='Remember me']");
	private By forgotLink=By.id("forgot_password_link");
	private By loginFailureMsg = By.cssSelector("#error");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean verifyLoginElement() {
		if(driver.findElement(usernameTxt).isDisplayed() && 
				driver.findElement(passwordTxt).isDisplayed() && 
				driver.findElement(loginBtn).isDisplayed() && 
				driver.findElement(remembermeChBox).isDisplayed() && 
				driver.findElement(forgotLink).isDisplayed() ) {
			return true;
		}else {
			return false;
		}
	}
	
	public LoginPage enterUserName(String userName) {
		driver.findElement(usernameTxt).sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(passwordTxt).sendKeys(password);
		return this;
	}
	
	public HomePage clickOnLogin() {
		driver.findElement(loginBtn).click();
		return new HomePage(driver);
	}
	
	public LoginPage clickOnLoginInValidCredential() {
		driver.findElement(loginBtn).click();
		return this;
	}
	
	public boolean validateErrorMsg() {
		if(driver.findElement(loginFailureMsg).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	

}
