package com.monster.learn;

import java.util.Arrays;
import java.util.HashMap;

//45.97%
public class PrisonAfterNDays {

  public int[] prisonAfterNDays(int[] cells, int N) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] temp = new int[cells.length];
    int i = 1;
    while (i <= N) {
      for (int j = 1; j < 7; j++) {
        temp[j] = cells[j-1] == cells[j+1] ? 1 : 0;
      }
      temp[0] = 0;
      temp[7] = 0;
      cells = Arrays.copyOf(temp, temp.length);
      int val = 0;
      for (int j = 0; j < 7; j++) {
        val = val * 2 + cells[j];
      }
      if (map.containsKey(val)) {
        int cycleLen = i - map.get(val);
        i += (N - i) / cycleLen * cycleLen;
      } else {
        map.put(val, i);
      }
      i++;
    }
    return cells;
  }
  
}