package com.baidu.qa.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * webdriver factory, various of webdriver, such as firefox webdriver with
 * firebug, netexport plug-in.
 * 
 * @author liangxiaowu
 * 
 */
public class WebDriverFactory {
	private static Logger LOG = Logger.getLogger(WebDriverFactory.class.getName());

	/**
	 * get Selenium 2 IE WebDriver
	 * 
	 * @return
	 */
	public WebDriver getIeWebDriver() {
		return new InternetExplorerDriver();
	}

	/**
	 * get Selenium 2 fireforx WebDriver
	 * 
	 * @return
	 */
	public WebDriver getFfWebDriver() {
		return new FirefoxDriver();
	}

	/**
	 * get a specific firefox driver
	 * 
	 * @param firefoxPath
	 *            e.g. D:/Program Files/Mozilla Firefox/firefox.exe
	 * @return
	 */
	public WebDriver getFfWebDriver(String firefoxPath) {
		System.setProperty("webdriver.firefox.bin", firefoxPath);
		return new FirefoxDriver();
	}

	/**
	 * get ff webdriver with firebug
	 * 
	 * @param firebugPath
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebug(final String firebugPath) {
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(firebugPath));
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2"); // hard
																					// code
																					// here
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * get ff webdriver with specific firefox and firebug
	 * 
	 * @param firefoxPath
	 * @param firebugPath
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebug(final String firefoxPath, final String firebugPath) {
		System.setProperty("webdriver.firefox.bin", firefoxPath);
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(firebugPath));
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2"); // hard
																					// code
																					// here
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * 
	 * @param firebugPath
	 * @param netExportPath
	 * @param defaultLogDir
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebugAndNetExport(final String firebugPath, final String netExportPath, final String defaultLogDir) {
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(firebugPath));
			profile.addExtension(new File(netExportPath));
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2");
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
			profile.setPreference("extensions.firebug.net.enableSites", true);
			profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
			profile.setPreference("extensions.firebug.netexport.autoExportToFile", true);
			profile.setPreference("extensions.firebug.netexport.showPreview", false);
			profile.setPreference("extensions.firebug.netexport.defaultLogDir", defaultLogDir);// "E:\\TEMP");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * 
	 * @param firefoxPath
	 * @param firebugPath
	 * @param netExportPath
	 * @param defaultLogDir
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebugAndNetExport1(final String firefoxPath, final String firebugPath, final String netExportPath, final String defaultLogDir) {
		System.setProperty("webdriver.firefox.bin", firefoxPath);
		FirefoxProfile profile = new FirefoxProfile();

		try {
			profile.addExtension(new File(firebugPath));
			profile.addExtension(new File(netExportPath));
			profile.setPreference("browser.tabs.showSingleWindowModePrefs", true);
			// firebug
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2");
			profile.setPreference("extensions.firebug.DBG_NETEXPORT", false);
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
			profile.setPreference("extensions.firebug.defaultPanelName", "net");
			// profile.setPreference("extensions.firebug.alwaysOpenTraceConsole",
			// "false");
			profile.setPreference("extensions.firebug.net.enableSites", true);
			// netexport
			profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
			profile.setPreference("extensions.firebug.netexport.autoExportToFile", true);
			profile.setPreference("extensions.firebug.netexport.autoExportToServer", false);
			profile.setPreference("extensions.firebug.netexport.compress", false);
			profile.setPreference("extensions.firebug.netexport.sendToConfirmation", false);
			profile.setPreference("extensions.firebug.netexport.showPreview", false);
			profile.setPreference("extensions.firebug.netexport.defaultLogDir", defaultLogDir);// "E:\\TEMP");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * Get ff webdriver with firebug and netexport
	 * 
	 * @param firebugPath
	 * @param netExportPath
	 * @param beaconServerURL
	 *            e.g. http://10.81.23.71:8000/showslow/beacon/har/
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebugAndNetExport2(final String firebugPath, final String netExportPath, final String beaconServerURL) {
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(firebugPath));
			profile.addExtension(new File(netExportPath));
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2");
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
			profile.setPreference("extensions.firebug.defaultPanelName", "net");
			profile.setPreference("extensions.firebug.alwaysOpenTraceConsole", true);
			// netexport
			profile.setPreference("extensions.firebug.net.enableSites", true);
			profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
			profile.setPreference("extensions.firebug.netexport.autoExportToFile", false);
			profile.setPreference("extensions.firebug.netexport.autoExportToServer", true);
			profile.setPreference("extensions.firebug.netexport.compress", true);
			profile.setPreference("extensions.firebug.netexport.sendToConfirmation", false);
			profile.setPreference("extensions.firebug.netexport.showPreview", false);
			profile.setPreference("extensions.firebug.netexport.beaconServerURL", beaconServerURL);
			profile.setPreference("extensions.firebug.netexport.viewerURL", "http://10.81.23.71:8000/harviewer/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * 
	 * @param firefoxPath
	 * @param firebugPath
	 * @param netExportPath
	 * @param beaconServerURL
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebugAndNetExport3(final String firefoxPath, final String firebugPath, final String netExportPath, final String beaconServerURL) {
		FirefoxProfile profile = new FirefoxProfile();
		try {
			System.setProperty("webdriver.firefox.bin", firefoxPath);
			profile.addExtension(new File(firebugPath));
			profile.addExtension(new File(netExportPath));
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2");
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
			profile.setPreference("extensions.firebug.defaultPanelName", "net");
			profile.setPreference("extensions.firebug.alwaysOpenTraceConsole", false);
			profile.setPreference("extensions.firebug.addonBarOpened", false);
			// netexport
			profile.setPreference("extensions.firebug.net.enableSites", true);
			profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
			profile.setPreference("extensions.firebug.netexport.autoExportToFile", false);
			profile.setPreference("extensions.firebug.netexport.autoExportToServer", true);
			profile.setPreference("extensions.firebug.netexport.compress", false);
			profile.setPreference("extensions.firebug.netexport.sendToConfirmation", false);
			profile.setPreference("extensions.firebug.netexport.showPreview", false);
			profile.setPreference("extensions.firebug.netexport.beaconServerURL", beaconServerURL);
			profile.setPreference("extensions.firebug.netexport.viewerURL", "http://10.81.23.71:8000/harviewer/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * 
	 * @param firebugPath
	 * @param netexportPath
	 * @param ySlowPath
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebugNetExportAndYSlow(final String firebugPath, final String netexportPath, final String ySlowPath) {
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(firebugPath));
			profile.addExtension(new File(netexportPath));
			profile.addExtension(new File(ySlowPath));
			// TODO
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2");
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
			profile.setPreference("extensions.yslow.optinBeacon", true);
			profile.setPreference("extensions.yslow.autorun", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * 
	 * @param firebugPath
	 * @param ySlowPath
	 * @param yslowBeaconUrl
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebugAndYSlow(final String firebugPath, final String ySlowPath, final String yslowBeaconUrl) {
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(firebugPath));
			profile.addExtension(new File(ySlowPath));
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2");
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
			profile.setPreference("extensions.firebug.defaultPanelName", "YSlow");
			// yslow
			profile.setPreference("extensions.yslow.beaconUrl", yslowBeaconUrl);
			profile.setPreference("extensions.yslow.beaconInfo", "grade");
			profile.setPreference("extensions.yslow.optinBeacon", true);
			profile.setPreference("extensions.yslow.autorun", true);
			profile.setPreference("extensions.yslow.defaultRuleset", "ydefault");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * 
	 * @param firefoxPath
	 * @param firebugPath
	 * @param ySlowPath
	 * @param yslowBeaconUrl
	 * @param defaultRulesetName
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebugAndYSlow1(final String firefoxPath, final String firebugPath, final String ySlowPath, final String yslowBeaconUrl, final String defaultRulesetName) {
		System.setProperty("webdriver.firefox.bin", firefoxPath);
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(firebugPath));
			profile.addExtension(new File(ySlowPath));
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2");
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
			profile.setPreference("extensions.firebug.defaultPanelName", "YSlow");
			// yslow
			profile.setPreference("extensions.yslow.beaconUrl", yslowBeaconUrl);
			profile.setPreference("extensions.yslow.beaconInfo", "grade");
			profile.setPreference("extensions.yslow.optinBeacon", true);
			profile.setPreference("extensions.yslow.autorun", true);
			profile.setPreference("extensions.yslow.defaultRuleset", defaultRulesetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * 
	 * @param firefoxPath
	 * @param firebugPath
	 * @param ySlowPath
	 * @param yslowBeaconUrl
	 * @param beaconInfo
	 * @param defaultRulesetName
	 * @return
	 */
	public WebDriver getFfWebDriverWithFirebugAndYSlow2(final String firefoxPath, final String firebugPath, final String ySlowPath, final String yslowBeaconUrl, final String beaconInfo,
			final String defaultRulesetName) {
		System.setProperty("webdriver.firefox.bin", firefoxPath);
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(firebugPath));
			profile.addExtension(new File(ySlowPath));
			profile.setPreference("extensions.firebug.currentVersion", "1.7X.0b2");
			profile.setPreference("extensions.firebug.allPagesActivation", "on");
			profile.setPreference("extensions.firebug.defaultPanelName", "YSlow");
			// yslow
			profile.setPreference("extensions.yslow.beaconUrl", yslowBeaconUrl);
			profile.setPreference("extensions.yslow.beaconInfo", beaconInfo);
			profile.setPreference("extensions.yslow.optinBeacon", true);
			profile.setPreference("extensions.yslow.autorun", true);
			profile.setPreference("extensions.yslow.defaultRuleset", defaultRulesetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new FirefoxDriver(profile);
	}

