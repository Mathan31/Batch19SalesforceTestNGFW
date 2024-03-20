package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class MenuPage extends BaseClass{
	
	protected By applauncherIcon=By.xpath("//div[@class='slds-icon-waffle']");
	protected By viewAllLink = By.xpath("//button[text()='View All']");
	protected By salesLink = By.xpath("//span[@part='formatted-rich-text']/p[text()='Sales']");
	protected By logoutLink = By.xpath("//a[text()='Log Out']");
	protected By userImg=By.xpath("(//span[@class='uiImage']/parent::div[@data-aura-class='forceEntityIcon'])[1]");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public MenuPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public MenuPage clickOnAppLauncher() {
		//driver.findElement(applauncherIcon).click();
		oWrap.click(driver.findElement(applauncherIcon), "App Launcher");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	

	public SalesPage clickOnSales() { 
		oWrap.click(driver.findElement(salesLink), "Sales Link");
		return new SalesPage(driver,node);
	}
	
	public MenuPage clickOnViewAll() {
		oWrap.click(driver.findElement(viewAllLink), "ViewAll Link");
		return this;
	}
	
	public MenuPage clickUserImg()   {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oWrap.click(driver.findElement(userImg), "User Image");
		return this;
	}
	
	public LoginPage clickLogout() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oWrap.click(driver.findElement(logoutLink), "Logout Link");
		return new LoginPage(driver,node);
	}

}
