package com.monster.learn;

import java.util.HashMap;

//37.57%
public class CanIWin {
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (maxChoosableInteger >= desiredTotal) return true;
    if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
    HashMap<Integer, Boolean> map = new HashMap<>();
    return canWin(maxChoosableInteger, desiredTotal, 0, map);
  }

  public boolean canWin(int length, int total, int used, HashMap<Integer, Boolean> map) {
    if (map.containsKey(used)) {
      return map.get(used);
    }
    for (int i = 0; i < length; i++) {
      int cur = (1 << i);
      if ((cur & used) == 0) {
        if (total <= i + 1 || !canWin(length, total - 1 - i, cur | used, map)) {
          map.put(used, true);
          return true;
        }
      }
    }
    map.put(used, false);
    return false;
  }
}