package com.baidu.qa.selenium.support.ui;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baidu.qa.common.constants.WaitConstant;
import com.baidu.qa.selenium.UIWebDriver;
import com.baidu.qa.selenium.UIWebElement;

/**
 * webdriver wrapped div, often use this class to get the descendants HTML
 * element to avoid the XPATH usage.
 * 
 * @author liangxiaowu
 * 
 */
public class S2Div {
	private static Logger LOG = Logger.getLogger(S2Div.class.getName());
	private WebDriver commonDriver;
	private UIWebDriver webDriver;

	public S2Div(WebDriver commonDriver) {
		this.commonDriver = commonDriver;
		webDriver = new UIWebDriver(commonDriver, WaitConstant.DEFAULT_SLEEP_TIMEOUT_SECONDS);
	}

	public UIWebElement getDiv(By by) {
		return webDriver.findElement(by);
	}

	public UIWebElement getSubDiv(By... bies) {
		if (bies.length <= 0) {
			return null;
		}
		UIWebElement element = getDiv(bies[0]);
		for (int i = 1; i < bies.length; i++) {
			element = new UIWebElement(element.findElement(bies[i]), commonDriver);
		}
		return element;
	}

	public UIWebElement getSubDiv(WebElement element, By... bies) {
		if (bies.length <= 0) {
			return null;
		}
		for (int i = 0; i < bies.length; i++) {
			element = element.findElement(bies[i]);
		}
		return new UIWebElement(element, commonDriver);
	}

	public UIWebElement getChildWebElement(UIWebElement parent, By by, int index) {
		List<WebElement> wList = parent.findElements(by);
		LOG.info("child list size: " + wList.size() + ", index: " + index);
		LOG.info("parent name: [" + parent.getWappedElement().getAttribute("name") + "]");
		LOG.info("child By: [" + by + "]");
		LOG.debug("parent innerHTML:\n" + parent.getWappedElement().getAttribute("innerHTML"));
		return new UIWebElement(wList.get(index), commonDriver);
	}

	public WebElement getChildWebElement(By parentBy, By childBy, int index) {
		WebElement parent = webDriver.findElement(parentBy);
		List<WebElement> wList = parent.findElements(childBy);
		return new UIWebElement(wList.get(index), commonDriver);
	}
}
