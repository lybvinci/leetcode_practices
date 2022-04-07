package com.monster.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NextLargerNodes {

	//5.07%
	public int[] nextLargerNodes(ListNode head) {
		if (null == head) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			ans.add(0);
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) > list.get(i)) {
					ans.remove(ans.size() - 1);
					ans.add(list.get(j));
					break;
				}
			}
		}
		return list.stream().mapToInt(i->i).toArray();
	}	

}
