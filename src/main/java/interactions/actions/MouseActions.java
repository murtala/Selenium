package interactions.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
WebDriver driver;

	public MouseActions(WebDriver driver) {
		
	}
	
	public void mouseOver(){
		Actions action = new Actions(driver);

		WebElement toElement = driver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/a/span"));
		action.moveToElement(toElement);
		System.out.println("Menu:  " + toElement.getText());
		action.build().perform();
	}
}
