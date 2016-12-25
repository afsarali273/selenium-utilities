package com.baidu.qa.selenium.condition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * 
 * @author liangxiaowu
 * 
 */
public class ElementPresent implements ExpectedCondition<Boolean> {
	private By findCondition;

	public ElementPresent(By by) {
		this.findCondition = by;
	}

	public Boolean apply(WebDriver driver) {
		driver.findElement(this.findCondition);
		return Boolean.valueOf(true);
	}
}
