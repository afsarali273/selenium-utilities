package com.baidu.qa.javacsv;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csvreader.CsvReader;

/**
 * Csv file reader helper
 * 
 * @author liangxiaowu
 * 
 */
public class CsvHelper {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map<String, String>> getMapList(String filePath, boolean skipHeader) {
		List<Map<String, String>> result = null;
		try {
			CsvReader reader = new CsvReader(filePath, ',', Charset.forName("GBK"));
			result = new ArrayList();
			if (skipHeader) {
				reader.readHeaders();// skip headers
			}
			while (reader.readRecord()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put(reader.get(0), reader.get(1));
				result.add(map);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String[]> getList(String filePath, boolean skipHeader, String... strings) {
		List<String[]> result = null;
		try {
			CsvReader reader = new CsvReader(filePath, ',', Charset.forName("GBK"));
			result = new ArrayList();
			if (skipHeader) {
				reader.readHeaders();// skip headers
			}
			while (reader.readRecord()) {
				String[] arr = new String[strings.length];
				for (int i = 0; i < strings.length; i++) {
					arr[i] = reader.get(i);
				}
				result.add(arr);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
