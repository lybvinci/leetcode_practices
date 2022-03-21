package com.monster.learn;

public class IsInterleave {
	//22.44%
	public boolean isInterleave(String s1, String s2, String s3) 
	{
			int n1 = s1.length();
			int n2 = s2.length();
			int n3 = s3.length();
			if (n1 + n2 != n3)
					return false;
			
			boolean [][] dp = new boolean [n1 + 1][n2 + 1];
			dp[0][0] = true;
			for (int i = 0; i < n1 + 1; i ++)
			{
					for (int j = 0; j < n2 + 1; j ++)
					{
							 if (0 <= i - 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
							 {
									 dp[i][j] |= dp[i - 1][j];
							 }
							 if (0 <= j - 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1))
							 {
									 dp[i][j] |= dp[i][j - 1];
							 }
					}
			}

			return dp[n1][n2];
	}

	// too slower
	public boolean isInterleave2(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		return helper(s1, 0, s2, 0, s3, "");
	}	

	private boolean helper(String s1, int s1Index, String s2, int s2Index, String s3, String tmp) {
		if (s3.equals(tmp) && s1Index == s1.length() && s2Index == s2.length()) {
			return true;
		}
		if (tmp.length() > s3.length() || s1Index > s1.length() || s2Index > s2.length()) {
			return false;
		}
    boolean ret = false;
		if (s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(tmp.length())) {
		  ret = helper(s1, s1Index + 1, s2, s2Index, s3, tmp + s1.charAt(s1Index));
		}
		if (ret) {
			return true;
		}
		if (s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(tmp.length())) {
		  ret = helper(s1, s1Index, s2, s2Index + 1, s3, tmp + s2.charAt(s2Index));
		}
		return ret;
	}

	public static void main(String[] args) {
		IsInterleave it = new IsInterleave();
		boolean ret = it.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab");
		System.out.println(ret);
	}

}
