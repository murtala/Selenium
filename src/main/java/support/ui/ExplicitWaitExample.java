package support.ui;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ScreenCapture;

public class ExplicitWaitExample {
	
	private WebDriver driver;

	public ExplicitWaitExample(WebDriver driver) {
		this.driver = driver;
		File file = new File("../resources/web/AjaxDemo.html");
		// go to the file
		driver.get("file:///" + file.getAbsolutePath().replace("..", "src\\main"));
	}
	
	public void interact(){
		   try {
	 			WebElement page4button = driver.findElement(By.xpath(".//ul//li[4]/a"));
	 			page4button.click();
	 		
	 			WebElement message = (new WebDriverWait(driver, 5)).until(new ExpectedCondition<WebElement>(){
	 						public WebElement apply(WebDriver d) {
	 							return d.findElement(By.xpath(".//ul//li[4]/a"));
	 						}});
	 			ScreenCapture sc = new ScreenCapture(driver);
	 			sc.getscreenshot();
	 			
	 		} catch (Exception e) {
	 		
	 			e.printStackTrace();
	 		} finally {
	 		
	 		}
	}

}
