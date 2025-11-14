package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ConfigReader;

public class PortalLoginTest {
	WebDriver driver;
	LoginPage loginPage;
	ConfigReader config;

	@BeforeClass
	public void setUp() {
		// Set the path for chromedriver (update as needed)
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://portal.bobcares.com/login");
		loginPage = new LoginPage(driver);
		config = new ConfigReader();
	}

//	@Test
//	public void testLogoDisplayed() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo is not displayed!");
//	}
	@Test(priority = 1)
	public void invalidLoginTest1() {
		// Use invalid credentials
		loginPage.setInvalidEmail(config.getInValidEmail());
		loginPage.setInvalidPassword(config.getInValidPassword());
		loginPage.clickSignIn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),
				"User should not be able to login with invalid credentials.");
	}

	@Test(priority = 2)
	public void invalidLoginTest2() {
		driver.navigate().refresh();
		loginPage.setInvalidEmail(config.getValidEmail());
		loginPage.setInvalidPassword(config.getInValidPassword());
		loginPage.clickSignIn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),
				"User should not be able to login with invalid credentials.");
	}

	@Test(priority = 3)
	public void invalidLoginTest3() {
		driver.navigate().refresh();
		loginPage.setInvalidEmail(config.getInValidEmail());
		loginPage.setInvalidPassword(config.getValidPassword());
		loginPage.clickSignIn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),
				"User should not be able to login with invalid credentials.");
	}

	@Test(priority = 4)
	public void ValidloginTest() {
		// Get credentials from external properties file
		driver.navigate().refresh();
		loginPage.clearEmail();
		loginPage.setValidEmail(config.getValidEmail());
		loginPage.setValidPassword(config.getValidPassword());
		loginPage.clickSignIn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.bobcares.com/home"),
				"Login failed or dashboard not reached.");
	}

//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
}
