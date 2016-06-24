package webdriver.manage.window;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class WindowSize {
	private WebDriver driver;
	public WindowSize(WebDriver driver) {
		this.driver = driver;
		driver.get("about:blank");
	}
	public void maximizeWindow(){
		driver.manage().window().maximize();
	}
	
	public void getPosition(){
		driver.manage().window().getPosition();
	}
	public void fullscreen(){
		driver.manage().window().fullscreen();	
	}
	public void getSize(){
		driver.manage().window().getSize();
	}
	public void setSize(){
		Dimension targetSize = new Dimension(300, 300);
		driver.manage().window().setSize(targetSize);	
	}
	public void setPosition(){
		Point targetPosition = new Point(0, 800);
		driver.manage().window().setPosition(targetPosition );
	}
}
