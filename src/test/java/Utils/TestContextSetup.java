package Utils;

import org.openqa.selenium.WebDriver;

import Pageobjects.PageObjectManger;

public class TestContextSetup {
public WebDriver driver;
public PageObjectManger pageobjectmanager;
public ConfigReader configreader;
//public TestBase testbase;
public DriverFactory driverfactory;

public TestContextSetup() throws Throwable {
	//testbase=new TestBase();
	//pageobjectmanager=new PageObjectManger(testbase.WebDriverManager());
	driverfactory=new DriverFactory();
	String browser = configreader.getBrowserType();
	pageobjectmanager=new PageObjectManger(driverfactory.initializeDrivers(browser));
}
}
