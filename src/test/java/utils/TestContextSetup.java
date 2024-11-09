package utils;

import org.openqa.selenium.WebDriver;

import pageobjects.PageObjectManger;

public class TestContextSetup {
public WebDriver driver;
public PageObjectManger pageobjectmanager;
public ConfigReader configreader;
public DriverFactory driverfactory;

public TestContextSetup() throws Throwable {
	//pageobjectmanager=new PageObjectManger(testbase.WebDriverManager());
	driverfactory=new DriverFactory();
	String browser = configreader.getBrowserType();
	pageobjectmanager=new PageObjectManger(driverfactory.initializeDrivers(browser));
}
}
