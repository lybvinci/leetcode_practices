package com.monster.learn;

public class IsSumEqual {

	//100.00%
	public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
		long fl1 = calc(firstWord);
		long fl2 = calc(secondWord);
		long fl3 = calc(targetWord);
		return fl1 + fl2 == fl3;
	}	

	private long calc(String word) {
		long ret = 0;
		for (int i = 0; i < word.length(); i++) {
			ret = ret * 10 + word.charAt(i) - 'a';
		}
		return ret;
	}

	public static void main(String[] args) {
		IsSumEqual ise = new IsSumEqual();
		ise.isSumEqual("j", "j", "bi");
	}

}
