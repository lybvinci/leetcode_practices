package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatLimitedString {
	//54.76%
	public String repeatLimitedString(String s, int repeatLimit) {
		//str用来记录字符串s每个字母出现的次数
		int[] str = new int[26];
		for (int i = 0;i < s.length();i ++) {
			str[s.charAt(i) - 'a'] ++;
		}
	//用来记录for循环遍历开始的位置
		int temp = 25;
	//nums用来记录字母的连续次数(这里可以优化,一个整型就可以解决问题)
		int[] nums = new int[26];
	//使用StringBuilder对字符串进行操作效率更高(我记得是)
		StringBuilder sb = new StringBuilder();
		while (temp >= 0) {
		//这里while套for纯脱裤子放屁了。for循环末尾有个break！
			for (int i = temp;i >= 0;i --) {
			//所有字母都用完了
				if (i == 0 && str[i] == 0) {
					temp = -1;
					break;
				}
							//避免重复循环无意义区域
				if (str[i] == 0) {//这里就是 如果
					temp --;
					continue;
				}
			//在末尾添加字符串
				sb.append((char)(i + 'a'));
			//连续字母个数+1
				nums[i] ++;
			//当前字母剩余可用个数-1
				str[i] --;
							//达到设定的次数，并且此字符还有没插入字符串的（有剩余）
				if (nums[i] == repeatLimit && str[i] > 0) {
				//没有能插入的字母了，因为没有比a字典序更小的了
					if (i == 0) {
						temp = -2;
						break;
					}
				//寻找比i较小的下标（较小的字典序）
					for (int j = i - 1;j >= 0;j --) {
					//没有剩余字母了（a-z都没有剩余了）
						if (j == 0 && str[j] == 0) {
							temp = -1;
							break;
						}
					//确保当前字母有剩余(我们总不能插入一个没出现过的字母，或者用完了的字母吧)
						if (str[j] != 0) {
							sb.append((char)(j + 'a'));
							nums[i] = 0;
							str[j] --;
							break;
						}
					}
				}
				break;
			}
		}
		return sb.toString();
	}

}
