package com.monster.learn;

import java.util.Stack;

//72.06%
public class Deserialize385 {

    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> sk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                sk.push(new NestedInteger());
            } else if ((ch >= '0' && ch <= '9') || ch == '-') {
                sb.append(ch);
            } else {
                if (sb.length() >= 1) {
                    int num = Integer.parseInt(sb.toString());
                    NestedInteger ni = new NestedInteger(num);
                    NestedInteger top = sk.peek();
                    top.add(ni);
                    sb.delete(0, sb.length());
                }
                if (ch == ']') {
                    NestedInteger top = sk.pop();
                    if (sk.isEmpty())
                        return top;
                    NestedInteger newtop = sk.peek();
                    newtop.add(top);
                }
            }
        }
        if (sb.length() >= 1)
            return new NestedInteger(Integer.parseInt(sb.toString()));
        return sk.peek();
    }
}