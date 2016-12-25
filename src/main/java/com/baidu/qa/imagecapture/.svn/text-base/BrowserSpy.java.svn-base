package com.baidu.qa.imagecapture;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.baidu.qa.snapsie.SnapsIeClient;
import com.baidu.qa.util.LocalFileUtil;
import com.thoughtworks.selenium.Selenium;

public class BrowserSpy extends RemoteWebDriver implements TakesScreenshot {
	private static Logger LOG = Logger.getLogger(BrowserSpy.class.getName());
	private WebDriver driver;

	/**
	 * Hide default constructor
	 */
	private BrowserSpy() {
	}

	/**
	 * Construct BrowserSpy with WebDriver
	 * 
	 * @param aDriver
	 */
	public BrowserSpy(WebDriver aDriver) {
		this.setDriver(aDriver);
	}

	/**
	 * Construct BrowserSpy with RemoteWebDriver
	 * 
	 * @param remoteAddress
	 * @param desiredCapabilities
	 */
	public BrowserSpy(URL remoteAddress, Capabilities desiredCapabilities) {
		super(remoteAddress, desiredCapabilities);
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		if ((Boolean) getCapabilities().getCapability(CapabilityType.TAKES_SCREENSHOT)) {
			String base64Str = execute(DriverCommand.SCREENSHOT).getValue().toString();
			return target.convertFromBase64Png(base64Str);
		}
		return null;
	}

	/**
	 * 利用WebDriver抓图
	 * 
	 * @param destFileFullPath
	 *            local dest file full path
	 * 
	 * @return
	 */
	public boolean takeWebDriverSnapshotOfThePage(String destFileFullPath) {
		boolean result = false;
		try {
			if (driver instanceof InternetExplorerDriver) {
				// call SnapsIEClient
				JavascriptExecutor je = (JavascriptExecutor) driver;
				String script = SnapsIeClient.getSaveSnapshotJs2(destFileFullPath);
				je.executeScript(script);
			} else {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				LocalFileUtil.copyFile(scrFile, destFileFullPath);
			}
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * 利用RemoteWebDriver抓图
	 * 
	 * @param destFileFullPath
	 *            local dest file full path
	 * 
	 * @return
	 */
	public boolean takeRemoteWebDriverSnapshotOfThePage(String destFileFullPath) {
		boolean result = false;
		try {
			File scrFile = this.getScreenshotAs(OutputType.FILE);
			LocalFileUtil.copyFile(scrFile, destFileFullPath);
			result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 使用Robot抓取屏幕全图
	 * 
	 * @param fileName 保存的图像文件名，如C:\fileName1
	 * @param imageSuffix 保存的图像文件后缀，如png
	 */
	public void captureScreenWithRobot(String fileName, String imageSuffix) {
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (AWTException e) {
			e.printStackTrace();
		}

		// save image as imageSuffix format
		File file = new File(fileName + "." + imageSuffix);
		try {
			ImageIO.write(image, imageSuffix, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用Robot抓取某一范围的屏幕
	 *
	 * @param fileName 保存的图像文件名，如C:\fileName1
	 * @param imageSuffix 保存的图像文件后缀，如png
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void captureScreenWithRobot(String fileName, String imageSuffix, int x, int y, int width, int height) {
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(new Rectangle(x, y, width, height)));
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// save image as imageSuffix format
		File file = new File(fileName + "." + imageSuffix);
		try {
			ImageIO.write(image, imageSuffix, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 利用WebDriver抓取某一个WebElement的图像
	 * 
	 * @param webDriver
	 * @param element
	 * @param targetPath
	 */
	public void captureImage(WebDriver webDriver, WebElement element, String targetPath) {
		Point point = element.getLocation();
		Dimension dimension = element.getSize();

		TakesScreenshot ts = (TakesScreenshot) webDriver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			crop(targetPath, file, point, dimension);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the snapshot of web page with RemoteWebDriver
	 * 
	 * @return
	 */
	public File getRemoteWebDriverSnapsshotOfThePage() {
		return this.getScreenshotAs(OutputType.FILE);
	}

	public String get() {
		return this.getScreenshotAs(OutputType.BASE64);
	}

	/**
	 * Get the snapshot of web page with WebDriver
	 * 
	 * @return
	 */
	public File getWebDriverSnapsshotOfThePage() {
		// TODO
		return null;
	}

	/**
	 * Get the runtime java code stack info, such as class name, method name and
	 * other info.
	 * 
	 * @param addonInfo
	 * @return
	 */
	public String getTraceInfo(String addonInfo) {
		StringBuffer sb = new StringBuffer();
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		if (addonInfo != null && addonInfo.length() > 0) {
			sb.append(stacks[1].getClassName()).append("_").append(stacks[1].getMethodName()).append("_").append(stacks[1].getLineNumber()).append("_").append(addonInfo).append("_");
		}
		return sb.toString();
	}

	/**
	 * Get the local machine host name.
	 * 
	 * @return
	 */
	public String getLocalHostName() {
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ia.getHostName();

	}

	/**
	 * Get the local machine IP address.
	 * 
	 * @return
	 */
	public String getLocalHostAddress() {
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ia.getHostAddress();

	}

	/**
	 * When use selenium open web page, use this method to max browser window
	 * for capturing screen.
	 */
	public void windowMaximize() {
		Selenium selenium1 = new WebDriverBackedSelenium(this, "");
		selenium1.windowMaximize();
	}

	public void hidden() {
		// document.documentElement
		// document.body.style.overflow = "auto"
		((JavascriptExecutor) this).executeScript("document.body.style.overflow = \"hidden\";");
		// ((JavascriptExecutor)
		// this).executeScript("document.getElementsByTagName('body')[0].style.overflowY='hidden';");
	}

	/**
	 * 按键盘F11键
	 */
	public void clickF11() {
		((HasInputDevices) this).getKeyboard().sendKeys(Keys.F11);
	}
    
	/**
	 * 剪裁图片
	 * 
	 * @param targetPath
	 * @param src
	 * @param point
	 * @param dimension
	 * @throws IOException
	 */
	private void crop(String targetPath, File src, Point point,
			Dimension dimension) throws IOException {

		FileInputStream is = null;
		ImageInputStream iis = null;

		try {
			// 读取图片文件
			is = new FileInputStream(src);

			/*
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
			 * 参数：formatName - 包含非正式格式名称 .（例如 "jpeg" 或 "tiff"）等 。
			 */
			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName("png");
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);

			/*
			 * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
			reader.setInput(iis, true);

			/*
			 * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
			 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
			 */
			ImageReadParam param = reader.getDefaultReadParam();

			/*
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
			Rectangle rect = new Rectangle(point.x, point.y, dimension.width,
					dimension.height);

			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);

			/*
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
			 * BufferedImage 返回。
			 */
			BufferedImage bi = reader.read(0, param);

			// 保存新图片
			ImageIO.write(bi, "png", new File(targetPath));
		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}

	}
}

