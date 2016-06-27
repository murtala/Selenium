package proxy;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProxyExample {
	public void connectToProxy() {
		FirefoxProfile profile = new FirefoxProfile();
		String PROXY = "xx.xx.xx.xx:xx";
		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY);
		proxy.setFtpProxy(PROXY);
		proxy.setSslProxy(PROXY);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, proxy);
	}

}
