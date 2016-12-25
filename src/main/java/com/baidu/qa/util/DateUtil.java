package com.baidu.qa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
	/**
	 * 
	 * @param format
	 *            yyyy-MM-dd-HH-mm-ss
	 * @return
	 */
	public static String formatCurrentDateAsString(String format) {
		Date current = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(current);
	}
}
