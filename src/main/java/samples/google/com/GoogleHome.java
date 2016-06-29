package samples.google.com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoogleHome {

	WebDriver driver;
	String url;

	GoogleHome(WebDriver wdriver) {
		this.driver = wdriver;
		url = "https://www.google.com";
		driver.get(url);
	}

	String getTitle() {
		return driver.getTitle();
	}

	void search(String query) {
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys(query);
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	}

	void shop(ArrayList<String> range) {
		driver.findElement(By.xpath("//div[@id='hdtb_msb']/a")).click();
		// click on the shopping link
		driver.findElement(By.xpath("//div[@id='hdtb_more_mn']/div/a")).click();
		// filter by new items
		driver.findElement(By.xpath("//span[contains(text(),'New items')]"))
				.click();
		// enter price range .
		// we wait for the boxes to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		// since the filter refreshes the page, i am going to wait for that
		// refresh to finish
		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.name("lower")))));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.name("upper")))));
		// now put my price range
		driver.findElement(By.name("lower")).sendKeys(range.get(0));
		driver.findElement(By.name("upper")).sendKeys(range.get(1));
		// click the go button
		driver.findElement(By.xpath("//button[contains(text(),'Go')]")).click();
	}

	// click on the "Images" in a new tab to display images from the search
	void images() {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText("Images")))
				.keyDown(Keys.CONTROL);
		builder.click();
		builder.keyUp(Keys.CONTROL);
		builder.perform();
	}

	void maps() {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Maps')]")))
				.keyDown(Keys.CONTROL);
		builder.click();
		builder.keyUp(Keys.CONTROL);
		builder.perform();
	}

}
