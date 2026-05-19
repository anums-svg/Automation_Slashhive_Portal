package pages;

import java.time.Duration; // Import for WebDriverWait

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicesPage {

	private WebDriver driver;
//<class name="tests.PortalLoginTest"/>
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

// --- Locators for Add Services Page ---
	private By viewDashboard = By.xpath("//span[contains(text(),'View Dashboard')]");
	private By viewServerManagement = By.xpath("//a[contains(text(),'Server Management')]");
	private By view_OutsourcedSupport = By.xpath("//a[contains(text(), 'Outsourced Support')]");
	private By viewCloud_Support = By.xpath("//a[contains(text(), 'Cloud Support')]");
	private By viewSoftware_Development = By.xpath("//a[contains(text(), 'Software Development')]");

	// 1 Server Management Plans
	private By ServerManagement_Monitoring = By
			.xpath("//a[@href='https://portal.bobcares.com/plan/server-management-cart']");
	private By ServerManagement_MonitoringQuarterly = By.xpath("(//input[@type='radio'])[1]");
	private By ServerManagement_MonitoringQuarterlyPrice = By.xpath("(//span[@id='quarterly-span'])[1]");
	private By ServerManagement_MonitoringAnnually = By.xpath("//label[@for='[$39.00/month]']");
	private By ServerManagement_MonitoringAnnuallyPrice = By.xpath("(//span[@id='quarterly-span'])[2]");
	private By Checkout_ContinueButton = By.xpath("//button[@type='submit']");
	private By SeeMore_ServerManagement_Monitoring = By
			.xpath("//a[@href='https://portal.bobcares.com/plan-view/826/server-management-cart']");
	private By BacktoAddServicesButton = By.xpath("//span[contains(text(),'Back to Add Services')]");
	// a Limitless Server Management Plans
	private By Limitless_Server_Management = By
			.xpath("//a[@href='https://portal.bobcares.com/plan/limitless-server-management-cart']");
	private By SeeMore_Limitless_Server_Management = By
			.xpath("//a[@href='https://portal.bobcares.com/plan-view/845/limitless-server-management-cart']");
	private By Quarterly = By.xpath("//label[contains(text(),'Quarterly')]");
	private By Annually = By.xpath("//label[contains(text(),'Annually')]");
	// b Limitless Priority Support Plan
	private By Limitless_Priority_Support = By
			.xpath("//a[@href='https://portal.bobcares.com/plan/limitless-priority-server-management-cart']");
	private By SeeMore_Limitless_Priority_Support = By
			.xpath("//a[@href='https://portal.bobcares.com/plan-view/826/server-management-cart']");
	// c Vulnerability Scan
	private By Vulnerability_Scan = By
			.xpath("//a[@href='https://portal.bobcares.com/plan/limitless-priority-server-management-cart']");
	// d Periodic Vulnerability Scanning
	private By Periodic_Vulnerability_Scanning = By
			.xpath("//a[@href='https://portal.bobcares.com/plan/go-to-cart/submit?pid=796']");
	// e Affordable Monitoring
	private By Affordable_Monitoring = By
			.xpath("//a[@href='https://portal.bobcares.com/plan/go-to-cart/submit?pid=859']");
	private By serverMgmtText = By.xpath("//div[contains(text(),'Server Management Plans')]");

	// 2 Outsourced Support Plans
	// a Dedicated Support Engineers
	private By viewDedicated_Support_Engineers = By
			.xpath("//a[@href='https://portal.bobcares.com/request-a-quote/2/5']");
	// b Dedicated Support Team
	private By viewDedicated_Support_Team = By.xpath("//a[@href='https://portal.bobcares.com/request-a-quote/2/6']");
	// c Semi-dedicated Support
	private By viewSemidedicated_Support = By.xpath("//a[@href='https://portal.bobcares.com/request-a-quote/2/7']");
	// d Shared Support
	private By viewSharedSupport = By.xpath("//a[@href='https://portal.bobcares.com/request-a-quote/2/8']");
	// e Outsourced Phone Support
	private By viewOutsourcedPhoneSupport = By.xpath("//a[@href='https://portal.bobcares.com/plan/phone-support']");
	// f All In One Hosting Support
	private By viewAllInOneHostingSupport = By.xpath("//a[@href='https://portal.bobcares.com/request-a-quote/2/10']");
	private By Subject = By.xpath("//input[@id='subject']");
	private By myDropdown = By.xpath("//select[@id='Related Service']");
	private By Message = By.xpath("//div[@class='col-xl-8 order-xl-1']");
	private By Attachments = By.xpath("//input[@id='attachments1']");
	private By SubmitButton = By.xpath("//input[@value='Submit']");
	By editorIframe = By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame')]");
	// body inside iframe
	By body = By.tagName("body");
	private By ContinueButton = By.xpath("//a[contains(text(), 'Continue')]");
	private By PhonesupportMinutesmonth = By.xpath(" //span[contains(text(),'Phone support minutes/month')]");
	private By PhoneSupportCallsmonth = By.xpath("//span[contains(text(),'Phone Support calls/month')]");
	private By OutsourcedPhoneSupportContinueButton = By.xpath("//button[@type='submit']");
	
	// 3 Cloud Support Plans
	private By RequestAQuoteCloudSupport = By.xpath("//a[@href='https://portal.bobcares.com/request-a-quote/3/11']");
	
	// 4 Software Development Plans
	private By RequestAQuote_SoftwareDevelopment = By.xpath("//a[@href='https://portal.bobcares.com/web-dev-design/service-categories']");

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

//Add services page functions

	public void clickviewDashboard() {
		wait.until(ExpectedConditions.elementToBeClickable(viewDashboard)).click();
	}

//Service 1: Server Management

	public void clickServerManagement() {
		wait.until(ExpectedConditions.elementToBeClickable(viewServerManagement)).click();
	}

	// Plan 1 : Server Management & Monitoring
	public void clickServerManagement_Plans1() {
		wait.until(ExpectedConditions.elementToBeClickable(ServerManagement_Monitoring)).click();
	}

	public void click_SeeMore_ServerManagement_Monitoring() {
		wait.until(ExpectedConditions.elementToBeClickable(SeeMore_ServerManagement_Monitoring)).click();
	}

	public void click_BacktoAddServicesButton() {
		wait.until(ExpectedConditions.elementToBeClickable(BacktoAddServicesButton)).click();
	}

	public void clickServerManagement_PlanQuarterly() {
		wait.until(ExpectedConditions.elementToBeClickable(Quarterly)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Checkout_ContinueButton)).click();

	}

	public void clickServerManagement_PlanAnnually() {
		wait.until(ExpectedConditions.elementToBeClickable(Annually)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Checkout_ContinueButton)).click();
	}

	// Plan 2 : Limitless Server Management
	public void click_LimitlessServerManagement_Plan() {
		wait.until(ExpectedConditions.elementToBeClickable(Limitless_Server_Management)).click();
	}

	public void click_SeeMore_Limitless_Server_Management() {
		wait.until(ExpectedConditions.elementToBeClickable(SeeMore_Limitless_Server_Management)).click();
	}

	// Plan 3 : Limitless Priority Support
	public void click_Limitless_Priority_Support_Plan() {
		wait.until(ExpectedConditions.elementToBeClickable(Limitless_Priority_Support)).click();
	}

	public void click_SeeMore_Limitless_Priority_Support() {
		wait.until(ExpectedConditions.elementToBeClickable(SeeMore_Limitless_Priority_Support)).click();
	}

	// Plan 4 : Vulnerability Scan - Pay As You Go
	public void click_Vulnerability_Scan_Plan() {
		wait.until(ExpectedConditions.elementToBeClickable(Vulnerability_Scan)).click();
	}

	// Plan 5 : Periodic Vulnerability Scanning
	public void click_Periodic_Vulnerability_ScanningPlan() {
		wait.until(ExpectedConditions.elementToBeClickable(Periodic_Vulnerability_Scanning)).click();
	}

	// Plan 6 : Affordable Monitoring
	public void click_Affordable_MonitoringPlan() {
		wait.until(ExpectedConditions.elementToBeClickable(Affordable_Monitoring)).click();
	}
