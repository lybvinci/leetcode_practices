package com.monster.learn;

import java.util.HashSet;
import java.util.Random;

//76.39%
public class Flip519 {
  private int row;
  private int col;
  private HashSet<Integer> flipped;

  public Flip519(int n_rows, int n_cols) {
    row = n_rows;
    col = n_cols;
    flipped = new HashSet<>();
  }
  
  public int[] flip() {
    Random rd = new Random();
    while (true) {
      int x = rd.nextInt(row) % row;
      int y = rd.nextInt(col) % col;
      if (!flipped.contains(x * col + y)) {
        flipped.add(x*col + y);
        return new int[]{x,y};
      }
    }
  }
  
  public void reset() {
     flipped.clear(); 
  }
}