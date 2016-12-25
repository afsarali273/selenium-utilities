package com.baidu.qa.selenium.html5;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * WebTimings is a new feature of HTML5, now support Chrome, IE 9 and FF XX
 * version. More info, you can find it from
 * https://dvcs.w3.org/hg/webperf/raw-file
 * /tip/specs/NavigationTiming/Overview.html
 * 
 * @author liangxiaowu
 * 
 */
public class WebTimingsCilent {
	private WebDriver driver;
	private JavascriptExecutor je;

	private WebTimingsCilent() {
	}

	public WebTimingsCilent(WebDriver driver) {
		this.driver = driver;
		this.je = (JavascriptExecutor) this.driver;
	}

	/**
	 * navigationStart time
	 * 
	 * @return
	 */
	public Long getNavigationStart() {
		return (Long) je.executeScript("return window.performance.timing.navigationStart");
	}

	/**
	 * unloadEventStart time
	 * 
	 * @return
	 */
	public Long getUnloadEventStart() {
		return (Long) je.executeScript("return window.performance.timing.unloadEventStart");
	}

	/**
	 * unloadEventEnd time
	 * 
	 * @return
	 */
	public Long getUnloadEventEnd() {
		return (Long) je.executeScript("return window.performance.timing.unloadEventEnd");
	}

	/**
	 * redirectStart time
	 * 
	 * @return
	 */
	public Long getRedirectStart() {
		return (Long) je.executeScript("return window.performance.timing.redirectStart");
	}

	/**
	 * redirectEnd time
	 * 
	 * @return
	 */
	public Long getRedirectEnd() {
		return (Long) je.executeScript("return window.performance.timing.redirectEnd");
	}

	/**
	 * fetchStart time
	 * 
	 * @return
	 */
	public Long getFetchStart() {
		return (Long) je.executeScript("return window.performance.timing.fetchStart");
	}

	/**
	 * domainLookupStart time
	 * 
	 * @return
	 */
	public Long getDomainLookupStart() {
		return (Long) je.executeScript("return window.performance.timing.domainLookupStart");
	}

	/**
	 * domainLookupEnd time
	 * 
	 * @return
	 */
	public Long getDomainLookupEnd() {
		return (Long) je.executeScript("return window.performance.timing.domainLookupEnd");
	}

	/**
	 * connectStart time
	 * 
	 * @return
	 */
	public Long getConnectStart() {
		return (Long) je.executeScript("return window.performance.timing.connectStart");
	}

	/**
	 * connectEnd time
	 * 
	 * @return
	 */
	public Long getConnectEnd() {
		return (Long) je.executeScript("return window.performance.timing.connectEnd");
	}

	/**
	 * secureConnectionStart time
	 * 
	 * @return
	 */
	public Long getSecureConnectionStart() {
		return (Long) je.executeScript("return window.performance.timing.secureConnectionStart");
	}

	/**
	 * requesetStart time
	 * 
	 * @return
	 */
	public Long getRequestStart() {
		return (Long) je.executeScript("return window.performance.timing.requestStart");
	}

	/**
	 * responseStart time
	 * 
	 * @return
	 */
	public Long getResponseStart() {
		return (Long) je.executeScript("return window.performance.timing.responseStart");
	}

	/**
	 * responseEnd time
	 * 
	 * @return
	 */
	public Long getResponseEnd() {
		return (Long) je.executeScript("return window.performance.timing.responseEnd");
	}

	/**
	 * domLoading time
	 * 
	 * @return
	 */
	public Long getDomLoading() {
		return (Long) je.executeScript("return window.performance.timing.domLoading");
	}

	/**
	 * domInteractive time
	 * 
	 * @return
	 */
	public Long getDomInteractive() {
		return (Long) je.executeScript("return window.performance.timing.domInteractive");
	}

	/**
	 * domContentLoadedEventStart time
	 * 
	 * @return
	 */
	public Long getDomContentLoadedEventStart() {
		return (Long) je.executeScript("return window.performance.timing.domContentLoadedEventStart");
	}

	/**
	 * domCotentLoadedEventEnd time
	 * 
	 * @return
	 */
	public Long getDomContentLoadedEventEnd() {
		return (Long) je.executeScript("return window.performance.timing.domContentLoadedEventEnd");
	}

	/**
	 * domComplete time
	 * 
	 * @return
	 */
	public Long getDomComplete() {
		return (Long) je.executeScript("return window.performance.timing.domComplete");
	}

	/**
	 * loadEventStart time
	 * 
	 * @return
	 */
	public Long getLoadEventStart() {
		return (Long) je.executeScript("return window.performance.timing.loadEventStart");
	}

	/**
	 * loadEventEnd time
	 * 
	 * @return
	 */
	public Long getLoadEventEnd() {
		return (Long) je.executeScript("return window.performance.timing.loadEventEnd");
	}
}
