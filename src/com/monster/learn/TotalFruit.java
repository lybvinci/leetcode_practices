package com.monster.learn;

import java.util.HashMap;
import java.util.Iterator;

//42.88%
public class TotalFruit {
  public int totalFruit(int[] tree) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int ans = 0;
    int cur = 0;
    for (int i = 0; i < tree.length; i++) {
      int f = tree[i];
      if (!map.containsKey(f)) {
        if (map.size() == 2) {
          Iterator<Integer> keys = map.keySet().iterator();
          int key1 = keys.next();
          int key2 = keys.next();
          if (map.get(key1) > map.get(key2)) {
            cur = i - map.get(key2) - 1;
            map.remove(key2);
          } else {
            cur = i - map.get(key1) - 1;
            map.remove(key1);
          }
        }
      }
      map.put(f, i);
      ans = Math.max(++cur, ans);
    }
    return ans;
  } 

  public static void main(String[] args) {
    TotalFruit tf = new TotalFruit();
    tf.totalFruit(new int[]{1,2,1});
  }
}