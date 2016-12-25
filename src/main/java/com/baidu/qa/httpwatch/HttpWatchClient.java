package com.baidu.qa.httpwatch;

import org.apache.log4j.Logger;

import com.baidu.qa.jautoit.AutoItX;
import com.sun.jna.WString;

/**
 * auto operate httpwatch by using autoit, it seems that this method is more
 * stable than by using selenium webdriver sendkeys method.
 * 
 * @author liangxiaowu
 * 
 */

public class HttpWatchClient {
	private static Logger logger = Logger.getLogger(HttpWatchClient.class.getName());
	private static AutoItX lib = AutoItX.INSTANCE;
	private static String defaultExport2HARWindowsTitle = "HttpWatch - Export";

	private HttpWatchClient() {
	}

	/**
	 * lanch httpwatch on browser
	 */
	public static void lanch() {
		logger.info("start lanch httpwatch...");
		lib.AU3_Send(new WString("+{F2}"), 0);
		logger.info("end lanch httpwatch...");

	}

	/**
	 * start record
	 */
	public static void record() {
		logger.info("start httpwatch record...");
		lib.AU3_Send(new WString("^{F2}"), 0);
		logger.info("end httpwatch record...");
	}

	/**
	 * stop record
	 */
	public static void stop() {
		logger.info("start httpwatch stop...");
		lib.AU3_Send(new WString("^{F3}"), 0);
		logger.info("end httpwatch stop...");
	}

	/**
	 * save httpwatch perf data.
	 */
	public static void save() {
		logger.info("start httpwatch save...");
		// TODO
		logger.info("start httpwatch save...");
	}

	/**
	 * clear all httpwatch recored data.
	 */
	public static void clear() {
		logger.info("start httpwatch clear...");
		lib.AU3_Send(new WString("^{Del}"), 0);
		logger.info("end httpwatch clear...");
	}

	public static void export2HAR() {
		// TODO
	}

	public static void export2CSV() {
		// TODO
	}

	public static void export2XML() {
		// TODO
	}

	/**
	 * export httpwatch perf data to har file
	 * 
	 * @param harFileName
	 *            har file name
	 */
	public static void export2HAR(String harFileName) {
		logger.info("start httpwatch export to har...");
		lib.AU3_Send(new WString("^+h"), 0);
		int i = 0;
		while (i < 3000) {
			if (lib.AU3_WinActive(new WString(defaultExport2HARWindowsTitle), new WString("")) > 0) {
				break;
			} else {
				lib.AU3_WinActivate(new WString(defaultExport2HARWindowsTitle), new WString(""));
				try {
					i++;
					lib.AU3_WinWaitActive(new WString(defaultExport2HARWindowsTitle), new WString(""), 100);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		if (lib.AU3_WinActive(new WString(defaultExport2HARWindowsTitle), new WString("")) > 0) {
			lib.AU3_ControlSend(new WString(defaultExport2HARWindowsTitle), new WString(""), new WString("Edit1"), new WString(""), 1);
			lib.AU3_ControlSend(new WString(defaultExport2HARWindowsTitle), new WString(""), new WString("Edit1"), new WString(harFileName), 1);
			lib.AU3_ControlClick(new WString(defaultExport2HARWindowsTitle), new WString(""), new WString("Button2"), new WString("left"), 1, AutoItX.AU3_INTDEFAULT, AutoItX.AU3_INTDEFAULT);
			logger.info("end httpwatch export to har...");
		} else {
			logger.error("Cannot active HttpWatch export to HAR window in 10 mins.");
		}

	}

}
