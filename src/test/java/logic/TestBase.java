package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	
//	public TestBase(TestContextSetup testcontextsetup) 
//	{
//		this.testcontextsetup = testcontextsetup;
//		this.landingpage = testcontextsetup.pageobjectmanager.getLandingpageobjects();
//		this.signinpage = testcontextsetup.pageobjectmanager.getSigninpageobjects();
//		this.driverfactorypage = testcontextsetup.pageobjectmanager.getdriverfactory();
//		this.configreaderfile = testcontextsetup.pageobjectmanager.getconfigreaderfile();
//	}
	
	static WebDriver driver;
	private By getStarted = By.linkText("Get Started");
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DriverFactory.class);
	
    @BeforeTest
	@Parameters({"browser"})
	public void adefineBrowser(@Optional("chrome") String browser) throws Throwable {
		ConfigReader.setBrowserType(browser);
	}
    
	@BeforeTest
	public void bbefore() throws Throwable
	{	
		//Get browser Type from config file
		logger.info("Loading Config file");
		String browser = ConfigReader.getBrowserType();
		//Initialize driver from driver factory
		driverfactorypage = new DriverFactory();
		driver = driverfactorypage.initializeDrivers(browser);
		driverfactorypage.getdriver();
		logger.info("Initializing driver for : " + browser);
	}
	
	@BeforeTest 
	public void cbefore() throws IOException
	{
		System.out.println("Launching the browser");
		//driver = new ChromeDriver();
		String path = System.getProperty("user.dir") + "/src/test/resources/global.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("URL");
		driver.get(url);
		System.out.println("Opening the url from properties file");
		driver.findElement(getStarted).click();
	}
	
	
	@AfterTest
	public void after()
	{
		System.out.println("Closing the browser");
		driver.quit();
	}
	
}