//Service 2: Outsourced Support

	public void Click_Outsourced_Support() {
		wait.until(ExpectedConditions.elementToBeClickable(view_OutsourcedSupport)).click();
	}

	// Plan 1: Dedicated Support Engineers
	public void Click_Dedicated_Support_Engineers() {
		wait.until(ExpectedConditions.elementToBeClickable(viewDedicated_Support_Engineers)).click();
	}

	public String Subject_RequestAQuote() {
		WebElement subjectElement = driver.findElement(Subject);
		String subjectText = subjectElement.getAttribute("value");
		// Return the string value
		return subjectText;
	}

	public void Dropdown_Dedicated_Support_Engineers() {
		WebElement dropdownElement = driver.findElement(myDropdown);
		Select select = new Select(dropdownElement);
		select.selectByVisibleText("Limitless Priority Server Support Yearly (AZUS)");
	}

	public void Message_RequestAQuote() {
		WebElement frame = driver.findElement(editorIframe);
		driver.switchTo().frame(frame);
		WebElement editorBody = driver.findElement(body);
		editorBody.clear();
		editorBody.sendKeys("Test Form");
		driver.switchTo().defaultContent();
	}

	public void uploadAttachment() {
		WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(Attachments));
		String filePath = "/home/poornam/Downloads/Cycle 248 March 2026.pdf";
		uploadElement.sendKeys(filePath);
	}

	public void ButtonClick_RequestAQuote() {
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButton)).click();
	}

	public void ContinueButton_ViewTicket() {
		wait.until(ExpectedConditions.elementToBeClickable(ContinueButton)).click();
	}

	// Plan 2: Dedicated Support Engineers
	public void Click_Dedicated_Support_Team() {
		wait.until(ExpectedConditions.elementToBeClickable(viewDedicated_Support_Team)).click();
	}

	// Plan 3: Semi-dedicated Support
	public void Click_Semidedicated_Support() {
		wait.until(ExpectedConditions.elementToBeClickable(viewSemidedicated_Support)).click();
	}

	// Plan 4: Shared Support
	public void Click_SharedSupport() {
		wait.until(ExpectedConditions.elementToBeClickable(viewSharedSupport)).click();
	}

	// Plan 5: Outsourced Phone Support
	public void Click_OutsourcedPhoneSupport() {
		wait.until(ExpectedConditions.elementToBeClickable(viewOutsourcedPhoneSupport)).click();
	}

	public void Click_PhonesupportMinutesmonth() {
		wait.until(ExpectedConditions.elementToBeClickable(PhonesupportMinutesmonth)).click();
	}

	public void Click_PhoneSupportCallsmonth() {
		wait.until(ExpectedConditions.elementToBeClickable(PhoneSupportCallsmonth)).click();
	}

	public void Click_OutsourcedPhoneSupportContinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(OutsourcedPhoneSupportContinueButton)).click();
	}

	// Plan 6: Dedicated Support Engineers
	public void Click_AllInOneHostingSupport() {
		wait.until(ExpectedConditions.elementToBeClickable(viewAllInOneHostingSupport)).click();
	}
	//Service 3: Cloud Support Plans
	public void Click_Cloud_Support() {
		wait.until(ExpectedConditions.elementToBeClickable(viewCloud_Support)).click();
		wait.until(ExpectedConditions.elementToBeClickable(RequestAQuoteCloudSupport)).click();
	}
	//Service 4: Software Development Plans
	public void Click_Software_Development() {
		wait.until(ExpectedConditions.elementToBeClickable(viewSoftware_Development)).click();
		wait.until(ExpectedConditions.elementToBeClickable(RequestAQuote_SoftwareDevelopment)).click();
	}
}