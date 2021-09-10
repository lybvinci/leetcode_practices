package com.monster.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberWays {
	//32.58%
	static double MOD = 1e9 + 7;
	public int numberWays(List<List<Integer>> hats) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < hats.size(); i++) {
			for (int j = 0; j < hats.get(i).size(); j++) {
				List<Integer> list = map.get(hats.get(i).get(j));
				if (null == list) {
					list = new ArrayList<>();
				}
				list.add(i);
				map.put(hats.get(i).get(j), list);
			}
		}
		long[][] dp = new long[41][1 << hats.size()];
		dp[0][0] = 1;
		for (int i = 1; i < 41; i++) {
			for (int j = 0; j < 1 << hats.size(); j++) {
				dp[i][j] = dp[i-1][j];
				if (map.get(i) == null) {
					continue;
				}
				for (int k : map.get(i)) {
					if ((j & 1 << k) != 0) {
						dp[i][j] += dp[i-1][j^(1<<k)];
					}
				}
			}
		}
		return (int)(dp[40][dp[40].length - 1] % MOD);
	}	

}
