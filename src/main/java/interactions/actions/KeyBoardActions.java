package interactions.actions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {
	WebDriver driver;
	public KeyBoardActions(WebDriver driver) {
		this.driver = driver;
		// go to the file
		
	}
	
	public void selectMultipleTableRows(){
		driver.get("http://www.w3schools.com/html/html_tables.asp");
		WebElement sampleTable = driver.findElement(By.xpath("//*[@id='main']/table[1]"));

		//Select second and fourth row from table using Control Key.
		//Row Index start at 0
		Actions action = new Actions(driver);
		
		WebElement row1col1 = driver.findElement(By.xpath(".//*[@id='main']/table[1]/tbody/tr[1]/th[1]"));
		WebElement row2col2 = driver.findElement(By.xpath(".//*[@id='main']/table[1]/tbody/tr[2]/td[2]"));
		WebElement row5col5 = driver.findElement(By.xpath(".//*[@id='main']/table[1]/tbody/tr[5]/td[3]"));
		
		action.moveToElement(row1col1);
		action.click(row1col1);
		action.keyDown(Keys.CONTROL);
		action.click(row1col1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.moveToElement(row5col5);
		action.click(row5col5);
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void useArrows(){
		driver.get("http://www.travelocity.com/");
		driver.findElement(By.id("tab-flight-tab")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("flight-type-one-way-label")).click();
		WebElement fo=driver.findElement(By.id("flight-origin"));
		fo.sendKeys("New York");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fo.sendKeys(Keys.ARROW_DOWN);
		fo.sendKeys(Keys.ARROW_DOWN);
		fo.sendKeys(Keys.ENTER);
		
		WebElement ft=driver.findElement(By.id("flight-destination"));
		ft.sendKeys("San fran");
		//code..... to wait and arrow_down......enter
		
		
		driver.findElement(By.id("flight-departing")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("29")).click();
	}
	
	public void keyInputs(){
			driver.navigate().to("http://www.google.com");
			//driver.findElement(By.id("gbqfq")).sendKeys(Keys.TAB);
			//Thread.sleep(3000);
			//driver.findElement(By.id("gbqfq")).sendKeys(Keys.TAB);
			//driver.findElement(By.id("gbqfq")).sendKeys(Keys.SPACE);
			
			//send multiple keys
			driver.findElement(By.id("gbqfq")).sendKeys(Keys.chord("Dota2",Keys.ENTER));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.navigate().back();
			driver.findElement(By.id("gbqfq")).sendKeys(Keys.chord(Keys.TAB, Keys.TAB, Keys.SPACE));
		
		}


}
