package com.baidu.qa.selenium.support;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PageObjectAutoGenerator {
	private void isPackageExist(String uiAgentJavaFileRootPath, String packagePath) {
		String path = uiAgentJavaFileRootPath + packagePath.replaceAll("\\.", "/");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	private void generateUIAgentJavaFile(String uiAgentJavaFileRootPath, String packagePath, String className, StringBuilder content) {
		String fullFileName = uiAgentJavaFileRootPath + packagePath.replaceAll("\\.", "/") + "/" + className + ".java";
		File file = null;
		FileWriter fw = null;
		try {
			file = new File(fullFileName);
			fw = new FileWriter(file);
			fw.write(content.toString());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static List<PageObjectJavaField> readInputByRow(String path) {
		List<PageObjectJavaField> list = new ArrayList<PageObjectJavaField>();

		File file = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		String line = null;
		try {
			file = new File(path);
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			reader = new BufferedReader(isr);
			while ((line = reader.readLine()) != null && (line.length() > 0)) {
				if (!line.startsWith("#")) {
					String[] fieldArr = line.split(",");
					if (fieldArr.length == 3) {
						PageObjectJavaField field = new PageObjectJavaField();
						field.setFieldName(fieldArr[0]);
						field.setHow(fieldArr[1]);
						field.setUsing(fieldArr[2]);
						list.add(field);
					} else {
						System.out.println("this line(" + line + ") format is not correct");
					}
				} else {
					System.out.println("this line(" + line + ") is not used");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	public void autoGenerateUIAgentJavaFile(String uiAgentTxtFilePath, String generatedJavaFileRootPath) {
		String path = uiAgentTxtFilePath;
		int slashIndex = path.lastIndexOf("/");
		int dotIndex = path.lastIndexOf(".");
		String fullClassName = path.substring(slashIndex + 1, dotIndex);
		int dotIndexInFull = fullClassName.lastIndexOf(".");
		String fullPackageName = fullClassName.substring(0, dotIndexInFull);
		String className = fullClassName.substring(dotIndexInFull + 1, fullClassName.length());
		PageObjectJavaFileBuilder builder = new PageObjectJavaFileBuilder();
		List<PageObjectJavaField> fieldList = readInputByRow(path);
		builder.buildUIAgentJavaClass(fullPackageName, className, fieldList);
		isPackageExist(generatedJavaFileRootPath, fullPackageName);
		generateUIAgentJavaFile(generatedJavaFileRootPath, fullPackageName, className, builder.content);
	}
}
