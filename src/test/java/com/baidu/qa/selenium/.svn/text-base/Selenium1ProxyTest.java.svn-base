package com.baidu.qa.selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Selenium1ProxyTest {
	public static void main(String[] args) {
		WebDriver driver = new InternetExplorerDriver();
		// driver.navigate().to("www.baidu.com");
		Selenium1Proxy s1Proxy = new Selenium1Proxy(driver, "http://www.baidu.com");
		driver.navigate().to("http://www.baidu.com");
		// s1Proxy.start();
		File image = new File("e:\\xxx.png");
		s1Proxy.getSelenium1();
		// s1Proxy.captureScreenshot().renameTo(image);
		driver.findElement(By.id("kw")).sendKeys("selenium");
	}
}
