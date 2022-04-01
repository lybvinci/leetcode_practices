package com.monster.learn;

import java.util.HashMap;
import java.util.Map;

public class GetFolderNames {

	//19.79%
	public String[] getFolderNames(String[] names) {
		if (names.length <= 0) {
			return new String[names.length];
		}
		Map<String,Integer> map = new HashMap<>();
		String[] ret = new String[names.length];
		int i = 0;
		for (String name : names) {
			if (!map.containsKey(name)) {
				ret[i++] = name;
				map.put(name, 1);
			} else {
				int count = map.get(name);
				while (map.containsKey(names[i] + "(" + count + ")")) {
					count++;
				}
				map.put(names[i] + "(" + count + ")", 1);
				map.put(names[i], map.get(names[i]) + 1);
				// 本次的结果
				ret[i] = names[i] + "(" + count + ")";
				i++;
			}
		}
		return ret;
	}

}
