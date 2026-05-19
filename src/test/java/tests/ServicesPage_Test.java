package tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ServicesPage;

public class ServicesPage_Test extends BaseTest {

	@Test(priority = 1)

	public void viewServices_Redirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServicesSidetab();
		service.clickViewServices();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("products"));
		Assert.assertTrue(urlContains, "Not redirected to Products page!");
	}

	@Test(priority = 2)
	public void pagination() throws InterruptedException {
		ServicesPage service = new ServicesPage(driver);
		// Click next page
		service.clickNextPagination();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("page=") || driver.getCurrentUrl().contains("page"),
				"❌ Page did not change after clicking NEXT!");
		System.out.println("✔ NEXT page clicked successfully");
		// Scroll again
		// Click previous page
		service.clickPreviousPagination();
		Thread.sleep(2500);
		Assert.assertTrue(driver.getCurrentUrl().contains("page=1") || driver.getCurrentUrl().endsWith("/products"),
				"❌ PREVIOUS button did not return to page 1!");
		System.out.println("✔ PREVIOUS page clicked successfully");
		// 3️⃣ Click LAST PAGE
		service.clickLastPage();
		Thread.sleep(2500);
		Assert.assertTrue(driver.getCurrentUrl().contains("page=8") || driver.getCurrentUrl().endsWith("/products"),
				"❌ LAST button did not return to page 8!");
		System.out.println("✔ LAST page clicked successfully");

		// 4️⃣ Click FIRST PAGE
		service.clickFirstPage();
		Thread.sleep(2500);
		Assert.assertTrue(driver.getCurrentUrl().contains("page=1") || driver.getCurrentUrl().endsWith("/products"),
				"❌ FIRST button did not return to page 1!");
		System.out.println("✔ FIRST page clicked successfully");

	}

	// Add Services
	@Test(priority = 3)
	public void Add_Services_Redirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickAddServices();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/plans"));
		Assert.assertTrue(urlContains, "Not redirected to Add services page!");
		System.out.println("✔ Add Services Redirected successfully");
	}

	@Test(priority = 4)
	public void viewDashboard_Redirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickviewDashboard();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/rewards"));
		Assert.assertTrue(urlContains, "Not redirected to Rewards Dashboard page!");
		driver.navigate().back();
		System.out.println("✔ Dashboard Redirected successfully");
	}

	// A: Server Management Plans
	@Test(priority = 5)
	public void viewServerManagement_Redirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServerManagement();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/plans"));
		Assert.assertTrue(urlContains, "Not redirected to Server Management Plans!");
		System.out.println("✔ Server Management Plans Redirected successfully");
	}

	@Test(priority = 6)
	public void SeeMoreLink_ServerManagement_Redirection() {
		ServicesPage service = new ServicesPage(driver);
		service.click_SeeMore_ServerManagement_Monitoring();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(
				ExpectedConditions.urlContains("https://portal.bobcares.com/plan-view/826/server-management-cart"));
		Assert.assertTrue(urlContains, "Not redirected to Server Management Plans!");
		service.click_BacktoAddServicesButton();
		System.out.println("✔ See More-Server Management Plans Redirected successfully");
	}

	@Test(priority = 7)
	public void ServerManagementMonitoringQuarterlyPlanCheck() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServerManagement_Plans1();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		service.clickServerManagement_PlanQuarterly();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains = wait2.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		driver.navigate().back();
		System.out.println("✔ Server Management & Monitoring Quarterly successfully ");
	}

	@Test(priority = 8)
	public void ServerManagementMonitoringAnnuallyPlanCheck() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServerManagement_Plans1();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		service.clickServerManagement_PlanAnnually();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains = wait2.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		driver.navigate().back();
		System.out.println("✔ Server Management & Monitoring Annually successfully ");
	}

	@Test(priority = 9)
	public void SeeMoreLink_Limitless_Server_Management_Redirection() {
		ServicesPage service = new ServicesPage(driver);
		service.click_SeeMore_Limitless_Server_Management();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions
				.urlContains("https://portal.bobcares.com/plan-view/845/limitless-server-management-cart"));
		Assert.assertTrue(urlContains, "Not redirected to Server Management Plans!");
		service.click_BacktoAddServicesButton();
		System.out.println("✔ See More-Limitless Server Management Redirected successfully");
	}

	@Test(priority = 10)
	public void Limitless_Server_Management_QuarterlyPlanCheck() {
		ServicesPage service = new ServicesPage(driver);
		service.click_LimitlessServerManagement_Plan();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		service.clickServerManagement_PlanQuarterly();
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains2 = wait.until(
				ExpectedConditions.urlContains("https://portal.bobcares.com/plan/limitless-server-management-cart"));
		driver.navigate().back();
		System.out.println("✔ Limitless Server Management Quarterly successfully ");

	}

	@Test(priority = 11)
	public void Limitless_Server_Management_AnnuallyPlanCheck() {
		ServicesPage service = new ServicesPage(driver);
		service.click_LimitlessServerManagement_Plan();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		service.clickServerManagement_PlanAnnually();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains = wait2.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		driver.navigate().back();
		System.out.println("✔ Limitless Server Management Annually successfully ");
	}

	@Test(priority = 12)
	public void SeeMoreLink_Limitless_Priority_Support_Redirection() {
		ServicesPage service = new ServicesPage(driver);
		service.click_SeeMore_Limitless_Priority_Support();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(
				ExpectedConditions.urlContains("https://portal.bobcares.com/plan-view/826/server-management-cart"));
		Assert.assertTrue(urlContains, "Not redirected to Server Management Plans!");
		service.click_BacktoAddServicesButton();
		System.out.println("✔ See More-Limitless Priority Support Redirected successfully");
	}

	@Test(priority = 13)
	public void Limitless_Priority_Support_QuarterlyPlanCheck() {
		ServicesPage service = new ServicesPage(driver);
		service.click_Limitless_Priority_Support_Plan();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		service.clickServerManagement_PlanQuarterly();
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains2 = wait.until(ExpectedConditions
				.urlContains("https://portal.bobcares.com/plan/limitless-priority-server-management-cart"));
		driver.navigate().back();
		System.out.println("✔ Limitless Priority Support Quarterly successfully ");

	}

	@Test(priority = 14)
	public void Limitless_Priority_Support_AnnuallyPlanCheck() {
		ServicesPage service = new ServicesPage(driver);
		service.click_Limitless_Priority_Support_Plan();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		service.clickServerManagement_PlanAnnually();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains = wait2.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		driver.navigate().back();
		System.out.println("✔ Limitless Priority Support Annually successfully ");
	}

	@Test(priority = 15)
	public void Vulnerability_ScanPlanCheck() {
		ServicesPage service = new ServicesPage(driver);
		service.click_Periodic_Vulnerability_ScanningPlan();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains = wait2.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		System.out.println("✔ Vulnerability Scan - Pay As You Go successfully ");
	}

	@Test(priority = 16)
	public void Affordable_MonitoringPlanCheck() {
		ServicesPage service = new ServicesPage(driver);
		service.click_Affordable_MonitoringPlan();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains = wait2.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		System.out.println("✔ Affordable Monitoring successfully ");
	}

	// B: Outsourced Support Plans
	@Test(priority = 17)
	public void view_Outsourced_SupportRedirection() {
		ServicesPage service = new ServicesPage(driver);
		service.Click_Outsourced_Support();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/plans"));
		Assert.assertTrue(urlContains, "Not redirected to Server Management Plans!");
		System.out.println("✔ Outsourced Support Service Redirected successfully");
	}

	// 1: Dedicated Support Engineers
	@Test(priority = 18)
	public void Request_A_quote_Dedicated_Support_Engineers_Redirection() {
		ServicesPage service = new ServicesPage(driver);
		service.Click_Dedicated_Support_Engineers();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add"));
		Assert.assertTrue(urlContains, "Not redirected to Dedicated Support Engineers");
		System.out.println("✔ Request a quote - Dedicated Support Engineers Redirected successfully");
	}

	@Test(priority = 19)
	public void RequestAQuote_Dedicated_Support_Engineers_SubjectDisplayCheck() {
		ServicesPage service = new ServicesPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String subjectText = service.Subject_RequestAQuote();
		Assert.assertTrue(subjectText.contains("Dedicated Support Engineers"),
				"Subject text does not contain expected value. Actual: " + subjectText);

		System.out.println("✔ Subject displayed successfully - Request A Quote Dedicated Support Engineers");
	}

	@Test(priority = 20)
	public void RequestAQuote_Dedicated_Support_Engineers_MandatoryValidationCheck() {
		ServicesPage service = new ServicesPage(driver);
		service.ButtonClick_RequestAQuote();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean textPresent = driver.getPageSource().contains("The message field is required.");
		Assert.assertTrue(textPresent, "Text not found on page");
		System.out.println("✔ Validation message displayed successfully- Request A Quote Dedicated Support Engineers");
	}

	@Test(priority = 21)
	public void RequestAQuote_Dedicated_Support_Engineers_FormSubmission() {
		ServicesPage service = new ServicesPage(driver);
		service.Dropdown_Dedicated_Support_Engineers();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		service.Message_RequestAQuote();
		service.uploadAttachment();
		service.ButtonClick_RequestAQuote();
		boolean urlContains = wait
				.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add-success"));
		Assert.assertTrue(urlContains, "Not redirected to Success Page");
		System.out.println("✔ Success Page displayed successfully- Request A Quote Dedicated Support Engineers");
	}

	@Test(priority = 22)
	public void RequestAQuote_Dedicated_Support_Engineers_ViewTicket() {
		ServicesPage service = new ServicesPage(driver);
		service.ContinueButton_ViewTicket();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Assert.assertTrue(driver.getPageSource().contains("Test Form"), "Expected text not found on page");
		System.out.println("✔ View Ticket- Dedicated_Support_EngineersNote displayed successfully");
	}

	// 2: Dedicated Support Team
	@Test(priority = 23)
	public void Request_A_quote_DedicatedSupportTeamRedirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServicesSidetab();
		service.clickAddServices();
		service.Click_Outsourced_Support();
		service.Click_Dedicated_Support_Team();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add"));
		Assert.assertTrue(urlContains, "Not redirected to Dedicated Support Team");
		System.out.println("✔ Request a quote - Dedicated Support Team  Redirected successfully");
	}

	@Test(priority = 24)
	public void RequestAQuote_Dedicated_Support_Team_Subject_MandatoryFieldCheck() {
		ServicesPage service = new ServicesPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String subjectText = service.Subject_RequestAQuote();
		Assert.assertTrue(subjectText.contains("Dedicated Support Team"),
				"Subject text does not contain expected value. Actual: " + subjectText);

		System.out.println("✔ Subject displayed successfully - Request A Quote Dedicated Support Team");
		service.ButtonClick_RequestAQuote();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean textPresent = driver.getPageSource().contains("The message field is required.");
		Assert.assertTrue(textPresent, "Text not found on page");
		System.out.println("✔ Validation message displayed successfully- Request A Quote Dedicated Support Team");
	}

	@Test(priority = 25)
	public void RequestAQuote_Dedicated_Support_Team_FormSubmission() {
		ServicesPage service = new ServicesPage(driver);
		service.Dropdown_Dedicated_Support_Engineers();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		service.Message_RequestAQuote();
		service.uploadAttachment();
		service.ButtonClick_RequestAQuote();
		boolean urlContains = wait
				.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add-success"));
		Assert.assertTrue(urlContains, "Not redirected to Success Page");
		System.out.println("✔ Success Page displayed successfully- Request A Quote Dedicated Support Team");
		service.ContinueButton_ViewTicket();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		Assert.assertTrue(driver.getPageSource().contains("Test Form"), "Expected text not found on page");
		System.out.println("✔ View Ticket- Dedicated_Support Team Note displayed successfully");
	}

	// 3: Semi-dedicated Support
	@Test(priority = 26)
	public void Request_A_quote_Semidedicated_SupportRedirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServicesSidetab();
		service.clickAddServices();
		service.Click_Outsourced_Support();
		service.Click_Semidedicated_Support();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add"));
		Assert.assertTrue(urlContains, "Not redirected to Semi-dedicated Support");
		System.out.println("✔ Request a quote -Semi-dedicated Support  Redirected successfully");
	}

	@Test(priority = 27)
	public void RequestAQuote_Semidedicated_Support_Subject_MandatoryFieldCheck() {
		ServicesPage service = new ServicesPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String subjectText = service.Subject_RequestAQuote();
		Assert.assertTrue(subjectText.contains("Semi-dedicated Support"),
				"Subject text does not contain expected value. Actual: " + subjectText);

		System.out.println("✔ Subject displayed successfully - Request A Quote Semi-dedicated Support");
		service.ButtonClick_RequestAQuote();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean textPresent = driver.getPageSource().contains("The message field is required.");
		Assert.assertTrue(textPresent, "Text not found on page");
		System.out.println("✔ Validation message displayed successfully- Request A Quote Semi-dedicated Support");
	}

	@Test(priority = 28)
	public void RequestAQuote_Semidedicated_Support_FormSubmission() {
		ServicesPage service = new ServicesPage(driver);
		service.Dropdown_Dedicated_Support_Engineers();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		service.Message_RequestAQuote();
		service.uploadAttachment();
		service.ButtonClick_RequestAQuote();
		boolean urlContains = wait
				.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add-success"));
		Assert.assertTrue(urlContains, "Not redirected to Success Page");
		System.out.println("✔ Success Page displayed successfully- Request A Quote Semi-dedicated Support");
		service.ContinueButton_ViewTicket();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		Assert.assertTrue(driver.getPageSource().contains("Test Form"), "Expected text not found on page");
		System.out.println("✔ View Ticket- Semi-dedicated Support Note displayed successfully");
	}

	// 3: Shared Support
	@Test(priority = 29)
	public void Request_A_quote_Shared_SupportRedirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServicesSidetab();
		service.clickAddServices();
		service.Click_Outsourced_Support();
		service.Click_SharedSupport();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add"));
		Assert.assertTrue(urlContains, "Not redirected to Shared Support");
		System.out.println("✔ Request a quote -Shared Support Redirected successfully");
	}

	@Test(priority = 30)
	public void RequestAQuote_Shared_Support_Subject_MandatoryFieldCheck() {
		ServicesPage service = new ServicesPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String subjectText = service.Subject_RequestAQuote();
		Assert.assertTrue(subjectText.contains("Shared Support"),
				"Subject text does not contain expected value. Actual: " + subjectText);

		System.out.println("✔ Subject displayed successfully - Request A Quote Shared Support");
		service.ButtonClick_RequestAQuote();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean textPresent = driver.getPageSource().contains("The message field is required.");
		Assert.assertTrue(textPresent, "Text not found on page");
		System.out.println("✔ Validation message displayed successfully- Request A Quote Shared Support");
	}

	@Test(priority = 31)
	public void RequestAQuote_Shared_Support_FormSubmission() {
		ServicesPage service = new ServicesPage(driver);
		service.Dropdown_Dedicated_Support_Engineers();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		service.Message_RequestAQuote();
		service.uploadAttachment();
		service.ButtonClick_RequestAQuote();
		boolean urlContains = wait
				.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add-success"));
		Assert.assertTrue(urlContains, "Not redirected to Success Page");
		System.out.println("✔ Success Page displayed successfully- Request A Quote Shared Support");
		service.ContinueButton_ViewTicket();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		Assert.assertTrue(driver.getPageSource().contains("Test Form"), "Expected text not found on page");
		System.out.println("✔ View Ticket- Shared Support Note displayed successfully");
	}

	// 4: Outsourced Phone Support
	@Test(priority = 32)
	public void Request_A_quote_Outsourced_Phone_SupportRedirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServicesSidetab();
		service.clickAddServices();
		service.Click_Outsourced_Support();
		service.Click_OutsourcedPhoneSupport();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait
				.until(ExpectedConditions.urlContains("https://portal.bobcares.com/plan/phone-support"));
		Assert.assertTrue(urlContains, "Not redirected to Outsourced Phone Support");
		System.out.println("✔ Checkout -Outsourced Phone Support successfully");
	}

	@Test(priority = 33)
	public void Minutes_Per_Month_Outsourced_Phone_SupportCheck() {
		ServicesPage service = new ServicesPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		service.Click_PhonesupportMinutesmonth();
		service.Click_OutsourcedPhoneSupportContinueButton();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains = wait2.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		System.out.println("✔ Phone support minutes/month- Outsourced Phone Support Loaded");
	}

	@Test(priority = 34)
	public void Calls_Per_Month_Outsourced_Phone_SupportCheck() {
		ServicesPage service = new ServicesPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		service.Click_PhoneSupportCallsmonth();
		service.Click_OutsourcedPhoneSupportContinueButton();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean urlContains = wait2.until(ExpectedConditions.urlContains("https://my.bobcares.com/order"));
		Assert.assertTrue(urlContains, "Not redirected to my.bobcares Order page!");
		driver.navigate().back();
		System.out.println("✔ Phone Support calls/month - Outsourced Phone Support Loaded");
	}

	// 5: All In One Hosting Support
	@Test(priority = 35)
	public void RequestAQuote_AllIn_One_Hosting_SupportRedirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServicesSidetab();
		service.clickAddServices();
		service.Click_Outsourced_Support();
		service.Click_AllInOneHostingSupport();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add"));
		Assert.assertTrue(urlContains, "Not redirected to Shared Support");
		System.out.println("✔ Request a quote -All In One Hosting Support Redirected successfully");
	}

	@Test(priority = 36)
	public void RequestAQuote_AllIn_One_Hosting_Subject_MandatoryFieldCheck() {
		ServicesPage service = new ServicesPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String subjectText = service.Subject_RequestAQuote();
		Assert.assertTrue(subjectText.contains("All In One Hosting Support"),
				"Subject text does not contain expected value. Actual: " + subjectText);

		System.out.println("✔ Subject displayed successfully - Request A Quote All In One Hosting Support");
		service.ButtonClick_RequestAQuote();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean textPresent = driver.getPageSource().contains("The message field is required.");
		Assert.assertTrue(textPresent, "Text not found on page");
		System.out.println("✔ Validation message displayed successfully- Request A Quote All In One Hosting Support");
	}

	@Test(priority = 37)
	public void RequestAQuote_AllIn_One_Hosting_FormSubmission() {
		ServicesPage service = new ServicesPage(driver);
		service.Dropdown_Dedicated_Support_Engineers();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		service.Message_RequestAQuote();
		service.uploadAttachment();
		service.ButtonClick_RequestAQuote();
		boolean urlContains = wait
				.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add-success"));
		Assert.assertTrue(urlContains, "Not redirected to Success Page");
		System.out.println("✔ Success Page displayed successfully- Request A Quote All In One Hosting Support");
		service.ContinueButton_ViewTicket();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		Assert.assertTrue(driver.getPageSource().contains("Test Form"), "Expected text not found on page");
		System.out.println("✔ View Ticket- All In One Hosting Support Note displayed successfully");
	}
	// C: Cloud Support Plans
	@Test(priority = 38)
	public void view_CloudSupport_PlansRedirection() {
		ServicesPage service = new ServicesPage(driver);
		service.clickServicesSidetab();
		service.clickAddServices();
		service.Click_Cloud_Support();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add"));
		Assert.assertTrue(urlContains, "Not redirected to Cloud Support - Request A quote");
		System.out.println("✔ Redirected to Cloud Support - Request A quote");
	}
	@Test(priority = 39)
	public void RequestAQuote_CloudSupport_Subject_MandatoryFieldCheck() {
		ServicesPage service = new ServicesPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String subjectText = service.Subject_RequestAQuote();
		Assert.assertTrue(subjectText.contains("Cloud Support"),
				"Subject text does not contain expected value. Actual: " + subjectText);

		System.out.println("✔ Subject displayed successfully - Request A Quote- Cloud Support");
		service.ButtonClick_RequestAQuote();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean textPresent = driver.getPageSource().contains("The message field is required.");
		Assert.assertTrue(textPresent, "Text not found on page");
		System.out.println("✔ Validation message displayed successfully- Request A Quote- Cloud Support");
	}
	@Test(priority = 40)
	public void RequestAQuote_CloudSupport_FormSubmission() {
		ServicesPage service = new ServicesPage(driver);
		service.Dropdown_Dedicated_Support_Engineers();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		service.Message_RequestAQuote();
		service.uploadAttachment();
		service.ButtonClick_RequestAQuote();
		boolean urlContains = wait
				.until(ExpectedConditions.urlContains("https://portal.bobcares.com/ticket-add-success"));
		Assert.assertTrue(urlContains, "Not redirected to Success Page");
		System.out.println("✔ Success Page displayed successfully- Request A Quote- Cloud Support");
		service.ContinueButton_ViewTicket();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		Assert.assertTrue(driver.getPageSource().contains("Test Form"), "Expected text not found on page");
		System.out.println("✔ View Ticket- Cloud Support- Note displayed successfully");
	}
	// D: Software Development Plans
		@Test(priority = 41)
		public void view_SoftwareDevelopment_Redirection() {
			ServicesPage service = new ServicesPage(driver);
			service.clickServicesSidetab();
			service.clickAddServices();
			service.Click_Software_Development();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean urlContains = wait.until(ExpectedConditions.urlContains("https://portal.bobcares.com/web-dev-design/service-categories"));
			Assert.assertTrue(urlContains, "Not redirected to Software Development Plans");
			System.out.println("✔ Redirected to Software Development Plans Page");
		}
}