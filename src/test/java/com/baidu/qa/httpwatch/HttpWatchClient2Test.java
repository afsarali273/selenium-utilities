package com.baidu.qa.httpwatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.baidu.qa.httpwatch.HttpWatchClient;
import com.baidu.qa.selenium.WebDriverFactory;

public class HttpWatchClient2Test {
	public static void main(String[] args) {
		WebDriverFactory wdf = new WebDriverFactory();
		WebDriver driver = wdf.getIeWebDriver();
		driver.navigate().to("http://www.baidu.com");
		HttpWatchClient2 hwc2 = new HttpWatchClient2(driver);
		hwc2.startHttpWatchOnBrowser();
		hwc2.clickRecord();
		driver.findElement(By.id("kw")).sendKeys("httpwatch");
		driver.findElement(By.id("su")).click();
		hwc2.clickStop();
		hwc2.export2Har();
		hwc2.exportHttpWatchLog("123");
		driver.quit();
	}

}
