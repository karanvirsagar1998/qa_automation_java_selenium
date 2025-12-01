package Session22;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Session21.BasicSetup;

//Locators(ID,Name,LinkText,PartialLinkText,Class&Tag)
public class Locators extends BasicSetup {

	public void testForgotPasswordFunctionality() {
		int comeBackCounter = 0;

		WebElement findForgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));

		if (findForgotPasswordLink.isDisplayed() && findForgotPasswordLink.isEnabled()) {
			comeBackCounter++; // moving one page forward
			waitForSeconds(2); // wait for 2 seconds before doing anything
			findForgotPasswordLink.click();
//		waiting to locate element
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			System.out.println("Navigated successfully. Email input is ready.");

//		testing element
			String testEmail = "KaranvirSingh123@gmail.com";
			waitForSeconds(2); // wait for 2 seconds before doing anything
			emailField.sendKeys(testEmail);
			String getVal = emailField.getAttribute("value");

			if (getVal.equals(testEmail)) {
				WebElement submitBtn = driver.findElement(By.id("form_submit"));
				if (submitBtn.isDisplayed() && submitBtn.isEnabled()) {
					comeBackCounter++; // moving one page forward
					waitForSeconds(2); // wait for 2 seconds before doing anything
					submitBtn.click();
				} else {
					System.out.println("Button not ready to click");
				}
			} else {
				System.out.println("Text not entered. Not clicking the button.");

			}

//		going back to home page
			for (int i = 0; i < comeBackCounter; i++) {
				waitForSeconds(2); // wait for 2 seconds before doing anything
				driver.navigate().back();
//				check if page loads, then go back
				wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
			}
		}
	}

	public void getAllHyperLinks() {
		List<WebElement> allLinks = driver.findElements(By.tagName("ul"));
		for (int i = 0; i < allLinks.size(); i++) {
			System.out.print(allLinks.get(i).getText());
			if (i != allLinks.size() - 1) { // not last element
				System.out.print(", ");
			}
		}
	}

	public static void main(String[] args) {
		Locators locators = new Locators();
		locators.openBrowser("https://the-internet.herokuapp.com/");
		locators.testForgotPasswordFunctionality();
		locators.getAllHyperLinks();
		locators.closeBrowser();
	}

}
