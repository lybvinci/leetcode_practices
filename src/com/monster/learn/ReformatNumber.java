package com.monster.learn;

public class ReformatNumber {

	//37.37%
	public String reformatNumber(String number) {
    number = number.replaceAll(" ", "");
		number = number.replaceAll("-", "");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number.length();) {
			if (number.length() - i <= 4) {
				if (number.length() - i == 4) {
					sb.append(number.substring(i, i + 2));
				  sb.append("-");
					sb.append(number.substring(i + 2, i + 4));
				} else {
					sb.append(number.substring(i, number.length()));
				}
				break;
			} else {
				sb.append(number.substring(i, i + 3));
				i += 3;
				sb.append("-");
			}
		}
		return sb.toString();
	}	

	public static void main(String[] args) {
		ReformatNumber rn = new ReformatNumber();
		rn.reformatNumber("123 4-567");
	}

}
