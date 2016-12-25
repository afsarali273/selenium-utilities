package com.baidu.qa.selenium;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * specific webdriver listener, when the exception happen, capture the screen.
 * 
 * @author liangxiaowu
 * 
 */
public class UIOperationEventListener implements WebDriverEventListener {
	private static Logger LOG = Logger.getLogger(UIOperationEventListener.class.getName());
	private final static String IMAGE_STORE_PATH = System.getProperty("user.dir").substring(0, 1) + ":/software/java_lib/hudson_home/workspace/report/failimage";

	static {
		File file = new File(IMAGE_STORE_PATH);
		if (!(file.exists()) && !(file.isDirectory())) {
			file.mkdirs();
		}
	}

	private String generateRandomFileName(Throwable arg0) {
		String fileName = null;
		try {
			fileName = arg0.getMessage();
			int i = fileName.indexOf('\n');
			fileName = fileName.substring(0, i).replaceAll("\\s", "_").replaceAll(":", "").replaceAll("\"", "_") + ".jpg";
			Calendar c = Calendar.getInstance();
			fileName = "" + c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH) + "-" + c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE) + "-"
					+ c.get(Calendar.SECOND) + "-" + fileName;
			if (fileName.length() > 100) {
				fileName = fileName.substring(0, 100);
			}
		} catch (Exception e) {
			LOG.error("generateRandomFileName Exception: " + e.getMessage());
		}
		return fileName;
	}

	public void createScreenCaptureJPEG(String filename) {
		try {
			BufferedImage img = getScreenAsBufferedImage();
			File output = new File(IMAGE_STORE_PATH + "\\" + filename);
			ImageIO.write(img, "jpg", output);
		} catch (IOException e) {
			LOG.error("createScreenCaptureJPEG IOException: " + e.getMessage());
		}
	}

	private BufferedImage getScreenAsBufferedImage() {
		BufferedImage img = null;
		try {
			Robot r;
			r = new Robot();
			Toolkit t = Toolkit.getDefaultToolkit();
			Rectangle rect = new Rectangle(t.getScreenSize());
			img = r.createScreenCapture(rect);
		} catch (AWTException e) {
			LOG.error("getScreenAsBufferedImage AWTException: " + e.getMessage());
		}
		return img;
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		String filename = generateRandomFileName(arg0);
		createScreenCaptureJPEG(filename);
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}
}
