package com.baidu.qa.fiddler;

import java.io.IOException;

/**
 * auto operate fiddler tool
 * 
 * @author liangxiaowu
 * 
 */
public class FiddlerClient {
	private String fiddlerFullPath;

	/**
	 * default constructor
	 */
	public FiddlerClient() {
	}

	/**
	 * constructor
	 * 
	 * @param fiddlerFullPath
	 *            fiddler full path
	 */
	public FiddlerClient(String fiddlerFullPath) {
		this.fiddlerFullPath = fiddlerFullPath;
	}

	/**
	 * start fiddler
	 * 
	 * @param fiddlerFullPath
	 *            fiddler full path
	 */
	public static void startFiddler(String fiddlerFullPath) {
		try {
			Runtime.getRuntime().exec(fiddlerFullPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * set fiddler full path
	 * 
	 * @param fiddlerFullPath
	 *            the fiddlerFullPath to set
	 */
	public void setFiddlerFullPath(String fiddlerFullPath) {
		this.fiddlerFullPath = fiddlerFullPath;
	}

	/**
	 * getter of fiddler full path
	 * 
	 * @return the fiddlerFullPath
	 */
	public String getFiddlerFullPath() {
		return fiddlerFullPath;
	}
}
