package com.monster.learn;

public class DeleteNode {

	//100.00%
	public void deleteNode(ListNode node) {
		node.val=node.next.val;
		node.next=node.next.next;
	}
}
