package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public  static WebDriver driver;
	public  String browserName = "chrome"; // Chrome,Firefox,Edge,IE,Safari
	String sURL = "https://credosystemz2-dev-ed.my.salesforce.com/";
	
	@BeforeClass
	public  void invokeBrower() {
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.out.println("User option is : "+browserName+", So invoking chrome browser");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.out.println("User option is : "+browserName+", So invoking firefox browser");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.out.println("User option is : "+browserName+", So invoking edge browser");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.out.println("User option is : "+browserName+", So invoking ie browser");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("User option is wrong : "+browserName+", So invoking the default chrome browser");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(sURL);;
	}
	
	@AfterClass	
	public  void closeBrowser() {
		driver.quit();
	}
	
	

}
