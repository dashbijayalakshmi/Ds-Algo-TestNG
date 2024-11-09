package logic;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.TestContextSetup;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class SigninTest extends TestBase
{
	
	@BeforeMethod
	public void click_loginlink() throws InterruptedException
	{
		Signinpageobjects signinpage = new Signinpageobjects(driver);
		signinpage.click_signin_link();			
	}
	
	@Test
	public void tc01_validuserpass() throws InterruptedException
	{
		Signinpageobjects signinpage = new Signinpageobjects(driver);
		signinpage.enter_username("npatni");
		Thread.sleep(5000);
	}
	
	@Test
	public void tc02_validuserpass() throws InterruptedException
	{
		Signinpageobjects signinpage = new Signinpageobjects(driver);
		signinpage.enter_username("npatni1");
		Thread.sleep(5000);
	}

}
