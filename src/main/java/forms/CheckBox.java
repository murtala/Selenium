package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class CheckBox {

    private WebDriver driver;
    public CheckBox(WebDriver newDriver) {
		this.driver = newDriver;
	}
    
    public void interactWithcheckBox(){  
		  File file2 = new File("../resources/web/Config.html");
		driver.get("file:///" + file2.getAbsolutePath().replace("..", "src\\main"));
    }

}