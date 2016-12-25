package com.baidu.qa.selenium;

import java.io.File;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Keyboard;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.baidu.qa.common.constants.WaitConstant;

/**
 * selenium 2.0 proxy class
 * 
 * @author liangxiaowu
 * 
 */
public class Selenium2Proxy {
	private static Logger LOG = Logger.getLogger(Selenium2Proxy.class.getName());
	private WebDriver commonDriver;
	private UIWebDriver webDriver;

	public Selenium2Proxy(WebDriver commonDriver) {
		this.commonDriver = commonDriver;
		this.webDriver = new UIWebDriver(commonDriver, WaitConstant.DEFAULT_SLEEP_TIMEOUT_SECONDS);
	}

	public void close() {
		commonDriver.close();
	}

	public void quit() {
		commonDriver.quit();
	}

	public void forward() {
		commonDriver.navigate().forward();
	}

	public void back() {
		commonDriver.navigate().back();
	}

	public String getCurrentUrl() {
		return commonDriver.getCurrentUrl();
	}

	public String getTitle() {
		return commonDriver.getTitle();
	}

	public void deleteAllCookies() {
		commonDriver.manage().deleteAllCookies();
	}

	public void captureScreenshot(String fileName) {
		TakesScreenshot tsDriver = (TakesScreenshot) commonDriver;
		File image = new File(fileName);
		tsDriver.getScreenshotAs(OutputType.FILE).renameTo(image);
	}

	public void switchToWindow(String windowTitle) {
		Set<String> windowHandles = commonDriver.getWindowHandles();
		for (String handler : windowHandles) {
			commonDriver.switchTo().window(handler);
			String title = commonDriver.getTitle();
			if (windowTitle.equals(title)) {
				break;
			}
		}
	}

	public void switchToDefaultContent() {
		commonDriver.switchTo().defaultContent();
		webDriver.wait3Sec();
	}

	public void switchToFrame(String frameId) {
		commonDriver.switchTo().frame(frameId);
	}

	private Alert switchToAlert() {
		return commonDriver.switchTo().alert();
	}

	public void acceptAlert() {
		switchToAlert().accept();
	}

	public void dismissAlert() {
		switchToAlert().dismiss();
	}

	/**
	 * Usage: mouse.mouseDown(((Locatable)weSecNav).getCoordinates());
	 * 
	 * @return
	 */
	public Mouse getMouse() {
		return ((HasInputDevices) commonDriver).getMouse();
	}

	/**
	 * Usage: getKeyboard().pressKey(Keys.CONTROL);
	 * 
	 * @return
	 */
	public Keyboard getKeyboard() {
		return ((HasInputDevices) commonDriver).getKeyboard();
	}

	public void refreshWithCtrlF5() {
		getKeyboard().sendKeys(Keys.CONTROL, Keys.F5);
	}

	public void click(WebElement e) {
		new Actions(commonDriver).moveToElement(e).click().perform();
	}
}
