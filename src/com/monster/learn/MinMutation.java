package com.monster.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//85.94%
public class MinMutation {
  public int minMutation(String start, String end, String[] bank) {
    if (bank == null || bank.length == 0)
      return -1;
    char[] gen = { 'A', 'C', 'G', 'T' };
    HashSet<String> bankSet = new HashSet<>();
    for (String s : bank)
      bankSet.add(s);
    Queue<String> q = new LinkedList<>();
    HashMap<String, Integer> res = new HashMap<>();
    res.put(start, 0);
    q.add(start);
    while (!q.isEmpty()) {
      String s = q.poll();
      bankSet.remove(s);
      for (int i = 0; i < s.length(); i++) {
        char[] next = s.toCharArray();
        for (char c : gen) {
          next[i] = c;
          String nextS = new String(next);
          if (bankSet.contains(nextS)) {
            res.put(nextS, res.get(s) + 1);
            if (nextS.equals(end))
              return res.get(nextS);
            q.add(nextS);
          }
        }
      }
    }
    return -1;
  }
}