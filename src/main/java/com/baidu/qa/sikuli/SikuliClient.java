package com.baidu.qa.sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

/**
 * Use Sikuli as a tool to do flash operation. 
 *
 * @author liangxiaowu
 * 
 */
public class SikuliClient {
	public static Screen screen;

	public SikuliClient() {
		screen = new Screen();
	}

	public boolean screenWaitAndClick(String regionImagePath, int timeOut) {
		boolean result = false;

		try {
			screen.exists(regionImagePath, timeOut);
			screen.click(regionImagePath, 0);
			result = true;
		} catch (FindFailed e) {
			result = false;
			e.printStackTrace();
		}

		return result;
	}

	public boolean screenPageDownUntillVisible(String region, int pageDownCountOut) {
		boolean result = false;
		try {
			for (int second = 0;; second++) {
				if (second > pageDownCountOut) {
					result = false;
					break;
				}
				try {
					if (screen.exists(region) != null) {
						result = true;
						break;
					}
				} catch (Exception e) {
				}
				screen.type(null, '\ue005' + "", 0);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
