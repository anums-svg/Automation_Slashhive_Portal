package tests;

import java.time.Duration;

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
}