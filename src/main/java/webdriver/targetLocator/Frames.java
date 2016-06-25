package webdriver.targetLocator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frames {
	WebDriver driver;
	
	public Frames(WebDriver driver) {
		// get the path
				File file = new File("../resources/web/Alerts.html");
				// go to the file
				driver.get("file:///" + file.getAbsolutePath().replace("..", "src\\main"));
	}
	
	public void switchToFrameWithIdOrName()
	{
		//Activate the frame on left side using it's id attribute
		driver.switchTo().frame("left");
		
		//Get an element from the frame on left side and verify it's contents
		WebElement leftmsg = driver.findElement(By.tagName("p"));
		
		//Activate the Page, this will move context from frame back to the Page
		driver.switchTo().defaultContent();
		
		//Activate the frame on right side using it's name attribute
		driver.switchTo().frame("right");
		
		//Get an element from the frame on right side and verify it's contents
		WebElement rightmsg = driver.findElement(By.tagName("p"));
		
		//Activate the Page, this will move context from frame back to the Page	
		driver.switchTo().defaultContent();
		
	}
	
	public void switchToFrameByIndex()
	{
		//Activate the frame in middle using it's index. Index starts at 0
		driver.switchTo().frame(1);
		
		//Get an element from the frame in the middle and verify it's contents
		WebElement leftmsg = driver.findElement(By.tagName("p"));
		
		//Activate the Page, this will move context from frame back to the Page
		driver.switchTo().defaultContent();
	}
	
	public void switchToFrameByContents()
	{
		//Get all frames on the Page, created with <frame> tag
		List<WebElement> frames = driver.findElements(By.tagName("frame"));

		//In this example frame in the middle is activated by checking the contents
		//Activate frame and check if it has the desired content. If found perform the operations
		//if not, then switch back to the Page and continue checking next frame
		for(WebElement frame : frames) {
			//switchTo().frame() also accepts frame elements apart from id, name or index 
			driver.switchTo().frame(frame);
			if(driver.getPageSource().contains("This Frame doesn't have id or name")) {
				assertTrue("Middle Frame Found",true);
				break;
			}
			else
				driver.switchTo().defaultContent();
		}

		//Activate the Page, this will move context from frame back to the Page
		driver.switchTo().defaultContent();
	}
	
	public void switchToIFrame()
	{
		//The frame on the right side has a nested iframe containing 'Twitter Follow' Button
		//Activate the frame on right side using it's name attribute
		driver.switchTo().frame("right");
		
		//Get the iframe element
		WebElement twitterframe = driver.findElement(By.tagName("iframe"));
		//Activate the iframe 
		driver.switchTo().frame(twitterframe);
		//Get and Click the follow button from iframe
		//a Popup Window will appear after click
		WebElement button = driver.findElement(By.id("follow-button"));
		button.click();
		
		//Store the handle of current driver window
		String currentWindow = driver.getWindowHandle(); 
		
		//The Twitter Popup does not have name or title. 
		//Script will get handles of all open windows and 
		//desired window will be activated by checking it's Title
		Set<String> allWindows = driver.getWindowHandles();
		if(!allWindows.isEmpty()) {
			for (String windowId : allWindows)
			{
				driver.switchTo().window(windowId);
				if (driver.getTitle().equals("Unmesh Gundecha (@upgundecha) on Twitter")) {
					driver.close();
					break;
				}
					
			}
		}
		//Switch back to original driver window
		driver.switchTo().window(currentWindow);
		//switch back to Page from the frame
		driver.switchTo().defaultContent();
	}

}
