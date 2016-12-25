package com.baidu.qa.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;

import com.thoughtworks.selenium.Selenium;

/**
 * selenium 1.0 proxy class
 * 
 * @author liangxiaowu
 * 
 */
public class Selenium1Proxy {
	private static Logger LOG = Logger.getLogger(Selenium1Proxy.class.getName());
	private Selenium selenium1;
	private WebDriver commonDriver;

	public Selenium1Proxy(WebDriver commonDriver, String testSiteUrl) {
		this.commonDriver = commonDriver;
		selenium1 = new WebDriverBackedSelenium(commonDriver, testSiteUrl);
	}

	public void start() {
		selenium1.start();
	}

	public void windowMaximize() {
		selenium1.windowMaximize();
	}

	public void windowFocus() {
		selenium1.windowFocus();
	}

	public Selenium getSelenium1() {
		return selenium1;
	}

	// public File captureScreenshot(){
	// selenium1.windowMaximize();
	// selenium1.windowFocus();
	// return selenium1.captureScreenshot("");
	// }
	//
	// public void captureScreenshot(String fileName){
	// selenium1.windowMaximize();
	// selenium1.windowFocus();
	// File dest=new File(fileName);
	// selenium1.captureScreenshot("").renameTo(dest);
	// }
}
