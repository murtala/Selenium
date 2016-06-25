package interactions.actions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ClickAndHoldExample {

	private WebDriver driver;

	public ClickAndHoldExample(WebDriver driver) {
		this.driver = driver;

		File file = new File("../resources/web/HTML5 Test Page - Canvas Drawing.htm");
		// go to the file
		driver.get("file:///" + file.getAbsolutePath().replace("..", "src\\main"));
	}

	public void HTML5CanvasDrawing() throws Exception {

		// Get the HTML5 Canvas Element
		WebElement canvas = driver.findElement(By.id("imageTemp"));
		// Select the Pencil Tool
		Select drawtool = new Select(driver.findElement(By.id("dtool")));
		drawtool.selectByValue("pencil");

		// Create a Action Chain for Draw a shape on Canvas
		Actions builder = new Actions(driver);
		builder.clickAndHold(canvas).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50)
				.moveByOffset(-50, -10).release().perform();

		// Get a screenshot of Canvas element after Drawing and compare it to the base version
		// to verify if the Drawing is performed
		// assertEquals(CompareUtil.Result.Matched, CompareUtil.CompareImage("c:\\tmp\\base_post.png","c:\\tmp\\post.png"));
	}

}
