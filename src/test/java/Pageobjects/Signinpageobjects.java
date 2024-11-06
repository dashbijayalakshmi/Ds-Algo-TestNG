package Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utils.DriverFactory;

public class Signinpageobjects {
	private By register_link=By.linkText("Register");
	private By signin=By.linkText("Sign in");
	private By datastructure=By.linkText("Data Structures");
	private By dropdownlist=By.cssSelector("div.dropdown-menu");
	
	private By elements=By.cssSelector("a");
	private By username=By.cssSelector("#id_username");
	private By password=By.id("id_password");
	private By login_btn=By.xpath("//input[@value='Login']");
	private By alert_message=By.xpath("//div[@role='alert']");
	private By error_invalid_userPass=By.xpath("//div[contains(text(), 'Invalid Username and Password')]");
	private By registerbtn_on_loginpage=By.xpath("//div[@class='col-sm']/a[@href='/register']");
	public DriverFactory driverfactory;
	
	WebDriver driver;
	public Signinpageobjects(WebDriver driver) {
		//this.driver=driver;
		driverfactory=new DriverFactory();
		this.driver=driverfactory.getdriver();	
	}
	public boolean regis_sign(){
		WebElement register=driver.findElement(register_link);
		WebElement sign_in=driver.findElement(signin);
		return register.isDisplayed() && sign_in.isDisplayed();
	}
	
//	public void click_dropdownlist()
//	{
//		//driver.findElement(dropdown_arrow).click();
//		boolean dropdown=driver.findElement(dropdown_arrow).isDisplayed();
//		Assert.assertTrue(dropdown, "Dropdown list is not present");
//		System.out.println("Dropdown field is present");
//	}
//	
//	
//	public List<String> datastructure() {
//		driver.findElement(datastructure).click();
//		List<String>ListData=new ArrayList<>();
//		WebElement ddlist=driver.findElement(dropdownlist);
//		List<WebElement>listitems=ddlist.findElements(elements);
//		for(WebElement datastructure:listitems) {
//			String text=datastructure.getText();
//			ListData.add(text);
//		}
//		return ListData;
//		
//	}
	public void click_signin_link() {
		driver.findElement(signin).click();
		
	}
	public void enter_username(String string) {
		driver.findElement(username).sendKeys(string);
		

	}
	public void enter_password(String string1) {
		driver.findElement(password).sendKeys(string1);

	}
	public void click_login_btn() {
		driver.findElement(login_btn).click();
		
		}
	public WebElement logged_in() {
		WebElement you_login=driver.findElement(alert_message);
		return you_login;
	}
	
	public void press_tab_on_username() {
		driver.findElement(username).sendKeys(Keys.TAB);
		
	}
	public void press_tab_on_password() {
		driver.findElement(password).sendKeys(Keys.TAB);
		
	}
	public void error_username_req()
	{
		String message=driver.findElement(username).getAttribute("validationMessage");
		boolean username_error_dispalyed=message.matches("Please fill out this field.");
		Assert.assertTrue(username_error_dispalyed, "FAILED Error doesn't exist");
		System.out.println("PASSED Error - "+message+ " displayed when username is blank");
		
	}
	public void error_password_req()
	{
		String message1=driver.findElement(password).getAttribute("validationMessage");
		boolean password_error_displayed=message1.matches("Please fill out this field.");
		Assert.assertTrue(password_error_displayed, "FAILED Error doesn't exist");
		System.out.println("PASSED Error - "+message1+ " displayed when password is blank");
	}
	public void error_invalid_userandpass()
	{
		driver.findElement(error_invalid_userPass).getText();
		
	}
	public void click_register_from_signingpage()
	{
		driver.findElement(registerbtn_on_loginpage).click();
	}
}
