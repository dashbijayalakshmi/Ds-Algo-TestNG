package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.ConfigReader;
import Utils.DriverFactory;
import Utils.TestContextSetup;

public class TestBase 
{
	TestContextSetup testcontextsetup;
	landingpageobjects landingpage;
	Signinpageobjects signinpage;
	static DriverFactory driverfactorypage;
	ConfigReader configreaderfile;
	
	public TestBase() {
		// Set up a simple configuration that logs on the console.
	    BasicConfigurator.configure();
	}
	
	WebDriver driver;
	//protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private By getStarted = By.linkText("Get Started");
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DriverFactory.class);
	
    
	@BeforeMethod
	@Parameters("browser")
	public void abefore(String browser) throws Throwable
	{	
		driver = new ThreadLocal<WebDriver>();
		driverfactorypage = new DriverFactory();
		driver.set(driverfactorypage.initializeDrivers(browser));
		//driverfactorypage.getdriver();
		logger.info("Initializing driver for : " + browser);
	}
	
	@BeforeMethod
	public void bbefore() throws IOException
	{
		System.out.println("Launching the browser");
		String path = System.getProperty("user.dir") + "/src/test/resources/global.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("URL");
		driver.get().get(url);
		System.out.println("Opening the url from properties file");
		driver.get().findElement(getStarted).click();
	}
	
	@DataProvider (name="Logindataprovider")
		public Object [][] dataprovider_method()
		{
			return new Object[][] {{"ninjatesterss" , "ninja@123"}};
			
		}
	
		
	
	
	
	@DataProvider (name="Logindataprovider")
	public Object [][] dataprovider_method()
	{
		return new Object[][] {{"ninjatesterss" , "ninja@123"}};
		
	}
	
	@AfterMethod
	public void after()
	{
		System.out.println("Closing the browser");
		driver.get().quit();
	}
	
}
