package com.monster.learn;


//37.17%
public class RLEIterator {
  private int[] A;
  private int curIndex;
  public RLEIterator(int[] A) {
    this.A = A;
    curIndex = 0;
  }
  
  public int next(int n) {
    if (curIndex >= A.length) {
      return -1;
    }
    while ((n - A[curIndex]) > 0){
      n = n - A[curIndex];
      curIndex += 2;
      if (curIndex >= A.length) {
        return -1;
      }
    }
    if (n > 0) {
      A[curIndex] -= n;
    }
    return A[curIndex+1];
  }

  public static void main(String[] args) {
    RLEIterator rlei = new RLEIterator(new int[]{3,8,0,9,2,5}) ; 
    rlei.next(2);
    rlei.next(1);
    rlei.next(1);
    rlei.next(2);
  }
}