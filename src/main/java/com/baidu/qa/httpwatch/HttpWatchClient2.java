package com.baidu.qa.httpwatch;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.baidu.qa.jautoit.AutoItX;
import com.baidu.qa.selenium.Selenium2Proxy;
import com.sun.jna.WString;

/**
 * auto operate httpwatch by using selenium webdriver sendkeys method.
 * 
 * @author liangxiaowu
 * 
 */

public class HttpWatchClient2 {
	private static Logger logger = Logger.getLogger(HttpWatchClient2.class.getName());
	private static AutoItX lib = AutoItX.INSTANCE;
	private static String defaultExport2HARWindowsTitle = "HttpWatch - Export";
	private Selenium2Proxy s2p;

	private HttpWatchClient2() {
	}

	public HttpWatchClient2(WebDriver driver) {
		this.s2p = new Selenium2Proxy(driver);
	}

	/**
	 * click the record button on the httpwatch.
	 * 
	 */
	public void clickRecord() {
		s2p.getKeyboard().sendKeys(Keys.CONTROL, Keys.F2);
	}

	/**
	 * when launch IE/FF, start the httpwatch if the httpwatch is installed.
	 */
	public void startHttpWatchOnBrowser() {
		s2p.getKeyboard().sendKeys(Keys.SHIFT, Keys.F2);
	}

	/**
	 * stop httpwatch recording.
	 */
	public void clickStop() {
		s2p.getKeyboard().sendKeys(Keys.CONTROL, Keys.F3);
	}

	/**
	 * clear httpwatch recorded data.
	 */
	public void clickClear() {
		s2p.getKeyboard().sendKeys(Keys.CONTROL, Keys.DELETE);
	}

	/**
	 * click the save button of httpwatch.
	 * 
	 * @param driver
	 */
	public void clickSave() {
		s2p.getKeyboard().sendKeys(Keys.CONTROL, Keys.SHIFT, "S");
	}
    
	/**
	 * click the 'export to har' button of httpwatch.
	 */
	public void export2Har() {
		s2p.getKeyboard().sendKeys(Keys.CONTROL, Keys.SHIFT, "H");
	}

	/**
	 * 
	 * @param harFileName
	 */
	public void exportHttpWatchLog(String harFileName) {
		int i = 0;
		while (i < 3000) {
			if (lib.AU3_WinActive(new WString(defaultExport2HARWindowsTitle), new WString("")) > 0) {
				break;
			} else {
				lib.AU3_WinActivate(new WString(defaultExport2HARWindowsTitle), new WString(""));
				try {
					i++;
					lib.AU3_WinWaitActive(new WString(defaultExport2HARWindowsTitle), new WString(""), 100);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		if (lib.AU3_WinActive(new WString(defaultExport2HARWindowsTitle), new WString("")) > 0) {
			lib.AU3_ControlSend(new WString(defaultExport2HARWindowsTitle), new WString(""), new WString("Edit1"), new WString(""), 1);
			lib.AU3_ControlSend(new WString(defaultExport2HARWindowsTitle), new WString(""), new WString("Edit1"), new WString(harFileName), 1);
			lib.AU3_ControlClick(new WString(defaultExport2HARWindowsTitle), new WString(""), new WString("Button2"), new WString("left"), 1, AutoItX.AU3_INTDEFAULT, AutoItX.AU3_INTDEFAULT);
			logger.info("end httpwatch export to har...");
		} else {
			logger.error("Cannot active HttpWatch export to HAR window in 10 mins.");
		}

	}
}
