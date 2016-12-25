package com.baidu.qa.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baidu.qa.common.constants.WaitConstant;

/**
 * custom web driver which extends web driver's functions
 * 
 * @author liangxiaowu
 * 
 */
public class UIWebDriver extends WebDriverWait {
	private static Logger LOG = Logger.getLogger(UIWebDriver.class.getName());
	private WebDriver commonDriver;

	public UIWebDriver(WebDriver commonDriver, long timeOutInSeconds) {
		super(commonDriver, timeOutInSeconds);
		this.commonDriver = commonDriver;
	}

	public UIWebDriver(WebDriver commonDriver, long timeOutInSeconds, long sleepInMillis) {
		super(commonDriver, timeOutInSeconds, sleepInMillis);
		this.commonDriver = commonDriver;
	}

	public WebDriver getCommonDriver() {
		return this.commonDriver;
	}

	// wait half second
	public void waitHalfSec() {
		try {
			Thread.sleep(WaitConstant.DEFAULT_SLEEP_TIMEOUT_SECONDS);
		} catch (Throwable t) {
			LOG.error("Thread sleep Exception: " + t.getMessage());
			return;
		}
	}

	// wait 1 second
	public void wait1Sec() {
		try {
			Thread.sleep(WaitConstant.ONE_SECOND);
		} catch (Throwable t) {
			LOG.error("Thread sleep Exception: " + t.getMessage());
			return;
		}
	}

	// wait 2 second
	public void wait2Sec() {
		try {
			Thread.sleep(WaitConstant.TWO_SECONDS);
		} catch (Throwable t) {
			LOG.error("Thread sleep Exception: " + t.getMessage());
			return;
		}
	}

	// wait 3 second
	public void wait3Sec() {
		try {
			Thread.sleep(WaitConstant.THREE_SECONDS);
		} catch (Throwable t) {
			LOG.error("Thread sleep Exception: " + t.getMessage());
			return;
		}
	}

	// wait 5 second
	public void wait5Sec() {
		try {
			Thread.sleep(WaitConstant.FIVE_SECONDS);
		} catch (Throwable t) {
			LOG.error("Thread sleep Exception: " + t.getMessage());
			return;
		}
	}

	// wait 10 second
	public void wait10Sec() {
		try {
			Thread.sleep(WaitConstant.TEN_SECONDS);
		} catch (Throwable t) {
			LOG.error("Thread sleep Exception: " + t.getMessage());
			return;
		}
	}

	// wait * second
	public void wait(int thresholdSec) {
		try {
			Thread.sleep(thresholdSec * WaitConstant.ONE_SECOND);
		} catch (Throwable t) {
			LOG.error("Thread sleep Exception: " + t.getMessage());
			return;
		}
	}

	/**
	 * override webdriver's findElement method.
	 * 
	 * @param by
	 * @param timeoutSecond
	 * @param intervalSecond
	 * @return
	 */
	public UIWebElement findElement(By by, long timeoutSecond, long intervalSecond) {
		long start = System.currentTimeMillis();
		int i = 0;
		while (true) {
			try {
				LOG.info("trying to find element [" + by + "] at " + (i + 1) + " time...");
				WebElement commonElement = this.commonDriver.findElement(by);
				if (commonElement != null) {
					int k = 0;
					boolean isDisplayed = commonElement.isDisplayed();
					while ((!isDisplayed) && (System.currentTimeMillis() - start < timeoutSecond * 1000)) {
						try {
							synchronized (this) {
								wait(intervalSecond * 1000);
								k++;
								isDisplayed = commonElement.isDisplayed();
							}
						} catch (InterruptedException e) {
							LOG.error("InterruptedException: " + e.getMessage());
							return null;
						}
					}
					if (isDisplayed) {
						LOG.info("trying to wait element [" + by + "] displayed at " + (k + 1) + " time...");
						return new UIWebElement(commonElement, commonDriver);
					} else {
						LOG.fatal("WaitElementDisplayedException.... cannot wait element [" + by + "] displayed in " + timeoutSecond + " seconds.");
						throw new Error("Timeout reached and element [" + by + "] cannot wait displayed in " + timeoutSecond + " seconds.");
					}
				}
			} catch (NoSuchElementException nse) {
				if (System.currentTimeMillis() - start >= timeoutSecond * 1000) {
					LOG.fatal("NoSuchElementException.... cannot find element [" + by + "] in " + timeoutSecond + " seconds.");
					throw new Error("Timeout reached and element [" + by + "] not found in " + timeoutSecond + " seconds.");
				} else {
					try {
						synchronized (this) {
							wait(intervalSecond * 1000);
							i++;
						}
					} catch (InterruptedException e) {
						LOG.error("InterruptedException: " + e.getMessage());
						return null;
					}
				}
			} catch (StaleElementReferenceException sre) {
				if (System.currentTimeMillis() - start >= timeoutSecond * 1000) {
					LOG.fatal("StaleElementReferenceException.... cannot find element [" + by + "] in " + timeoutSecond + " seconds.");
					throw new Error("Timeout reached and element [" + by + "] not found in " + timeoutSecond + " seconds.");
				} else {
					try {
						synchronized (this) {
							wait(intervalSecond * 1000);
							i++;
						}
					} catch (InterruptedException e) {
						LOG.error("InterruptedException: " + e.getMessage());
						return null;
					}
				}
			} catch (Exception e) {
				LOG.error("OtherException in UIWebDriver findElement: " + e.toString());
				return null;
			}
		}
	}

