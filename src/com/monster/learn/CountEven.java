package com.monster.learn;

public class CountEven {

	//100.00%
	public int countEven(int num) {
		if(((num/1000)+(num/100)+(num/10)+num)%2!=0){num-=1;}//这段条件就相当于把各个位数相加判断是否是奇数
		return num/2;
	}	

}
