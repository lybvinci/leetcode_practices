package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

public class FindDifferentBinaryString {

	//78.57%
	public String findDifferentBinaryString(String[] nums) {
		List<String> list = new ArrayList<>();
		for (String s : nums) {
			list.add(s);
		}
		return make(list, new StringBuilder());
	}	

	private String make(List<String> nums, StringBuilder ret) {
		if (ret.length() == nums.size()) {
			if (nums.contains(ret.toString())) {
				return "";
			} else {
				return ret.toString();
			}
		}

		ret.append('1');
		String tmp = make(nums, ret);
		ret.deleteCharAt(ret.length() - 1);
		if (tmp.length() != nums.size()) {
			ret.append('0');
		  tmp = make(nums, ret);
		  ret.deleteCharAt(ret.length() - 1);
		}
		return tmp;
	}

	public static void main(String[] args) {
		FindDifferentBinaryString fdbs = new FindDifferentBinaryString();
		fdbs.findDifferentBinaryString(new String[]{"10", "11"});
	}
	
}
