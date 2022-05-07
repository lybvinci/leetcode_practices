package com.monster.learn;

import java.util.LinkedList;

public class CustomStack {
	//5.66%

	private int mMaxSize;
	private LinkedList<Integer> mStack;
	public CustomStack(int maxSize) {
		mMaxSize = maxSize;
		mStack = new LinkedList<>();
	}
	
	public void push(int x) {
		if (mStack.size() >= mMaxSize) {
			return;
		} else {
			mStack.push(x);
		}
	}
	
	public int pop() {
		if (mStack.isEmpty()) {
			return -1;
		} else {
			return mStack.pop();
		}
	}
	
	public void increment(int k, int val) {
		for (int i = mStack.size() - 1; mStack.size() - i <= k && i >= 0; i--) {
			mStack.set(i, mStack.get(i) + val);
		}
	}

	public static void main(String[] args) {
		CustomStack cs = new CustomStack(3);
		cs.push(1);
		cs.push(2);
		cs.pop();
		cs.push(2);
		cs.push(3);
		cs.push(4);
		cs.increment(5, 100);
		cs.increment(2, 100);
		cs.pop();
		cs.pop();
		cs.pop();
		cs.pop();
	}
}
