package com.baidu.qa.selenium.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.baidu.qa.selenium.UIWebDriver;
import com.baidu.qa.selenium.UIWebElement;
import com.baidu.qa.selenium.support.ui.S2Div;

/**
 * 
 * PageObject parent class
 * 
 * @author liangxiaowu
 * 
 */
public class BaseUIPage {
	protected static Logger LOG = Logger.getLogger(BaseUIPage.class.getName());
	protected UIWebDriver webDriver;

	public BaseUIPage(UIWebDriver webDriver) {
		this.webDriver = webDriver;
	}

	/**
	 * 根据id找元素
	 * 
	 * @param id
	 * @return
	 */
	public UIWebElement id(String id) {
		return webDriver.findElement(By.id(id));
	}

	/**
	 * 根据name找元素
	 * 
	 * @param name
	 * @return
	 */
	public UIWebElement name(String name) {
		return webDriver.findElement(By.name(name));
	}

	/**
	 * 根据tagname找元素
	 * 
	 * @param name
	 * @return
	 */
	public UIWebElement tagName(String name) {
		return webDriver.findElement(By.tagName(name));
	}

	/**
	 * 根据xpath找元素
	 * 
	 * @param xpathExpression
	 * @return
	 */
	public UIWebElement xpath(String xpathExpression) {
		return webDriver.findElement(By.xpath(xpathExpression));
	}

	/**
	 * 根据classname找元素
	 * 
	 * @param className
	 * @return
	 */
	public UIWebElement className(String className) {
		return webDriver.findElement(By.className(className));
	}

	/**
	 * 根据cssselector找元素
	 * 
	 * @param selector
	 * @return
	 */
	public UIWebElement cssSelector(String selector) {
		return webDriver.findElement(By.cssSelector(selector));
	}

	/**
	 * 根据linktext找元素
	 * 
	 * @param linkText
	 * @return
	 */
	public UIWebElement linkText(String linkText) {
		return webDriver.findElement(By.linkText(linkText));
	}

	/**
	 * 根据partiallinktext找元素
	 * 
	 * @param linkText
	 * @return
	 */
	public UIWebElement partialLinkText(String linkText) {
		return webDriver.findElement(By.partialLinkText(linkText));
	}

	/**
	 * 第N个儿子节点
	 * 
	 * @param e
	 * @param by
	 * @param index
	 * @return
	 */
	public UIWebElement child(UIWebElement e, By by, int index) {
		S2Div div = new S2Div(webDriver.getCommonDriver());
		return div.getChildWebElement(e, by, index);
	}

	/**
	 * 第一个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child0(UIWebElement e, By by) {
		return this.child(e, by, 0);
	}

	/**
	 * 第二个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child1(UIWebElement e, By by) {
		return this.child(e, by, 1);
	}

	/**
	 * 第三个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child2(UIWebElement e, By by) {
		return this.child(e, by, 2);
	}

	/**
	 * 第四个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child3(UIWebElement e, By by) {
		return this.child(e, by, 3);
	}

	/**
	 * 第五个儿子节点
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement child4(UIWebElement e, By by) {
		return this.child(e, by, 4);
	}
}
