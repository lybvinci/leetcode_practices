package com.monster.learn;

//95.45%
public class PartitionDisjoint {
  public int partitionDisjoint(int[] A) {
    int index = 0, lmax = -1, rmin = 1000010;
    while (index < A.length) {
      if (lmax < A[index])
        lmax = A[index];
      if (A[index] <= rmin) {
        rmin = 1000010;
        for (int i = index + 1; i < A.length; i++)
          if (A[i] < rmin)
            rmin = A[i];
      }
      if (lmax <= rmin)
        break;
      index++;
    }
    return index + 1;
  } 

  public static void main(String[] args) {
    PartitionDisjoint pd = new PartitionDisjoint();
    pd.partitionDisjoint(new int[]{32,57,24,19,0,24,49,67,87,87});
  }
}