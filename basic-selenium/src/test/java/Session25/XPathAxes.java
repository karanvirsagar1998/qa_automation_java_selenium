package Session25;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Session21.BasicSetup;

public class XPathAxes extends BasicSetup {
	private static WebDriverWait wait;

	public static void main(String[] args) {
		XPathAxes XPathAxes = new XPathAxes();
//		XPathAxes.openBrowser("https://demo.nopcommerce.com/login?returnUrl=%2F");
//		driver.manage().window().maximize();
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
////		Task 1 — Locate Email input using its label (following-sibling)
//		WebElement followingSibling = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//label[text()='Email:']/following-sibling::input")));
//		followingSibling.sendKeys("asd");
//
////		Task 2 — Locate Remember me? checkbox through label
//		WebElement rememberMeBox = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//label[text()='Remember me?']/preceding-sibling::input")));
//		System.out.println("Found rememberMeBox");
//
////		closing browser
//		XPathAxes.closeBrowser();

//		opening for this task again
		XPathAxes.openBrowser("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Task 3 — Click “Computers” category using ancestor axis
//		WebElement computerLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//a[text()='Computers']/ancestor::div[@class='menu__item-toggle']")));
//		System.out.println("Found computerLink");
//		computerLink.click();

//		Task 4 — Get all subcategories under Electronics using descendant

		Actions actions = new Actions(driver);
		WebElement electronics = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Electronics']"))
		);
		actions.moveToElement(electronics).perform();

		// Locate the Electronics menu parent
		WebElement electronicsMenu = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//a[text()='Electronics']/ancestor::div[@class='menu__item menu-dropdown']"))
		);

		// Get all subcategory links using descendant
		List<WebElement> subMenuItems = electronicsMenu.findElements(
		        By.xpath(".//descendant::div[@class='menu__list-view']//a")
		);

		// Print subcategory names
		for (WebElement item : subMenuItems) {
		    System.out.println(item.getText());
		}

	}
}
