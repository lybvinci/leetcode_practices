package com.monster.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//6.20%
public class MinStack {
	private Stack<Integer> mStack;
	private ArrayList<Integer> mList;
	public MinStack() {
		mStack = new Stack<>();
		mList = new ArrayList<>();
	}
	
	public void push(int x) {
		mStack.push(x);
		mList.add(x);
		Collections.sort(mList);
	}
	
	public void pop() {
		mList.remove((Integer)mStack.pop());
		Collections.sort(mList);
	}
	
	public int top() {
		return mStack.peek();
	}
	
	public int min() {
		return mList.get(0);
	}
}
