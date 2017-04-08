package runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.test.Class1;
import com.test.Class2;
import com.test.Class3;
import com.test.Class4;
import com.test.Class5;

import utility.ExcelUtils;

public class demo {
	Multimap<String, String> map;
	String TestName;
	static List<String> methodname;
	static HSSFWorkbook wb;
	static HSSFSheet sheet;
	static HSSFCell cell;
	static HSSFRow row;
	static XmlTest mainTest;
	
	public static void main(String[] args) throws Exception {
		
		//ExcelUtils.setExcelFile("E:\\EclipseTests\\DemoTests\\src\\main\\java\\testdata\\testdata.xls", "suite");
		FileInputStream ExcelFile = new FileInputStream("E:\\EclipseTests\\DemoTests\\src\\main\\java\\testdata\\testdata.xls");
		wb=new HSSFWorkbook(ExcelFile);
		sheet=wb.getSheet("suite");
		int ic=sheet.getLastRowNum();
		
		XmlSuite mainsuite = new XmlSuite();
		mainsuite.setName("SmokeTest Suite");
		mainsuite.setFileName("SmokeTest.xml");
		mainsuite.setParallel("false");
		
		for(int rowIndex=1;rowIndex<=ic;rowIndex++){
			
			//String tcname=sheet.getRow(rowIndex).getCell(0).getStringCellValue();
			String run=sheet.getRow(rowIndex).getCell(1).getStringCellValue();
			
			if(run.contentEquals("Y")){
				
				String tcname=sheet.getRow(rowIndex).getCell(0).getStringCellValue();
				System.out.println("tc name : "+tcname+"  : "+run ); 
				
				XmlTest xmlTest=getTest(tcname, mainsuite);
				
				//mainTest.setXmlClasses(classes);
				//System.out.println("Returned value is : "+demo1.methods(tcname));
			}
		}
		
		TestNG runner=new TestNG();
		List<XmlSuite>suites=new ArrayList<XmlSuite>();
		suites.add(mainsuite);
		runner.setXmlSuites(suites);
		runner.run();

		
	}
	@SuppressWarnings("null")
	public static XmlTest getTest(String TCName,XmlSuite mainsuite) throws Exception {

		XmlClass classlist = null;
		List<XmlInclude>xmlInclude=null;
		XmlTest mainTest=null;
		methodname=null;

		switch (TCName) {
		
		case "Class1":	
			classlist = new XmlClass(Class1.class);
			//XmlTest mainTest;
			mainTest = new XmlTest(mainsuite);
			mainTest.setName(TCName);
			mainTest.setPreserveOrder("True");
			methodname=methods(TCName);	
			for(String a: methodname){
				//xmlInclude.add(new XmlInclude(a));
				System.out.println("method : "+a);
				classlist.getIncludedMethods().add(new XmlInclude(a));
				//classlist.setIncludedMethods(Arrays.asList(new XmlInclude[] { new XmlInclude(a)}));
				
			}		
			break;
			
		case "Class2":
			
			classlist = new XmlClass(Class2.class);
			
			mainTest = new XmlTest(mainsuite);
			mainTest.setName(TCName);
			mainTest.setPreserveOrder("True");
			methodname=methods(TCName);
			
			for(String a: methodname){
				//xmlInclude.add(new XmlInclude(a));
				//classlist.setIncludedMethods(Arrays.asList(new XmlInclude[] { new XmlInclude(a)}));
				classlist.getIncludedMethods().add(new XmlInclude(a));
			}
			//classlist.getIncludedMethods().add(xmlInclude);
			//classlist.setIncludedMethods(xmlInclude);
			break;
			
		case "Class3":
			classlist = new XmlClass(Class3.class);
			mainTest = new XmlTest(mainsuite);
			mainTest.setName(TCName);
			mainTest.setPreserveOrder("True");
			methodname=methods(TCName);
			
			for(String a: methodname){
				//xmlInclude.add(new XmlInclude(a));
				//classlist.setIncludedMethods(Arrays.asList(new XmlInclude[] { new XmlInclude(a)}));
				classlist.getIncludedMethods().add(new XmlInclude(a));
			}
			//classlist.setIncludedMethods(xmlInclude);
			break;
		case "Class4":
			classlist = new XmlClass(Class4.class);
			mainTest = new XmlTest(mainsuite);
			mainTest.setName(TCName);
			mainTest.setPreserveOrder("True");
			methodname=methods(TCName);
			
			for(String a: methodname){
				//classlist.setIncludedMethods(Arrays.asList(new XmlInclude[] { new XmlInclude(a)}));
				classlist.getIncludedMethods().add(new XmlInclude(a));
			}
			//classlist.setIncludedMethods(xmlInclude);
			break;
		case "Class5":
			classlist = new XmlClass(Class5.class);
			mainTest = new XmlTest(mainsuite);
			mainTest.setName(TCName);
			mainTest.setPreserveOrder("True");
			methodname=methods(TCName);
			
			for(String a: methodname){
				
			//classlist.setIncludedMethods(Arrays.asList(new XmlInclude[] { new XmlInclude(a)}));
			classlist.getIncludedMethods().add(new XmlInclude(a));
			}
			//classlist.setIncludedMethods(xmlInclude);
			break;
		}

		List<XmlClass> class_list = new ArrayList<XmlClass>();
		class_list.add(classlist);
		mainTest.setXmlClasses(class_list);
		return mainTest;
	}
	
	public static List<String>methods(String clasName) throws Exception{

		FileInputStream ExcelFile = new FileInputStream("E:\\EclipseTests\\DemoTests\\src\\main\\java\\testdata\\testdata.xls");
		wb=new HSSFWorkbook(ExcelFile);
		sheet=wb.getSheet("test");
		List<String>method=new ArrayList<String>();
		for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			if (row != null) {	
				HSSFCell cell=sheet.getRow(rowIndex).getCell(0);
				if(cell.getStringCellValue().equalsIgnoreCase(clasName) && sheet.getRow(rowIndex).getCell(2).getStringCellValue().contentEquals("Y")){

					String value=sheet.getRow(rowIndex).getCell(1).getStringCellValue();
					 //System.out.println( value);
					method.add(value);
				}
			}
		}
		
		return method;
	}


}
