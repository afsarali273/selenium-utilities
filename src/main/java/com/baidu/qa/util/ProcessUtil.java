package com.baidu.qa.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author liangxiaowu
 * 
 */

public class ProcessUtil {
	public static void killProcess(String processName) {
		try {
			String[] cmd = { "tasklist" };
			Process proc = Runtime.getRuntime().exec(cmd);
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String string_Temp = in.readLine();
			while (string_Temp != null) {
				if (string_Temp.indexOf(processName) != -1) {
					System.out.println("WARNING: will kill proecess " + processName + "...");
					Runtime.getRuntime().exec("Taskkill /IM " + processName);
				}
				string_Temp = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void forceKillProcess(String processName){
		try {
			String[] cmd = { "tasklist" };
			Process proc = Runtime.getRuntime().exec(cmd);
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String string_Temp = in.readLine();
			while (string_Temp != null) {
				if (string_Temp.indexOf(processName) != -1) {
					System.out.println("WARNING: will kill proecess " + processName + "...");
					Runtime.getRuntime().exec("Taskkill /F /IM " + processName);
				}
				string_Temp = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
