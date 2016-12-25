package com.baidu.qa.util;

import java.util.List;

public class CollectionUtil {
	public static Object[][] toTwoDimensionArray(List<Object[]> source) {
		Object[][] result = new Object[source.size()][];

		for (int i = 0; i < source.size(); i++) {
			Object[] sourceItem = source.get(i);
			result[i] = new Object[sourceItem.length];
			for (int j = 0; j < sourceItem.length; j++) {
				result[i][j] = sourceItem[j];
			}
		}

		return result;
	}
}