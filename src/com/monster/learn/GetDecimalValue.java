package com.monster.learn;

public class GetDecimalValue {

	//100.00%
	public int getDecimalValue(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val);
			head = head.next;
		}
		return Integer.parseInt(sb.toString(), 2);
	}	

}
