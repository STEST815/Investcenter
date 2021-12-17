package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	public static WebDriver driver;
	public String browser;

	@Before
	public void openBrowser(Scenario scenario) throws Throwable {
		try {

			Properties properties = new Properties();

			File f = new File("resources/Browser.properties");
			if (f.exists()) {

				try {
					InputStream inputValue = new FileInputStream("resources/Browser.properties");
					properties.load(inputValue);
					browser = properties.getProperty("BrowserType");
					System.out.println("The main selected-browser is " + browser);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				try {
					InputStream inputValue = new FileInputStream("BankFeeds/resources/Browser.properties");
					properties.load(inputValue);
					browser = properties.getProperty("BrowserType");
					System.out.println("The main selected-browser is " + browser);
				} catch (Exception e) {
					e.printStackTrace();
				}


			}
		}catch (Exception e){
			System.out.println("\n could not set the value of browser type ");
			e.printStackTrace();
		}


		System.out.println("\n[SETUP] Running Scenario: " + scenario.getName());

		switch (browser){
		case "Chrome":
			WebDriverManager.chromedriver().version("96.0.4664.45").setup();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("headless");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			System.out.println("Launching in Chrome");
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().version("0.29.1").setup();
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.setBinary(firefoxBinary);
			driver = new FirefoxDriver(firefoxoptions);
			driver.manage().window().maximize();
			System.out.println("Launching in Firefox");
			break;  

		}

	}

	@After
	public void closeBrowser(Scenario scenario) {
		System.out.println("\n---- End Scenario ----\n");
		if(scenario.isFailed()){
			System.out.println("\n Last Scenario "+ scenario.getName() + " failed");

			try
			{
				// Create reference of TakesScreenshot
				TakesScreenshot ts=(TakesScreenshot)driver;

				// Call method to capture screenshot
				File source=ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./Screenshots/"+scenario.getName()+".png"));
				System.out.println("Screenshot taken for the failed scenario: "+scenario.getName() );
				System.out.println("\n the file path of the source file is "+ source.getAbsolutePath());
			}

			catch (Exception e)
			{

				System.out.println("Exception while taking screenshot "+e.getMessage());
			}

		}
		driver.quit();
	}
}
