package com.monster.learn;

import java.util.ArrayList;
import java.util.Stack;

//77.21%
public class StockSpanner {
  private ArrayList<Integer> list;
  private Stack<int[]> num;

  public StockSpanner() {
    list = new ArrayList<Integer>();
    num = new Stack<int[]>();
  }

  public int next(int price) {
    while (!num.isEmpty() && num.peek()[0] <= price) {
      num.pop();
    }
    int res = 1;
    if (num.isEmpty()) {
      res = list.size() + 1;
    } else {
      res = list.size() - num.peek()[1];
    }
    list.add(price);
    num.push(new int[] { price, list.size() - 1 });
    return res;
  }

}