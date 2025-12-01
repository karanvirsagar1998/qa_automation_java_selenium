package Session21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSetup { // creating a class and re-using same function
							// everywhere

	protected static WebDriver driver;

	// this method will open browser
	public void openBrowser(String url) {
		driver = new ChromeDriver();
		driver.get(url);
	}

	// this method will close browser
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	// wait method
	public void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
