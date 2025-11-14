package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	// Locators
	By emailField = By.xpath("//input[@name='email']");
	By passwordField = By.xpath("//input[@name='password']");
	By signInButton = By.xpath("//button[contains(text(),'Sign in')]");
	By logoLocator = By.xpath("//img[contains(@alt, 'bobcares logo')]");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogoDisplayed() {
		try {
			return driver.findElement(logoLocator).isDisplayed();
		} catch (Exception e) {
			return false; // Element not found
		}
	}

	// Actions
	public void setInvalidEmail(String invalid_Email) {

		driver.findElement(emailField).sendKeys(invalid_Email);
	}

	public void setInvalidPassword(String invalid_Password) {
		driver.findElement(passwordField).sendKeys(invalid_Password);
	}

	// Actions
	public void setValidEmail(String valid_email) {

		driver.findElement(emailField).sendKeys(valid_email);
	}

	public void setValidPassword(String valid_password) {
		driver.findElement(passwordField).sendKeys(valid_password);
	}

	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}

	public void clearEmail() {
		driver.findElement(emailField).clear();
	}
}