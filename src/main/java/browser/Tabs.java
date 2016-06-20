package browser;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;

public class Tabs {

	private WebDriver driver;

	public Tabs(WebDriver wdriver) {
		driver = wdriver;
	}

	// open a new tab, then get back to main
	public void openNewTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.switchTo().defaultContent();
		driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL + "1");
	}
}
