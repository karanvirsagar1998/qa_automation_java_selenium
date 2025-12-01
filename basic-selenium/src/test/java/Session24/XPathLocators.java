package Session24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Session21.BasicSetup;

public class XPathLocators extends BasicSetup {
	private static WebDriverWait wait;

	public static void main(String[] args) {
		XPathLocators xPathLocate = new XPathLocators();
		xPathLocate.openBrowser("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		Locate the Search Bar by Placeholder
		WebElement searchBar = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search store']")));
		searchBar.sendKeys("apple");

//		Locate the "Log in" link by Exact Text
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Log in']")));
//		printing on success to avoid bot-block
//		loginBtn.click();
		System.out.println("login button found");

//		Locate an anchor with a class containing a specific substring
		WebElement anchorWithClass = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[contains(@class,'menu__link') and contains(@href,'comput')]")));
//		printing on success to avoid bot-block
//		anchorWithClass.click();
		System.out.println("clicked in Computers link");

//		closing the browser and opening in another page to test another functionality
		xPathLocate.closeBrowser();
		xPathLocate.openBrowser("https://demo.nopcommerce.com/login?returnUrl=%2F");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		Locate an input element whose ID contains Password.
		WebElement passwordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'Password')]")));
		passwordField.sendKeys("1234");

	}
}
