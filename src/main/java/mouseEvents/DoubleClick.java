package mouseEvents;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
	
	WebDriver driver;
	static  WebElement message ;
	public DoubleClick(WebDriver ArgDriver) {
		
		this.driver = ArgDriver;
		// get the path
		File file = new File("../resources/web/DoubleClickDemo.html");
		// go to the file
		driver.get("file:///" + file.getAbsolutePath().replace("..", "src\\main"));
		 message = driver.findElement(By.id("message"));
	}
	
	//the double click
	public void performDoubleClick(){
		 
		 Actions action = new Actions(driver);
		  action.doubleClick(message);
		  action.build().perform();
	}
}
