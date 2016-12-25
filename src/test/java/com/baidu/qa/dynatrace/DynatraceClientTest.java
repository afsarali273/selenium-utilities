package com.baidu.qa.dynatrace;

public class DynatraceClientTest {
	public static void main(String[] args) {
		String dtPath = "C:\\Program Files\\dynaTrace\\dynaTrace AJAX Edition 3.1\\dtajax.exe";
		DynatraceClient client = new DynatraceClient(dtPath);
		client.start();
	}

}
