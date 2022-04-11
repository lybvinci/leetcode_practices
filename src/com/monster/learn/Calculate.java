package com.monster.learn;

import java.util.Stack;

public class Calculate {

	//26.39%
	public int calculate(String s) {
		s = s.replaceAll(" ","");
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		char flag = '+';
		char[] array = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(array[i])) {
				num = num * 10 + array[i] - '0';
			}
			if (!Character.isDigit(array[i]) || i == s.length() - 1) {
				switch (flag) {
					case '/':
						stack.add(stack.pop() / num);
						break;
					case '*':
						stack.add(stack.pop() * num);
						break;
					case '+':
						stack.add(num);
						break;
					case '-':
						stack.add(-num);
						break;
				}
				flag = array[i];
				num = 0;
			}
		}
		int ret = 0;
		while (!stack.isEmpty()) {
			ret += stack.pop();
		}
		return ret;
	}	

	public static void main(String[] args) {
		Calculate c = new Calculate();
		c.calculate("3+ 2*2");

	}

}
