package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class MenuPage extends BaseClass{
	
	protected By applauncherIcon=By.xpath("//div[@class='slds-icon-waffle']");
	protected By viewAllLink = By.xpath("//button[text()='View All']");
	protected By salesLink = By.xpath("//span[@part='formatted-rich-text']/p[text()='Sales']");
	protected By logoutLink = By.xpath("//a[text()='Log Out']");
	protected By userImg=By.xpath("(//span[@class='uiImage']/parent::div[@data-aura-class='forceEntityIcon'])[1]");
	private WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public MenuPage clickOnAppLauncher() {
		driver.findElement(applauncherIcon).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	

	public SalesPage clickOnSales() { 
		driver.findElement(salesLink).click();
		return new SalesPage(driver);
	}
	
	public MenuPage clickOnViewAll() {
		driver.findElement(viewAllLink).click();
		return this;
	}
	
	public MenuPage clickUserImg()   {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(userImg).click();  
		return this;
	}
	
	public LoginPage clickLogout() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(logoutLink).click();
		return new LoginPage(driver);
	}

}
