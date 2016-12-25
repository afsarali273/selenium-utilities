package com.baidu.qa.selenium.support.ui;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baidu.qa.common.constants.WaitConstant;
import com.baidu.qa.selenium.UIWebDriver;

/**
 * HTML table element wrapped class.
 * 
 * @author liangxiaowu
 * 
 */
public class S2Table {
	private static Logger LOG = Logger.getLogger(S2Table.class.getName());
	private WebDriver commonDriver;
	private UIWebDriver webDriver;

	public S2Table(WebDriver commonDriver) {
		this.commonDriver = commonDriver;
		webDriver = new UIWebDriver(commonDriver, WaitConstant.DEFAULT_SLEEP_TIMEOUT_SECONDS);
	}

	public int getNumberOfRowsInTable(String tableId) {
		return commonDriver.findElement(By.id(tableId)).findElements(By.tagName("tr")).size();
	}

	public int getNumberOfRowsInTable(By by) {
		return commonDriver.findElement(by).findElements(By.tagName("tr")).size();
	}

	public int getNumberOfColsInTable(By by) {
		List<WebElement> rows = commonDriver.findElement(by).findElements(By.tagName("tr"));
		WebElement row = rows.get(0);
		return row.findElements(By.tagName("td")).size();
	}

	public String getCellText(By by, int rowIndex, int colIndex) {
		List<WebElement> rows = commonDriver.findElement(by).findElements(By.tagName("tr"));
		WebElement row = rows.get(rowIndex);
		List<WebElement> cols = row.findElements(By.tagName("td"));
		WebElement col = cols.get(colIndex);
		return col.getText();
	}

	public String getCellValue(By by, int rowIndex, int colIndex) {
		List<WebElement> rows = commonDriver.findElement(by).findElements(By.tagName("tr"));
		WebElement row = rows.get(rowIndex);
		List<WebElement> cols = row.findElements(By.tagName("td"));
		WebElement col = cols.get(colIndex);
		return col.getAttribute("value");
	}

	public String getCellInnerHTML(By by, int rowIndex, int colIndex) {
		List<WebElement> rows = commonDriver.findElement(by).findElements(By.tagName("tr"));
		WebElement row = rows.get(rowIndex);
		List<WebElement> cols = row.findElements(By.tagName("td"));
		WebElement col = cols.get(colIndex);
		System.out.println("HTML: " + col.getAttribute("innerHTML"));
		return col.getAttribute("innerHTML");
	}

	public int getRowIndexInTable(By by, int colIndex, String query) {
		int result = -1;
		List<WebElement> rows = commonDriver.findElement(by).findElements(By.tagName("tr"));
		int rowIndex = 0;
		for (WebElement row : rows) {
			if (query.equals(row.findElements(By.tagName("td")).get(colIndex).getText())) {
				result = rowIndex;
				break;
			}
			rowIndex++;
		}

		return result;
	}

	public WebElement getCellSubElement(By tableBy, int rowIndex, int colIndex, By cellSubElementBy) {
		List<WebElement> rows = commonDriver.findElement(tableBy).findElements(By.tagName("tr"));
		WebElement row = rows.get(rowIndex);
		List<WebElement> cols = row.findElements(By.tagName("td"));
		return cols.get(colIndex).findElement(cellSubElementBy);
	}

	public void clickCell(By by, int rowIndex, int colIndex) {
		List<WebElement> rows = commonDriver.findElement(by).findElements(By.tagName("tr"));
		WebElement row = rows.get(rowIndex);
		List<WebElement> cols = row.findElements(By.tagName("td"));
		cols.get(colIndex).click();
	}
}
