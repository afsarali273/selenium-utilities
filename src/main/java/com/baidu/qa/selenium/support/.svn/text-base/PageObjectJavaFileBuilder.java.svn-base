package com.baidu.qa.selenium.support;

import java.util.ArrayList;
import java.util.List;

public class PageObjectJavaFileBuilder {
	public StringBuilder content = new StringBuilder();

	public void buildLineFeed() {
		content.append("\n");
	}

	public void buildPackageDescLine(String packageName) {
		content.append("package " + packageName + ";");
		buildLineFeed();
	}

	public void buildLine(String lineContent) {
		content.append(lineContent);
		buildLineFeed();
	}

	public void buildImportWebElementRef() {
		content.append("import org.openqa.selenium.WebElement;");
		buildLineFeed();

	}

	public void buildImportFindByRef() {
		content.append("import org.openqa.selenium.support.FindBy;");
		buildLineFeed();
	}

	public void buildClassStartDesc(String className) {
		content.append("public class " + className + " {");
		buildLineFeed();
	}

	public void buildClassEndDesc() {
		content.append("}");
	}

	public void buildUIAgentClassField(String how, String using, String fieldName) {
		content.append("@FindBy(" + how + " = \"" + using + "\")");
		buildLineFeed();
		content.append("public WebElement " + fieldName + ";");
		buildLineFeed();
	}

	public void buildUIAgentJavaClass(String packageName, String className, List<PageObjectJavaField> fieldList) {
		buildPackageDescLine(packageName);
		buildImportWebElementRef();
		buildImportFindByRef();
		buildClassStartDesc(className);
		for (PageObjectJavaField field : fieldList) {
			buildUIAgentClassField(field.getHow(), field.getUsing(), field.getFieldName());
		}
		buildClassEndDesc();
	}
}
