package com.baidu.qa.camstudio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CamStudioClientTest {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.baidu.com");
		String camStudioFullPath = "C:\\Program Files\\CamStudio\\Recorder.exe";
		CamStudioClient client = new CamStudioClient(camStudioFullPath);
		client.startCamStudio();
		client.clickRecord();
		// client.minimizeWindow();
		driver.findElement(By.id("kw")).sendKeys("123");
		driver.findElement(By.id("su")).click();
		driver.quit();
		client.clickStop();
		client.saveAVIFile("bb.avi");
	}
}