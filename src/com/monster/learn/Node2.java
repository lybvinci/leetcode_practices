package com.monster.learn;

public class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val,Node2 _left,Node2 _right,Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};