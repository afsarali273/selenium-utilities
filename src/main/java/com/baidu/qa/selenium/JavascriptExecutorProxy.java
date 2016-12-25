package com.baidu.qa.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Selenium 2.0 JavascriptExcutorProxy
 * 
 * @author liangxiaowu
 * 
 */
public class JavascriptExecutorProxy {
	private static Logger LOG = Logger.getLogger(JavascriptExecutorProxy.class.getName());
	private JavascriptExecutor je;
	private WebDriver commonDriver;

	/**
	 * constructor
	 * 
	 * @param commonDriver
	 *            instance of webdriver
	 */
	public JavascriptExecutorProxy(WebDriver commonDriver) {
		this.commonDriver = commonDriver;
		setJe((JavascriptExecutor) commonDriver);
	}

	/**
	 * @param je
	 *            the je to set
	 */
	public void setJe(JavascriptExecutor je) {
		this.je = je;
	}

	/**
	 * @return the je
	 */
	public JavascriptExecutor getJe() {
		return je;
	}

	/**
	 * get the count of a web page
	 * 
	 * @return
	 */
	public Long getPageDOMCount() {
		String js = "return document.getElementsByTagName('*').length";
		return (Long) je.executeScript(js);
	}

	/**
	 * scroll to the browser top
	 */
	public void scroll2Top() {
		je.executeScript("window.scrollTo(0,0)");
	}

	/**
	 * scroll to the browser bottom
	 */
	public void scroll2Bottom() {
		je.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/**
	 * scroll to the specific height of browser
	 */
	public void scroll2SpecificHeight(int z) {
		je.executeScript("window.scrollTo(0,document.body.scrollHeight/" + z + ")");
	}

	/**
	 * scroll to the specific webelement's position.
	 * 
	 * @param webElement
	 */
	public void scroll2WebElementHeight(WebElement e) {
		je.executeScript("window.scrollTo(0," + e.getLocation().getY() + ")");
	}

	/**
	 * click a webelement, sometimes you need this method.
	 * 
	 * @param e
	 */
	public void click(WebElement e) {
		String script = null;
		// if (commonDriver instanceof InternetExplorerDriver) {
		// script = "arguments[0].click();";
		// je.executeScript(script, e);
		// } else if (commonDriver instanceof FirefoxDriver) {
		// script = "arguments[0].click;";
		// je.executeScript(script, e);
		// } else if (commonDriver instanceof ChromeDriver) {
		script = "var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);";
		je.executeScript(script, e);
		// } else {
		// e.click();
		// }
	}
}
