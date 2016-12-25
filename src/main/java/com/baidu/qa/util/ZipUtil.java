package com.baidu.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Zip/UnZip files helper class.
 * 
 * @author liangxiaowu
 *
 */
public class ZipUtil {
	public static void unZip(String zipFileName, String outputDirectory) throws IOException {
		ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));
		ZipEntry z;
		while ((z = in.getNextEntry()) != null) {
			System.out.println("unziping " + z.getName());
			if (z.isDirectory()) {
				String name = z.getName();
				name = name.substring(0, name.length() - 1);
				File f = new File(outputDirectory + File.separator + name);
				f.mkdir();
				System.out.println("mkdir " + outputDirectory + File.separator + name);
			} else {
				File f = new File(outputDirectory + File.separator + z.getName());
				f.createNewFile();

				FileOutputStream out;

				out = new FileOutputStream(f);

				int b;

				while ((b = in.read()) != -1)
					out.write(b);

				out.close();
			}
		}

		in.close();

	}

	public static void main(String[] args) throws IOException {
		unZip("e:\\test1\\aa.saz", "e:\\test2");
	}

}
