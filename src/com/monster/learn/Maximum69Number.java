package com.monster.learn;

public class Maximum69Number {

	//60.74%
	public int maximum69Number(int num) {
		int copy = num;
		String numStr = num + "";
		for (int i = 0; i < numStr.length(); i++) {
			if (numStr.charAt(i) == '6') {
				num -= 6 * Math.pow(10, (numStr.length() - 1 - i));
				num += 9 * Math.pow(10, (numStr.length() - 1 - i));
				return num;
			}
		}
		return copy;
	}	

	public static void main(String[] args) {
		Maximum69Number mn = new Maximum69Number();
		mn.maximum69Number(9669);
	}

}
