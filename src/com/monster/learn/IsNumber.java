package com.monster.learn;

import java.util.Stack;

public class IsNumber {

    //56.69%
    public boolean isNumber(String s) {
        if (null == s) {
            return false;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char firstChar = s.charAt(0);
        if ((firstChar >= 'a' && firstChar <= 'z') || (firstChar >= 'A' && firstChar <= 'Z')) {
            return false;
        }
        stack.push(firstChar);
        boolean hasD = false;
        boolean hasE = false;
        boolean hasSign = false;
        if (firstChar == '.') {
            hasD = true;
        } else if (firstChar == 'E' || firstChar == 'e') {
            hasE = true;
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                return false;
            } else if (c == '+' || c == '-') {
                if (hasE && !hasSign) {
                   hasSign = true;
                   stack.push(c);
                } else {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                stack.push(c);
            } else if (c == 'e' || c == 'E') {
                if (hasE) {
                    return false;
                } else {
                    hasE = true;
                    if (stack.peek() == '.') {
                        if (stack.size() < 2) {
                            return false;
                        }
                    } else if (stack.peek() == '+' || stack.peek() == '-') {
                        return false;
                    }
                    stack.push(c);
                }
            } else if (c == '.') {
                if (hasD || hasE) {
                    return false;
                } else {
                    hasD = true;
                    stack.push(c);
                }
            } else {
                return false;
            }
            
        }
        if (stack.peek() == '+' || stack.peek() == '-' ||
                stack.peek() == 'e' || stack.peek() == 'E') {
            return false;
        }
        if (stack.peek() == '.') {
            if (stack.size() < 2) {
                return false;
            }
            stack.pop();
            if (stack.peek() >= '0' && stack.peek() <= '9') {
                return true;
            } else {
                return false;
            }
        }
        return true;
    } 

    public static void main(String[] args) {
        IsNumber in = new IsNumber();
        in.isNumber("..2");
    }
}
