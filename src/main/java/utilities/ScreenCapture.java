package utilities;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class ScreenCapture {
	WebDriver driver;
	File file;
	private ScreenRecorder screenRecorder;
	private StringBuffer verificationErrors = new StringBuffer();

	public ScreenCapture(WebDriver driver) {
		this.driver = driver;
		file = new File("../resources/media/screenshot" + new Date().getTime() + ".png").getAbsoluteFile();
		// go to the file
		// driver.get("file:///" + file.getAbsolutePath().replace("..", "src\\main"));

		file = new File(file.getAbsolutePath().replace("..", "src\\main"));
	}

	public void getscreenshot() throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, file);
		Reporter.log("Saving picture");
		System.out.println("ScreenShot saved at: " + file.toString());
	}

	public void altPrtSc() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_PRINTSCREEN);
		robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
		robot.keyRelease(KeyEvent.VK_ALT);

		try {
			Thread.sleep(1000 * 2);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
		RenderedImage image = null;
		try {
			image = (RenderedImage) t.getTransferData(DataFlavor.imageFlavor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean isSuccess = false;
		try {
			isSuccess = ImageIO.write(image, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(isSuccess);
	}

	public void getScreenShot(WebElement element) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(scrFile, file);

			File screen = scrFile;
			// Create an instance of Buffered Image from captured screenshot

			// Get the Width and Height of the WebElement using
			int width = element.getSize().getWidth();
			int height = element.getSize().getHeight();

			Point p = element.getLocation();

			String CroppedfileLocation = file.getAbsolutePath();
			BufferedImage img = ImageIO.read(file);
			File outputfile = new File(CroppedfileLocation);

			// BufferedImage croppedImg = img.getSubimage(p.getX()-30, p.getY(), width,height);
			System.out.println("width " + width + " height " + height + "p.getX() " + p.getX() + " p.getY() " + p.getY()
					+ " getRaster().getHeight()" + img.getRaster().getHeight() + " - " + img.getRaster().getMinY()
					+ "getRaster().getWeight()" + img.getRaster().getWidth() + " - " + img.getRaster().getMinX());
			// img.getRaster().getHeight();
			// img.getRaster().getHeight();
			// ImageIO.write(croppedImg, "png", outputfile);

			// Write back the image data for element in File object
			// ImageIO.write(dest, "png", screen);

			// Now you can do whatever you need to do with it, for example copy
			// somewhere

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void startScreenRecording() {
		// Create an instance of GraphicsConfiguration to get the Graphics configuration
		// of the Screen. This is needed for ScreenRecorder class.
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		// Create a instance of ScreenRecorder with the required configurations
		try {
			screenRecorder = new ScreenRecorder(gc, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, (int) 24, FrameRateKey,
							Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, (int) (15 * 60)),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
					null);

			// Call the start method of ScreenRecorder to begin recording
			screenRecorder.start();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
	
	public void stopScreenRecording(){
		try {
			screenRecorder.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
