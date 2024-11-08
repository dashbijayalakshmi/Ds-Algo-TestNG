package logic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.Signinpageobjects;
import Pageobjects.landingpageobjects;
import Utils.DriverFactory;
import Utils.TestContextSetup;

public class LoginPage 
{
//	TestContextSetup testcontextsetup;
//	Signinpageobjects signinpage;
//	landingpageobjects landingpage;
////	WebDriver driver;
//	
//	public void signinStepDefination(TestContextSetup testcontextsetup) {
//		this.testcontextsetup=testcontextsetup;
//		this.signinpage=testcontextsetup.pageobjectmanager.getSigninpageobjects();
//		this.landingpage=testcontextsetup.pageobjectmanager.getLandingpageobjects();
//	}
//	
//	
//	
//	@BeforeClass
//	public void open_LoginPage() throws Exception
//	{
//		System.out.println("1");
//		
//		signinpage.click_signin_link();	
//		System.out.println("2");
//		
//	}
//	
	@Test
	public void tc01_validuserpass()
	{
		System.out.println("Login");
		
	}

}
