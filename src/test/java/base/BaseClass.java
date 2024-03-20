package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import libraries.HTMLReport;
import utilities.ExcelReader;
import utilities.PropertiesReader;

public class BaseClass extends HTMLReport{
	
	public WebDriver driver; //11111
	public String fileName = "Environment";
	public String browserName = PropertiesReader.getPropertyValue(fileName, "Browser"); // Chrome,Firefox,Edge,IE,Safari
	String sURL = PropertiesReader.getPropertyValue(fileName, "URL");
	public String excelFileName="";
	public String testName,testDescription,testModule;
	
	@BeforeSuite
	public void reportInit() {
		startReport();
	}
	
	@AfterSuite
	public void wrapReport() {
		endReport();
	}
	
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
		driver.manage().window().maximize();
		driver.get(sURL);
		startTestCase(testName, testDescription);
		startTestcase(testModule);
	}
	
	@AfterClass	
	public  void closeBrowser() {
		driver.quit();
	}
	

	@DataProvider(name = "TestCaseData")
	public Object[][] excelData(){
		Object[][] values = ExcelReader.getValueFromExcel(excelFileName);
		return values;
	}
	
	@Override
	public String takeScreenshot() {
		String sPath = System.getProperty("user.dir")+"/snap/img"+System.currentTimeMillis()+".png";
		TakesScreenshot oShot = (TakesScreenshot)driver;
		File osrc = oShot.getScreenshotAs(OutputType.FILE);
		File dis = new File(sPath);
		try {
			FileUtils.copyFile(osrc, dis); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sPath;
	}
	

}
