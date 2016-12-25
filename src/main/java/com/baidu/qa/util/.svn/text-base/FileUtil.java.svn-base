package com.baidu.qa.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
	public static File getLatestModifiedTimeFile(String directoryPath, String fileSuffix) {
		File file = null;
		try {
			File root = new File(directoryPath);
			File[] filesOrDirs = root.listFiles();
			File f = null;
			long modify = 0;
			int result = 0;
			// maybe has a bug
			for (int i = 0; i < filesOrDirs.length; i++) {
				f = filesOrDirs[i];

				if (f.isFile() && f.getName().contains(fileSuffix)) {
					if (f.lastModified() > modify) {
						modify = f.lastModified();
						result = i;
					}
				}
			}

			file = filesOrDirs[result];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	public static String getLatestModifiedTimeFileName(String directoryPath, String fileSuffix) {
		String fileName = null;
		try {
			File root = new File(directoryPath);
			File[] filesOrDirs = root.listFiles();
			File f = null;
			long modify = 0;
			int result = 0;
			// maybe has a bug
			for (int i = 0; i < filesOrDirs.length; i++) {
				f = filesOrDirs[i];

				if (f.isFile() && f.getName().contains(fileSuffix)) {
					if (f.lastModified() > modify) {
						modify = f.lastModified();
						result = i;
					}
				}
			}

			fileName = filesOrDirs[result].getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	public static String readFile(String path) {
		StringBuilder sb = new StringBuilder();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));

			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				System.out.println(i++);
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

	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { 
				InputStream inStream = new FileInputStream(oldPath); 
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; 
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
