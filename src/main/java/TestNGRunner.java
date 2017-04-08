package runner;
import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.test.Class1;
import com.test.Class2;
import com.test.Class3;
import com.test.Class4;
import com.test.Class5;

import utility.ExcelUtils;

public class demo {
	String TestName;
	static List<String> methodname;
	static XmlTest mainTest;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile("E:\\EclipseTests\\DemoTests\\src\\main\\java\\testdata\\testdata.xls", "suite");
		int ic=ExcelUtils.getRowUsed();
		XmlSuite mainsuite = new XmlSuite();
		mainsuite.setName("SmokeTest Suite");
		mainsuite.setFileName("SmokeTest.xml");
		mainsuite.setParallel("false");
		mainsuite.addListener("utility.Listeners");

		for(int rowIndex=1;rowIndex<=ic;rowIndex++){

			ExcelUtils.setExcelFile("E:\\EclipseTests\\DemoTests\\src\\main\\java\\testdata\\testdata.xls", "suite");
			String run=ExcelUtils.getCellData(rowIndex, 1);

			if(run.contentEquals("Y")){

				String tcname=ExcelUtils.getCellData(rowIndex, 0);
				System.out.println("tc name : "+tcname+"  : "+run ); 
				getTest(tcname, mainsuite);
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
		XmlTest mainTest=null;
		methodname=null;

		switch (TCName) {

		case "Class1":	
			
			classlist = new XmlClass(Class1.class);
			mainTest=xmltest(mainsuite, TCName);
			for(String a: methods(TCName)){
				classlist.getIncludedMethods().add(new XmlInclude(a));
			}		
			break;

		case "Class2":

			classlist = new XmlClass(Class2.class);
			mainTest=xmltest(mainsuite, TCName);
			for(String a: methods(TCName)){
				classlist.getIncludedMethods().add(new XmlInclude(a));
			}
			break;

		case "Class3":
			classlist = new XmlClass(Class3.class);
			mainTest=xmltest(mainsuite, TCName);
			for(String a: methods(TCName)){
				classlist.getIncludedMethods().add(new XmlInclude(a));
			}
			break;
		case "Class4":
			classlist = new XmlClass(Class4.class);
			mainTest=xmltest(mainsuite, TCName);
			for(String a: methods(TCName)){
				classlist.getIncludedMethods().add(new XmlInclude(a));
			}
			break;
		case "Class5":
			classlist = new XmlClass(Class5.class);
			mainTest = new XmlTest(mainsuite);
			mainTest.setName(TCName);
			mainTest.setPreserveOrder("True");
			methodname=methods(TCName);

			for(String a: methodname){
				classlist.getIncludedMethods().add(new XmlInclude(a));
			}
			break;
		}

		List<XmlClass> class_list = new ArrayList<XmlClass>();
		class_list.add(classlist);
		mainTest.setXmlClasses(class_list);
		return mainTest;
	}

	public static List<String>methods(String clasName) throws Exception{

		ExcelUtils.setExcelFile("E:\\EclipseTests\\DemoTests\\src\\main\\java\\testdata\\testdata.xls", "test");
		int row=ExcelUtils.getRowUsed();
		List<String>method=new ArrayList<String>();
		for (int rowIndex = 1; rowIndex <= row; rowIndex++) {	
			if(ExcelUtils.getCellData(rowIndex, 0).equalsIgnoreCase(clasName) && ExcelUtils.getCellData(rowIndex, 2).contentEquals("Y")){
				String value=ExcelUtils.getCellData(rowIndex, 1);
				method.add(value);
			}
		}

		return method;
	}

	public static XmlTest xmltest(XmlSuite mainsuite ,String TCName){
		XmlTest mainTest=null;
		mainTest = new XmlTest(mainsuite);
		mainTest.setName(TCName);
		mainTest.setPreserveOrder("True");
		return mainTest;
	}
}
