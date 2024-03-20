package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import libraries.SeleniumWrapper;

public class HomePage extends MenuPage{
	
private WebDriver driver;
private SeleniumWrapper oWrap;
	
	public HomePage(WebDriver driver,ExtentTest node) {
		super(driver,node);
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public HomePage verifyHomeElement() {
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(applauncherIcon), "App Launcher") && 
				oWrap.verifyDisplayedwithReturn(driver.findElement(userImg), "User Image"))
		{
				System.out.println("User landed to the home page");
			return this;
		}else {
			System.out.println("User not landed to the home page");
			return this;
		}
	}
	
	
	

}
