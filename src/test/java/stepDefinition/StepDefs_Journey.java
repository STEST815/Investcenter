package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import seleniumPages.Page_Home;

public class StepDefs_Journey {

	public WebDriver driver;

	public StepDefs_Journey() {
		driver = Hooks.driver;
	}

	@Given("^I navigate to the application successfully$")
	public void i_reached_the_main_Homepage() throws Throwable {
		driver.get("https://www.investcentre.co.uk");
	}

	@When("^I select the find out more button from Charges gadget$")
	public void i_select_find_more_button() throws Throwable {
		Page_Home homePage = new Page_Home(driver);
		homePage.clickFindmorebutton();
	}

	@And("^I verify that (.*) page is loaded successfully$")
	public void i_verify_page_is_loaded(String arg0) throws Throwable {
		Assert.assertTrue(driver.getTitle().contains(arg0));
	}

	@And("^I click (.*) download and ensure the PDF is displayed in new window$")
	public void i_download_pdf(String arg0) throws Throwable {
		Page_Home homePage = new Page_Home(driver);
		homePage.downloadpdf(arg0);
	}

	@When("^I select the Register icon in top navigation bar$")
	public void i_select_register_button() throws Throwable {
		Page_Home homePage = new Page_Home(driver);
		homePage.clickregisterbutton();
	}

	@And("^I verify Adviser registration page is displayed$")
	public void i_verify_registration_page_is_loaded() throws Throwable {
		Page_Home homePage = new Page_Home(driver);
		homePage.verifyregistration();
	}

	@And("^I click on continue button leaving the FCA firm reference blank and verify the (.*)$")
	public void i_click_continue(String arg0) throws Throwable {
		Page_Home homePage = new Page_Home(driver);
		homePage.clickContinue(arg0);
	}

	@And("^I click on continue button with (.*) into the FCA firm reference field and verify the (.*)$")
	public void i_click_continue_with_invalid_data(String arg0, String arg1) throws Throwable {
		Page_Home homePage = new Page_Home(driver);
		homePage.clickContinuewithinvaliddata(arg0, arg1);
	}

}
