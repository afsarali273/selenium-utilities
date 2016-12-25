package com.baidu.qa.camstudio;

import java.io.IOException;

import com.baidu.qa.jautoit.AutoItX;
import com.sun.jna.WString;

/**
 * Use the open source tool - CamStudio as a tool to record movie.
 * 
 * @author liangxiaowu
 * 
 */
public class CamStudioClient {
	private static AutoItX lib = AutoItX.INSTANCE;
	private String camStudioFullPath;
	private String camStudioTitle = "CamStudio";
	private String saveAVIFileTitle = "Save AVI File";

	/**
	 * constructor
	 * 
	 * @param camStudioFullPath
	 *            the full path of CamStudio exe, you could find it under the project's third_party folder or download it.
	 */
	public CamStudioClient(String camStudioFullPath) {
		this.setCamStudioFullPath(camStudioFullPath);
	}

	/**
	 * start CamStudio exe
	 */
	public void startCamStudio() {
		try {
			Runtime.getRuntime().exec(this.camStudioFullPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * minize the CamStudio exe window
	 */
	public void minimizeWindow() {
		lib.AU3_WinWaitActive(new WString(camStudioTitle), new WString(""), 10000);
		lib.AU3_WinActive(new WString(camStudioTitle), new WString(""));
		lib.AU3_WinMinimizeAll();
	}

	/**
	 * click the record button on the CamStudio
	 */
	public void clickRecord() {
		lib.AU3_WinWaitActive(new WString(camStudioTitle), new WString(""), 10000);
		lib.AU3_WinActive(new WString(camStudioTitle), new WString(""));
		lib.AU3_Send(new WString("{F8}"), 0);
	}

	/**
	 * click the stop button on the CamStudio
	 */
	public void clickStop() {
		lib.AU3_WinWaitActive(new WString(camStudioTitle), new WString(""), 10000);
		lib.AU3_WinActive(new WString(camStudioTitle), new WString(""));
		lib.AU3_Send(new WString("{F9}"), 0);
	}

	/**
	 * save the recorded avi file
	 * 
	 * @param fileName
	 *            the avi file name
	 */
	public void saveAVIFile(String fileName) {
		lib.AU3_WinWaitActive(new WString(saveAVIFileTitle), new WString(""), 10000);
		lib.AU3_WinActive(new WString(saveAVIFileTitle), new WString(""));
		lib.AU3_ControlSend(new WString(saveAVIFileTitle), new WString(""), new WString("Edit1"), new WString(fileName), 1);
		lib.AU3_ControlClick(new WString(saveAVIFileTitle), new WString(""), new WString("[CLASS:Button; TEXT:����(&S)]"), new WString("left"), 1, AutoItX.AU3_INTDEFAULT, AutoItX.AU3_INTDEFAULT);
	}

	/**
	 * @param camStudioFullPath
	 *            the camStudioFullPath to set
	 */
	public void setCamStudioFullPath(String camStudioFullPath) {
		this.camStudioFullPath = camStudioFullPath;
	}

	/**
	 * @return the camStudioFullPath
	 */
	public String getCamStudioFullPath() {
		return camStudioFullPath;
	}

}
