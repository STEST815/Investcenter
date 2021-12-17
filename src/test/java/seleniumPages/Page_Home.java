package seleniumPages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Home extends Page_BasePage {
	public Page_Home(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CLASS_NAME, using = "grid-container-x")
	public static WebElement divgrid;

	@FindBy(how = How.NAME, using = "adviser")
	public static WebElement adviserbutton;

	@FindBy(how = How.LINK_TEXT, using = "FIND OUT MORE")
	public static List<WebElement> findmorelist;

	@FindBy(how = How.LINK_TEXT, using = "CHARGES – SIPP, ISA OR GIA")
	public static WebElement chargespdf;

	@FindBy(how = How.XPATH, using = "//a[@class='user-register'][1]")
	public static WebElement registerbutton;

	@FindBy(how = How.XPATH, using = "//form[@class='form-horizontal']/h1")
	public static WebElement formheader;

	@FindBy(how = How.NAME, using = "AdviserRegsitration_Login")
	public static WebElement continuebutton;

	@FindBy(how = How.CLASS_NAME, using = "field-validation-error")
	public static WebElement emptystringerrormessage;

	@FindBy(how = How.NAME, using = "FSRNumber_TextBox")
	public static WebElement inputfield;

	public static void waitForLoadPage(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public static void waitforElementThenClick(WebDriver driver, WebElement element) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();

		} catch (Exception e) {
		}
		Thread.sleep(2000);
	}
	
	public static void waitforElement(WebDriver driver, WebElement element) throws InterruptedException {
        try {
                WebDriverWait wait = new WebDriverWait(driver, 45);
                wait.until(ExpectedConditions.visibilityOf(element));

        } catch (Exception e) {
        }
        Thread.sleep(5000);
    }

	public static void scrollingToElementofaPage(WebDriver driver, WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void checkforpopup() {
		if (adviserbutton.isDisplayed()) {
			adviserbutton.click();
		}
	}

	public void clickFindmorebutton() {

		try {
			checkforpopup();
			waitForLoadPage(driver);
			System.out.println("Scroll to the button...");
			scrollingToElementofaPage(driver, divgrid);
			waitForLoadPage(driver);
			for (WebElement findmorebutton : findmorelist) {
				if (findmorebutton.getAttribute("href").contains("charges")) {
					waitforElementThenClick(driver, findmorebutton);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void downloadpdf(String downloadLink) {

		String MainWindow = driver.getWindowHandle();
		try {
			waitforElementThenClick(driver, chargespdf);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitForLoadPage(driver);

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			System.out.println("The child window is " + ChildWindow);
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				System.out.println("Current URL is " + driver.getCurrentUrl());
				Assert.assertTrue(driver.getCurrentUrl().contains("sites/default/files/AJBIC_charges_and_rates.pdf"));
				break;
			}
		}
	}

	public void clickregisterbutton() {

		checkforpopup();
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", registerbutton);
			waitForLoadPage(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyregistration() throws InterruptedException {
		waitForLoadPage(driver);
		System.out.println("\nWaiting for Page Load...");
		waitforElement(driver, formheader);
		Assert.assertTrue(formheader.getText().contentEquals("Adviser registration"));
	}

	public void clickContinue(String message) throws InterruptedException {
		continuebutton.click();
		System.out.println(emptystringerrormessage.getText().equalsIgnoreCase(message));
		waitforElement(driver, emptystringerrormessage);
		Assert.assertTrue(emptystringerrormessage.getText().equalsIgnoreCase(message));

	}

	public void clickContinuewithinvaliddata(String value, String message) throws InterruptedException {
		inputfield.sendKeys(value);
		continuebutton.click();
		waitforElement(driver, emptystringerrormessage);
		Assert.assertTrue(emptystringerrormessage.getText().equalsIgnoreCase(message));

	}

}
