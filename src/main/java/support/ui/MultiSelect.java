package support.ui;

import java.io.File;

import org.openqa.selenium.WebDriver;

public class MultiSelect {
	private WebDriver driver;

	public MultiSelect(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectMultiplesDropDowns(){
		  File file2 = new File("../resources/web/MultiSelect.htm");
			driver.get("file:///" + file2.getAbsolutePath().replace("..", "src\\main"));
	}
public void selectMultiplesDropDowns2(){
		  File file2 = new File("../resources/web/Config.html");
			driver.get("file:///" + file2.getAbsolutePath().replace("..", "src\\main"));
	}
}
