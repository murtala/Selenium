package os.windowUtils;

import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.os.ProcessUtils;;


public class WindowsRegistry {
	
	public void readRegistry(){
		//TODO : process utils
		WindowsUtils.tryToKillByName("firefox.exe");
		String osName =  WindowsUtils.readStringRegistryValue("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\WindowsNT\\CurrentVersion\\DevicePath");
		//String osName = WindowsUtils.readStringRegistryValue("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\WindowsNT\\CurrentVersion\\DevicePath");
		System.out.println("OS name: "+osName);
	}
	
	public void writeRegistry(){
		WindowsUtils.writeStringRegistryValue("HKEY_CURRENT_USER\\SOFTWARE\\Selenium\\SeleniumVersion", "2.24");
	}

}
