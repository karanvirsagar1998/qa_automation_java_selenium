package Session23;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Session21.BasicSetup;

public class CssLocators extends BasicSetup {

	private static WebDriverWait wait;

	public static void main(String[] args) {
		CssLocators cssLocators = new CssLocators();
		cssLocators.openBrowser("https://demo.nopcommerce.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		searching by input type and id
		WebElement searchInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#small-searchterms")));
		searchInput.sendKeys("Samsung");

//		going to a different page and then searching by input type and name
		WebElement goTologin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ico-login")));
		goTologin.click();

//			wait about 2 seconds there
		cssLocators.waitForSeconds(2);

		WebElement emailField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='Email']")));
		emailField.sendKeys("abc@gmail.com");
	}
}