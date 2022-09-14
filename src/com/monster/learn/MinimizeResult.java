package com.monster.learn;

public class MinimizeResult {
	//36.36%
	public String minimizeResult(String expression) {
		int rightStart = expression.indexOf("+");
		String left = expression.substring(0, rightStart);
		String right = expression.substring(rightStart + 1);
		String minS = "(" + expression + ")";
		int sum = Integer.parseInt(left) + Integer.parseInt(right);
		for (int i = 0; i < left.length(); i++) {
			for (int j = 1; j <= right.length(); j++) {
				try {
					String one = left.substring(0, i);
					String two = left.substring(i);
					if (two.isEmpty()) {
						break;
					}
					String three = right.substring(0, j);
					if (three.isEmpty()) {
						continue;
					}
					String four = right.substring(j);

					int dot = (one.isEmpty() ? 1 : Integer.parseInt(one)) * (four.isEmpty() ? 1 : Integer.parseInt(four))
					 *((two.isEmpty() ? 0 : Integer.parseInt(two)) + (three.isEmpty() ? 0 : Integer.parseInt(three)));
					if (dot < sum) {
						sum = dot;
						minS = one + "(" + two + "+" + three + ")" + four; 
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
		return minS;
	}

	public static void main(String[] args) {
		MinimizeResult mr = new MinimizeResult();
		mr.minimizeResult("5+22");
	}
}
