package firefox.firefoxProfile;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxProfile;

public class Preferences {
	static FirefoxProfile profile;
	public static FirefoxProfile switchUserAgentTo(String userAgentString) {
		System.out.println("http://www.useragentstring.com/index.php");
		profile.setPreference("general.useragent.override", userAgentString);
		return profile;
	}
	
	public FirefoxProfile switchProfile(File profileDir) {
		 profile =  new FirefoxProfile(profileDir);
		 return profile;
	}
}
