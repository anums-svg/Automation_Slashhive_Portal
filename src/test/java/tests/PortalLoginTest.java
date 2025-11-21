package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

	@Test(priority = 4) // Testing with blank email id
	public void blankEmailLoginTest1() {
		driver.navigate().refresh();
		loginPage.setValidPassword(config.getValidPassword());
		loginPage.clickSignIn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),
				"User should not be able to login with blank email id.");

	}

	@Test(priority = 5) // Testing with blank password
	public void blankPasswordLoginTest() {
		driver.navigate().refresh();
		loginPage.setValidEmail(config.getValidEmail());
		loginPage.clickSignIn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),
				"User should not be able to login with blank password.");
	}

	@Test(priority = 6) // Redirection of the forgot button in the login page
	public void ForgotPasswordLinkRedirection() {
		driver.navigate().refresh();
		loginPage.forgotPassword();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.bobcares.com/forget-password"),
				"User was NOT redirected to Forgot Password page.");

	}

	@Test(priority = 7)
	public void ForgotPasswordPage_EmptyEmail_Click() {
		driver.navigate().refresh();
		loginPage.ResetButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://portal.bobcares.com/forget-password"),
				"The user is not entered the mail id.");
		driver.navigate().back();
		WebDriverWait wait_1 = new WebDriverWait(driver, Duration.ofSeconds(100));
	}

	@Test(priority = 8)
	public void ValidloginTest() {
		driver.navigate().refresh();
		loginPage.clearEmail();
		loginPage.setValidEmail(config.getValidEmail());
		loginPage.setValidPassword(config.getValidPassword());
		loginPage.clickSignIn();
		// Wait for either URL or specific dashboard element after login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		boolean isLoggedIn = wait.until(d -> d.getCurrentUrl().contains("/home"));
		Assert.assertTrue(isLoggedIn, "Login failed or dashboard not reached.");
	}

	@AfterClass
	public void tearDown() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(200));
		driver.quit();
	}
}
