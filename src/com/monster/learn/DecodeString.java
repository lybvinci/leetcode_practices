package com.monster.learn;

import java.util.Stack;

//99.13%
public class DecodeString {

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        ds.decodeString("3[a2[c]]");
    }

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        Stack<Integer> stackNums = new Stack<>();
        int num = 0;
        String pre = "";
        for (char c : chars) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(pre);
                stackNums.push(num);
                num = 0;
                pre = "";
            } else if (c == ']') {
                int times = stackNums.pop();
                String peekStr = stack.peek();
                for (int i = 0; i < times; i++) {
                    peekStr += pre;
                }
                stack.pop(); stack.push(peekStr);
                pre = stack.pop();
            } else {
                pre += c;
            }
        }
        return stack.isEmpty() ? pre : stack.pop();
    }
}