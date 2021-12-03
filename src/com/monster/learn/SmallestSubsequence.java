package com.monster.learn;

import java.util.Stack;

//48.37%
public class SmallestSubsequence {

    public String smallestSubsequence(String s) {
        // 获取字符串长度
        int n = s.length();
        Stack<Character> obj = new Stack<>();
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char occ = s.charAt(i);
            if (obj.contains(occ)) {
                continue;
            }
            while (!obj.empty() && occ < obj.peek() && s.indexOf(obj.peek(), i) != -1) {
                obj.pop();
            }
            obj.push(occ);
        }
        for (Character o : obj) {
            ss.append(o);
        }
        return ss.toString();
    }
}
