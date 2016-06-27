package webdriver.timeouts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImplicitWaitExample {

	 WebDriver driver;

	public ImplicitWaitExample(WebDriver driver) {
		File file = new File("../resources/web/AjaxDemo.html");

		this.driver = driver;
		// Set the Implicit Wait time Out to 10 Seconds ==> appplies for the whole driver and session
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// go to the file
		driver.get("file:///" + file.getAbsolutePath().replace("..", "src\\main"));
	}

	public void Interact(){
		try {

 			//Get link for Page 4 and click on it
 			WebElement page4button = driver.findElement(By.xpath(".//ul//li[4]/a"));
 			page4button.click();
 		
 			//Get an element with id page4 and verify it's text
 			WebElement message = driver.findElement(By.xpath(".//ul//li[4]/a"));
	}catch(Exception e){
		e.printStackTrace();
	}
	
	

}
}
