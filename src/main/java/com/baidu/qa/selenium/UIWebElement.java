package com.baidu.qa.selenium;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsDriver;

import com.baidu.qa.selenium.support.ui.S2Div;

public class UIWebElement implements WebElement, WrapsDriver, Locatable {
	private static Logger LOG = Logger.getLogger(UIWebElement.class.getName());
	private WebElement wrappedElement = null;
	private WebDriver commonDriver = null;

	public UIWebElement(WebElement commonElement, WebDriver commonDriver) {
		if (null == commonElement) {
			throw new IllegalArgumentException("Argument webElement cannot be null.");
		}
		if (!(commonElement instanceof WebElement) || !(commonElement instanceof WrapsDriver) || !(commonElement instanceof Locatable)) {
			throw new IllegalArgumentException("Argument webElement type error.");
		}
		this.wrappedElement = commonElement;
		this.commonDriver = commonDriver;
	}

	public UIWebElement(WebElement commonElement) {
		if (null == commonElement) {
			throw new IllegalArgumentException("Argument webElement cannot be null.");
		}
		if (!(commonElement instanceof WebElement) || !(commonElement instanceof WrapsDriver) || !(commonElement instanceof Locatable)) {
			throw new IllegalArgumentException("Argument webElement type error.");
		}
		this.wrappedElement = commonElement;
	}

	/*
	 * Construct object with web element find by ID.
	 */
	public UIWebElement(UIWebDriver webDriver, String id) {
		this(webDriver.findElement(By.id(id)));
	}

	/*
	 * Construct object with web element find by BY object.
	 */
	public UIWebElement(UIWebDriver webDriver, By by) {
		this(webDriver.findElement(by));
	}

	public Coordinates getCoordinates() {
		return ((Locatable) wrappedElement).getCoordinates();
	}

	// public Point getLocationOnScreenOnceScrolledIntoView() {
	// return ((Locatable)
	// wrappedElement).getLocationOnScreenOnceScrolledIntoView();
	// }

	public WebDriver getWrappedDriver() {
		return ((WrapsDriver) wrappedElement).getWrappedDriver();
	}

	public WebElement getWappedElement() {
		return wrappedElement;
	}

	public void clear() {
		wrappedElement.clear();
	}

	public void click() {
		wrappedElement.click();
	}

	/**
	 * 找到儿子结点
	 */
	public WebElement findElement(By arg0) {
		return wrappedElement.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {
		return wrappedElement.findElements(arg0);
	}

	/**
	 * 得到元素html属性
	 */
	public String getAttribute(String arg0) {
		return wrappedElement.getAttribute(arg0);
	}

	/**
	 * 得到元素的tagname
	 */
	public String getTagName() {
		return wrappedElement.getTagName();
	}

	/**
	 * 得到元素的text
	 */
	public String getText() {
		return wrappedElement.getText();
	}

	/**
	 * 判断元素的text是否包含source字符串
	 * 
	 * @param source
	 * @return
	 */
	public boolean textContains(String source) {
		LOG.debug("UIWebElement text:\n");
		LOG.debug(this.getText());
		return this.getText().contains(source);
	}

	/**
	 * 得到元素的innerHTML
	 * 
	 * @return
	 */
	public String getInnerHTML() {
		return this.getAttribute("innerHTML");
	}

	/**
	 * 判断元素的innerHTML是否包含source字符串
	 * 
	 * @param source
	 * @return
	 */
	public boolean innerHTMLContains(String source) {
		LOG.debug("UIWebElement innerHTML:\n");
		LOG.debug(this.getInnerHTML());
		return this.getInnerHTML().contains(source);
	}

	public boolean isEnabled() {
		return wrappedElement.isEnabled();
	}

	public boolean isSelected() {
		return wrappedElement.isSelected();
	}

	public void sendKeys(CharSequence... arg0) {
		wrappedElement.click(); // to fix selenium bug which cannot sendkeys
								// stalely on IE
		wrappedElement.sendKeys(arg0);
	}

	public boolean isDisplayed() {
		return wrappedElement.isDisplayed();
	}

	public Point getLocation() {
		return wrappedElement.getLocation();
	}

	public Dimension getSize() {
		return wrappedElement.getSize();
	}

	public String getCssValue(String propertyName) {
		return wrappedElement.getCssValue(propertyName);
	}

	public void submit() {
		wrappedElement.submit();
	}

	/**
	 * 第N个儿子节点
	 * 
	 * @param by
	 * @param index
	 * @return
	 */
	public UIWebElement child(By by, int index) {
		S2Div div = new S2Div(commonDriver);
		return div.getChildWebElement(this, by, index);
	}

	/**
	 * 第一个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child0(By by) {
		return this.child(by, 0);
	}

	/**
	 * 第二个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child1(By by) {
		return this.child(by, 1);
	}

	/**
	 * 第三个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child2(By by) {
		return this.child(by, 2);
	}

	/**
	 * 第四个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child3(By by) {
		return this.child(by, 3);
	}

	/**
	 * 第五个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child4(By by) {
		return this.child(by, 4);
	}

	/**
	 * 根据tag找到第一个儿子结点
	 * 
	 * @param tagName
	 * @return
	 */
	public UIWebElement child0ByTag(String tagName) {
		return this.child(By.tagName(tagName), 0);
	}

	/**
	 * 根据tag找到第N个儿子结点
	 * 
	 * @param tagName
	 * @param index
	 * @return
	 */
	public UIWebElement childByTag(String tagName, int index) {
		return this.child(By.tagName(tagName), index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commonDriver == null) ? 0 : commonDriver.hashCode());
		result = prime * result + ((wrappedElement == null) ? 0 : wrappedElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UIWebElement other = (UIWebElement) obj;
		if (wrappedElement == null) {
			if (other.wrappedElement != null)
				return false;
		} else if (!wrappedElement.equals(other.wrappedElement))
			return false;
		return true;
	}
}