	/**
	 * 
	 * @param by
	 * @param timeoutSecond
	 * @param intervalSecond
	 */
	public void findElementNotExist(By by, long timeoutSecond, long intervalSecond) {
		long start = System.currentTimeMillis();
		int i = 0;
		while (System.currentTimeMillis() - start < timeoutSecond * 1000) {
			try {
				try {
					synchronized (this) {
						wait(intervalSecond * 1000);
					}
				} catch (InterruptedException e) {
					LOG.error("Thread sleep Exception: " + e.getMessage());
					return;
				}
				i++;
				LOG.info("trying to find element [" + by + "] at " + i + " time...");
				this.commonDriver.findElement(by);
			} catch (NoSuchElementException nse) {
				LOG.info("element [" + by + "] is missing at " + i + " time, in " + timeoutSecond + "seconds.");
				break;
			}
		}

		if (System.currentTimeMillis() - start >= timeoutSecond * 1000) {
			LOG.fatal("element [" + by + "] not missing in " + timeoutSecond + " seconds.");
			throw new Error("element [" + by + "] not missing in " + timeoutSecond + " seconds.");
		}
	}

	/**
	 * find element in 3 minutes.
	 * 
	 * @param by
	 * @return
	 */
	public UIWebElement findElement(By by) {
		return this.findElement(by, 180, 1);
	}

	/**
	 * wait the element is visible in 3 minutes.
	 * 
	 * @param by
	 */
	public void ajaxWait(By by) {
		this.findElement(by, 180, 1);
	}

	/**
	 * wait the element is not visible in 3 minutes.
	 * 
	 * @param by
	 */
	public void ajaxWaitNotExist(By by) {
		this.findElementNotExist(by, 180, 1);
	}

	// public List<UIWebElement> findElements(By by, long timeoutSecond, long
	// intervalSecond) {
	// long start = System.currentTimeMillis();
	// int i = 0;
	// while (true) {
	// try {
	// logger.info("trying to find element [" + by + "] at " + i + " time...");
	// return this.driver.findElements(by);
	// } catch (NoSuchElementException nse) {
	// if (System.currentTimeMillis() - start >= timeoutSecond * 1000) {
	// logger.fatal("NoSuchElementException.... cannot found element[" + by +
	// "] in " + timeoutSecond + " seconds.");
	// throw new Error("Timeout reached and element [" + by + "] not found in "
	// + timeoutSecond + " seconds.");
	// } else {
	// try {
	// synchronized (this) {
	// wait(intervalSecond * 1000);
	// i++;
	// }
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }
	// }

	// /**
	// *
	// * @param by
	// * @return
	// */
	// public List<UIWebElement> findElements(By by) {
	// return this.findElements(by, 180, 1);
	// }
}
