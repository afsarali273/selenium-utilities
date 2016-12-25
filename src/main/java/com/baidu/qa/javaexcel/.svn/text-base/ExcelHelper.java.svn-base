package com.baidu.qa.javaexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	private static Logger LOG = Logger.getLogger(ExcelHelper.class.getName());

	public static void read(String filePath) {
		ExcelHelper.read(filePath, 0);
	}

	public static List<String> readLine(String filePath, int sheetIndex, int lineIndex) {
		XSSFWorkbook xwb = null;
		try {
			xwb = new XSSFWorkbook(new FileInputStream(filePath));
		} catch (IOException e) {
			LOG.error("read Excel file from " + filePath + " IOException: " + e.getMessage());
			return null;
		}
		try {
			XSSFSheet sheet = null;
			sheet = xwb.getSheetAt(sheetIndex);
			XSSFRow row = null;
			String cell = null;
			row = sheet.getRow(lineIndex);
			List<String> result = new ArrayList<String>();
			for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
				cell = row.getCell(j).toString();
				LOG.info("readLine cell[" + lineIndex + ", " + j + "]: " + cell);
				result.add(cell);
			}
			return result;
		} catch (Exception e) {
			LOG.error("readLine Exception: " + e.getMessage());
			return null;
		}
	}

	public static void read(String filePath, int sheetIndex) {
		XSSFWorkbook xwb = null;
		try {
			xwb = new XSSFWorkbook(new FileInputStream(filePath));
		} catch (IOException e) {
			LOG.error("read Excel file from " + filePath + " IOException: " + e.getMessage());
			return;
		}
		// 读取第一章表格内容
		XSSFSheet sheet = null;
		sheet = xwb.getSheetAt(sheetIndex);
		// 定义 row、cell
		XSSFRow row = null;
		String cell = null;
		// 循环输出表格中的内容
		for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
				// 通过 row.getCell(j).toString() 获取单元格内容，
				cell = row.getCell(j).toString();
				System.out.print(cell + "\t");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) throws Exception {
		String filePath = "c:\\com.dajie.web.index.xlsx";
		// ExcelHelper.read("c:\\com.dajie.web.index.xlsx");
		List<String> l = ExcelHelper.readLine(filePath, 0, 0);
		for (String s : l) {
			System.out.println(s);
		}
	}
}
