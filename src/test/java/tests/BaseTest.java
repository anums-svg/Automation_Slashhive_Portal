package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import pages.LoginPage;
import utils.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	protected ConfigReader config;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://portal.bobcares.com/login");
		config = new ConfigReader();
		// Login before all tests
		LoginPage login = new LoginPage(driver);
		login.setValidEmail(config.getValidEmail());
		login.setValidPassword(config.getValidPassword());
		login.clickSignIn();
		// wait for dashboard
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
	}
}