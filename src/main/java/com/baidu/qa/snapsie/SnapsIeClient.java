package com.baidu.qa.snapsie;

import com.baidu.qa.util.FileUtil;

/**
 * Use the open source tool - SnapsIe to capture full browser image, because sometimes website's contents over-show in the browser while selenium webdriver cannot get the full image of all contents.
 * 
 * @author liangxiaowu
 * 
 */

public class SnapsIeClient {
	private static final String snapsIEJs = "/**" 
			+ "\n* This file wraps the Snapsie ActiveX object, exposing a single saveSnapshot()" 
			+ "\n* method on a singleton object." 
			+ "\n*" 
			+ "\n* See http://snapsie.sourceforge.net/" 
			+ "\n*/"
			+ "\nif (!Snapsie) // create the Snapsie singleton?"
			+ "\nvar Snapsie = new function() {"
			+ "\n   // private fields"
			+ "\n var nativeObj;"
			+ "\n// private methods"
			+ "\nfunction init() {" 
			+ "\n  try {"
			+ "\n    nativeObj = new ActiveXObject('Snapsie.CoSnapsie');"
			+ "\n}"
			+ "\ncatch (e) {"
			+ "\n  showException(e);"
			+ "\n}"
			+ "\n}"
			+ "\nfunction showException(e) {" 
			+ "\n throw e;" 
			+ "\n//alert(e + ', ' + (e.message ? e.message : \"\"));" 
			+ "\n}"
			+ "\n function isQuirksMode(inDocument) {"
			+ "\n   return (inDocument.compatMode == 'BackCompat');"
			+ "\n}"
			+ "\nfunction getDrawableElement(inDocument) {"
			+ "\n  if (isQuirksMode(inDocument)) {"
			+ "\n   return inDocument.getElementsByTagName('body')[0];"
			+ "\n}" 
			+ "\nelse {" 
			+ "\n  // standards mode"
			+ "\nreturn inDocument.documentElement;" + "}" 
			+ "\n}"
			+ "\n/**"
			+ "\n* Returns the canonical Windows path for a given path. This means" 
			+ "\n* basically replacing any forwards slashes with backslashes."
			+ "\n*"
			+ "\n* @param path  the path whose canonical form to return" 
			+ "\n*/" 
			+ "\nfunction getCanonicalPath(path) {"
			+ "\n  path = path.replace(/\\//g, '\\\\');" 
			+ "\npath = path.replace(/\\\\\\\\/g, '\\\\');" 
			+ "\nreturn path;" 
			+ "\n}"
			+ "\n// public methods"
			+ "\n/**" 
			+ "\n* Saves a screenshot of the current document to a file. If frameId is" 
			+ "\n* specified, a screenshot of just the frame is captured instead."
			+ "\n*"
			+ "\n* @param outputFile  the file to which to save the screenshot" 
			+ "\n* @param frameId     the frame to capture; omit to capture entire document"
			+ "\n*/" 
			+ "\nthis.saveSnapshot = function(outputFile, frameId) {" 
			+ "\n  if (!nativeObj) {"
			+ "\n    var e = new Exception('Snapsie was not properly initialized');" 
			+ "\n  showException(e);"
			+ "\nreturn;"
			+ "\n}"
			+ "\nvar drawableElement = getDrawableElement(document);"
			+ "\nvar drawableInfo = {"
			+ "\n    overflow  : drawableElement.style.overflow" 
			+ "\n, scrollLeft: drawableElement.scrollLeft"
			+ "\n, scrollTop : drawableElement.scrollTop" 
			+ "\n};" 
			+ "\ndrawableElement.style.overflow = 'hidden';"
			+ "\nvar capturableDocument;" 
			+ "\nvar frameBCR = { left: 0, top: 0 };"
			+ "\nif (arguments.length == 1) {" 
			+ "\n  capturableDocument = document;" 
			+ "\n}" 
			+ "\nelse {" 
			+ "\n  var frame = document.getElementById(frameId);"
			+ "\ncapturableDocument = frame.document;"
			+ "\n// scroll as much of the frame into view as possible"
			+ "\nframeBCR = frame.getBoundingClientRect();"
			+ "\nwindow.scroll(frameBCR.left, frameBCR.top);" 
			+ "\nframeBCR = frame.getBoundingClientRect();" 
			+ "\n}"
			+ "\ntry {" 
			+ "\n  nativeObj.saveSnapshot("
			+ "\n    getCanonicalPath(outputFile),"
			+ "\n  frameId," 
			+ "\ndrawableElement.scrollWidth,"
			+ "\ndrawableElement.scrollHeight," 
			+ "\ndrawableElement.clientWidth," 
			+ "\ndrawableElement.clientHeight,"
			+ "\ndrawableElement.clientLeft," 
			+ "\ndrawableElement.clientTop,"
			+ "\nframeBCR.left," 
			+ "\nframeBCR.top" 
			+ "\n);" 
			+ "\n}" 
			+ "\ncatch (e) {" 
			+ "\n  showException(e);" 
			+ "\n}"
			+ "\n// revert"
			+ "\ndrawableElement.style.overflow = drawableInfo.overflow;"
			+ "\ndrawableElement.scrollLeft = drawableInfo.scrollLeft;" 
			+ "\ndrawableElement.scrollTop = drawableInfo.scrollTop;"
			+ "\n}"
			+ "\n// initializers"
			+ "\ninit();"
			+ "\n};";
	
	/**
	 * 
	 * @param outputFile
	 *            "'C:/a.png'"
	 * @return
	 */
	public static String getSaveSnapshotJs(String outputFile) {
		return FileUtil.readFile("resource\\snapsie.js") + "Snapsie.saveSnapshot(" + outputFile + ");";
	}
	
	/**
	 * 
	 * @param outputFile "C:/a.png"
	 * @return
	 */
	public static String getSaveSnapshotJs2(String outputFile){
		String script = snapsIEJs+"\nSnapsie.saveSnapshot("+outputFile+");";
		return script;
	}
}
