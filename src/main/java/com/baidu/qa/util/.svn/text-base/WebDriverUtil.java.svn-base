package com.baidu.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

public class WebDriverUtil {
	public static boolean isWebElementVisible(WebElement we) {
		return we.isDisplayed();
	}

	public static boolean isWebElementExist(WebDriver driver, By by) {
		try {
			driver.findElement(by);
		} catch (NoSuchElementException ex) {
			return false;
		}
		return true;
	}

	public static Function<WebDriver, WebElement> presenceOfElementLocated(final By locator) {
		return new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		};
	}

	public static Function<WebDriver, WebElement> presenceOfElementLocated(final WebElement element) {
		return new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return element;
			}
		};
	}
}
