package com.monster.learn;

//97.43%
public class RemoveKdigits {
    public static void main(String[] args) {
        RemoveKdigits rk = new RemoveKdigits();
        rk.removeKdigits("1432219", 3);
    }
    public String removeKdigits(String num, int k) {
       if (k < 0) {
           return num;
       } 
       if (num.length() == 0 || k > num.length()) {
           return "0";
       }
       int digits = num.length() - k;
       char[] stk = new char[num.length()];
       int top = 0;
       for (int i = 0; i < num.length(); i++) {
           char c = num.charAt(i);
           while (top > 0 && stk[top - 1] > c && k > 0) {
               top--;
               k--;
           }
           stk[top++] = c;
       }
       int id = 0;
       while (id < digits && stk[id] == '0') {
           id++;
       }
       if (id == digits) {
           return "0";
       } else {
           return new String(stk, id, digits - id);
       }
    }
}