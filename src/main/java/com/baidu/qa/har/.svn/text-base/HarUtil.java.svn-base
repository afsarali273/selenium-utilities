package com.baidu.qa.har;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class HarUtil {
	public static List<Map<String, String>> getHarEntriesRequestUrlParamtersMapList(Har har, String reqUrlPrefix) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			for (HarEntry entry : har.getLog().getEntries()) {
				if (entry.getRequest().getUrl().contains(reqUrlPrefix)) {
					String entryReqUrl = entry.getRequest().getUrl();
					System.out.println(entryReqUrl);
					int beginIndex = entryReqUrl.indexOf("?");
					int endIndex = entryReqUrl.length();
					String entryReqSubUrl = entryReqUrl.substring(beginIndex + 1, endIndex);
					System.out.println(entryReqSubUrl);
					String[] reqUrlParArr = entryReqSubUrl.split("&");
					for (String s : reqUrlParArr) {
						System.out.println(s);
						String[] parPair = s.split("=");
						Map<String, String> map = new HashMap<String, String>();
						if (parPair.length > 1) {
							map.put(parPair[0], parPair[1]);
						} else {
							map.put(parPair[0], "");
						}
						list.add(map);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public static Map<String, String> getHarEntriesRequestUrlParamtersMap(Har har, String reqUrlPrefix) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (HarEntry entry : har.getLog().getEntries()) {
				if (entry.getRequest().getUrl().contains(reqUrlPrefix)) {
					String entryReqUrl = entry.getRequest().getUrl();
					System.out.println(entryReqUrl);
					int beginIndex = entryReqUrl.indexOf("?");
					int endIndex = entryReqUrl.length();
					String entryReqSubUrl = entryReqUrl.substring(beginIndex + 1, endIndex);
					System.out.println(entryReqSubUrl);
					String[] reqUrlParArr = entryReqSubUrl.split("&");
					for (String s : reqUrlParArr) {
						System.out.println(s);
						String[] parPair = s.split("=");
						// Map<String, String> map = new HashMap<String,
						// String>();
						if (parPair.length > 1) {
							map.put(parPair[0], parPair[1]);
						} else {
							map.put(parPair[0], "");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	public static HarEntry findEntryByUrl(Har har, String toFind) {
		for (HarEntry entry : har.getLog().getEntries()) {
			if (entry.getRequest().getUrl().indexOf(toFind) != -1) {
				return entry;
			}
		}
		return null;
	}

	public static HarLog extractHarLog(String filePath) {
		return extractHar(filePath).getLog();
	}

	public static Har extractHar(String filePath) {
		Har har = new Har();
		try {
			InputStream harStream = new FileInputStream(filePath);
			String harBlob = IOUtils.toString(harStream, "UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			har = mapper.readValue(harBlob, Har.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return har;
	}

	public static long getFirstStartDateTime(HarLog harLog, String urlPrefix) {
		long firstStartDateTime = Long.MAX_VALUE;
		for (HarEntry entry : harLog.getEntries()) {
			if (entry.getRequest().getUrl().contains(urlPrefix)) {
				if (entry.getStartedDateTime().getTime() < firstStartDateTime) {
					firstStartDateTime = entry.getStartedDateTime().getTime();
				}
			}
		}
		return firstStartDateTime;

	}

	public static long getLastStartDateTime(HarLog harLog, String urlPrefix) {
		long lastStartDateTime = Long.MIN_VALUE;
		for (HarEntry entry : harLog.getEntries()) {
			if (entry.getRequest().getUrl().contains(urlPrefix)) {
				if (entry.getStartedDateTime().getTime() > lastStartDateTime) {
					lastStartDateTime = entry.getStartedDateTime().getTime();
				}
			}
		}
		return lastStartDateTime;
	}

	public static List<HarEntry> buildSpecificHarEntryList(HarLog harLog, String urlPrefix) {
		List<HarEntry> result = new ArrayList<HarEntry>();
		for (HarEntry entry : harLog.getEntries()) {
			if (entry.getRequest().getUrl().contains(urlPrefix)) {
				result.add(entry);
			}
		}
		return result;
	}

	public static HarEntry getSpecificEntry(HarLog harLog, String urlPrefix, int entryIndex) {
		return buildSpecificHarEntryList(harLog, urlPrefix).get(entryIndex);
	}
}
