package com.baidu.qa.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LocalFileUtil {
	// no try catch
	public static void copyFile(File srcFile, String destFileFullPath) {
		File dest = new File(destFileFullPath);
		srcFile.renameTo(dest);
	}
	
	public static String readFile(String path) {
		StringBuilder sb = new StringBuilder();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));

			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

}
