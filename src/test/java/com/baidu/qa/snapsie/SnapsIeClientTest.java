package com.baidu.qa.snapsie;

import org.openqa.selenium.WebDriver;

import com.baidu.qa.selenium.JavascriptExecutorProxy;
import com.baidu.qa.selenium.WebDriverFactory;

public class SnapsIeClientTest {
	public static void main(String[] args) {
		WebDriverFactory wdf = new WebDriverFactory();
		WebDriver driver = wdf.getIeWebDriver();
		JavascriptExecutorProxy jep = new JavascriptExecutorProxy(driver);
		driver.navigate().to("http://www.sohu.com");
		String s = SnapsIeClient.getSaveSnapshotJs("'C:/b.png'");
		System.out.println(s);
		jep.getJe().executeScript(s, "");
		driver.quit();
	}
}
