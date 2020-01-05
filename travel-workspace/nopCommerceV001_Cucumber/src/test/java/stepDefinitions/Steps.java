package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Steps {

	public WebDriver driver;

	public LoginPage lp;

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "/home/kuldeep/Downloads/chromedriver");
		driver = new ChromeDriver();

		lp = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String pwd) {
		lp.setUserName(email);
		lp.setPassword(pwd);

	}

	@When("Click on Login")
	public void click_on_Login() {
		lp.clickLogin();

	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {

		if (driver.getPageSource().contains(" Login was unsuccessful.")) {

			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		Thread.sleep(3000);
		lp.clickLogOut();
		Thread.sleep(3000);

	}

	@Then("close browser")
	public void close_browser() {
		driver.close();

	}

}
