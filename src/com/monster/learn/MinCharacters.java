package com.monster.learn;

public class MinCharacters {

	// 63.64%
	public int f1(String a, String b) {
		int[] c1 = new int[26];
		int[] c2 = new int[26];
		for (int i = 0; i < a.length(); i++) {
			c1[a.charAt(i) - 'a']++;
		}
		for (int i = 0; i < b.length(); i++) {
			c2[b.charAt(i) - 'a']++;
		}
		int ans1 = a.length() - c1[0] + c2[0];
		int ans2 = b.length() + c1[0] - c2[0];
		int ans = a.length() + b.length();
		ans = Math.min(ans, a.length() + b.length() - c1[0] - c2[0]);
		for (int i = 1; i < 26; i++) {
			ans = Math.min(ans, ans1);
			ans = Math.min(ans, ans2);
			ans = Math.min(ans, a.length() + b.length() - c1[i] - c2[i]);
			ans1 = ans1 - c1[i] + c2[i];
			ans2 = ans2 + c1[i] - c2[i];
		}
		return ans;
	}
	
}
