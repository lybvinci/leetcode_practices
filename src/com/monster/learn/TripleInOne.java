package com.monster.learn;

//100.00%
public class TripleInOne {
	private int[] ret;
	private int[] index;
	public TripleInOne(int stackSize) {
		ret = new int[stackSize * 3];
		index = new int[]{0 - 1, stackSize * 1 - 1, stackSize * 2 - 1};
	}
	
	public void push(int stackNum, int value) {
		if (stackNum < 0 || stackNum > 2) {
			return;
		}
		if (index[stackNum] >= (stackNum + 1) * ret.length / 3 - 1) {
			return;
		}
		index[stackNum]++;
		ret[index[stackNum]] = value;
	}
	
	public int pop(int stackNum) {
		if (stackNum < 0 || stackNum > 2) {
			return -1;
		}
		if (index[stackNum] < stackNum * ret.length / 3) {
			return -1;
		}
		index[stackNum]--;
		return ret[index[stackNum]+1];
	}
	
	public int peek(int stackNum) {
		if (stackNum < 0 || stackNum > 2) {
			return -1;
		}
		if (index[stackNum] < stackNum * ret.length / 3) {
			return -1;
		}
		return ret[index[stackNum]];
	}
	
	public boolean isEmpty(int stackNum) {
		if (stackNum < 0 || stackNum > 2) {
			return true;
		}
		if (index[stackNum] < stackNum * ret.length / 3) {
			return true;
		}
		return false;
	}	

	public static void main(String[] args) {
		TripleInOne ti = new TripleInOne(2);
		ti.push(0, 1);
		ti.push(0, 2);
		ti.push(0, 3);
		ti.pop(0);
	}
}
