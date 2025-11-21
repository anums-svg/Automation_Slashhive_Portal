package pages;

import java.time.Duration; // Import for WebDriverWait

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicesPage {

	private WebDriver driver;

// Define a WebDriverWait for common actions (best practice)

	private WebDriverWait wait;

// --- Locators for Sidetabs (No Change) ---

	private By servicesSidetab = By.xpath("//a[@href='#service_menu' and contains(@class, 'nav-link')]");
	private By viewServices = By.xpath("//a[@href='https://portal.bobcares.com/products']"); // ... (other sidetab //
																								// locators
	private By addServices = By.xpath("//a[@href='https://portal.bobcares.com/plans']");
	private By cancelPlans = By.xpath("//a[@href='https://portal.bobcares.com/cancellation-product-plans']");
	private By specialOffers = By.xpath("//a[@href='https://portal.bobcares.com/products/special-offers']");

// --- Locators for Pagination (FIXED) ---

	private By nextpagination = By.xpath("//li[@id='next-page']//a[@class='page-link'][contains(text(),'›')]");
	private By previouspagination = By.xpath("//li[@id='previous-page']");
	private By lastPage = By.xpath("//a[contains(text(),'››')]");
	private By firstPage = By.xpath("//li[@id='first-page']");
	private By pagenumber = By.xpath("//a[@class='page-link' and text()='\" + pageNumber + \"']");

//Locator for the request a quote button and close button

	private By requestQoutebtn = By.xpath("//a[normalize-space()='Request Quote']");
	private By requestQuoteClosebtn = By.xpath("//span[@id='banner-close']");

// Constructor

	public ServicesPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

// Actions for sidetabs (No Change)

	public void clickServicesSidetab() {
		wait.until(ExpectedConditions.elementToBeClickable(servicesSidetab)).click();
	}

	public void clickViewServices() {
		wait.until(ExpectedConditions.elementToBeClickable(viewServices)).click();
	}

	public void clickAddServices() {
		wait.until(ExpectedConditions.elementToBeClickable(addServices)).click();
	}

	public void clickCancelPlans() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelPlans)).click();
	}

	public void clickSpecialOffers() {
		wait.until(ExpectedConditions.elementToBeClickable(specialOffers)).click();
	}

//Scrolling (No Change)

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

// --- Actions for Pagination (FIXED AND IMPROVED) ---

	public void clickNextPagination() {
		scrollToBottom();
		wait.until(ExpectedConditions.elementToBeClickable(nextpagination)).click();
	}

	public void clickPreviousPagination() {
		scrollToBottom();
		wait.until(ExpectedConditions.elementToBeClickable(previouspagination)).click();
	}

// Click LAST PAGE

	public void clickLastPage() {
		scrollToBottom();
		wait.until(ExpectedConditions.elementToBeClickable(lastPage)).click();
	}

// Click FIRST PAGE

	public void clickFirstPage() {
		scrollToBottom();
		wait.until(ExpectedConditions.elementToBeClickable(firstPage)).click();
	}

// Action for a fixed page number (for testing the locator itself)

	public void clickFixedPageNumber() {
		wait.until(ExpectedConditions.elementToBeClickable(pagenumber)).click();
	}

}