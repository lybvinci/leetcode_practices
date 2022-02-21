package com.monster.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StackOfPlates {
    //98.52%

    private List<LinkedList<Integer>> mDatas;
    private int mCap;

    public StackOfPlates(int cap) {
        mCap = cap;
        mDatas = new ArrayList<>();
    }
    
    public void push(int val) {
        if (mCap <= 0) {
            return;
        }
        LinkedList<Integer> stack = null;
        if (mDatas.size() <= 0) {
           stack = new LinkedList<>(); 
           mDatas.add(stack);
        } else {
            stack = mDatas.get(mDatas.size() - 1);
        }
        if (stack.size() == mCap) {
           stack = new LinkedList<>(); 
           mDatas.add(stack);
        }
        stack.push(val);
    }
    
    public int pop() {
        if (mDatas.size() <= 0) {
            return -1;
        }
        LinkedList<Integer> stack = mDatas.get(mDatas.size() - 1);
        int ans = stack.pop();
        if (stack.size() <= 0) {
            mDatas.remove(stack);
        }
        return ans;
    }
    
    public int popAt(int index) {
        if (mDatas.size() <= index) {
            return -1;
        }
        LinkedList<Integer> stack = mDatas.get(index);
        int ans = stack.pop();
        if (stack.isEmpty()) {
            mDatas.remove(stack);
        }
        // else {
        //     for (int i = index; i < mDatas.size() - 1; i++) {
        //         LinkedList<Integer> nextStack = mDatas.get(i + 1);
        //         while(stack.size() < mCap) {
        //             stack.push(nextStack.pollFirst());
        //         }
        //         stack = nextStack;
        //         //only last stack will occur this.
        //         if (stack.size() == 0) {
        //             mDatas.remove(stack);
        //         }
        //     }
        // }
        return ans;
    } 
}
