package support.ui;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	private WebDriver driver;

	public DropDown(WebDriver driver) {
		this.driver = driver;
	}
	
	public Select useDropDownMenu(){
		driver.navigate().to("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_select2");
		WebDriver frame = driver.switchTo().frame("iframeResult");
		Select select = new Select(frame.findElement(By.name("cars")));
		return select;
	}

}
