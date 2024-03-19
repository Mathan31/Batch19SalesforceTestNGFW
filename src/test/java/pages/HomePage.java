package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends MenuPage{
	
private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public HomePage verifyHomeElement() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.findElement(applauncherIcon).isDisplayed() && 
				driver.findElement(userImg).isDisplayed())
		{
				System.out.println("User landed to the home page");
			return this;
		}else {
			System.out.println("User not landed to the home page");
			return this;
		}
	}
	
	
	

}
