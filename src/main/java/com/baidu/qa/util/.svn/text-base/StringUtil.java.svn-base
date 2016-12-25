package com.baidu.qa.util;

import java.io.ByteArrayOutputStream;

public final class StringUtil {
	public static String byteArrayToString(byte[] aByteArray) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int byteCounter = 0;
		while (byteCounter < aByteArray.length && aByteArray[byteCounter] != 0) {
			baos.write(aByteArray[byteCounter++]);
		}
		return baos.toString();
	}

	public static String formatUrl2WindowsFileName(String url) {
		String result = null;
		System.out.println(url);
		result = url.replaceAll("://", ".");
		System.out.println(result);
		result = url.replaceAll(":", ".");
		System.out.println(result);
		result = result.replaceAll("/", ".");
		System.out.println(result);
		result = result.replaceAll("\\?", ".");
		System.out.println(result);
		return result;
	}
}
