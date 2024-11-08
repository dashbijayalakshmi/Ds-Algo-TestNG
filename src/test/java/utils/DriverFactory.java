package Utils;


	import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.safari.SafariDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

	public class DriverFactory {
		
		public static WebDriver driver;
		
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DriverFactory.class);

		public WebDriver initializeDrivers(String browser) {
			
			if (browser.equalsIgnoreCase("chrome")) {
				logger.info("Testing on chrome");
			driver = new ChromeDriver();
			}
			
			else if (browser.equalsIgnoreCase("firefox")) {

				logger.info("Testing on firefox");
				driver = new FirefoxDriver();
			}  

			 else if (browser.equalsIgnoreCase("safari")) {

				logger.info("Testing on safari");
				driver = new SafariDriver();
				
			} else if (browser.equalsIgnoreCase("edge")) {

				logger.info("Testing on edge");
				driver = new EdgeDriver();
			}			
			// Set Page load timeout

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

			driver.manage().window().maximize();

			return driver;

		}
	public WebDriver getdriver()
	{
		return driver;
	}
	}



