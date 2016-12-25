package com.baidu.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class JavascriptExecutorProxyTest {
	public static void main(String[] args) {
		WebDriver driver = new InternetExplorerDriver();
		driver.navigate().to("http://www.google.com");
		JavascriptExecutorProxy proxy = new JavascriptExecutorProxy(driver);
		proxy.getJe().executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}