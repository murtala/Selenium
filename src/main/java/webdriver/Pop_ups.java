package webdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pop_ups {

	private WebDriver driver;

	public Pop_ups(WebDriver driver) {
		this.driver = driver;
		driver.get("http://www.popuptest.com/goodpopups.html");
	}

	public void openPopUps() {
		driver.findElement(By.linkText("Good PopUp #1")).click();
		driver.findElement(By.linkText("Good PopUp #3")).click();
		driver.findElement(By.linkText("Good PopUp #4")).click();
	}

	public void handlePopUp() {

		// with many pop ups, when close 1, control still stays there, will give not found error
		// closing a pop up will not automatically switch to another window
		// Save the WindowHandle of Parent Browser Window
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			WebDriver popup = driver.switchTo().window(window);
			System.out.println("Title: " + popup.getTitle() + " url: " + popup.getCurrentUrl() + " handle :"
					+ popup.getWindowHandle() + "Current Page" + driver.getCurrentUrl());
			driver.switchTo().window(window).get("http://google.com");
		}

		driver.switchTo().window(mainWindowHandle);// return to main window
	}

}
