package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalhomepage;
import resources.base;

public class stepDefination extends base {

	@Given("^Initilaize the browser with chrome$")
	public void initilaize_the_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();

	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// in cucumber we don't have to pass the global parameters.
		driver.get(arg1);
	}

	@Given("^click on login link in homepage to land on sign in page$")
	public void click_on_login_link_in_homepage_to_land_on_sign_in_page() throws Throwable {
		LandingPage l = new LandingPage(driver);
		// whether the pop is present or not. If it is present click on the thanks
		// button.
		// So, for that we have written the code
		if (l.getpopupsize() > 0) {
			l.getPopUp().click();
		}

		l.getLogin().click();
	}

	@Then("^verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// check point to check whether the check box is displaying after successful
		// login
		portalhomepage p = new portalhomepage(driver);
		Assert.assertTrue(p.getSearchBox().isDisplayed());

	}

	@When("^user user enter (.+) and (.+) and logs in$")
	public void user_user_enter_and_and_logs_in(String username, String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();

	}

	@And("^close browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}

}
