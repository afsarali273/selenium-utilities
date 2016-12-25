package com.baidu.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Selenium2ProxyTest {
	public static void main(String[] args) {
		WebDriverFactory wdf = new WebDriverFactory();

		WebDriver driver = wdf.getFfWebDriverWithFirebugAndNetExport("E:\\java_workspace_2\\qa-lib\\lib\\firebug-1.7X.0b2.xpi", "E:\\java_workspace_2\\qa-lib\\lib\\netExport-0.8b12.xpi", "E:\\TEMP");// new
																																																		// FirefoxDriver();
		// Selenium2Proxy s2Proxy=new Selenium2Proxy(driver);
		driver.navigate().to("http://caslt.baidu.com:8477/?tpl=www2");
		// s2Proxy.captureScreenshot("e:\\a.jpg");
	}
}
