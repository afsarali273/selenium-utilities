package com.baidu.qa.os;

/**
 * 
 * @author liangxiaowu
 *
 */
public class Bytes {
	
	/**
	 * 
	 * @param src
	 * @param start_idx
	 * @param end_idx
	 * @return
	 */
	public static String substring(String src, int start_idx, int end_idx) {
		byte[] b = src.getBytes();
		String tgt = "";
		for (int i = start_idx; i <= end_idx; i++) {
			tgt += (char) b[i];
		}
		return tgt;
	}
}