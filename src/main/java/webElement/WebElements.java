package webElement;

import static org.junit.Assert.fail;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class WebElements {
	private WebDriver driver;

	public WebElements(WebDriver driver) {
		this.driver = driver;
		
		// get the path
				File file = new File("../resources/web/Config.html");
				// go to the file
				driver.get("file:///" + file.getAbsolutePath().replace("..", "src\\main"));	
	}
	
	public void elements(){
		//Get the Checkbox as WebElement using it's name attribute
 		WebElement ledheadlamp = driver.findElement(By.xpath("//input[@name='ledheadlamp']"));
 		ledheadlamp.isDisplayed();
 		ledheadlamp.isEnabled();
 		ledheadlamp.isSelected();
 		ledheadlamp.clear();
 		ledheadlamp.click();
 		ledheadlamp.findElement(By.name(""));
 		ledheadlamp.findElements(By.xpath(""));
 		ledheadlamp.getAttribute("value");
 		ledheadlamp.getCssValue("");
 		ledheadlamp.getLocation();
 		ledheadlamp.getRect();
		//ledheadlamp.getScreenshotAs(target);
 		ledheadlamp.getSize();
 		ledheadlamp.getTagName();
 		ledheadlamp.getText();
 		ledheadlamp.sendKeys("");
 		ledheadlamp.submit();
 		
 		
	}
	

}
