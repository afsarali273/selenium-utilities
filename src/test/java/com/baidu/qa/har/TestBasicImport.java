package com.baidu.qa.har;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.RuntimeException;

import org.codehaus.jackson.map.ObjectMapper;

import org.apache.commons.io.IOUtils;

import org.junit.*;


import static org.junit.Assert.*;

/**
 * Test the basic importing of HAR as json. No attempt at completeness is made
 * here.
 */
public class TestBasicImport {
	private String harBlob;
	private final ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws IOException {
		// String filePath =
		// "E:\\jars\\cburroughs-browsermob-proxy-9b94ca1\\cburroughs-browsermob-proxy-9b94ca1\\src\\test\\resources\\org\\browsermob\\core\\har\\ysearch.har";
		String filePath = "e:\\temp\\test.har";
		InputStream harStream = new FileInputStream(filePath);
		// InputStream harStream = new
		// InputStream("E:\\jars\\cburroughs-browsermob-proxy-9b94ca1\\cburroughs-browsermob-proxy-9b94ca1\\src\\test\\resources\\org\\browsermob\\core\\har\\ysearch.har");
		harBlob = IOUtils.toString(harStream, "UTF-8");
	}

	private HarLog extractHarLog() {
		try {
			Har har = mapper.readValue(harBlob, Har.class);
			return har.getLog();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void browser() {
		HarLog ysearch = extractHarLog();
		String harBrowser = ysearch.getBrowser().getName();
		assertEquals("browser name", "Firefox", harBrowser);
	}

	@Test
	public void aa() {
		HarLog ysearch = extractHarLog();
		String urlPrefix = "http://fctest.baidu.com:8000/nirvana/request.ajax";
		for (HarPage page : ysearch.getPages()) {
			System.out.println(page.getId() + " " + page.getTitle());
		}
		long firstStartTime = Long.MAX_VALUE;
		long lastStartTime = Long.MIN_VALUE;
		for (HarEntry entry : ysearch.getEntries()) {
			if (entry.getRequest().getUrl().contains(urlPrefix)) {
				if (entry.getStartedDateTime().getTime() < firstStartTime) {
					firstStartTime = entry.getStartedDateTime().getTime();
				}

				if (entry.getStartedDateTime().getTime() > lastStartTime) {
					lastStartTime = entry.getStartedDateTime().getTime();
				}
				System.out.println(entry.getRequest().getUrl());
				System.out.println(entry.getTime());
				System.out.println(entry.getTimings().toString());
			}
		}

		System.out.println(lastStartTime - firstStartTime);
		// String aa= ysearch.getEntries()
	}

	@Test
	public void testHttpWatchExportHarLog() {
		String harFileName = "1234";
		HarLog harLog = extractHarLog();
		String urlPrefix = "http://fctest.baidu.com:8000/nirvana/request.ajax";
		long firstStartDateTime = HarUtil.getFirstStartDateTime(harLog, urlPrefix);
		long lastStartDateTime = HarUtil.getLastStartDateTime(harLog, urlPrefix);
		long lastEspanTime = HarUtil.getSpecificEntry(harLog, urlPrefix, HarUtil.buildSpecificHarEntryList(harLog, urlPrefix).size() - 1).getTime();
		long result = lastStartDateTime + lastEspanTime - firstStartDateTime;
		System.out.println(result);
	}
}