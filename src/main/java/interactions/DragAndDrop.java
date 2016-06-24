package interactions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
	WebDriver driver;
	public DragAndDrop(WebDriver driver) {
		this.driver = driver;
		driver.get("http://www.w3schools.com/html/html5_draganddrop.asp");
	}
	
	public void perform(){
		Actions builder = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("div1"));
		WebElement target = driver.findElement(By.id("div2"));
		
		builder.dragAndDrop(source, target) .perform();
	
	}

}
