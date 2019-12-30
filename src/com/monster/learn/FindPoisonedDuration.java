package com.monster.learn;

//100.00%
public class FindPoisonedDuration {

  public static void main(String[] args) {
    FindPoisonedDuration fpd = new FindPoisonedDuration();
    fpd.findPoisonedDuration(new int[]{1,2,3,4,5,6,7,8,9}, 1);
  }


  public int findPoisonedDuration(int[] timeSeries, int duration) {
    if (timeSeries.length < 1) {
      return 0;
    }
    int sum = 0;
    int lastTime = timeSeries[0];
    for (int i = 1; i < timeSeries.length; i++) {
      if (timeSeries[i] >= (lastTime + duration)) {
        sum += duration;
      } else {
        sum += timeSeries[i] - lastTime;
      }
      lastTime = timeSeries[i];
    }
    sum += duration;
    return sum;
  }
}