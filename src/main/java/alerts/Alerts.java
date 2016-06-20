package alerts;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Alerts {

	WebDriver driver;
	Alert alert;

	public Alerts(WebDriver ArgDriver) {
		setDriver(ArgDriver);
		// get the path
		File file = new File("../resources/web/Alerts.html");
		// go to the file
		driver.get("file:///" + file.getAbsolutePath().replace("..", "src\\main"));
	}

	// get the driver
	public WebDriver getDriver() {
		return driver;
	}

	// set the driver
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return the alert
	 */
	public Alert getAlert() {
		return alert;
	}

	/**
	 * @param alert
	 *            the alert to set
	 */
	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	// open the alert
	public Alert openAlert() {
		// Clicking button will show a simple Alert with OK Button
		WebElement button = driver.findElement(By.id("simple"));
		// open the alert
		button.click();
		// Get the Alert
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	// open a confirmation box
	public Alert confirmationBox() {
		// Clicking button will show a Confirmation Alert with OK and Cancel Button
		WebElement button = driver.findElement(By.id("confirm"));
		button.click();
		// Get the Alert
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	public Alert prompt(){
		
		//Clicking button will show a Prompt Alert asking user to enter
				//value/text with OK and Cancel Button
				WebElement button = driver.findElement(By.id("prompt"));
				button.click();
				
		//Get the Alert
		Alert alert = driver.switchTo().alert();

	
		return alert;
	}

}
