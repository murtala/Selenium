package flashVideos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Youtube {
	WebDriver driver = new FirefoxDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, 30);

	// api ref : https://developers.google.com/youtube/js_api_reference
	public void OpenPage() {
		driver.get("http://tinyurl.com/bqnaoo7");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// 
			e.printStackTrace();
		}
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("player")));
	}

	public void pause() {
		js.executeScript("return document.movie_player.pauseVideo();");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// 
			e.printStackTrace();
		}
	}

	public void play() {
		js.executeScript("return document.movie_player.playVideo();");
	}

	public void seekTo() {
		js.executeScript("return document.movie_player.seekTo('140','true');");

	}

	public void mute() {
		js.executeScript("return document.movie_player.mute();");

	}

	public void setVolume() {
		js.executeScript("return document.movie_player.setVolume('50');");

	}

	public void stopVideo() {
		js.executeScript("return document.movie_player.stopVideo();");

	}

/*	public void getCurrentTime() {
		int time = (int) js.executeScript("return document.movie_player.getCurrentTime();");
		System.out.println(time);

	}*/

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();

		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "movie_player");
		driver.manage().window().maximize();
		driver.get("http://tinyurl.com/bqnaoo7");
		Thread.sleep(2000L);

		// let the video load
		while (Integer.parseInt(flashApp.callFlashObject("getPlayerState")) == 3) {
			Thread.sleep(1000L);
		}

		// Play the video for 10 seconds
		Thread.sleep(5000);
		flashApp.callFlashObject("pauseVideo");
		Thread.sleep(5000);
		flashApp.callFlashObject("playVideo");
		Thread.sleep(5000);
		flashApp.callFlashObject("seekTo", "140", "true");
		Thread.sleep(5000);
		flashApp.callFlashObject("mute");
		Thread.sleep(5000);
		flashApp.callFlashObject("setVolume", "50");
		Thread.sleep(5000);

	}

}