package com.baidu.qa.dynatrace;

import java.io.IOException;

/**
 * auto operate dynatrace tool
 * 
 * @author liangxiaowu
 * 
 */
public class DynatraceClient {
	private String dtPath;

	@SuppressWarnings("unused")
	private DynatraceClient() {
	}

	/**
	 * 
	 * 
	 * @param dynatracePath the dynatrace tool set-up full path,
	 *            e.g.
	 *            "C:\\Program Files\\dynaTrace\\dynaTrace AJAX Edition 3.1\\dtajax.exe"
	 */
	public DynatraceClient(String dynatracePath) {
		this.dtPath = dynatracePath;
	}

	/**
	 * start dynatrace
	 */
	public void start() {
		try {
			Runtime.getRuntime().exec(dtPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