	/**
	 * get Selenium 2 chrome WebDriver
	 * 
	 * @return
	 */
	public WebDriver getChWebDriver() {
		return new ChromeDriver();
	}

	/**
	 * 
	 * @param chromePath
	 *            e.g. lib\\chromedriver.exe
	 * @return
	 */
	public WebDriver getChWebDriver(final String chromeDriverPath) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		return new ChromeDriver();
	}

	public WebDriver getChWebDriver2(final String chromeDriverPath) {
		WebDriver webDriver = null;
		ChromeDriverService chromeServer = null;
		chromeServer = new ChromeDriverService.Builder().usingDriverExecutable(new File(chromeDriverPath)).usingAnyFreePort().build();
		try {
			chromeServer.start();
		} catch (IOException e) {
			LOG.error("IOException in getChWebDriver2: " + e.getMessage());
			return null;
		}
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		webDriver = new RemoteWebDriver(chromeServer.getUrl(), capabilities);
		return webDriver;
	}

	public WebDriver getChWebDriver3(ChromeDriverService chromeDriverService) {
		WebDriver webDriver = null;
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		webDriver = new RemoteWebDriver(chromeDriverService.getUrl(), capabilities);
		return webDriver;
	}

	/**
	 * get Selenium 2 html unit WebDriver
	 * 
	 * @return
	 */
	public WebDriver getHtWebDriver() {
		return new HtmlUnitDriver();
	}
}
