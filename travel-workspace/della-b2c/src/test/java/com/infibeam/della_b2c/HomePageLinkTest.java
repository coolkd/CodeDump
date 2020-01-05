package com.infibeam.della_b2c;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import esselworld.pages.HomePageLinks;
import resources.BasePageTest;
import resources.PropertyLoader;

public class HomePageLinkTest extends BasePageTest {

//	@BeforeTest(alwaysRun = true)
	public void closeAllChildWindows() {
		System.out.println("HomePageLinkTest.closeAllChildWindows()");
		String handle = driver.getWindowHandle();
		driver.getWindowHandles().stream().filter(e -> !handle.equals(e)).forEach(e -> {
			driver.switchTo().window(e);
			driver.close();
		});
		driver.switchTo().window(handle);

	}

//	@Test
	public void clickOffersLinkAndVerify() throws InterruptedException {

		driver.get(PropertyLoader.getProperty("url"));
		HomePageLinks homePageLinks = new HomePageLinks(driver);

		WebElement offerLinks = driver.findElement(By.xpath("//*[@id=\"offerWidget\"]//div[@class='offer-list']"));
		System.out.println(offerLinks.findElements(By.tagName("a")).size());

		String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (WebElement element : offerLinks.findElements(By.tagName("a"))) {
			String currentWindow = driver.getWindowHandle();

			try {
				String elementString = element.getText();
				element.sendKeys(clickOnLinkTab);
				TimeUnit.SECONDS.sleep(2);

				currentWindow = driver.getWindowHandle();
				for (String windowHandle : driver.getWindowHandles()) {
					driver.switchTo().window(windowHandle);
				}
				assertEquals(elementString.toUpperCase(), homePageLinks.getOfferTitle().toUpperCase());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				driver.close();
				TimeUnit.SECONDS.sleep(2);
				driver.switchTo().window(currentWindow);
			}

		}
	}

//	@Test
	public void footerTopMenuLinks() throws InterruptedException {

		driver.get(PropertyLoader.getProperty("url"));
		HomePageLinks homePageLinks = new HomePageLinks(driver);
		WebElement topMenuLinks = driver.findElement(By.xpath("//*[@id=\"footer-top-menu\"]//div[@class='row']"));
		System.out.println(topMenuLinks.findElements(By.tagName("a")).size());
		String clickOnTopMenuLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);

		for (WebElement element : topMenuLinks.findElements(By.tagName("a"))) {
			String elementString = element.getText();
			element.sendKeys(clickOnTopMenuLinks);
			TimeUnit.SECONDS.sleep(2);

			String currentWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);
			}
//			assertEquals(elementString.toUpperCase(), homePageLinks.getOfferTitle().toUpperCase());
			driver.close();
			TimeUnit.SECONDS.sleep(2);
			driver.switchTo().window(currentWindow);

		}
	}

	@Test
	public void clickToBirdParkLinkAndGetBirdParkHomePageURL() {

		driver.get(PropertyLoader.getProperty("url"));
		HomePageLinks homePageLinks = new HomePageLinks(driver);
		homePageLinks.getBirdParkLink();
		Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.getProperty("birdparkUrl"));

	}

	@Test
	public void clickToWaterKingdomAndGetWaterKingdomHomePageURL() throws InterruptedException {

		driver.get(PropertyLoader.getProperty("url"));
		HomePageLinks homePageLinks = new HomePageLinks(driver);
		homePageLinks.getwaterKingdomLink();
		String mainWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			Thread.sleep(5000);
			if (driver.getTitle().trim().contains("Water")) {
				break;
			}
		}
		String title = driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(mainWindow);
		Assert.assertEquals(title, PropertyLoader.getProperty("waterkingdomUrl"));
	}

	@Test
	public void clickToFab5ShoppingLinkAndGetGetFab5ShoppingHomePageURL() throws InterruptedException {

		driver.get(PropertyLoader.getProperty("url"));
		String mainWindow = driver.getWindowHandle();
		HomePageLinks homePageLinks = new HomePageLinks(driver);
		homePageLinks.getfab5ShoppingLink();
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			Thread.sleep(5000);
			if (driver.getTitle().trim().contains("Fab5Shopping")) {
				break;
			}
		}
		String fabTitle = driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(mainWindow);
		Assert.assertEquals(fabTitle, PropertyLoader.getProperty("fab5shopingUrl"));
	}
}
